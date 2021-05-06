package gniot_library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class Student_Entry_Exit extends JFrame implements ActionListener{
	
	JButton jButton1, jButton;
	JTextField jTextField, jTextField1;
	DefaultTableModel model;
	JTable table;
	
	public Student_Entry_Exit() {
	
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(-5, -1, 1379, 740);
		
		//TableModel tm = new TableModel();

        model = new DefaultTableModel();
        
        String[] columnNames = {"Student ID", "Student Name ", "Email", "Entry Time"};

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);
        
      table  = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

//String textvalue = textbox.getText();

        int id= 0;

        String name = "";

        String email = "";

        String entry = "";
        
        try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Login_through_credentails l = new Login_through_credentails();	        	
        	Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
        	
        	Statement st = c.createStatement();
        	
        	ResultSet rs = st.executeQuery("select * from library_entry_instant");
        	
        	while(rs.next()) {	
        		
        		id =  rs.getInt("id");
        		entry = rs.getString("entry_time");
        		String sql = "select name , e_mail from student where id = " + id;
        		Statement pst = c.createStatement();
        		ResultSet rs1 = pst.executeQuery(sql);
        		rs1.next();
        		name = rs1.getString("name");
        		email = rs1.getString("e_mail");
        		
        		model.addRow(new Object[] {id, name,email, entry});
        	}
        	
        	
        	
        }catch(Exception E) {
        	JOptionPane.showMessageDialog(null, "Fetching result is difficult this time.....");
        }
		
		
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.DARK_GRAY);
		jPanel.setVisible(true);
		jPanel.setLayout(new GridLayout(1,1));
		jPanel.setSize(MAXIMIZED_HORIZ, 30);
		add(jPanel, BorderLayout.PAGE_END);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("Writable");
		jLabel.setFont(new Font("aeria", Font.BOLD	, 20));
		jPanel.add(jLabel);
		
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(Color.MAGENTA);
		jPanel1.setVisible(true);
		jPanel1.setLayout(new GridLayout(1,6));
		jPanel1.setSize(MAXIMIZED_HORIZ, 30);
		add(jPanel1, BorderLayout.PAGE_START);
		
		
		JLabel jLabel2 = new JLabel("Enter Student_Id - ");

		jLabel2.setFont(new Font("aerial", Font.BOLD, 18));
		jPanel1.add(jLabel2);
		jTextField = new JTextField();
		jPanel1.add(jTextField);
		jButton= new JButton("ENTRY");
		jPanel1.add(jButton);

		
		JLabel jLabel23 = new JLabel("Enter Student_Id to Exit - ");

		jLabel23.setFont(new Font("aerial", Font.BOLD, 18));
		jPanel1.add(jLabel23);
		jTextField1 = new JTextField();
		jPanel1.add(jTextField1);
		jButton1  = new JButton("EXIT");
		jPanel1.add(jButton1);
				
		
		jButton.addActionListener(this);
		jButton1.addActionListener(this);
		
		
		
		
		
		
		
		
		  JInternalFrame frame1 = new JInternalFrame("Showing Student Information Entered The Libraray");
		  frame1.setVisible(true);
	        frame1.setLayout(new BorderLayout());


	        
	        frame1.add(scroll);

	        frame1.setVisible(true);

	        frame1.setSize(400, 300);
	        
	        
		
		
		
		add(frame1, BorderLayout.CENTER);
		
		
		
		

		validate();
	}
	
