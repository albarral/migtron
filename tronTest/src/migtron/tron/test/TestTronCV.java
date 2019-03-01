/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.test;

import java.awt.image.BufferedImage;

import migtron.tron.cv.ImageUtils;
import migtron.tron.cv.Mask;
import migtron.tron.cv.MaskDrawing;
import migtron.tron.cv.OpenCV;
import migtron.tron.display.Display;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

/**
* Test class for goon.features package.
* @author albarral
 */

public class TestTronCV
{
    String modName;
    
    public TestTronCV()
    {
        modName = "TestTronCV";
    }

    public void makeTest()
    {
        OpenCV.activate();

        System.out.println(modName  + ": test start");
//        testMaskDrawing();
        testMaskOperations();
        System.out.println(modName  + ": test end");
    }

    private void testMaskDrawing()
    {
        System.out.println(modName  + ".testMaskDrawing() ...");
        int imgW = 200;
        int imgH = 100;

        MaskDrawing maskDrawing = new MaskDrawing(imgW, imgH);
        maskDrawing.fillTopLeft();
        BufferedImage image1 = ImageUtils.maskCV2Java(maskDrawing.getMask());

        maskDrawing.clear();
        maskDrawing.fillTopRight();
        BufferedImage image2 = ImageUtils.maskCV2Java(maskDrawing.getMask());

        maskDrawing.clear();
        maskDrawing.fillBottomLeft();
        BufferedImage image3 = ImageUtils.maskCV2Java(maskDrawing.getMask());

        maskDrawing.clear();
        maskDrawing.fillBottomRight();
        BufferedImage image4 = ImageUtils.maskCV2Java(maskDrawing.getMask());
                
        // show two images at the same time
        Display display = new Display("display");
        display.addWindow(image1);
        display.addWindow(image2);
        display.addWindow(image3);
        display.addWindow(image4);
    }

    private void testMaskOperations()
    {
        System.out.println(modName  + ".testOperations() ...");

        // build first mask
        MaskDrawing maskDrawing = new MaskDrawing(200, 100);
        //maskDrawing.fillTop();
        maskDrawing.fillTopRight();
        Mask mask1 = new Mask(maskDrawing.getMask());
                
        // build sedond mask
        maskDrawing.clear();
        //maskDrawing.fillLeft();
        maskDrawing.fillBottomLeft();
        Mask mask2 = new Mask(maskDrawing.getMask());

        // get union
        Mask maskOr = (Mask)mask1.clone();                
        maskOr.merge(mask2);
        // get intersection
        Mask maskAnd = (Mask)mask1.clone();                
        maskAnd.intersect(mask2);
                
        // show all
        Display display = new Display("display");
        display.addWindow(ImageUtils.maskCV2Java(mask1.getMask()));
        display.addWindow(ImageUtils.maskCV2Java(mask2.getMask()));
        display.addWindow(ImageUtils.maskCV2Java(maskOr.getMask()));
        display.addWindow(ImageUtils.maskCV2Java(maskAnd.getMask()));
    }    
}
