package gniot_library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student_Entry_Exit extends JFrame{
	
	public Student_Entry_Exit() {
	
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(-5, -1, 1379, 740);
		
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
		JTextField jTextField = new JTextField();
		jPanel1.add(jTextField);
		JButton jButton= new JButton("ENTRY");
		jPanel1.add(jButton);

		
		JLabel jLabel23 = new JLabel("Enter Student_Id to Exit - ");

		jLabel23.setFont(new Font("aerial", Font.BOLD, 18));
		jPanel1.add(jLabel23);
		JTextField jTextField1 = new JTextField();
		jPanel1.add(jTextField1);
		JButton jButton1  = new JButton("ENTRY");
		jPanel1.add(jButton1);
				
		
		
		
		
		
		
		
		
		
		
		  JInternalFrame frame1 = new JInternalFrame("Showing Student Information Entered The Libraray");
		  frame1.setVisible(true);
	        frame1.setLayout(new BorderLayout());

	//TableModel tm = new TableModel();

	        DefaultTableModel model = new DefaultTableModel();
	        
	        String[] columnNames = {"Student ID", "Student Name ", "Email", "Entry Time"};

	        model.setColumnIdentifiers(columnNames);

	//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

	//table = new JTable(model);
	        
	        JTable table  = new JTable();

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
	        
	        DateTimeFormatter hello = DateTimeFormatter.ofPattern("dd-MM-yyyy        HH::mm::ss");
			LocalDateTime l1 =  LocalDateTime.now();
//			dateTextField.setText(hello.format(l));
			String entry_date =  hello.format(l1);
			
			entry = entry_date;
	        
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
	    
	        frame1.add(scroll);

	        frame1.setVisible(true);

	        frame1.setSize(400, 300);
	        
	        
		
		
		
		add(frame1, BorderLayout.CENTER);
		
		
		
		

		validate();
	}
	
	public static void main(String[] args) {
		
		new Student_Entry_Exit();

	}

}
