package co.kr.team.main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDiet extends JFrame implements ActionListener {
	JPanel mainP;
	JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13;
	JTextField tfId, tfPwd, tfName, tfAge, tfHp1, tfHp2, tfHp3, tfEmail1,
			tfEmail2, tfAddr, tfHeight, tfWeight, tfHopeWeight, tfWaist;
	JRadioButton rbSex1, rbSex2;
	JButton btnJoin, btnCancel, btnIdCh;

	public JoinDiet() {
		setTitle("ȸ������");
		mainP = new JPanel(new GridLayout(14, 1));
		add(mainP);

		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p10 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p11 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p12 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		p13 = new JPanel();

		mainP.add(p1);
		mainP.add(p2);
		mainP.add(p3);
		mainP.add(p4);
		mainP.add(p5);
		mainP.add(p6);
		mainP.add(p7);
		mainP.add(p8);
		mainP.add(p9);
		mainP.add(p10);
		mainP.add(p11);
		mainP.add(p12);
		mainP.add(p13);

		// p1 ����
		p1.add(new JLabel("*I             D : "));
		p1.add(tfId = new JTextField(10));
		btnIdCh = new JButton("I D �ߺ�üũ");
		btnIdCh.addActionListener(this);
		p1.add(btnIdCh);

		// p2 ����
		p2.add(new JLabel("*��й�ȣ: "));
		p2.add(tfPwd = new JTextField(14));

		// p3 ����
		p3.add(new JLabel("*��        �� : "));
		p3.add(tfName = new JTextField(8));

		// p4 ����
		p4.add(new JLabel("*��        �� : "));
		rbSex1 = new JRadioButton("��");
		rbSex2 = new JRadioButton("��");
		ButtonGroup bg = new ButtonGroup(); // Group ���� ���������� �ٿ��� �ϳ��� ���õ�.
		bg.add(rbSex1);
		bg.add(rbSex2);
		p4.add(rbSex1);
		p4.add(rbSex2);

		p5.add(new JLabel("*��        �� : "));
		p5.add(tfAge = new JTextField(3));

		p6.add(new JLabel("��  ��  �� : "));
		p6.add(tfHp1 = new JTextField(4));
		p6.add(new JLabel("-"));
		p6.add(tfHp2 = new JTextField(4));
		p6.add(new JLabel("-"));
		p6.add(tfHp3 = new JTextField(4));

		p7.add(new JLabel("Email       : "));
		p7.add(tfEmail1 = new JTextField(10));
		p7.add(new JLabel("@"));
		p7.add(tfEmail2 = new JTextField(14));

		p8.add(new JLabel("��         �� : "));
		p8.add(tfAddr = new JTextField(40));

		p9.add(new JLabel("*��        �� : "));
		p9.add(tfHeight = new JTextField(3));
		p9.add(new JLabel("cm"));

		p10.add(new JLabel("*ü        �� : "));
		p10.add(tfWeight = new JTextField(3));
		p10.add(new JLabel("kg"));

		p11.add(new JLabel("*���ü��: "));
		p11.add(tfHopeWeight = new JTextField(3));
		p11.add(new JLabel("kg"));

		p12.add(new JLabel("*�㸮�ѷ�: "));
		p12.add(tfWaist = new JTextField(3));
		p12.add(new JLabel("inch"));

		btnJoin = new JButton("�����ϱ�");
		btnCancel = new JButton("�������");
		btnJoin.addActionListener(this);
		btnCancel.addActionListener(this);
		p13.add(btnJoin);
		p13.add(btnCancel);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 500);
		setVisible(true);

	}// joinDiet

	public static void main(String[] args) {
		new JoinDiet();
	}// main

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin) {
			boolean b = checkData();
			if(b) {
				insertJoin();
				JOptionPane.showMessageDialog(this, "ȸ�������� �Ϸ�Ǿ����ϴ�.^^");
				clearView();
				}
		}//btnJoin
		
		if(e.getSource()==btnCancel) {
			clearView();
			JOptionPane.showMessageDialog(this, "ȸ�������� ��ҵǾ����ϴ�. lol");
		}
		
		if(e.getSource()==btnIdCh) {
			String id = tfId.getText();
			if(id.length()==0) {
				JOptionPane.showMessageDialog(this, "üũ �� ID�� �Է����ּ���");
				return;
			}
			boolean idDch = idCh();
			if(idDch) {
				JOptionPane.showMessageDialog(this, "��밡���� ID�Դϴ�.");
			}else {
				JOptionPane.showMessageDialog(this, "�ߺ��Ǵ� ID�� �ֽ��ϴ�.");
			}
		}
	}// actionPerformed
	
	private void insertJoin() {
		JoinDto dto = getDto();
		//JDBC ���α׷��� 5�ܰ�
		Connection con = null;
		PreparedStatement ps = null;
		con = getCon();
		String sql = "insert into joindiet(ID, PWD, NAME, SEX, AGE, HP, EMAIL, ADDR, HEIGHT, WEIGHT, HOPEWEIGHT, WAIST)"
		+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getSex());
			ps.setInt(5, dto.getAge());
			ps.setString(6, dto.getHp());
			ps.setString(7, dto.getEmail());
			ps.setString(8, dto.getAddr());
			ps.setInt(9, dto.getHeight());
			ps.setInt(10, dto.getWeight());
			ps.setInt(11, dto.getHopeweight());
			ps.setInt(12, dto.getWaist());
			int res = ps.executeUpdate();						// ����
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean idCh() {
		String id = tfId.getText();
		boolean ok = false;
		String sql = "select count(*) from joindiet where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);						// 1�� ù��° ��� �÷�
				if(cnt != 1) {									
					ok=true;									// ok = true => ��� ����
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//finally
		return ok;
	}

	private boolean checkData() {
		boolean ok = false;
		String id = tfId.getText();
		if(id.length()==0) {
			JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���!");
			tfId.requestFocus();															//���̵� Ŀ���� �д�
			return false;
		}
		
		String pwd = tfPwd.getText();
		if(pwd.length()==0) {
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է����ּ���!");
			tfPwd.requestFocus();															
			return false;
		}
		
		String name = tfName.getText();
		if(name.length()==0) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է����ּ���!");
			tfName.requestFocus();															
			return false;
		}
		
		boolean sex = rbSex1.isSelected() | rbSex2.isSelected();
		if(!sex) {
			JOptionPane.showMessageDialog(this, "������ �������ּ���!");
			return false;
		}
	
		String strAge = tfAge.getText();
		int age = 0;
		try {
			age = Integer.parseInt(strAge);
		}catch(NumberFormatException e) {
			JOptionPane.showConfirmDialog(this,"���̸� ���ڷ� �Է����ּ���!", "�޽���", 2, 1);
			tfAge.setText("");
			tfAge.requestFocus();
			return false;
		}
		
		String hp1 = tfHp1.getText();
		if(hp1.length()==0) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ ���ڸ� 3�ڸ��� �Է����ּ���!");
			tfHp1.requestFocus();	
			return false;
		}else if(hp1.length()>3) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ ���ڸ��� 3���ڱ����� �Է����ּ���!");
			tfHp1.requestFocus();	
			return false;
		}
		String hp2 = tfHp2.getText();
		if(hp2.length()==0) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ �߰��ڸ� 4�ڸ��� �Է����ּ���!");
			tfHp2.requestFocus();	
			return false;
		}else if(hp2.length()>4) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ �߰��ڸ��� 4���ڱ����� �Է����ּ���!");
			tfHp2.requestFocus();	
			return false;
		}
		String hp3 = tfHp3.getText();
		if(hp3.length()==0) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ ���ڸ� 4�ڸ��� �Է����ּ���!");
			tfHp3.requestFocus();	
			return false;
		}else if(hp3.length()>4) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ ���ڸ��� 4���ڱ����� �Է����ּ���!");
			tfHp3.requestFocus();	
			return false;
		}
		
		String email1 = tfEmail1.getText();
		if(email1.length()==0) {
			JOptionPane.showMessageDialog(this, "Email ���ڸ��� �Է����ּ���!");
			tfEmail1.requestFocus();	
			return false;
		}
		String email2 = tfEmail2.getText();
		if(email2.length()==0) {
			JOptionPane.showMessageDialog(this, "Email ���ڸ��� �Է����ּ���!");
			tfEmail2.requestFocus();	
			return false;
		}
		String email = tfEmail1.getText() + tfEmail2.getText();
		if(email.length()>30) {
			JOptionPane.showMessageDialog(this, "Email�� 30���ڳ��� �Է��ϼ���!");
			tfEmail1.setText("");
			tfEmail1.requestFocus();	
			return false;
		}
	
		String addr = tfAddr.getText();
		if(addr.length()==0) {
			JOptionPane.showMessageDialog(this, "�ּҸ� �Է��ϼ���!");
			tfAddr.requestFocus();
			return false;
		}else if(addr.length()>50) {
			JOptionPane.showMessageDialog(this, "�ּҴ� 50���� ���� �Է��ϼ���!");
			tfAddr.requestFocus();
			return false;
		}
		
		String strHeight = tfHeight.getText();
		int height = 0;
		try {
			height = Integer.parseInt(strHeight);
		}catch(NumberFormatException e) {
			JOptionPane.showConfirmDialog(this,"������ ���ڷ� �Է����ּ���!", "�޽���", 2, 1);
			tfHeight.setText("");
			tfHeight.requestFocus();
			return false;
		}
		
		String strWeight = tfWeight.getText();
		int weight = 0;
		try {
			weight = Integer.parseInt(strWeight);
		}catch(NumberFormatException e) {
			JOptionPane.showConfirmDialog(this,"ü���� ���ڷ� �Է����ּ���!", "�޽���", 2, 1);
			tfWeight.setText("");
			tfWeight.requestFocus();
			return false;
		}
		
		String strHopweight = tfHopeWeight.getText();
		int hopeweight = 0;
		try {
			hopeweight = Integer.parseInt(strHopweight);
		}catch(NumberFormatException e) {
			JOptionPane.showConfirmDialog(this,"���ü���� ���ڷ� �Է����ּ���!", "�޽���", 2, 1);
			tfHopeWeight.setText("");
			tfHopeWeight.requestFocus();
			return false;
		}
		
		String strWaist = tfWaist.getText();
		int waist = 0;
		try {
			waist = Integer.parseInt(strWaist);
		}catch(NumberFormatException e) {
			JOptionPane.showConfirmDialog(this,"�㸮�ѷ��� ���ڷ� �Է����ּ���!", "�޽���", 2, 1);
			tfWaist.setText("");
			tfWaist.requestFocus();
			return false;
		}		
		ok=true;
		return ok;
	}

	private void clearView() {
		// ID, PWD, NAME, SEX, AGE, HP, EMAIL, ADDR, HEIGHT, WEIGHT, HOPEWEIGHT, WAIST
		tfId.setText("");
		tfPwd.setText("");
		tfName.setText("");
		tfAge.setText("");
		tfHp1.setText("");
		tfHp2.setText("");
		tfHp3.setText("");
		tfEmail1.setText("");
		tfEmail2.setText("");
		tfAddr.setText("");
		tfHeight.setText("");
		tfWeight.setText("");
		tfHopeWeight.setText("");
		tfWaist.setText("");
	
	}

	private JoinDto getDto(){
	// ID, PWD, NAME, SEX, AGE, HP, EMAIL, ADDR, HEIGHT, WEIGHT, HOPEWEIGHT, WAIST
		String id = tfId.getText();
		String pwd = tfPwd.getText();
		String name = tfName.getText();
		String sex = null;
		if(rbSex1.isSelected()) {
			sex="��";
		}else { sex="��";}
		String strAge = tfAge.getText();
		int age = Integer.parseInt(strAge);
		String hp = tfHp1.getText() + "-" + tfHp2.getText() + "-" + tfHp3.getText();
		String email = tfEmail1.getText() + "@" + tfEmail2.getText();
		String addr = tfAddr.getText();
		String srtHeight = tfHeight.getText();
		int height = Integer.parseInt(srtHeight);
		String strWeight = tfWeight.getText();
		int weight = Integer.parseInt(strWeight);
		String srtHopeweight = tfHopeWeight.getText();
		int hopeweight = Integer.parseInt(srtHopeweight);
		String strWaist = tfWaist.getText();
		int waist = Integer.parseInt(strWaist);
		
		//DTO�� ���� 11���� ������ �����Ѵ�.
		JoinDto dto = new JoinDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setSex(sex);
		dto.setAge(age);
		dto.setHp(hp);
		dto.setEmail(email);
		dto.setAddr(addr);
		dto.setHeight(height);
		dto.setWeight(weight);
		dto.setHopeweight(hopeweight);
		dto.setWaist(waist);
		System.out.println("dto="+dto);
		
		return dto;
	} //getDto

	// �����ͺ��̽� ���� �޼ҵ�
	public Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "";
		String user = "";
		String password = "";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}// getCon

}// end