package gniot_library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoginAsk_Screen extends JFrame implements ActionListener{
	JButton j, j1, j2;
	
	public LoginAsk_Screen() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 150, 700, 500);
		
		JInternalFrame jInternalFrame = new JInternalFrame();
		jInternalFrame.setVisible(true);
		jInternalFrame.setLayout(new BorderLayout());
		add(jInternalFrame, BorderLayout.CENTER);
		
		JPanel jLabel = new JPanel();
		jLabel.setLayout(new GridLayout(3,1));
		jLabel.setSize(500, MAXIMIZED_VERT);
		jLabel.setBackground(Color.CYAN);
		jInternalFrame.add(jLabel, BorderLayout.WEST);
		
		JPanel jLabel2 = new JPanel();
		jLabel2.setBackground(Color.MAGENTA);
		jLabel2.setLayout(new BorderLayout());
		jInternalFrame.add(jLabel2, BorderLayout.CENTER);
		
	
		ImageIcon icon = new ImageIcon("D:\\\\new\\\\download.jpg");
		JLabel jLabel3 =  new JLabel(icon, JLabel.CENTER);
		jLabel3.setSize(MAXIMIZED_VERT,MAXIMIZED_HORIZ);
		jLabel2.add(jLabel3, BorderLayout.CENTER);
		
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setText("CLICK YOUR RESPONSE FROM LEFT");
		jLabel4.setFont(new Font("aerial", Font.BOLD, 28));
		jLabel4.setSize(MAXIMIZED_HORIZ, 40);
		jLabel2.add(jLabel4, BorderLayout.PAGE_START);
		
		j = new JButton("ADMIN LOGIN");
		j.setBounds(220, 80, 220, 50);
		j.setBackground(Color.CYAN);
		j1 = new JButton("STUDENT LOGIN");
		j1.setBounds(220, 150, 220, 50);
		j1.setBackground(Color.CYAN);
		j2 = new JButton("STUDENT ENTRY ");
		j2.setBounds(220, 220, 220, 50);
		j2.setBackground(Color.cyan);
		
		JButton jPanel = new JButton();
		jInternalFrame.add(jPanel, BorderLayout.PAGE_END);
		
		
		jLabel.add(j1);
		jLabel.add(j2);
		jLabel.add(j);
		
		j.addActionListener(this);
		j1.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public static void main(String[] a) {
		new LoginAsk_Screen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == j) {
			
			dispose();
			new LoginPage();
		}
		
		if(e.getSource() == j1) {
			dispose();
			new Login_Page_student();
		}
	}
}
