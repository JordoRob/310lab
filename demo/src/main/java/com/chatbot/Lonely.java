package com.chatbot;

import java.awt.*;
import java.io.File;

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

    public static void main(String args[]) throws BadLocationException{ // main creates the bot and creates the interface session
        resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = TRACE_MODE;
        bot = new Bot("safety", resourcesPath);
        chatSession = new Chat(bot);
        bot.brain.nodeStats();
        gui = new Interface(bot, chatSession);
        gui.setText(chatSession.multisentenceRespond("LONELYBOT3000") + "\n\n", 1);

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
                                                                                  // switchover from safety to regular.
        // Could be expanded upon if necessary
        Bot temp = new Bot(name, resourcesPath);
        Chat chatTemp = new Chat(temp);
        gui.addListener(temp, chatTemp, gui, 1);

        if (name == "super") {
            gui.setText("You have switched to conversation mode, to switch back press the 'switch' button\n\n", 2);
            if (message.contains("CHATTIME")) {
                String[] nice = message.split(":");
                chatTemp.multisentenceRespond(nice[0] + " " + nice[1]);
                gui.setText(chatTemp.multisentenceRespond("I like" + nice[2]), 1);
            } else
                chatTemp.multisentenceRespond("My name is " + message);
        }
        if (name == "safety") {
            gui.setText("You have switched to safety mode, to switch back press the 'switch' button\n\n", 2);
            chatTemp.multisentenceRespond("My name is " + message);
        }
    }
}
