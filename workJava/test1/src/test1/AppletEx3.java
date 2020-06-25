package test1;
import java.awt.*;
import java.applet.Applet;

public class AppletEx3 extends Applet {

	Image img = null;
	
	public void init()
	{
		// AppletEx3.html�� �±׾ȿ� ������ �����´�.
		img = getImage(getDocumentBase(), "../images/getJava.jpg");			// ������ �ּ��� �̹����� ��ü�� ��ȯ�Ѵ�.
		//img = getImage(getCodeBase(), "../images/getJava.jpg");				// ������ �ּ��� �̹����� ��ü�� ��ȯ�Ѵ�.
		//img = getImage(getDocumentBase(), getParameter("imgName"));		// [x] ������ �ּ��� �̹����� ��ü�� ��ȯ�Ѵ�.
		//img = getImage(getCodeBase(), getParameter("imgName"));			// [x] ������ �ּ��� �̹����� ��ü�� ��ȯ�Ѵ�.
		// URL getDocumentBase() - ���ø��� ���Ե� HTML�� �ּҸ� ��ȯ
		// URL getCodeBase() - ���ø� Ŭ���� ������ ����Ǿ� �ִ� �ּ� ��ȯ
		System.out.println(getDocumentBase());
		System.out.println(getCodeBase());
		System.out.println(getParameter("imgName"));
		System.out.println(img);
	}
	
	@Override
	public void paint(Graphics g) {// Component paint
		// Image�� ũ�⸦ ��´�.
		int imgWidth = img.getWidth(this); // img ��ü������ ���� ������, Observe this=Applet�� ��ȭ�� ����
		int imgHeight = img.getHeight(this);
		
		// �̹����� Applet�� �߾ӿ� ���
		// (Applet ���� ������ - img���� ���ν�����) / 2, (Applet ���� ������ - img���� ���ν�����) / 2
		g.drawImage(img, (getWidth() - imgWidth)/2, (getHeight() - imgHeight)/2, this );// g(�׷��Ȱ�ü ����)�� (img���۳��� + img.g���۳���)�� ��ġ�� ���� �׸���. 
				
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