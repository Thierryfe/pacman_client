package commands;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.google.gson.Gson;

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
				
				DataInputStream in = new DataInputStream(this.cs.getEntree());
				
				System.out.println("Waiting...");
				
				String s = in.readUTF();
				Gson gson = new Gson();
				Maze m = gson.fromJson(s , Maze.class);
				
				if( vg != null)
					vg.update(m);
				else {
					KeyCommand_sender key= new KeyCommand_sender(cs);
					vg= new ViewGame(m, key);
					vg.showWindow();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

		
	}
}

