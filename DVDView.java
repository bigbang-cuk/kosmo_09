package myProject_1;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DVDView extends JFrame implements MainViewInterface {
	
	MainView mView = null;
	
	public DVDView(MainView mView) {
		this.mView = mView;
	}
	
	SubViewInterface subView = null;
	static DVDView memView = null;
	
	String SearchLabel[] = {"DVD코드","타이틀","영화코드","등록일","갱신일","DVD상태"};
	String cols[] = {"DVD코드","타이틀","영화코드","등록일","발매일","DVD가격","DVD상태","갱신일"};
	
	
	@Override
	public void initDisplay() {
		if(mView.jp_north!=null) {
			mView.remove(mView.jp_north);
			mView.jp_north.removeAll();
			mView.jp_north_first.removeAll();
			mView.jp_north_second.removeAll();
		}
		mView.jp_north = new JPanel();
		mView.jp_north.setLayout(new GridLayout(2,1));
		if(mView.jcb!=null) {
			mView.jcb.removeAll();
		}
		mView.jcb = new JComboBox(SearchLabel);
		mView.jp_north_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		mView.jp_north_first.add(mView.jcb);
		mView.jtf = new JTextField("검색할 키워드를 입력하세요.");
		mView.jp_north_first.add(mView.jtf);
		mView.jtf.addActionListener(mView);
		mView.jtf.addMouseListener(mView);
		mView.jtf.addKeyListener(mView);
		mView.jp_north.add(mView.jp_north_first);
		
		mView.jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		mView.jp_north_second.add(mView.jbtn_ins);
		mView.jbtn_ins.addActionListener(mView);
		mView.jp_north_second.add(mView.jbtn_upd);
		mView.jbtn_upd.addActionListener(mView);
		mView.jp_north_second.add(mView.jbtn_del);
		mView.jbtn_del.addActionListener(mView);
		mView.jp_north_second.add(mView.jbtn_sel);
		mView.jbtn_sel.addActionListener(mView);
		mView.jp_north.add(mView.jp_north_second);
		mView.jp_north.setSize(1000, 100);
		
		if(mView.jsp!=null) {
			mView.remove(mView.jsp);
			mView.jsp.removeAll();
			mView.jt.removeAll();
		}
		mView.dtm = new DefaultTableModel(mView.data,cols);
		mView.jt = new JTable(mView.dtm);
		mView.jsp = new JScrollPane(mView.jt,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mView.jsp.setSize(1000, 300);
		
		mView.add("North",mView.jp_north);
		mView.add("Center",mView.jsp);
		mView.revalidate();
		mView.repaint();
		
		
	}

	@Override
	public void setRow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSubViewText() {
		// TODO Auto-generated method stub

	}

	@Override
	public InterfaceVO connectDB(InterfaceVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
