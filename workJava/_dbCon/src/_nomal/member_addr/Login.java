package _nomal.member_addr;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener, ItemListener{
	JLabel l_driver, l_ip, l_port, l_db, l_id, l_passwd;
	JTextField txt_ip, txt_port, txt_db, txt_id, txt_passwd;
	Choice ch_driver;
	JButton bt_login, bt_cancel;
	JPanel label_panel, select_panel , button_panel;
	String driver, url, id, passwd;
	Connection con;
	
	public Login(){
		l_driver = new JLabel("Driver"); 
		l_ip = new JLabel("IP"); 
		l_port = new JLabel("Port"); 
		l_db = new JLabel("DataBase");
		l_id = new JLabel("ID");
		l_passwd = new JLabel("PassWord");
		
		txt_ip = new JTextField(30);
		txt_port = new JTextField(30);
		txt_db = new JTextField(30);
		txt_id = new JTextField(30);
		txt_passwd = new JTextField(30);

		ch_driver = new Choice();
		ch_driver.add("접속할 데이터베이스를 선택하세요");
		ch_driver.add("Oracle");
		ch_driver.add("MySql");
		
		bt_login = new JButton("연결");
		bt_cancel=new JButton("취소");
		
		label_panel=new JPanel();
		select_panel= new JPanel();
		button_panel = new JPanel();
	
		label_panel.setPreferredSize(new Dimension(100, 200));
		select_panel.setPreferredSize(new Dimension(300, 200));
		button_panel.setPreferredSize(new Dimension(400, 50));
		
		label_panel.setLayout(new GridLayout(6,1,10,10));
		select_panel.setLayout(new GridLayout(6,1,10,10));

		label_panel.add(l_driver);
		label_panel.add(l_ip);
		label_panel.add(l_port);
		label_panel.add(l_db);
		label_panel.add(l_id);
		label_panel.add(l_passwd);
		
		select_panel.add(ch_driver);
		select_panel.add(txt_ip);
		select_panel.add(txt_port);
		select_panel.add(txt_db);
		select_panel.add(txt_id);
		select_panel.add(txt_passwd);
		
		button_panel.add(bt_login);
		button_panel.add(bt_cancel);
		
		add(label_panel, BorderLayout.WEST);
		add(select_panel, BorderLayout.CENTER);
		add(button_panel, BorderLayout.SOUTH);	
		
		bt_login.addActionListener(this);
		bt_cancel.addActionListener(this);
				
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		//윈도우 종료시
		this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}); // end windowListner

		ch_driver.addItemListener(this);
		
		pack();		
		this.setLocation( ((this.getToolkit().getScreenSize()).width - this.getWidth())/2,  ((this.getToolkit().getScreenSize()).height - this.getHeight())/2);
		setVisible(true);
		
			
	}	

	/* 오라클 이나 mysql이냐에 따라 주소 완성~!
	 * DBMS선택에 따라 필요한 데이터가 여러개(ip, port, id, 등등)이므로 반환형은 맵(hash map)으로 하자!(데이터를 주머니에 넣고 다니면 더 간편하죠?)
		선택한 item의 index 에 따라 알맞는 DBMS 정보를 생성하여 맵으로 반환해주는 메서드에요~
		이 메서드를 호출하는 방법은 다음과 같아요~
		(인수1) index : 선택한 choice 컴포넌트 index 값 즉 어떤 DBMS 를 원하느냐~~를 결정^^
		(인수2) ip : 선택한 DBMS 접속에 사용할 ip , 만일 디폴트 주소를 원하면 null 을 넘김 
		(인수3) port : 선택한 DBMS 에 사용할 port 번호, 만일 디폴트 포트번호를 원하면 null 을 넘김
		(인수4) dbname : 선택한 DBMS 에 사용할 DB이름 ,  만일 디폴트 디비명을 원하면 null 을 넘김
		(인수5) id : 선택한 DBMS 에 사용할 아이디 , 만일 디폴트 아이디를 원하면 null 을 넘김
		(인수6) pass : 선택한 DBMS 에 사용할 비밀번호, 만일 디폴트 비번을 원하면 null 을 넘김*/
	public HashMap<String,String> getDBMStype(int index,String ip, String port, String dbname,String id,String pass){
		HashMap<String,String> map=new HashMap<String,String>();
		
		//아무것도 선택하지 않음 
		if(index==0){
			map.put("driver", "");
			//3항연산자 사용.. ip값이 널일때 아닐때~~로. 조건 2개니까..
			map.put("ip", ip=(ip==null)? "":ip); 
			map.put("port", port=(port==null)? "":port);
			map.put("dbname", dbname=(dbname==null)? "":dbname);
			map.put("id", id=(id==null)? "":id);
			map.put("pass", pass=(pass==null)? "":pass);
			url="";
		}
		
		//오라클을 선택함 
		if(index==1){
			map.put("driver", "oracle.jdbc.driver.OracleDriver");
			map.put("ip", ip=(ip==null)? "localhost":ip);
			map.put("port", port=(port==null)? "1521":port);
			map.put("dbname", dbname=(dbname==null)? "orcl":dbname);
			map.put("id", id=(id==null)? "scott":id);
			map.put("pass", pass=(pass==null)? "tiger":pass);
			
			url="jdbc:oracle:thin:"+"@"+ip+":"+port+":"+dbname;
		}
		
		//MySQL을 선택함
		if(index==2){
			map.put("driver", "com.mysql.jdbc.Driver");
			map.put("ip", ip=(ip==null)? "localhost":ip);
			map.put("port", port=(port==null)? "3306":port);
			map.put("dbname", dbname=(dbname==null)? "bitna":dbname);
			map.put("id", id=(id==null)? "root":id);
			map.put("pass", pass=(pass==null)? "apmsetup":pass);
			
			url="jdbc:mysql:"+"//"+ip+":"+port+"/"+dbname;
		}

		//드라이버 멤버변수에 현재 사용할 DBMS의 드라이버 정보 대입~!!
		driver=map.get("driver");
		
		//텍스트 컴포넌트에 출력	(입력편의성을 위해 출력해주자~ ㅎㅎㅎ)
		txt_ip.setText(ip);
		txt_port.setText(port);
		txt_db.setText(dbname);
		txt_id.setText(id);
		txt_passwd.setText(pass);		
		return map;
	}
	
	public void itemStateChanged(ItemEvent e) {
		/*초이스 컴포넌트에서 DBMS 선택시 디폴트로 보여질 정보는 아무것도 넘길 필요가 없음.. 
		 * 인덱스 번호만 넘겨서 값을 체우자~!
		 		로그인 버튼 누를시에 접속 정보를  정보를 넘기자 */
		getDBMStype(ch_driver.getSelectedIndex(),null, null, null,null,null);
	}	
	
	/*유효성 검사
	 * 유효하지 않은 조건을 만날 경우 경우 더 이상 실행부가 진행되지 않도록 return 으로 처리했어요.
	 * 검사시 메세지 띄우고 하는것도 이 안에서 다 해주자~ 그럼 반환형은 필요없으니까 void가 되겠죠? 난 반환형 보이드인 메서드가 젤 좋더라>_<*/
	public void check(){		
		//아이피 유효성 검사
		if(txt_ip.getText()==null || txt_ip.getText().length()==0||txt_ip.getText().length()>40){
			JOptionPane.showMessageDialog(getParent(), "아이피를 정확히 입력해주세요(ex)192.168.0.1 또는 localhost");
			txt_ip.setText("");
			txt_ip.requestFocus();
			return;
		}
		if (txt_port.getText()==null || txt_port.getText().length()==0||txt_port.getText().length()>4 || txt_port.getText().matches("[0-9]")){
			JOptionPane.showMessageDialog(getParent(), "포트번호를 정확히 입력해주세요.");
			txt_port.setText("");
			txt_port.requestFocus();
			return;
		}
		if (txt_db.getText()==null || txt_db.getText().length()==0||txt_db.getText().length()>20){
			JOptionPane.showMessageDialog(getParent(), "데이터베이스를 정확히 입력해주세요.");
			txt_port.setText("");
			txt_port.requestFocus();						
			return;
		}
		if (txt_id.getText()==null || txt_id.getText().length()==0||txt_id.getText().length()>20){
			JOptionPane.showMessageDialog(getParent(), "아이디를 정확히 입력해주세요.");
			txt_port.setText("");
			txt_port.requestFocus();						
			return;
		}
		if (txt_passwd.getText()==null || txt_ip.getText().length()==0||txt_ip.getText().length()>20){
			JOptionPane.showMessageDialog(getParent(), "비밀번호를 정확히 입력해주세요.");
			txt_port.setText("");
			txt_port.requestFocus();
			return;
		}
		
		getDBMStype(ch_driver.getSelectedIndex(),txt_ip.getText(), txt_port.getText(), txt_db.getText(),txt_id.getText(),txt_passwd.getText());
		System.out.println("url is "+url);
		
		
		//자바스크립트 처럼, 유효성을 모두 무사히 마친 경우만 아래의 접속 기회를 줘야죠~~? 
		connect();
	}		
		
	/*---------------------------------------------------------------------------------------------------
	 * 접속시도 메소드
	 * 접속시도 메서드에서 접속을 시도했는지 여부를 반환해주는 것도 좋지만 , 
	 * 어차피 접속을 성공하게 되면 con 이 null이 아니라 특정 주소값이 들어있을 것이기 때문에 
	 * 멤버 변수인 con 을 사용하는 다른 코드에서 con이 null 인지 , 아닌지 판단하면서 로직을 작성하면 되기 때문에
	 *  현재 메서드는 void 로 갑니다.
	 * 예를 들면, 아래 actionPerformed 메서드에서 로그인 버튼을 누를때 con 의 현재 상태를 파악해가면서 로직을 작성하면 되겠죠?^__^ 
	---------------------------------------------------------------------------------------------------*/
	public String connect() {
		id=txt_id.getText();
		passwd=txt_passwd.getText();
		
		try {
			// 접속 드라이버 로드
			Class.forName(driver);
			System.out.println(driver);
			// 접속 시도
			con = DriverManager.getConnection(url, id, passwd);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return driver;
	}

		
	//버튼 이벤트 구현
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj.equals(bt_login)){
			check();			
			//접속이 성공했다면 ~~
			if(con!=null){
				//member를 생성할때 로그인 정보를 넘겨주자~~
				if(connect().equals("oracle.jdbc.driver.OracleDriver")){
					Member_ora m=new Member_ora(this); 
				}
				if(connect().equals("com.mysql.jdbc.Driver")){
					Member m = new Member(this);
				}
				this.setVisible(false);
			}
		}
		
		if(obj.equals(bt_cancel)){
			System.exit(0);
		}
	}	

	public static void main(String[] args) {
		new Login();
	}

}
