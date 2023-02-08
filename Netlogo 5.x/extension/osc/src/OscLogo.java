import org.nlogo.api.Primitive;




public class OscLogo extends org.nlogo.api.DefaultClassManager { 
	



	public void load(org.nlogo.api.PrimitiveManager primitiveManager) 
	{

		primitiveManager.addPrimitive( "send-agents", (Primitive) new SendAgents() ) ;
		primitiveManager.addPrimitive( "send-variables", (Primitive) new SendVariables() ) ;

		primitiveManager.addPrimitive( "port-out", (Primitive) new PortOut() ) ;

		PortOut initPort = new PortOut();
		
		try {
			initPort.setSender ( new OscSend("localHost",57110));
			initPort.getSender().setUp();	
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
	}
	
}


