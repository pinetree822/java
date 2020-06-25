package test1;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class AppletEx2
	extends Applet // 상속
	implements MouseMotionListener // 인터페이스 구현 
{
	int x = 0;// mouse x 좌표
	int y = 0;// mouse y 좌표
	
	Image img = null;		// 이미지 객체
	Graphics gImg = null;	// 도화지 객체
	
	
	public AppletEx2() // new 호출시 자동호출 생성자
	{
		addMouseMotionListener(this);		// AppletEx2에 리스너 등록
	}//public AppletEx2()
	
	
	// 애플릿프로그램 초기화
	public void init()
	{
		img = createImage(500, 500);		// 우선 메모리상에 이미지(x가 500pixel, y가 500pixel)의 싸이즈만큼의 이미지 버퍼객체를 생성,
												// getImage() 와 혼용해서 사용 메모리적재 사용량 때문에 => getImage cache 참고
		
		gImg = img.getGraphics();			// img버퍼객체로부터 Graphic 객체를 반환한다. / 그리기 도구 설정(더블버퍼링 지정)
		/*
		 * Graphic 어떤 컴포넌트에 그리기 위한 도구나 정보들을 담고 있는 추상적인 클래스
		 * 즉) Graphics 객체를 담고 있는 g를 통해서
		 * 해당 컴포넌트(img)에 
		 * g.drawString 메서드를 통해 글자를 그리거나
		 * g.drawColor 메서드를 통해 그릴때의 색상을 선택하거나
		 * g.drawLine 메서드를 통해서 선을 그리거나
		 * 
		 * 컴퍼넌트 구역내에 그리기 또는 나타내기 위하 여러가지 메서드(도구)를 가지고 있다.
		 */
		
		
		// Graphics클래스의 gImg객체로 페인팅(painting)
		//gImg.drawString("왼쪽버튼을 누른 채로 마우스를 움직여보세요.", 10, 50);		// 
		//gImg.drawString("value1 : " + this.x, 10, 65);					// 
		//gImg.drawString("value2 : " + this.y, 10, 80);					// 
		
		//gImg.drawString(getParameter("text"), 10, 50);									// [x]  html의 APPLET 태그내의 Param 속성에 name="text"를 	gImg객체로 x좌표 10, y좌표 60에 표시
		//gImg.drawString("value1 : " + getParameter("value1"), 10, 65);					// [x] html의 APPLET 태그내의 Param 속성에 name="value1"를 gImg객체로 x좌표 10, y좌표 60에 표시
		//gImg.drawString("value2 : " + getParameter("value2"), 10, 80);					// [x] html의 APPLET 태그내의 Param 속성에 name="value2"를 gImg객체로 x좌표 10, y좌표 60에 표시
		
	}//public void init()
	
	
	
	// 실제화면 paint 자동 호출
	public void paint(Graphics g)
	{
		if(img == null) return ;		// img버퍼객체가 생성되지 않았다면 리턴(중단)

		//gImg.drawString("value1 : " + this.x, 10, 65);					// 지우고 다시그린다.
		//gImg.drawString("value2 : " + this.y, 10, 80);					// 
		// 더블버퍼링 구현 = 프레임내용이 깜박이는 현상을 방지하기 위한 기법
		g.drawImage(img, 0, 0, this);	// Observe(this=프레임)는 이미지로 전환될 때에
											// Graphics g객체가  img객체(img버프객체의 내용)와 + Graphic g객체의 버퍼로 페인팅된 내용 을 
											// 좌표(0,0) 위에 출력하고 
											// 화면을 갱신한다
											// 

		/*
		 가상화면(도화지 - img)의 이미지로 전환이 될때, this observe는 Graphics.g에 알리고 Graphics는 repaint( Applet의 0,0위치로 복사한다.)
		 
		 - g.drawImage(img, 0, 0, null)			// 업데이트 정보를 observe 하지마라 의미임 - 사용자가 수동으로 그린다.
		 - g.drawImage(img, 0, 0, this); 			// Observe인 this(Applet)업데이트정보를 observe하며 Graphics객체가 Observe(this)를 참조한다.
		 - g.drawImage(img, 0, 0, getParent); 	// getParent는 this의 부모 업데이트 정보를 observe 하고 Graphics객체가 Observe(getParent)를 참조한다.
		 
		 // 아래는 웹에서 참고한 내용 - 내용이 약간 이상함
		 - 좌표(0,0) 이란 ? 	자바 프레임(혹은 다른 컨테이너)의 컴포넌트를 표시하는 영역을
									타이틀 바 (메뉴바 가 있다면 메뉴바) 밑의 클라이언트 영역의
									가장 위쪽 왼쪽을 기준으로 좌표(0,0)가 시작됩니다.

		 - image Observe : 1. img객체 로딩에 시간이 오래 걸릴 듯한 경우 적어주면 
		 							이미지 로딩부분은 따로 하게 놔두고 다른 것을 진행하다가 로딩이 완료되면
		 							컴포넌트에 알려줘서 repaint() 시키는것이라는 의미인듯.
		 							
		 						2. 이미지의 정보를 전달받아서 이미지를 업데이트 시키는 역활을 한다.(?)
		 							이미지가 로딩 완료가 안됐을때  drawImage 를 호출하면 imageObserve객체에게 그 정보가 전달되고
		 							ImageObserve는 이미지를 관찰하고 있다가 이미지가 완전히 불려지면 이미지를 업데이트 시킨다.
		 							다른말로 하자면, 이미지가 그려질 컴포넌터를 ImageObserve로 두면된다.
		 							
		- image Observe : null 인경우 이미지정보를 observe 할 필요없다. => 이미지를 수동으로 패치 적용(그리기시 사용자가 조정)
		 */
		
	}//public void paint(Graphics g)

	
	// 마우스 이벤트 핸들러 - 움직일때
	public void mouseMoved(MouseEvent me)
	{
		x = me.getX();// event시 getX함수로 값을 얻어와 전역변수 x에 넣는다.
		y = me.getY();// 
	}// public void mouseMoved(MouseEvent me)
	
	
	// 마우스 이벤트 핸들러 - 왼쪽버튼 드래그시
	public void mouseDragged(MouseEvent me)
	{
		if( me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK  ) return; // 마우스가 조작이 되면 오른쪽 버튼을 누른 상태에서의 값
		//gImg.drawString("*", x, y);
		gImg.drawLine(x, y, me.getX(), me.getY());		// 전역 x,y값과 바로 생긴 이벤트객체(me)의 x,y 값과 Graphics g(gImg)객체의 버퍼에 선그리고  Applet으로 내용을 갱신한다.
		x = me.getX();										// 신규 마우스조작되어 발생된 x의 값을 전역변수 x에 저장한다.(기존 마우스 x의 값은 사라짐)
		y = me.getY();

		repaint(); // 프레임에 갱신한 마우스좌표값에 대한 내용을 그린다.(해당 프레임의 내용을 않지우고 덮어쓴다.)
		
		// 원하는 그림이 안그려지다면...
		// 1. fillRect() 메서드로 repaint() 영역을 흰색으로 칠하고 하얀 백지 상태에서 repaint()메서드 호출하면 원하는 그림 나온다.
		// fillRect() -> repaint();
		// 2. repaint(startX, startY, width, height)  - 원하는 지점부터 원하는 크기만큼 repaint()를 할수 있다.
		// repaint(startX, startY, width, height)
	}//public void mouseDragged(MouseEvent me)
	
	
	/*
	 * 
	For example,
	if the user presses button 1 followed by button 2, and then releases them in the same order,
	 the following sequence of events is generated: 
    MOUSE_PRESSED:  BUTTON1_DOWN_MASK
    MOUSE_PRESSED:  BUTTON1_DOWN_MASK | BUTTON2_DOWN_MASK
    MOUSE_RELEASED: BUTTON2_DOWN_MASK
    MOUSE_CLICKED:  BUTTON2_DOWN_MASK
    MOUSE_RELEASED:
    MOUSE_CLICKED:

	It is not recommended to compare the return value of this method using == because new modifiers can be added in the future. 
	For example, 
	the appropriate way to check that SHIFT and BUTTON1 are down, 
	but CTRL is up is demonstrated by the following code: 
	
    int onmask = SHIFT_DOWN_MASK | BUTTON1_DOWN_MASK;
    int offmask = CTRL_DOWN_MASK;
    if ((event.getModifiersEx() & (onmask | offmask)) == onmask) {
        ...
    }

	 * 
	 */
	
	
}// public class AppletEx2 extends Applet implements MouseMotionListener






/*
 *  AppletEx2.html
 *  
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>AppletEx2.html</title>
</head>
<body>
	<applet code="AppletEx2.class" width=200 height=100>
		<param name="value1" value="100"></param>
		<param name="value2" value="200"></param>
		<param name="text" value="왼쪽버튼을 누른 채로 마우스를 움직여보세요."></param>
	</applet>
</body>
</html>



 *
 */

