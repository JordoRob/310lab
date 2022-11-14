package com.chatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import java.awt.event.*;

public class Switch extends Lonely implements ActionListener {
public Interface gui;
public Bot lonely;
public Chat chatSession;
public int button;

public Switch(Bot lonely, Chat chatSession) {
    this.lonely=lonely;
    this.chatSession=chatSession;
        }
        public void actionPerformed(ActionEvent e) {
            String x = chatSession.multisentenceRespond("GETNAME");
			if(lonely.name=="super"){
				newBot("safety", x);      
			}
			else{
				newBot("super", x);
			}
        }
}
