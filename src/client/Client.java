package client;

import Model.Maze;
import commands.Commands_receiver;
import commands.Commands_sender;
import commands.KeyCommand_sender;
import view.ViewCommand;
import view.ViewGame;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClientSocket c= new ClientSocket(6000,"localhost");
			
			Commands_sender commands= new Commands_sender(c);
			
			
			
			ViewGame vg= null;

			Thread t= new Thread(new Commands_receiver(c,vg));

			t.start();

			ViewCommand v= new ViewCommand(commands);
			
			//
			v.showWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
