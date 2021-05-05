package gniot_library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Welcome_Screen extends JFrame {
	
	public Welcome_Screen() {
		
		
//		setResizable(false);
		setVisible(true);
		setBounds(400, 100, 700, 500);
		setLayout(new BorderLayout());
		setTitle("Welcome To Gniot ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JInternalFrame jInternalFrame = new JInternalFrame();
		jInternalFrame.setBackground(Color.CYAN);
		jInternalFrame.setVisible(true);
		add(jInternalFrame, BorderLayout.CENTER);
		
		JPanel jLabel1 = new JPanel();
		jLabel1.setSize(MAXIMIZED_HORIZ, 20);
		JLabel title = new JLabel();
		title.setFont(new Font("aerial", Font.BOLD, 15));
		title.setText("Welcome To Gniot Library");
		jLabel1.setBackground(Color.RED);
		jLabel1.add(title);
		add(jLabel1,BorderLayout.PAGE_START);

		JProgressBar jBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		jBar.setStringPainted(true);
		jBar.setString("AWANISH WELCOMES YOU TO GNIOT LIBRARY.....");
		jBar.setForeground(Color.RED);
		jBar.setBackground(Color.WHITE);
		add(jBar, BorderLayout.PAGE_END);
		
		
//		jLabel1.setVisible(false);
		ImageIcon icon = new ImageIcon("D:\\\\new\\\\gniot-logo.jpg");
		JLabel jLabel = new JLabel(icon, JLabel.CENTER);
		jInternalFrame.add(jLabel, BorderLayout.CENTER);
		
//		jLabel.setIcon(icon);
		
		validate();
		
		for(int i = 0; i < 101; i+=10) {
			
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			
			if(i >= 70) {
				
				jBar.setValue(i);
			}else {
				jBar.setValue(i);
			}
			
			
		}
		
		validate();
		
		dispose();
		new LoginAsk_Screen();
		
		
		
	}
		

	public static void main(String[] args) {
		
		new Welcome_Screen();

	}

}
