/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.cv;

import org.opencv.core.Mat;

/**
 * Utility class to show OpenCV images in java frames
 * @author albarral
 */
public class Display
{
    private static int numWindows = 0;
        
    // create new window with given title to show image
    public static void showWindow(String title, Mat mat)
    {                
        numWindows++;
        DisplayWindow displayWindow = new DisplayWindow(title);
        displayWindow.showMask(mat);
    }
}
