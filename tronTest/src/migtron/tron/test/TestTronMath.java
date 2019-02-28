/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.test;

import migtron.tron.math.Ellipse;


/**
* Test class for tron.math package.
* @author albarral
 */

public class TestTronMath
{
    String modName;
    
    public TestTronMath()
    {
        modName = "TestTronMath";
    }

    public void makeTest()
    {
        System.out.println(modName  + ": test start");
        testEllipse();
        System.out.println(modName  + ": test end");
    }

    private void testEllipse()
    {
        Ellipse ellipse = new Ellipse();
        
        System.out.println(ellipse.toString());
    }
}
