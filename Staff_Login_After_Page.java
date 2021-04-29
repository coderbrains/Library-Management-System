package gniot_library;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import java.sql.*;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

@SuppressWarnings("serial")
public class Staff_Login_After_Page extends JFrame implements ActionListener{
	
	//-------> Start
	
	JMenuBar menuBar;
	JButton addStudent, lookStudent, returnBook, issueBook, removeStudent, addBook;
	JLabel jLabel;
	Container c;
	
	JLabel title, address, name, mob, gender, Dob, email, password, message;
	JTextField nam, mobi, e_mail, pass;
	JRadioButton male, female;
	JTextArea add, Message, details;
	JComboBox<String> day, month, year;
	JCheckBox box;
	JButton button;
	
	JInternalFrame jInternalFrame = null;
	
	//<------------ End
	
	//Constructor Starts ---------->
	public Staff_Login_After_Page() {
		
		c = getContentPane();
		
		menuBar = new JMenuBar();
		
		addStudent = new JButton("Add Student");
		lookStudent = new JButton("Look Student");
		returnBook = new JButton("Return Book");
		issueBook = new JButton("Issue Book");
		addBook = new JButton("ADD BOOK");
		removeStudent = new JButton("Remove Student");
		
		
		

		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		addStudent.setCursor(cursor);
		lookStudent.setCursor(cursor);
		returnBook.setCursor(cursor);
		issueBook.setCursor(cursor);
		removeStudent.setCursor(cursor);
		addBook.setCursor(cursor);
		
		Font f = new Font("aerial", Font.BOLD, 22);
		
		addStudent.setFont(f);
		lookStudent.setFont(f);
		returnBook.setFont(f);
		issueBook.setFont(f);
		removeStudent.setFont(f);
		addBook.setFont(f);
		
		
		
		menuBar.add(addStudent);
		menuBar.add(returnBook);
		menuBar.add(issueBook);
		menuBar.add(lookStudent);
		menuBar.add(removeStudent);
		menuBar.add(addBook);
		
		
		c.add(menuBar, BorderLayout.PAGE_START);
		
		addStudent.addActionListener(this);
		returnBook.addActionListener(this);
		issueBook.addActionListener(this);
		lookStudent.addActionListener(this);
		returnBook.addActionListener(this);
		addBook.addActionListener(this);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setTitle("Hello Staff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//<------------------Constructor ends
	
	
	//-----------------> Main funcion starts

	public static void main(String[] args) {
		
		new Staff_Login_After_Page();

	}
	//<----------------------Main function ends
	
	
	//----------------------> starts Button clicked handling

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == addStudent) {
			
			if(jInternalFrame != null) {
				jInternalFrame.dispose();
			}
			

			addStudent.setEnabled(false);
			jInternalFrame = new JInternalFrame("This is Internal jFrame", true, true, true, true);
			jInternalFrame.setLayout(null);
			jInternalFrame.setTitle("ADD A STUDENT");
			add(jInternalFrame, BorderLayout.CENTER);
			
			title = new JLabel();
			title.setText("New Student Registration Form");
			Font font1 = new  Font("arial", Font.BOLD, 20);
			title.setBounds(500, 40, 300, 30);
			title.setFont(font1);
			jInternalFrame.add(title);
			
			name = new JLabel();
			name.setBounds(240, 120, 60, 30);
			name.setText("Name - ");
			jInternalFrame.add(name);
			
			nam = new JTextField();

			nam.setToolTipText("Enter Your Full  name here");
			nam.setBounds(350, 125, 170, 20);
			jInternalFrame.add(nam);
			
			email = new JLabel();
			email.setBounds(750, 120, 60, 30);
			email.setText("Email - ");
			jInternalFrame.add(email);
			
			e_mail = new JTextField();
			email.setToolTipText("Enter Your E-mail Address Here");
			e_mail.setBounds(850, 125, 170, 20);
			jInternalFrame.add(e_mail);
			
			mob = new JLabel();
			mob.setBounds(240, 180, 60, 30);
			mob.setText("Mobile - ");
			jInternalFrame.add(mob);
			
			mobi = new JTextField();
			mobi.setBounds(350, 180, 170, 20);
			jInternalFrame.add(mobi);
			mobi.setToolTipText("Enter Mobile number without country code");
			
			password = new JLabel();
			password.setBounds(750, 180, 100, 30);
			password.setText("Password - ");
			jInternalFrame.add(password);
			
			pass = new JTextField();
			pass.setBounds(850, 180, 170, 20);
			jInternalFrame.add(pass);
			pass.setToolTipText("Create Password");
			
			gender = new JLabel();
			gender.setBounds(240, 235, 60, 30);
			gender.setText("Gender - ");
			jInternalFrame.add(gender);
			
			male = new JRadioButton();
			female = new JRadioButton();
			
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(male);
			buttonGroup.add(female);
			
			male.setBounds(350, 237, 60, 20);
			male.setText("Male");
			female.setBounds(420, 237, 90, 20);
			female.setText("Female");
			jInternalFrame.add(male);
			jInternalFrame.add(female);
			
			Dob = new JLabel();
			Dob.setBounds(240, 290, 60, 30);
			Dob.setText("DOB -");			
			jInternalFrame.add(Dob);
			
			
			
			String[] days = {
					"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
					"19","20","21","22","23","24","25","26","27","28","29","30","31"
			};
			
			String[] months = {
					"January", "February", "March", "April", "May", "June", "July", "August"
					,"September", "October", "november", "December"
			};
			
			String[] years = {
					"2001", "2002", "2003", "2004"
			};
			
			day = new JComboBox<String>(days);
			month = new JComboBox<String>(months);
			year = new JComboBox<String>(years);
			
			day.setBounds(350, 290, 50, 20);
			jInternalFrame.add(day);
			
			month.setBounds(410, 290, 80, 20);
			jInternalFrame.add(month);
			
			year.setBounds(500, 290, 60, 20);
			jInternalFrame.add(year);
			
			address = new JLabel();
			address.setBounds(240, 345, 60, 30);
			address.setText("Address -");
			jInternalFrame.add(address);
			
			add = new JTextArea();
			add.setBounds(350, 345, 210, 70);
			add.setLineWrap(true);
			jInternalFrame.add(add);
			
			box = new JCheckBox();
			box.setText("Accept The Terms and Conditions");
			box.setBounds(240, 450, 300, 30);
			jInternalFrame.add(box);
			
			button = new JButton();
			button.setText("Submit");
			Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
			button.setCursor(cursor);
			button.setBounds(1000   , 570, 200, 40);
			jInternalFrame.add(button);
			
			details = new JTextArea();
			details.setBounds(800, 300, 200, 200);
			jInternalFrame.add(details);
			details.setBackground(Color.RED);
			details.setForeground(Color.WHITE);
			details.setEditable(false);
			details.setLineWrap(false);
			
			//Submit button click listener **
			
			
			
			message = new JLabel();
			message.setText("Please Fill the Whole Form and then click on Submit");
			message.setLocation(240, 560);
			jInternalFrame.setIconifiable(true);
			message.setSize(500, 20);
			jInternalFrame.add(message);
			
			jInternalFrame.addInternalFrameListener(new InternalFrameListener() {
				
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					
					addStudent.setEnabled(true);
				}

				@Override
				public void internalFrameOpened(InternalFrameEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void internalFrameClosing(InternalFrameEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void internalFrameIconified(InternalFrameEvent e) {
					
					
				}

				@Override
				public void internalFrameDeiconified(InternalFrameEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void internalFrameActivated(InternalFrameEvent e) {
					
					button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								
								details.setText(null);
								
								if(nam.getText().equals("")) {
									message.setText("Please Fill the name field");
									JOptionPane.showMessageDialog(null, "Please Fill the name field");
									message.setForeground(Color.RED);
								}else if(mobi.getText().equals("")) {
									message.setText("Please Fill the mobile number ");
									JOptionPane.showMessageDialog(null, "Please Fill the mobile number field");
									message.setForeground(Color.RED);
								}else if(mobi.getText().length() != 10) {
									message.setText("Please Fill a valid Mobile Number");
									JOptionPane.showMessageDialog(null, "Please Fill the mobile number in 10 Integer digits field");
									message.setForeground(Color.RED);
								}else if(male.isSelected() == false && female.isSelected()  == false) {
									message.setText("Please Select The Gender");
									JOptionPane.showMessageDialog(null, "Please select the gender field");
									message.setForeground(Color.RED);
								}else if(add.getText().equals("")) {
									message.setText("Please Fill The Address");
									JOptionPane.showMessageDialog(null, "Please Fill the Address field");
									message.setForeground(Color.RED);
								}else if(box.isSelected() == false) {
									message.setText("Please Accept the Terms And Conditions");
									JOptionPane.showMessageDialog(null, "Please Accept the Terms and condition");
								}else {
									new BigInteger(mobi.getText());
									
									String gender ;
									if(male.isSelected()) {
										gender = "Male";
									}else gender = "Female";
		
									
									
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
										Login_through_credentails l = new Login_through_credentails();
										Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
										String query = "insert into student(name, e_mail, pass, mobile, gender, Death_of_Birth, address)values(?,?,?,?,?,?,?)";
										PreparedStatement st = c.prepareStatement(query);
										
										st.setString(1, nam.getText().toString());
										st.setString(2, e_mail.getText().toString());
										st.setString(3, pass.getText().toString());
										st.setString(4, mobi.getText().toString());
										st.setString(5, gender);
										st.setString(6, day.getSelectedItem() + " "+ month.getSelectedItem() + " " + year.getSelectedItem());
										st.setString(7, add.getText().toString());
										
										st.executeUpdate();
										c.close();
										st.close();
										
										
										
										message.setText("Registration Is SuccessFull");
										message.setForeground(Color.GREEN);
										
									} catch (Exception e1) {
										
										
										message.setText("Duplicate Entry of e-mail");
									}
									
									details.setText("Name - " + nam.getText() + "\n" +  "Mobile - " + mobi.getText() +"\n" +"Address - " + add.getText()
									+ "\n" + "Gender- " + gender + "\n" +"DOB - " + day.getSelectedItem() + " " 
									+ month.getSelectedItem() + " " + year.getSelectedItem() + "\n" + "E-mail - " + e_mail.getText().toString()
									 + "\n" + "Password - " + pass.getText().toString());
									
									nam.setText(null);
									mobi.setText(null);
									add.setText(null);
									e_mail.setText(null);
									pass.setText(null);
									
									
									
									
								}
								
							}catch(NumberFormatException nfe) {
								message.setText("Please Fill a Valid Mobile number");
								message.setForeground(Color.RED);
							}
							
						}
					});
					
				}

				@Override
				public void internalFrameDeactivated(InternalFrameEvent e) {
					// TODO Auto-generated method stub
					
				}
		
			});
			
			
