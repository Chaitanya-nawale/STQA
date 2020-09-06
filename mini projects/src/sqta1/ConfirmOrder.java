package sqta1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ConfirmOrder {

	private JFrame frame;
	private int appleCNT=0,mangoCNT=0,orangeCNT=0,guavaCNT=0;
	private int basilCNT=0,mintCNT=0,turmericCNT=0,ginsengCNT=0;
	public static void confirmation (int id, String name, JFrame f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmOrder window = new ConfirmOrder(id, name, f);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConfirmOrder(int id, String name, JFrame f) {
		initialize(id, name, f);
	}

	private void initialize(int id, String name, JFrame f) {
		frame = new JFrame();
		Connection conn = null;
		
		frame.setTitle("Order Confirmation");
		frame.setBounds(100, 100, 450, 548);
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Summary for "+name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 416, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirm Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn1 =null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					conn1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					PreparedStatement stmt = conn1.prepareStatement("delete from cart where Cust_id = (?)");
					stmt.setString(1,Integer.toString(id));
					int rs = stmt.executeUpdate();
					if(rs>0)
					{
						JOptionPane.showMessageDialog(null, "Your order is confirmed!\nYou will receive your order soon.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Your cart is empty!\nPlease add something to cart first.");
					}
				}	
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
				finally
				{
					if (conn1 != null)
					{
						try {
							conn1.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton.setBounds(260, 400, 116, 21);
		frame.getContentPane().add(btnNewButton);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			PreparedStatement stmt = conn.prepareStatement("select Product_id, sum(Quantity) Total from cart where Cust_id = (?) group by Product_id");
			stmt.setString(1,Integer.toString(id));
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				int quant = Integer.parseInt(rs.getString("Total"));
				stmt = conn.prepareStatement("select ProductName from product where idProduct = (?)");
				stmt.setString(1,rs.getString("Product_id"));
				ResultSet temp = stmt.executeQuery();
				if(temp.next())
				{
					String Pname = temp.getString("ProductName");
					switch(Pname)
					{
						case "Apple" : appleCNT = quant; break;
						case "Mango" : mangoCNT = quant; break;
						case "Orange" : orangeCNT = quant; break;
						case "Guava" : guavaCNT = quant; break;
						case "Basil" : basilCNT = quant; break;
						case "Mint" : mintCNT = quant; break;
						case "ginseng" : ginsengCNT = quant; break;
						case "Turmeric" : turmericCNT = quant; break;
					}
				}
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
		String op = "<html><pre>Products   |    Count    |    Total";
		op+="<br>------------------------------------";
		if(appleCNT>0)
			op+="<br>Apple      |      "+appleCNT+"      |     "+appleCNT*100;
		if(mangoCNT>0)
			op+="<br>Mango      |      "+mangoCNT+"      |     "+mangoCNT*150;
		if(orangeCNT>0)
			op+="<br>Orange     |      "+orangeCNT+"      |     "+orangeCNT*60;
		if(guavaCNT>0)
			op+="<br>Guava      |      "+guavaCNT+"      |     "+guavaCNT*80;
		if(basilCNT>0)
			op+="<br>Basil      |      "+basilCNT+"      |     "+basilCNT*100;
		if(mintCNT>0)
			op+="<br>Mint       |      "+mintCNT+"      |     "+mintCNT*80;
		if(ginsengCNT>0)
			op+="<br>Ginseng    |      "+ginsengCNT+"     |     "+ginsengCNT*800;
		if(turmericCNT>0)
			op+="<br>Turmeric   |      "+turmericCNT+"      |     "+turmericCNT*320;
		int TotalPrice = appleCNT*100+mangoCNT*150+guavaCNT*80+orangeCNT*60+basilCNT*100+mintCNT*80+ginsengCNT*800+turmericCNT*320;
		op+="<br>------------------------------------";
		op+="<br>Total Price                    "+TotalPrice+"</pre></html>";
		JLabel lblNewLabel_1 = new JLabel(op);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 59, 316, 331);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(60, 400, 116, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
