package My.project;
import static java.lang.System.out;
import static My.project.MyPart.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import My.project.MyPart;
 
public class MemberShip_Application extends Frame{
    
     Label lblId, lblPwd, lblName, lblHp, lblGen, lblHobby,lblJob,lblAddr,lblAge ;
     TextField txtId, txtPwd, txtName;
     TextField txtHp1, txtHp2, txtHp3;
     Checkbox cbMale,cbFeMale;
     Checkbox cbHobby1, cbHobby2, cbHobby3;
     Choice chJob;
     TextField txtAddr,txtAge;
     Button btnSubmit, btnCancel;
     Vector<Member> v1 = new Vector<Member>(5,3);
     //Vector<String> v2 = new Vector<String>(5,3);
    
     public MemberShip_Application() {
         
          super("회원가입");
          setLayout(null);
         
          lblId =new Label("아이디"); lblPwd=new Label("패스워드");
          lblName=new Label("이름"); lblHp=new Label("핸드폰");
          lblGen=new Label("성별"); lblHobby=new Label("취미");
          lblJob=new Label("직업"); lblAddr=new Label("주소");
          lblAge =new Label("나이");
         
          lblId.setBounds(20, 50, 100, 20);
          lblPwd.setBounds(20, 80, 100, 20);
          lblName.setBounds(20, 110, 100, 20);
          lblHp.setBounds(20, 140, 100 , 20);
          lblGen.setBounds(20, 170, 100, 20);
          lblHobby.setBounds(20, 200, 100, 20);
          lblJob.setBounds(20, 230, 100, 20);
          lblAddr.setBounds(20, 260, 100, 20);
          lblAge.setBounds(20, 290, 100, 20);
         
          add(lblId); add(lblPwd);
          add(lblName); add(lblHp);
          add(lblGen); add(lblHobby);
          add(lblJob); add(lblAddr);
          add(lblAge);
         
          txtId =new TextField(20); txtPwd =new TextField(20);
          txtName= new TextField(20);
          Label lblhipen1 = new Label("-");
          Label lblhipen2 = new Label("-");
          txtHp1 = new TextField(); txtHp2 = new TextField();
          txtHp3 = new TextField();
         
          Panel panGen = new Panel(new FlowLayout(FlowLayout.LEFT));
          Panel panHobby = new Panel(new FlowLayout(FlowLayout.LEFT));
    
          CheckboxGroup group = new CheckboxGroup();
          cbMale = new Checkbox("남자",group,true);
          cbFeMale = new Checkbox("여자",group,false);
         
          panGen.add(cbMale);
          panGen.add(cbFeMale);
          panGen.setBounds(120, 162, 100, 30);         
         
          cbHobby1 = new Checkbox("자전거");
          cbHobby2 = new Checkbox("컴퓨터");
          cbHobby3 = new Checkbox("독서");
          panHobby.add(cbHobby1);
          panHobby.add(cbHobby2);
          panHobby.add(cbHobby3);
         
          panHobby.setBounds(120, 192, 200, 30);
         
          chJob = new Choice();
          chJob.add("자바프로그래머");
          chJob.add("임베디드프로그래머");
          chJob.add("웹프로그래머");
          chJob.add("모바일프로그래머");
         
          txtAddr = new TextField();
          txtAge = new TextField();
         
          btnCancel = new Button("취소");       
          btnSubmit = new Button("가입완료");
          //btnCancel.setSize(150, 40 );
          //btnSubmit.setSize(150, 40);
         
          txtId.setBounds(120, 50, 150, 20);
          txtPwd.setBounds(120, 80, 150, 20);
          txtName.setBounds(120, 110, 150, 20);
          txtHp1.setBounds(120, 140, 60, 20);
          lblhipen1.setBounds(190, 140, 10, 20);
          txtHp2.setBounds(210, 140, 60, 20);
          lblhipen2.setBounds(275, 140, 10, 20);
          txtHp3.setBounds(290, 140, 60, 20);
                  
          chJob.setBounds(120,230, 150, 20);
          txtAddr.setBounds(120, 260, 150, 20);
          txtAge.setBounds(120, 290, 150, 20);
         
         
          Panel paButton = new Panel();
          paButton.add(btnSubmit);
          paButton.add(btnCancel);
          paButton.setBounds(0, 320, 370, 370);
             
          add(txtId);
          add(txtPwd);
          add(txtName);
          add(txtHp1);
          add(lblhipen1);
          add(txtHp2);
          add(lblhipen2);
          add(txtHp3);
          add(panGen);
          add(panHobby);
          add(chJob);
          add(txtAddr);
          add(txtAge);
          add(paButton);
         
          setSize(370, 370);
          setResizable(false);
          //setVisible(true);
          
          //add source code
          Member user1=new Member(); // Member 클래스 속성 가진 객체 user1 생성
		  Member user2=new Member();
		  
		  // id 테스트	  
		  for(int i=1;i<=10;i++){
				v1.add(new Member("test"+i, "i"));
		  }
		  
          btnSubmit.addActionListener(new ActionListener(){
        	  public void actionPerformed(ActionEvent e){
        		  
        		  user1.setId(txtId.getText());//ID 텍스트 값을 얻어와 user1의 setId 메소드를 통해 id 설정
        		  user2.setPwd(txtPwd.getText());//패스워드도 이하 동일
        		  //v1.add(user1);//아이디 값은 백터 v1에 추가
        		  
        		  //임의의 값을 설정해보자 벡터 v2는 String형만 저장하게 설정
        		  String str = "test";
        		  user1.setId(str);
        		  v1.add(user1);
        		  setTitle(v1.size()+" 명 등록됨");
        		  
        		 //벡터에 요소 꺼내오기 => Object get(int index), Object elementAt(int index)
        		  Object obj = v1.get(0);
        		  Member i=(Member)obj;
        		  out.println("i="+i); 
        		  
        		  
        	  }
        	  
          });
     }
    
     public static void main(String[] args) {
          new MemberShip_Application();
     }   
}
