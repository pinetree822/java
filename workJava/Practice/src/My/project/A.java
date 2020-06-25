package My.project;

import java.awt.*;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import My.project.DataClass;

public class A {
	public static DataClass []dc = new DataClass[DataClass.TOT_MAX];
	public static DataClass []dc1 = new DataClass[DataClass.SUB_MAX];
	public static DataClass []dc2 = new DataClass[DataClass.SUB_MAX];
	public static DataClass []dc3 = new DataClass[DataClass.SUB_MAX];
	public static DataClass []dc4 = new DataClass[DataClass.SUB_MAX];
	public static DataClass []dc5 = new DataClass[DataClass.SUB_MAX];
	public static DataClass []dc6 = new DataClass[DataClass.SUB_MAX];
	
	public static JButton[] btTotal=new JButton[DataClass.TOT_MAX];
	public static JButton[] btClothes=new JButton[DataClass.SUB_MAX];
	public static JButton[] btShoes=new JButton[DataClass.SUB_MAX];
	public static JButton[] btEtc=new JButton[DataClass.SUB_MAX];
	public static JButton[] btElec=new JButton[DataClass.SUB_MAX];
	public static JButton[] btBook=new JButton[DataClass.SUB_MAX];
	public static JButton[] btKids=new JButton[DataClass.SUB_MAX];
	
	public static JPanel[] pTotalSub=new JPanel[DataClass.TOT_MAX];
	public static JPanel[] pClothesSub=new JPanel[DataClass.SUB_MAX];
	public static JPanel[] pShoesSub=new JPanel[DataClass.SUB_MAX];
	public static JPanel[] pEtcSub=new JPanel[DataClass.SUB_MAX];
	public static JPanel[] pElecSub=new JPanel[DataClass.SUB_MAX];
	public static JPanel[] pBookSub=new JPanel[DataClass.SUB_MAX];
	public static JPanel[] pKidsSub=new JPanel[DataClass.SUB_MAX];
	
	
	public static Hashtable<Integer,JButton[]> hB=new Hashtable<Integer,JButton[]>();
	public static Hashtable<Integer,JPanel[]> hP=new Hashtable<Integer,JPanel[]>();
	public static Hashtable<Integer,DataClass[]> hDC=new Hashtable<Integer,DataClass[]>(); 
	public A(){
		hash1Set();
		hash2Set();
		hash3Set();
		dcsSet();
	}
	
	public static void dcsSet(){
		for(int i=0;i<DataClass.TOT_MAX;i++){
			dc[i]=new DataClass();
			//btTotal[i] 보여줄때 생성하고 입력함
			pTotalSub[i]=new JPanel(new GridLayout(1,1));
		}
		for(int i=0;i<DataClass.SUB_MAX;i++){
			dc1[i]=new DataClass();dc2[i]=new DataClass();
			dc3[i]=new DataClass();dc4[i]=new DataClass();
			dc5[i]=new DataClass();dc6[i]=new DataClass();
			pClothesSub[i]=new JPanel(new GridLayout(1,1));
			pShoesSub[i]=new JPanel(new GridLayout(1,1));
			pEtcSub[i]=new JPanel(new GridLayout(1,1));
			pElecSub[i]=new JPanel(new GridLayout(1,1));
			pBookSub[i]=new JPanel(new GridLayout(1,1));
			pKidsSub[i]=new JPanel(new GridLayout(1,1));
		}
		
	}
	public static void hash1Set(){
		hB.put(0,btTotal);hB.put(1,btClothes);
		hB.put(2,btShoes);hB.put(3,btEtc);
		hB.put(4,btElec);hB.put(5,btBook);
		hB.put(6,btKids);
	}
	public static void hash2Set(){
		hP.put(0,pTotalSub);hP.put(1,pClothesSub);
		hP.put(2,pShoesSub);hP.put(3,pEtcSub);
		hP.put(4,pElecSub);hP.put(5,pBookSub);
		hP.put(6,pKidsSub);
	}
	public static void hash3Set(){
		hDC.put(0,dc);hDC.put(1,dc1);
		hDC.put(2,dc2);hDC.put(3,dc3);
		hDC.put(4,dc4);hDC.put(5,dc5);
		hDC.put(6,dc6);
	}
}
