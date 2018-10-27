package student.information.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;

public class MainScreen {

	private JFrame frmMainscreen;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmMainscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainscreen = new JFrame();
		frmMainscreen.setTitle("MainScreen");
		frmMainscreen.setType(Type.UTILITY);
		frmMainscreen.getContentPane().setBackground(SystemColor.menu);
		frmMainscreen.setBounds(100, 100, 816, 513);
		frmMainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblStudentInformationSytem = new JLabel("STUDENT INFORMATION SYSTEM");
		lblStudentInformationSytem.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = JOptionPane.showConfirmDialog(null, "Do you want to exit the System?", "Exit System",
		                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		        if (c == JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
			}
		});
		button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frmMainscreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(lblStudentInformationSytem)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStudentInformationSytem)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setEditable(false);
		txtpnWelcomeToThe.setBackground(SystemColor.menu);
		txtpnWelcomeToThe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtpnWelcomeToThe.setText("Welcome to the Student Information System (SIS). It allows the entry of a new student where the latter is given a unique registration number. Allows Exam processing and reports. This System is basically made for small scale learning institutions. Reach greater heights with SIS.");
		txtpnWelcomeToThe.setBounds(10, 11, 760, 36);
		panel.add(txtpnWelcomeToThe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(227, 106, 310, 120);
		panel.add(panel_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				char ch[]=passwordField.getPassword();
				String password=String.valueOf(ch);
				if(name.equals("admin")&&password.equals("admin123")){
					String s[]={};
					Dashboard.main(s);
					frmMainscreen.dispose();
				}else {
				JOptionPane.showMessageDialog(null,"Sorry, username or password error!");
				textField.setText("");passwordField.setText("");
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frmMainscreen.getContentPane().setLayout(groupLayout);
	}
}
