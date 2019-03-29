package commands;
import client.*;

public class Commands_sender implements InterfaceControler {

	private ClientSocket cs;
	private boolean isInited;
	private String filename;
	public Commands_sender(ClientSocket cs) {
		super();
		this.cs = cs;
		this.isInited=false;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if( isInited)
			cs.sendToStream("START");
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		if( isInited) {
			cs.sendToStream("RESTART");
			cs.sendToStream(filename);
			}
			
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		if( isInited)
			cs.sendToStream("STEP");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if( isInited)
			cs.sendToStream("PAUSE");
	}

	public void setTime(double time) {
		if( isInited)
			cs.sendToStream("TIME : "+Double.toString(time));
	}

	public void setMap(String filename) {
		this.filename=filename;
		System.out.println(filename);
		isInited=true;
	}

}
