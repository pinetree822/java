package co.kr.team.food;
import co.kr.team.food.KcalDao;
import co.kr.team.food.KcalDto;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class KcalList extends JFrame implements MouseListener {
	JTable table;
	JScrollPane pane;
	Vector vData; // ������
	Vector vCols; // �÷� ����
	DefaultTableModel model; // ���̺��
	KcalMain m;
	public KcalList() {
		String[] arrCols = {"No", "�����̸�", "Kcal"};

		vCols = new Vector();
		for (int i = 0; i < arrCols.length; i++) { // �ݺ��� ���鼭 �÷� ���� �ֱ�
			vCols.add(arrCols[i]);
		}//for
		vData = KcalDao.KcalList();
		model = new DefaultTableModel(vData, vCols);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//���ϼ���
		table.addMouseListener(this); // ���̺� ���콺������ ���
		pane = new JScrollPane(table);
		add(pane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}//������
	
	public KcalList(KcalMain m) {
		this.m = m;
		String[] arrCols = {"No", "�����̸�", "Kcal"};
		vCols = new Vector();
		for (int i = 0; i < arrCols.length; i++) { // �ݺ��� ���鼭 �÷� ���� �ֱ�
			vCols.add(arrCols[i]);
		}//for
		vData = KcalDao.selFoodName(m.tfFname.getText());
		model = new DefaultTableModel(vData, vCols);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//���ϼ���
		table.addMouseListener(this); // ���̺� ���콺������ ���
		pane = new JScrollPane(table);
		
		add(pane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new KcalList();
	}//main
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int no = (Integer)table.getValueAt(row, 0);
		KcalDto dto = KcalDao.selectno(no);
		int No = dto.getNo();
		m.tfNo.setText("" + No);
		int Kcal = dto.getKcal();
		m.tfKcal.setText("" + Kcal);
		m.tfFname.setText(dto.getFname());
		this.dispose();
		
		
	}//mouseClicked
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}//end