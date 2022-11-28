package com.chatbot;
import java.util.ArrayList;

import org.fastily.jwiki.core.*;
public class Wikisearch {
    public static Wiki wiki = new Wiki.Builder().build();


    public String getDetail(String title){
         // login
        ArrayList<String> temp = wiki.search(title, 1);
       String para= wiki.getTextExtract(temp.get(0)); // edit
       if(para==null)
       return("Wow! Wikipedia doesn't even know what "+title+" is!");
       else{
       int period=0;
       StringBuilder small=new StringBuilder();
       for(int i=0; period<7; i++){
        small.append(para.charAt(i));
        if(para.charAt(i)=='.')
        period++;
       }
       return(small.toString());}
    }
}
