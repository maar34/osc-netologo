(
Ndef(\example).play;
Ndef(\example, { | amp = 0.01, freq = 333 |
var sound;
sound = Pan2.ar(
SinOsc.ar( (freq), 0, (amp)), 0);
});

x = OSCFunc( { | msg, time, addr, port |
var pyFreq;
pyFreq = msg[1].asFloat;
	( "freq is " + (pyFreq * 10)).postln;
	Ndef(\example).set( \freq, (pyFreq * 10) );
}, '/partner/XCOR' );

y = OSCFunc( { | msg, time, addr, port |
var pyAmp;
pyAmp= msg[1].asFloat;
	( "Volume is " + (pyAmp)).postln;
	Ndef(\example).set( \amp, (pyAmp / 1000) );
}, '/node/XCOR' );

)