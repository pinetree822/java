package test1;
import java.awt.*;
import java.awt.event.*;


public class  AppletEx1_1 extends java.applet.Applet
{
	TextArea ta = new TextArea();
	Button clear = new Button("clear");

	// new 했을때 자동 호출 생성자
	// 사용자가 정의된 생성자 호출 하거나 
	// jdk에서 자동으로 미리 정의된 호출자 생성하거나, 
	// 빈 생성자 하나 호출한다.
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
	// Applet 확장 사용시 자바프레임워크(JDK)에서 자동호출
	// init(초기 클래스 생성시 호출) -> start -> paint -> stop -> destroy 수순
	// 부르는 순서가 틀리기도 하다.
	//
	// 초기생성할시재시작시 => constructor()->init()->start()
	// 재시작시 => stop()->destroy()->init()->start()

	public void init(){ write("init()\n"); }
	public void start(){ write("start()\n"); }
	public void stop(){ write("stop()\n"); }
	public void destroy(){ write("destroy()\n"); }
	public void paint(){ write("paint()\n"); }

	public void write(String str){
		ta.append(str);				// applet text상자에 표시
		System.out.println(str);	// 이클립스의 애뮬레이터 콘솔에 표시
	}
	
}

/*
/////////////////////////////////////////////////////////////////////////////
// result Print ////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
//// 초기화
constructor()
init()
start()

// 재시작
stop()
destroy()
init()
start()

// 정지
 * 

// 저장
stop()
start()

// 시작
start()

// 복제
constructor()
init()
start()

// 닫기
stop()
destroy()

// 종료
stop()
destroy()

//복제
constructor()
init()
start()

// 재로드
stop()
destroy()
constructor()
init()
start()
 * 
*/


/*
//Applet 생명주기와 메서드
// 1. 웹브라우저가 html + applet 읽는다.
// 2. 웹브라우저가 applet(javaClass) 다운로드한다.
// 3. 웹브라우저가 applet의 인스턴스를 생성한다.
// 4. 애플릿 초기화된다.init()
// 5. 애플릿이 실행된다.start()

Applet 의 메서드(웹브라우저마다 다르다)

init()	- 애플릿이 생성될 때 호출 (객체생성/이미지로딩/애플릿초기화/)
		- 생성자 다음에 호출

start()	- 애플릿의 실행시작, 재시작될 때 호출
		- 웹브라우저가 아이콘화 되었다가 화면에 나타날때 호출
		- init() 호출 된 직 후 반드시 호출

stop()	- 애플릿의 실행 중지
		- 웹브라우저가 아이콘화 되었다가 다른페이지 이동 시 호출
		- distroy()가 호출 직전에 반드시 호출

destroy() - 웹브라우저가 닫히면서 애플릿이 소멸되기 직전에 stop() 다음 호출
		- 애플릿이 사용하던 자원을 반환하는 용도


// HTML TAG 형태
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

// 태그옵션
ARCHIVE	-	애플릿에 사용되는 클래스 파일이나 이미지 파일이 담긴 jar파일을 지정하는데 사용
				jar파일이 하나 이상일 때는 쉼표(,)를 구분자로 사용
				ex) ARCHIVE="a.jar, b.jar"
				
CODE		-	애플릿 클래스의 클래스 파일을 지정하는데 사용한다.
				ex) 패키지명.클래스명.class형태로 지정
				
WIDTH, HEIGHT	- 애플릿이 웹브라우저에 보여질 영역의 폭(WIDTH)과 넓이(HEIGHT)를 지정하는데 사용

CODEBASE -	애플릿을 다운로드할 경로(URL)를 지정하는데 사용
			  - 이 옵션이 없으면 애플릿이 담긴 HTML경로가 CODEBASE가 된다.
			  
ALT		- <APPLET>태그를 이해하지 못하는 웹브라우저에서 애플릿 대신 보여줄 텍스트 지정

NAME		- 애플릿의 이름을 지정하는데 사용
			하나의 HTML페이지에 둘 이상의 애플릿이 있을 때 서로 구별되도록 할 수 있다.
			
ALIGH		- 애플릿의 정렬위치(ALIGHMENT)를 지정하는데 사용
			HTML의 태그에 사용되는 ALIGN옵션과 동일한 값이 사용된다.
			ex) left, right, top, bottom등의 값
			
VSPACE, HSPACE - 애플릿의 외부여백을 지정하는데 사용

<PARAM NAME=attribute VALUE=vlaue>	- 외부에서 애플릿의 값을 전달할 때 사용한다.
													자바 어플리케이션을 실행할 때 커맨드라인에서 값을 입력하는것과 유사하다
													애플릿 내부에서는 getParameter(String name)을 사용해서 읽을 수 있다.
													
				


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