package client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import client.Client;
import data.Person;

public class ClientGui {
	Client client;
	static boolean ended = false;
	
	public void initializeGui() {
		JFrame frame = new JFrame("Gui Client");
		frame.setLayout(new GridLayout(3,3));
		
		JLabel title = new JLabel("CLIENT GUI");
		frame.add(title);
		
		JLabel received = new JLabel("Here is presented the incoming data from server\n");
		frame.add(received);
		
		
		JTextField text = new JTextField();
		frame.add(text);
		
		JButton connect = new JButton("connect");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Starting client");
					client= new Client("localhost",8080);
				}catch (Exception ex) {
					System.err.println(ex);
				}
			}
		});
		frame.add(connect);
		
		JButton send = new JButton ("Send");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText() == "q") {
					ended = true;
				}
				client.sendMessage(text.getText());
			}
		});
		frame.add(send);
		
		JButton exit = new JButton("EXIT");
		frame.add(exit);
		
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.pack();
	}
	
	public ClientGui() {
		this.initializeGui();
		
	}
	
	public Client getClient() {
		if(this.client == null) {
			try {
			this.client = new Client("localhost",8080);
			} catch (Exception e) {
				System.err.println(e);
			}
			return this.client;
		} else
		{
			return this.client;
		}
	}
	
	public static void main (String args[]) {
		ClientGui cl = new ClientGui();
		String incoming;
		String [] splitted = new String[8];
//		while(!ClientGui.ended) {
//			try {
//				if((incoming = cl.client.input.readLine()) != null) {
//					System.out.println("WSzed");
//					if(!incoming.contentEquals("User with this id wasnt found")) {
//						System.out.println(incoming);
//						splitted = incoming.split(":");
//						for(String s:splitted) {
//							System.out.println(s);
//						}
//						cl.client.received.add(new Person(splitted[7],splitted[1], splitted[3],Integer.parseInt(splitted[5])));
//						System.out.println(cl.client.received);
//					}
//					System.out.println("Client received: " + incoming);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
//		while (true) {
//			System.out.println("XD");
//		}
		
	}

}
