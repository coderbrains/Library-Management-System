package gniot_library;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class Staff_Login_After_Page extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JButton addStudent, lookStudent, returnBook, issueBook;
	JLabel jLabel;
	Container c;
	public Staff_Login_After_Page() {
		
		c = getContentPane();
		
		menuBar = new JMenuBar();
		
		addStudent = new JButton("Add Student");
		lookStudent = new JButton("Look Student");
		returnBook = new JButton("Return Book");
		issueBook = new JButton("Issue Book");
		
		Font f = new Font("aerial", Font.BOLD, 22);
		
		addStudent.setFont(f);
		lookStudent.setFont(f);
		returnBook.setFont(f);
		issueBook.setFont(f);
		
		menuBar.add(addStudent);
		menuBar.add(returnBook);
		menuBar.add(issueBook);
		menuBar.add(lookStudent);
		
		
		add(menuBar, BorderLayout.PAGE_START);
		
		addStudent.addActionListener(this);
		
		setBounds(200, 20, 1000, 700);
		setVisible(true);
		setResizable(false);
		setTitle("Hello Staff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		new Staff_Login_After_Page();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource() == addStudent) {
			JInternalFrame jInternalFrame = new JInternalFrame("This is Internal jFrame", true, true, true, true);
			
			jInternalFrame.setLayout(null);
			jInternalFrame.setTitle("ADD A STUDENT");
			add(jInternalFrame, BorderLayout.CENTER);
			jInternalFrame.setBounds(50, 50, 200, 300);
			jInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			jInternalFrame.setVisible(true);
			validate();
		}
		
	}

}
