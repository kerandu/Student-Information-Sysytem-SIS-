package student.information.system;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ViewStudent extends JFrame {
	static ViewStudent frame;
	protected Window frmViewStudent;
	public ViewStudent() {
		setTitle("Students");
		//Code to view data in JTable
		List<Student> list=StudentDao.view();
		int size=list.size();
		
		String data[][]=new String[size][12];
		int row=0;
		for(Student s:list){
			data[row][0]=String.valueOf(s.getRegno());
			data[row][1]=s.getName();
			data[row][2]=s.getGender();
			data[row][3]=s.getDepartment();
			data[row][4]=s.getCourseid();
			data[row][5]=s.getProgram();
			data[row][6]=String.valueOf(s.getYear());
			
			
			
			row++;
		}
		String columnNames[]={"Regno","Name","Gender","Department","Course ID","Program","Year"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.main(new String[] {});				
			}
		});
		btnDashboard.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(sp, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(672, Short.MAX_VALUE)
					.addComponent(btnDashboard)
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(sp, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDashboard)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
