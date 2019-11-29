package client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.Collections;

import client.Client;
import data.Person;

public class ClientGui {
	// Client client;
	// JLabel received;
	// JTextField text;
	
	// static boolean ended = false;
	
	// public void initializeGui() {
	// 	JFrame frame = new JFrame("Gui Client");
	// 	frame.setLayout(new GridLayout(3,3));
		
	// 	JLabel title = new JLabel("CLIENT GUI");
	// 	frame.add(title);
		
	// 	this.received = new JLabel("Here is presented the incoming data from server\n");
	// 	frame.add(received);
		
		
	// 	this.text = new JTextField();
	// 	frame.add(text);
		
	// 	JButton connect = new JButton("connect");
	// 	connect.addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			try {
	// 				System.out.println("Starting client");
	// 				client= new Client("localhost",8080);
	// 			}catch (Exception ex) {
	// 				System.err.println(ex);
	// 			}
	// 		}
	// 	});
	// 	frame.add(connect);
		
	// 	JButton showList = new JButton("Show received");
	// 	showList.addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			StringStream ss = new StringStream();
				
	// 			received.setText(client.received);
	// 		}
	// 	});
		
	// 	JButton send = new JButton ("Send");
	// 	send.addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			if(text.getText() == "q") {
	// 				ended = true;
	// 			}
	// 			client.sendMessage(text.getText());
	// 		}
	// 	});
	// 	frame.add(send);
		
	// 	JButton exit = new JButton("EXIT");
	// 	frame.add(exit);
		
	// 	frame.setSize(300,300);
	// 	frame.setVisible(true);
	// 	frame.pack();
	// }
	
	// public ClientGui() {
	// 	this.initializeGui();
		
	// }
	
	// public Client getClient() {
	// 	if(this.client == null) {
	// 		try {
	// 		this.client = new Client("localhost",8080);
	// 		} catch (Exception e) {
	// 			System.err.println(e);
	// 		}
	// 		return this.client;
	// 	} else
	// 	{
	// 		return this.client;
	// 	}
	// }

	JFrame frame;
	JLabel title;
	JButton connect;
	JButton send;
	JTextArea output;
	JTextField input;
	boolean exit;

	Client client;

	public ClientGui() {
		this.exit = false;
	}


	public void fillOutput(){
		StringBuilder str = new StringBuilder();
		Collections.sort(this.client.received);
		str.append("Here is incoming output presented\n");
		try{
			System.out.println("XDXD");
			for(Person pr: client.received){
				str.append(pr + "\n");
			}
		} catch (NullPointerException nl) {
			JOptionPane.showMessageDialog(null, "Firstly connect to server!");
		}
		output.setText(str.toString());
	}




	public void initGui(){
		this.frame = new JFrame();

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, 
					"Are you sure you want to close this window?", "Close Window?", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					exit = true;
					try{
						client.finalize();
					} catch(Exception e) {
						System.err.println(e);
					}
					System.exit(0);
				}
			}
		});

		this.title = new JLabel("Client gui");
		
		frame.add(title,BorderLayout.NORTH);

		this.connect = new JButton("Connect");
		connect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				System.out.println("connect");
				try {
					client = new Client("localhost",8080);
					} catch (Exception e) {
					System.err.println(e);
					}
			}
		});	
		frame.add(connect,BorderLayout.LINE_START);

		this.send = new JButton("Send message");
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
				if(client.socket.isConnected()){				
				client.output.println(input.getText());
				System.out.println("Message sent");
				}
				else {
					JOptionPane.showMessageDialog(null, "Firstly connect to server!");
				}
			} catch(NullPointerException nl) {
				JOptionPane.showMessageDialog(null, "Firstly connect to server!");
			}
			}
		});

		frame.add(send, BorderLayout.LINE_END);

		this.output = new JTextArea("Here is incoming output presented\n");
		output.setAutoscrolls(true);
		output.setEnabled(false);
		frame.add(output,BorderLayout.CENTER);

		this.input = new JTextField();
		frame.add(input,BorderLayout.SOUTH);

		frame.setSize(600,500);
		frame.setVisible(true);

	}
	
	public static void main (String args[]) {
		ClientGui xd = new ClientGui();
		xd.initGui();
		while(!xd.exit){
			System.out.println("WSZED");
			String incoming;
			String [] splitted = new String[8];
			if(xd.client != null){
					try{
					if((incoming = xd.client.input.readLine()) != null) {
						if(!incoming.contentEquals("User with this id wasnt found")) {
							System.out.println(incoming);
								splitted = incoming.split(":");
								for(String s:splitted) {
									System.out.println(s);
								}
								xd.client.received.add(new Person(splitted[7],splitted[1], splitted[3],Integer.parseInt(splitted[5])));
								// System.out.println(this.received);
						}
						System.out.println("Client received: " + incoming);
					}
					// System.out.println("Closing Client");				
					System.out.println(xd.client == null);
					
					System.out.println("is not null");
					System.out.println(xd.client.received);
					xd.fillOutput();
				} catch (Exception e) {
					System.out.println("XDDX");
					System.err.println(e);
				}
			}
		}
		
// 		ClientGui cl = new ClientGui();
// 		while(!ClientGui.ended) {
// 			try {
// 			cl.client.run();
// 			} catch (Exception e) {
// 				System.err.println(e);
// 			}
// 			if(cl.client.received.size() == 0) {
// 				cl.received.setText("Here incoming will be displayed\n");
// 			} else {
// 				cl.received.setText(cl.text.getText());
// 			}
// 		}
// 		cl.client.finalize();
// //		while(!ClientGui.ended) {
// //			try {
// //				if((incoming = cl.client.input.readLine()) != null) {
// //					System.out.println("WSzed");
// //					if(!incoming.contentEquals("User with this id wasnt found")) {
// //						System.out.println(incoming);
// //						splitted = incoming.split(":");
// //						for(String s:splitted) {
// //							System.out.println(s);
// //						}
// //						cl.client.received.add(new Person(splitted[7],splitted[1], splitted[3],Integer.parseInt(splitted[5])));
// //						System.out.println(cl.client.received);
// //					}
// //					System.out.println("Client received: " + incoming);
// //				}
// //			} catch (Exception e) {
// //				e.printStackTrace();
// //			}
// //		}
		
//		while (true) {
//			System.out.println("XD");
//		}
		

}
}
