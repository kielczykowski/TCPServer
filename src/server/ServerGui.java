package server;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ServerGui {

	public static void main(String args[]) {
//		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Server GUI");  
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		connect.setBackground(Color.DARK_GRAY);
//		connect.setForeground(Color.green);
//		Przycisk wraz z Action eventem
		JButton connect = new JButton("Przycisk połączenia");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				System.out.println("Connect");
			}
		});
		frame.getContentPane().add(connect,BorderLayout.CENTER);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Zakończ program i zamknij wszystkie sockety");
			}
		});
		frame.getContentPane().add(exit,BorderLayout.PAGE_END);
		
		JLabel title = new JLabel("SERVER GUI.");
		frame.getContentPane().add(title,BorderLayout.PAGE_START);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.pack();
	}
}
