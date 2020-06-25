package _help1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
/*[1] tf1에 입력한 이미지 파일을 tf2에 입력한 파일로
 *    카피하자. 카피가 다 완료되면 lbImg에 해당 이미지가 나온다.
 *[2] 진행바(pb)에 카피 진행상태를 보여준다.=> Thread이용
 *
 *[3] 원격서버에 있는 이미지를 카피해보자.(다운로드)
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
		
		btCopy=new JButton("로컬에서 Copy");
		btUrlCopy=new JButton("원격에서 Copy");
		
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
		
		tf1.setBorder(new TitledBorder("원본 이미지 파일"));
		tf2.setBorder(new TitledBorder("목적 이미지 파일"));
		tfUrl.setBorder(new TitledBorder("원격 이미지 파일의 URL"));
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
	}//생성자------------
	public synchronized void urlFileCopy(String urlStr){
		try {
			java.net.URL url=new java.net.URL(urlStr);
			InputStream is=url.openStream();
			//m95-168-290
			java.net.URLConnection con
						=url.openConnection();
			//url에 있는 파일의 크기를 반환한다.
			
			int fsize=con.getContentLength();
			setTitle(fsize+"bytes");
			
			pb.setMinimum(0);
			pb.setMaximum(fsize);
			
			//해당 url과 노드 연결된 입력 스트림을 반환한다.
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
		long fsize=srcFile.length();//원본 파일의 크기를 반환
		setTitle("원본 파일 크기: "+fsize+"bytes");
		
		//pb의 최대값을 원본 파일 크기로 잡는다.
		pb.setMinimum(0);
		pb.setMaximum((int)fsize);
		
		try{
		//스트림 연결=> 노드 스트림=> 필터 스트림
		fis=new FileInputStream(srcFile);
		fos=new FileOutputStream(tarFile);
		
		//반복문 돌면서 읽어들이고 내보낸다.
		int input=0, count=0;
		byte[] data=new byte[1024];
		while((input=fis.read(data))!= -1){
			fos.write(data,0,input);
			fos.flush();
			count+=input;
			pb.setValue(count);
			Thread.sleep(10);
			
		}//while----------------
		msg=count+"bytes 카피 완료";
		//스트림 닫기
		fis.close();
		fos.close();
		
		//lbImage에 카피된 이미지를 보여준다.
		lbImage.setIcon(new ImageIcon(tarFile.getAbsolutePath()));
		
		}catch(FileNotFoundException e){
			msg="없는 파일이에요: "+e.getMessage();
		}catch(Exception e){
			msg="오류: "+e.getMessage();
		}
		
		//JOptionPane.showMessageDialog(this, msg);
		
	}
	

	public static void main(String[] args) {
		new ImageCopyGui();
	}

}
