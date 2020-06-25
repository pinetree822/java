package test1;
import java.awt.*;
import java.applet.Applet;

public class AppletEx3 extends Applet {

	Image img = null;
	
	public void init()
	{
		// AppletEx3.html의 태그안에 내용을 가져온다.
		img = getImage(getDocumentBase(), "../images/getJava.jpg");			// 지정된 주소의 이미지를 객체로 변환한다.
		//img = getImage(getCodeBase(), "../images/getJava.jpg");				// 지정된 주소의 이미지를 객체로 변환한다.
		//img = getImage(getDocumentBase(), getParameter("imgName"));		// [x] 지정된 주소의 이미지를 객체로 변환한다.
		//img = getImage(getCodeBase(), getParameter("imgName"));			// [x] 지정된 주소의 이미지를 객체로 변환한다.
		// URL getDocumentBase() - 애플릿이 포함된 HTML의 주소를 반환
		// URL getCodeBase() - 애플릿 클래스 파일이 저장되어 있는 주소 반환
		System.out.println(getDocumentBase());
		System.out.println(getCodeBase());
		System.out.println(getParameter("imgName"));
		System.out.println(img);
	}
	
	@Override
	public void paint(Graphics g) {// Component paint
		// Image의 크기를 얻는다.
		int imgWidth = img.getWidth(this); // img 객체버퍼의 가로 싸이즈, Observe this=Applet의 변화를 감지
		int imgHeight = img.getHeight(this);
		
		// 이미지를 Applet의 중앙에 출력
		// (Applet 가로 싸이즈 - img버퍼 가로싸이즈) / 2, (Applet 세로 싸이즈 - img버퍼 세로싸이즈) / 2
		g.drawImage(img, (getWidth() - imgWidth)/2, (getHeight() - imgHeight)/2, this );// g(그래픽객체 버퍼)는 (img버퍼내용 + img.g버퍼내용)을 위치에 합쳐 그린다. 
				
	}


}// public class AppletEx3



/*
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>AppletEx3.html</title>
</head>
<body>
	<applet code="AppletEx3.class" width=200 height=100>
	</applet>
</body>
</html>
*/