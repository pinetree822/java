package My.project;
import javax.swing.*;

import static My.project.InitScreen.*;
import static My.project.Join.*;
import static My.project.LoginScreen.*;
import static My.project.Member.*;
import static My.project.MemberShip_Application.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

import javax.swing.border.*;

import My.project.MyPart;

public class Show_main extends JFrame {
	public static String curr_ID="";
	InitScreen it;
	LoginScreen lg;
	//MemberShip_Application mb; -> ±¸ È¸¿ø°¡ÀÔ È­¸é(¾ÆÁ÷ Áö¿ìÁö ¸»°Í)
	Join jo;
	
	Show_main() {
		it = new InitScreen();
		lg = new LoginScreen();
		jo = new Join();
		
		MyHandler my = new MyHandler();
		//¹öÆ° ÀÌº¥Æ® ¸®½º³Ê »ı¼º.....................................
		it.start.addActionListener(my); // ÃÊ±âÈ­¸é ½ÃÀÛ¹öÆ°
		it.left.addActionListener(my); // ÃÊ±âÈ­¸é ¿ŞÂÊ¹öÆ°
		it.right.addActionListener(my); // ÃÊ±âÈ­¸é ¿À¸¥ÂÊ¹öÆ°
		lg.btn_join.addActionListener(my); // ·Î±×ÀÎ È­¸é ·Î±×ÀÎ ¹öÆ°
		lg.btn_ok.addActionListener(my); // ·Î±×ÀÎ È­¸é È¸¿ø°¡ÀÔ ¹öÆ°
		jo.btjoin.addActionListener(my); // È¸¿ø°¡ÀÔ È­¸é È¸¿ø°¡ÀÔ ¹öÆ°
		jo.btout.addActionListener(my); // È¸¿ø°¡ÀÔ È­¸é ³ª°¡±â ¹öÆ°
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	int i=5, j=0;

	class MyHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == it.start) {
				lg.pack();
				lg.setVisible(true);
				lg.setLocationRelativeTo(null);
				for(Member u : jo.v1){
					System.out.println(u.getId()+" ¾ÆÀÌµğ ºÒ·¯¿À´Â Áß");
					System.out.println(u.getPwd()+" ÆĞ½º¿öµå ºÒ·¯¿À´Â Áß");
				}
				
