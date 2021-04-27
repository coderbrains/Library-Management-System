package gniot_library;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Welcome_Screen extends JFrame {
	
	public Welcome_Screen() {
		
		setVisible(true);
		setResizable(false);
		setBounds(200, 100, 700, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setForeground(Color.RED);
		
		
		
		JProgressBar jBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		jBar.setStringPainted(true);
		jBar.setString("AWANISH WELCOMES YOU TO GNIOT LIBRARY.....");
		jBar.setForeground(Color.RED);
		jBar.setBackground(Color.WHITE);
		add(jBar, BorderLayout.PAGE_END);
		
		
		ImageIcon icon = new ImageIcon("D:\\\\new\\\\gniot-logo.jpg");
		JLabel jLabel = new JLabel(icon, JLabel.CENTER);
		
		add(jLabel, BorderLayout.CENTER);
		
		jLabel.setIcon(icon);
		
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
		
		dispose();
		new LoginAsk_Screen();
		
		
		
	}
		

	public static void main(String[] args) {
		
		new Welcome_Screen();

	}

}
