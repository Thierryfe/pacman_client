package commands;


import java.io.IOException;
import java.io.ObjectInputStream;

import Model.Maze;
import client.ClientSocket;
import view.ViewGame;

public class Commands_receiver implements Runnable{

	private ClientSocket cs;
	private ViewGame vg;


	public Commands_receiver(ClientSocket c, ViewGame v) {
		this.cs=c;
		this.vg=v;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		String ch="";
		while(true && !cs.getSocket().isClosed()) {
			
			try {
				
				ObjectInputStream ois = new ObjectInputStream(cs.getEntree());
				
				System.out.println("Waiting...");
				
				Maze newMaze = (Maze)ois.readObject();
				
				if( vg != null)
					vg.update(newMaze);
				else {
					KeyCommand_sender key= new KeyCommand_sender(cs);
					vg= new ViewGame(newMaze, key);
					vg.showWindow();
				}
				
				System.out.println("Sérializable maze récupéré. modifications : "+newMaze.getGhosts_start().size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("La donnée envoyée par le serveur n'est pas une classe serializable.");
				break;
			}
		}

		
	}
}