//	public static void main(String[] args) {
//		
//		new Student_Entry_Exit();
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jButton) {
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
	        	Login_through_credentails l = new Login_through_credentails();	        	
	        	Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
	        	
				int id1 = 0;
				String id = jTextField.getText().toString();
				jTextField.setText(null);
				//If the id entered has Zero length
				if(id.length() == 0 ) {
					JOptionPane.showMessageDialog(null, "Please Enter Student Id :");
				}
				
				//If the Id present has more than one length
				else{
					
					//This try is for checking that whether the Id Entered is in Integer Format or not.
					
					try {
						id1 = Integer.parseInt(id);
						
						String sql =  "select id from student where id = " + id1;
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery(sql);
						
						//To check whether the Id is Present in the Student table or not
						
						if(rs.next()) {
							
							//If the Id is present in the databse then we will again check that whether it is present in the 
							//Libraray or not . If the student is already entered the library then no need to enter again.
							sql = "select id from library_entry_instant where id = " + id1;
							rs = st.executeQuery(sql);
							
							if(rs.next()) {
								JOptionPane.showMessageDialog(null, "This student is already present in the Library");
							}
							
							//If the student is present in the Databse but not entered the library
							
							else {
								String query = "select name , e_mail from student where id = " + id1;
								rs = st.executeQuery(query);
								rs.next();
								sql = "insert into library_entry_instant(id, name, email, entry_time)values(?,?,?,?)";
								
								PreparedStatement pst = c.prepareStatement(sql);
								pst.setInt(1, id1);
								pst.setString(2, rs.getString("name"));
								pst.setString(3, rs.getString("e_mail"));
								
								DateTimeFormatter hello = DateTimeFormatter.ofPattern("dd-MM-yyyy        HH::mm::ss");
								LocalDateTime l1 =  LocalDateTime.now();
								String entry_date =  hello.format(l1);
								
								pst.setString(4, entry_date);
								
								pst.executeUpdate();
								
								String name = rs.getString("name");
								String emailId = rs.getString("e_mail");
								
								model.addRow(new Object[] {id1, name, emailId, entry_date});
								
								JOptionPane.showMessageDialog(null, "Allowed to enter");
								
							
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "This Id is not present in the Student databse");
						}
						
						
					}catch(NumberFormatException NFE) {
						JOptionPane.showMessageDialog(null, "Please Enter The correct Id . Only Integer is Allowed");
					}
					
				}
				
				
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null, "Connection with the databse is not possible right now.");
			}
		}
		
		
		//For Exit Button Code Sniffet
		if(e.getSource() == jButton1) {
			
			String id = jTextField1.getText().toString();
			jTextField1.setText(null);
			
			if(id.length() == 0) {
				
				JOptionPane.showMessageDialog(null, "Please Enter a Student Id :");
				
			}else {
				
				int id1 =0;
				try {
					

					id1 = Integer.parseInt(id);
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
			        	Login_through_credentails l = new Login_through_credentails();	        	
			        	Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
			        	String sql = "select * from library_entry_instant where id = " + id1;
						Statement st = c.createStatement();
						ResultSet   rs = st.executeQuery(sql);
						
						
						if(rs.next()) {
							
							
							
							int result = JOptionPane.showConfirmDialog(null, "Do you want to exit the student ?",	 "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							
							
							if(result == JOptionPane.YES_OPTION) {
								
								
								String name = rs.getString("name");
								String email = rs.getString("email");
								String entry_time = rs.getString("entry_time");
								DateTimeFormatter hello = DateTimeFormatter.ofPattern("dd-MM-yyyy        HH::mm::ss");
								LocalDateTime l1 =  LocalDateTime.now();
								String exit_time =  hello.format(l1);
								
								sql = "delete from library_entry_instant where id = " + id1;
								st.executeUpdate(sql);
								
								sql = "insert into library_entry(id, name, email, entry_time, exit_time)values(?,?,?,?,?)";
								
								PreparedStatement pst = c.prepareStatement(sql);
								pst.setInt(1, id1);
								pst.setString(2, name);
								pst.setString(3, email);
								pst.setString(4, entry_time);
								pst.setString(5, exit_time);
								pst.executeUpdate();
							
								int id2;

						        String name2 = "";

						        String email2 = "";

						        String entry = "";
						        
						        try {
						        	  model = new DefaultTableModel();
						              
						              String[] columnNames = {"Student ID", "Student Name ", "Email", "Entry Time"};

						              model.setColumnIdentifiers(columnNames);
						              table.setModel(model);
						        	st = c.createStatement();
						        	
						        	rs = st.executeQuery("select * from library_entry_instant");
						        	
						        	while(rs.next()) {	
						        		
						        		id2 =  rs.getInt("id");
						        		entry = rs.getString("entry_time");
						        		sql = "select name , e_mail from student where id = " + id;
						        		Statement pst2 = c.createStatement();
						        		ResultSet rs1 = pst2.executeQuery(sql);
						        		rs1.next();
						        		name = rs1.getString("name");
						        		email = rs1.getString("e_mail");
						        		model.addRow(new Object[] {id2, name2,email2, entry});
						        	}
						        	
						        	
						        	
						        }catch(Exception E) {
						        	JOptionPane.showMessageDialog(null, "Fetching result is difficult this time.....");
						        }
								
								
								
							}else {
								JOptionPane.showMessageDialog(null, "This student is not get exit from the library");
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "This student is admitted to the library");
						}
					}catch(Exception E) {
						
						E.printStackTrace();
						JOptionPane.showMessageDialog(null, "Connection with the database cannot be established");
						
					}
					
					
				}catch(Exception E) {
					JOptionPane.showMessageDialog(null, "ops! This is an invalid Id format.");
				}
				
				
			}
		}
		
	}

}
