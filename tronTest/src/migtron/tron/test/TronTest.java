/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.test;

/**
 *
 * @author albarral
 */
public class TronTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        TestTronCV testTronCV = new TestTronCV();
        testTronCV.makeTest();

        TestTronMath testTronMath = new TestTronMath();
        //testTronMath.makeTest();

        TestTronDisplay testTronDisplay = new TestTronDisplay();
        //testTronDisplay.makeTest();                
    }
    
}
