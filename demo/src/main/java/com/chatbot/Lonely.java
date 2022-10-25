package com.chatbot;
import java.io.File;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;

public class Lonely {
    private static final boolean TRACE_MODE = false;
    static String botName = "Mr. Lonely";
    static String textLine = "";
    public static void main(String args[]){
        String resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = TRACE_MODE;
        Bot bot = new Bot("super", resourcesPath);
        Chat chatSession = new Chat(bot);
        bot.brain.nodeStats();
        Interface gui = new Interface(bot, chatSession);
        
    }

    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator +"demo"+File.separator+ "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }
    }

