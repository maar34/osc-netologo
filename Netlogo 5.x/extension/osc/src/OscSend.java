import java.net.InetAddress;

import org.nlogo.api.ExtensionException;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.OSCPortOut;


public class OscSend {
	
	OSCPortOut sender;
   	InetAddress newAddress;
	

	int id;
	String id2;
	double x;
	double y;
	String name;
	String agentType;
	String variableType;
	
	String variable;
	String vValue;
	
	float fValue;
	float value; 


	public String outIP;
	public int outPort;
	
	public OscSend() {

		
	}
	
	
	public OscSend(String _outIP, int _outPort) { //

		setOutIP(_outIP);	
		setOutPort(_outPort);
		
	}
	

	protected void init() throws Exception {


    	try{
 
    		sender = new OSCPortOut(); 

	    	
    	} catch (Exception e) {
  		
    		throw new ExtensionException("Can«t initialize ports, set ports manually"+e);
 	
    	}
	
	}

	protected void setUp() throws Exception {


    	try{
 
    		newAddress = InetAddress.getByName( getOutIP());
 
    		sender = new OSCPortOut(newAddress, getOutPort()); 
       			    	
    	} catch (Exception e) {
  		
    		throw new ExtensionException("Invalid IP Adress or Port: \n"+e);
 	
    	}
	
	}
	
	public void agentMessage(String _name, String _agentType, String _variableType,  int _id, float turtleVariable) throws Exception {
		

		this.name = _name; 
		this.agentType = _agentType;
		this.variableType = _variableType;		
		this.id = _id; 
		
		
		OSCPacket mesgs[] = new OSCPacket[2];
		
		OSCMessage mesg = new OSCMessage("/"+name+"/"+variableType);

		mesg.addArgument(id);			
		mesg.addArgument(turtleVariable);

		mesgs[0] = mesg;
		
		sender.send(mesg);
		
    	
	}
	
	public void agentMessage(String _name, String _agentType, String _variableType,  int _id, String _turtleVariable) throws Exception {
		

		this.name = _name; 
		this.agentType = _agentType;
		this.variableType = _variableType;		
		this.id = _id; 
		
		
		OSCPacket mesgs[] = new OSCPacket[2];
		
		OSCMessage mesg = new OSCMessage("/"+name+"/"+variableType);

		mesg.addArgument(id);			
		mesg.addArgument(_turtleVariable);

		mesgs[0] = mesg;
		
		sender.send(mesg);
		
    	
	}
	
	public void variableMessage(String _variable, String _vValue) throws Exception {
		
		this.variable = _variable;
		this.vValue = _vValue; 

		
		
		OSCPacket mesgs[] = new OSCPacket[2];
		
		
		OSCMessage mesg = new OSCMessage("/variables"+"/"+variable);

		mesg.addArgument(vValue);

		mesgs[0] = mesg;
		
		sender.send(mesg);
		    	
	}
	
	
	public void variableMessage(String _variable, float _fValue) throws Exception {
		
		this.variable = _variable;
		this.fValue = _fValue; 

		
		
		OSCPacket mesgs[] = new OSCPacket[2];
		
		
		OSCMessage mesg = new OSCMessage("/variables"+"/"+variable);

		mesg.addArgument(fValue);

		mesgs[0] = mesg;
		
		sender.send(mesg);
		    	
	}
	
	
	
	public void turtleMessage(int _id, double _x, double _y) throws Exception {
		
		this.id = _id;
		this.x = _x;
		this.y = _y;

		
		Object args[] = new Object[3];
		OSCPacket mesgs[] = new OSCPacket[1];
		args[0] = new Float((float)id);
		args[1] = new Float((float)x);
		args[2] = new Float((float)y);

		OSCMessage mesg = new OSCMessage("/position", args);
		mesgs[0] = mesg;
		sender.send(mesg);
	}
	
	

	public String getOutIP() {
		return outIP;
	}



	public void setOutIP(String outIP) {
		this.outIP = outIP;
	}



	public int getOutPort() {
		return outPort;
	}



	public void setOutPort(int outPort) {
		this.outPort = outPort;
	}



}

