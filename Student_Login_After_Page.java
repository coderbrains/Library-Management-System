package gniot_library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


@SuppressWarnings("serial")
public class Student_Login_After_Page extends JFrame implements ActionListener{
	
	JMenuBar jMenuBar;
	JButton seeAcount, changePass, seeBookAllotment, seeFines, mobileChange, logout; 
	JLabel jLabel1;
	JPanel jPanel;
	JInternalFrame jInternalFrame = null;
	public Student_Login_After_Page(int id ) {

		setVisible(true);
		setTitle("Hello Student ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(-7, 0, 1379, 740);
		setResizable(false);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		jPanel = new JPanel();
//		jInternalFrame = new JInternalFrame();
		jPanel.setVisible(true);
		jPanel.setBackground(Color.RED);
		add(jPanel, BorderLayout.CENTER);
		jPanel.setLayout(null);
		
		JLabel title = new JLabel();
		title.setText("\"SABSE BADA YOG EK DUSRE KA SAHYOG\"");
		title.setBounds(200, 5, 1000, 30);
		title.setBackground(Color.RED);
//		title.setForeground(Color.gray);
		title.setFont(new Font("aerial", Font.BOLD, 40));
		jPanel.add(title);
		
		ImageIcon icon = new ImageIcon("D:\\New folder\\JAVA PROJECTS\\java programs\\librarySystem\\src\\gniot_library\\download.jpg");
		JLabel image = new JLabel(icon,JLabel.CENTER);
		image.setBounds(420, 100, 500, 500);
		jPanel.add(image);
		
		
		Font font = new Font("aerial", Font.BOLD, 18);
		
		jMenuBar = new JMenuBar();
		
		jMenuBar.setSize(MAXIMIZED_HORIZ, 50);
		
		seeAcount =  new JButton("YOUR PROFILE");
		seeAcount.setFont(font);
		changePass = new JButton("CHANGE PASSWORD");
		changePass.setFont(font);
		seeBookAllotment = new JButton("BOOKS ALLOTED");
		seeBookAllotment.setFont(font);
		seeFines = new JButton("SEE FINES");
		seeFines.setFont(font);
		mobileChange = new JButton("CHANGE CONTACT");
		mobileChange.setFont(font);
		logout = new JButton("LOGOUT  ");
		logout.setFont(font);
		
		
		jMenuBar.add(seeAcount);
		jMenuBar.add(mobileChange);
		jMenuBar.add(seeBookAllotment);
		jMenuBar.add(seeFines);
		jMenuBar.add(changePass);
		jMenuBar.add(logout);
		
		JPanel jLabel = new JPanel();
		jLabel.setSize(MAXIMIZED_HORIZ, 10);
		jLabel.setBackground(Color.cyan);
		c.add(jLabel, BorderLayout.PAGE_END);
		
		jMenuBar.setLayout(new GridLayout(1,6));
		jMenuBar.setSize(MAXIMIZED_HORIZ, 30);
		c.add(jMenuBar , BorderLayout.PAGE_START);
		
		jLabel1 = new JLabel();
		
		
		
		logout.addActionListener(this);
		
		
		seeBookAllotment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jInternalFrame != null){
					
					jInternalFrame.dispose();
				
				}
				jPanel.setVisible(false);
				seeBookAllotment.setEnabled(false);
				jInternalFrame = new JInternalFrame("This is Internal jFrame", true, true, true, true);
				jInternalFrame.setVisible(true);
				jInternalFrame.setLayout(new BorderLayout());
				c.add(jInternalFrame, BorderLayout.CENTER);

				
				JList<String> jList = new JList<String>();
				JPanel jPanel1 = new JPanel();
				jPanel1.setLayout(new GridLayout(1,1));
//				jPanel1.setBounds(280, 0, 1074,  638);
				jPanel1.add(new JScrollPane(jList));
				jInternalFrame.add(jPanel1);
				
				DefaultListModel<String> dModel = new DefaultListModel<>();
				jList.setFont(font);
				
				try {
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Login_through_credentails  l = new Login_through_credentails();
					Connection c = DriverManager.getConnection(l.url,l.user, l.pass);
					
					String query = "select * from issue_book, book where issue_book.book_id =  book.id and issue_book.student_id =  " + id;
					
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(query);
			
					while(rs.next()) {
						
						dModel.add(0, ">>");
						dModel.add(1, "\nBook id - " + rs.getInt("issue_book.book_id"));
						dModel.add(2,  "Book Name - " + rs.getString("name"));
						dModel.add(3, "Author - " + rs.getString("author"));
						dModel.add(4, "ISBN - " + rs.getString("isbn"));
						dModel.add(5, "Publisher - " +  rs.getString("publisher"));
						dModel.add(6, "Price of the book - " + rs.getString("price"));
						dModel.add(7, "Issue Date - " + rs.getString("issue_date"));
						dModel.add(8, "Return date - " + rs.getString("return_date"));
						dModel.add(9, "\n");
						jList.setModel(dModel);
					}
					
					
					c.close();
					st.close();
					
				}catch(Exception Ae) {
					JOptionPane.showMessageDialog(null, "Connection with the database is not possible...");
				}
				
				jInternalFrame.addInternalFrameListener(new InternalFrameListener() {
					
					@Override
					public void internalFrameOpened(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameIconified(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameDeiconified(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameClosed(InternalFrameEvent e) {
						seeBookAllotment.setEnabled(true);
						jPanel.setVisible(true);
						
					}
					
					@Override
					public void internalFrameActivated(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}
		});
		
		seeFines.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				if(jInternalFrame != null) {
					
					jInternalFrame.dispose();
				}
				
				jPanel.setVisible(false);
				seeFines.setEnabled(false);
				jInternalFrame = new JInternalFrame("This is Internal jFrame", true, true, true, true);
				jInternalFrame.setVisible(true);
				jInternalFrame.setLayout(new BorderLayout());
				c.add(jInternalFrame, BorderLayout.CENTER);
				JList<String> jList = new JList<String>();
				JPanel jPanel1 = new JPanel();
				jPanel1.setLayout(new GridLayout(1,1));
				jPanel1.add(new JScrollPane(jList));
				jInternalFrame.add(jPanel1);
				
				DefaultListModel<String> dModel = new DefaultListModel<>();
				jList.setFont(font);
				
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Login_through_credentails  l = new Login_through_credentails();
					Connection c = DriverManager.getConnection(l.url,l.user, l.pass);
					
					String query = "select * from fine_table, student where student.id = fine_table.student_id and student.id = " + id;
					
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(query);
					
					int total_fine = 0;
					Statement st1 = c.createStatement();
					while(rs.next()) {
					
						
						int bookId = rs.getInt("fine_table.book_id");
						String sql = "select * from book where id = " + bookId;
						st1  = c.createStatement();
						ResultSet book_info = st1.executeQuery(sql);
						book_info.next();
		
						dModel.add(0, ">>");
						dModel.add(1, "\nBook id - " + rs.getInt("fine_table.book_id"));
						dModel.add(2,  "Book Name - " + book_info.getString("name"));
						dModel.add(3, "Author - " + book_info.getString("author"));
						dModel.add(4, "ISBN - " + book_info.getString("isbn"));
						dModel.add(5, "Publisher - " + book_info.getString("publisher"));
						dModel.add(6, "Price of the book - " + book_info.getString("price"));
						dModel.add(7, "Actual return Date - " + rs.getString("actual_return_date"));
						dModel.add(8, "Expected return date - " + rs.getString("expected_return_date"));
						dModel.add(9, "Number of days late - " + rs.getString("Number_of_days_late"));
						dModel.add(10, "Fine Amount - " + rs.getString("fine_amount"));
						dModel.add(11, "\n");
						total_fine += rs.getInt("fine_amount");
						jList.setModel(dModel);
					}
					
					dModel.add(0, "Total fine = " + total_fine);
					dModel.add(1, "\n");
					jList.setForeground(Color.black);
					jList.setModel(dModel);
					
					c.close();
					st.close();
					st1.close();
					
				}catch(Exception Ae) {
					JOptionPane.showMessageDialog(null, "Connection with the database is not possible...");
				}
				
				
				jInternalFrame.addInternalFrameListener(new InternalFrameListener() {
					
					@Override
					public void internalFrameOpened(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameIconified(InternalFrameEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void internalFrameDeiconified(InternalFrameEvent e) {
						
						
						
					}
					
					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {
						
						jInternalFrame.dispose();
					}
					
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						
						
						
					}
					
					@Override
					public void internalFrameClosed(InternalFrameEvent e) {
						seeFines.setEnabled(true);

						jPanel.setVisible(true);
						
					}
					
					@Override
					public void internalFrameActivated(InternalFrameEvent e) {
						
						
					}
				});
				
				
				
			}
		});
		
		
		mobileChange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jPanel.setVisible(true);
				seeFines.setEnabled(true);
				seeBookAllotment.setEnabled(true);
				if(jInternalFrame != null) {
					jInternalFrame.dispose();
				}
				
							
				jPanel.setVisible(true);
					
						try {
							
							String number = JOptionPane.showInputDialog("Enter Your Number here - ");
							new BigInteger(number );
							
							if(number.length() != 10  || number.length() == 0) {
								JOptionPane.showMessageDialog(null, "Invalid number format");
							}else {
								int result = JOptionPane.showConfirmDialog(null, "Do You want to change your number to : " + number, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								
								if(result == JOptionPane.YES_OPTION) {
									
									
									Class.forName("com.mysql.cj.jdbc.Driver");
									Login_through_credentails l = new Login_through_credentails();
									Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
								
									String query = "update student set mobile = '" + number + "' where id = " + id;
									
									PreparedStatement st = c.prepareStatement(query);
									
									st.executeUpdate();
									
									JOptionPane.showMessageDialog(null, "Successfull...");

									c.close();
									st.close();
								}else {
									JOptionPane.showMessageDialog(null, "No change is done");
								}
								
							}
							
						}catch(NumberFormatException Ne) {
							
							JOptionPane.showMessageDialog(null, "Invaid number format.");
							
						}catch(Exception ce) {
							JOptionPane.showMessageDialog(null, "Not changed");
						}
					}
		});
		
		changePass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jPanel.setVisible(true);
				seeBookAllotment.setVisible(true);
				seeFines.setVisible(true);
				if(jInternalFrame != null) {
					jInternalFrame.dispose();
				}
				
				try {
					
					String pass1 = JOptionPane.showInputDialog(null, "Please Enter your new Password :");
					String pass2;
					
					if(pass1.length() < 8) {
						
						JOptionPane.showMessageDialog(null, "Password is minimum of 8 length");
					
					}else if(pass1.length() >= 8) {
						
						pass2 = JOptionPane.showInputDialog(null, "Re-enter your password : ");
						
						if(pass1.equals(pass2)) {
							
							JOptionPane.showMessageDialog(null, "Password Matched....");
							
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Login_through_credentails l = new Login_through_credentails();
							Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
							
							String query = "update student set pass = ? where id = ?";
							
							PreparedStatement pst = c.prepareStatement(query);
							
							pst.setString(1, pass1);
							pst.setInt(2, id);
							
							pst.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Sucessfully changed");
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Password do not match");
							
						}
					}
					
				}catch(Exception AE) {
					JOptionPane.showMessageDialog(null, "Password was not changed...");
				}
				
			}
		});
		
		
		
		
		seeAcount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jPanel.setVisible(true);
				if(jInternalFrame != null) {
					jInternalFrame.dispose();
				}
				
				
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
				
					c.close();
					st.close();
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
		int result = 	JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Sure", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null);
			if(result == JOptionPane.YES_OPTION) {
				dispose();
				new Login_Page_student();
			}
			
		}
		
		
		
		
		
		
	}

}
