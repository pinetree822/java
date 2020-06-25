package test1;
import java.awt.*;
import java.awt.event.*;


public class  AppletEx1_1 extends java.applet.Applet
{
	TextArea ta = new TextArea();
	Button clear = new Button("clear");

	// new ������ �ڵ� ȣ�� ������
	// ����ڰ� ���ǵ� ������ ȣ�� �ϰų� 
	// jdk���� �ڵ����� �̸� ���ǵ� ȣ���� �����ϰų�, 
	// �� ������ �ϳ� ȣ���Ѵ�.
	public AppletEx1_1(){
		setLayout(new BorderLayout());
		add(ta,"Center");
		add(clear, "South");
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ta.setText("");
			}
		});
		write("constructor()\n");
	}
	// Applet Ȯ�� ���� �ڹ������ӿ�ũ(JDK)���� �ڵ�ȣ��
	// init(�ʱ� Ŭ���� ������ ȣ��) -> start -> paint -> stop -> destroy ����
	// �θ��� ������ Ʋ���⵵ �ϴ�.
	//
	// �ʱ�����ҽ�����۽� => constructor()->init()->start()
	// ����۽� => stop()->destroy()->init()->start()

	public void init(){ write("init()\n"); }
	public void start(){ write("start()\n"); }
	public void stop(){ write("stop()\n"); }
	public void destroy(){ write("destroy()\n"); }
	public void paint(){ write("paint()\n"); }

	public void write(String str){
		ta.append(str);				// applet text���ڿ� ǥ��
		System.out.println(str);	// ��Ŭ������ �ֹķ����� �ֿܼ� ǥ��
	}
	
}

/*
/////////////////////////////////////////////////////////////////////////////
// result Print ////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
//// �ʱ�ȭ
constructor()
init()
start()

// �����
stop()
destroy()
init()
start()

// ����
 * 

// ����
stop()
start()

// ����
start()

// ����
constructor()
init()
start()

// �ݱ�
stop()
destroy()

// ����
stop()
destroy()

//����
constructor()
init()
start()

// ��ε�
stop()
destroy()
constructor()
init()
start()
 * 
*/


/*
//Applet �����ֱ�� �޼���
// 1. ���������� html + applet �д´�.
// 2. ���������� applet(javaClass) �ٿ�ε��Ѵ�.
// 3. ���������� applet�� �ν��Ͻ��� �����Ѵ�.
// 4. ���ø� �ʱ�ȭ�ȴ�.init()
// 5. ���ø��� ����ȴ�.start()

Applet �� �޼���(������������ �ٸ���)

init()	- ���ø��� ������ �� ȣ�� (��ü����/�̹����ε�/���ø��ʱ�ȭ/)
		- ������ ������ ȣ��

start()	- ���ø��� �������, ����۵� �� ȣ��
		- ���������� ������ȭ �Ǿ��ٰ� ȭ�鿡 ��Ÿ���� ȣ��
		- init() ȣ�� �� �� �� �ݵ�� ȣ��

stop()	- ���ø��� ���� ����
		- ���������� ������ȭ �Ǿ��ٰ� �ٸ������� �̵� �� ȣ��
		- distroy()�� ȣ�� ������ �ݵ�� ȣ��

destroy() - ���������� �����鼭 ���ø��� �Ҹ�Ǳ� ������ stop() ���� ȣ��
		- ���ø��� ����ϴ� �ڿ��� ��ȯ�ϴ� �뵵


// HTML TAG ����
<APPLET
	[ARCHIVE = archiveList]
	CODE = appletFile.class
	WIDTH = pixels
	HEIGHT = pixels
	[CODEBASE=codebaseURL]
	[ALT=alternateText]
	[NAME=appletInstanceName]
	[ALIGN=pixels]
	[VSPACE=pixels]
>
	[<PARAM NAME=appletAttribte1 VALUE=value>]
	[<PARAM NAME=appletAttribte2 VALUE=value>]
	// ..
</APPLET>

// �±׿ɼ�
ARCHIVE	-	���ø��� ���Ǵ� Ŭ���� �����̳� �̹��� ������ ��� jar������ �����ϴµ� ���
				jar������ �ϳ� �̻��� ���� ��ǥ(,)�� �����ڷ� ���
				ex) ARCHIVE="a.jar, b.jar"
				
CODE		-	���ø� Ŭ������ Ŭ���� ������ �����ϴµ� ����Ѵ�.
				ex) ��Ű����.Ŭ������.class���·� ����
				
WIDTH, HEIGHT	- ���ø��� ���������� ������ ������ ��(WIDTH)�� ����(HEIGHT)�� �����ϴµ� ���

CODEBASE -	���ø��� �ٿ�ε��� ���(URL)�� �����ϴµ� ���
			  - �� �ɼ��� ������ ���ø��� ��� HTML��ΰ� CODEBASE�� �ȴ�.
			  
ALT		- <APPLET>�±׸� �������� ���ϴ� ������������ ���ø� ��� ������ �ؽ�Ʈ ����

NAME		- ���ø��� �̸��� �����ϴµ� ���
			�ϳ��� HTML�������� �� �̻��� ���ø��� ���� �� ���� �����ǵ��� �� �� �ִ�.
			
ALIGH		- ���ø��� ������ġ(ALIGHMENT)�� �����ϴµ� ���
			HTML�� �±׿� ���Ǵ� ALIGN�ɼǰ� ������ ���� ���ȴ�.
			ex) left, right, top, bottom���� ��
			
VSPACE, HSPACE - ���ø��� �ܺο����� �����ϴµ� ���

<PARAM NAME=attribute VALUE=vlaue>	- �ܺο��� ���ø��� ���� ������ �� ����Ѵ�.
													�ڹ� ���ø����̼��� ������ �� Ŀ�ǵ���ο��� ���� �Է��ϴ°Ͱ� �����ϴ�
													���ø� ���ο����� getParameter(String name)�� ����ؼ� ���� �� �ִ�.
													
				


 * 
 */


/*
 * AppeltEx1_1.html
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>AppletEx1-1.html</title>
</head>
<body>
	<applet code="AppletEx1_1.class" width=200 height=100>
	</applet>
</body>
</html>


*/