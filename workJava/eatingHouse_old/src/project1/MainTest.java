package project1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainTest extends JFrame implements ActionListener{

	// �гκ� ���(frame>p>p1,p2|frame>p3>p4,p5,p6,p7,p8 �з��� �ʱ�ȭ
	JPanel p, p3/*ī��*/;						// ���̾ƿ� �г�, p3�� ī�巹�̾ƿ�
	JPanel p1, p2;								// ���̾ƿ� �г�
	JPanel p4, p5;								// ���̾ƿ� �г�, p4�� �Ĵ��̸� 1~10 �پ��ִ� ��
	JPanel p6, p7, p8;							// ���̾ƿ� �г�
	//
	// 
	JButton bt1,bt2;								// �α���,ȸ������ ��ư �ʱ�ȭ
	JButton bt3,bt4,bt5,bt6,bt7;				// �ѽ�,�߽�,�Ͻ�,���,��Ÿ ��ư
	JButton li1,li2,li3,li4,li5,li6,li7,li8,li9,li10;		// ���� ����Ʈ ��ư
	
	JButton btBack1,btBack2,btBack3,btBack4;	// ó�� , ���� , ����, �� ��ư �ʱ�ȭ
	CardLayout card=new CardLayout();
	
	public MainTest(){
		super("::������::");
		
//////// �г� ����Ʈ �ʱ�ȭ /////////////////////////////
		p=new JPanel(new GridLayout(2,1)); 		// ���� ��� �г� (��ü�޴� ��ȯ�̵��� ��� �г�)
		
		p1=new JPanel();							// ��� 	(�α���,ȸ������)
		p2=new JPanel();							// ��		( �޴�����Ʈ / �ѽ�,�߽�,�Ͻ�,���,��Ÿ)
		p3=new JPanel(card){						// ��		( ��������Ʈ)
			@Override
			public Insets getInsets(){
				return new Insets(35,10,40,10);	// â�� Frame(�����̳�) ���� ����
			}///
		};

//////// �޴��׺���̼� ������ �ϴ� ����Ʈ���� ��ȭ�κ�  /////////////////////////////	
		p4=new JPanel(new GridLayout(0,1,5,5));	// �ѽĸ���Ʈ ȭ��
		p5=new JPanel();								// �߽ĸ���Ʈ ȭ��
		p6=new JPanel();								// �Ͻĸ���Ʈ ȭ��
		p7=new JPanel();								// ��ĸ���Ʈ ȭ��
		p8=new JPanel();								// ��Ÿ����Ʈ ȭ��

		//My1 m1=new My1();
		//m1.sub1();

		
//////// ��ư ����Ʈ �ʱ�ȭ /////////////////////////////		
		bt1=new JButton("�α���");		bt2=new JButton("ȸ������");		bt3=new JButton("�ѽ�");
		bt4=new JButton("�߽�");			bt5=new JButton("�Ͻ�");			bt6=new JButton("���");
		bt7=new JButton("��Ÿ");
		
		btBack1=new JButton("ó��");		btBack2=new JButton("����");
		btBack3=new JButton("����");		btBack4=new JButton("��");
		
////////��ư �Ĵ縮��Ʈ �ʱ�ȭ /////////////////////////////
		li1=new JButton("1.�ѽ� �Ĵ� �̸�");		li2=new JButton("2.�ѽ� �Ĵ� �̸�");		li3=new JButton("3.�ѽ� �Ĵ� �̸�");
		li4=new JButton("4.�ѽ� �Ĵ� �̸�");		li5=new JButton("5.�ѽ� �Ĵ� �̸�");		li6=new JButton("6.�ѽ� �Ĵ� �̸�");
		li7=new JButton("7.�ѽ� �Ĵ� �̸�");		li8=new JButton("8.�ѽ� �Ĵ� �̸�");		li9=new JButton("9.�ѽ� �Ĵ� �̸�");
		li10=new JButton("10.�ѽ� �Ĵ� �̸�");

		// ����Ʈ�� ������ ȭ�鿡 �Ѿ� ���� Valign�� ����� ���δ�.
		// p4�� ���̾ƿ��� setLayout(null);
		/*tf=new JTextArea(30,30);
		p3.add(tf);
		tf.setBackground(Color.lightGray);
		tf.setEditable(false);*/

//////// frame, 1�ܰ� p �гο� �г� �߰� �۾� /////////////////////////////
		add(p,"North");		// MainTest frame>p�г� 	: Top���� - 2�� ��ü�� ��������	
		add(p3,"Center");	//  f >p3�г� 				: Center �߰� ����	// ��		( ��������Ʈ)
		p.add(p1); 			// f>p�г� 					: p1�г� �߰�		// ��� 	(�α���,ȸ������)
		p.add(p2);			// f>p�г�					: p2�г� �߰�		// ��		( �޴�����Ʈ / �ѽ�,�߽�,�Ͻ�,���,��Ÿ)

//////// �гο� ���� ���� /////////////////////////////
		// f>p3, f>p>p1 , f>p>p2
		p3.setBackground(Color.red);		// ���г� ����
		p1.setBackground(Color.green);	// ���г� ���� (�α���, ȸ������ )
		p2.setBackground(Color.blue);	// ���г� ���� (�޴��з��˻�  �ѽ�, �߽�, �Ͻ�, ���, ��Ÿ)
		p5.setBackground(Color.yellow);	// �߽ĸ���Ʈ ȭ�� ����

////////�гο� ��ư�߰� /////////////////////////////
		p1.add(bt1); p1.add(bt2);					// ���г� (�α���,ȸ������)��ư �߰�
		p2.add(bt3); p2.add(bt4);					// ���г� (�޴��˻�)��ư �߰�
		p2.add(bt5); p2.add(bt6); p2.add(bt7);	// ���г� ��ư �߰�
		
////////���гο� ��ư�߰� /////////////////////////////
		p5.add(btBack1);		// �ѽĿ� ó�� ��ư �߰�
		p6.add(btBack2);		// �ϽĿ� ���� ��ư �߰�
		p7.add(btBack3);		// ��Ŀ� ���� ��ư �߰�
		p8.add(btBack4);		// ��Ÿ�� �� ��ư �߰�

		

		
////////p3�г� ȭ�� �ٲٱ� (�ѽ�,�߽�,�Ͻ�,���,��Ÿ �޴��з��˻��� ����Ʈ) /////////////////////////////
		//p3.setLayout(new GridLayout(0,1,5,5));
		p3.add(p4,"K");	// �ѽ�
		p3.add(p5,"C");	// �߽�
		p3.add(p6,"J");	// �Ͻ�
		p3.add(p7,"U");	// ���
		p3.add(p8,"O");	// ��Ÿ
		/*p3.add(p5,"c");		p3.add(p6,"j");		p3.add(p7,"u");		p3.add(p8,"ex");*/


		
////////p4�гο� ��������Ʈ �߰� /////////////////////////////
		p4.add(li1); p4.add(li2);		p4.add(li3); p4.add(li4);
		p4.add(li5); p4.add(li6);		p4.add(li7); p4.add(li8);
		p4.add(li9); p4.add(li10);

////////��ư�� ������ ���̱� /////////////////////////////
		bt1.addActionListener(this);			bt2.addActionListener(this);		bt3.addActionListener(this);
		bt4.addActionListener(this);			bt5.addActionListener(this);		bt6.addActionListener(this);
		bt7.addActionListener(this);			btBack1.addActionListener(this);		btBack2.addActionListener(this);
		btBack3.addActionListener(this);		btBack4.addActionListener(this);
		
////////Frame�� ������, ���̱�, �ڵ��ݱ�ɼ� ���� /////////////////////////////
		setSize(800,600);		// MainTest ������ ������
		setVisible(true);		// MainTest ������ ���̱�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}///public MainTest()
	
	@Override
	public void actionPerformed(ActionEvent e){
			Object o=e.getSource();
			if(o==bt1){			// ��ư �α���
				setTitle("1");
			}//
			else if(o==bt2){ 	// ��ư ȸ������
				setTitle("2");
			}//
			else if(o==bt3){ 	// �޴� �ѽĹ�ư
				setTitle("3");
				card.show(p3, "K");
				
			}//if
			else if(o==bt4){ 	// �޴� �߽Ĺ�ư 	// �װ� bt4�� ������ card�� ���������� p3�� ������ 
				setTitle("4");
				card.show(p3, "C");
				/*setSize(800,600);
				setVisible(true);*/
			}//
			else if(o==bt5){		// �޴� �ϽĹ�ư
				setTitle("5");
				card.show(p3, "J");
				/*setSize(800,600);
				setVisible(true);*/
			}//
			else if(o==bt6){		// �޴� ��Ĺ�ư
				setTitle("6");
				card.show(p3, "U");
			}//
			else if(o==bt7){		// �޴� ��Ÿ��ư
				setTitle("7");
				card.show(p3, "O");
			}//
			else if(o==btBack1){ // �ѽĿ� ó�� ��ư �߰�
				card.show(p3,"K");
			}//
			else if(o==btBack2){// �ϽĿ� ���� ��ư �߰�
				card.show(p3,"K");
			}//
			else if(o==btBack3){// ��Ŀ� ���� ��ư �߰�
				card.show(p3,"K");
			}//
			else if(o==btBack4){// ��Ÿ�� �� ��ư �߰�
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

