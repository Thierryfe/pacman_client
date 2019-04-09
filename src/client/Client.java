package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.Maze;
import commands.Commands_receiver;
import commands.Commands_sender;
import commands.KeyCommand_sender;
import view.ViewCommand;
import view.ViewGame;

public class Client {
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {

			ClientSocket c = new ClientSocket(6000,"localhost");

			if(c!=null) {

				Scanner clavier = new Scanner(System.in);

				DataInputStream in = new DataInputStream(c.getEntree());
				DataOutputStream out = new DataOutputStream(c.getSortie());



				Boolean connectionOk = false;

				while(!connectionOk) {

					System.out.println(in.readUTF());
					out.writeUTF(clavier.nextLine());

					System.out.println(in.readUTF());
					out.writeUTF(clavier.nextLine());

					connectionOk = in.readBoolean();

					if(connectionOk) {
						Commands_sender commands= new Commands_sender(c);

						ViewGame vg= null;

						Thread t= new Thread(new Commands_receiver(c,vg));

						t.start();

						ViewCommand v= new ViewCommand(commands);

						//
						v.showWindow();
					}else {
						System.out.println("Login ou mdp incorrecte");
					}
				}
			}

		} catch (IOException  e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de flux.");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de connexion au serveur.");
		}


	}

}
