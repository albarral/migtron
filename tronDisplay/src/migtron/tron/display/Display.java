/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.display;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Utility class to show multiple images in a display
 * @author albarral
 */
public class Display
{
//    private static final int MAX_WINDOWS = 4; // max number of windows allowed in the display
//    private static final int NUM_COLUMNS = 2; // predefined number of columns

//    private int width;  // display width
//    private int height;  // display height
    private JFrame frame;       // display frame
    private List<JLabel> listWindows;   // list of display windows (JLabels)
    
    public Display(String title)
    {
//        this.width = width;
//        this.height = height;
        
        frame = new JFrame(title);        
//        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));        
        listWindows = new ArrayList<>();
    }
    
    // add new window with given image (from path)
    public void addWindow(String imagePath)
    {      
        // create icon
        ImageIcon icon = createIcon(imagePath);
        // create label and add it to frame
        if (icon != null)
        {
            JLabel label = new JLabel(icon);
            listWindows.add(label);            
            frame.getContentPane().add(label);            
        }
        // show the frame
        frame.pack();
        frame.setVisible(true);                                    
    }    
    
    // show image located in given path in specified window
    public void updateWindow(int position, String imagePath)
    {                
        if (position < listWindows.size())
        {            
            // create icon        
            ImageIcon icon = createIcon(imagePath);
            // update label
            if (icon != null)
            {
                listWindows.get(position).setIcon(icon);
            }
        }
        else
        {
            System.out.println("Display: updateWindow() failed, window not exists " + position);                                                   
        }
    }

    private ImageIcon createIcon(String imagePath)
    {
        if (checkPathExists(imagePath))
        {
            return new ImageIcon(imagePath);
        }
        else
            return null;        
    }

    private ImageIcon createIcon(BufferedImage image)
    {
        if (image != null)
        {
            return new ImageIcon(image);
        }
        else
            return null;        
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
            System.out.println("Display: path not exists " + path);                                       
        }
        return bvalid;
    }
    
}
