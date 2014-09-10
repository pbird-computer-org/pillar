package test;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 
public class PillarTest {
    
   public static void main(String[] args){
      PillarTest  swingControlDemo = new PillarTest();      
      swingControlDemo.showTextFieldDemo();
   }

   // -------------------------------------------------------
   
   private Hashtable<String, ArrayList<String>> 
   		m_relation = new Hashtable<String, ArrayList<String>>()
   		;
	
private void buildRelation( final String newspaper, final String newAd )
{
	// -- check to see if the ad has already been placed in the paper
	// -- if not, initialize the relation
	
	if (null == m_relation.get(newspaper))
		m_relation.put( newspaper,  new ArrayList<String>() );
	
	// -- Given a newspaper and an ad, build the relation
	
	final ArrayList<String> ads = m_relation.get(newspaper);		
	ads.add( newAd );
	m_relation.put( newspaper, ads );
}

   	// ---------------------------------------------------
   
   private JFrame mainFrame;

   private JLabel statusLabel;
   private JPanel controlPanel;

   public PillarTest(){
      prepareGUI();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Pillar Test");
      mainFrame.setSize(500,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     
      statusLabel = new JLabel("", JLabel.CENTER);    

      statusLabel.setSize(100,50);

      controlPanel = new JPanel();
      controlPanel.setLayout(new BoxLayout( controlPanel, BoxLayout.Y_AXIS));

      mainFrame.add(statusLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);
   }

   private void showTextFieldDemo(){
	   final JLabel  
	   		newspaperlabel= new JLabel("NewsPaper: ", JLabel.RIGHT)
	   		,adLabel = new JLabel("Ad: ", JLabel.RIGHT)
	   		;

	   final JTextField 
	   		newspaper = new JTextField( "Freep" )
	   		,ad = new JTextField( "This is the Ad", 100 )
	   		;      

	   final JButton loginButton = new JButton("Register");
	      
	   loginButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {     
	            String 
	            	data = "Newspaper " + newspaper.getText()
	            		+ ", Ad: " + ad.getText()
	            		; 
	            statusLabel.setText(data);      
	            
	            buildRelation( newspaper.getText(), ad.getText() );
	         }
	   }); 

       controlPanel.add(loginButton);
      
      controlPanel.add(newspaperlabel);
      controlPanel.add(newspaper);      
      controlPanel.add(adLabel);       
      controlPanel.add(ad);

      mainFrame.setVisible(true);  
   }
}
