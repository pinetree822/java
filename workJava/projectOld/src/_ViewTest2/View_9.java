package _ViewTest2;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Array;
import java.util.StringTokenizer;
// ��������
public class View_9 extends JPanel {

	private View_Box win;												// ���̾ƿ� Ʋ View_Box
	private JPanel view_9;
	private ShopMemberList shopList;								//	�����ڵ�����Ʈ
	protected String errContext1="";									// - ����ó�� ���� : db���� ���� �Ľ��� ���� �ϴ°� 
	protected int errNum1=0;										// - �������� ��ȣ
	protected JTabbedPane mTpanel_1, mTpanel_2;
	//JLabel lb, shopContext, lb2, lb2_1, , lb3_1;

	protected JLabel shopImg, foodImg_1, foodImg_2, foodImg_3;
	protected JLabel shopContext, foodContext_1, foodContext_2, foodContext_3;
	protected JLabel mapPanel;
	protected JTextArea ta, ta2, ta3;
	protected JButton bBack;														// ��������
	//protected JButton b1, b2, b3;												// ����,ó��,��
	protected JPanel layerPanel_1, layerPanel_1_2, layerPanel_2, layerPanel_3;
	protected JTextPane jmTpanel_2;												// jmTpanel_2JTextPane 		- ����
	protected JPanel layerMapPanel;												// layerMapPanel - JPanle		- ����
	
	
	
