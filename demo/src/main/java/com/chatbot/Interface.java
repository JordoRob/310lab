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
        ta.setEditable(false);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setVisible(true);
        ActionListener actionListener = new App(bot, chatSession, this);
        tf.addActionListener(actionListener);
        send.addActionListener(actionListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    public void setText(String a){
        ta.append(a);
    }
    public String getText(){
        return tf.getText();
    }
}
