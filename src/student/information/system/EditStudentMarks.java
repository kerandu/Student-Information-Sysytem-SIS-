package student.information.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class EditStudentMarks {

	private JFrame frmExamProcessing;
	private JTextField txtRegno;
	private JTextField txtName;
	private JTextField txtCourseID;
	private JTextField txtUnit1;
	private JTextField txtUnit2;
	private JTextField txtUnit3;
	private JTextField txtUnit4;
	private JTextField txtUnit5;
	private JTextField txtUnit6;
	private JTextField txtUnit7;
	private JTextField txtTotal;
	private JTextField txtAverage;
	private JTextField txtGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudentMarks window = new EditStudentMarks();
					window.frmExamProcessing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditStudentMarks() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frmExamProcessing = new JFrame();
		frmExamProcessing.setTitle("Edit Student Mark");
		frmExamProcessing.setBounds(100, 100, 575, 492);
		frmExamProcessing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblRegistrationNo = new JLabel("Registration No:");
		lblRegistrationNo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		txtRegno = new JTextField();
		txtRegno.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtRegno.setColumns(10);
		
		JButton btnSearchRecord = new JButton("Search Record");
		btnSearchRecord.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnSearchRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sregno=txtRegno.getText();
				if(sregno==null||sregno.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Please enter the regitration no. first");
				}else{
				String regno = sregno;
				Student s=StudentDao.getStudentByRegNoMark(regno);
				txtRegno.setText(s.getRegno());
				txtName.setText(s.getName());
				txtCourseID.setText(s.getCourseid());
				txtUnit1.setText(String.valueOf(s.getUnit1()));
				txtUnit2.setText(String.valueOf(s.getUnit2()));
				txtUnit3.setText(String.valueOf(s.getUnit3()));
				txtUnit4.setText(String.valueOf(s.getUnit4()));
				txtUnit5.setText(String.valueOf(s.getUnit5()));
				txtUnit6.setText(String.valueOf(s.getUnit6()));
				txtUnit7.setText(String.valueOf(s.getUnit7()));
				txtTotal.setText(String.valueOf(s.getTotal()));
				txtAverage.setText(String.valueOf(s.getAverage()));
				txtGrade.setText(s.getGrade());
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mark Entry", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnProcess = new JButton("Update");
		btnProcess.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, num3, num4, num5, num6, num7, sum;
				float avg;
				try {
					num1 = Integer.parseInt(txtUnit1.getText());
					num2 = Integer.parseInt(txtUnit2.getText());
					num3 = Integer.parseInt(txtUnit3.getText());
					num4 = Integer.parseInt(txtUnit4.getText());
					num5 = Integer.parseInt(txtUnit5.getText());
					num6 = Integer.parseInt(txtUnit6.getText());
					num7 = Integer.parseInt(txtUnit7.getText());
					
					sum = num1 + num2 + num3 + num4 + num5 + num6 + num7;
					txtTotal.setText(Integer.toString(sum));
					
					avg = sum/7;
					txtAverage.setText(Float.toString(avg));
					
					 if (avg >=71)
				        {
				            txtGrade.setText("A"); 
				        }
				        if (avg <=71)
				        {
				            txtGrade.setText("B"); 
				        }
				        if (avg <=60)
				        {
				        	txtGrade.setText("C"); 
				        }
				        if (avg <=50)
				        {
				        	txtGrade.setText("D"); 
				        }
				        if (avg <=39)
				        {
				        	txtGrade.setText("E"); 
				        }
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,  "");
				}
				
				String regno = txtRegno.getText(); 
				String name=txtName.getText();
				String courseid = txtCourseID.getText();
				int unit1=Integer.parseInt(txtUnit1.getText());
				int unit2=Integer.parseInt(txtUnit2.getText());
				int unit3=Integer.parseInt(txtUnit3.getText());
				int unit4=Integer.parseInt(txtUnit4.getText());
				int unit5=Integer.parseInt(txtUnit5.getText());
				int unit6=Integer.parseInt(txtUnit6.getText());
				int unit7=Integer.parseInt(txtUnit7.getText());
				int total=Integer.parseInt(txtTotal.getText());
				float average=Float.parseFloat(txtAverage.getText());
				String grade=txtGrade.getText();
				
								
				Student s=new Student(regno, name, courseid, unit1, unit2, unit3, unit4, unit5, unit6, unit7, total, average, grade);
				int status=StudentDao.updateMarks(s);
				
				if(status>0){
					int c = JOptionPane.showConfirmDialog(null, "Do you want to update this Student?", "Confirm",
			                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			        if (c == JOptionPane.YES_OPTION)
			        {
					JOptionPane.showMessageDialog(null, "Student updated Successfully");
				}else{
					JOptionPane.showMessageDialog(null,"Oops!, Unable to update student!");
				}
			}				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.main(new String[]{});
				frmExamProcessing.dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Miscellaneous", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frmExamProcessing.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRegistrationNo)
							.addGap(18)
							.addComponent(txtRegno, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnSearchRecord))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
							.addComponent(btnProcess)))
					.addGap(180))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegistrationNo)
						.addComponent(txtRegno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearchRecord))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnProcess)
						.addComponent(btnCancel))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		
		JLabel lblAverage = new JLabel("Average:");
		
		txtAverage = new JTextField();
		txtAverage.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtAverage.setEditable(false);
		txtAverage.setColumns(10);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		txtGrade = new JTextField();
		txtGrade.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtGrade.setEditable(false);
		txtGrade.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblAverage)
							.addGap(18)
							.addComponent(txtAverage, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblGrade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGrade, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal)
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAverage)
						.addComponent(txtAverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrade)
						.addComponent(txtGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblUnit = new JLabel("Unit 1:");
		lblUnit.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblUnit_1 = new JLabel("Unit 2:");
		lblUnit_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblUnit_2 = new JLabel("Unit 3:");
		lblUnit_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblUnit_3 = new JLabel("Unit 4:");
		lblUnit_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblUnit_4 = new JLabel("Unit 5:");
		lblUnit_4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblUnit_5 = new JLabel("Unit 6:");
		lblUnit_5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblUnit_6 = new JLabel("Unit 7:");
		lblUnit_6.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		txtUnit1 = new JTextField();
		txtUnit1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit1.setColumns(10);
		
		txtUnit2 = new JTextField();
		txtUnit2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit2.setColumns(10);
		
		txtUnit3 = new JTextField();
		txtUnit3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit3.setColumns(10);
		
		txtUnit4 = new JTextField();
		txtUnit4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit4.setColumns(10);
		
		txtUnit5 = new JTextField();
		txtUnit5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit5.setColumns(10);
		
		txtUnit6 = new JTextField();
		txtUnit6.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit6.setColumns(10);
		
		txtUnit7 = new JTextField();
		txtUnit7.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtUnit7.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUnit, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(lblUnit_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUnit_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUnit_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtUnit7)
						.addComponent(txtUnit3)
						.addComponent(txtUnit2)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtUnit1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUnit_5, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(lblUnit_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUnit_3))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtUnit6)
						.addComponent(txtUnit5)
						.addComponent(txtUnit4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(107))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit_3)
								.addComponent(txtUnit4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit_4)
								.addComponent(txtUnit5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit_5)
								.addComponent(txtUnit6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit)
								.addComponent(txtUnit1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit_1)
								.addComponent(txtUnit2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit_2)
								.addComponent(txtUnit3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit_6)
								.addComponent(txtUnit7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtName.setColumns(10);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		txtCourseID = new JTextField();
		txtCourseID.setEditable(false);
		txtCourseID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtCourseID.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addGap(18)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(lblCourseId)
					.addGap(18)
					.addComponent(txtCourseID, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblName))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCourseId)
							.addComponent(txtCourseID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmExamProcessing.getContentPane().setLayout(groupLayout);
	}
}
