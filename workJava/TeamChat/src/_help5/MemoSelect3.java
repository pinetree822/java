package _help5;

import java.io.FileReader;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MemoSelect3 {
	public static void main(String[] args) 
			throws Exception
	{
		//�޸� ���̺��� ������ �������� (�ۼ���, �޸𳻿�, �ۼ���)
		
		FileReader fr=new FileReader("DB.properties");
		Properties p=new Properties();
		p.load(fr);
		
		Class.forName(p.getProperty("driver"));
		String url=p.getProperty("dburl");
		String user=p.getProperty("user");
		String pwd=p.getProperty("pwd");
		Connection con
		=DriverManager.getConnection(url,user,pwd);
		System.out.println("db���� ����");
		String name=JOptionPane.showInputDialog(
				"�˻��� �ۼ��ڸ� �Է��ϼ���");
		
		//ȫ�浿=> ȫ�浿�� �Է��� ���� � �ִ��� ����ϴ�
		//sql������ �ۼ�
		//"3���� ���� �ֽ��ϴ�", "�ۼ��� ���� �����ϴ�"
		String sql="SELECT count(idx) cnt FROM memo WHERE name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		boolean b=rs.next();//Ŀ�� �̵�
		if(b){
			//int count=rs.getInt(1);
			int count=rs.getInt("cnt");
			if(count<=0){
				System.out.println("�ۼ��� ���� �����!");
				return;
			}
			System.out.println(count+"���� ���� �ֽ��ϴ�.");
			
			//�ۼ���(ȫ�浿)�� �۵��� ������ ����ϼ���
			sql="SELECT idx, name, msg, wdate FROM memo";
			sql+=" WHERE name=? ORDER BY idx";
			PreparedStatement pstmt2
			=con.prepareStatement(sql);
			pstmt2.setString(1, name);
			ResultSet rs2=pstmt2.executeQuery();
			
			while(rs2.next()){
				int idx=rs2.getInt("idx");
				String name2=rs2.getString("name");
				String msg=rs2.getString("msg");
				Date wdate=rs2.getDate("wdate");
				System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
			}
			rs2.close();
			pstmt2.close();
			
		}//if-------------------------
		rs.close();
		pstmt.close();
		con.close();
	}

}













