/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.goon.test;

import migtron.tron.cv.OpenCV;

/**
 *
 * @author albarral
 */
public class GoonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        OpenCV.activate();
        
        TestGoonFeatures testGoonFeatures = new TestGoonFeatures();
        testGoonFeatures.makeTest();
    }    
}
