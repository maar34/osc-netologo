import org.nlogo.agent.AgentSet;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;
import org.nlogo.nvm.ExtensionContext;
import org.nlogo.nvm.Workspace.OutputDestination;





public class SendAgents extends DefaultCommand
    {

	 static PortOut port = new PortOut(); 



		public Syntax getSyntax() {

			return Syntax.commandSyntax(	new int[] {Syntax.StringType(), Syntax.AgentsetType() | Syntax.AgentType() | Syntax.StringType() | Syntax.RepeatableType()});

	    }  
		public String getAgentClassString()
		{
			return "OTPL" ;
		}    	
	    public void perform(Argument args[], Context context) throws ExtensionException, LogoException
		 {   	    	
	    	
			try
			{
				String rname = args[0].getString();		// args 0 "agentLists"	
				Object ag = args[1].get();  // turtle 0
									
				String[] varnames = new String[args.length-2];	// get variable names
			    
				for (int i=0; i<args.length-2; i++)
		    	{
		    		varnames[i] = args[i+2].getString();	// args [2 + ...] Nombre de las variables a obtener
		    	}	    		

				if (ag instanceof org.nlogo.agent.AgentSet)
				{
					org.nlogo.agent.AgentSet agentset = (org.nlogo.agent.AgentSet)ag;
					
			    	for (int j = 0; j<varnames.length; j++)
					{
			    		org.nlogo.agent.AgentSet.Iterator it = agentset.iterator();
		    			org.nlogo.agent.Agent[] ags = new org.nlogo.agent.Agent[agentset.count()];
		    			int i = 0;
		    			
			    		while (it.hasNext())
			    		{

			    			ags[i] = (org.nlogo.agent.Agent)it.next();
		
				    		int varindex = ags[i].world().indexOfVariable(ags[i], varnames[j].toUpperCase());	
			    
				    		if (varindex != -1)
				    		{	
				    		
				    			if (ags[i] instanceof org.nlogo.agent.Turtle)
				    			{
				    				if (isNumeric ((ags[i].getTurtleVariable(varindex).toString())))
				    				{
				    				
				    					if (((AgentSet) ag).printName()!=null){
				    				
				    				
				    						port.getSender().agentMessage(rname,  ((AgentSet) ag).printName(),varnames[j].toUpperCase() , ((Number)ags[i].getTurtleVariable(0)).intValue() , ((Number) ags[i].getTurtleVariable(varindex)).floatValue());
				    				
				    				
				    					}else{
				    					
				    						port.getSender().agentMessage(rname, "TURTLE",varnames[j].toUpperCase() , ((Number)ags[i].getTurtleVariable(0)).intValue() , ((Number) ags[i].getTurtleVariable(varindex)).floatValue());
					    		
				    					}
				    				}else{
				    					
				    					if (((AgentSet) ag).printName()!=null){
						    				
						    				
				    						port.getSender().agentMessage(rname,  ((AgentSet) ag).printName(),varnames[j].toUpperCase() , ((Number)ags[i].getTurtleVariable(0)).intValue() , (ags[i].getTurtleVariable(varindex)).toString());
				    				
				    				
				    					}else{
				    					
				    						port.getSender().agentMessage(rname, "TURTLE",varnames[j].toUpperCase() , ((Number)ags[i].getTurtleVariable(0)).intValue() ,  (ags[i].getTurtleVariable(varindex)).toString());
					    		
				    					}
				    					
				    				}
				    			}
				    		
		    					if (ags[i] instanceof org.nlogo.agent.Link)
		    					{
		    						if (isNumeric ((ags[i].getLinkVariable(varindex)).toString()))
		    						{

		    							port.getSender().agentMessage(rname,  ((AgentSet) args[1].get()).printName(),varnames[j].toUpperCase() , i, ((Number) ags[i].getLinkVariable(varindex)).floatValue());
		    						
		    						}else{
			    					
		    							port.getSender().agentMessage(rname,  ((AgentSet) args[1].get()).printName(),varnames[j].toUpperCase() , i, (ags[i].getLinkVariable(varindex)).toString());

		    						}
		    						
		    					}
		    					if (ags[i] instanceof org.nlogo.agent.Patch)
		    					{
		    						if (isNumeric ((ags[i].getPatchVariable(varindex)).toString()))
		    						{
		    							
			    						port.getSender().agentMessage(rname,  ((AgentSet) args[1].get()).printName(),varnames[j].toUpperCase() , i, ((Number) ags[i].getPatchVariable(varindex)).floatValue());
			    						
			    						}else{
			    							
				    					port.getSender().agentMessage(rname,  ((AgentSet) args[1].get()).printName(),varnames[j].toUpperCase() , i, (ags[i].getPatchVariable(varindex)).toString());

			    						}		    						
		    					}
		    					
		    					i++;
		    					
				    		}else{
				    		      ExtensionContext extcontext = (ExtensionContext) context;
				    		        try {
				    		            extcontext.workspace().outputObject("Can«t send Variable "+varnames[j]+"\n", null, false, false,
				    		                      OutputDestination.NORMAL);
				    		        } catch (LogoException e) {
				    		            throw new ExtensionException(e);
				    		        }
				    		}
			    		}
					}
				}		
			    	
			    	if (ag instanceof org.nlogo.agent.Agent)
					{
						org.nlogo.agent.Agent agent = (org.nlogo.agent.Agent)ag; 
				    	for (int j = 0; j<varnames.length; j++)
						{
				    		int varindex = agent.world().indexOfVariable(agent, varnames[j].toUpperCase());	
				    		org.nlogo.api.LogoListBuilder varvalue = new org.nlogo.api.LogoListBuilder();	
				    		
				    		if (varindex != -1){

							if (agent instanceof org.nlogo.agent.Turtle)
				    		{
								try{

									port.getSender().agentMessage(rname,  agent.classDisplayName().toUpperCase(),varnames[j].toUpperCase() , ((Number)agent.getTurtleVariable(0)).intValue() , ((Number)agent.getTurtleVariable(varindex)).floatValue());

								}catch(NumberFormatException nfe) {

									port.getSender().agentMessage(rname,  agent.classDisplayName().toUpperCase(),varnames[j].toUpperCase() , ((Number)agent.getTurtleVariable(0)).intValue() , (agent.getTurtleVariable(varindex)).toString());

				    		}
							}
				    		if (agent instanceof org.nlogo.agent.Link)
				  			{
				    			
				    			try{
				    				
				    			port.getSender().agentMessage(rname,  agent.classDisplayName().toUpperCase(),varnames[j].toUpperCase() , j, ((Number)agent.getLinkVariable(varindex)).floatValue());
		    		    
				    			varvalue.add(agent.getLinkVariable(varindex));
								}catch(NumberFormatException nfe) {
									port.getSender().agentMessage(rname,  agent.classDisplayName().toUpperCase(),varnames[j].toUpperCase() , j, (agent.getLinkVariable(varindex)).toString());
					    		    
									
								}
							}
			    			if (agent instanceof org.nlogo.agent.Patch)
			    			{
			    				try{
			    				port.getSender().agentMessage(rname,  agent.classDisplayName().toUpperCase(),varnames[j].toUpperCase() ,j , ((Number)agent.getPatchVariable(varindex)).floatValue());
		    
			    				varvalue.add(agent.getPatchVariable(varindex));
								}catch(NumberFormatException nfe) {
				    				port.getSender().agentMessage(rname,  agent.classDisplayName().toUpperCase(),varnames[j].toUpperCase() , j, (agent.getPatchVariable(varindex)).toString());
								}
			    			}
			    			
				    		}else{
				    		      ExtensionContext extcontext = (ExtensionContext) context;
				    		        try {
				    		            extcontext.workspace().outputObject("Can«t send Variable "+varnames[j]+"\n", null, false, false,
				    		                      OutputDestination.NORMAL);
				    		        } catch (LogoException e) {
				    		            throw new ExtensionException(e);
				    		        }
				    		}
						}
					}

			}
			catch (Exception ex)
			{
				throw new ExtensionException("Error in PutAgentDf: \n"+ex);
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
	  
