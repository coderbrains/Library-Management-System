package gniot_library;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LoginAsk_Screen extends JFrame implements ActionListener{
	JButton j, j1, j2;
	public LoginAsk_Screen() {
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		setBounds(300, 150, 700, 500);

	
		Container c = getContentPane();
		j = new JButton("ADMIN LOGIN");
		j.setBounds(220, 80, 220, 50);
		j1 = new JButton("STUDENT LOGIN");
		j1.setBounds(220, 150, 220, 50);
		j2 = new JButton("STUDENT ENTRY ");
		j2.setBounds(220, 220, 220, 50);
		c.add(j1);
		c.add(j2);
		c.add(j);
		
		j.addActionListener(this);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == j) {
			dispose();
			new LoginPage();
		}
		
	}
}
