package com.example;

import static org.junit.Assert.assertTrue;

import javax.swing.text.BadLocationException;

import org.junit.Test;

import com.chatbot.Interface;
import com.chatbot.Lonely;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /*
     * tests basic input and output with correct pattern matching
     */
    @Test
    public void botResponseTest(){
        boolean result = Lonely.testResponse();
        assertTrue(result);
    }
    /*
     * Tests that the interface can be created without error
     */
    @Test
    public void interfaceTest(){
        boolean result = Interface.testInterface();
        assertTrue(result);
    }
    /*
     * 
     */
    @Test
    public void switchBotTest() throws BadLocationException{
        boolean result = Lonely.newBotTest();
        assertTrue(result);
    }
}
