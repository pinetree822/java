package _javaChat1;
import java.awt.*;  
import java.awt.TrayIcon.MessageType;  
import java.awt.event.*;  
import java.io.*;  
import java.net.*;  
import java.util.*;  
import java.util.prefs.Preferences;    
import javax.annotation.Resource;
import javax.swing.*;  
import javax.swing.border.*;  
import javax.swing.tree.*;  
  
  
public class EQ extends JDialog{  
    private JTextField ipEndTField;  
    private JTextField ipStartTField;  
    private JTextField userNameTField;//��??   
    private JPasswordField passwordTField;//��??   
    private JTextField placardPathTField;//placard:��ͱ   
    private JTextField updatePathTField;//������?   
    private JTextField pubPathTField;  
    public static EQ frame = null;  
    private ChatTree chatTree;  
    private JPopupMenu popupMenu;//��?��?   
    private JTabbedPane tabbedPane;//��?����   
    private JToggleButton searchUserButton;//�����?��?   
    private JProgressBar progressBar;//???   
    private JList faceList;  
    private JButton selectInterfaceOKButton;  
    private DatagramSocket ss;//?��??�   
    private final JLabel stateLabel;  
    private static String user_dir;  
    private static File localFile;  
    private static File netFile;  
    private String netFilePath;  
    private JButton messageAlertButton;  
    private Stack<String> messageStack;////Stack ?������?���LIFO����?����?��   
    private ImageIcon messageAlertIcon;  
    private ImageIcon messageAlertNullIcon;  
    private Rectangle location;  
    public static TrayIcon trayicon;  
    private Dao dao;  
    //Preferences.systeRoot:����ͧ?������???��   Preferences:????   
    public final static Preferences preferences = Preferences.systemRoot();  
    private JButton userInfoButton;  
    //----------------------------------------------------------------------------------   
    public static void main(String[] args){  
        try{  
            String laf = preferences.get("lookAndFeel", "java��?");  
            if(laf.indexOf("?��ͧ?") > -1){  
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
            }  
            EQ frame = new EQ();  
            frame.setVisible(true);  
            frame.SystemTrayInitial();// �����ͧ??   
            frame.server();  
            frame.checkPlacard();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
    //----------------------------------------------------------------------------------   
    public EQ(){  
        super(new JFrame());  
        frame = this;  
        dao = Dao.getDao();  
        location = dao.getLocation();  
        setTitle("EQ����");  
        setBounds(location);  
        progressBar = new JProgressBar();  
        //BevelBorder:??????��??����??��Bevel:����     lowered:��������?����   
        progressBar.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        tabbedPane = new JTabbedPane();  
        popupMenu = new JPopupMenu();  
        chatTree = new ChatTree(this);  
        user_dir = System.getProperty("user.dir");// ����?����?����ͧ?����   
        localFile = new File(user_dir + File.separator + "EQ.jar");// ���EQ����   
        stateLabel = new JLabel();// ?????   
        this.addWindowListener(new FrameWindowListener());// ��ʥ????��   
        this.addComponentListener(new ComponentAdapter(){  
            public void componentResized(final ComponentEvent e){  
                saveLocation();  
            }  
            public void componentMoved(final ComponentEvent e){  
                saveLocation();  
            }  
        });  
        try{// ??��?��?ӮϢ   
            ss = new DatagramSocket(1111);  
        }catch(SocketException e2){  
            if(e2.getMessage().startsWith("Address already in use")){  
                showMessageDialog("��?ӮϢ�����,�����?���??����");  
            }  
            System.exit(0);  
        }  
        {// ���������������?   
            messageAlertIcon = new ImageIcon(EQ.class.getResource("/image/messageAlert.gif"));  
            messageAlertNullIcon = new ImageIcon(EQ.class.getResource("/image/messageAlertNull20.gif"));  
            messageStack = new Stack<String>();  
            messageAlertButton = new JButton();  
            messageAlertButton.setHorizontalAlignment(SwingConstants.RIGHT);  
            messageAlertButton.setContentAreaFilled(false);//��?��?�?�   
            final JPanel BannerPanel = new JPanel();  
            BannerPanel.setLayout(new BorderLayout());  
            this.add(BannerPanel,BorderLayout.NORTH);  
            userInfoButton = new JButton();  
            BannerPanel.add(userInfoButton,BorderLayout.WEST);  
            userInfoButton.setMargin(new Insets(0,0,0,10));//Margin:?��    insets:?��    
            initUserInfoButton();// ����������??����?   
            BannerPanel.add(messageAlertButton,BorderLayout.CENTER);  
            messageAlertButton.addActionListener(new ActionListener(){  
  
                @Override  
                public void actionPerformed(ActionEvent arg0) {  
                    if(!messageStack.empty()){  
                        showMessageDialog(messageStack.pop());//��??ݻ��?�ڣ�Vector ?������������?����    
                    }  
                }  
            });  
            messageAlertButton.setIcon(messageAlertIcon);  
            showMessageBar();  
        }  
        this.add(tabbedPane,BorderLayout.CENTER);  
        tabbedPane.setTabPlacement(SwingConstants.LEFT);//?���????̫��???����   
        ImageIcon userTicon = new ImageIcon(EQ.class.getResource("/image/tabIcon/tabLeft.PNG"));  
        tabbedPane.addTab(null,userTicon,createUserList(),"��?֪��");  
        ImageIcon sysOTicon = new ImageIcon(EQ.class.getResource("/image/tabIcon/tabLeft2.PNG"));  
        tabbedPane.addTab(null, sysOTicon, createSysToolPanel(), "ͧ?����");  
        ImageIcon sysSTicon = new ImageIcon(EQ.class.getResource("/image/tabIcon/tabLeft3.png"));  
        tabbedPane.addTab(null, sysSTicon, createSysSetPanel(), "ͧ??��");  
        this.setAlwaysOnTop(true);//?�?ݻ   
    }  
    //----------------------------------------------------------------------------------   
    private JScrollPane createSysSetPanel(){//ͧ??������   
        final JPanel sysSetPanel = new JPanel();  
        JScrollPane scrollPane = new JScrollPane(sysSetPanel);  
        sysSetPanel.setLayout(new BoxLayout(sysSetPanel,BoxLayout.Y_AXIS));  
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));  
        final JPanel sysPathPanel = new JPanel();  
        sysPathPanel.setMaximumSize(new Dimension(600,200));  
        sysPathPanel.setBorder(new TitledBorder("ͧ?��?"));//title - ????����??   
        sysPathPanel.setLayout(new GridLayout(0,1));  
        sysSetPanel.add(sysPathPanel);  
        sysPathPanel.add(new JLabel("�����?��?"));  
        updatePathTField = new JTextField(preferences.get("updatePath", "??����?"));  
        sysPathPanel.add(updatePathTField);  
        sysPathPanel.add(new JLabel("ͧ?��ͱ��?��"));  
        placardPathTField = new JTextField(preferences.get("placardPath","??����?"));  
        sysPathPanel.add(placardPathTField);  
        sysPathPanel.add(new JLabel("����������?��"));  
        pubPathTField = new JTextField(preferences.get("pubPath", "??����?"));  
        sysPathPanel.add(pubPathTField);  
        final JButton pathOKButton = new JButton("?��");  
        pathOKButton.setActionCommand("sysOK");  
        pathOKButton.addActionListener(new SysSetPanelOKListener());  
        sysSetPanel.add(pathOKButton);  
        final JPanel loginPanel = new JPanel();  
        loginPanel.setMaximumSize(new Dimension(600, 90));  
        loginPanel.setBorder(new TitledBorder("��?�?��?��"));  
        final GridLayout gridLayout_1 = new GridLayout(0, 1);  
        gridLayout_1.setVgap(5);  
        loginPanel.setLayout(gridLayout_1);  
        sysSetPanel.add(loginPanel);  
        final JPanel panel_7 = new JPanel();  
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));  
        loginPanel.add(panel_7);  
        panel_7.add(new JLabel("��?٣��"));  
        userNameTField = new JTextField(preferences.get("username", "??����?٣"));  
        panel_7.add(userNameTField);  
        final JPanel panel_8 = new JPanel();  
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));  
        loginPanel.add(panel_8);  
        panel_8.add(new JLabel("�ˡ�?��"));  
        passwordTField = new JPasswordField("*****");  
        panel_8.add(passwordTField);  
        final JButton loginOKButton = new JButton("?��");  
        sysSetPanel.add(loginOKButton);  
        loginOKButton.setActionCommand("loginOK");  
        loginOKButton.addActionListener(new SysSetPanelOKListener());  
        final JPanel ipPanel = new JPanel();  
        final GridLayout gridLayout_2 = new GridLayout(0, 1);  
        gridLayout_2.setVgap(5);  
        ipPanel.setLayout(gridLayout_2);  
        ipPanel.setMaximumSize(new Dimension(600, 90));  
        ipPanel.setBorder(new TitledBorder("IP�����?"));  
        sysSetPanel.add(ipPanel);  
        final JPanel panel_5 = new JPanel();  
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));  
        ipPanel.add(panel_5);  
        panel_5.add(new JLabel("���IP��"));  
        ipStartTField = new JTextField(preferences.get("ipStart", "192.168.0.1"));  
        panel_5.add(ipStartTField);  
        final JPanel panel_6 = new JPanel();  
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));  
        ipPanel.add(panel_6);  
        panel_6.add(new JLabel("?�IP��"));  
        ipEndTField = new JTextField(preferences.get("ipEnd", "192.168.1.255"));  
        panel_6.add(ipEndTField);  
        final JButton ipOKButton = new JButton("?��");  
        ipOKButton.setActionCommand("ipOK");  
        ipOKButton.addActionListener(new SysSetPanelOKListener());  
        sysSetPanel.add(ipOKButton);  
        return scrollPane;  
    }  
    //----------------------------------------------------------------------------------   
    private JScrollPane createUserList(){// ��?֪������   
        JScrollPane scrollPane = new JScrollPane();  
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);  
        addUserPopup(chatTree,getPopupMenu());// ?��?��ʥ?����?   
        scrollPane.setViewportView(chatTree);  
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));  
        chatTree.addMouseListener(new ChatTreeMouseListener());  
          
        return scrollPane;  
    }  
    //----------------------------------------------------------------------------------   
    private JScrollPane createSysToolPanel() {// ͧ?��������   
        JPanel sysToolPanel = new JPanel(); // ͧ?��������   
        sysToolPanel.setLayout(new BorderLayout());  
        JScrollPane sysToolScrollPanel = new JScrollPane();  
        sysToolScrollPanel  
                .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);  
        sysToolScrollPanel.setBorder(new EmptyBorder(0, 0, 0, 0));  
        sysToolScrollPanel.setViewportView(sysToolPanel);  
        sysToolPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        JPanel interfacePanel = new JPanel();  
        sysToolPanel.add(interfacePanel, BorderLayout.NORTH);  
        interfacePanel.setLayout(new BorderLayout());  
        interfacePanel.setBorder(new TitledBorder("ͣ��??-��??����"));  
        faceList = new JList(new String[]{"?��ͧ?", "java��?"});  
        interfacePanel.add(faceList);  
        faceList.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        final JPanel interfaceSubPanel = new JPanel();  
        interfaceSubPanel.setLayout(new FlowLayout());  
        interfacePanel.add(interfaceSubPanel, BorderLayout.SOUTH);  
        selectInterfaceOKButton = new JButton("?��");  
        selectInterfaceOKButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                preferences.put("lookAndFeel", faceList.getSelectedValue().toString());  
                JOptionPane.showMessageDialog(EQ.this, "����?����?��������");  
            }  
        });  
        interfaceSubPanel.add(selectInterfaceOKButton);  
  
        JPanel searchUserPanel = new JPanel(); // ��?�������   
        sysToolPanel.add(searchUserPanel);  
        searchUserPanel.setLayout(new BorderLayout());  
        final JPanel searchControlPanel = new JPanel();  
        searchControlPanel.setLayout(new GridLayout(0, 1));  
        searchUserPanel.add(searchControlPanel, BorderLayout.SOUTH);  
        final JList searchUserList = new JList(new String[]{"??��?֪��"});// ����ʥ��?֪��   
        final JScrollPane scrollPane_2 = new JScrollPane(searchUserList);  
        scrollPane_2.setDoubleBuffered(true);  
        searchUserPanel.add(scrollPane_2);  
        searchUserList.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        searchUserButton = new JToggleButton();  
        searchUserButton.setText("�������?");  
        searchUserButton.addActionListener(new SearchUserActionListener(searchUserList));  
        searchControlPanel.add(progressBar);  
        searchControlPanel.add(searchUserButton);  
        searchUserPanel.setBorder(new TitledBorder("�����?"));  
  
        final JPanel sysUpdatePanel = new JPanel();  
        sysUpdatePanel.setOpaque(false);  
        sysUpdatePanel.setLayout(new GridBagLayout());  
        sysUpdatePanel.setBorder(new TitledBorder("ͧ?����"));  
        sysToolPanel.add(sysUpdatePanel, BorderLayout.SOUTH);  
        final JButton sysUpdateButton = new JButton("ͧ?����");  
        final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();  
        gridBagConstraints_1.gridx = 0;  
        gridBagConstraints_1.gridy = 0;  
        sysUpdatePanel.add(sysUpdateButton, gridBagConstraints_1);  
        sysUpdateButton.addActionListener(new SysUpdateListener());// ��ʥͧ?��������   
        final JLabel updateLabel = new JLabel("�������棺");  
        final GridBagConstraints updateLabelLayout = new GridBagConstraints();  
        updateLabelLayout.gridy = 1;  
        updateLabelLayout.gridx = 0;  
        sysUpdatePanel.add(updateLabel, updateLabelLayout);  
        final JLabel updateDateLabel = new JLabel();// ����������Ѣ??   
        Date date = new Date(localFile.lastModified());  
        String dateStr = String.format("%tF %<tr", date);  
        updateDateLabel.setText(dateStr);  
        final GridBagConstraints updateDateLayout = new GridBagConstraints();  
        updateDateLayout.gridy = 2;  
        updateDateLayout.gridx = 0;  
        sysUpdatePanel.add(updateDateLabel, updateDateLayout);  
        final JLabel updateStaticLabel = new JLabel("����??��");  
        final GridBagConstraints updateStaticLayout = new GridBagConstraints();  
        updateStaticLayout.gridy = 3;  
        updateStaticLayout.gridx = 0;  
        sysUpdatePanel.add(updateStaticLabel, updateStaticLayout);  
        final JLabel updateInfoLabel = new JLabel();// ��������??   
        checkSysInfo(updateInfoLabel);// ?��??����������۰��   
        final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();  
        gridBagConstraints_5.gridy = 4;  
        gridBagConstraints_5.gridx = 0;  
        sysUpdatePanel.add(updateInfoLabel, gridBagConstraints_5);  
        JPanel statePanel = new JPanel();  
        add(statePanel, BorderLayout.SOUTH);  
        statePanel.setLayout(new BorderLayout());  
        statePanel.add(stateLabel);  
        stateLabel.setText("?��?��" + chatTree.getRowCount());  
        return sysToolScrollPanel;  
    }  
    //----------------------------------------------------------------------------------   
    private void initUserInfoButton(){  
        try{  
            String ip = InetAddress.getLocalHost().getHostAddress();  
            User user = dao.getUser(ip);  
            userInfoButton.setIcon(user.getIconImg());  
            userInfoButton.setText(user.getName());  
            userInfoButton.setIconTextGap(JLabel.RIGHT);  
            userInfoButton.setToolTipText(user.getTipText());  
            userInfoButton.getParent().doLayout();  
        }catch(UnknownHostException e1){  
            e1.printStackTrace();  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private void showMessageBar(){// ?����ͱ������?��?��   
        new Thread(new Runnable() {  
            public void run() {  
                while (true) {  
                    if (!messageStack.empty()) {  
                        try {  
                            messageAlertButton.setIcon(messageAlertNullIcon);  
                            messageAlertButton.setPreferredSize(new Dimension(20, 20));  
                            Thread.sleep(500);  
                            messageAlertButton.setIcon(messageAlertIcon);  
                            Thread.sleep(500);  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                    } else {  
                        try {  
                            Thread.sleep(3000);  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                    }  
                }  
            }  
        }).start();  
    }  
    //----------------------------------------------------------------------------------   
    private void checkSysInfo(final JLabel updateInfo){  
        new Thread(new Runnable(){  
            public void run(){  
                String info = "";  
                while(true){  
                    try{  
                        netFilePath = preferences.get("updatePath", "EQ.jar");  
                        if(netFilePath.equals("EQ.jar")){  
                            info = "<html><center><font color=red><b>������?</b><br>ڱ?���?��?</font></center></html>";  
                            updateInfo.setText(info);  
                            continue;  
                        }  
                        netFile = new File(netFilePath);  
                        if(netFile.exists()){  
                            Date netDate = new Date(netFile.lastModified());  
                            if(!localFile.exists()){  
                                info = "<html><font color=blue>�������������?��</font></html>";  
                            }else{  
                                Date localDate = new Date(localFile.lastModified());  
                                if(netDate.after(localDate)){  
                                    info = "<html><font color=blue>??߾����������</font></html>";  
                                    pushMessage(info);  
                                }else{  
                                    info = "<html><font color=green>?�����������</font></html>";  
                                }  
                            }  
                        }else{  
                            info = "<html><center><font color=red><b>����??</b><br>�?��?</font></center></html>";  
                        }  
                        updateInfo.setText(info);  
                        Thread.sleep(5*1000);  
                    }catch(InterruptedException e){  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }).start();  
    }  
    //----------------------------------------------------------------------------------   
    class SearchUserActionListener implements ActionListener{  
        private final JList list;  
        SearchUserActionListener(JList list){  
            this.list = list;  
        }  
  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            // TODO Auto-generated method stub   
            if(searchUserButton.isSelected()){  
                searchUserButton.setText("������");  
                new Thread(new Runnable(){  
                    public void run(){  
                        Resource.searchUsers(chatTree, progressBar,list, searchUserButton);  
                    }  
                }).start();  
            }else{  
                searchUserButton.setText("�������?");  
            }  
              
        }  
    }  
    //----------------------------------------------------------------------------------   
    class SysSetPanelOKListener implements ActionListener{  
  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            // TODO Auto-generated method stub   
            String command = e.getActionCommand();  
            if(command.equals("sysOK")){  
                String updatePath = updatePathTField.getText();  
                String placardPath = placardPathTField.getText();  
                String pubPath = pubPathTField.getText();  
                preferences.put("updatePath", updatePath); // ?��ͧ?�?��?   
                preferences.put("placardPath", placardPath);// ?��ͧ?��ͱ��?   
                preferences.put("pubPath", pubPath); // ?������������?   
                JOptionPane.showMessageDialog(EQ.this, "ͧ??��������?");  
            }  
            if (command.equals("loginOK")) {  
                String username = userNameTField.getText();  
                String password = new String(passwordTField.getPassword());  
                preferences.put("username", username); // ?��ͧ?�?��?   
                preferences.put("password", password);// ?��ͧ?��ͱ��?   
                JOptionPane.showMessageDialog(EQ.this, "��??��������?");  
            }  
            if (command.equals("ipOK")) {  
                String ipStart = ipStartTField.getText();  
                String ipEnd = ipEndTField.getText();  
                try {  
                    InetAddress.getByName(ipStart);  
                    InetAddress.getByName(ipEnd);  
                } catch (UnknownHostException e1) {  
                    JOptionPane.showMessageDialog(EQ.this, "IP��̫��??");  
                    return;  
                }  
                preferences.put("ipStart", ipStart); // ?��ͧ?�?��?   
                preferences.put("ipEnd", ipEnd);// ?��ͧ?��ͱ��?   
                JOptionPane.showMessageDialog(EQ.this, "IP?��������?");  
            }  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private final class SysUpdateListener implements ActionListener{// ͧ?��������   
  
        @Override  
        public void actionPerformed(final ActionEvent e) {  
            // TODO Auto-generated method stub   
            String username = preferences.get("username", null);  
            String password = preferences.get("password", null);  
            if(username == null || password == null){  
                pushMessage("ڱ?����?�?��?������?٣����?");  
                return;  
            }  
            Resource.loginPublic(username, password);  
            updateProject();  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private class ChatTreeMouseListener extends MouseAdapter{// ��?֪����??��   
        public void mouseClicked(final MouseEvent e){  
            if (e.getClickCount() == 2) {  
                TreePath path = chatTree.getSelectionPath();  
                if (path == null)  
                    return;  
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) path  
                        .getLastPathComponent();  
                User user = (User) node.getUserObject();  
                try {  
                    TelFrame.getInstance(ss, new DatagramPacket(new byte[0], 0,  
                            InetAddress.getByName(user.getIp()), 1111),  
                            chatTree);  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private void server(){// ��?��??۰��   
        new Thread(new Runnable(){  
            public void run(){  
                while(true){  
                    if(ss != null){  
                        byte[] buf = new byte[4096];  
                        DatagramPacket dp = new DatagramPacket(buf,buf.length);  
                        try{  
                            ss.receive(dp);  
                        }catch(IOException e){  
                            e.printStackTrace();  
                        }  
                        TelFrame.getInstance(ss,dp,chatTree);  
                    }  
                }  
            }  
        }).start();  
    }  
    //----------------------------------------------------------------------------------   
    private void addUserPopup(Component component, final JPopupMenu popup){// ��ʥ��??����?   
        component.addMouseListener(new MouseAdapter(){  
            public void mousePressed(MouseEvent e){  
                if(e.isPopupTrigger()){  
                    showMenu(e);  
                }  
            }  
            public void mouseReleased(MouseEvent e) {  
                if (e.isPopupTrigger())  
                    showMenu(e);  
            }  
            private void showMenu(MouseEvent e){  
                if(chatTree.getSelectionPaths() == null){  
                    popupMenu.getComponent(0).setEnabled(false);  
                    popupMenu.getComponent(2).setEnabled(false);  
                    popupMenu.getComponent(3).setEnabled(false);  
                    popupMenu.getComponent(4).setEnabled(false);  
                    popupMenu.getComponent(5).setEnabled(false);  
                }else{  
                    if(chatTree.getSelectionPaths().length < 2){  
                        popupMenu.getComponent(3).setEnabled(false);  
                    }else {  
                        popupMenu.getComponent(3).setEnabled(true);  
                    }  
                    popupMenu.getComponent(0).setEnabled(true);  
                    popupMenu.getComponent(2).setEnabled(true);  
                    popupMenu.getComponent(4).setEnabled(true);  
                    popupMenu.getComponent(5).setEnabled(true);  
                }  
                popup.show(e.getComponent(), e.getX(), e.getY());  
            }  
        });  
    }  
    //----------------------------------------------------------------------------------   
    private void saveLocation(){// �����??������۰��   
        location = getBounds();  
        dao.updateLocation(location);  
    }  
    //----------------------------------------------------------------------------------   
    protected JPopupMenu getPopupMenu(){// ?����??����?   
        if (popupMenu == null) {  
            popupMenu = new JPopupMenu();  
            popupMenu.setOpaque(false);  
        }  
        final JMenuItem rename = new JMenuItem();  
        popupMenu.add(rename);  
        rename.addActionListener(new RenameActionListener());  
        rename.setText("��٣");  
        final JMenuItem addUser = new JMenuItem();  
        addUser.addActionListener(new AddUserActionListener());  
        popupMenu.add(addUser);  
        addUser.setText("��ʥ��?");  
        final JMenuItem delUser = new JMenuItem();  
        delUser.addActionListener(new delUserActionListener());  
        popupMenu.add(delUser);  
        delUser.setText("?���?");  
        final JMenuItem messagerGroupSend = new JMenuItem();  
        messagerGroupSend  
                .addActionListener(new messagerGroupSendActionListener());  
        messagerGroupSend.setText("������?");  
        popupMenu.add(messagerGroupSend);  
        final JMenuItem accessComputerFolder = new JMenuItem("??���?�");  
        accessComputerFolder.setActionCommand("computer");  
        popupMenu.add(accessComputerFolder);  
        accessComputerFolder  
                .addActionListener(new accessFolderActionListener());  
        final JMenuItem accessPublicFolder = new JMenuItem();  
        popupMenu.add(accessPublicFolder);  
        accessPublicFolder.setOpaque(false);  
        accessPublicFolder.setText("??��������");  
        accessPublicFolder.setActionCommand("public");  
        accessPublicFolder.addActionListener(new accessFolderActionListener());  
        return popupMenu;  
    }  
    //----------------------------------------------------------------------------------   
    private void updateProject(){// ��������۰��   
        netFilePath = preferences.get("updatePath", "EQ.jar");  
        if(netFilePath.equals("EQ.jar")){  
            pushMessage("ڱ?���?��?");  
            return;  
        }  
        netFile = new File(netFilePath);  
        localFile = new File(user_dir + File.separator + "EQ.jar");  
        if (localFile != null && netFile != null && netFile.exists()  
                && localFile.exists()) {  
            Date netDate = new Date(netFile.lastModified());  
            Date localDate = new Date(localFile.lastModified());  
            if (netDate.after(localDate)) {  
                new Thread(new Runnable() {  
                    public void run() {  
                        try {  
                            Dialog frameUpdate = new UpdateFrame();  
                            frameUpdate.setVisible(true);  
                            Thread.sleep(2000);  
                            FileInputStream fis = new FileInputStream(netFile);  
                            FileOutputStream fout = new FileOutputStream(  
                                    localFile);  
                            int len = fis.available();  
                            if (len > 0) {  
                                byte[] data = new byte[len];  
                                if (fis.read(data) > 0) {  
                                    fout.write(data);  
                                }  
                            }  
                            fis.close();  
                            fout.close();  
                            frameUpdate.setVisible(false);  
                            frameUpdate = null;  
                            showMessageDialog("������?��?����??����");  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        }  
                    }  
                }).start();  
            } else {  
                showMessageDialog("�?����������������");  
            }  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private void checkPlacard() { // ??��ͱ����۰��   
        String placardDir = preferences.get("placardPath", null);  
        if (placardDir == null) {  
            pushMessage("ڱ?����ͱ��?");  
            return;  
        }  
        File placard = new File(placardDir);  
        try {  
            if (placard.exists() && placard.isFile()) {  
                StringBuilder placardStr = new StringBuilder();  
                Scanner sc = new Scanner(new FileInputStream(placard));  
                while (sc.hasNextLine()) {  
                    placardStr.append(sc.nextLine());  
                }  
                pushMessage(placardStr.toString());  
            }  
        } catch (FileNotFoundException e) {  
            pushMessage("��ͱ��???������ͱ���������");  
        }  
    }  
    //----------------------------------------------------------------------------------   
    public void setStatic(String str){// ?��???����   
        if(stateLabel != null){  
            stateLabel.setText(str);  
        }  
    }  
      
    public void pushMessage(String info){// ��?����   
        if(!messageStack.contains(info)){  
            messageStack.push(info);  
        }  
    }  
      
    private void showMessageDialog(String message){  
        JOptionPane.showMessageDialog(this, message);  
    }  
    //----------------------------------------------------------------------------------   
    private String showInputDialog(String str){// ?��?��???   
        String newName = JOptionPane.showInputDialog(this,  
                "<html>?��<font color=red>" + str + "</font>����٣�</html>");  
        return newName;  
    }  
    private class accessFolderActionListener implements ActionListener {// ???�   
        public void actionPerformed(final ActionEvent e) {  
            TreePath path = chatTree.getSelectionPath();  
            if (path == null)  
                return;  
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path  
                    .getLastPathComponent();  
            User user = (User) node.getUserObject();  
            String ip = "\\\\"+user.getIp();  
            String command = e.getActionCommand();  
            if (command.equals("computer")) {  
                Resource.startFolder(ip);  
            }  
            if (command.equals("public")) {  
                String serverPaeh = preferences.get("pubPath", null);  
                if (serverPaeh == null) {  
                    pushMessage("ڱ?������������?");  
                    return;  
                }  
                Resource.startFolder(serverPaeh);  
            }  
        }  
    }  
  
    private class RenameActionListener implements ActionListener {// ��٣   
        public void actionPerformed(final ActionEvent e) {  
            TreePath path = chatTree.getSelectionPath();  
            if (path == null)  
                return;  
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path  
                    .getLastPathComponent();  
            User user = (User) node.getUserObject();  
            String newName = showInputDialog(user.getName());  
            if (newName != null && !newName.isEmpty()) {  
                user.setName(newName);  
                dao.updateUser(user);  
                DefaultTreeModel model = (DefaultTreeModel) chatTree.getModel();  
                model.reload();  
                chatTree.setSelectionPath(path);  
                initUserInfoButton();  
            }  
        }  
    }  
    private class FrameWindowListener extends WindowAdapter {  
        public void windowClosing(final WindowEvent e) {// ͧ???����   
            setVisible(false);  
        }  
    }  
    private class AddUserActionListener implements ActionListener {  
        public void actionPerformed(final ActionEvent e) {// ��ʥ��?   
            String ip = JOptionPane.showInputDialog(EQ.this, "?������?IP��");  
            if (ip != null)  
                chatTree.addUser(ip, "add");  
        }  
    }  
    private class delUserActionListener implements ActionListener {  
        public void actionPerformed(final ActionEvent e) {// ?���?   
            chatTree.delUser();  
        }  
    }  
    private class messagerGroupSendActionListener implements ActionListener {// ������?   
        public void actionPerformed(final ActionEvent e) {  
            String message = JOptionPane.showInputDialog(EQ.this, "??����?����",  
                    "������?", JOptionPane.INFORMATION_MESSAGE);  
            if (message != null && !message.equals("")) {  
                TreePath[] selectionPaths = chatTree.getSelectionPaths();  
                Resource.sendGroupMessenger(selectionPaths, message);  
            } else if (message != null && message.isEmpty()) {  
                JOptionPane.showMessageDialog(EQ.this, "����?�������ӣ�");  
            }  
        }  
    }  
    private void SystemTrayInitial() { // ͧ??�����   
        if (!SystemTray.isSupported()) // ��??��ͧ?������ͧ??   
            return;  
        try {  
            String title = "TT";  
            String company = "��Դ���ԳΡ����������";  
            SystemTray sysTray = SystemTray.getSystemTray();  
            Image image = Toolkit.getDefaultToolkit().getImage(  
                    EQ.class.getResource("/icons/sysTray.png"));// ͧ????   
            trayicon = new TrayIcon(image, title + "\n" + company, createMenu());  
            trayicon.setImageAutoSize(true);  
            trayicon.addActionListener(new SysTrayActionListener());  
            sysTray.add(trayicon);  
            trayicon.displayMessage(title, company, MessageType.INFO);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    private PopupMenu createMenu() { // ?��ͧ??��?��۰��   
        PopupMenu menu = new PopupMenu();  
        MenuItem exitItem = new MenuItem("����");  
        exitItem.addActionListener(new ActionListener() { // ͧ??��������   
                    public void actionPerformed(ActionEvent e) {  
                        System.exit(0);  
                    }  
                });  
        MenuItem openItem = new MenuItem("��?");  
        openItem.addActionListener(new ActionListener() {// ͧ??��?��??����   
                    public void actionPerformed(ActionEvent e) {  
                        if (!isVisible()) {  
                            setVisible(true);  
                            toFront();  
                        } else  
                            toFront();  
                    }  
                });  
  
        // ͧ??��??��?����??����    
        MenuItem publicItem = new MenuItem("??��?��");  
        publicItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                String serverPaeh = preferences.get("pubPath", null);  
                if (serverPaeh == null) {  
                    pushMessage("ڱ?������������?");  
                    return;  
                }  
                Resource.startFolder(serverPaeh);  
            }  
        });  
        menu.add(publicItem);  
        menu.add(openItem);  
        menu.addSeparator();  
        menu.add(exitItem);  
        return menu;  
    }  
    class SysTrayActionListener implements ActionListener {// ͧ????����   
        public void actionPerformed(ActionEvent e) {  
            setVisible(true);  
            toFront();  
        }  
    }  
}  
