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
    private JTextField userNameTField;//éÄ??   
    private JPasswordField passwordTField;//ÚË??   
    private JTextField placardPathTField;//placard:ÍëÍ±   
    private JTextField updatePathTField;//ÌÚãæÖØ?   
    private JTextField pubPathTField;  
    public static EQ frame = null;  
    private ChatTree chatTree;  
    private JPopupMenu popupMenu;//éÓ?óø?   
    private JTabbedPane tabbedPane;//İÂ?Øü÷ù   
    private JToggleButton searchUserButton;//â¤ßãéÄ?äÎ?   
    private JProgressBar progressBar;//???   
    private JList faceList;  
    private JButton selectInterfaceOKButton;  
    private DatagramSocket ss;//?Ëß??ñ¨   
    private final JLabel stateLabel;  
    private static String user_dir;  
    private static File localFile;  
    private static File netFile;  
    private String netFilePath;  
    private JButton messageAlertButton;  
    private Stack<String> messageStack;////Stack ?øúãÆı¨?à»õó£¨LIFO£©îÜ?ßÚ÷Ø?¡£   
    private ImageIcon messageAlertIcon;  
    private ImageIcon messageAlertNullIcon;  
    private Rectangle location;  
    public static TrayIcon trayicon;  
    private Dao dao;  
    //Preferences.systeRoot:Ú÷üŞÍ§?îÜĞÆâÏ???ïÃ   Preferences:????   
    public final static Preferences preferences = Preferences.systemRoot();  
    private JButton userInfoButton;  
    //----------------------------------------------------------------------------------   
    public static void main(String[] args){  
        try{  
            String laf = preferences.get("lookAndFeel", "javaÙù?");  
            if(laf.indexOf("?îñÍ§?") > -1){  
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
            }  
            EQ frame = new EQ();  
            frame.setVisible(true);  
            frame.SystemTrayInitial();// ôøã·ûùÍ§??   
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
        setTitle("EQÖıô¸");  
        setBounds(location);  
        progressBar = new JProgressBar();  
        //BevelBorder:??????îÜ??ŞØØü??¡£Bevel:ŞØØü     lowered:èêìıŞØØü?úş¡£   
        progressBar.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        tabbedPane = new JTabbedPane();  
        popupMenu = new JPopupMenu();  
        chatTree = new ChatTree(this);  
        user_dir = System.getProperty("user.dir");// ïïßí?ú¼ÖØ?éÄéÍÍ§?ÌÚãæ   
        localFile = new File(user_dir + File.separator + "EQ.jar");// Üâò¢EQÙşËì   
        stateLabel = new JLabel();// ?????   
        this.addWindowListener(new FrameWindowListener());// ôÕÊ¥????Ğï   
        this.addComponentListener(new ComponentAdapter(){  
            public void componentResized(final ComponentEvent e){  
                saveLocation();  
            }  
            public void componentMoved(final ComponentEvent e){  
                saveLocation();  
            }  
        });  
        try{// ??÷×?Ü×?Ó®Ï¢   
            ss = new DatagramSocket(1111);  
        }catch(SocketException e2){  
            if(e2.getMessage().startsWith("Address already in use")){  
                showMessageDialog("Ü×?Ó®Ï¢ù¬ï¿éÄ,ûäíºÜâ?Ëìì«??ú¼¡£");  
            }  
            System.exit(0);  
        }  
        {// ôøã·ûùÍëÍìãáãÓäÎ?   
            messageAlertIcon = new ImageIcon(EQ.class.getResource("/image/messageAlert.gif"));  
            messageAlertNullIcon = new ImageIcon(EQ.class.getResource("/image/messageAlertNull20.gif"));  
            messageStack = new Stack<String>();  
            messageAlertButton = new JButton();  
            messageAlertButton.setHorizontalAlignment(SwingConstants.RIGHT);  
            messageAlertButton.setContentAreaFilled(false);//Üô?õö?é»?æ´   
            final JPanel BannerPanel = new JPanel();  
            BannerPanel.setLayout(new BorderLayout());  
            this.add(BannerPanel,BorderLayout.NORTH);  
            userInfoButton = new JButton();  
            BannerPanel.add(userInfoButton,BorderLayout.WEST);  
            userInfoButton.setMargin(new Insets(0,0,0,10));//Margin:?Ëå    insets:?ìı    
            initUserInfoButton();// ôøã·ûùÜâò¢éÄ??ßÀäÎ?   
            BannerPanel.add(messageAlertButton,BorderLayout.CENTER);  
            messageAlertButton.addActionListener(new ActionListener(){  
  
                @Override  
                public void actionPerformed(ActionEvent arg0) {  
                    if(!messageStack.empty()){  
                        showMessageDialog(messageStack.pop());//÷Ø??İ»îÜ?ßÚ£¨Vector ?ßÚñéîÜõÌı¨ìé?£©¡£    
                    }  
                }  
            });  
            messageAlertButton.setIcon(messageAlertIcon);  
            showMessageBar();  
        }  
        this.add(tabbedPane,BorderLayout.CENTER);  
        tabbedPane.setTabPlacement(SwingConstants.LEFT);//?öÇó®????Ì«îÜ???øÖÏÑ   
        ImageIcon userTicon = new ImageIcon(EQ.class.getResource("/image/tabIcon/tabLeft.PNG"));  
        tabbedPane.addTab(null,userTicon,createUserList(),"éÄ?Öªøú");  
        ImageIcon sysOTicon = new ImageIcon(EQ.class.getResource("/image/tabIcon/tabLeft2.PNG"));  
        tabbedPane.addTab(null, sysOTicon, createSysToolPanel(), "Í§?ğÃíÂ");  
        ImageIcon sysSTicon = new ImageIcon(EQ.class.getResource("/image/tabIcon/tabLeft3.png"));  
        tabbedPane.addTab(null, sysSTicon, createSysSetPanel(), "Í§??öÇ");  
        this.setAlwaysOnTop(true);//?î¤?İ»   
    }  
    //----------------------------------------------------------------------------------   
    private JScrollPane createSysSetPanel(){//Í§??öÇØü÷ù   
        final JPanel sysSetPanel = new JPanel();  
        JScrollPane scrollPane = new JScrollPane(sysSetPanel);  
        sysSetPanel.setLayout(new BoxLayout(sysSetPanel,BoxLayout.Y_AXIS));  
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));  
        final JPanel sysPathPanel = new JPanel();  
        sysPathPanel.setMaximumSize(new Dimension(600,200));  
        sysPathPanel.setBorder(new TitledBorder("Í§?ÖØ?"));//title - ????ãÆîÜ??   
        sysPathPanel.setLayout(new GridLayout(0,1));  
        sysSetPanel.add(sysPathPanel);  
        sysPathPanel.add(new JLabel("ïïßíã®?ÖØ?"));  
        updatePathTField = new JTextField(preferences.get("updatePath", "??ìıÖØ?"));  
        sysPathPanel.add(updatePathTField);  
        sysPathPanel.add(new JLabel("Í§?ÍëÍ±ÖØ?£º"));  
        placardPathTField = new JTextField(preferences.get("placardPath","??ìıÖØ?"));  
        sysPathPanel.add(placardPathTField);  
        sysPathPanel.add(new JLabel("ÍëÍìïïßíÖØ?£º"));  
        pubPathTField = new JTextField(preferences.get("pubPath", "??ìıÖØ?"));  
        sysPathPanel.add(pubPathTField);  
        final JButton pathOKButton = new JButton("?ïÒ");  
        pathOKButton.setActionCommand("sysOK");  
        pathOKButton.addActionListener(new SysSetPanelOKListener());  
        sysSetPanel.add(pathOKButton);  
        final JPanel loginPanel = new JPanel();  
        loginPanel.setMaximumSize(new Dimension(600, 90));  
        loginPanel.setBorder(new TitledBorder("Ôô?ã®?Ü×?Ğï"));  
        final GridLayout gridLayout_1 = new GridLayout(0, 1);  
        gridLayout_1.setVgap(5);  
        loginPanel.setLayout(gridLayout_1);  
        sysSetPanel.add(loginPanel);  
        final JPanel panel_7 = new JPanel();  
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));  
        loginPanel.add(panel_7);  
        panel_7.add(new JLabel("éÄ?Ù££º"));  
        userNameTField = new JTextField(preferences.get("username", "??ìıéÄ?Ù£"));  
        panel_7.add(userNameTField);  
        final JPanel panel_8 = new JPanel();  
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));  
        loginPanel.add(panel_8);  
        panel_8.add(new JLabel("ÚË¡¡?£º"));  
        passwordTField = new JPasswordField("*****");  
        panel_8.add(passwordTField);  
        final JButton loginOKButton = new JButton("?ïÒ");  
        sysSetPanel.add(loginOKButton);  
        loginOKButton.setActionCommand("loginOK");  
        loginOKButton.addActionListener(new SysSetPanelOKListener());  
        final JPanel ipPanel = new JPanel();  
        final GridLayout gridLayout_2 = new GridLayout(0, 1);  
        gridLayout_2.setVgap(5);  
        ipPanel.setLayout(gridLayout_2);  
        ipPanel.setMaximumSize(new Dimension(600, 90));  
        ipPanel.setBorder(new TitledBorder("IPâ¤ßãÛõ?"));  
        sysSetPanel.add(ipPanel);  
        final JPanel panel_5 = new JPanel();  
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));  
        ipPanel.add(panel_5);  
        panel_5.add(new JLabel("ÑÃã·IP£º"));  
        ipStartTField = new JTextField(preferences.get("ipStart", "192.168.0.1"));  
        panel_5.add(ipStartTField);  
        final JPanel panel_6 = new JPanel();  
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));  
        ipPanel.add(panel_6);  
        panel_6.add(new JLabel("?ò­IP£º"));  
        ipEndTField = new JTextField(preferences.get("ipEnd", "192.168.1.255"));  
        panel_6.add(ipEndTField);  
        final JButton ipOKButton = new JButton("?ïÒ");  
        ipOKButton.setActionCommand("ipOK");  
        ipOKButton.addActionListener(new SysSetPanelOKListener());  
        sysSetPanel.add(ipOKButton);  
        return scrollPane;  
    }  
    //----------------------------------------------------------------------------------   
    private JScrollPane createUserList(){// éÄ?ÖªøúØü÷ù   
        JScrollPane scrollPane = new JScrollPane();  
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);  
        addUserPopup(chatTree,getPopupMenu());// ?éÄ?ôÕÊ¥?õóóø?   
        scrollPane.setViewportView(chatTree);  
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));  
        chatTree.addMouseListener(new ChatTreeMouseListener());  
          
        return scrollPane;  
    }  
    //----------------------------------------------------------------------------------   
    private JScrollPane createSysToolPanel() {// Í§?ÍïÎıØü÷ù   
        JPanel sysToolPanel = new JPanel(); // Í§?ÍïÎıØü÷ù   
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
        interfacePanel.setBorder(new TitledBorder("Í£Øü??-î¢ó­??ßæüù"));  
        faceList = new JList(new String[]{"?îñÍ§?", "javaÙù?"});  
        interfacePanel.add(faceList);  
        faceList.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        final JPanel interfaceSubPanel = new JPanel();  
        interfaceSubPanel.setLayout(new FlowLayout());  
        interfacePanel.add(interfaceSubPanel, BorderLayout.SOUTH);  
        selectInterfaceOKButton = new JButton("?ïÒ");  
        selectInterfaceOKButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                preferences.put("lookAndFeel", faceList.getSelectedValue().toString());  
                JOptionPane.showMessageDialog(EQ.this, "ñìãæ?ú¼Üâ?Ëìı¨ßæüù");  
            }  
        });  
        interfaceSubPanel.add(selectInterfaceOKButton);  
  
        JPanel searchUserPanel = new JPanel(); // éÄ?â¤ßãØü÷ù   
        sysToolPanel.add(searchUserPanel);  
        searchUserPanel.setLayout(new BorderLayout());  
        final JPanel searchControlPanel = new JPanel();  
        searchControlPanel.setLayout(new GridLayout(0, 1));  
        searchUserPanel.add(searchControlPanel, BorderLayout.SOUTH);  
        final JList searchUserList = new JList(new String[]{"??éÄ?Öªøú"});// ãæôÕÊ¥éÄ?Öªøú   
        final JScrollPane scrollPane_2 = new JScrollPane(searchUserList);  
        scrollPane_2.setDoubleBuffered(true);  
        searchUserPanel.add(scrollPane_2);  
        searchUserList.setBorder(new BevelBorder(BevelBorder.LOWERED));  
        searchUserButton = new JToggleButton();  
        searchUserButton.setText("â¤ßããæéÄ?");  
        searchUserButton.addActionListener(new SearchUserActionListener(searchUserList));  
        searchControlPanel.add(progressBar);  
        searchControlPanel.add(searchUserButton);  
        searchUserPanel.setBorder(new TitledBorder("â¤ßãéÄ?"));  
  
        final JPanel sysUpdatePanel = new JPanel();  
        sysUpdatePanel.setOpaque(false);  
        sysUpdatePanel.setLayout(new GridBagLayout());  
        sysUpdatePanel.setBorder(new TitledBorder("Í§?ğÃíÂ"));  
        sysToolPanel.add(sysUpdatePanel, BorderLayout.SOUTH);  
        final JButton sysUpdateButton = new JButton("Í§?ÌÚãæ");  
        final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();  
        gridBagConstraints_1.gridx = 0;  
        gridBagConstraints_1.gridy = 0;  
        sysUpdatePanel.add(sysUpdateButton, gridBagConstraints_1);  
        sysUpdateButton.addActionListener(new SysUpdateListener());// ôÕÊ¥Í§?ÌÚãæŞÀËì   
        final JLabel updateLabel = new JLabel("õÌĞÎÌÚãæ£º");  
        final GridBagConstraints updateLabelLayout = new GridBagConstraints();  
        updateLabelLayout.gridy = 1;  
        updateLabelLayout.gridx = 0;  
        sysUpdatePanel.add(updateLabel, updateLabelLayout);  
        final JLabel updateDateLabel = new JLabel();// ïïßíÌÚãæìíÑ¢??   
        Date date = new Date(localFile.lastModified());  
        String dateStr = String.format("%tF %<tr", date);  
        updateDateLabel.setText(dateStr);  
        final GridBagConstraints updateDateLayout = new GridBagConstraints();  
        updateDateLayout.gridy = 2;  
        updateDateLayout.gridx = 0;  
        sysUpdatePanel.add(updateDateLabel, updateDateLayout);  
        final JLabel updateStaticLabel = new JLabel("ÌÚãæ??£º");  
        final GridBagConstraints updateStaticLayout = new GridBagConstraints();  
        updateStaticLayout.gridy = 3;  
        updateStaticLayout.gridx = 0;  
        sysUpdatePanel.add(updateStaticLabel, updateStaticLayout);  
        final JLabel updateInfoLabel = new JLabel();// ÷úÜâãáãÓ??   
        checkSysInfo(updateInfoLabel);// ?éÄ??÷úÜâÌÚãæîÜÛ°Ûö   
        final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();  
        gridBagConstraints_5.gridy = 4;  
        gridBagConstraints_5.gridx = 0;  
        sysUpdatePanel.add(updateInfoLabel, gridBagConstraints_5);  
        JPanel statePanel = new JPanel();  
        add(statePanel, BorderLayout.SOUTH);  
        statePanel.setLayout(new BorderLayout());  
        statePanel.add(stateLabel);  
        stateLabel.setText("?ìÑ?£º" + chatTree.getRowCount());  
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
    private void showMessageBar(){// ?ãÆÍëÍ±ãáãÓäÎ?îÜ?ïï   
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
                            info = "<html><center><font color=red><b>ÙéÛöÔô?</b><br>Ú±?öÇã®?ÖØ?</font></center></html>";  
                            updateInfo.setText(info);  
                            continue;  
                        }  
                        netFile = new File(netFilePath);  
                        if(netFile.exists()){  
                            Date netDate = new Date(netFile.lastModified());  
                            if(!localFile.exists()){  
                                info = "<html><font color=blue>Üâò¢ïïßíêÈöÇõó?£¡</font></html>";  
                            }else{  
                                Date localDate = new Date(localFile.lastModified());  
                                if(netDate.after(localDate)){  
                                    info = "<html><font color=blue>??ß¾êóõÌãæïïßí£¡</font></html>";  
                                    pushMessage(info);  
                                }else{  
                                    info = "<html><font color=green>?î¤ãÀõÌãæïïßí£¡</font></html>";  
                                }  
                            }  
                        }else{  
                            info = "<html><center><font color=red><b>ÙéÛö??</b><br>ã®?ÖØ?</font></center></html>";  
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
                searchUserButton.setText("ïÎò­â¤ßã");  
                new Thread(new Runnable(){  
                    public void run(){  
                        Resource.searchUsers(chatTree, progressBar,list, searchUserButton);  
                    }  
                }).start();  
            }else{  
                searchUserButton.setText("â¤ßããæéÄ?");  
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
                preferences.put("updatePath", updatePath); // ?öÇÍ§?ã®?ÖØ?   
                preferences.put("placardPath", placardPath);// ?öÇÍ§?ÍëÍ±ÖØ?   
                preferences.put("pubPath", pubPath); // ?öÇÍëÍìïïßíÖØ?   
                JOptionPane.showMessageDialog(EQ.this, "Í§??öÇÜÁğíèÇ?");  
            }  
            if (command.equals("loginOK")) {  
                String username = userNameTField.getText();  
                String password = new String(passwordTField.getPassword());  
                preferences.put("username", username); // ?öÇÍ§?ã®?ÖØ?   
                preferences.put("password", password);// ?öÇÍ§?ÍëÍ±ÖØ?   
                JOptionPane.showMessageDialog(EQ.this, "Ôô??öÇÜÁğíèÇ?");  
            }  
            if (command.equals("ipOK")) {  
                String ipStart = ipStartTField.getText();  
                String ipEnd = ipEndTField.getText();  
                try {  
                    InetAddress.getByName(ipStart);  
                    InetAddress.getByName(ipEnd);  
                } catch (UnknownHostException e1) {  
                    JOptionPane.showMessageDialog(EQ.this, "IPò¢ò£Ì«ãÒ??");  
                    return;  
                }  
                preferences.put("ipStart", ipStart); // ?öÇÍ§?ã®?ÖØ?   
                preferences.put("ipEnd", ipEnd);// ?öÇÍ§?ÍëÍ±ÖØ?   
                JOptionPane.showMessageDialog(EQ.this, "IP?öÇÜÁğíèÇ?");  
            }  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private final class SysUpdateListener implements ActionListener{// Í§?ÌÚãæŞÀËì   
  
        @Override  
        public void actionPerformed(final ActionEvent e) {  
            // TODO Auto-generated method stub   
            String username = preferences.get("username", null);  
            String password = preferences.get("password", null);  
            if(username == null || password == null){  
                pushMessage("Ú±?öÇÔô?ã®?Ü×?ĞïîÜéÄ?Ù£ûäÚË?");  
                return;  
            }  
            Resource.loginPublic(username, password);  
            updateProject();  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private class ChatTreeMouseListener extends MouseAdapter{// éÄ?ÖªøúîÜ??Ğï   
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
    private void server(){// Ü×?Ğï??Û°Ûö   
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
    private void addUserPopup(Component component, final JPopupMenu popup){// ôÕÊ¥éÄ??õóóø?   
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
    private void saveLocation(){// ÜÁğíñ«??êÈöÇîÜÛ°Ûö   
        location = getBounds();  
        dao.updateLocation(location);  
    }  
    //----------------------------------------------------------------------------------   
    protected JPopupMenu getPopupMenu(){// ?ËïéÄ??õóóø?   
        if (popupMenu == null) {  
            popupMenu = new JPopupMenu();  
            popupMenu.setOpaque(false);  
        }  
        final JMenuItem rename = new JMenuItem();  
        popupMenu.add(rename);  
        rename.addActionListener(new RenameActionListener());  
        rename.setText("ÌÚÙ£");  
        final JMenuItem addUser = new JMenuItem();  
        addUser.addActionListener(new AddUserActionListener());  
        popupMenu.add(addUser);  
        addUser.setText("ôÕÊ¥éÄ?");  
        final JMenuItem delUser = new JMenuItem();  
        delUser.addActionListener(new delUserActionListener());  
        popupMenu.add(delUser);  
        delUser.setText("?ğ¶éÄ?");  
        final JMenuItem messagerGroupSend = new JMenuItem();  
        messagerGroupSend  
                .addActionListener(new messagerGroupSendActionListener());  
        messagerGroupSend.setText("ãáŞÅÏØ?");  
        popupMenu.add(messagerGroupSend);  
        final JMenuItem accessComputerFolder = new JMenuItem("??ñ«Ïõ?ê¹");  
        accessComputerFolder.setActionCommand("computer");  
        popupMenu.add(accessComputerFolder);  
        accessComputerFolder  
                .addActionListener(new accessFolderActionListener());  
        final JMenuItem accessPublicFolder = new JMenuItem();  
        popupMenu.add(accessPublicFolder);  
        accessPublicFolder.setOpaque(false);  
        accessPublicFolder.setText("??ÍëÍìïïßí");  
        accessPublicFolder.setActionCommand("public");  
        accessPublicFolder.addActionListener(new accessFolderActionListener());  
        return popupMenu;  
    }  
    //----------------------------------------------------------------------------------   
    private void updateProject(){// ïïßíÌÚãæÛ°Ûö   
        netFilePath = preferences.get("updatePath", "EQ.jar");  
        if(netFilePath.equals("EQ.jar")){  
            pushMessage("Ú±?öÇã®?ÖØ?");  
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
                            showMessageDialog("ÌÚãæèÇ?£¬?ñìãæ??ïïßí¡£");  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        }  
                    }  
                }).start();  
            } else {  
                showMessageDialog("ì«?ãÀõÌãæîÜïïßíÖõ¡£");  
            }  
        }  
    }  
    //----------------------------------------------------------------------------------   
    private void checkPlacard() { // ??ÍëÍ±ãáãÓÛ°Ûö   
        String placardDir = preferences.get("placardPath", null);  
        if (placardDir == null) {  
            pushMessage("Ú±?öÇÍëÍ±ÖØ?");  
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
            pushMessage("ÍëÍ±ÖØ???£¬ûäÍëÍ±ÙşËìÜôğíî¤");  
        }  
    }  
    //----------------------------------------------------------------------------------   
    public void setStatic(String str){// ?öÇ???ãáãÓ   
        if(stateLabel != null){  
            stateLabel.setText(str);  
        }  
    }  
      
    public void pushMessage(String info){// ÷Ø?ãáãÓ   
        if(!messageStack.contains(info)){  
            messageStack.push(info);  
        }  
    }  
      
    private void showMessageDialog(String message){  
        JOptionPane.showMessageDialog(this, message);  
    }  
    //----------------------------------------------------------------------------------   
    private String showInputDialog(String str){// ?ãÆ?ìı???   
        String newName = JOptionPane.showInputDialog(this,  
                "<html>?ìı<font color=red>" + str + "</font>îÜãæÙ£í®</html>");  
        return newName;  
    }  
    private class accessFolderActionListener implements ActionListener {// ???ê¹   
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
                    pushMessage("Ú±?öÇÍëÍìïïßíÖØ?");  
                    return;  
                }  
                Resource.startFolder(serverPaeh);  
            }  
        }  
    }  
  
    private class RenameActionListener implements ActionListener {// ÌÚÙ£   
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
        public void windowClosing(final WindowEvent e) {// Í§???ŞÀËì   
            setVisible(false);  
        }  
    }  
    private class AddUserActionListener implements ActionListener {  
        public void actionPerformed(final ActionEvent e) {// ôÕÊ¥éÄ?   
            String ip = JOptionPane.showInputDialog(EQ.this, "?ìıãæéÄ?IPò¢ò£");  
            if (ip != null)  
                chatTree.addUser(ip, "add");  
        }  
    }  
    private class delUserActionListener implements ActionListener {  
        public void actionPerformed(final ActionEvent e) {// ?ğ¶éÄ?   
            chatTree.delUser();  
        }  
    }  
    private class messagerGroupSendActionListener implements ActionListener {// ãáŞÅÏØ?   
        public void actionPerformed(final ActionEvent e) {  
            String message = JOptionPane.showInputDialog(EQ.this, "??ìıÏØ?ãáãÓ",  
                    "ãáŞÅÏØ?", JOptionPane.INFORMATION_MESSAGE);  
            if (message != null && !message.equals("")) {  
                TreePath[] selectionPaths = chatTree.getSelectionPaths();  
                Resource.sendGroupMessenger(selectionPaths, message);  
            } else if (message != null && message.isEmpty()) {  
                JOptionPane.showMessageDialog(EQ.this, "ÜôÒö?áêÍöãáãÓ£¡");  
            }  
        }  
    }  
    private void SystemTrayInitial() { // Í§??ôøã·ûù   
        if (!SystemTray.isSupported()) // ÷÷??îñÍ§?ãÀÜúò¨ò¥Í§??   
            return;  
        try {  
            String title = "TT";  
            String company = "à÷Ô´ã¼ÔÒÔ³Î¡ĞüêóùÚÍëŞÉ";  
            SystemTray sysTray = SystemTray.getSystemTray();  
            Image image = Toolkit.getDefaultToolkit().getImage(  
                    EQ.class.getResource("/icons/sysTray.png"));// Í§????   
            trayicon = new TrayIcon(image, title + "\n" + company, createMenu());  
            trayicon.setImageAutoSize(true);  
            trayicon.addActionListener(new SysTrayActionListener());  
            sysTray.add(trayicon);  
            trayicon.displayMessage(title, company, MessageType.INFO);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    private PopupMenu createMenu() { // ?ËïÍ§??óø?îÜÛ°Ûö   
        PopupMenu menu = new PopupMenu();  
        MenuItem exitItem = new MenuItem("÷Üõó");  
        exitItem.addActionListener(new ActionListener() { // Í§??÷ÜõóŞÀËì   
                    public void actionPerformed(ActionEvent e) {  
                        System.exit(0);  
                    }  
                });  
        MenuItem openItem = new MenuItem("öè?");  
        openItem.addActionListener(new ActionListener() {// Í§??öè?óø??ŞÀËì   
                    public void actionPerformed(ActionEvent e) {  
                        if (!isVisible()) {  
                            setVisible(true);  
                            toFront();  
                        } else  
                            toFront();  
                    }  
                });  
  
        // Í§??îÜ??Ü×?Ğïóø??ŞÀËì    
        MenuItem publicItem = new MenuItem("??Ü×?Ğï");  
        publicItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                String serverPaeh = preferences.get("pubPath", null);  
                if (serverPaeh == null) {  
                    pushMessage("Ú±?öÇÍëÍìïïßíÖØ?");  
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
    class SysTrayActionListener implements ActionListener {// Í§????ŞÀËì   
        public void actionPerformed(ActionEvent e) {  
            setVisible(true);  
            toFront();  
        }  
    }  
}  
