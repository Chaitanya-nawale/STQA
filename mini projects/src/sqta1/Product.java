package sqta1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Product {

	private JFrame frame;

	public static void productOrder(int id, String name, JFrame f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product window = new Product(id,name,f);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Product(int id, String name, JFrame f) {
		initialize(id,name,f);
	}

	private void initialize(int id, String name, JFrame f) {
		frame = new JFrame();
		frame.setTitle("Health Shopping Portal");
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 536, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Order Fruit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Fruit.fruitBook(id,frame);
			}
		});
		btnNewButton.setBounds(120, 202, 112, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Order Herb");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Herb.herbBook(id,frame);
			}
		});
		btnNewButton_1.setBounds(325, 202, 112, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to portal " +name);
		lblNewLabel.setBounds(163, 37, 207, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(94, 274, 160, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Confirm Order");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ConfirmOrder.confirmation(id, name, frame);
			}
		});
		btnNewButton_3.setBounds(299, 274, 160, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("fruits.jpg"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(94, 87, 160, 105);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("herbs.jpg"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(299, 87, 160, 105);
		frame.getContentPane().add(lblNewLabel_2);
		
	}
}
