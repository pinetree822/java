package test1;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class AppletEx2
	extends Applet // ���
	implements MouseMotionListener // �������̽� ���� 
{
	int x = 0;// mouse x ��ǥ
	int y = 0;// mouse y ��ǥ
	
	Image img = null;		// �̹��� ��ü
	Graphics gImg = null;	// ��ȭ�� ��ü
	
	
	public AppletEx2() // new ȣ��� �ڵ�ȣ�� ������
	{
		addMouseMotionListener(this);		// AppletEx2�� ������ ���
	}//public AppletEx2()
	
	
	// ���ø����α׷� �ʱ�ȭ
	public void init()
	{
		img = createImage(500, 500);		// �켱 �޸𸮻� �̹���(x�� 500pixel, y�� 500pixel)�� �����ŭ�� �̹��� ���۰�ü�� ����,
												// getImage() �� ȥ���ؼ� ��� �޸����� ��뷮 ������ => getImage cache ����
		
		gImg = img.getGraphics();			// img���۰�ü�κ��� Graphic ��ü�� ��ȯ�Ѵ�. / �׸��� ���� ����(������۸� ����)
		/*
		 * Graphic � ������Ʈ�� �׸��� ���� ������ �������� ��� �ִ� �߻����� Ŭ����
		 * ��) Graphics ��ü�� ��� �ִ� g�� ���ؼ�
		 * �ش� ������Ʈ(img)�� 
		 * g.drawString �޼��带 ���� ���ڸ� �׸��ų�
		 * g.drawColor �޼��带 ���� �׸����� ������ �����ϰų�
		 * g.drawLine �޼��带 ���ؼ� ���� �׸��ų�
		 * 
		 * ���۳�Ʈ �������� �׸��� �Ǵ� ��Ÿ���� ���� �������� �޼���(����)�� ������ �ִ�.
		 */
		
		
		// GraphicsŬ������ gImg��ü�� ������(painting)
		//gImg.drawString("���ʹ�ư�� ���� ä�� ���콺�� ������������.", 10, 50);		// 
		//gImg.drawString("value1 : " + this.x, 10, 65);					// 
		//gImg.drawString("value2 : " + this.y, 10, 80);					// 
		
		//gImg.drawString(getParameter("text"), 10, 50);									// [x]  html�� APPLET �±׳��� Param �Ӽ��� name="text"�� 	gImg��ü�� x��ǥ 10, y��ǥ 60�� ǥ��
		//gImg.drawString("value1 : " + getParameter("value1"), 10, 65);					// [x] html�� APPLET �±׳��� Param �Ӽ��� name="value1"�� gImg��ü�� x��ǥ 10, y��ǥ 60�� ǥ��
		//gImg.drawString("value2 : " + getParameter("value2"), 10, 80);					// [x] html�� APPLET �±׳��� Param �Ӽ��� name="value2"�� gImg��ü�� x��ǥ 10, y��ǥ 60�� ǥ��
		
	}//public void init()
	
	
	
	// ����ȭ�� paint �ڵ� ȣ��
	public void paint(Graphics g)
	{
		if(img == null) return ;		// img���۰�ü�� �������� �ʾҴٸ� ����(�ߴ�)

		//gImg.drawString("value1 : " + this.x, 10, 65);					// ����� �ٽñ׸���.
		//gImg.drawString("value2 : " + this.y, 10, 80);					// 
		// ������۸� ���� = �����ӳ����� �����̴� ������ �����ϱ� ���� ���
		g.drawImage(img, 0, 0, this);	// Observe(this=������)�� �̹����� ��ȯ�� ����
											// Graphics g��ü��  img��ü(img������ü�� ����)�� + Graphic g��ü�� ���۷� �����õ� ���� �� 
											// ��ǥ(0,0) ���� ����ϰ� 
											// ȭ���� �����Ѵ�
											// 

		/*
		 ����ȭ��(��ȭ�� - img)�� �̹����� ��ȯ�� �ɶ�, this observe�� Graphics.g�� �˸��� Graphics�� repaint( Applet�� 0,0��ġ�� �����Ѵ�.)
		 
		 - g.drawImage(img, 0, 0, null)			// ������Ʈ ������ observe �������� �ǹ��� - ����ڰ� �������� �׸���.
		 - g.drawImage(img, 0, 0, this); 			// Observe�� this(Applet)������Ʈ������ observe�ϸ� Graphics��ü�� Observe(this)�� �����Ѵ�.
		 - g.drawImage(img, 0, 0, getParent); 	// getParent�� this�� �θ� ������Ʈ ������ observe �ϰ� Graphics��ü�� Observe(getParent)�� �����Ѵ�.
		 
		 // �Ʒ��� ������ ������ ���� - ������ �ణ �̻���
		 - ��ǥ(0,0) �̶� ? 	�ڹ� ������(Ȥ�� �ٸ� �����̳�)�� ������Ʈ�� ǥ���ϴ� ������
									Ÿ��Ʋ �� (�޴��� �� �ִٸ� �޴���) ���� Ŭ���̾�Ʈ ������
									���� ���� ������ �������� ��ǥ(0,0)�� ���۵˴ϴ�.

		 - image Observe : 1. img��ü �ε��� �ð��� ���� �ɸ� ���� ��� �����ָ� 
		 							�̹��� �ε��κ��� ���� �ϰ� ���ΰ� �ٸ� ���� �����ϴٰ� �ε��� �Ϸ�Ǹ�
		 							������Ʈ�� �˷��༭ repaint() ��Ű�°��̶�� �ǹ��ε�.
		 							
		 						2. �̹����� ������ ���޹޾Ƽ� �̹����� ������Ʈ ��Ű�� ��Ȱ�� �Ѵ�.(?)
		 							�̹����� �ε� �Ϸᰡ �ȵ�����  drawImage �� ȣ���ϸ� imageObserve��ü���� �� ������ ���޵ǰ�
		 							ImageObserve�� �̹����� �����ϰ� �ִٰ� �̹����� ������ �ҷ����� �̹����� ������Ʈ ��Ų��.
		 							�ٸ����� ���ڸ�, �̹����� �׷��� �������͸� ImageObserve�� �θ�ȴ�.
		 							
		- image Observe : null �ΰ�� �̹��������� observe �� �ʿ����. => �̹����� �������� ��ġ ����(�׸���� ����ڰ� ����)
		 */
		
	}//public void paint(Graphics g)

	
	// ���콺 �̺�Ʈ �ڵ鷯 - �����϶�
	public void mouseMoved(MouseEvent me)
	{
		x = me.getX();// event�� getX�Լ��� ���� ���� �������� x�� �ִ´�.
		y = me.getY();// 
	}// public void mouseMoved(MouseEvent me)
	
	
	// ���콺 �̺�Ʈ �ڵ鷯 - ���ʹ�ư �巡�׽�
	public void mouseDragged(MouseEvent me)
	{
		if( me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK  ) return; // ���콺�� ������ �Ǹ� ������ ��ư�� ���� ���¿����� ��
		//gImg.drawString("*", x, y);
		gImg.drawLine(x, y, me.getX(), me.getY());		// ���� x,y���� �ٷ� ���� �̺�Ʈ��ü(me)�� x,y ���� Graphics g(gImg)��ü�� ���ۿ� ���׸���  Applet���� ������ �����Ѵ�.
		x = me.getX();										// �ű� ���콺���۵Ǿ� �߻��� x�� ���� �������� x�� �����Ѵ�.(���� ���콺 x�� ���� �����)
		y = me.getY();

		repaint(); // �����ӿ� ������ ���콺��ǥ���� ���� ������ �׸���.(�ش� �������� ������ ������� �����.)
		
		// ���ϴ� �׸��� �ȱ׷����ٸ�...
		// 1. fillRect() �޼���� repaint() ������ ������� ĥ�ϰ� �Ͼ� ���� ���¿��� repaint()�޼��� ȣ���ϸ� ���ϴ� �׸� ���´�.
		// fillRect() -> repaint();
		// 2. repaint(startX, startY, width, height)  - ���ϴ� �������� ���ϴ� ũ�⸸ŭ repaint()�� �Ҽ� �ִ�.
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
		<param name="text" value="���ʹ�ư�� ���� ä�� ���콺�� ������������."></param>
	</applet>
</body>
</html>



 *
 */

