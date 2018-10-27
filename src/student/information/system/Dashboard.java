package student.information.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;

public class Dashboard {

	private JFrame frmDashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frmDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		frmDashboard.setType(Type.UTILITY);
		frmDashboard.setTitle("Student Information System");
		frmDashboard.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 9));
		frmDashboard.setBounds(100, 100, 471, 412);
		frmDashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblAllRightsReserverd = new JLabel("Copyright 2018. All rights reserverd");
		lblAllRightsReserverd.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		
		JLabel lblNewLabel = new JLabel("Designed and Published by Edwin Randu");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDashboard)
					.addContainerGap(319, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDashboard, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Entries", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = JOptionPane.showConfirmDialog(null, "Do you want to exit the System?", "Exit System",
		                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		        if (c == JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
			}
		});
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Reports", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnEndSession = new JButton("End Session");
		btnEndSession.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(new String[]{});
				frmDashboard.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmDashboard.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAllRightsReserverd)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnEndSession)))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExit))))
					.addGap(138))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnEndSession))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllRightsReserverd)
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		
		JButton btnViewstudent = new JButton("View Student");
		btnViewstudent.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnViewstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudent.main(new String[]{});
			}
		});
		
		JButton btnViewResults = new JButton("View Results");
		btnViewResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultView.main(new String[]{});
				frmDashboard.setVisible(true);
			}
		});
		btnViewResults.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnViewstudent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(btnViewResults, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnViewstudent)
					.addGap(18)
					.addComponent(btnViewResults)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AddStudent.main(new String[]{});
					frmDashboard.dispose();
			}
		});
		
		JButton btnEditStudentMark = new JButton("Edit Student Mark");
		btnEditStudentMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudentMarks.main(new String[]{});
				frmDashboard.dispose();
			}
		});
		btnEditStudentMark.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JButton btnMarkEntry = new JButton("Mark Entry");
		btnMarkEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamProcessing.main(new String[]{});
				frmDashboard.dispose();
			}
		});
		btnMarkEntry.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEditStudentMark, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMarkEntry, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddStudent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddStudent)
					.addGap(18)
					.addComponent(btnMarkEntry)
					.addGap(18)
					.addComponent(btnEditStudentMark)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmDashboard.getContentPane().setLayout(groupLayout);
	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
