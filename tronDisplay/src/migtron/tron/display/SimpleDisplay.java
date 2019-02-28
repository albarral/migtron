/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.display;

//import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;


/**
 * Utility class to show an image in a display
 * @author albarral
 */
public class SimpleDisplay 
{
    JFrame frame;       // display frame
    JLabel label;          // display label     
    
    public SimpleDisplay(String title)
    {
        frame = new JFrame(title);        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        label = null;
    }
    
    // show image located in given path 
    public void showImage(String imagePath)
    {                
        try 
        {
            if (checkPathExists(imagePath))
            {
                System.out.println("SimpleDisplay: showing image " + imagePath);
                // if first image, create label and add it to frame
                if (label == null)
                {
                    label = new JLabel(new ImageIcon(imagePath));
                    frame.getContentPane().add(label);
                    frame.pack();
                    frame.setVisible(true);                    
                }
                // otherwise, just update the label
                else
                {
                    label.setIcon(new ImageIcon(imagePath));
                    //frame.repaint();  // frame is not resized
                }
            }
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }            
    }
    
    private boolean checkPathExists(String path)
    {
        boolean bvalid = false;
        if (!path.isEmpty())
        {
            File file = new File(path);
            bvalid = (file.exists());
        }

        if (!bvalid)
        {
            System.out.println("SimpleDisplay: path not exists " + path);                                       
        }
        return bvalid;
    }
}
