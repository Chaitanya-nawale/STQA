package sqta1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.SwingConstants;

public class LogIn {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LogIn() {
		initialize();
	}


	public void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 379, 228);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login page");
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 68, 96, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(81, 91, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(187, 65, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 88, 96, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String uname = textField.getText();
				String pass  = passwordField.getText();
				if(uname.length()==0 || pass.length()==0 ) {
                	JOptionPane.showMessageDialog(btnNewButton, "All fields are compulsory");
                	return;
                }
				try {
						Class.forName("com.mysql.cj.jdbc.Driver"); 
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
						PreparedStatement stmt = conn.prepareStatement("select idCustomer, FullName, password from customer where UserName = (?)");
						stmt.setString(1,uname);
						ResultSet rs = stmt.executeQuery();
						if(rs.next()==false)
						{
							JOptionPane.showMessageDialog(null, "Invalid Username");
							textField.setText("");
							passwordField.setText("");
						}
						else 
						{
							String dbpass= rs.getString("password");
							if(pass.equals(dbpass))
							{
								
								JOptionPane.showMessageDialog(null, "Login successful!");
								textField.setText("");
								passwordField.setText("");
								frame.setVisible(false);
								int id = Integer.parseInt(rs.getString("idCustomer"));
								String name = rs.getString("FullName");
								Product.productOrder(id, name, frame);
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect password");
								textField.setText("");
								passwordField.setText("");
							}
						}
						conn.close();
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(81, 117, 96, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				frame.setVisible(false);
				Register.registration(frame);
			}
		});
		btnNewButton_1.setBounds(187, 117, 96, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(140, 148, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
	}

}
