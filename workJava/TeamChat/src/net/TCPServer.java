package net;
import java.net.*;
import java.util.Random;

import javax.swing.JOptionPane;

import java.io.*;
/*
 * ������
 * 
	- ServerSocket�� Socket�� �ʿ�
	- Ŭ���̾�Ʈ �����ؿ��� "����� ����"�� ��������
	
 */


public class TCPServer {

	public static void main(String[] args) throws IOException {
		// 1. ���� ������ ���� => ������� ��Ʈ��ȣ �ʿ�
		ServerSocket server = new ServerSocket(5555);
		
		// 2. ���������� Ŭ���̾�Ʈ�� ������ ��ٸ�
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ�");
		
		// 3. Ŭ���̾� �����ؿ��� Ŭ���̾�Ʈ�� ����� ��� ��ü�� ��ȯ
		while(true){
			Socket sock = server.accept();
			/*
			 * Ŭ�� �����ؿ��⸦ ��ٸ��� �ִٰ� Ŭ�� �����ؿ���
			 * Ŭ�� ����� ���� ��ü�� ��ȯ�Ѵ�.
			 */
			System.out.println("Ŭ���̾�Ʈ�� �����߾��.!");
			InetAddress inet = sock.getInetAddress();// Ŭ�� �������ּ�			
			System.out.println("Ŭ�� IP : " + inet.getHostAddress());
			
			int num = new Random().nextInt(100) + 0;
			
			// ������ Ŭ���� ���� �����͸� ������.
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			
			dos.writeInt(num);
			dos.flush();
			
			// Ŭ�� ������ �޽����� ��� �ֿܼ� �������
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String msg = ""; 
			msg = dis.readUTF();
			System.out.println("From ClientX>>>" + msg);
			
			dos.close();
			os.close();
			
			//JOptionPane.showMessageDialog(null, msg);
			if( sock!=null ) sock.close(); // ��������
		}
		
		
		// 4. ������ ���� ���/�Է� ��Ʈ���� ���
		// �����͸� �ְ�޴´�.
		
		// 5. ���� ����
	}//

}//

