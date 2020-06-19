package chat.serverClientLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

// ������ ���� - �������� ���
public class GuSHandle extends Thread{

	GuServer gServer = null;	// GuServer ��ü - ���� ����
	Socket sock = null;			// Socket ��ü - ��ſ��� ����
	PrintWriter pw = null;		// PrintWriter ��ü - ����Ʈ ����
	BufferedReader br = null;	// InputStreamReader�� ���� ����Ÿ�� BufferedReader�� �о ó��
	
	
	// �Լ���� - ��� �����ڿ��� �����޼����� �����ش�.
	private void broadcast(String sMsg) {
		// �迭 - ä�������� ��� ���� ����� - ������ü���� ��ü ����
		int userCnt = gServer.user.size();// ������ ����� Vector�迭 ����޸� ��� - ����� ����
		
		//**********// ��������� ����ڿ� �ش��ϴ� ���͸޸� ����
		for(int i=0; i<userCnt; i++) {
			// ������ �����  Vector�޸��� user�����迭�� ���� Ŭ���̾�Ʈ������ ��ü���� ����Ѵ�.
			GuSHandle ghandle = (GuSHandle) gServer.user.elementAt(i); 
			ghandle.pw.println(sMsg);
			ghandle.pw.flush();// �޼����� �׿� ���ڵ��� ��� ���
		}// for
	}// broadcast()
	
	
	
	
	// �Լ���� - GuSHandle ����� �ʱ�ȭ : ��� ���� ���� ������(���� ��ü, ��ż��ϰ����� ��ü)
	// ��ü(����, ��ż��ϰ�����)��  GuSHandle��ü ������ �� �����Ѵ�.
	public GuSHandle(GuServer gServer, Socket sock) {
		this.gServer = gServer;	// ���� ����
		this.sock = sock;		// ��ż��ϰ����� ����
		
		// ������ ���� ������ Ŭ���̾�Ʈ ��� ����
		try {
			// Ŭ���̾�Ʈ���� ���� ����Ÿ�� ó���ϴ� ����
			InputStream is = sock.getInputStream();// sock��Ű����ڸ� ���� ����Ÿ ����
			br = new BufferedReader(new InputStreamReader(is));// ���۷� �о �ٽ� ó��
			
			// �������� ����Ÿ�� �簡���Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ���� ���
			OutputStream os = sock.getOutputStream();// sock�� ��ŵ���Ÿ ����
			pw = new PrintWriter(new OutputStreamWriter(os));// ��� - �޼��� ����ڵ� : ���� ���ڵ��� ����ϴ� ��ü ����
			
		} catch (Exception e) {
			e.printStackTrace();// ���� �߻��� ���
		}// try
		
	}// GuSHandle()
	
	
	
	
	// �Լ���� - ������ ��� : ���������� ����� ���ӹ� �޼��� ������ broadcast()���� 
	@Override
	public void run() {// ������ ����
//		super.run();
		String nickname = null; // �г���(����) ����
		
		try {
			
			nickname = br.readLine();// �Էµ� ���ۿ��� ó������ �Ѷ��� �о nickname�� ����
			
			// ������ �α� �˸�
			gServer.setMsg("[" + nickname + "]�� ����\n");// gServer�� setMsg()�� �ؽ�Ʈ�� ����
			// ä��â�� �ڵ����� �˸�
			broadcast(nickname + ":>�� ���� �ϼ̽��ϴ�.\n");// Ŭ���̾�Ʈ�� �ؽ�Ʈ�� ������.
			
			///////////////// ä�� ��ȭ ���� /////////////////////////////////////////////
			//////////////// ä���߿� ���� ( quit /Quit /<��ư����> );
			while(true) {
				
				try {
					String text = br.readLine();// �Էµ� ���ۿ��� �Ѷ��� �о text�� ����
					
					// ������ �α� �˸�
					gServer.setMsg(text + ":> " + text + "\n");// gServer�� setMsg()�� �ؽ�Ʈ�� ����
					// ä��â�� �޼��� �˸�
					broadcast(nickname + ":> " + text);// Ŭ���̾�Ʈ�� �ؽ�Ʈ�� ������.
					
				// ä�� �� �����޼���
				} catch(Exception e1) {}// try
				
			}// while
			//////////////// ä���߿� ���� ( quit /Quit /<��ư����> );
			///////////////// ä�� ��ȭ ���� /////////////////////////////////////////////
			
		// ���� �� �����޼���
		} catch (Exception e2) {}// try
		
		
	}// run()
	
	
	
	
}// class GuSHandle
