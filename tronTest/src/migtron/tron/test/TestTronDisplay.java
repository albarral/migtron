/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.test;

import migtron.tron.display.Display;
import migtron.tron.display.SimpleDisplay;

/**
* Test class for tron.display package.
* @author albarral
 */

public class TestTronDisplay
{
    String modName;
    
    public TestTronDisplay()
    {
        modName = "TestTronDisplay";
    }

    public void makeTest()
    {
        System.out.println(modName  + ": test start");
        //testSimpleDisplay();
        testDisplay();
        System.out.println(modName  + ": test end");
    }

    private void testSimpleDisplay()
    {
        SimpleDisplay display = new SimpleDisplay("display");
        display.showImage("tomas_small.jpg");
        try {Thread.sleep(1000);} catch (Exception e) {}
        display.showImage("david_small.jpg");
    }

    private void testDisplay()
    {
        Display display = new Display("display");
        display.addWindow("tomas_small.jpg");
        display.addWindow("david_small.jpg");
        try {Thread.sleep(1000);} catch (Exception e) {}
        display.updateWindow(1, "tomas_small.jpg");
        try {Thread.sleep(1000);} catch (Exception e) {}
        display.updateWindow(0, "david_small.jpg");

    }
}
