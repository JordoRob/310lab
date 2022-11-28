package com.chatbot;
import java.util.ArrayList;

import org.fastily.jwiki.core.*;
public class Wikisearch {
    public static Wiki wiki = new Wiki.Builder().build();


    public String getDetail(String title){
         // login
        ArrayList<String> temp = wiki.search(title, 1); //Searches wikipedia for the item typed
       String para= wiki.getTextExtract(temp.get(0)); //gets the first search result
       if(para==null) //if there is no search results, this is returned
       return("Wow! Wikipedia doesn't even know what "+title+" is!");
       else{
       int period=0;
       StringBuilder small=new StringBuilder();
       for(int i=0; i<para.length(); i++){ //This API would send a massive wall of text, so I limited it to about 7 sentences
        if(period>7){
            break;
        }else{
        small.append(para.charAt(i));
        if(para.charAt(i)=='.')
        period++;
       }}
       return(small.toString());} //Returns the wikipedia paragraph(s)
    }
}
