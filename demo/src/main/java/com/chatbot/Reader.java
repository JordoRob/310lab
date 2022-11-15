package com.chatbot;

import java.util.Locale;  
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;  
import javax.speech.synthesis.SynthesizerModeDesc;  
public class Reader{
    public Synthesizer synthesizer;

    public Reader(){ //Sets up the voice
    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");  
    try {
        Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
        
    synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));  
    synthesizer.allocate();
     } catch (EngineException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
    }
    public void read(String line, int x){ //narrates the text
        try{
            
            synthesizer.resume();  
            if(x==1)
            synthesizer.speakPlainText("Mr. Lonely said: " + line, null); 
            else if(x==0)
            synthesizer.speakPlainText("You said: " + line, null); 
            else if(x==2)
            synthesizer.speakPlainText("Switched modes", null);
            } catch(Exception e){
        e.printStackTrace();}

    }
    }

