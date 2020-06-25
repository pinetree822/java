package _help1;
/*이벤트 핸들러를 외부 클래스로 구현할 경우
 *  - 매개변수를 받는 인자 생성자를 구성한다.
 *  - 연동할 클래스의 매개변수를 받아 멤버변수로 전달한다.
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyEditorEventHandler 
				implements ActionListener
				, ListSelectionListener{
	MyEditor edit;
	
	public MyEditorEventHandler(MyEditor edit){
		this.edit=edit;
	}//--------------------------
	
	public void valueChanged(ListSelectionEvent e){
		boolean b=e.getValueIsAdjusting();
		//마우스를 누르면 true반환, 떼면 false를 반환
		//System.out.println("리스트 이벤트"+b);
		if(b){
			//1. lst에서 선택한 파일명 얻기
			String filename=edit.lst.getSelectedValue();
			String dir=edit.tfDir.getText();			
			File file=new File(dir+"/"+filename);
			edit.setTitle(file.isFile()+"<파일여부");
			if(!file.isFile()){
				return;
			}
						
			//4. 파일을 읽는 스트림과 노드 연결
			try{
			/*FileReader fr=new FileReader(file);
			char[] data=new char[1000];
			int input=0;
			edit.ta.setText("");
			while((input=fr.read(data))!=-1){
				String str=new String(data,0,input);
				edit.ta.append(str);
			}
			fr.close();*/
			BufferedReader br
			=new BufferedReader(new FileReader(file));
			String line="";
			edit.ta.setText("");
			while((line=br.readLine())!=null){
				edit.ta.append(line+"\r\n");
			}
			br.close();
			edit.setTitle(file.getAbsolutePath());
			
			//5. 반복문 돌면서 파일을 읽어들이고 
			//   해당 내용을 ta에 덧붙인다.
			}catch(IOException ex){
				JOptionPane.showMessageDialog(
						edit, ex.getMessage());
			}
		}
		
	}//--------------------------
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		try{
			//tfDir, btNew, btSave
			Object o=e.getSource();
			if(o==edit.tfDir){
				getFileList();
			}else if(o==edit.btNew){
				//edit.ta.setBackground(Color.yellow);
				edit.ta.setText("");
			}else if(o==edit.btSave){			
				saveFile();			
			}
		}catch(IOException ex){
			String message=ex.getMessage();
			JOptionPane.showMessageDialog(edit, message,
					"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}//------------------------------
	
	public void saveFile() throws IOException{
		JFileChooser dialog
		=new JFileChooser(new File("C:/MyJava"));
		 dialog.showSaveDialog(edit);
		 //JFileChooser에서 저장할  파일명을
		 //얻는다. 절대경로를 알아내어
		 //파일에 쓰기작업을 한다.(ta에 입력한 내용을)
		 File selFile=dialog.getSelectedFile();
		 if(selFile==null) return;//취소=> null을 반환
		 String path=selFile.getAbsolutePath();
		 edit.setTitle(path);
		 		 
		 //1) ta에 입력한 내용 얻기
		 String content=edit.ta.getText();
		 
		 //2) 파일과 노드연결할 스트림 선택=>연결하기
		 FileWriter fw=new FileWriter(path);
		 
		 //3) 파일에 쓰기. =>저장 완료 메시지 처리(타이틀에)
		 fw.write(content.replaceAll("\n","\r\n"));
		 
		 fw.flush();
		 fw.close();
		 edit.setTitle(path+" 저장 완료~!");
		 
	}//------------------------------
	
	
	
	/**특정 디렉토리의 파일 목록을 얻어온다.*/
	public void getFileList(){
		//1. tfDir에 사용자가 입력한 값을 받는다.
		String dirStr=edit.tfDir.getText();
		File dir=new File(dirStr.trim());
		//2. 해당 값이 디렉토리가 맞는지 유효성 체크
		if(!dir.isDirectory()){
			JOptionPane.showMessageDialog(edit,
					"디렉토리를 입력해야 해요");
			edit.tfDir.setText("");
			edit.tfDir.requestFocus();
			return;		
		}		
		//3. 디렉토리가 맞다면 해당 디렉토리의
		//   파일목록을 얻어온다.
		String[] fileList=dir.list();		
		//4. lst에 파일 목록 데이터를 연결한다.
		edit.lst.setListData(fileList);
		
	}//------------------------------
	
	
}////////////////////////////////////////////




