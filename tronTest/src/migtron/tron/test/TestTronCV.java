/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import migtron.tron.cv.ImageUtils;
import migtron.tron.cv.Mask;
import migtron.tron.cv.MaskDrawing;
import migtron.tron.cv.OpenCV;
import migtron.tron.display.Display;
import migtron.tron.math.Ellipse;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


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
        testMask();
//        testMaskDrawing();
//        testMaskOperations();
        System.out.println(modName  + ": test end");
    }

    private void testMask()
    {
        System.out.println(modName  + ".testMask() ...");
        // image size
        int w = 100;
        int h = 100;
        // ellipse 
        int w2 = 100;
        int h2 = 50;
        float angle = 30.0f;
        // create mask with ellipse
        Mat mat = Mat.zeros(h, w, CvType.CV_8UC1);
        ImageUtils.drawFilledEllipse(mat, 50, 50, w2, h2, angle, ImageUtils.eColor.eCOLOR_WHITE);

        Mask mask = new Mask(mat);
        Mask mask2 = computeAndDrawEllipse(mask);
        
        Display display = new Display("original");
        display.addWindow(ImageUtils.cvMask2Java(mat));            
        Display display2 = new Display("computed");
        display2.addWindow(ImageUtils.cvMask2Java(mask2.getMat()));            
    }

    private void testMaskDrawing()
    {
        System.out.println(modName  + ".testMaskDrawing() ...");

        // create list for masks
        List<Mask> listMasks = new ArrayList<>();
        
        // create 4 masks (200 x 100)
        MaskDrawing maskDrawing = new MaskDrawing(200, 100);
        maskDrawing.fillTopLeft();        
        listMasks.add(new Mask(maskDrawing.getMat()));

        maskDrawing.clear();
        maskDrawing.fillTopRight();
        listMasks.add(new Mask(maskDrawing.getMat()));

        maskDrawing.clear();
        maskDrawing.fillBottomLeft();
        listMasks.add(new Mask(maskDrawing.getMat()));

        maskDrawing.clear();
        maskDrawing.fillBottomRight();
        listMasks.add(new Mask(maskDrawing.getMat()));
                
        // process masks (compute ellipses)
        List<Mask> listMasks2 = processMasks(listMasks);

        // show masks (original and processed)
        showMasks(listMasks, "original");
        showMasks(listMasks2, "processed");
    }

    private void testMaskOperations()
    {
        System.out.println(modName  + ".testMaskOperations() ...");

        // create 2 masks (200 x 100)
        MaskDrawing maskDrawing = new MaskDrawing(200, 100);
        maskDrawing.fillTopRight();
        Mask mask1 = new Mask(maskDrawing.getMat());
                
        maskDrawing.clear();
        maskDrawing.fillBottomLeft();
        Mask mask2 = new Mask(maskDrawing.getMat());

        // get union
        Mask maskOr = (Mask)mask1.clone();                
        maskOr.merge(mask2);

        // get intersection
        Mask maskAnd = (Mask)mask1.clone();                
        maskAnd.intersect(mask2);
                
        // create list for masks
        List<Mask> listMasks = new ArrayList<>();
        listMasks.add(mask1);
        listMasks.add(mask2);
        listMasks.add(maskOr);
        listMasks.add(maskAnd);

        // process masks (compute ellipses)
        List<Mask> listMasks2 = processMasks(listMasks);
        
        // show masks (original and processed)
        showMasks(listMasks, "original");
        showMasks(listMasks2, "processed");
    }    
    
    // show list of masks in a display
    private void showMasks(List<Mask> listMasks, String title)
    {
        Display display = new Display(title);
        
        for (Mask mask : listMasks)
        {
            BufferedImage image = ImageUtils.cvMask2Java(mask.getMat());
            display.addWindow(image);            
        }
    }

    // process list of masks computing their ellipses and drawing them 
    private List<Mask> processMasks(List<Mask> listMasks)
    {
        List<Mask> listMasks2 = new ArrayList<>();
        
        for (Mask mask : listMasks)
        {
            Mask mask2 = computeAndDrawEllipse(mask);
            listMasks2.add(mask2);
        }
        return listMasks2;
    }
    
    private Mask computeAndDrawEllipse(Mask mask)
    {
        // compute ellipse
        Ellipse ellipse = mask.computeEllipse();
        System.out.println("mask: " + ellipse.toString());
        // and draw it in a copy of the mask
        Mask mask2 = (Mask)mask.clone();
        ImageUtils.drawEllipse(mask2.getMat(), ellipse, ImageUtils.eColor.eCOLOR_GREY);
        return mask2;
    }
}
