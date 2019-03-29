package commands;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Maze;
import client.ClientSocket;
import view.ViewGame;

public class KeyCommand_sender implements KeyListener{

	private ClientSocket cs;
	
	public KeyCommand_sender(ClientSocket c) {
		this.cs=c;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case 37:
			cs.sendToStream("GAUCHE");
			System.out.println("GAUCHE");
			break;
		case 38:
			cs.sendToStream("HAUT");
			System.out.println("HAUT");
			break;
		case 39:
			cs.sendToStream("DROITE");
			System.out.println("DROITE");
			break;
		case 40:
			cs.sendToStream("BAS");
			System.out.println("BAS");
			break;
		default:
			//System.out.println("KeyCode : " + e.getKeyCode() + " non traité");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
