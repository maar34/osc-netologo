

For NetLogo 5.0.4 (API 5.0)


CONTENTS
This package contains:

1- extension/osc : NetLogo OSC (open sound control) send extension. (http://opensoundcontrol.org/)
2- examples/netlogo-examples/...
3- examples/pd-examples: Pure Data examples. 
4- examples/sp-examples: SuperCollider examples.


INSTRUCTIONS

1- There are two options to use OSC extension for NetLogo, put 'osc' folder into: 
	a-Extensions folder in the same location as the NetLogo application (recommended).	
	b-Current model folder.
	

2- This extension allows you to send NetLogo data to external software via OSC, to any port and IP. There are 5 example explaining:

	*- pd-receive - Pure Data example to receive and monitor osc data. 
	*- sp-receive - SuperCollider example to receive and monitor osc data.

	1- Send Turtles
	2- Send Breeds
	3- Send Links
	4- Send Patch
	5- Send NetLogo Variables 	
 

3- Pure Data (pd) is a real-time graphical programming environment for audio, video, and graphical processing. (http://puredata.info/)

	1- Download pure data or pd-extended*: http://puredata.info/community/projects/software 
		
	2- Open the corresponding examples in pd and NetLogo.

*Required pd externals are included with the examples.


4- SuperCollider (sp) is an environment and programming language for real time audio synthesis and algorithmic composition. (http://supercollider.sourceforge.net/)

	1- Download: http://supercollider.sourceforge.net/downloads/
		
	2- Open the corresponding examples in sp and NetLogo.


HOW TO USE THE PD EXAMPLE

1- Go to osc-netlogo/examples/pd-examples/1_Preferential_Attachment folder 

2- Open pAttachment.pd

3- Open pAttachment.nlogo 

4- Turn audio ON (You must turn on Pure Data audio engine each time you open the program)

5- Activate audio Synth

6- Setup model in netlogo interface

7- Press go button 

NOTES: 
- You can read in PD console how the OSC data is received, just turn on ptintIN toggle in the patch. Useful for debugging. 

- All the PD examples have the following logic and objects. 
	- oscreceive: object which listen and print received data. 
	- dataRouter: route OSC tags, and stream data in PD. 
	- dataMapping.  map netlogo variables to sound values.
	- synth - receives mapped data and generates the sound. 


HOW TO USE THE SP EXAMPLE

1- Go to osc-netlogo/examples/sp-examples/1_Random_Balls folder 

2- Open Random Balls.scd

3- Open Random Balls.nlogo 

4- Boot the server

5- Run the code


TERMS OF USE

………………….


CREDITS

OSC extension, Pure Data examples and NetLogo example patches developed by Rodrigo F. Cadiz & Marco Colasso.
www.rodrigocadiz.com | http://mcolasso.com

Re-written for NetLogo Api version 5.0 by Byron Christodoulou.
SuperCollider examples developed by Yorgo Yeorgiou & Byron Christodoulou.
http://computersuspect.com | http://byron.feltcollective.com