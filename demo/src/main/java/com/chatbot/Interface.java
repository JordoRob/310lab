package com.chatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Interface implements ActionListener {
    JFrame frame = new JFrame("Unlonley");
    // Creating the MenuBar and adding components
    JMenuBar mb = new JMenuBar();
    JMenu m2 = new JMenu("Help");
    JMenuItem m11 = new JMenuItem("Report a bug");
    JMenuItem m22 = new JMenuItem("Contact Authorities");
    // Creating the panel at bottom and adding components
    JPanel panel = new JPanel(); // the panel is not visible in output
    JLabel label = new JLabel("Enter Text");
    JTextField tf = new JTextField(20); // accepts upto 10 characters
    JButton send = new JButton("Send");
    JButton switchbutton = new JButton("Switch");
    // Text Area at the Center
    JTextArea ta = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(ta);
    // Adding Components to the frame

    public Interface(Bot bot, Chat chatSession) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        mb.add(m2);
        m2.add(m11);
        m2.add(m22);
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(switchbutton);
        ta.setEditable(false);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setVisible(true);
        addListener(bot, chatSession, this, 0);
        
    }
    public static boolean testInterface(){
        try {
            JFrame frame = new JFrame("Unlonley");
            // Creating the MenuBar and adding components
            JMenuBar mb = new JMenuBar();
            JMenu m2 = new JMenu("Help");
            JMenuItem m11 = new JMenuItem("Report a bug");
            JMenuItem m22 = new JMenuItem("Contact Authorities");
            // Creating the panel at bottom and adding components
            JPanel panel = new JPanel(); // the panel is not visible in output
            JLabel label = new JLabel("Enter Text");
            JTextField tf = new JTextField(20); // accepts upto 10 characters
            JButton send = new JButton("Send");
            JButton switchbutton = new JButton("Switch");
            // Text Area at the Center
            JTextArea ta = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(ta);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            mb.add(m2);
            m2.add(m11);
            m2.add(m22);
            panel.add(label); // Components Added using Flow Layout
            panel.add(tf);
            panel.add(send);
            panel.add(switchbutton);
            ta.setEditable(false);
            frame.getContentPane().add(BorderLayout.SOUTH, panel);
            frame.getContentPane().add(BorderLayout.NORTH, mb);
            frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
            frame.setVisible(false);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    public void setText(String a){ //getters and setters
        ta.append(a);
    }
    public String getText(){
        return tf.getText();
    }
    public void addAction(){

    }
    public void addListener(Bot bot, Chat chatSession, Interface a, int x){ //int x is 0 if this is the first time we have created the bot, otherwise it is 1

        if(x>0){
            ActionListener[] z = tf.getActionListeners(); //this removes all other action listeners (removes other bots)
            ActionListener[] y = switchbutton.getActionListeners();
                tf.removeActionListener(z[0]);
                send.removeActionListener(z[0]);
                switchbutton.removeActionListener(y[0]);
            
        }
        ActionListener text = new App(bot, chatSession, a); //sets up the App class as the actionlistener
        ActionListener change = new Switch(bot, chatSession);
        tf.addActionListener(text);
        send.addActionListener(text);
        switchbutton.addActionListener(change);
    }
    }

