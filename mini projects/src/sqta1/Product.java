package sqta1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Product {

	private JFrame frame;

	public static void productOrder(int id, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product window = new Product(1,"Chaitanya");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Product(int id, String name) {
		initialize(id,name);
	}

	private void initialize(int id, String name) {
		frame = new JFrame();
		frame.setTitle("Health Shopping Portal");
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Order Fruit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Fruit fb = new Fruit();
				fb.fruitBook();
			}
		});
		btnNewButton.setBounds(39, 113, 112, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Order Herb");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Herb hb = new Herb();
				hb.herbBook();
			}
		});
		btnNewButton_1.setBounds(161, 113, 112, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to portal " +name);
		lblNewLabel.setBounds(119, 40, 207, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogIn obj = new LogIn();
				obj.initialize();
			}
		});
		btnNewButton_2.setBounds(283, 113, 112, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
}
