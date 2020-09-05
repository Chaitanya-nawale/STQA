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
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 379, 228);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login page");
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(71, 68, 96, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(71, 91, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(177, 65, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 88, 96, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String uname = textField.getText();
				String pass  = passwordField.getText();
				try {
						Class.forName("com.mysql.jdbc.Driver"); 
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
						PreparedStatement stmt = conn.prepareStatement("select idCustomer, FullName, password from customer where UserName = (?)");
						stmt.setString(1,uname);
						ResultSet rs = stmt.executeQuery();
						if(rs.next()==false)
						{
							JOptionPane.showMessageDialog(null, "Account doesn't exist!");
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
								Product.productOrder(id, name);
								frame.setVisible(true);
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect password");
								frame.setVisible(true);
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
		btnNewButton.setBounds(71, 117, 96, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				frame.setVisible(false);
				Register.registration();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(177, 117, 96, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}

}
