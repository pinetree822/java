package My.project;

import My.project.DataClass;
import static My.project.C.*;
import static My.project.A.*;
import static My.project.MyPart.*;
import static My.project.ProductPage.img1;
import static My.project.ProductPage.taMain;
import static My.project.ProductPage.tfArea;
import static My.project.ProductPage.tfCategory;
import static My.project.ProductPage.tfPrice;
import static My.project.ProductPage.tfTitle;

import javax.swing.*;

public class B {
	public static void showImage(JPanel[] jp,JButton[] jb,int num,int idx){
		for(int i=0;i<num;i++){
			jp[i].add(
					jb[i]=new JButton(
						hDC.get(idx)[i].vProductName,new ImageIcon(hDC.get(idx)[i].vImage)));
			pan[idx].add(pTotalSub[i]);
			makeButton(btTotal[i]);	
		}
	}
	public static JButton makeButton(JButton j){
		j.setVerticalTextPosition(JButton.BOTTOM);
		j.setHorizontalTextPosition(JButton.CENTER);
		return j;
	}
	
}
