# Osc-NetLogo compilation  

This repository is a compilation of the last two versions of OSC-NetLogo.


# Osc-NetLogo
OSC is a NetLogo extension that allows you to send OSC messages from it to other software (such as PureData, Wekinator, among others). This is an updated version of the [original version](https://quod.lib.umich.edu/cgi/p/pod/dod-idx/osc-netlogo-a-tool-for-exploring-the-sonification-of-complex.pdf?c=icmc;idno=bbp2372.2012.069;format=pdf) created by Rodrigo Cádiz and Marco Colasso and is compatible with the latest version of NetLogo (6.x).
The OSC-NETLOGO Extension for NetLogo adds primitives to NetLogo that let users route data from NetLogo models via OSC to third-party applications. Turtles, breeds, links, patches, and any other variables from a NetLogo patch can be sent to compatible external hardware or software over Ethernet.

## Installation 
It can be installed in two ways:

• Put the osc folder in the Extensions folder in the same location as the NetLogo application.

• Put the osc folder in the current model folder.

To use it, you must add the following line at the top of the Procedures tab: extensions [osc]

## Primitives 
(taken from the original [release documentation](https://quod.lib.umich.edu/cgi/p/pod/dod-idx/osc-netlogo-a-tool-for-exploring-the-sonification-of-complex.pdf?c=icmc;idno=bbp2372.2012.069;format=pdf))

### osc:port-out
This primitive should be used in the setup of the model. The user can set the IP (String) and port number (integer)of the receiving host, such as:
```
osc:port-out "169.254.183.129 " 10000
````

If port-out is not defined, the extension will use the default parameters, ip: localHost and port: 57110.

### osc:send-agents 
This primitive receives as input a string with the name of the OSC tag, followed by the name of an agentset of the model, and names of default or defined variables for this agentset, and sends them out. The syntax for this primitive is:
```
osc:send-agents "tagName" agentsetName var1 var2 var3 ...
```
Examples:
```
osc:send-agents "myTurtles" turtles "xcor" "size"
osc:send-agents "breeds" cars "XCOR" "age"
osc:send-agents "links" blue-links "weight"
osc:send-agents "patches" patch 2 2 "pcolor" "pxcor"
```
### osc:send-variables
This primitive receives as input the name of any variable of the model and sends it out. Example:
```
osc:send-variables "decays" decays
```

CREDITS

Original OSC extension, Pure Data examples and NetLogo example patches developed by Rodrigo F. Cadiz & Marco Colasso.
www.rodrigocadiz.com | https://maar.world

Re-written for NetLogo Api version 5.0 by Byron Christodoulou.
SuperCollider examples developed by Yorgo Yeorgiou & Byron Christodoulou.
http://computersuspect.com | http://byron.feltcollective.com


Rewritten version 6.x Teo Dannemann
https://teodannemann.wordpress.com/
