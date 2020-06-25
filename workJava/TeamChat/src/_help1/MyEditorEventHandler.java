package _help1;
/*�̺�Ʈ �ڵ鷯�� �ܺ� Ŭ������ ������ ���
 *  - �Ű������� �޴� ���� �����ڸ� �����Ѵ�.
 *  - ������ Ŭ������ �Ű������� �޾� ��������� �����Ѵ�.
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
		//���콺�� ������ true��ȯ, ���� false�� ��ȯ
		//System.out.println("����Ʈ �̺�Ʈ"+b);
		if(b){
			//1. lst���� ������ ���ϸ� ���
			String filename=edit.lst.getSelectedValue();
			String dir=edit.tfDir.getText();			
			File file=new File(dir+"/"+filename);
			edit.setTitle(file.isFile()+"<���Ͽ���");
			if(!file.isFile()){
				return;
			}
						
			//4. ������ �д� ��Ʈ���� ��� ����
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
			
			//5. �ݺ��� ���鼭 ������ �о���̰� 
			//   �ش� ������ ta�� �����δ�.
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
		 //JFileChooser���� ������  ���ϸ���
		 //��´�. �����θ� �˾Ƴ���
		 //���Ͽ� �����۾��� �Ѵ�.(ta�� �Է��� ������)
		 File selFile=dialog.getSelectedFile();
		 if(selFile==null) return;//���=> null�� ��ȯ
		 String path=selFile.getAbsolutePath();
		 edit.setTitle(path);
		 		 
		 //1) ta�� �Է��� ���� ���
		 String content=edit.ta.getText();
		 
		 //2) ���ϰ� ��忬���� ��Ʈ�� ����=>�����ϱ�
		 FileWriter fw=new FileWriter(path);
		 
		 //3) ���Ͽ� ����. =>���� �Ϸ� �޽��� ó��(Ÿ��Ʋ��)
		 fw.write(content.replaceAll("\n","\r\n"));
		 
		 fw.flush();
		 fw.close();
		 edit.setTitle(path+" ���� �Ϸ�~!");
		 
	}//------------------------------
	
	
	
	/**Ư�� ���丮�� ���� ����� ���´�.*/
	public void getFileList(){
		//1. tfDir�� ����ڰ� �Է��� ���� �޴´�.
		String dirStr=edit.tfDir.getText();
		File dir=new File(dirStr.trim());
		//2. �ش� ���� ���丮�� �´��� ��ȿ�� üũ
		if(!dir.isDirectory()){
			JOptionPane.showMessageDialog(edit,
					"���丮�� �Է��ؾ� �ؿ�");
			edit.tfDir.setText("");
			edit.tfDir.requestFocus();
			return;		
		}		
		//3. ���丮�� �´ٸ� �ش� ���丮��
		//   ���ϸ���� ���´�.
		String[] fileList=dir.list();		
		//4. lst�� ���� ��� �����͸� �����Ѵ�.
		edit.lst.setListData(fileList);
		
	}//------------------------------
	
	
}////////////////////////////////////////////




