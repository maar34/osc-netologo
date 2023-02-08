(
Ndef(\genetic).play;
Ndef(\genetic).fadeTime = 2;

Ndef(\genetic, { | amp = 0.1, feedback = 0, freq = 440 |
    var sound;
    sound = Pan2.ar(
		SinOscFB.ar( (freq), (feedback), (amp), 0), 0, 1);
});

x = OSCFunc( { | msg, time, addr, port |

    var ntlogoFreq;

    ntlogoFreq = msg[1].asFloat;

    ( "freq is " + (ntlogoFreq / 25)).postln;

	   Ndef(\genetic).set( \freq, (ntlogoFreq / 25));
    }, '/winner/FITNESS',

);

y = OSCFunc( { | msg, time, addr, port |

	var ntlogoFeedback;

    ntlogoFeedback = msg[1].asFloat;

    ( "Feedback is " + ntlogoFeedback).postln;

	   Ndef(\genetic).set( \feedback, ntlogoFeedback * 7);

    }, '/variables/diversity')

);