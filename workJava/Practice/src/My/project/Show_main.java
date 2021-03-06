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
	//MemberShip_Application mb; -> 구 회원가입 화면(아직 지우지 말것)
	Join jo;
	
	Show_main() {
		it = new InitScreen();
		lg = new LoginScreen();
		jo = new Join();
		
		MyHandler my = new MyHandler();
		//버튼 이벤트 리스너 생성.....................................
		it.start.addActionListener(my); // 초기화면 시작버튼
		it.left.addActionListener(my); // 초기화면 왼쪽버튼
		it.right.addActionListener(my); // 초기화면 오른쪽버튼
		lg.btn_join.addActionListener(my); // 로그인 화면 로그인 버튼
		lg.btn_ok.addActionListener(my); // 로그인 화면 회원가입 버튼
		jo.btjoin.addActionListener(my); // 회원가입 화면 회원가입 버튼
		jo.btout.addActionListener(my); // 회원가입 화면 나가기 버튼
				
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
					System.out.println(u.getId()+" 아이디 불러오는 중");
					System.out.println(u.getPwd()+" 패스워드 불러오는 중");
				}
				
				it.setVisible(false);
								
			} else if (o==it.left) {
				try{
					j++;
					ImageIcon icon=it.vimg.get(j);
					it.initimg0=icon;
					it.p2.update(it.p2.getGraphics()); // p2 이미지만 변경
					//p2.repaint()를 했을 때 p1에 있는 graphics 까지 건드림
					if(j==4){
						j=0;
					}
				}catch(java.lang.ArrayIndexOutOfBoundsException ex){
					System.out.println("이미지를 저장한 벡터의 배열을 벗어났습니다");
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
					System.out.println("이미지를 저장한 벡터의 배열을 벗어났습니다");
				}

			} else if (o == lg.btn_ok) {
				lg.setTitle("회원가입  페이지로 이동");
				jo.setVisible(true);
				jo.setLocationRelativeTo(null);
			} else if (o == lg.btn_join) {
				lg.setTitle("로그인 화면 접속");
				if(lg.id.getText().trim().equals("") || lg.pw.getText().trim().isEmpty() ){
					lg.setTitle("아이디, 비밀번호 입력해주세요");
					System.out.println("다다");
					return;
					}
				// 이곳에서 회원가입 데이터에 저장된 벡터 값을 불러와 유효성 검사를 해야한다
				// 확장 for문 - 아이디 체크
				if(jo.v1 != null) {
					System.out.println("v1.size=============="+jo.v1.size());
					for (Member u : jo.v1) {// Member 클래스 확장 for문 변수 u : mb의 벡터
						System.out.println(u.getId()+"<<<<<"+u.getPwd()+", lg=="+lg.id.getText()+"/"+lg.pw.getText());
											// v1
						if(u.getId().equals(lg.id.getText()) && u.getPwd().equals(lg.pw.getText())){
							curr_ID=lg.id.getText();
							lg.setTitle("회원 인증");
							MyPart my = new MyPart();
							my.setLocation(0,0);
							my.setSize(1300,800);
			        		my.setVisible(true);
			        		lg.setVisible(false);
							return;
						}
						
						// 추후에 메인화면으로 넘어가는 이벤트 처리 해야함
						
					}
					lg.setTitle("인증 실패");
				}
			} else if (o == jo.btjoin){
				
				 Member user1=new Member();
				//id,pw 값은 벡터에 저장하자
		        user1.setId(jo.tfid.getText().trim());
		        //user1.setPwd(tfpwd.getPassword().toString()); 문자열로 안받고 주소값으로 받아서 오류남
		        user1.setPwd(new String(jo.tfpwd.getPassword()));
		        jo.v1.add(user1);
		        //v1.add(new Member("test"+i, "i"));
		        setTitle(jo.v1.size()+" 명 등록됨");

		        //벡터의 요소들을 꺼내보자
		        //v1.get(0) -> Member형 / v1.get(0).get(Id) -> String형
		        Object obj=jo.v1.get(10).getId(); //v[10]부터 
		        String str=(String)obj;
		        System.out.println(str);
	        	
				String name=jo.tfname.getText();
				String add=jo.tfadd.getText();
				String tel=jo.tftel.getText();
				String email=jo.tfemail.getText();
				
				if(jo.tfid.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "아이디를 입력하세요");
					jo.tfid.requestFocus();
					return;
				}else if(String.valueOf(jo.tfpwd.getPassword()).equals("")){
		            JOptionPane.showMessageDialog(jo.tfname, "비밀번호를 입력하세요");
		            return;
		        }else if(jo.tfname.getText().trim().isEmpty()){
		        	JOptionPane.showMessageDialog(jo.tfname, "이름을 입력하세요");
					jo.tfname.requestFocus();
					return;
				}else if(jo.tfadd.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "주소를 입력하세요");
					jo.tfadd.requestFocus();
					return;
				}else if(jo.tftel.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "전화번호를 입력하세요");
					jo.tftel.requestFocus();
					return;
				}else if(jo.tfemail.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(jo.tfname, "이메일을 입력하세요");
					jo.tfemail.requestFocus();
					return;
				} 
				
				int tp=0;
				
				// 이름 필드에는 한글만 입력할 수 있도록 유효성 체크
				try{
					if(jo.tfname.getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
						System.out.println("한글을 입력했습니다");
					}else{
						JOptionPane.showMessageDialog(jo.tfname, "이름은 반드시 한글로 입력하세요");
						jo.tfname.setText("");
						return;
					}
				}catch(PatternSyntaxException ex){
					// 정규식에 오류가 있는 경우에 대한 처리
					System.err.println("An Exception Occured");
					ex.printStackTrace();
				}
				
				// 전화번호 필드에는 숫자만 입력할 수 있도록 유효성 체크
				try{
					tp=Integer.parseInt(tel.trim());
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(jo.tftel, "전화번호는 숫자로 합시다");
					jo.tftel.setText("");
					return;
				}
				
				// 이메일 형식 체크
				try{
					if(jo.tfemail.getText().matches("\\w+[@]\\w+\\.\\w+")){
						System.out.println("이메일 형식에 맞게 입력했습니다");
					}else{
						JOptionPane.showMessageDialog(jo.tfemail, "표준 이메일 형식에 맞게끔 입력하세요");
						jo.tfemail.setText("");
						return;
					}
				}catch(PatternSyntaxException ex){
					System.err.println("An Exception Occured");
					ex.printStackTrace();
				}

				JOptionPane.showMessageDialog(jo.tfemail, "회원가입이 완료 되었습니다");
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
