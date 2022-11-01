package com.chatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import java.awt.event.*;
public class App extends Lonely implements ActionListener {
public Interface gui;
public Bot lonely;
public Chat chatSession;
	public App(Bot lonely, Chat chatSession, Interface gui) {
		this.gui=gui;
		this.lonely=lonely;
		this.chatSession=chatSession;
			}

	@Override
	public void actionPerformed(ActionEvent e) {	
		textLine = gui.getText();
		gui.setText("You: "+ textLine + "\n\n");
				if ((textLine == null) || (textLine.length() < 1))
					textLine = MagicStrings.null_input;
				if (textLine.equals("q")) {
					System.exit(0);
				} else if (textLine.equals("wq")) {
					lonely.writeQuit();
					System.exit(0);
				} else {
					String request = textLine;
					if (MagicBooleans.trace_mode)
						System.out.println(
								"STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0)
										+ ":TOPIC=" + chatSession.predicates.get("topic"));
					String response = chatSession.multisentenceRespond(request);
					if(response.contains("CHATTIME")){
						newBot("super", response);
						
					}
					else{
					while (response.contains("&lt;"))
						response = response.replace("&lt;", "<");
					while (response.contains("&gt;"))
						response = response.replace("&gt;", ">");
                        gui.setText("Mr.Lonely: "+ response + "\n\n");
					}
				gui.tf.setText("");}
	}
		}