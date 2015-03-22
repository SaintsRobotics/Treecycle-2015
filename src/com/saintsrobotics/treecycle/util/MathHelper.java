package com.saintsrobotics.treecycle.util;

/**
 * Contains utility methods for the robot.
 */
public class MathHelper {
    
    /**
     * Rotates a vector in Cartesian space.
     * 
     * @param x The x component of the vector.
     * @param y The y component of the vector.
     * @param angle The angle to rotate by.
     * @return The rotated vector.
     */
    public static double[] rotateVector(double x, double y, double angle) {
        double cosA = Math.cos(angle * (Math.PI / 180.0));
        double sinA = Math.sin(angle * (Math.PI / 180.0));
        double out[] = new double[2];
        out[0] = x * cosA - y * sinA;
        out[1] = x * sinA + y * cosA;
        return out;
    }
    
    /**
     * Normalizes wheel speeds if they're greater than the maximum.
     * 
     * @param wheels An array with the speeds, between 1.0 and -1.0.
     */
    public static void normalize(double wheels[]) {
        double maxMagnitude = 0;
        for (int i=0;i<wheels.length;i++)
            maxMagnitude = Math.max(maxMagnitude, Math.abs(wheels[i]));
        if (maxMagnitude <= 1.0)
            return;
        for (int i=0;i<wheels.length;i++)
            wheels[i] = wheels[i] / maxMagnitude;
    }
}
