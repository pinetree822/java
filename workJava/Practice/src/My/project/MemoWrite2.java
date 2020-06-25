package My.project;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import static My.project.A.*;
import static My.project.B.*;
import static My.project.C.*;
import static My.project.MyPart.*;
import static My.project.Show_main.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.filechooser.*;

import My.project.ImageFileView;
import My.project.ImageFilter;
import My.project.ImagePreview;
import My.project.Utils;

public class MemoWrite2 extends JPanel
implements ActionListener {

	private JFrame frame;
	private JComboBox cateCombo;
	private JComboBox areaCombo;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private JTextArea msgArea;
	private JScrollPane msgScroller;
	private JButton sendButton;
	private JButton btmImage;
    private JFileChooser fc;
    private Component[] textFields;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoWrite2 window = new MemoWrite2();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemoWrite2() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	private void initialize() {
		
		frame = new JFrame("게시판");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 1, 10, 10));

		msgArea = new JTextArea(20, 40);
		msgArea.setWrapStyleWord(true);
		msgArea.setLineWrap(true);

		msgScroller = new JScrollPane();
		msgScroller.setBorder(BorderFactory.createTitledBorder("Messages"));
		msgScroller.setViewportView(msgArea);

		int numPairs = 7;
		//JLabel[] labels = new JLabel[numPairs];
		Component[] labels = new Component[numPairs];
		textFields = new Component[numPairs];

		JLabel lblCate = new JLabel("카테고리: ");
		lblCate.setLabelFor(cateCombo);
		labels[0] = lblCate;

		JLabel lblArea = new JLabel("지        역: ");
		lblArea.setLabelFor(areaCombo);		
		labels[1] = lblArea;
		
		JLabel lblD = new JLabel("아  이  디: ");
		lblD.setLabelFor(textField);		
		labels[2] = lblD;

		JLabel lblItem = new JLabel("상  품  명: ");
		lblItem.setLabelFor(textField);		
		labels[3] = lblItem;
		
		JLabel lblPrice = new JLabel("제        목: ");
		lblPrice.setLabelFor(textField_1);		
		labels[4] = lblPrice;
		
		JLabel lblTitle = new JLabel("가        격: ");
		lblTitle.setLabelFor(textField_2);
		labels[5] = lblTitle;
		
        btmImage = new JButton("이미지");
        btmImage.addActionListener(this);
		labels[6] = btmImage;
		
		String[] cateArray = { "선택하세요", "옷", "신발", "잡화", "전자제품", "도서류", "유아용품"};
		cateCombo = new JComboBox(cateArray);
		cateCombo.setBounds(80, 39, 176, 24);
		cateCombo.setSelectedIndex(0);
		
		String[] areaArray = { "선택하세요", "강남구", "강동구", "강북구", "강서구"};
		areaCombo = new JComboBox(areaArray);
		areaCombo.setBounds(326, 39, 84, 24);
		
	    textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 75, 330, 24);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 75, 330, 24);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 111, 116, 24);
		textField_2.setColumns(10);	
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 111, 116, 24);
		textField_3.setColumns(10);	
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 111, 116, 24);
		textField_4.setColumns(10);
		textField_4.enable(false);
		
		textFields[0] = cateCombo;
		textFields[1] = areaCombo;
		textFields[2] = textField;
		textFields[3] = textField_1;
		textFields[4] = textField_2;
		textFields[5] = textField_3;
		textFields[6] = textField_4;
	
		Container container = createForm(labels, textFields, 5, 5, 5, 5);

		centerPanel.add(msgScroller);

		JPanel bottomPanel = new JPanel();
		sendButton = new JButton("Send");
		bottomPanel.add(sendButton);

		contentPane.add(container, BorderLayout.BEFORE_FIRST_LINE);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.PAGE_END);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);		
		
		textField_2.setText("제목은 입력하지 않으셔도 됩니다.");
		textField_2.setEditable(false);
		btmImage.addActionListener(this);
		sendButton.addActionListener(this);
		textField.setText(curr_ID);
		textField.setEditable(false);
		
	}
	
	private static Container createForm(Component[] leftComponents, Component[] rightComponents, int initialX,
			int initialY, int xPad, int yPad) {
		SpringLayout layout = new SpringLayout();
		int numRows = Math.max(leftComponents.length, rightComponents.length);

		Spring xSpring = Spring.constant(initialX);
		Spring ySpring = Spring.constant(initialY);
		Spring xPadSpring = Spring.constant(xPad);
		Spring yPadSpring = Spring.constant(yPad);
		Spring negXPadSpring = Spring.constant(-xPad);

		JPanel parent = new JPanel(layout);
		for (int i = 0; i < numRows; i++) {
			parent.add(leftComponents[i]);
			parent.add(rightComponents[i]);
		}

		Spring maxEastSpring = layout.getConstraint("East", leftComponents[0]);
		for (int row = 1; row < numRows; row++) {
			maxEastSpring = Spring.max(maxEastSpring, layout.getConstraint("East", leftComponents[row]));
		}

		SpringLayout.Constraints lastConsL = null;
		SpringLayout.Constraints lastConsR = null;
		Spring parentWidth = layout.getConstraint("East", parent);
		Spring rWidth = null;
		Spring maxHeightSpring = null;
		Spring rX = Spring.sum(maxEastSpring, xPadSpring); // right col location
		Spring negRX = Spring.minus(rX); // negative of rX

		for (int row = 0; row < numRows; row++) {
			SpringLayout.Constraints consL = layout.getConstraints(leftComponents[row]);
			SpringLayout.Constraints consR = layout.getConstraints(rightComponents[row]);

			consL.setX(xSpring);
			consR.setX(rX);

			rWidth = consR.getWidth(); 
			
			consR.setWidth(Spring.sum(Spring.sum(parentWidth, negRX), negXPadSpring));
			if (row == 0) {
				consL.setY(ySpring);
				consR.setY(ySpring);
				maxHeightSpring = Spring.sum(ySpring, Spring.max(consL.getHeight(), consR.getHeight()));
			} else { 
				Spring y = Spring.sum(Spring.max(lastConsL.getConstraint("South"), lastConsR.getConstraint("South")),
						yPadSpring);

				consL.setY(y);
				consR.setY(y);
				maxHeightSpring = Spring.sum(yPadSpring,
						Spring.sum(maxHeightSpring, Spring.max(consL.getHeight(), consR.getHeight())));
			}
			lastConsL = consL;
			lastConsR = consR;
		} 

		SpringLayout.Constraints consParent = layout.getConstraints(parent);
		consParent.setConstraint("East", Spring.sum(rX, Spring.sum(rWidth, xPadSpring)));
		consParent.setConstraint("South", Spring.sum(maxHeightSpring, yPadSpring));
		
		return parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sendButton){
			System.out.println("######################");
			String cate = (String)cateCombo.getSelectedItem();
			String area = (String)areaCombo.getSelectedItem();
			String product = (String)textField_1.getText();
			String price = (String)textField_3.getText();
			String imgStr = (String)textField_4.getText();
			String cont = (String)msgArea.getText();
			
			//dc2[0].setData("갈색운동화","300","images/갈색운동화.jpg",str,"신발","강서구");
			//"옷", "신발", "잡화", "전자제품", "도서류", "유아용품"
			if(cate=="옷"){
				dc[dc_crr].setData(product,price,imgStr,cont,cate,area);
				dc1[n1].setData(product,price,imgStr,cont,cate,area);
				newSet(0,dc_crr);
				newSet(1,n1);
				dc_crr++;
				n1++;
			}else if (cate=="신발"){
				dc[dc_crr].setData(product,price,imgStr,cont,cate,area);
				dc2[n2].setData(product,price,imgStr,cont,cate,area);
				newSet(0,dc_crr);
				newSet(2,n2);
				dc_crr++;
				n2++;
			}else if (cate=="잡화"){
				dc[dc_crr].setData(product,price,imgStr,cont,cate,area);
				dc3[n3].setData(product,price,imgStr,cont,cate,area);
				newSet(0,dc_crr);
				newSet(3,n3);
				dc_crr++;
				n3++;
			}else if (cate=="전제제품"){
				dc[dc_crr].setData(product,price,imgStr,cont,cate,area);
				dc4[n4].setData(product,price,imgStr,cont,cate,area);
				newSet(0,dc_crr);
				newSet(4,n4);
				dc_crr++;
				n4++;
			}else if (cate=="도서류"){
				dc[dc_crr].setData(product,price,imgStr,cont,cate,area);
				dc5[n5].setData(product,price,imgStr,cont,cate,area);
				newSet(0,dc_crr);
				newSet(5,n5);
				dc_crr++;
				n5++;
			}else if (cate=="유아용품"){
				dc[dc_crr].setData(product,price,imgStr,cont,cate,area);
				dc6[n6].setData(product,price,imgStr,cont,cate,area);
				newSet(0,dc_crr);
				newSet(6,n6);
				dc_crr++;
				n6++;
			}
		
			frame.setVisible(false);
		}
		if(e.getSource()== btmImage){
			if (fc == null) {
				fc = new JFileChooser();
				fc.addChoosableFileFilter(new ImageFilter());
				fc.setAcceptAllFileFilterUsed(false);
				fc.setFileView(new ImageFileView());
				fc.setAccessory(new ImagePreview(fc));
			}
	
			 int returnVal = fc.showDialog(MemoWrite2.this, "이미지 파일");
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
				 File file = fc.getSelectedFile(); 
				 textField_4.setText(fc.getSelectedFile().toString());
			 } 
			 else {
			 }
			 
			 fc.setSelectedFile(null);
		}
	}
	public void newSet(int i, int j){
		hP.get(i)[j].add(
				hB.get(i)[j]=new JButton(
					hDC.get(i)[j].vProductName
					,new ImageIcon(hDC.get(i)[j].vImage)));
		hB.get(i)[j].setBackground(Color.white);
		pan[i].add(hP.get(i)[j]);
		makeButton(hB.get(i)[j]);
	}

}
