package com.chatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import java.awt.event.*;

import javax.swing.text.BadLocationException;
public class App extends Lonely implements ActionListener {
public Interface gui;
public Bot lonely;
public Chat chatSession;
public int button;
//This class completes the interfacing with the bot
	public App(Bot lonely, Chat chatSession, Interface gui) {
		this.gui=gui;
		this.lonely=lonely;
		this.chatSession=chatSession;
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		textLine = gui.getText();
		try {
			gui.setText(textLine, 0);
		
				if ((textLine == null) || (textLine.length() < 1)) //Checks for null or incorrect input
					textLine = MagicStrings.null_input;
				if (textLine.equals("q")) {
					System.exit(0);
				} else if (textLine.equals("wq")) {
					lonely.writeQuit();
					System.exit(0);
				} else {
					String request = textLine;
					if (MagicBooleans.trace_mode)
						System.out.println( //Sends the user text and previous bot message to the system for debugging
								"STATE=" + request + ":THAT=" + (chatSession.thatHistory.get(0)).get(0)
										+ ":TOPIC=" + chatSession.predicates.get("topic"));
					String response = chatSession.multisentenceRespond(request); //Sends user message to the chatsession/bot and gets a response
					if(response.contains("CHATTIME")){ //This is the switch that flips from safety oriented questions to the default AIML chatbot
						newBot("super", response);
					}else if(response.contains("WIKI")){ //Previously the chatbot would send a random message in response to an unknown string but I modified it to send this.
						response = response.replace("WIKI ",""); //Trim out the "WIKI" part of the chatbot message
						gui.setText("I don't know what that is! According to wikipedia:", 1);
						gui.setText(info.getDetail(response), 1); //calls the new getDetail method to return information on the item
					}
					else{ //This replaces all incorrect symbols
					while (response.contains("&lt;"))
						response = response.replace("&lt;", "<");
					while (response.contains("&gt;"))
						response = response.replace("&gt;", ">");
                        gui.setText(response, 1); //sends text to the ui
					}
				gui.tf.setText("");} //resets the typing textbox
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //Send out your message to the UI
		}
	}
		