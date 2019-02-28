/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.cv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;

/**
 * Utility class to convert OpenCV images to java
 * @author albarral
 */
public class Image
{
    // transform opencv mask to java image
    public static BufferedImage convertMask(Mat mat)
    {                
        if (mat.type() == CvType.CV_8UC1)
        {
            try 
            {
                // convert mat to buffer
                MatOfByte mat2 = new MatOfByte();
                Highgui.imencode(".jpg", mat, mat2); 
                byte[] byteArray = mat2.toArray();

                // convert buffer to java image 
                InputStream in = new ByteArrayInputStream(byteArray);
                return ImageIO.read(in);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                return null;
            }            
        }
        else
        {
            System.out.println("tron.cv.Image: convertMask() failed. Input mat is not a mask");                 
            return null;
        }
    }
    
}
