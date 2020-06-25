import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JFrameMain extends JFrame
{
	public JFrameMain()
	{
		//������ ����
		super("Test");
		setBounds(400,20, 500, 500);
		setVisible(true);
		
		//�޴��� ����
		MenuBar menuSet=new MenuBar();
		Menu file=new Menu("����");
		MenuItem file_new=new MenuItem("����");
		MenuItem file_open=new MenuItem("�ҷ�����");
		MenuItem file_close=new MenuItem("���ϴݱ�");
		file.add(file_new);
		file.add(file_open);
		file.add(file_close);
		Menu edit=new Menu("����");
		MenuItem edit_cut=new MenuItem("�����α�");
		MenuItem edit_paste=new MenuItem("���̱�");
		edit.add(edit_cut);	//�޴� �׸� ������ ���
		edit.add(edit_paste);
		Menu helpDesk=new Menu("����");
		menuSet.add(file);	//�޴��ٿ� �޴� ���
		menuSet.add(edit);
		menuSet.add(helpDesk);
		setMenuBar(menuSet); //�����ӿ� �޴��� ����
		
		//���� �̺�Ʈ ���
		saveHandler saveHandler=new saveHandler();
		file_new.addActionListener(saveHandler);
		
		//��� ���� ��ư
		JPanel radioPanel=new JPanel();
		JPanel radioPanel1=new JPanel();
		JPanel radioPanel2=new JPanel();
		JPanel registerPanel=new JPanel();
		
		Border radioBorder=BorderFactory.createEtchedBorder();
		radioBorder=BorderFactory.createTitledBorder(radioBorder, "����� ���");
		Border border=BorderFactory.createEtchedBorder();//���� �ѷ�
		JRadioButton radioButton1=new JRadioButton("�Ϲ�",true);
		JRadioButton radioButton2=new JRadioButton("ȸ��");
		JRadioButton radioButton3=new JRadioButton("���б�");
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(radioButton1); //������ư �׷쿡 ���
		bGroup.add(radioButton2);
		bGroup.add(radioButton3);
		
		
		radioPanel1.setLayout(new FlowLayout());		
		radioPanel1.add(radioButton1); //�гο� ���� ��ư ���
		radioPanel1.add(radioButton2);
		radioPanel1.add(radioButton3);
		
		JLabel nameLabel=new JLabel("�̸�", SwingConstants.LEFT);
		JTextField nameText=new JTextField(10);
		JLabel phoneLabel=new JLabel("��ȭ��ȣ", SwingConstants.LEFT);
		JTextField phoneText=new JTextField(10);
		JLabel companyLabel=new JLabel("ȸ��", SwingConstants.LEFT);
		JTextField companyText=new JTextField(10);
		companyText.setEditable(false);
		JLabel univLabel=new JLabel("�б�", SwingConstants.LEFT);
		JTextField univText=new JTextField(10);
		univText.setEditable(false);
		
		radioPanel2.setLayout(new GridLayout(4,1));
		radioPanel2.add(nameLabel); radioPanel2.add(nameText);
		radioPanel2.add(phoneLabel); radioPanel2.add(phoneText);
		radioPanel2.add(companyLabel); radioPanel2.add(companyText);
		radioPanel2.add(univLabel); radioPanel2.add(univText);
		
		setLayout(new FlowLayout());
		JButton registerButton=new JButton("���");
		registerPanel.add(radioPanel1);	
		registerPanel.add(radioPanel2);
		registerPanel.add(registerButton);
		Border registerBorder=BorderFactory.createTitledBorder(border, "����ڵ��");
		registerPanel.setBorder(registerBorder);
		add(registerPanel);
		
		//search	
		JPanel intePanel=new JPanel();
		JPanel searchPanel=new JPanel();
		JTextField searchText=new JTextField(10);
		JButton searchButton=new JButton("search");
		Border searchBorder=BorderFactory.createTitledBorder(border, "�̸��˻�");
		searchPanel.setBorder(searchBorder);
		searchPanel.setLayout(new FlowLayout());
		searchPanel.add(searchText);
		searchPanel.add(searchButton);
		intePanel.add(searchPanel, BorderLayout.CENTER);
		
		//delete
		JPanel deletePanel=new JPanel();
		JTextField deleteText=new JTextField(10);
		JButton deleteButton=new JButton("Delete");
		Border deleteBorder=BorderFactory.createTitledBorder(border, "�����ͻ���");
		deletePanel.setBorder(deleteBorder);
		deletePanel.setLayout(new FlowLayout());
		deletePanel.add(deleteText);
		deletePanel.add(deleteButton);
		intePanel.add(deletePanel, BorderLayout.CENTER);
		add(intePanel);
		
		//textArea
		JTextArea textArea=new JTextArea(10,39);
		JScrollPane simpleScroll=new JScrollPane(textArea);
		Border textBorder=BorderFactory.createTitledBorder(border, "Information Board");
		simpleScroll.setBorder(textBorder);
		
		textArea.setCaretPosition(textArea.getText().length());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		add(simpleScroll);
		
		//����� ��� ��ư �̺�Ʈ ���
		registerHandler buttonHandler=new registerHandler(radioButton1, radioButton2, radioButton3,
				nameText, phoneText, companyText, univText, textArea);
		registerButton.addActionListener(buttonHandler);
		//�̺�Ʈ ���
		BoxHandler handler=new BoxHandler(radioButton1,radioButton2, radioButton3, companyText, univText);
		radioButton1.addItemListener(handler);
		radioButton2.addItemListener(handler);
		radioButton3.addItemListener(handler);
		//��ġ �̺�Ʈ ���
		SearchHandler sHandler=new SearchHandler(searchText, textArea);
		searchButton.addActionListener(sHandler);
		//���� �̺�Ʈ ���
		DeleteHandler dHandler=new DeleteHandler(deleteText, textArea);
		deleteButton.addActionListener(dHandler);
		
	}
	
}
