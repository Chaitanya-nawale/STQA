package sqta1;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Fruit {

	public int appleCNT,mangoCNT,orangeCNT,guavaCNT;
	private JFrame frame;
	private JTextField textFieldApple;
	private JTextField textFieldMango;
	private JTextField textFieldGuava;
	private JTextField textFieldOrange;

	/**
	 * Launch the application.
	 */
	public void fruitBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fruit window = new Fruit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fruit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Fruits");
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Fruits");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(229, 10, 141, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LogIn obj = new LogIn();
				obj.initialize();
			}
		});
		btnNewButton.setBounds(10, 14, 97, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("apple.jpg"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 97, 170, 92);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = "Products        Count       Total";
				if(appleCNT>0)
					op+="\nApple                  "+appleCNT+"              "+appleCNT*100;
				if(mangoCNT>0)
					op+="\nMango                "+mangoCNT+"              "+mangoCNT*150;
				if(guavaCNT>0)
					op+="\nGuava                 "+guavaCNT+"              "+guavaCNT*80;
				if(orangeCNT>0)
					op+="\nOrange               "+orangeCNT+"              "+orangeCNT*60;
				int TotalPrice = appleCNT*100+mangoCNT*150+guavaCNT*80+orangeCNT*60;
				op+="\nTotal Price                         "+TotalPrice;
				JOptionPane.showMessageDialog(frame,op);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(519, 14, 97, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("mango.jpg"));
		lblNewLabel_2.setBounds(351, 97, 170, 92);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton buttonApplePlus = new JButton("+");
		buttonApplePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appleCNT++;
				textFieldApple.setText(Integer.toString(appleCNT));
			}
		});
		buttonApplePlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonApplePlus.setBounds(243, 97, 40, 25);
		frame.getContentPane().add(buttonApplePlus);
		
		JButton buttonAppleMinus = new JButton("-");
		buttonAppleMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appleCNT--;
				if(appleCNT < 0) {
					appleCNT = 0;
				}
				textFieldApple.setText(Integer.toString(appleCNT));
			}
		});
		buttonAppleMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonAppleMinus.setBounds(244, 164, 40, 25);
		frame.getContentPane().add(buttonAppleMinus);
		
		textFieldApple = new JTextField();
		textFieldApple.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldApple.setText("0");
		textFieldApple.setBounds(244, 132, 40, 22);
		frame.getContentPane().add(textFieldApple);
		textFieldApple.setColumns(10);
		
		JButton buttonMangoPlus = new JButton("+");
		buttonMangoPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mangoCNT++;
				textFieldMango.setText(Integer.toString(mangoCNT));
			}
		});
		buttonMangoPlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonMangoPlus.setBounds(531, 97, 40, 25);
		frame.getContentPane().add(buttonMangoPlus);
		
		textFieldMango = new JTextField();
		textFieldMango.setText("0");
		textFieldMango.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMango.setColumns(10);
		textFieldMango.setBounds(531, 132, 40, 22);
		frame.getContentPane().add(textFieldMango);
		
		JButton buttonMangoMinus = new JButton("-");
		buttonMangoMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mangoCNT--;
				if(mangoCNT < 0) {
					mangoCNT = 0;
				}
				textFieldMango.setText(Integer.toString(mangoCNT));
				
			}
		});
		buttonMangoMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonMangoMinus.setBounds(531, 165, 40, 25);
		frame.getContentPane().add(buttonMangoMinus);
		
		JLabel lblAppleRskg = new JLabel("Apple Rs .100/KG");
		lblAppleRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppleRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAppleRskg.setBounds(89, 184, 120, 30);
		frame.getContentPane().add(lblAppleRskg);
		
		JLabel lblMangoRskg = new JLabel("Mango Rs .150/KG");
		lblMangoRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMangoRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMangoRskg.setBounds(381, 184, 120, 30);
		frame.getContentPane().add(lblMangoRskg);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("guava.jpg"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(64, 242, 170, 92);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton buttonGuavaPlus = new JButton("+");
		buttonGuavaPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guavaCNT++;
				textFieldGuava.setText(Integer.toString(guavaCNT));
			}
		});
		buttonGuavaPlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonGuavaPlus.setBounds(243, 242, 40, 25);
		frame.getContentPane().add(buttonGuavaPlus);
		
		textFieldGuava = new JTextField();
		textFieldGuava.setText("0");
		textFieldGuava.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGuava.setColumns(10);
		textFieldGuava.setBounds(243, 277, 40, 22);
		frame.getContentPane().add(textFieldGuava);
		
		JButton buttonGuavaMinus = new JButton("-");
		buttonGuavaMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guavaCNT--;
				if(guavaCNT < 0) {
					guavaCNT = 0;
				}
				textFieldGuava.setText(Integer.toString(guavaCNT));
			}	
		});
		buttonGuavaMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonGuavaMinus.setBounds(243, 309, 40, 25);
		frame.getContentPane().add(buttonGuavaMinus);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("oranges.jpg"));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(351, 242, 170, 92);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblGuavaRskg = new JLabel("Guava Rs .80/KG");
		lblGuavaRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuavaRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuavaRskg.setBounds(89, 327, 120, 30);
		frame.getContentPane().add(lblGuavaRskg);
		
		JLabel lblOrangeRskg = new JLabel("Orange Rs . 60/KG");
		lblOrangeRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrangeRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrangeRskg.setBounds(381, 327, 120, 30);
		frame.getContentPane().add(lblOrangeRskg);
		
		JButton buttonOrangePlus = new JButton("+");
		buttonOrangePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orangeCNT++;
				textFieldOrange.setText(Integer.toString(orangeCNT));
			}
		});
		buttonOrangePlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonOrangePlus.setBounds(531, 242, 40, 25);
		frame.getContentPane().add(buttonOrangePlus);
		
		textFieldOrange = new JTextField();
		textFieldOrange.setText("0");
		textFieldOrange.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOrange.setColumns(10);
		textFieldOrange.setBounds(531, 278, 40, 22);
		frame.getContentPane().add(textFieldOrange);
		
		JButton buttonOrangeMinus = new JButton("-");
		buttonOrangeMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orangeCNT--;
				if(orangeCNT < 0) {
					orangeCNT = 0;
				}
				textFieldOrange.setText(Integer.toString(orangeCNT));
			}
		});
		buttonOrangeMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonOrangeMinus.setBounds(531, 309, 40, 25);
		frame.getContentPane().add(buttonOrangeMinus);
		
		JButton btnNewButton_2 = new JButton("Place Order");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(229, 386, 160, 30);
		frame.getContentPane().add(btnNewButton_2);

	}

}
