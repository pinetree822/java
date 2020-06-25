package _help1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
/*[1] tf1�� �Է��� �̹��� ������ tf2�� �Է��� ���Ϸ�
 *    ī������. ī�ǰ� �� �Ϸ�Ǹ� lbImg�� �ش� �̹����� ���´�.
 *[2] �����(pb)�� ī�� ������¸� �����ش�.=> Thread�̿�
 *
 *[3] ���ݼ����� �ִ� �̹����� ī���غ���.(�ٿ�ε�)
 * */

public class ImageCopyGui extends JFrame {
	JTextField tf1, tf2, tfUrl;
	JButton btCopy, btUrlCopy;
	JProgressBar pb;
	JLabel lbImage;
	
	FileInputStream fis;
	FileOutputStream fos;
	File file1, file2;

	public ImageCopyGui() {
		super("::ImageCopyGui::");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(2,1));
		JPanel p=new JPanel(new GridLayout(0,1));
		cp.add(p);
		lbImage=new JLabel("*^^*", JLabel.CENTER);
		cp.add(new JScrollPane(lbImage));
		lbImage.setBorder(new LineBorder(Color.magenta,3));
		
		tf1=new JTextField("pic.png");
		tf2=new JTextField("target.png");
		tfUrl=new JTextField(
		"http://image.yes24.com/momo/TopCate957/MidCate001/95602110.jpg");
		
		btCopy=new JButton("���ÿ��� Copy");
		btUrlCopy=new JButton("���ݿ��� Copy");
		
		pb=new JProgressBar();
		p.add(tf1);
		p.add(tf2);
		p.add(tfUrl);
		JPanel p2=new JPanel();
		p.add(p2);
		
		p2.add(btCopy);
		p2.add(btUrlCopy);
		
		p.add(pb);
		pb.setStringPainted(true);
		
		tf1.setBorder(new TitledBorder("���� �̹��� ����"));
		tf2.setBorder(new TitledBorder("���� �̹��� ����"));
		tfUrl.setBorder(new TitledBorder("���� �̹��� ������ URL"));
		btCopy.setMnemonic('C');
		p.setBorder(new BevelBorder(BevelBorder.RAISED));
		//m76-976-547
		btCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String srcStr=tf1.getText();
				String targetStr=tf2.getText();
				file1=new File(srcStr);
				file2=new File(targetStr);
				Thread tr=new Thread(){
					public void run(){					
						fileCopy(file1, file2);
					}
				}; 
				tr.start();		
				
			}
		});
		
		btUrlCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				String urlStr=tfUrl.getText();
				
				new Thread(){
					public void run(){
						urlFileCopy(urlStr);
					}					
				}.start();
				
				
			}			
		});
		

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------------
	public synchronized void urlFileCopy(String urlStr){
		try {
			java.net.URL url=new java.net.URL(urlStr);
			InputStream is=url.openStream();
			//m95-168-290
			java.net.URLConnection con
						=url.openConnection();
			//url�� �ִ� ������ ũ�⸦ ��ȯ�Ѵ�.
			
			int fsize=con.getContentLength();
			setTitle(fsize+"bytes");
			
			pb.setMinimum(0);
			pb.setMaximum(fsize);
			
			//�ش� url�� ��� ����� �Է� ��Ʈ���� ��ȯ�Ѵ�.
			BufferedInputStream bis=new BufferedInputStream(is);
			file2=new File(tf2.getText());
			fos=new FileOutputStream(file2);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			int input=0, count=0;
			byte [] data=new byte[3000];
			while((input=bis.read(data))!=-1){
				bos.write(data,0,input);
				bos.flush();
				count+=input;
				pb.setValue(count);
				Thread.sleep(10);
			}
			bis.close();
			bos.close();
			is.close();
			fos.close();
			
			lbImage.setIcon(new ImageIcon(file2.getAbsolutePath()));

			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}//--------------------
	
	
	
	
	
	
	
	
	public synchronized void fileCopy(File srcFile, File tarFile){
		String msg="";
		long fsize=srcFile.length();//���� ������ ũ�⸦ ��ȯ
		setTitle("���� ���� ũ��: "+fsize+"bytes");
		
		//pb�� �ִ밪�� ���� ���� ũ��� ��´�.
		pb.setMinimum(0);
		pb.setMaximum((int)fsize);
		
		try{
		//��Ʈ�� ����=> ��� ��Ʈ��=> ���� ��Ʈ��
		fis=new FileInputStream(srcFile);
		fos=new FileOutputStream(tarFile);
		
		//�ݺ��� ���鼭 �о���̰� ��������.
		int input=0, count=0;
		byte[] data=new byte[1024];
		while((input=fis.read(data))!= -1){
			fos.write(data,0,input);
			fos.flush();
			count+=input;
			pb.setValue(count);
			Thread.sleep(10);
			
		}//while----------------
		msg=count+"bytes ī�� �Ϸ�";
		//��Ʈ�� �ݱ�
		fis.close();
		fos.close();
		
		//lbImage�� ī�ǵ� �̹����� �����ش�.
		lbImage.setIcon(new ImageIcon(tarFile.getAbsolutePath()));
		
		}catch(FileNotFoundException e){
			msg="���� �����̿���: "+e.getMessage();
		}catch(Exception e){
			msg="����: "+e.getMessage();
		}
		
		//JOptionPane.showMessageDialog(this, msg);
		
	}
	

	public static void main(String[] args) {
		new ImageCopyGui();
	}

}
