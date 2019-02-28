/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.math;

/**
 * Utility class to perform conversions of spatial coordinates
 * @author albarral
 */
public class Coordinates 
{
    private float x;
    private float y;
    private float magnitude;
    private float angle;            // degrees [-180, 180]

    public float getX() {return x;};
    public float getY() {return y;};
    public float getMagnitude() {return magnitude;};
    public float getAngle() {return angle;};
    
    public void setCartesian(float x, float y)
    {
        this.x = x;
        this.y = y;        
        computePolar();
    }

    public void setPolar(float magnitude, float angle)
    {
        this.magnitude = magnitude;
        this.angle = angle;        
        computeCartesian();        
    }
    
    private void computePolar()
    {
        magnitude = (float)Math.sqrt(x*x + y*y);        
        float radians = (float)Math.atan2(y, x);
        angle = (float)Math.toDegrees(radians);       
    }

    private void computeCartesian()
    {
        float radians = (float)Math.toRadians(angle);       
        x = magnitude*(float)Math.cos(radians);
        y = magnitude*(float)Math.sin(radians);        
    }
}