	public View_9(View_Box win) {
		///////////////////////////////////////////////////////////////////////////
		/// ���� ����
		///////////////////////////////////////////////////////////////////////////
		this.win = win;																						// View_Box ��ü�� View_1 JPanel�� win ������ ����		
		view_9 = this;
		win.setTitle("��굿����-" + win.VectorShopMemberInfo.getName() +"ȭ��(" + this.getClass().getName() +")");	// View_Box ��ü���� ��ü���̾ƿ��� ���� ����
		//JOptionPane.showMessageDialog(null, win.shopList.getNextpage() );
		//System.out.println( win.shopList.getNowpage() );

		//JOptionPane.showMessageDialog(null, win );
		
		/*
		// setLayout(null);																					// View_1 ��ü JPanel�� ���̾ƿ� ������ �ʱ�ȭ
		// setBounds(100, 100, 800, 600);
		// setSize(800, 600);
 		//win.VectorShopMemberInfo
		//fBox.VectorShopMemberInfo --> View_Box���� VectorShopMemberInfo������ Member ����Ÿ ����
		//JOptionPane.showMessageDialog(null, win.VectorShopMemberInfo.getNum() );	

 		*/
		String tmpShopContext ="";																		// ���� ��� �Ұ�
		tmpShopContext += ("��ü�� : " + win.VectorShopMemberInfo.getName() +"\n");
		tmpShopContext += ("���� : " + win.VectorShopMemberInfo.getType() +"\n");
		tmpShopContext += ("��ȭ��ȣ : " + win.VectorShopMemberInfo.getTel() +"\n");
		tmpShopContext += ("�ּ� : " + win.VectorShopMemberInfo.getJuso() +"\n");
		tmpShopContext += ("���� : ") ;
		int maxRank = 5;
		for(int i=0; i<maxRank; i++){
			if ( i <= win.VectorShopMemberInfo.getRanking() ) tmpShopContext += "��";
			else tmpShopContext += "��";
		}
		//tmpShopContext += (win.VectorShopMemberInfo.getNum() +"\n\n");	
		
		

		/////////////////////////////////////////////////////////////////////////////////////////
		/// ���� �ʱ�ȭ
		/////////////////////////////////////////////////////////////////////////////////////////
		// ���̾ƿ� �г�
		mTpanel_1=new JTabbedPane(JTabbedPane.LEFT);			// ���� ���� �г�
		mTpanel_1.setPreferredSize(new Dimension(800, 600)); 		// 1�ܰ� �޴� ������ ����
		Font font_1=new Font("Dialog",Font.BOLD,18);					// ��Ʈ Dialog Boldü 18������ ���� �ʱ�ȭ

		//�����Ұ� ���̾�
		JPanel layerPanel_1=new JPanel(new BorderLayout());		// ��ư������ ������Ʈ ���� ���̾�
		JPanel layerPanel_1_2=new JPanel(new FlowLayout());			// �׺���̼� ��ư�� ���� ���̾�
		
		//Container cp=this.getContentPane();							// �����̳��г� ���� ��������
		// �������̾�
		view_9.add(mTpanel_1, "Center");									// ���� �޴��� ��Ÿ ������Ʈ�� ����
		view_9.add(layerPanel_1_2, "South");								// ��ư�� ���� ���̾�
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/// �����Ұ�
		/////////////////////////////////////////////////////////////////////////////////////////
		mTpanel_1.add("�����Ұ�", layerPanel_1);// 1�ܰ� �޴�
		shopContext=new JLabel();
		JTextPane shopContext_Text=new JTextPane();						// shopContext_Text - JTextPane - 
		shopContext_Text.setText(tmpShopContext);							// �����Ұ� �ؽ�Ʈ ����
		shopContext_Text.setFont(new Font("Gothic", Font.BOLD, 15));	// �����Ұ� �ؽ�Ʈ������(shopContext_Text) ��Ʈ ����
		shopImg=new JLabel(new ImageIcon("images/" + win.VectorShopMemberInfo.getShopimg()));		// �����Ұ� - �̹���
		layerPanel_1.add(shopImg, "North");
		layerPanel_1.add(shopContext_Text, "Center");


		/////////////////////////////////////////////////////////////////////////////////////////
		// �޴�����
		/////////////////////////////////////////////////////////////////////////////////////////
		//�޴�
		mTpanel_1.add(mTpanel_2=new JTabbedPane(JTabbedPane.LEFT),"�޴�"); // 1�ܰ� �޴�
		
		
		// �������� 	- �迭(�����̸�,���İ���|�����̸�,���İ���)
		// �̹��� 		- �迭(�����̹���|�����̹���)
		//getFolist;			// ��ġ���̳ñ���,7000|�Ҹ���������,16000
		//getFolistimg;		// f1_1.PNG|f1_2.PNG
		String foSpliter1 = "\\|";			// folist 1�� ���ڿ� �и���
		String foSpliter2 = ",";				// folist 2�� ���ڿ� �и���
		String foimgSpliter1 = "\\|";		// folistimg 1�� ���ڿ� �и���
		try {
			// java.lang.NullPointerException	// for������ �߻�������
			// indexOverflow
			// 
			String[] folistToArr1 = win.VectorShopMemberInfo.getFolist().split(foSpliter1);					// ���ĸ޴�����Ʈ(�̸�,����) �迭
			String[] folistimgToFilename = win.VectorShopMemberInfo.getFolistimg().split(foSpliter1);	// �����̹�������Ʈ
			String[] folistToFood = new String[(folistToArr1.length)];		// ���ĸ޴� �̸�
			String[] folistToPrice = new String[(folistToArr1.length)];		// ���ĸ޴� ����
	
			for (int i=0; i<folistToArr1.length; i++) {// �迭�� ������ �ϼ� �ִ�.
				String[] folistToArr2 = folistToArr1[i].split(foSpliter2);
				if( (Integer.valueOf((folistToArr2.length/2))).intValue() != 1 ) { break; }					// �迭�� 2���� ���� �ƴ϶�� ���������� ���� ����. ( Exception �߻� ���Ѿ� �� )
				if( (Integer.valueOf((folistToArr2.length%2))).intValue() == 1 ) { break; }				// �迭�� 2���� ���� �ƴ϶�� ���������� ���� ����. ( Exception �߻� ���Ѿ� �� )
			     for(int k=0; k < folistToArr2.length; k++) {				// �迭�� 2�����̴�
			    	if( k == 0 ) folistToFood[i] = folistToArr2[k];			// ù��°�� �����̸�
			    	else if ( k == 1 ) folistToPrice[i] = folistToArr2[k];		// �ι�°�� ����
			     }
			}
	
	
			// ���ĸ޴� �ʱ�ȭ
			JPanel[] menuPanes = new JPanel[folistToFood.length]; 			// ���ĸ޴�����Ʈ �迭
			JLabel[] menufoodImg = new JLabel[folistToFood.length]; 		// �����̹�������Ʈ �迭
			JLabel[] menuContext = new JLabel[folistToFood.length]; 		// ���ĳ��븮��Ʈ �迭
			
			for(int i=0; i < menuPanes.length; i++) {
				menuPanes[i] = new JPanel(new BorderLayout());													// ���ĸ޴�����Ʈ
				menufoodImg[i] = new JLabel(new ImageIcon("images/" + folistimgToFilename[i])); 		// �����̹�������Ʈ
				menuContext[i] = new JLabel("���� : " + folistToPrice[i] + "��"); 								// ���ĳ��븮��ƮfolistToPrice
				//menuContext[i] = new JLabel("�������� ���ֵ����� ��췯�� �������� �Դϴ�. ������ 15,000��!"); 	// ���ĳ��븮��Ʈ
				menuPanes[i].add(menufoodImg[i], "Center");
				menuPanes[i].add(menuContext[i], "South");
				mTpanel_2.add(folistToFood[i], menuPanes[i]);						// mTpanel_2Panel�� 1��° �޴��� menuPane_1 Panel �߰�			
			}
		} catch (NullPointerException e) {
			// http://soonrok.tistory.com/114 ����
			errNum1++;
			errContext1 = ("�˼����¿����� �����ϴ�.");
		} catch( IndexOutOfBoundsException e) {
			errNum1++;
			errContext1 = ("�˼����¿����� �����ϴ�.");
		} catch (Exception e) {
			errNum1++;
			errContext1 = "";
		} finally {
			// �α��� üũ
			if(errNum1 > 0 ) {
				win.logLevel = win.logLevel; // ȸ������ �״�� �����ؼ� �Ѱ��ֱ�
				win.change("view_2"); 
			}
		}

//java.lang.NullPointerException	// for������ �߻�������


		


		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/// Map ���� 
		/////////////////////////////////////////////////////////////////////////////////////////

		jmTpanel_2=new JTextPane();												// jmTpanel_2JTextPane 		- ����
		jmTpanel_2.setFont(new Font("Gothic", Font.BOLD, 14));				// ����(jmTpanel_2) ��Ʈ����  - 
		// jmTpanel_2 ��������
		jmTpanel_2.setText(win.VectorShopMemberInfo.getMapinfo());
		mapPanel=new JLabel(new ImageIcon("images/" + win.VectorShopMemberInfo.getMapimg()));			// mapPanel �̹��� �߰� 		- ����

		layerMapPanel=new JPanel(new BorderLayout());						// layerMapPanel - JPanle		- ����
		layerMapPanel.add(mapPanel, "Center");									// �����г� - mapPanel ���� �̹��� �߰�
		layerMapPanel.add(jmTpanel_2, "South");								// �����г� - shopContext_Text - JTextPane �߰�
		mTpanel_1.add("ã�� ���� ��",layerMapPanel);							// 1�ܰ� �޴� -  mTpanel_1�гο� layerMapPanel Panel ���� �߰�
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/// �׺���̼� �ϴ� ��ư
		/////////////////////////////////////////////////////////////////////////////////////////
		bBack=new JButton("��������");
		//b2=new JButton("ó��");
		//b3=new JButton("������");
		
		layerPanel_1_2.add(bBack);// ��ư �������� �߰�
		//layerPanel_1_2.add(b2);// ��ư ó������ �߰�
		//layerPanel_1_2.add(b3);// ��ư ������ �߰�

		/////////////////////////////////////////////////////////////////////////////////////////
		/// �������� �ؽ�Ʈ ����
		/////////////////////////////////////////////////////////////////////////////////////////

		
		//lb2_1.setFont(f);// 1��° JLable>�޴�����>��Ʈ ����
		//lb2_1.setFont(f);// 2��° JLable>�޴�����>��Ʈ ����
		

		setVisible(true);// Frame ���̱� ����

		
		///////////////////////////////////////////////////////////////////////////
		/// ������ ���
		///////////////////////////////////////////////////////////////////////////
		bBack.addActionListener( new MyActionListener() );		// �˻� button
		
		//�մ� ���� (�Խ��� ����)
		/*ta3=new JTextArea("�մ� ����");
		mTpanel_1.add(new JScrollPane(ta3), "�մ� ����");*/
		
		//ã�ƿ��� ��
		//mTpanel_1.setPreferredSize(new Dimension(770, 520));/// ������ ���߱�
		//mTpanel_2.setPreferredSize(new Dimension(300, 300));/// ������ ���߱�		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������-----------------------------


	///////////////////////////////////////////////////////////////////////////
	/// ������ ���
	//
	/// View_Box win �� change() �Լ��� �гα�ȯ ��� ���ڿ��� �����Ѵ�. 
	/// ȭ�鱸���� �гα��� ����� "view_2" �������� �����Ѵ�.
	/// �������� ActionListener�� ������ MyActionListener�ڵ鷯 ���� 
	///////////////////////////////////////////////////////////////////////////
	class MyActionListener implements ActionListener {
		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed �̺�Ʈ ����
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 					// ActionListener���� �̺�Ʈ �߻��ϸ� �ڵ�ȣ��Ǵ� ActionEvent ���ڰ��� ���� actionPerformed�Լ�
			Object o=e.getSource(); 										// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			//JOptionPane.showMessageDialog(null, "������ Ŭ��.");	// + o.toString()
			if(o==bBack ){					// �˻� button
				win.logLevel = win.logLevel;// ȸ������ �״�� �����ؼ� �Ѱ��ֱ�
				if (win.logLevel == 1 )	win.change("view_2");
				else win.change("view_1");
			} else {
			}
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	
	
	
	

}