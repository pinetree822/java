package net.tis.day0605;

import java.awt.Button;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Scanner;

import net.tis.common.Bank;
import net.tis.nc.Maple;



public class BankUser {

	
	public static void main(String[] args) {

		Scanner sc = null;
		Date dt = null;
		InputStream is = null;
		Button btnEnd = null;
		ServerSocket server = null;
		
		
		Bank bk= null;
		Maple mp = null;
		System.out.println("\nBankUser ��浿 �Ѹ��� �ı�");
		System.out.println("BankUser ��ġ ����� ������");
		
		Bank.input();
		Bank.output();
//		Bank.getTotal();// �������� ����
		
		Bank woori = new Bank();
		woori.getTotal();
//		Math.ran
	}// main()
	
}// class BankUser