/*
 * PC PORT üũ
		C:\Users\kodica07>netstat -na
		
		Ȱ�� ����
		
		  ��������  ���� �ּ�           �ܺ� �ּ�              ����
		  TCP    0.0.0.0:135            0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:445            0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:5357           0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:49152          0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:49153          0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:49154          0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:49155          0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:49179          0.0.0.0:0              LISTENING
		  TCP    0.0.0.0:49184          0.0.0.0:0              LISTENING
		  TCP    127.0.0.1:5939         0.0.0.0:0              LISTENING
		  TCP    127.0.0.1:5939         127.0.0.1:49957        ESTABLISHED
		  TCP    127.0.0.1:15292        0.0.0.0:0              LISTENING
		  TCP    127.0.0.1:20051        0.0.0.0:0              LISTENING
		  TCP    127.0.0.1:28091        0.0.0.0:0              LISTENING
		  TCP    127.0.0.1:28091        127.0.0.1:49541        ESTABLISHED
		  TCP    127.0.0.1:30051        0.0.0.0:0              LISTENING
		  TCP    127.0.0.1:49541        127.0.0.1:28091        ESTABLISHED
		  TCP    127.0.0.1:49957        127.0.0.1:5939         ESTABLISHED
		  TCP    127.0.0.1:49964        127.0.0.1:49965        ESTABLISHED
		  TCP    127.0.0.1:49965        127.0.0.1:49964        ESTABLISHED
		  TCP    127.0.0.1:50000        0.0.0.0:0              LISTENING
		  TCP    192.168.10.98:139      0.0.0.0:0              LISTENING
		  TCP    192.168.10.98:1521     0.0.0.0:0              LISTENING
		  TCP    192.168.10.98:2030     0.0.0.0:0              LISTENING
		  TCP    192.168.10.98:49214    110.76.143.225:5223    ESTABLISHED
		  TCP    192.168.10.98:49960    37.252.230.27:5938     ESTABLISHED
		  TCP    192.168.10.98:49967    37.252.244.3:5938      ESTABLISHED
		  TCP    192.168.10.98:51336    198.41.30.197:80       CLOSE_WAIT
		  TCP    192.168.10.98:51340    198.41.30.197:80       CLOSE_WAIT
		  TCP    192.168.10.98:51342    198.41.30.197:80       CLOSE_WAIT
		  TCP    192.168.10.98:51343    198.41.30.197:80       CLOSE_WAIT
		  TCP    192.168.10.98:51386    192.168.10.150:445     ESTABLISHED
		  TCP    192.168.10.98:51460    204.79.197.203:80      ESTABLISHED
		  TCP    192.168.10.98:51461    204.79.197.203:80      ESTABLISHED
		  TCP    192.168.10.98:51462    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51463    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51464    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51465    103.243.220.231:80     CLOSE_WAIT
		  TCP    192.168.10.98:51466    103.243.220.231:80     CLOSE_WAIT
		  TCP    192.168.10.98:51467    111.221.29.30:80       ESTABLISHED
		  TCP    192.168.10.98:51468    111.221.29.30:80       ESTABLISHED
		  TCP    192.168.10.98:51469    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51470    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51471    103.243.221.112:80     CLOSE_WAIT
		  TCP    192.168.10.98:51472    103.243.221.112:80     ESTABLISHED
		  TCP    192.168.10.98:51474    131.253.61.64:443      ESTABLISHED
		  TCP    192.168.10.98:51475    13.107.21.200:80       ESTABLISHED
		  TCP    192.168.10.98:51476    13.107.21.200:80       ESTABLISHED
		  TCP    192.168.10.98:51477    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51478    182.162.106.9:80       ESTABLISHED
		  TCP    192.168.10.98:51479    23.99.125.55:80        ESTABLISHED
		  TCP    192.168.10.98:51481    54.243.150.94:80       ESTABLISHED
		  TCP    192.168.10.98:51482    54.243.150.94:80       ESTABLISHED
		  TCP    192.168.10.98:51483    31.13.68.16:80         ESTABLISHED
		  TCP    192.168.10.98:51484    31.13.68.16:80         ESTABLISHED
		  TCP    192.168.10.98:51485    31.13.68.35:443        ESTABLISHED
		  TCP    192.168.10.98:51486    31.13.68.35:443        ESTABLISHED
		  TCP    192.168.10.98:51487    103.243.221.109:80     CLOSE_WAIT
		  TCP    192.168.10.98:51488    103.243.221.109:80     CLOSE_WAIT
		  TCP    192.168.10.98:51489    61.111.58.173:80       ESTABLISHED
		  TCP    192.168.10.98:51490    61.111.58.173:80       ESTABLISHED
		  TCP    192.168.10.98:51491    195.154.184.146:80     ESTABLISHED
		  TCP    192.168.10.98:51492    195.154.184.146:80     ESTABLISHED
		  TCP    192.168.10.98:51493    204.79.197.203:443     ESTABLISHED
		  TCP    192.168.10.98:51498    101.79.244.39:80       CLOSE_WAIT
		  TCP    192.168.10.98:51500    101.79.244.39:80       CLOSE_WAIT
		  TCP    192.168.10.98:51501    101.79.244.39:80       CLOSE_WAIT
		  TCP    192.168.10.98:51502    101.79.244.39:80       CLOSE_WAIT
		  TCP    192.168.10.98:51503    101.79.244.39:80       CLOSE_WAIT
		  TCP    192.168.10.98:51504    101.79.244.39:80       CLOSE_WAIT
		  TCP    192.168.10.98:51508    121.156.109.26:80      CLOSE_WAIT
		  TCP    192.168.10.98:51509    121.156.109.26:80      CLOSE_WAIT
		  TCP    192.168.10.98:51510    121.156.109.26:80      CLOSE_WAIT
		  TCP    192.168.10.98:51511    182.162.92.26:80       CLOSE_WAIT
		  TCP    192.168.10.98:51512    125.209.222.141:80     ESTABLISHED
		  TCP    192.168.10.98:51514    121.156.109.26:80      CLOSE_WAIT
		  TCP    192.168.10.98:51515    121.156.109.26:80      CLOSE_WAIT
		  TCP    192.168.10.98:51516    121.156.109.26:80      CLOSE_WAIT
		  TCP    192.168.10.98:51519    182.162.92.12:80       CLOSE_WAIT
		  TCP    192.168.10.98:51520    182.162.92.12:80       CLOSE_WAIT
		  TCP    192.168.10.98:51521    202.179.177.196:80     CLOSE_WAIT
		  TCP    192.168.10.98:51523    125.209.230.167:443    ESTABLISHED
		  TCP    192.168.10.98:51524    125.209.230.167:443    CLOSE_WAIT
		  TCP    192.168.10.98:51525    182.162.92.134:443     ESTABLISHED
		  TCP    192.168.10.98:51526    182.162.92.134:443     ESTABLISHED
		  TCP    192.168.10.98:51527    182.162.92.134:443     ESTABLISHED
		  TCP    192.168.10.98:51528    182.162.92.134:443     ESTABLISHED
		  TCP    192.168.10.98:51529    182.162.92.134:443     ESTABLISHED
		  TCP    192.168.10.98:51530    182.162.92.134:443     ESTABLISHED
		  TCP    192.168.10.98:51531    182.162.92.50:443      CLOSE_WAIT
		  TCP    192.168.10.98:51532    182.162.92.50:443      ESTABLISHED
		  TCP    192.168.10.98:51533    182.162.92.140:443     ESTABLISHED
		  TCP    192.168.10.98:51534    182.162.92.140:443     ESTABLISHED
		  TCP    192.168.10.98:51535    182.162.92.140:443     ESTABLISHED
		  TCP    192.168.10.98:51536    182.162.92.140:443     CLOSE_WAIT
		  TCP    192.168.10.98:51537    182.162.92.140:443     CLOSE_WAIT
		  TCP    192.168.10.98:51538    182.162.92.140:443     CLOSE_WAIT
		  TCP    192.168.10.98:51540    202.131.27.102:443     ESTABLISHED
		  TCP    192.168.10.98:51541    125.209.226.239:443    CLOSE_WAIT
		  TCP    192.168.10.98:51542    125.209.226.239:443    TIME_WAIT
		  TCP    192.168.10.98:51544    117.52.128.48:443      CLOSE_WAIT
		  TCP    192.168.10.98:51545    182.162.192.121:80     CLOSE_WAIT
		  TCP    [::]:135               [::]:0                 LISTENING
		  TCP    [::]:445               [::]:0                 LISTENING
		  TCP    [::]:5357              [::]:0                 LISTENING
		  TCP    [::]:49152             [::]:0                 LISTENING
		  TCP    [::]:49153             [::]:0                 LISTENING
		  TCP    [::]:49154             [::]:0                 LISTENING
		  TCP    [::]:49155             [::]:0                 LISTENING
		  TCP    [::]:49179             [::]:0                 LISTENING
		  TCP    [::]:49184             [::]:0                 LISTENING
		  TCP    [::1]:49165            [::]:0                 LISTENING
		  TCP    [::1]:49221            [::]:0                 LISTENING
		  TCP    [fe80::eda1:c483:93c5:7f53%11]:2030  [::]:0                 LISTENING
		  UDP    0.0.0.0:500            *:*
		  UDP    0.0.0.0:3702           *:*
		  UDP    0.0.0.0:3702           *:*
		  UDP    0.0.0.0:4500           *:*
		  UDP    0.0.0.0:5355           *:*
		  UDP    0.0.0.0:9876           *:*
		  UDP    0.0.0.0:58133          *:*
		  UDP    0.0.0.0:59406          *:*
		  UDP    127.0.0.1:1900         *:*
		  UDP    127.0.0.1:49767        *:*
		  UDP    127.0.0.1:53664        *:*
		  UDP    192.168.10.98:137      *:*
		  UDP    192.168.10.98:138      *:*
		  UDP    192.168.10.98:1900     *:*
		  UDP    192.168.10.98:5353     *:*
		  UDP    192.168.10.98:53663    *:*
		  UDP    [::]:500               *:*
		  UDP    [::]:3702              *:*
		  UDP    [::]:3702              *:*
		  UDP    [::]:4500              *:*
		  UDP    [::]:5355              *:*
		  UDP    [::]:9876              *:*
		  UDP    [::]:58134             *:*
		  UDP    [::]:59407             *:*
		  UDP    [::1]:1900             *:*
		  UDP    [::1]:5353             *:*
		  UDP    [::1]:53662            *:*
		  UDP    [fe80::eda1:c483:93c5:7f53%11]:1900  *:*
		  UDP    [fe80::eda1:c483:93c5:7f53%11]:53661  *:*
 * 
 */
