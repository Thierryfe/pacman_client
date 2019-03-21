package client;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.*;


public class ClientSocket {

	private Socket socket;
	private DataInputStream entree;
	private DataOutputStream sortie;


	public ClientSocket(int port, String address) {
		super();
		try {
			socket = new Socket(address, port);

		} 	catch (SocketException e) {
			e.printStackTrace();
		} 	catch(UnknownHostException e) {
			e.printStackTrace();
		}	catch (IOException e) {
			e.printStackTrace();
		}

		try {
			sortie = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			entree = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readFromStream() {

		try {
			return entree.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	}

	public void sendToStream(String value) {

		try {
			sortie.writeUTF(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public DataInputStream getEntree() {
		return entree;
	}
	public void setEntree(DataInputStream entree) {
		this.entree = entree;
	}
	public DataOutputStream getSortie() {
		return sortie;
	}
	public void setSortie(DataOutputStream sortie) {
		this.sortie = sortie;
	}



}
