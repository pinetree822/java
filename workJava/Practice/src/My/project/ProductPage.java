package My.project;
import javax.swing.*;
import javax.swing.border.*;
import static My.project.Show_main.*;
import static My.project.A.*;
import static My.project.B.*;
import static My.project.C.*;
import static My.project.MyPart.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ProductPage extends JFrame implements ActionListener{
	public static JPanel p1,p2,p3,p2_1,p2_2,p1_1,p1_1_User,p1_2,p1_3,p1_4,p1_4_1,p2_2_1,pPhoto, pMainText,pLine;
	public static JLabel lbTitle,lbCategory,lbArea,lbPrice, lbUser;
	public static JLabel lbRe;
	public static JTextField tfTitle,tfCategory,tfArea,tfPrice,tfRe, tfUser;
	public static JTextArea taComment, taMain ,taDate;
	public static JButton btEnter;
	public static JLabel lbImg;
	public static ImageIcon img1;
	

	public ProductPage(){
		super("@@@@@@@@ProductPage@@@@@@@@");
		Container cp=getContentPane();
		JPanel mainP=new JPanel(new BorderLayout());
		
		JScrollPane sp=new JScrollPane(mainP);
		//sp.setLayout(new BorderLayout());
		sp.getVerticalScrollBar().setUnitIncrement(16);//스크롤속도
		
		
		cp.add(sp, "Center");
		p1=new JPanel(new GridLayout(5,1,0,0)); 
		
		
		p2=new JPanel();
		p3=new JPanel();
		p2_1=new JPanel(new BorderLayout());
		p2_2=new JPanel();
		
		p2.setLayout(new BorderLayout());
		p1_1=new JPanel();
		p1_2=new JPanel();
		p1_3=new JPanel();
		p1_4=new JPanel(new BorderLayout());
		p1_4_1=new JPanel();
		pLine=new JPanel();
		p1_1_User=new JPanel();
		
		////////////////이미지
		
		
		pPhoto=new JPanel();
		taMain=new JTextArea(2,60);
		
		mainP.add(p1, "North");
		mainP.add(p2, "Center");
		p2.add(new JScrollPane());
		mainP.add(p3, "South");
		
		/////컬러
		Color colO= new Color(60,161,217);
		Color colN= new Color(37,58,75);
		Color colG= new Color(226,226,226);
		
		///
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(colO);
		p2.add(p2_1,"Center");
		p2.add(p2_2,"South");
		p2_1.setBackground(Color.white);
		p2_2.setBackground(colO);
		p1.add(p1_1);
		p1.add(p1_1_User);
		p1_1_User.setBackground(Color.white);
		p1.add(p1_2);
		p1.add(p1_3);
		p1.add(p1_4);
		
		p2.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		
		/*p2_1.add(pPhoto,"North");
		pPhoto.setBackground(Color.cyan);*/
		pMainText=new JPanel();
		p2_1.add(pMainText,"Center");
		
		pMainText.add(taMain);
		taMain.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pMainText.setBackground(Color.white);
		
		////////
		p1_4.add(p1_4_1,"Center");
		p1_4.add(pLine,"South");
		pLine.setBackground(colG);
		
		////////Panel
		
		lbTitle= new JLabel("제        목 :");
		lbCategory=new JLabel("카테고리 :");
		lbArea=new JLabel("지        역 :");
		lbPrice=new JLabel("금        액 :");
		tfUser=new JTextField(54); tfUser.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfUser.setBackground(Color.white);
		lbUser=new JLabel("게   시  자:");lbUser.setForeground(colO);
		
		tfTitle=new JTextField(54); tfTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfTitle.setBackground(colO);
		
		tfCategory=new JTextField(54);tfCategory.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfCategory.setBackground(Color.white);
		tfArea=new JTextField(54);tfArea.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfArea.setBackground(Color.white);
		tfPrice=new JTextField(54);tfPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfPrice.setBackground(Color.white);
		
		p1_1.add(lbTitle);
		p1_1.setBackground(colO);
		lbTitle.setForeground(Color.white);
		p1_1.add(tfTitle);
		lbCategory.setForeground(colO);
		
		
		p1_1_User.add(lbUser);
		p1_1_User.add(tfUser);
		
		
		tfUser.setText("USERNAME");
		
		p1_2.add(lbCategory);
		p1_2.setBackground(Color.white);
		p1_2.add(tfCategory);
		p1_3.add(lbArea);
		lbArea.setForeground(colO);
		p1_3.add(tfArea);
		p1_3.setBackground(Color.white);
		p1_4_1.add(lbPrice);
		lbPrice.setForeground(colO);
		p1_4_1.add(tfPrice);
		p1_4_1.setBackground(Color.white);
		
		
	/////////////////////////
		lbRe=new JLabel("댓글입력 :");
		tfRe=new JTextField("", 40);
		
		p3.add(lbRe);
		p3.add(tfRe);
		
		
		taComment=new JTextArea(4,50);
		p2_2.add(taComment);
		taDate=new JTextArea(4,10);
		p2_2.add(taDate);
		
		btEnter = new JButton("입  력");
		p3.add(btEnter);

		////////
		img1= new ImageIcon("b.jpg");
		
		lbImg = new JLabel("상품이미지",img1,JLabel.CENTER);
		lbImg.setForeground(colN);
		
		lbImg.setVerticalTextPosition(JLabel.NORTH);
		lbImg.setHorizontalTextPosition(JLabel.CENTER);
		p2_1.add(lbImg,"North");
		
		
	/*	public void init() {
			  //Panel p = new Panel();
			  image1 = new ImageIcon("img/img.jpg");  //이미지 경로
			  
			  lb = new JLabel("이미지를 넣자",image1,JLabel.CENTER);
			  lb.setVerticalTextPosition(JLabel.CENTER);
			  lb.setHorizontalTextPosition(JLabel.RIGHT);
			  
			 add(lb);
			 
			 }*/
		
		/////////////리스너
		btEnter.addActionListener(this);
		tfRe.addActionListener(this);
		
		
		//////읽기전용
		taComment.setEditable(false);
		taDate.setEditable(false);
		tfTitle.setEditable(false);
		tfCategory.setEditable(false);
		tfArea.setEditable(false);
		tfPrice.setEditable(false);
		tfUser.setEditable(false);
		taMain.setEditable(false);
	


		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		Vector<String> vComment = new Vector<String>(10,3);  	    ///////////백터로 댓글값 저장(추가됨)
		Vector<String> vCal = new Vector<String>(10,3);			///////////백터로 댓글날자 저장(추가됨)
		if(obj==btEnter||obj==tfRe){
			setTitle("댓글이 입력되었습니다.");
			String str = tfRe.getText();
			Date date = new Date();
			String dateStr = date.toString();
			String saveRe = "→"+"  "+curr_ID+" : "+str+"\n";	
			////////////(수정됨)
			vComment.add(saveRe);									////////////백터로 댓글값 저장(추가됨)
			for(int i=0; i<vComment.size();i++){					////////////백터크기만큼 저장된값 다시 출력
				String sum = vComment.get(i);
				taComment.append(sum);
			}
			Calendar cal = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기
			String saveCal = ""+cal.get(Calendar.YEAR)+"."+(cal.get(Calendar.MONTH) + 1)+"."
		    		+cal.get(Calendar.DAY_OF_MONTH)+"   "+cal.get(Calendar.HOUR_OF_DAY)+":"
		    		+cal.get(Calendar.MINUTE)+"\n"; 				////////////(수정됨)
			//taDate.append(saveCal);								////////////단순 입력되는거 주석처리
		    vCal.add(saveCal);
		    for(int i=0; i<vCal.size();i++){					////////////백터크기만큼 저장된값 다시 출력
				String sum = vCal.get(i);
				taDate.append(sum);
			}
		    
			tfRe.setText("");
			tfRe.requestFocus();
			
			
		}
	}
		
	
	public static void main(String[] args) {
		ProductPage pdp = new ProductPage();
		pdp.setSize(400,600);
		pdp.setVisible(true);
		
	}
	
	

}