//			jInternalFrame.setBounds(50, 50, 200, 300);
			jInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			jInternalFrame.setVisible(true);	
			validate();
			
		}
		
		//Look book Button clicked here....
		
		
		if(e.getSource() == lookStudent) {
			
			if(jInternalFrame != null) {
				jInternalFrame.dispose();
			}

			lookStudent.setEnabled(false);
			jInternalFrame = new JInternalFrame("This is Internal jFrame", true, true, true, true);
			jInternalFrame.setLayout(null);
			jInternalFrame.setTitle("SEARCH UPDATE STUDENT INFORMATION");
			add(jInternalFrame, BorderLayout.CENTER);
			
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
					lookStudent.setEnabled(true);
					
				}
				
				@Override
				public void internalFrameActivated(InternalFrameEvent e) {
					
					JTextField id = new JTextField();
					id.setBounds(500, 100, 150, 50);
					
					Font f = new Font("arial", Font.BOLD, 30);
					id.setFont(f);
				
					jInternalFrame.add(id);
					
					JButton show = new JButton();
					show.setText("SHOW DETAILS");
					show.setBounds(646, 100, 148, 49);
					jInternalFrame.add(show);
					
					//Show Button Clicked is handled here
					
					show.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try {
								int idd = Integer.parseInt(id.getText().toString());
								Class.forName("com.mysql.cj.jdbc.Driver");
								Login_through_credentails l1 = new Login_through_credentails();
								Connection c =DriverManager.getConnection(l1.url, l1.user, l1.pass);
								
								String sql = "select * from student where id = "  + idd;
								
								
								Statement st = c.createStatement();
								
								ResultSet rs = st.executeQuery(sql);
								
								if(rs.next()) {
									
									JOptionPane.showMessageDialog(null, "Id - " + rs.getString("id") + "\n"
									
										+"Name - "	+ rs.getString("name") + "\n" +
											"E-mail - " + rs.getString("e_mail") + "\n" + "Password - "  + rs.getString("pass")
											+"\n" + "Mobile - " + rs.getString("mobile")
											+ "\n" + "Address - " + rs.getString("address") + "\n" + "Gender - "
											+ rs.getString("gender") + "\n" + "Date of Birth" + rs.getString("Death_of_Birth"));
									
									int result = JOptionPane.showConfirmDialog(null, "Do you want Change the student Information", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
									if(result == JOptionPane.YES_OPTION) {
										
										id.setVisible(false);
										show.setVisible(false);
										title.setVisible(false);
										
										JButton another = new JButton();
										another.setText("CLICK TO CHECK ANOTHER");
										another.setBounds(500, 100, 200, 50);
										jInternalFrame.add(another);
										
										
										JLabel hintnameChange = new JLabel();
										hintnameChange.setText("Enter New Name -");
										hintnameChange.setBounds(300, 240, 150, 30);
										jInternalFrame.add(hintnameChange);
										
										JTextField nameChange = new JTextField();
										nameChange.setBounds(470, 240, 220, 30);
										jInternalFrame.add(nameChange);
										
										JButton changeNameButton = new JButton();
										changeNameButton.setText("CHANGE NAME");
										changeNameButton.setBounds(710, 240, 150, 30);
										jInternalFrame.add(changeNameButton);
										
										JLabel hintmobileChange = new JLabel();
										hintmobileChange.setText("Enter New Mobile -");
										hintmobileChange.setBounds(300, 300, 150, 30);
										jInternalFrame.add(hintmobileChange);
										
										JTextField mobileChange = new JTextField();
										mobileChange.setBounds(470, 300, 220, 30);
										jInternalFrame.add(mobileChange);
										
										JButton changemobileButton = new JButton();
										changemobileButton.setText("CHANGE MOBILE");
										changemobileButton.setBounds(710, 300, 150, 30);
										jInternalFrame.add(changemobileButton);
										
										JLabel hintemailChange = new JLabel();
										hintemailChange.setText("Enter New E-mail -");
										hintemailChange.setBounds(300, 350, 150, 30);
										jInternalFrame.add(hintemailChange);
										
										JTextField emailChange = new JTextField();
										emailChange.setBounds(470, 350, 220, 30);
										jInternalFrame.add(emailChange);
										
										JButton changemailButton = new JButton();
										changemailButton.setText("CHANGE EMAIL");
										changemailButton.setBounds(710, 350, 150, 30);
										jInternalFrame.add(changemailButton);
										
										JLabel hintpasswordChange = new JLabel();
										hintpasswordChange.setText("Enter New Password -");
										hintpasswordChange.setBounds(300, 400, 150, 30);
										jInternalFrame.add(hintpasswordChange);
										
										JTextField passChange = new JTextField();
										passChange.setBounds(470, 400, 220, 30);
										jInternalFrame.add(passChange);
										
										JButton changepasswordButton = new JButton();
										changepasswordButton.setText("CHANGE PASSWORD");
										changepasswordButton.setBounds(710, 400, 150, 30);
										jInternalFrame.add(changepasswordButton);
										
										
										JLabel hintaddChange = new JLabel();
										hintaddChange.setText("Enter New Address -");
										hintaddChange.setBounds(300, 450, 150, 30);
										jInternalFrame.add(hintaddChange);
										
										JTextField addChange = new JTextField();
										addChange.setBounds(470, 450, 220, 30);
										jInternalFrame.add(addChange);
										
										JButton changeaddressButton = new JButton();
										changeaddressButton.setText("CHANGE ADDRESS");
										changeaddressButton.setBounds(710, 450, 150, 30);
										jInternalFrame.add(changeaddressButton);
										
										Dob = new JLabel();
										Dob.setBounds(300, 500, 130, 30);
										Dob.setText("CHECK NEW DOB -");			
										jInternalFrame.add(Dob);
										
										
										
										String[] days = {
												"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
												"19","20","21","22","23","24","25","26","27","28","29","30","31"
										};
										
										String[] months = {
												"January", "February", "March", "April", "May", "June", "July", "August"
												,"September", "October", "november", "December"
										};
										
										String[] years = {
												"2001", "2002", "2003", "2004"
										};
										
										day = new JComboBox<String>(days);
										month = new JComboBox<String>(months);
										year = new JComboBox<String>(years);
										
										day.setBounds(470, 500, 50, 20);
										jInternalFrame.add(day);
										
										month.setBounds(520, 500, 80, 20);
										jInternalFrame.add(month);
										
										year.setBounds(600, 500, 60, 20);
										jInternalFrame.add(year);
										
										JButton changedate = new JButton("CHANGE DATE");
										changedate.setBounds(710, 500, 150, 30);
										jInternalFrame.add(changedate);
										
										
										
										
										another.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												another.setVisible(false);
												id.setVisible(true);
												show.setVisible(true);
												title.setVisible(true);
												id.setText(null);
												
												
												hintnameChange.setVisible(false);
												
												nameChange.setVisible(false);
												changeNameButton.setVisible(false);
												hintmobileChange.setVisible(false);
												mobileChange.setVisible(false);
												changemobileButton.setVisible(false);
												hintemailChange.setVisible(false);
												emailChange.setVisible(false);
												changemailButton.setVisible(false);
												hintpasswordChange.setVisible(false);
												passChange.setVisible(false);
												changepasswordButton.setVisible(false);
												
												
											}
										});
										
										changeNameButton.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												if(nameChange.getText().toString().equals("")) {
													JOptionPane.showMessageDialog(null, "Please Fill the name first");
												}else {
												
													String query = "update student set name = ? where id = ?";
													try {
														PreparedStatement pst = c.prepareStatement(query);
														pst.setString(1, nameChange.getText().toString());
														pst.setInt(2, idd);
														pst.executeUpdate();
														nameChange.setText(null);
														JOptionPane.showMessageDialog(null, "Successfully name changed");
					
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE, null);
													}
												}
												
												
											}
										});
										
										
										changemobileButton.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												if(mobileChange.getText().toString().equals("")) {
													JOptionPane.showMessageDialog(null, "Please Fill the Mobile number first");
												}else {
												
													String query = "update student set mobile = ? where id = ?";
													try {
														PreparedStatement pst = c.prepareStatement(query);
														pst.setString(1, mobileChange.getText().toString());
														pst.setInt(2, idd);
														pst.executeUpdate();
														JOptionPane.showMessageDialog(null, "Successfully mobile Number changed");
														mobileChange.setText(null);
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE, null);
													}
												}
												
												
											}
										});
										
										
										changeaddressButton.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												if(addChange.getText().toString().equals("")) {
													JOptionPane.showMessageDialog(null, "Please Fill the Address first");
												}else {
												
													String query = "update student set address = ? where id = ?";
													try {
														PreparedStatement pst = c.prepareStatement(query);
														pst.setString(1, addChange.getText().toString());
														pst.setInt(2, idd);
														pst.executeUpdate();
														addChange.setText(null);
														JOptionPane.showMessageDialog(null, "Successfully Address changed");
					
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE, null);
													}
												}
												
												
											}
										});
										
										
										
										changepasswordButton.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												if(passChange.getText().toString().equals("")) {
													JOptionPane.showMessageDialog(null, "Please Fill the New Password first");
												}else {
												
													String query = "update student set pass = ? where id = ?";
													try {
														PreparedStatement pst = c.prepareStatement(query);
														pst.setString(1, passChange.getText().toString());
														pst.setInt(2, idd);
														pst.executeUpdate();
														passChange.setText(null);
														JOptionPane.showMessageDialog(null, "Successfully Password changed");
					
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE, null);
													}
												}
												
												
											}
										});
										
										
										changemailButton.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												if(emailChange.getText().toString().equals("")) {
													JOptionPane.showMessageDialog(null, "Please Fill the E-mail ID first");
												}else {
												
													String query = "update student set e_mail = ? where id = ?";
													try {
														PreparedStatement pst = c.prepareStatement(query);
														pst.setString(1, emailChange.getText().toString());
														pst.setInt(2, idd);
														pst.executeUpdate();
														emailChange.setText(null);
														JOptionPane.showMessageDialog(null, "Successfully Email ID changed");
					
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														JOptionPane.showMessageDialog(null, "Error occured or may be Duplicate entry of email Id is not allowed", "Error", JOptionPane.ERROR_MESSAGE, null);
													}
												}
												
												
											}
										});
										
										changedate.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
													String query = "update student set Death_of_birth = ? where id = ?";
													try {
														PreparedStatement pst = c.prepareStatement(query);
														pst.setString(1,day.getSelectedItem().toString() + " " 
																+ month.getSelectedItem().toString()
																+ " " + year.getSelectedItem().toString());
														pst.setInt(2, idd);
														pst.executeUpdate();
														JOptionPane.showMessageDialog(null, "Successfully date_of_birth changed");
					
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														JOptionPane.showMessageDialog(null, "Error occured or may be Duplicate entry of email Id is not allowed", "Error", JOptionPane.ERROR_MESSAGE, null);
													}
												
											}
										});
										
										
										
										
										validate();
									}else {
										id.setText(null);
									}
								}else {
									JOptionPane.showMessageDialog(null, "There is no student with this Id");
									id.setText(null);
									
								}
								
								
								
							}catch(NumberFormatException NFE) {
								id.setText(null);
								JOptionPane.showMessageDialog(null, "Please Enter a valid Id. Only Integer is allowed");
							}catch(Exception eX) {
								JOptionPane.showMessageDialog(null, "Connection with the data Base is not possible");
							}
							
						}
					});
					
					
				}
			});
			
			title = new JLabel();
			title.setText("ENTER THE STUDENT'S ID : ");
			Font font1 = new  Font("arial", Font.BOLD, 20);
			title.setBounds(500, 40, 300, 30);
			title.setFont(font1);
			
			jInternalFrame.add(title);
			jInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			jInternalFrame.setVisible(true);	
			validate();
			
		}
		
		//Look student click stops here..........
		
		
		//Adding a book starts here ----------->
		
		if(e.getSource() == addBook) {
			
			if(jInternalFrame != null) {
				jInternalFrame.dispose();
			}
			
			addBook.setEnabled(false);
			jInternalFrame = new JInternalFrame("This is Internal jFrame", true, true, true, true);
			jInternalFrame.setLayout(null);
			jInternalFrame.setTitle("ADD A STUDENT");
			add(jInternalFrame, BorderLayout.CENTER);
			
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
					addBook.setEnabled(true);
					
				}
				
				@Override
				public void internalFrameActivated(InternalFrameEvent e) {
					
					JTextField id = new JTextField();
					id.setBounds(500, 100, 150, 50);
					
					Font f = new Font("arial", Font.BOLD, 30);
					id.setFont(f);
				
					jInternalFrame.add(id);
					
					JButton show = new JButton();
					show.setText("SHOW DETAILS");
					show.setBounds(646, 100, 148, 49);
					jInternalFrame.add(show);
					
					title = new JLabel();
					title.setText("ENTER THE BOOK ID : ");
					Font font1 = new  Font("arial", Font.BOLD, 20);
					title.setBounds(500, 40, 300, 30);
					title.setFont(font1);
					jInternalFrame.add(title);
					
					show.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							if(id.getText().toString().equals("")) {
								JOptionPane.showMessageDialog(null, "Enter a BookId first");
							}else {
								
								
								boolean exception = false;
								try {
									
									Integer.parseInt(id.getText().toString());
								}catch(NumberFormatException Nfe) {
									exception = true;
									JOptionPane.showMessageDialog(null, "Please Enter a Integer BookId");
									id.setText(null);
								}
								
								if(!exception) {
									
									
									try {
										
										
										Class.forName("com.mysql.cj.jdbc.Driver");
										Login_through_credentails rl = new Login_through_credentails();
										Connection c = DriverManager.getConnection(rl.url, rl.user, rl.pass);
										int bookId = Integer.parseInt(id.getText().toString().trim());
										String query = "select * from book where id = ?";
										PreparedStatement st = c.prepareStatement(query);
										st.setString(1, id.getText().toString());
										ResultSet rs = st.executeQuery();
										
										
										if(rs.next()) {
											id.setText(null);
											JOptionPane.showMessageDialog(null, "This book is already present :" + "\n" +"Id - " + rs.getString("id") + "\n"
													
										+"Name - "	+ rs.getString("name") + "\n" +"Author - " + rs.getString("author") + "\n" +
											"ISBN -  - " + rs.getString("isbn") + "\n" + "Publisher - "  + rs.getString("publisher")
											+"\n" + "Price - " + rs.getString("price"));

										}else {
											
											
											int result = JOptionPane.showConfirmDialog(null, "Do you want to add this book", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
											
											if(result == JOptionPane.YES_OPTION) {
												
												//Adding different fields for the addition of new book
												id.setVisible(false);
												show.setVisible(false);
												title.setVisible(false);
												
												Font f = new Font("aerial", Font.BOLD, 25);
												
												
												JLabel another = new JLabel();
												another.setText("FILL THE BELOW INFO TO ADD THE BOOK");
												another.setBounds(400, 50, 550, 50);
												another.setFont(f);
												jInternalFrame.add(another, BorderLayout.CENTER);
												another.setVisible(true);
												
												JLabel name = new JLabel();
												name.setText("Book Name - ");
												name.setFont(f);
												name.setBounds(350, 150, 200, 30);
												jInternalFrame.add(name);
												
												JTextField nameAdd = new JTextField();
												nameAdd.setBounds(570, 150, 250	, 30);
//												nameAdd.setFont(f);
												jInternalFrame.add(nameAdd);
												
												JLabel authorName = new JLabel();
												authorName.setText("Writter name - ");
												authorName.setFont(f);
												authorName.setBounds(350, 200, 200, 30);
												jInternalFrame.add(authorName);
												
												JTextField authorAdd = new JTextField();
												authorAdd.setBounds(570, 200, 250	, 30);
//												authorAdd.setFont(f);
												jInternalFrame.add(authorAdd);
												
												JLabel addisbn = new JLabel();
												addisbn.setText("Isbn no. - ");
												addisbn.setFont(f);
												addisbn.setBounds(350, 250, 200, 30);
												jInternalFrame.add(addisbn);
												
												JTextField isbnAdd = new JTextField();
												isbnAdd.setBounds(570, 250, 250	, 30);
//												isbnAdd.setFont(f);
												jInternalFrame.add(isbnAdd);
												
												JLabel addprice = new JLabel();
												addprice.setText("Price - ");
												addprice.setFont(f);
												addprice.setBounds(350, 300, 200, 30);
												jInternalFrame.add(addprice);
												
												JTextField priceAdd = new JTextField();
												priceAdd.setBounds(570, 300, 250	, 30);
//												priceAdd.setFont(f);
												jInternalFrame.add(priceAdd);
												
												
												JLabel publication = new JLabel();
												publication.setText("Publication - ");
												publication.setFont(f);
												publication.setBounds(350, 350, 250, 30);
												jInternalFrame.add(publication);
												
												JTextField publicationAdd = new JTextField();
												publicationAdd.setBounds(570, 350, 250	, 30);
//												publicationAdd.setFont(f);
												jInternalFrame.add(publicationAdd);
												
												JButton addition = new JButton();
												addition.setText("ADD BOOK");
												addition.setBounds(900, 450, 150, 50);
												jInternalFrame.add(addition);
												
												
												validate();
												
												
												addition.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent e) {
														
														if(nameAdd.getText().toString().equals("")) {
															JOptionPane.showMessageDialog(null, "Please Enter the name field");
														}else if(authorAdd.getText().toString().equals("")) {
															JOptionPane.showMessageDialog(null, "Please Enter the Author name");
														}else if(isbnAdd.getText().toString().equals("")) {
															JOptionPane.showMessageDialog(null, "Please Enter an ISBN number first  ");
														}else if(priceAdd.getText().toString().equals("")) {
															JOptionPane.showMessageDialog(null, "Please Enter The price of the book");
														}else if(publicationAdd.getText().toString().equals("")) {
															JOptionPane.showMessageDialog(null, "Please Enter The Publication name");
														}else {
															
															String query = "insert into book(id, name, author, isbn,publisher,price)"
																	+ "values(?,?,?,?,?,?)";
															try {
																
																PreparedStatement st = c.prepareStatement(query);
																st.setString(1, id.getText().toString());
																st.setString(2, nameAdd.getText().toString());
																st.setString(3, authorAdd.getText().toString());
																st.setString(4, isbnAdd.getText().toString());
																st.setString(5, publicationAdd.getText().toString());
																st.setString(6, priceAdd.getText().toString());
																st.executeUpdate();
																JOptionPane.showMessageDialog(null, "Successfully Added");
																
																
																nameAdd.setText(null);
																authorAdd.setText(null);
																isbnAdd.setText(null);
																priceAdd.setText(null);
																publicationAdd.setText(null);
																
																
																
																
																
																nameAdd.setVisible(false);
																authorAdd.setVisible(false);
																isbnAdd.setVisible(false);
																priceAdd.setVisible(false);
																publicationAdd.setVisible(false);
																
																name.setVisible(false);
																authorName.setVisible(false);
																addisbn.setVisible(false);
																addprice.setVisible(false);
																publication.setVisible(false);
																
																addition.setVisible(false);
																
																another.setVisible(false);
																
																title.setVisible(true);
																show.setVisible(true);
																id.setText(null);
																id.setVisible(true);																
															
																
															} catch (Exception e1) {

																JOptionPane.showMessageDialog(null, "An erropr occured");
															}
														}
														
													}
												});
												
											}else {
												id.setText(null);
											}
												
										
										}
										
										c.close();
										st.close();
										
									} catch (Exception e1) {
										id.setText(null);
										JOptionPane.showMessageDialog(null, "Some Error occured....");
									}
									
								}
							}
							
						}
					});
					
				}
			});

			jInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			jInternalFrame.setVisible(true);	
			validate();
					
		}
		
	//----------------------->Adding a book button clicked stops
	}
	
	//Button Clicked stops <-------------

}
