(
Ndef(\rebellion).play;
Ndef(\rebellion).fadeTime = 2;

Ndef(\rebellion, { | amp = 0.5, feedback = 0, freq = 440 |
    var sound;
    sound = Pan2.ar(
		SinOscFB.ar( (freq), (feedback), (amp), 0), 0, 1);
});

x = OSCFunc( { | msg, time, addr, port |

    var ntlogoFreq;

    ntlogoFreq = msg[1].asFloat;

    ( "freq is " + (ntlogoFreq)).postln;

	   Ndef(\rebellion).set( \freq, (ntlogoFreq * 2000));
    }, '/variables/input2',

);

z = OSCFunc( { | msg, time, addr, port |

    var ntlogoAmp;

    ntlogoAmp = msg[1].asFloat;

    ( "Volume is " + ntlogoAmp).postln;

	   Ndef(\rebellion).set( \amp, ntlogoAmp);
    }, '/variables/input1'

);

y = OSCFunc( { | msg, time, addr, port |

	var ntlogoFeedback;

    ntlogoFeedback = msg[1].asFloat;

    ( "What is " + ntlogoFeedback).postln;

	if(ntlogoFeedback > 25, {
	   Ndef(\rebellion).set( \feedback, ntlogoFeedback);
		}, {
	   Ndef(\rebellion).set( \feedback, 0);
	});
    }, '/variables/input3')
);