package client;

import commands.Commands_sender;
import view.ViewCommand;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientSocket c= new ClientSocket(6000,"localhost");
		
		Commands_sender commands= new Commands_sender(c);
		
		ViewCommand v= new ViewCommand(commands);
		
		v.showWindow();
	}

}
