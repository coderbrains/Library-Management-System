package gniot_library;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame{
	
	String user, password;
	JTextField jTextField;
	JPasswordField jTextField1;
	
	public LoginPage() {	


		setResizable(false);
		setTitle("Student Login Page");
		setLayout(new BorderLayout());
		setBounds(400, 200, 500, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.cyan);
		add(jPanel, BorderLayout.CENTER);
		jPanel.setLayout(null);
		
		Cursor cursor = new Cursor(Cursor.TEXT_CURSOR);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("User_Name - ");
		
		jLabel.setBounds(100, 30, 200, 40);
		jPanel.add(jLabel);
		
		jTextField = new JTextField();
		jTextField.setBounds(203, 35, 200, 30);
		jTextField.setCursor(cursor);
		jPanel.add(jTextField);
		
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Password -  ");
		jLabel1.setBounds(100, 94, 200, 40);
		jPanel.add(jLabel1);
		
		jTextField1 = new JPasswordField();
		jTextField1.setBounds(203, 99, 200, 30);
		jTextField1.setEchoChar('*');
		jTextField1.setCursor(cursor);
		jPanel.add(jTextField1);		
		
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setText("Show Password");
		jCheckBox.setBounds(203, 135, 200, 20);
		jPanel.add(jCheckBox);
		
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
		
		
		
		JButton jButton = new JButton();
		jButton.setText("Login");
		Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR);
		jButton.setCursor(cursor1);
		jButton.setBounds(70, 200, 150, 30);
		jButton.setBackground(Color.MAGENTA);
		jPanel.add(jButton);
		
		
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
							break;
						}
					}
					
					if(!found) {
						JOptionPane.showMessageDialog(null, "Login Failed");
					}else {
						
						dispose();
						Thread.sleep(500);
						new Staff_Login_After_Page();
						
					}
					
					
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton back = new JButton("Forgot Password");
		back.setBounds(250,200, 150, 30);
		back.setBackground(Color.MAGENTA);
		jPanel.add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String e_mail = JOptionPane.showInputDialog("Enter Your Email Id :");
				if(e_mail.length() == 0) {
					JOptionPane.showMessageDialog(null, "No E-mail is entered");
				}else {
					
					try {
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Login_through_credentails l = new Login_through_credentails();
						Connection c = DriverManager.getConnection(l.url,l.user, l.pass);
						
						 String query = "select * from staff where email =  '" + e_mail + "'";
						 
						 Statement st = c.createStatement();
						 
						 ResultSet rs = st.executeQuery(query);
						 
						 if(rs.next()) {
							 
							 String password = JOptionPane.showInputDialog("Enter Your Password :");
								
								if(password.length() < 8) {
									JOptionPane.showMessageDialog(null, "Password must contain 8 letters");
								}else {
									
									query = "update staff set password = ? where email = ? ";
									 PreparedStatement pst = c.prepareStatement(query);
									 
									 pst.setString(1, password);
									 pst.setString(2, e_mail);
									 
									 pst.executeUpdate();
									 
									 JOptionPane.showMessageDialog(null, "SuccessFully changed");
								}
							 
							 
						 }else {
							 JOptionPane.showMessageDialog(null, "This E-mail is not registerd yet");
						 }
						
					}catch(Exception AE) {
						JOptionPane.showMessageDialog(null, "Some Error occured please try after sometime.");
					}
					
				}
				
			}
		});
		
		setVisible(true);
		revalidate();
	}

	
//	public static void main(String[] args) {
//		
//		new LoginPage();
//	}

}