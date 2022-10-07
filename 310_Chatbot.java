
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class gui implements ActionListener {


    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Unlonley");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m2 = new JMenu("Help");
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Report a bug");
        JMenuItem m22 = new JMenuItem("Contact Authorities");
        m2.add(m11);
        m2.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(20); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        

        // Text Area at the Center
        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        //Adding Components to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){  
               String a = tf.getText();
               ta.append("You: " + a + "\n\n");
               String b = response(a.toLowerCase());
            ta. append("Mr.Lonely: "+ b + "\n\n");
               tf.setText("");
    }

   
});}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
public static String response(String a){

if(a.contains("hi")||a.contains("hello")||a.contains("hey")||a.contains("yo")||a.contains("howdy")){
    return("Hi there! How are you?");
   } else if(a.contains("good")&&!a.contains("not good")){
    return("Im glad to hear it, do you feel lonely today?");
   }  else return("Sorry I did not understand");



}
}

