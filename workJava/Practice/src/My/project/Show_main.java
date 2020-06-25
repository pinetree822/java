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
	//MemberShip_Application mb; -> �� ȸ������ ȭ��(���� ������ ����)
	Join jo;
	
	Show_main() {
		it = new InitScreen();
		lg = new LoginScreen();
		jo = new Join();
		
		MyHandler my = new MyHandler();
		//��ư �̺�Ʈ ������ ����.....................................
		it.start.addActionListener(my); // �ʱ�ȭ�� ���۹�ư
		it.left.addActionListener(my); // �ʱ�ȭ�� ���ʹ�ư
		it.right.addActionListener(my); // �ʱ�ȭ�� �����ʹ�ư
		lg.btn_join.addActionListener(my); // �α��� ȭ�� �α��� ��ư
		lg.btn_ok.addActionListener(my); // �α��� ȭ�� ȸ������ ��ư
		jo.btjoin.addActionListener(my); // ȸ������ ȭ�� ȸ������ ��ư
		jo.btout.addActionListener(my); // ȸ������ ȭ�� ������ ��ư
				
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
					System.out.println(u.getId()+" ���̵� �ҷ����� ��");
					System.out.println(u.getPwd()+" �н����� �ҷ����� ��");
				}
				
				it.setVisible(false);
								
			} else if (o==it.left) {
				try{
					j++;
					ImageIcon icon=it.vimg.get(j);
					it.initimg0=icon;
					it.p2.update(it.p2.getGraphics()); // p2 �̹����� ����
					//p2.repaint()�� ���� �� p1�� �ִ� graphics ���� �ǵ帲
					if(j==4){
						j=0;
					}
				}catch(java.lang.ArrayIndexOutOfBoundsException ex){
					System.out.println("�̹����� ������ ������ �迭�� ������ϴ�");
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
					System.out.println("�̹����� ������ ������ �迭�� ������ϴ�");
				}

			} else if (o == lg.btn_ok) {
				lg.setTitle("ȸ������  �������� �̵�");
				jo.setVisible(true);
				jo.setLocationRelativeTo(null);
			} else if (o == lg.btn_join) {
				lg.setTitle("�α��� ȭ�� ����");
				if(lg.id.getText().trim().equals("") || lg.pw.getText().trim().isEmpty() ){
					lg.setTitle("���̵�, ��й�ȣ �Է����ּ���");
					System.out.println("�ٴ�");
					return;
					}
				// �̰����� ȸ������ �����Ϳ� ����� ���� ���� �ҷ��� ��ȿ�� �˻縦 �ؾ��Ѵ�
				// Ȯ�� for�� - ���̵� üũ
				if(jo.v1 != null) {
					System.out.println("v1.size=============="+jo.v1.size());
					for (Member u : jo.v1) {// Member Ŭ���� Ȯ�� for�� ���� u : mb�� ����
						System.out.println(u.getId()+"<<<<<"+u.getPwd()+", lg=="+lg.id.getText()+"/"+lg.pw.getText());
											// v1
						if(u.getId().equals(lg.id.getText()) && u.getPwd().equals(lg.pw.getText())){
							curr_ID=lg.id.getText();
							lg.setTitle("ȸ�� ����");
							MyPart my = new MyPart();
							my.setLocation(0,0);
							my.setSize(1300,800);
			        		my.setVisible(true);
			        		lg.setVisible(false);
							return;
						}
						
						// ���Ŀ� ����ȭ������ �Ѿ�� �̺�Ʈ ó�� �ؾ���
						
					}
					lg.setTitle("���� ����");
				}
			} else if (o == jo.btjoin){
				
				 Member user1=new Member();
				//id,pw ���� ���Ϳ� ��������
		        user1.setId(jo.tfid.getText().trim());
		        //user1.setPwd(tfpwd.getPassword().toString()); ���ڿ��� �ȹް� �ּҰ����� �޾Ƽ� ������
		        user1.setPwd(new String(jo.tfpwd.getPassword()));
		        jo.v1.add(user1);
		        //v1.add(new Member("test"+i, "i"));
		        setTitle(jo.v1.size()+" �� ��ϵ�");

		        //������ ��ҵ��� ��������
		        //v1.get(0) -> Member�� / v1.get(0).get(Id) -> String��
		        Object obj=jo.v1.get(10).getId(); //v[10]���� 
		        String str=(String)obj;
		        System.out.println(str);
	        	
				String name=jo.tfname.getText();
				String add=jo.tfadd.getText();
				String tel=jo.tftel.getText();
				String email=jo.tfemail.getText();
				
				if(jo.tfid.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "���̵� �Է��ϼ���");
					jo.tfid.requestFocus();
					return;
				}else if(String.valueOf(jo.tfpwd.getPassword()).equals("")){
		            JOptionPane.showMessageDialog(jo.tfname, "��й�ȣ�� �Է��ϼ���");
		            return;
		        }else if(jo.tfname.getText().trim().isEmpty()){
		        	JOptionPane.showMessageDialog(jo.tfname, "�̸��� �Է��ϼ���");
					jo.tfname.requestFocus();
					return;
				}else if(jo.tfadd.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "�ּҸ� �Է��ϼ���");
					jo.tfadd.requestFocus();
					return;
				}else if(jo.tftel.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "��ȭ��ȣ�� �Է��ϼ���");
					jo.tftel.requestFocus();
					return;
				}else if(jo.tfemail.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "�̸����� �Է��ϼ���");
					jo.tfemail.requestFocus();
					return;
				} 
				
				int tp=0;
				
				// �̸� �ʵ忡�� �ѱ۸� �Է��� �� �ֵ��� ��ȿ�� üũ
				try{
					if(jo.tfname.getText().matches(".*[��-����-�Ӱ�-�R]+.*")){
						System.out.println("�ѱ��� �Է��߽��ϴ�");
					}else{
						JOptionPane.showMessageDialog(jo.tfname, "�̸��� �ݵ�� �ѱ۷� �Է��ϼ���");
						jo.tfname.setText("");
						return;
					}
				}catch(PatternSyntaxException ex){
					// ���ԽĿ� ������ �ִ� ��쿡 ���� ó��
					System.err.println("An Exception Occured");
					ex.printStackTrace();
				}
				
				// ��ȭ��ȣ �ʵ忡�� ���ڸ� �Է��� �� �ֵ��� ��ȿ�� üũ
				try{
					tp=Integer.parseInt(tel.trim());
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(jo.tftel, "��ȭ��ȣ�� ���ڷ� �սô�");
					jo.tftel.setText("");
					return;
				}
				
				// �̸��� ���� üũ
				try{
					if(jo.tfemail.getText().matches("\\w+[@]\\w+\\.\\w+")){
						System.out.println("�̸��� ���Ŀ� �°� �Է��߽��ϴ�");
					}else{
						JOptionPane.showMessageDialog(jo.tfemail, "ǥ�� �̸��� ���Ŀ� �°Բ� �Է��ϼ���");
						jo.tfemail.setText("");
						return;
					}
				}catch(PatternSyntaxException ex){
					System.err.println("An Exception Occured");
					ex.printStackTrace();
				}

				JOptionPane.showMessageDialog(jo.tfemail, "ȸ�������� �Ϸ� �Ǿ����ϴ�");
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
