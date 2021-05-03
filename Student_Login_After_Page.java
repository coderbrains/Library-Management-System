package gniot_library;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class Student_Login_After_Page extends JFrame implements ActionListener{
	
	JMenuBar jMenuBar;
	JButton seeAcount, changePass, seeBookAllotment, seeFines, mobileChange, logout; 
	
	public Student_Login_After_Page(int id ) {

		setVisible(true);
		setTitle("Hello Student ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, 0, 1000, 1000);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Container c = getContentPane();
		GridBagLayout gb = new GridBagLayout();
		c.setLayout(gb);
		
		Font font = new Font("aerial", Font.BOLD, 18);
		
		seeAcount =  new JButton("YOUR PROFILE");
		seeAcount.setFont(font);
		changePass = new JButton("CHANGE PASSWORD");
		changePass.setFont(font);
		seeBookAllotment = new JButton("BOOKS ALLOTED");
		seeBookAllotment.setFont(font);
		seeFines = new JButton("FINES");
		seeFines.setFont(font);
		mobileChange = new JButton("CHANGE CONTACT");
		mobileChange.setFont(font);
		logout = new JButton("LOGOUT");
		logout.setFont(font);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 0;
		//These gridx and gridy are the constraints variable for the placement of the buttons
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		c.add(seeAcount, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		c.add(changePass, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		c.add(seeBookAllotment, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		c.add(seeFines, gbc);
		

		gbc.gridx = 4;
		gbc.gridy = 0;
		c.add(mobileChange, gbc);
		

		gbc.gridx = 5;
		gbc.gridy = 0;
		c.add(logout, gbc);
		
		gbc.gridwidth = 6;
		ImageIcon icon = new ImageIcon("D:\\New folder\\JAVA PROJECTS\\java programs\\librarySystem\\src\\gniot_library\\download.jpg");
//		JLabel jLabel = new JLabel();
		JLabel jPanel = new JLabel(icon, JLabel.CENTER);
		jPanel.setBackground(Color.RED);
		gbc.ipady = 500;    // for looking the taller button
		gbc.weightx = 1;
		gbc.ipadx = 1180;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		c.add(jPanel, gbc);
		
		
		
		pack();
		
		logout.addActionListener(this);
		seeAcount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Login_through_credentails l = new Login_through_credentails();
					Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
					
					String query = "select * from student where id = " + id;
					
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(query);
					
					rs.next();
					
					JOptionPane.showMessageDialog(null, "Hello " + rs.getString("name") + "\n"
							+ "This is your detalied profile : \n" +"Id - " + rs.getString("id") + "\n"
									
										+"Name - "	+ rs.getString("name") + "\n" +"Email - " + rs.getString("e_mail") + "\n" +
											"Password -  - " + rs.getString("pass") + "\n" + "Mobile number - "  + rs.getString("mobile")
											+"\n" + "Address - " + rs.getString("address"));
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Connection with the database is not possible...");
				}
				
			}
		});
		
		
		
		validate();
	}

	public static void main(String[] args) {
		new Student_Login_After_Page(16);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == logout) {
			
			dispose();
			new Login_Page_student();
		}
		
		
		
	}

}
