import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;


public class SendVariables extends DefaultCommand
    {

	static PortOut port = new PortOut(); 


		public Syntax getSyntax() {

			return Syntax.commandSyntax(	new int[] {Syntax.StringType(), Syntax.WildcardType()});

		}  
		public String getAgentClassString()
		{
			return "OTPL" ;
		}    	
	    public void perform(Argument args[], Context context) throws ExtensionException, LogoException
		 {   	    	

			String variable = args[0].getString();			
			String sValue =  args[1].get().toString();  
			
			if (isNumeric(sValue)){
				float fValue =  ((Number)args[1].get()).floatValue();  
				
				try {
					port.getSender().variableMessage(variable, fValue);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}else{
				
				try {
					port.getSender().variableMessage(variable, sValue);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			


	
		}

	    @SuppressWarnings("unused")
	    
		public static boolean isNumeric(String str)  
	    {  
	      try  
	      {  
	        double d = Double.parseDouble(str);  
	      }  
	      catch(NumberFormatException nfe)  
	      {  
	        return false;  
	      }  
	      return true;  
	    }
	    
    }
	  


