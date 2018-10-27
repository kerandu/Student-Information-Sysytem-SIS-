
package student.information.system;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ResultView extends JFrame {
	static ResultView frame;
	public ResultView() {
		setTitle("Students");
		//Code to view data in JTable
		List<Student> list=StudentDao.viewResult();
		int size=list.size();
		
		String data[][]=new String[size][14];
		int row=0;
		for(Student s:list){
			data[row][0]=String.valueOf(s.getRegno());
			data[row][1]=s.getName();
			data[row][2]=s.getCourseid();
			data[row][3]=String.valueOf(s.getUnit1());
			data[row][4]=String.valueOf(s.getUnit2());
			data[row][5]=String.valueOf(s.getUnit3());
			data[row][6]=String.valueOf(s.getUnit4());
			data[row][7]=String.valueOf(s.getUnit5());
			data[row][8]=String.valueOf(s.getUnit6());
			data[row][9]=String.valueOf(s.getUnit7());
			data[row][10]=String.valueOf(s.getTotal());
			data[row][11]=String.valueOf(s.getAverage());
			data[row][12]=s.getGrade();
			row++;
		}
		String columnNames[]={"Regno","Name","Course ID","Unit 1","Unit 2","Unit 3","Unit 4", "Unit 5", "Unit 6", "Unit 7", "Total", "Average", "Grade"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.main(new String[] {});
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDashboard)
							.addGap(12))
						.addComponent(sp, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(sp, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnDashboard)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ResultView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
