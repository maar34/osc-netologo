import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;



public class PortOut extends DefaultCommand
    {

		private static String outIP = "localHost";
		private static int outPort = 57110;

		private static OscSend sender= new OscSend(outIP,outPort);

		public Syntax getSyntax() {
	        return Syntax.reporterSyntax(new int[] { Syntax.StringType(), Syntax.NumberType()  },
                    Syntax.WildcardType());
	    }  
		public String getAgentClassString()
		{
			return "OTPL" ;
		}    	
	    public void perform(Argument args[], Context context) throws ExtensionException, LogoException
		 {   	    	

	    	if (outPort!=args[1].getIntValue() || !outIP.contentEquals(args[0].getString()))
	    	{

	        	setOutIP (args[0].getString());
		    	setOutPort ( args[1].getIntValue());	

	    	}
	    	
	    	 setSender ( new OscSend(outIP,outPort));

	    	try {
	    			
				getSender().setUp();			
		    	
		    	} catch (Exception e) {
			
		    		e.printStackTrace();
			
		    	}
		}
	    
	    public OscSend getSender() {
			return sender;
		}
		public void setSender(OscSend sender) {
			PortOut.sender = sender;
		}
		public String getOutIP() {
			return outIP;
		}
		public void setOutIP(String outIP) {
			PortOut.outIP = outIP;
		}
		public int getOutPort() {
			return outPort;
		}
		public void setOutPort(int outPort) {
			PortOut.outPort = outPort;
		}
 

    }