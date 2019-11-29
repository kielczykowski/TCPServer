package server;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import server.Server;

public class ServerGui {
	Server srv;

	public ServerGui() {
		this.initGui();
	}

	public void initGui() {
		JFrame frame = new JFrame("Server GUI");  
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton connect = new JButton("Przycisk połączenia");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(e);
				try{
					srv = new Server("/home/michal/Programming/TCPServer/src/data/data");
				} catch (Exception err) {
					System.err.println(err);
				}

				System.out.println("Connected");
			}
		});
		frame.getContentPane().add(connect,BorderLayout.CENTER);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Zakończ program i zamknij wszystkie sockety");
				System.exit(0);
			}
		});
		frame.getContentPane().add(exit,BorderLayout.PAGE_END);
		
		JLabel title = new JLabel("SERVER GUI.");
		frame.getContentPane().add(title,BorderLayout.PAGE_START);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}

	public static void main(String args[]) {
		ServerGui sr = new ServerGui();
		while(true){
			System.out.print("obj");
			try{
			sr.srv.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		// System.out.println("out");
		// this.finalize();
//		JFrame.setDefaultLookAndFeelDecorated(true);
		
		// frame.pack();
	}
}
