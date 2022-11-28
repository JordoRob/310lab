package com.chatbot;

import java.io.File;
import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;

public class Lonely {
    private static final boolean TRACE_MODE = false;
    static String botName = "Mr. Lonely";
    static String textLine = "";
    static String resourcesPath;
    static Interface gui;
    public static Bot bot;
    public static Chat chatSession;
    public static Wikisearch info;


    public static void main(String args[]) throws BadLocationException, IOException{ // main creates the bot and creates the interface session
        //System.out.println(newBotTest());

        resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = TRACE_MODE;
        bot = new Bot("safety", resourcesPath);
        info = new Wikisearch();
        chatSession = new Chat(bot);
        bot.brain.nodeStats();
        gui = new Interface(bot, chatSession);

        gui.setText(chatSession.multisentenceRespond("LONELYBOT3000"), 1);}

    public static boolean testResponse() {
        resourcesPath = getResourcesPath();
        MagicBooleans.trace_mode = TRACE_MODE;
        Bot bot = new Bot("safety", resourcesPath);
        Chat chatSession = new Chat(bot);
        bot.brain.nodeStats();
        String response = chatSession.multisentenceRespond("TESTING"); // Sends user message to the chatsession/bot and
                                                                       // gets a response
        if (response.equals("TEST")) {
            return true;
        }
        return false;
    }

    private static String getResourcesPath() { // grabs the path for the bot libraries
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        if (!path.contains("demo")) {
            path = path + File.separator + "demo";
        }
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }

    public void newBot(String name, String message) throws BadLocationException { // creates a new bot for the
                                                                                  // switching from safety to regular.
        Bot temp = new Bot(name, resourcesPath);
        Chat chatTemp = new Chat(temp);
        gui.addListener(temp, chatTemp, gui, 1);

        if (name == "super") {
            gui.setText("\nYou have switched to conversation mode, to switch back press the 'switch' button", 2);
            if (message.contains("CHATTIME")) {
                String[] nice = message.split(":");
                chatTemp.multisentenceRespond(nice[0] + " " + nice[1]); //Sends the bot the users name
                gui.setText(chatTemp.multisentenceRespond("I like" + nice[2]), 1);
            } else
                chatTemp.multisentenceRespond("My name is " + message);
        }
        if (name == "safety") {
            gui.setText("\nYou have switched to safety mode, to switch back press the 'switch' button", 2);
            chatTemp.multisentenceRespond("My name is " + message);
        }
    }
    public static boolean newBotTest() throws BadLocationException { //Testing method
        resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = TRACE_MODE;
        Bot bot = new Bot("safety", resourcesPath);
        Chat chatSession = new Chat(bot);
        gui = new Interface(bot, chatSession);
        
        // Could be expanded upon if necessary
        String name = "safety";
        String message = "TEST";

        String test = "";
        Bot temp = new Bot(name, resourcesPath);
        Chat chatTemp = new Chat(temp);
        gui.addListener(temp, chatTemp, gui, 1);

        if (name == "super") {
            gui.setText("\nYou have switched to conversation mode, to switch back press the 'switch' button\n\n", 2);
            if (message.contains("CHATTIME")) {
                String[] nice = message.split(":");
                chatTemp.multisentenceRespond(nice[0] + " " + nice[1]);
                gui.setText("Mr.Lonely: " + chatTemp.multisentenceRespond("I like" + nice[2]), 2);
            } else
                chatTemp.multisentenceRespond("My name is " + message);
        }
        if (name == "safety") {
            gui.setText("\nYou have switched to safety mode, to switch back press the 'switch' button\n\n", 2);
            test = chatTemp.multisentenceRespond("My name is " + message);
        }
        System.out.println(test);
        if (test.equals("Well then TEST, how have you been feeling lately?")) {
            return true;
        }
        return false;
    }
}
