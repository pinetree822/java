package My.project;
import static My.project.A.*;
import static My.project.B.*;
import static My.project.C.*;
import static My.project.ProductPage.*;
import static My.project.Show_main.*;

import java.awt.*;
//1)
import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.*;

import My.project.*;
 
public class MyPart extends JFrame 
implements ActionListener {
	public static JTabbedPane j1;
	public static JButton b1,b2;
	public static JPanel pTotal,pClothes,pShoes,pEtc,pElec,pBook,pKids,pLocation;
	public static JPanel[] pan = new JPanel[7];
	public static JScrollPane sTotal,sClothes,sShoes,sEtc,sElec,sBook,sKids,sLocation;
	
	public static int n1=5,n2=7,n3=6,n4=4,n5=4,n6=5;
	public static int num[] ={n1,n2,n3,n4,n5,n6};
	public static int dc_crr=n1+n2+n3+n4+n5+n6;
	ProductPage pp;
	
	
	public MyPart(){
		super(":::::MyNotePad v1.1:::::");
		A a=new A();
		Container c=getContentPane();
	//jtabbedpane
		j1=new JTabbedPane();
		
		pTotal=new JPanel();pClothes=new JPanel();pShoes=new JPanel();
		pEtc=new JPanel();pElec=new JPanel();pBook=new JPanel();
		pKids=new JPanel();pLocation=new JPanel();
		
		sTotal = new JScrollPane(pTotal);
		sClothes = new JScrollPane(pClothes);
		sShoes = new JScrollPane(pShoes);sEtc = new JScrollPane(pEtc);
		sElec = new JScrollPane(pElec);sBook = new JScrollPane(pBook);
		sKids = new JScrollPane(pKids);
		
		sTotal.setPreferredSize(new Dimension(400, 0));
		
		j1.addTab("전체",sTotal);
		j1.addTab("옷",sClothes);
		j1.addTab("신발",sShoes);			j1.addTab("잡화",sEtc);
		j1.addTab("전자제품",sElec);		j1.addTab("책",sBook);
		j1.addTab("유아용품",sKids);
	//glasspane
		JComponent gp=(JComponent)this.getGlassPane();
		gp.setLayout(new BorderLayout());JPanel p = new JPanel();
		p.setOpaque(false);	p.setLayout(new BorderLayout());
		b2=new JButton("게시글 작성",new ImageIcon("images/캡처.jpg"));
		b2.setBackground(Color.white);
		p.add(b2,"East");gp.add(p,"South");
		gp.setVisible(true);
		for(int i=0;i<dc_crr;i++){dc[i]=new DataClass();}
	//main page(pTotal)
		temporalSave();
		//setLayout GridLayout
		pTotal.setLayout(new GridLayout(0,3));
		pClothes.setLayout(new GridLayout(0,3));
		pShoes.setLayout(new GridLayout(0,3));
		pEtc.setLayout(new GridLayout(0,3));
		pElec.setLayout(new GridLayout(0,3));
		pBook.setLayout(new GridLayout(0,3));
		pKids.setLayout(new GridLayout(0,3));
		//pan 값 저장
		pan[0]=pTotal;pan[1]=pClothes;pan[2]=pShoes;pan[3]=pEtc;
		pan[4]=pElec;pan[5]=pBook;pan[6]=pKids;
		//Total page show
		for(int i=0;i<dc_crr;i++){
			hP.get(0)[i].add(
					hB.get(0)[i]=new JButton(
						hDC.get(0)[i].vProductName
						,new ImageIcon(hDC.get(0)[i].vImage)));
			hB.get(0)[i].setBackground(Color.white);
			pan[0].add(hP.get(0)[i]);
			//pan[0].add(new Label(hDC.get(0)[i].vContents));
			makeButton(hB.get(0)[i]);	
		}
		//기타 page show
		for(int j=1;j<7;j++){
		for(int i=0;i<num[j-1];i++){
			hP.get(j)[i].add(
					hB.get(j)[i]=new JButton(
							hDC.get(j)[i].vProductName
							,new ImageIcon(hDC.get(j)[i].vImage)));
			hB.get(j)[i].setBackground(Color.white);
				pan[j].add(hP.get(j)[i]);
				//pan[j].add(new Label(hDC.get(j)[i].vContents));
				makeButton(hB.get(j)[i]);
		}}
		//setTitle(""+(hDC.get(1)==dc1)+"");
		setTitle(""+num[0]+"");
		
		//버튼 동작하게 하기
		pp=new ProductPage();
		for(int i=0;i<dc_crr;i++)
			hB.get(0)[i].addActionListener(this);
		//나머지 페이지
		for(int i=1;i<=6;i++){
			for(int j=0;j<num[i-1];j++){
				hB.get(i)[j].addActionListener(this);
			}
		}
		b2.addActionListener(this);
		this.add(j1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//Constructor()--------------------------
	@Override
	public void actionPerformed(ActionEvent e) {//3)
		Object o = e.getSource();
		for(int i=0;i<dc_crr;i++){
			if(o==btTotal[i]){
				action2(i,0);
			}
		}
		for(int j=1;j<=6;j++){
			for(int i=0;i<num[j-1];i++){
				if(o==hB.get(j)[i]){
					action2(i,j);
				}
			}
		}
		if(o==b2){
			setTitle("b2");
			MemoWrite2 m = new MemoWrite2();
			m.setLocation(0,0);
			m.setSize(700,500);
			m.setVisible(true);
		}
		
	}//actionPerformed()----------------------
	public void action2(int i,int j){
		String imgUrl=hDC.get(j)[i].vImage;
		img1= new ImageIcon(imgUrl);
		setTitle(imgUrl);
		pp.lbImg.setIcon(img1);
		tfTitle.setText(hDC.get(j)[i].vProductName);
		tfCategory.setText(hDC.get(j)[i].vCat1);
		tfArea.setText(hDC.get(j)[i].vCat2);
		tfPrice.setText(hDC.get(j)[i].vPrice+"원");
		taMain.setText(hDC.get(j)[i].vContents);
		tfUser.setText(curr_ID);
		pp.pack();
		pp.setLocation(0,0);
		pp.setSize(800,600);
		pp.setVisible(true);
		
		
	}
	public static void main(String [] args){
		MyPart my=new MyPart();
		my.setSize(1025,700);
		my.setVisible(true);	
	}	
}