package sqta1;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Herb {


	public int basilCNT,mintCNT,turmericCNT,ginsengCNT;
	private JFrame frame;
	private JTextField textFieldBasil;
	private JTextField textFieldMint;
	private JTextField textFieldGinseng;
	private JTextField textFieldTurmeric;

	public static void herbBook(int id, JFrame f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Herb window = new Herb(id, f);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Herb(int id, JFrame f) {
		initialize(id, f);
	}

	private void initialize(int id, JFrame f) {
		frame = new JFrame();
		frame.setTitle("Herbs");
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Herbs");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(229, 10, 141, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 14, 97, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("basil.jpg"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 97, 170, 92);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = "Products    |    Count    |    Total";
				op+="\n-------------------------------------------";
				if(basilCNT>0)
					op+="\nBasil           |         "+basilCNT+"        |      "+basilCNT*100;
				if(mintCNT>0)
					op+="\nMint            |         "+mintCNT+"        |      "+mintCNT*80;
				if(ginsengCNT>0)
					op+="\nGinseng     |         "+ginsengCNT+"        |      "+ginsengCNT*800;
				if(turmericCNT>0)
					op+="\nTurmeric    |         "+turmericCNT+"        |      "+turmericCNT*320;
				int TotalPrice = basilCNT*100+mintCNT*80+ginsengCNT*800+turmericCNT*320;
				op+="\n-------------------------------------------";
				op+="\nTotal Price                         "+TotalPrice;
				JOptionPane.showMessageDialog(frame,op);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(519, 14, 97, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("mint.jpg"));
		lblNewLabel_2.setBounds(351, 97, 170, 92);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton buttonBasilPlus = new JButton("+");
		buttonBasilPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basilCNT++;
				if(basilCNT > 20) {
					basilCNT = 20;
					JOptionPane.showMessageDialog(null, "You can't buy more than 20!");
				}
				textFieldBasil.setText(Integer.toString(basilCNT));
			}
		});
		buttonBasilPlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonBasilPlus.setBounds(243, 97, 40, 25);
		frame.getContentPane().add(buttonBasilPlus);
		
		JButton buttonBasilMinus = new JButton("-");
		buttonBasilMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basilCNT--;
				if(basilCNT < 0) {
					basilCNT = 0;
				}
				textFieldBasil.setText(Integer.toString(basilCNT));
			}
		});
		buttonBasilMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonBasilMinus.setBounds(244, 164, 40, 25);
		frame.getContentPane().add(buttonBasilMinus);
		
		textFieldBasil = new JTextField();
		textFieldBasil.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldBasil.setText("0");
		textFieldBasil.setBounds(244, 132, 40, 22);
		frame.getContentPane().add(textFieldBasil);
		textFieldBasil.setColumns(10);
		
		JButton buttonMintPlus = new JButton("+");
		buttonMintPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mintCNT++;
				if(mintCNT > 20) {
					mintCNT = 20;
					JOptionPane.showMessageDialog(null, "You can't buy more than 20!");
				}
				textFieldMint.setText(Integer.toString(mintCNT));
			}
		});
		buttonMintPlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonMintPlus.setBounds(531, 97, 40, 25);
		frame.getContentPane().add(buttonMintPlus);
		
		textFieldMint = new JTextField();
		textFieldMint.setText("0");
		textFieldMint.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMint.setColumns(10);
		textFieldMint.setBounds(531, 132, 40, 22);
		frame.getContentPane().add(textFieldMint);
		
		JButton buttonMintMinus = new JButton("-");
		buttonMintMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mintCNT--;
				if(mintCNT < 0) {
					mintCNT = 0;
				}
				textFieldMint.setText(Integer.toString(mintCNT));
				
			}
		});
		buttonMintMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonMintMinus.setBounds(531, 165, 40, 25);
		frame.getContentPane().add(buttonMintMinus);
		
		JLabel lblAppleRskg = new JLabel("Basil Rs .100/pack");
		lblAppleRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppleRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAppleRskg.setBounds(89, 184, 120, 30);
		frame.getContentPane().add(lblAppleRskg);
		
		JLabel lblMangoRskg = new JLabel("Mint Rs . 80/pack");
		lblMangoRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMangoRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMangoRskg.setBounds(381, 184, 120, 30);
		frame.getContentPane().add(lblMangoRskg);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("ginseng.jpg"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(64, 242, 170, 92);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton buttonGinsengPlus = new JButton("+");
		buttonGinsengPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ginsengCNT++;
				if(ginsengCNT > 20) {
					ginsengCNT = 20;
					JOptionPane.showMessageDialog(null, "You can't buy more than 20!");
				}
				textFieldGinseng.setText(Integer.toString(ginsengCNT));
			}
		});
		buttonGinsengPlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonGinsengPlus.setBounds(243, 242, 40, 25);
		frame.getContentPane().add(buttonGinsengPlus);
		
		textFieldGinseng = new JTextField();
		textFieldGinseng.setText("0");
		textFieldGinseng.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGinseng.setColumns(10);
		textFieldGinseng.setBounds(243, 277, 40, 22);
		frame.getContentPane().add(textFieldGinseng);
		
		JButton buttonGinsengMinus = new JButton("-");
		buttonGinsengMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ginsengCNT--;
				if(ginsengCNT < 0) {
					ginsengCNT = 0;
				}
				textFieldGinseng.setText(Integer.toString(ginsengCNT));
			}	
		});
		buttonGinsengMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonGinsengMinus.setBounds(243, 309, 40, 25);
		frame.getContentPane().add(buttonGinsengMinus);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("turmeric.jpg"));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(351, 242, 170, 92);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblGuavaRskg = new JLabel("Ginseng Rs .800/pack");
		lblGuavaRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuavaRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuavaRskg.setBounds(89, 327, 120, 30);
		frame.getContentPane().add(lblGuavaRskg);
		
		JLabel lblOrangeRskg = new JLabel("Turmeric Rs . 320/KG");
		lblOrangeRskg.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrangeRskg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrangeRskg.setBounds(381, 327, 120, 30);
		frame.getContentPane().add(lblOrangeRskg);
		
		JButton buttonTurmericPlus = new JButton("+");
		buttonTurmericPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turmericCNT++;
				if(turmericCNT > 20) {
					turmericCNT = 20;
					JOptionPane.showMessageDialog(null, "You can't buy more than 20!");
				}
				textFieldTurmeric.setText(Integer.toString(turmericCNT));
			}
		});
		buttonTurmericPlus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonTurmericPlus.setBounds(531, 242, 40, 25);
		frame.getContentPane().add(buttonTurmericPlus);
		
		textFieldTurmeric = new JTextField();
		textFieldTurmeric.setText("0");
		textFieldTurmeric.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTurmeric.setColumns(10);
		textFieldTurmeric.setBounds(531, 278, 40, 22);
		frame.getContentPane().add(textFieldTurmeric);
		
		JButton buttonTurmericMinus = new JButton("-");
		buttonTurmericMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turmericCNT--;
				if(turmericCNT < 0) {
					turmericCNT = 0;
				}
				textFieldTurmeric.setText(Integer.toString(turmericCNT));
			}
		});
		buttonTurmericMinus.setFont(new Font("Dialog", Font.BOLD, 9));
		buttonTurmericMinus.setBounds(531, 309, 40, 25);
		frame.getContentPane().add(buttonTurmericMinus);
		
		JButton btnNewButton_2 = new JButton("Place Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int x = 0;
				Connection conn =null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					if(basilCNT>0)
					{
						PreparedStatement stmt = conn.prepareStatement("select idProduct from product where ProductName = (?)");
						stmt.setString(1,"Basil");
						ResultSet rs = stmt.executeQuery();
						if(rs.next()!=false)
						{
							stmt = conn.prepareStatement("insert into cart(Cust_id,Product_id,Quantity) values (?,?,?)");
							stmt.setString(1,Integer.toString(id));
							stmt.setString(2,rs.getString("idProduct"));
							stmt.setString(3,Integer.toString(basilCNT));
							stmt.executeUpdate();
							x++;
						}
					}
					if(mintCNT>0)
					{
						PreparedStatement stmt = conn.prepareStatement("select idProduct from product where ProductName = (?)");
						stmt.setString(1,"Mint");
						ResultSet rs = stmt.executeQuery();
						if(rs.next()!=false)
						{
							stmt = conn.prepareStatement("insert into cart(Cust_id,Product_id,Quantity) values (?,?,?)");
							stmt.setString(1,Integer.toString(id));
							stmt.setString(2,rs.getString("idProduct"));
							stmt.setString(3,Integer.toString(mintCNT));
							stmt.executeUpdate();
							x++;
						}
					}
					if(ginsengCNT>0)
					{
						PreparedStatement stmt = conn.prepareStatement("select idProduct from product where ProductName = (?)");
						stmt.setString(1,"Ginseng");
						ResultSet rs = stmt.executeQuery();
						if(rs.next()!=false)
						{
							stmt = conn.prepareStatement("insert into cart(Cust_id,Product_id,Quantity) values (?,?,?)");
							stmt.setString(1,Integer.toString(id));
							stmt.setString(2,rs.getString("idProduct"));
							stmt.setString(3,Integer.toString(ginsengCNT));
							stmt.executeUpdate();
							x++;
						}
					}
					if(turmericCNT>0)
					{
						PreparedStatement stmt = conn.prepareStatement("select idProduct from product where ProductName = (?)");
						stmt.setString(1,"Turmeric");
						ResultSet rs = stmt.executeQuery();
						if(rs.next()!=false)
						{
							stmt = conn.prepareStatement("insert into cart(Cust_id,Product_id,Quantity) values (?,?,?)");
							stmt.setString(1,Integer.toString(id));
							stmt.setString(2,rs.getString("idProduct"));
							stmt.setString(3,Integer.toString(turmericCNT));
							stmt.executeUpdate();
							x++;
						}
					}
					if(x>0)
					{
						JOptionPane.showMessageDialog(null, "Order saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
						try {
							conn.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(229, 386, 160, 30);
		frame.getContentPane().add(btnNewButton_2);

	}

}
