import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JFrameMain extends JFrame
{
	public JFrameMain()
	{
		//프레임 설정
		super("Test");
		setBounds(400,20, 500, 500);
		setVisible(true);
		
		//메뉴바 설정
		MenuBar menuSet=new MenuBar();
		Menu file=new Menu("파일");
		MenuItem file_new=new MenuItem("저장");
		MenuItem file_open=new MenuItem("불러오기");
		MenuItem file_close=new MenuItem("파일닫기");
		file.add(file_new);
		file.add(file_open);
		file.add(file_close);
		Menu edit=new Menu("편집");
		MenuItem edit_cut=new MenuItem("오려두기");
		MenuItem edit_paste=new MenuItem("붙이기");
		edit.add(edit_cut);	//메뉴 항목에 아이템 등록
		edit.add(edit_paste);
		Menu helpDesk=new Menu("도움말");
		menuSet.add(file);	//메뉴바에 메뉴 등록
		menuSet.add(edit);
		menuSet.add(helpDesk);
		setMenuBar(menuSet); //프레임에 메뉴바 설정
		
		//저장 이벤트 등록
		saveHandler saveHandler=new saveHandler();
		file_new.addActionListener(saveHandler);
		
		//등록 라디오 버튼
		JPanel radioPanel=new JPanel();
		JPanel radioPanel1=new JPanel();
		JPanel radioPanel2=new JPanel();
		JPanel registerPanel=new JPanel();
		
		Border radioBorder=BorderFactory.createEtchedBorder();
		radioBorder=BorderFactory.createTitledBorder(radioBorder, "사용자 등록");
		Border border=BorderFactory.createEtchedBorder();//라인 둘레
		JRadioButton radioButton1=new JRadioButton("일반",true);
		JRadioButton radioButton2=new JRadioButton("회사");
		JRadioButton radioButton3=new JRadioButton("대학교");
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(radioButton1); //라디오버튼 그룹에 등록
		bGroup.add(radioButton2);
		bGroup.add(radioButton3);
		
		
		radioPanel1.setLayout(new FlowLayout());		
		radioPanel1.add(radioButton1); //패널에 라디오 버튼 등록
		radioPanel1.add(radioButton2);
		radioPanel1.add(radioButton3);
		
		JLabel nameLabel=new JLabel("이름", SwingConstants.LEFT);
		JTextField nameText=new JTextField(10);
		JLabel phoneLabel=new JLabel("전화번호", SwingConstants.LEFT);
		JTextField phoneText=new JTextField(10);
		JLabel companyLabel=new JLabel("회사", SwingConstants.LEFT);
		JTextField companyText=new JTextField(10);
		companyText.setEditable(false);
		JLabel univLabel=new JLabel("학교", SwingConstants.LEFT);
		JTextField univText=new JTextField(10);
		univText.setEditable(false);
		
		radioPanel2.setLayout(new GridLayout(4,1));
		radioPanel2.add(nameLabel); radioPanel2.add(nameText);
		radioPanel2.add(phoneLabel); radioPanel2.add(phoneText);
		radioPanel2.add(companyLabel); radioPanel2.add(companyText);
		radioPanel2.add(univLabel); radioPanel2.add(univText);
		
		setLayout(new FlowLayout());
		JButton registerButton=new JButton("등록");
		registerPanel.add(radioPanel1);	
		registerPanel.add(radioPanel2);
		registerPanel.add(registerButton);
		Border registerBorder=BorderFactory.createTitledBorder(border, "사용자등록");
		registerPanel.setBorder(registerBorder);
		add(registerPanel);
		
		//search	
		JPanel intePanel=new JPanel();
		JPanel searchPanel=new JPanel();
		JTextField searchText=new JTextField(10);
		JButton searchButton=new JButton("search");
		Border searchBorder=BorderFactory.createTitledBorder(border, "이름검색");
		searchPanel.setBorder(searchBorder);
		searchPanel.setLayout(new FlowLayout());
		searchPanel.add(searchText);
		searchPanel.add(searchButton);
		intePanel.add(searchPanel, BorderLayout.CENTER);
		
		//delete
		JPanel deletePanel=new JPanel();
		JTextField deleteText=new JTextField(10);
		JButton deleteButton=new JButton("Delete");
		Border deleteBorder=BorderFactory.createTitledBorder(border, "데이터삭제");
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
		
		//사용자 등록 버튼 이벤트 등록
		registerHandler buttonHandler=new registerHandler(radioButton1, radioButton2, radioButton3,
				nameText, phoneText, companyText, univText, textArea);
		registerButton.addActionListener(buttonHandler);
		//이벤트 등록
		BoxHandler handler=new BoxHandler(radioButton1,radioButton2, radioButton3, companyText, univText);
		radioButton1.addItemListener(handler);
		radioButton2.addItemListener(handler);
		radioButton3.addItemListener(handler);
		//서치 이벤트 등록
		SearchHandler sHandler=new SearchHandler(searchText, textArea);
		searchButton.addActionListener(sHandler);
		//삭제 이벤트 등록
		DeleteHandler dHandler=new DeleteHandler(deleteText, textArea);
		deleteButton.addActionListener(dHandler);
		
	}
	
}
