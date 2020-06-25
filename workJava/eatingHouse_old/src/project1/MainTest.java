package project1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainTest extends JFrame implements ActionListener{

	// 패널별 계단(frame>p>p1,p2|frame>p3>p4,p5,p6,p7,p8 분류순 초기화
	JPanel p, p3/*카드*/;						// 레이아웃 패널, p3는 카드레이아웃
	JPanel p1, p2;								// 레이아웃 패널
	JPanel p4, p5;								// 레이아웃 패널, p4에 식당이름 1~10 붙어있는 것
	JPanel p6, p7, p8;							// 레이아웃 패널
	//
	// 
	JButton bt1,bt2;								// 로그인,회원가입 버튼 초기화
	JButton bt3,bt4,bt5,bt6,bt7;				// 한식,중식,일식,양식,기타 버튼
	JButton li1,li2,li3,li4,li5,li6,li7,li8,li9,li10;		// 샘플 리스트 버튼
	
	JButton btBack1,btBack2,btBack3,btBack4;	// 처음 , 이전 , 다음, 끝 버튼 초기화
	CardLayout card=new CardLayout();
	
	public MainTest(){
		super("::음식점::");
		
//////// 패널 리스트 초기화 /////////////////////////////
		p=new JPanel(new GridLayout(2,1)); 		// 제일 상단 패널 (전체메뉴 전환이동시 대상 패널)
		
		p1=new JPanel();							// 상단 	(로그인,회원가입)
		p2=new JPanel();							// 중		( 메뉴리스트 / 한식,중식,일식,양식,기타)
		p3=new JPanel(card){						// 하		( 상점리스트)
			@Override
			public Insets getInsets(){
				return new Insets(35,10,40,10);	// 창과 Frame(컨테이너) 사이 간격
			}///
		};

//////// 메뉴네비게이션 누르면 하단 컨텐트내용 변화부분  /////////////////////////////	
		p4=new JPanel(new GridLayout(0,1,5,5));	// 한식리스트 화면
		p5=new JPanel();								// 중식리스트 화면
		p6=new JPanel();								// 일식리스트 화면
		p7=new JPanel();								// 양식리스트 화면
		p8=new JPanel();								// 기타리스트 화면

		//My1 m1=new My1();
		//m1.sub1();

		
//////// 버튼 리스트 초기화 /////////////////////////////		
		bt1=new JButton("로그인");		bt2=new JButton("회원가입");		bt3=new JButton("한식");
		bt4=new JButton("중식");			bt5=new JButton("일식");			bt6=new JButton("양식");
		bt7=new JButton("기타");
		
		btBack1=new JButton("처음");		btBack2=new JButton("이전");
		btBack3=new JButton("다음");		btBack4=new JButton("끝");
		
////////버튼 식당리스트 초기화 /////////////////////////////
		li1=new JButton("1.한식 식당 이름");		li2=new JButton("2.한식 식당 이름");		li3=new JButton("3.한식 식당 이름");
		li4=new JButton("4.한식 식당 이름");		li5=new JButton("5.한식 식당 이름");		li6=new JButton("6.한식 식당 이름");
		li7=new JButton("7.한식 식당 이름");		li8=new JButton("8.한식 식당 이름");		li9=new JButton("9.한식 식당 이름");
		li10=new JButton("10.한식 식당 이름");

		// 리스트나 내용이 화면에 넘어 갈때 Valign을 해줘야 보인다.
		// p4의 레이아웃을 setLayout(null);
		/*tf=new JTextArea(30,30);
		p3.add(tf);
		tf.setBackground(Color.lightGray);
		tf.setEditable(false);*/

//////// frame, 1단계 p 패널에 패널 추가 작업 /////////////////////////////
		add(p,"North");		// MainTest frame>p패널 	: Top정렬 - 2행 전체를 윗쪽으로	
		add(p3,"Center");	//  f >p3패널 				: Center 추가 정렬	// 하		( 상점리스트)
		p.add(p1); 			// f>p패널 					: p1패널 추가		// 상단 	(로그인,회원가입)
		p.add(p2);			// f>p패널					: p2패널 추가		// 중		( 메뉴리스트 / 한식,중식,일식,양식,기타)

//////// 패널에 배경색 설정 /////////////////////////////
		// f>p3, f>p>p1 , f>p>p2
		p3.setBackground(Color.red);		// 하패널 배경색
		p1.setBackground(Color.green);	// 상패널 배경색 (로그인, 회원가입 )
		p2.setBackground(Color.blue);	// 중패널 배경색 (메뉴분류검색  한식, 중식, 일식, 양식, 기타)
		p5.setBackground(Color.yellow);	// 중식리스트 화면 배경색

////////패널에 버튼추가 /////////////////////////////
		p1.add(bt1); p1.add(bt2);					// 상패널 (로그인,회원가입)버튼 추가
		p2.add(bt3); p2.add(bt4);					// 중패널 (메뉴검색)버튼 추가
		p2.add(bt5); p2.add(bt6); p2.add(bt7);	// 중패널 버튼 추가
		
////////각패널에 버튼추가 /////////////////////////////
		p5.add(btBack1);		// 한식에 처음 버튼 추가
		p6.add(btBack2);		// 일식에 이전 버튼 추가
		p7.add(btBack3);		// 양식에 다음 버튼 추가
		p8.add(btBack4);		// 기타에 끝 버튼 추가

		

		
////////p3패널 화면 바꾸기 (한식,중식,일식,양식,기타 메뉴분류검색별 리스트) /////////////////////////////
		//p3.setLayout(new GridLayout(0,1,5,5));
		p3.add(p4,"K");	// 한식
		p3.add(p5,"C");	// 중식
		p3.add(p6,"J");	// 일식
		p3.add(p7,"U");	// 양식
		p3.add(p8,"O");	// 기타
		/*p3.add(p5,"c");		p3.add(p6,"j");		p3.add(p7,"u");		p3.add(p8,"ex");*/


		
////////p4패널에 상점리스트 추가 /////////////////////////////
		p4.add(li1); p4.add(li2);		p4.add(li3); p4.add(li4);
		p4.add(li5); p4.add(li6);		p4.add(li7); p4.add(li8);
		p4.add(li9); p4.add(li10);

////////버튼에 리스너 붙이기 /////////////////////////////
		bt1.addActionListener(this);			bt2.addActionListener(this);		bt3.addActionListener(this);
		bt4.addActionListener(this);			bt5.addActionListener(this);		bt6.addActionListener(this);
		bt7.addActionListener(this);			btBack1.addActionListener(this);		btBack2.addActionListener(this);
		btBack3.addActionListener(this);		btBack4.addActionListener(this);
		
////////Frame의 싸이즈, 보이기, 자동닫기옵션 설정 /////////////////////////////
		setSize(800,600);		// MainTest 프레임 싸이즈
		setVisible(true);		// MainTest 프레임 보이기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}///public MainTest()
	
	@Override
	public void actionPerformed(ActionEvent e){
			Object o=e.getSource();
			if(o==bt1){			// 버튼 로그인
				setTitle("1");
			}//
			else if(o==bt2){ 	// 버튼 회원가입
				setTitle("2");
			}//
			else if(o==bt3){ 	// 메뉴 한식버튼
				setTitle("3");
				card.show(p3, "K");
				
			}//if
			else if(o==bt4){ 	// 메뉴 중식버튼 	// 그걸 bt4를 누르면 card가 뒤접어져서 p3를 보여줌 
				setTitle("4");
				card.show(p3, "C");
				/*setSize(800,600);
				setVisible(true);*/
			}//
			else if(o==bt5){		// 메뉴 일식버튼
				setTitle("5");
				card.show(p3, "J");
				/*setSize(800,600);
				setVisible(true);*/
			}//
			else if(o==bt6){		// 메뉴 양식버튼
				setTitle("6");
				card.show(p3, "U");
			}//
			else if(o==bt7){		// 메뉴 기타버튼
				setTitle("7");
				card.show(p3, "O");
			}//
			else if(o==btBack1){ // 한식에 처음 버튼 추가
				card.show(p3,"K");
			}//
			else if(o==btBack2){// 일식에 이전 버튼 추가
				card.show(p3,"K");
			}//
			else if(o==btBack3){// 양식에 다음 버튼 추가
				card.show(p3,"K");
			}//
			else if(o==btBack4){// 기타에 끝 버튼 추가
				card.show(p3,"K");
			}//
	}///public void actionPerformed(ActionEvent e)

	public static void main(String[] args){
		MainTest h=new MainTest();
		
	}///public static void main(String[] args)
	
}/////public class MainTest extends JFrame implements ActionListener

//CardLayout card; card=new CardLayout(); setLayout(card); 
// card.show(this,"mainP"); setBackground(Color.lightGray);
//card.show(this, "loginP");

