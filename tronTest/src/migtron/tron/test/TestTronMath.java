/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.test;

import java.awt.geom.Point2D.Float;
import java.awt.Point;

import migtron.tron.math.Coordinates;       
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
        testCoordinates();
        //testEllipse();
        System.out.println(modName  + ": test end");
    }

    private void testCoordinates()
    {
        Point pos = new Point(50, 50);                
        Point polar = Coordinates.computePolarPoint(pos);
        Point posBack = Coordinates.computeCartesianPoint(polar);

        System.out.println("pos = " + pos.toString());
        System.out.println("polar = " + polar.toString());
        System.out.println("cartesian = " + posBack.toString());
        
        Float pos2 = new Float(50.0f, 50.0f);                
        Float polar2 = Coordinates.computePolar(pos2);
        Float posBack2 = Coordinates.computeCartesian(polar2);
        
        System.out.println("pos2 = " + pos2.toString());
        System.out.println("polar2 = " + polar2.toString());
        System.out.println("cartesian2 = " + posBack2.toString());
    }
    
    private void testEllipse()
    {
        Ellipse ellipse = new Ellipse();
        
        System.out.println(ellipse.toString());
    }
}
