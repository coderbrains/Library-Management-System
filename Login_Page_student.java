package gniot_library;


import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login_Page_student extends JFrame{
	
	String user, password;
	JTextField jTextField;
	JPasswordField jTextField1;
	
	String user1;
	
	public Login_Page_student() {	


		
		setTitle("Login Page For Student");
		setLayout(null);
		Cursor cursor = new Cursor(Cursor.TEXT_CURSOR);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("User_Name - ");
		jLabel.setBounds(100, 30, 200, 40);
		add(jLabel);
		
		jTextField = new JTextField();
		jTextField.setBounds(203, 35, 200, 30);
		jTextField.setCursor(cursor);
		add(jTextField);
		
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Password -  ");
		jLabel1.setBounds(100, 94, 200, 40);
		add(jLabel1);
		
		jTextField1 = new JPasswordField();
		jTextField1.setBounds(203, 99, 200, 30);
		jTextField1.setEchoChar('*');
		jTextField1.setCursor(cursor);
		add(jTextField1);		
		
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setText("Show Password");
		jCheckBox.setBounds(203, 135, 300, 20);
		add(jCheckBox);
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
		add(jLabel2);
		
		
		JButton jButton = new JButton();
		jButton.setText("Login");
		Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR);
		jButton.setCursor(cursor1);
		jButton.setBounds(100, 160, 100, 30);
		add(jButton);
		jButton.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					Login_through_credentails l = new Login_through_credentails();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
					
					String query = "select e_mail, pass from student";
					Statement st = c.createStatement();
					
					String username = jTextField.getText().toString();
					@SuppressWarnings("deprecation")
					String passw = jTextField1.getText().toString();
					
					jTextField.setText(null);
					jTextField1.setText(null);
					
					ResultSet rs = st.executeQuery(query);
					boolean found = false;
					
					while(rs.next()) {
						
						
						user1 = rs.getString("e_mail");
						String pass = rs.getString("pass");
					
						if(user1.equals(username) && passw.equals(pass)) {
							found = true;
							break;
						}
					}
					
					if(!found) {
						JOptionPane.showMessageDialog(null, "Login Failed");
					}else {
						
						dispose();
						Thread.sleep(500);
						int id = rs.getInt("id");
						new Student_Login_After_Page(id);
						
					}
					
					
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Some Error occured");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		
		new Login_Page_student();


	}

}
