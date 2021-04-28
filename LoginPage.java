package gniot_library;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame{
	
	String user, password;
	JTextField jTextField;
	JPasswordField jTextField1;
	
	public LoginPage() {	


		Container container = getContentPane();
		setTitle("Login Page");
		container.setLayout(null);
		Cursor cursor = new Cursor(Cursor.TEXT_CURSOR);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("User_Name - ");
		jLabel.setBounds(100, 30, 200, 40);
		container.add(jLabel);
		
		jTextField = new JTextField();
		jTextField.setBounds(203, 35, 200, 30);
		jTextField.setCursor(cursor);
		container.add(jTextField);
		
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Password -  ");
		jLabel1.setBounds(100, 94, 200, 40);
		container.add(jLabel1);
		
		jTextField1 = new JPasswordField();
		jTextField1.setBounds(203, 99, 200, 30);
		jTextField1.setEchoChar('*');
		jTextField1.setCursor(cursor);
		container.add(jTextField1);		
		
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setText("Show Password");
		jCheckBox.setBounds(203, 135, 300, 20);
		container.add(jCheckBox);
		jCheckBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(jCheckBox.isSelected()) {
					jTextField1.setEchoChar((char)0);
				}else {
					jTextField1.setEchoChar('*');
				}
				
			}
		});
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Login Required");
		jLabel2.setBounds(150, 200, 190, 60);
		container.add(jLabel2);
		
		
		JButton jButton = new JButton();
		jButton.setText("Login");
		Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR);
		jButton.setCursor(cursor1);
		jButton.setBounds(100, 160, 100, 30);
		container.add(jButton);
		jButton.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					Login_through_credentails l = new Login_through_credentails();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
					
					String query = "select * from staff";
					PreparedStatement st = c.prepareStatement(query);
					
					String username = jTextField.getText().toString();
					@SuppressWarnings("deprecation")
					String passw = jTextField1.getText().toString();
					
					jTextField.setText(null);
					jTextField1.setText(null);
					
					ResultSet rs = st.executeQuery();
					boolean found = false;
					while(rs.next()) {
						String user1 = rs.getString(3);
						String pass = rs.getString(4);
						if(username.equals(user1) && passw.equals(pass)) {
							found = true;
//							JOptionPane.showMessageDialog(null, "Login Successfull...");
							dispose();
							new Staff_Login_After_Page();
						}
					}
					
					if(!found) {
						JOptionPane.showMessageDialog(null, "Login Failed");
					}
					
					
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton back = new JButton("Back");
		back.setBounds(220, 160, 100, 30);
		add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new LoginAsk_Screen();
				
			}
		});
		
		setVisible(true);
		setSize(300, 300);
		setResizable(false);
		setBounds(200, 200, 500, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}