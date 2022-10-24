
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class gui implements ActionListener {
    
    // CHATBOT VARS
    static boolean askedHowAreYou = false;
    static boolean askedHowAreYouFeeling = false;
    static boolean askedDoctor = false;
    static boolean askedName = false;
    static boolean safetyQuestion=false;
    static boolean danger = false;
    static boolean hobby = false;
    static int responsesTillDoctor = 0;
    public static void main(String args[]) {

        
        // Rand num gen
        Random rand = new Random();

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
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        

        // Text Area at the Center
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ta);
    

        //Adding Components to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setVisible(true);
        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){  
               String a = tf.getText();
               ta.append("You: " + a + "\n\n");
               String b = response(a.toLowerCase(), rand);
            ta. append("Mr.Lonely: "+ b + "\n\n");
               tf.setText("");
            }

   
    });}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static String response(String a, Random rand){
        /* 
         * RESPONSES: HOW LONG HAVE YOU BEEN FEELING THIS WAY, 
         * 
         */
        responsesTillDoctor++;


        /* 
         * Hello Check
         * Only will ask how are you once
         */
        if((a.contains("hello") || a.contains("hi") || a.contains("hey")) && !a.contains("how")&&askedHowAreYou==false){
            
            if (askedHowAreYou == false){
                askedHowAreYou = true;
                return "Hello! How are you?";
            }         
            return "Hello!";
        }

        /*
         * How are you check
         * Only will ask how are you feeling / how are you once
         */
        if(a.contains("how are you")){
            if(askedHowAreYou == true){
                askedHowAreYouFeeling = true;
                return "I am good! How have you been feeling lately?";
            } else {
                askedHowAreYou = true;
                return "I'm doing well, how are you?";
            }
        }

        /*
         * Not feeling good check
         * Random responses
         */
        if(a.contains("lonely") || a.contains("depressed") || a.contains("sad") || a.contains("not") && (a.contains("good") || a.contains("happy"))||a.contains("bad")){
            
            int amtResponse = 4;
            int randNum = rand.nextInt(amtResponse);
            askedName = true;
            switch (randNum) {
                case 0:
                    return "Oh that must be really tough, before we continue may I get your name?";
                case 1:
                    return "I'm sorry to hear that! Before we discuss this, can I get your name?";
                case 2:
                    return "I understand how you are feeling, before we talk about it can I get your name?";
		    case 3:
			    return "Let's talk about this more, I'm Unlonely, what's your name?";
                default:
                    return "OUT OF BOUNDS?!";
            }  
        }

        /*
         * Feeling good check
         * Random Responses
         */
        if(a.contains("good") || a.contains("happy")){
            int amtResponse = 2;
            int randNum = rand.nextInt(amtResponse);
            switch (randNum) {
                case 0:
                    return "I'm glad to hear that. What are you looking for from me?";
                case 1:
                    return "Oh thats good! What brings you here?";
                default:
                    return "OUT OF BOUNDS?!";
            }
        }

        /*
         * Thank you check
         * Random Responses
         */
        if (a.contains("thank")){
            int amtResponse = 2;
            int randNum = rand.nextInt(amtResponse);
            switch (randNum) {
                case 0:
                    return "You're welcome.";
                case 1:
                    return "No Worries.";
                default:
                    return "OUT OF BOUNDS?!";
            }
        }

        /*
         * High danger check
         * If they respond with yes after they will be sent the message  "Ok here is the details xxxx.xxxx at xxxx on xxx at xxx"
         */
        if (a.contains("death") || a.contains("suicide") || a.contains("kill")){
            responsesTillDoctor = 0;
            askedDoctor = true;
            danger = true;
            return "I think we should talk about this in person do you want me to recommend you to a doctor?";
        }

        /*
         * Continuation of high danger check 
         */
        if (a.contains("yes") && responsesTillDoctor == 1 && askedDoctor == true){
            return "Ok here is the details xxxx.xxxx at xxxx on xxx at xxx";
        }

        /*
         * Asking for chatbot name check
         */
        if (a.contains("name") && !a.contains("my")){
            askedName = true;
            return "My name is Unlonely what's yours?";
        }

        /*
         * Responding to users name
         * Askes safety question to keep conversation going
         */
        if (askedName == true || (a.contains("my") && a.contains("name"))){
            askedName = false;
            safetyQuestion=true;
            return "Thats an amazing name!\n Before we continue, do you feel you are a danger to yourself or anyone around you?";
        }

        /*
         * Danger and yes check
         * If safetyQuestion has been asked and user responds yes danger = true
         * Recommedns user to call local emergency
         */
        if(safetyQuestion==true&& a.contains("yes")){
            safetyQuestion=false;
            danger=true;
            return "We recommend you dial your local emergency line, they will help you.\n Your local emergency line is xxx";
        }

        /*
         * Danger and no check
         * If user declines calling local services danger is set to false
         */
        if(danger==true&&a.contains("no")){
            danger=false;
            return "I am still here for you, however I strongly urge you to contact emergency services";
            
        } 

        /*
         * If user does not say no chat bot exits conversation 
         */
        if (danger==true&&!a.contains("no")) return "They will help you from here on out. Well wishes.";
        
        /*
         * 
         * User is safe and then chatbot prompts user to talk about hobbies
         * Set hobby to true
         */
        if(safetyQuestion==true && a.contains("no")){
            safetyQuestion=false;
            hobby=true;
            return "Good to hear :)\n So... What do you do with your free time?";
        }
        
        /*
         * No friends check
         */
        if(a.contains("friend") && a.contains("no")){
            return "Dont worry I am your friend!";
        }

        /*
         * No hobbies check
         */
        if (hobby==true&&a.contains("nothing")){
            hobby=false;
            return("Oh im sorry to hear that, have you been feeling that way for a while?");
        }

        /*
         * Start Hobbies
         */
        if (hobby==true&&(a.contains("snowboarding")||a.contains("skiing")||a.contains("snowboard")||a.contains("ski"))){
            hobby=false;
            return("No way that's awesome! I love the mountains too that's a good way to clear your mind. Where do you like to go?");
        }

        if (a.contains("big white")||a.contains("silver star")) {
            return("Oh that's so cool I love it there!");
        }

        if (hobby==true&&(a.contains("netflix")||a.contains("smoke")||a.contains("video games")||a.contains("tv"))){
            hobby=false;
            return("Those are definitely fun hobbies, but if you've been feeling down you should try to find a hobby that gets you active!");
        }
        
        if (hobby == true && a.contains("friend") && !a.contains("no")){
            hobby = false;
            return("I love being with friends too!");
        }
        if(hobby==true&&!(a.contains("nothing"))){
            hobby=false;
            return("Oh that sounds interesting! How long have you been doing that (years)");
        }
        /*
         * End Hobbies
         */

        /*
         * User leaving check
         */
        if (a.contains("bye") || a.contains("go") || a.contains("leave")){
            return "Bye! It was very nice talking to you, feel free to come say hi anytime :)";
        }

        return "Sorry I did not understand. Can you say it in a different way?";
    }
}