				it.setVisible(false);
								
			} else if (o==it.left) {
				try{
					j++;
					ImageIcon icon=it.vimg.get(j);
					it.initimg0=icon;
					it.p2.update(it.p2.getGraphics()); // p2 ÀÌ¹ÌÁö¸¸ º¯°æ
					//p2.repaint()¸¦ ÇßÀ» ¶§ p1¿¡ ÀÖ´Â graphics ±îÁö °Çµå¸²
					if(j==4){
						j=0;
					}
				}catch(java.lang.ArrayIndexOutOfBoundsException ex){
					System.out.println("ÀÌ¹ÌÁö¸¦ ÀúÀåÇÑ º¤ÅÍÀÇ ¹è¿­À» ¹ş¾î³µ½À´Ï´Ù");
				}
						
			} else if (o==it.right){
				try{
					i--;
					ImageIcon icon=it.vimg.get(i);
					it.initimg0=icon;
					it.p2.update(it.p2.getGraphics());
					if(i==0){
						i=5;
					}
				}catch(java.lang.ArrayIndexOutOfBoundsException ex){
					System.out.println("ÀÌ¹ÌÁö¸¦ ÀúÀåÇÑ º¤ÅÍÀÇ ¹è¿­À» ¹ş¾î³µ½À´Ï´Ù");
				}

			} else if (o == lg.btn_ok) {
				lg.setTitle("È¸¿ø°¡ÀÔ  ÆäÀÌÁö·Î ÀÌµ¿");
				jo.setVisible(true);
				jo.setLocationRelativeTo(null);
			} else if (o == lg.btn_join) {
				lg.setTitle("·Î±×ÀÎ È­¸é Á¢¼Ó");
				if(lg.id.getText().trim().equals("") || lg.pw.getText().trim().isEmpty() ){
					lg.setTitle("¾ÆÀÌµğ, ºñ¹Ğ¹øÈ£ ÀÔ·ÂÇØÁÖ¼¼¿ä");
					System.out.println("´Ù´Ù");
					return;
					}
				// ÀÌ°÷¿¡¼­ È¸¿ø°¡ÀÔ µ¥ÀÌÅÍ¿¡ ÀúÀåµÈ º¤ÅÍ °ªÀ» ºÒ·¯¿Í À¯È¿¼º °Ë»ç¸¦ ÇØ¾ßÇÑ´Ù
				// È®Àå for¹® - ¾ÆÀÌµğ Ã¼Å©
				if(jo.v1 != null) {
					System.out.println("v1.size=============="+jo.v1.size());
					for (Member u : jo.v1) {// Member Å¬·¡½º È®Àå for¹® º¯¼ö u : mbÀÇ º¤ÅÍ
						System.out.println(u.getId()+"<<<<<"+u.getPwd()+", lg=="+lg.id.getText()+"/"+lg.pw.getText());
											// v1
						if(u.getId().equals(lg.id.getText()) && u.getPwd().equals(lg.pw.getText())){
							curr_ID=lg.id.getText();
							lg.setTitle("È¸¿ø ÀÎÁõ");
							MyPart my = new MyPart();
							my.setLocation(0,0);
							my.setSize(1300,800);
			        		my.setVisible(true);
			        		lg.setVisible(false);
							return;
						}
						
						// ÃßÈÄ¿¡ ¸ŞÀÎÈ­¸éÀ¸·Î ³Ñ¾î°¡´Â ÀÌº¥Æ® Ã³¸® ÇØ¾ßÇÔ
						
					}
					lg.setTitle("ÀÎÁõ ½ÇÆĞ");
				}
			} else if (o == jo.btjoin){
				
				 Member user1=new Member();
				//id,pw °ªÀº º¤ÅÍ¿¡ ÀúÀåÇÏÀÚ
		        user1.setId(jo.tfid.getText().trim());
		        //user1.setPwd(tfpwd.getPassword().toString()); ¹®ÀÚ¿­·Î ¾È¹Ş°í ÁÖ¼Ò°ªÀ¸·Î ¹Ş¾Æ¼­ ¿À·ù³²
		        user1.setPwd(new String(jo.tfpwd.getPassword()));
		        jo.v1.add(user1);
		        //v1.add(new Member("test"+i, "i"));
		        setTitle(jo.v1.size()+" ¸í µî·ÏµÊ");

		        //º¤ÅÍÀÇ ¿ä¼ÒµéÀ» ²¨³»º¸ÀÚ
		        //v1.get(0) -> MemberÇü / v1.get(0).get(Id) -> StringÇü
		        Object obj=jo.v1.get(10).getId(); //v[10]ºÎÅÍ 
		        String str=(String)obj;
		        System.out.println(str);
	        	
				String name=jo.tfname.getText();
				String add=jo.tfadd.getText();
				String tel=jo.tftel.getText();
				String email=jo.tfemail.getText();
				
				if(jo.tfid.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "¾ÆÀÌµğ¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
					jo.tfid.requestFocus();
					return;
				}else if(String.valueOf(jo.tfpwd.getPassword()).equals("")){
		            JOptionPane.showMessageDialog(jo.tfname, "ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
		            return;
		        }else if(jo.tfname.getText().trim().isEmpty()){
		        	JOptionPane.showMessageDialog(jo.tfname, "ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä");
					jo.tfname.requestFocus();
					return;
				}else if(jo.tfadd.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "ÁÖ¼Ò¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
					jo.tfadd.requestFocus();
					return;
				}else if(jo.tftel.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
					jo.tftel.requestFocus();
					return;
				}else if(jo.tfemail.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "ÀÌ¸ŞÀÏÀ» ÀÔ·ÂÇÏ¼¼¿ä");
					jo.tfemail.requestFocus();
					return;
				} 
				
				int tp=0;
				
				// ÀÌ¸§ ÇÊµå¿¡´Â ÇÑ±Û¸¸ ÀÔ·ÂÇÒ ¼ö ÀÖµµ·Ï À¯È¿¼º Ã¼Å©
				try{
					if(jo.tfname.getText().matches(".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*")){
						System.out.println("ÇÑ±ÛÀ» ÀÔ·ÂÇß½À´Ï´Ù");
					}else{
						JOptionPane.showMessageDialog(jo.tfname, "ÀÌ¸§Àº ¹İµå½Ã ÇÑ±Û·Î ÀÔ·ÂÇÏ¼¼¿ä");
						jo.tfname.setText("");
						return;
					}
				}catch(PatternSyntaxException ex){
					// Á¤±Ô½Ä¿¡ ¿À·ù°¡ ÀÖ´Â °æ¿ì¿¡ ´ëÇÑ Ã³¸®
					System.err.println("An Exception Occured");
					ex.printStackTrace();
				}
				
				// ÀüÈ­¹øÈ£ ÇÊµå¿¡´Â ¼ıÀÚ¸¸ ÀÔ·ÂÇÒ ¼ö ÀÖµµ·Ï À¯È¿¼º Ã¼Å©
				try{
					tp=Integer.parseInt(tel.trim());
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(jo.tftel, "ÀüÈ­¹øÈ£´Â ¼ıÀÚ·Î ÇÕ½Ã´Ù");
					jo.tftel.setText("");
					return;
				}
				
				// ÀÌ¸ŞÀÏ Çü½Ä Ã¼Å©
				try{
					if(jo.tfemail.getText().matches("\\w+[@]\\w+\\.\\w+")){
						System.out.println("ÀÌ¸ŞÀÏ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇß½À´Ï´Ù");
					}else{
						JOptionPane.showMessageDialog(jo.tfemail, "Ç¥ÁØ ÀÌ¸ŞÀÏ Çü½Ä¿¡ ¸Â°Ô²û ÀÔ·ÂÇÏ¼¼¿ä");
						jo.tfemail.setText("");
						return;
					}
				}catch(PatternSyntaxException ex){
					System.err.println("An Exception Occured");
					ex.printStackTrace();
				}

				JOptionPane.showMessageDialog(jo.tfemail, "È¸¿ø°¡ÀÔÀÌ ¿Ï·á µÇ¾ú½À´Ï´Ù");
				jo.dispose();
				
			} else if(o == jo.btout){
				jo.dispose();
			}
		}
	}

	public static void main(String[] args) {
		new Show_main();
	}
}
