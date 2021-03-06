package sqta1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Objects;
import java.util.regex.Pattern;
public class Register {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public static void registration(JFrame f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register(f);
					window.frame.setVisible(true);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register(JFrame f) {
		initialize(f);
	}

	private void initialize(JFrame f) {
		frame = new JFrame();
		frame.setTitle("Registration Form");
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(52, 46, 77, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setBounds(52, 69, 77, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(52, 92, 77, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(52, 115, 77, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(52, 138, 77, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("City");
		lblNewLabel_5.setBounds(52, 161, 77, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("State");
		lblNewLabel_6.setBounds(52, 184, 77, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pincode");
		lblNewLabel_7.setBounds(52, 207, 77, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setBounds(52, 230, 77, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
			{
				String username = textField.getText();
				String fullname = textField_1.getText();
				String password = passwordField.getText();
				String password1 = passwordField_1.getText();
				String address	= textField_2.getText();
				String city 	= textField_3.getText();
				String state 	= textField_4.getText();
				String pincode	= textField_5.getText();
				String email 	= textField_6.getText();
				if(username.length()==0 || fullname.length()==0 || password.length()==0 || password1.length()==0 || address.length()==0 || city.length() == 0 || state.length()==0 || pincode.length()==0 || email.length() == 0) {
                	JOptionPane.showMessageDialog(btnNewButton, "All fields are compulsory");
                	return;
                }
				else if(invalidName(fullname))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Full name. Please use only characters.");
                	return;
				}
				else if(invalidPincode(pincode))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Pincode. Please enter 6 digit pincode.");
                	return;
				}
				else if(!Objects.equals(password,password1))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Passwords don't match.");
                	return;
				}
				else if(isWeakPassword(password)){ return;}
				else if(invalidName(city))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid city name. Please use only characters.");
                	return;
				}
				else if(invalidName(state))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid state name. Please use only characters.");
                	return;
				}
				else if(invalidEmail(email))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid email address.");
                	return;
				}
				Connection conn =null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					PreparedStatement query = conn.prepareStatement("select idCustomer, FullName, password from customer where UserName = (?)");
					query.setString(1,username);
					ResultSet qs = query.executeQuery();
					if(qs.next()==false)
					{
						PreparedStatement stmt = conn.prepareStatement("insert into customer( FullName, UserName, Password, Address, City, State, Pincode, Email) values (?,?,?,?,?,?,?,?)");
						stmt.setString(1,fullname);
						stmt.setString(2,username);
						stmt.setString(3,password);
						stmt.setString(4,address);
						stmt.setString(5,city);
						stmt.setString(6,state);
						stmt.setString(7,pincode);
						stmt.setString(8,email);
						int rs = stmt.executeUpdate();
						if(rs>0)
						{
							JOptionPane.showMessageDialog(btnNewButton, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Username already exists. Try something new.");
	                	return;
					}
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
				finally
				{
					if (conn != null)
					{
						try 
						{
							conn.close();
						} 
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(51, 253, 96, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(157, 253, 96, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Login Page");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(263, 253, 96, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(157, 43, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 66, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 89, 96, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(157, 112, 96, 19);
		frame.getContentPane().add(passwordField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 135, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 158, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 181, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(157, 204, 96, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(157, 227, 96, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
	
	public boolean invalidName(String s)
	{
		return ((!s.equals("")) && (s != null) && !(s.matches("^[a-z A-Z]*"))); 
	}
	public boolean invalidPincode(String s)
	{
		if(s.length()!=6) return true;
		return ((!s.equals("")) && (s != null) && !(s.matches("^[0-9]*"))); 
	}
	public boolean isWeakPassword(String pass)
	{
		String uppercase = "(.*[A-Z].*)";
		String lowercase = "(.*[A-Z].*)";
		String numbers = "(.*[0-9].*)";
		String special = "(.*[,~,!,@,#,$,%,^,&,*,_,?].*$)";
		if(pass.length()<6) {
    		JOptionPane.showMessageDialog(null, "Password length should be minimum 6");
    	}
		else if(!pass.matches(uppercase)) {
    		JOptionPane.showMessageDialog(null, "Password should contain atleast one upper case alphabet");
		}
		else if(!pass.matches(lowercase)) {
    		JOptionPane.showMessageDialog(null, "Password should contain atleast one lower case alphabet");
		}
		else if(!pass.matches(numbers)) {
    		JOptionPane.showMessageDialog(null, "Password should contain atleast one number");
    	}
		else if(!pass.matches(special)) {
    		JOptionPane.showMessageDialog(null, "Password should contain atleast one special character");
    	}
		else
		{
			return false;
		}
    	return true; 
	}
	public boolean invalidEmail(String email) {
    	
    	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
    	Pattern pat = Pattern.compile(emailRegex); 
    	if (email == null) return true; 
    	return !pat.matcher(email).matches(); 	
    }
}
