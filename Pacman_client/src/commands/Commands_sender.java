package commands;
import client.*;

public class Commands_sender implements InterfaceControler {

	private ClientSocket cs;

	
	public Commands_sender(ClientSocket cs) {
		super();
		this.cs = cs;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		cs.sendToStream("START");
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		cs.sendToStream("RESTART");
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		cs.sendToStream("STEP");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		cs.sendToStream("PAUSE");
	}

	public void setTime(double time) {
		cs.sendToStream("TIME : "+Double.toString(time));
	}

	public void setMap(String filename) {
		cs.sendToStream(filename);
	}

}
