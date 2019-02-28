/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.cv;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;

/**
 * Utility class to show OpenCV images in java frames
 * @author albarral
 */
public class DisplayWindow 
{
    JFrame frame;       // swing frame
    
    public DisplayWindow(String title)
    {
        frame = new JFrame(title);        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    // show given mask in a display window
    public void showMask(Mat mat)
    {                
        try 
        {
            // convert mask to java image
            BufferedImage image = Image.convertMask(mat);

            if (image != null)
            {
                // and put image to frame
                frame.getContentPane().add(new JLabel(new ImageIcon(image)));
                frame.pack();
                frame.setVisible(true);                    
            }
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }            
    }
}
