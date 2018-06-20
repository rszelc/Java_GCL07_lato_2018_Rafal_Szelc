/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing2;

import static java.lang.Math.sqrt;

/**
 *
 * @author Rafał
 */
public class FieldCalculator {
    public double calculateSquare(double a){
        if (a <= 0) {
	        throw new IllegalArgumentException();
	    }
		return a*a;
    }
    public double calculateCircle(double a){
        if (a <= 0) {
	        throw new IllegalArgumentException();
	    }
		return Math.PI*a*a;
    }
    public double calculateTriangle(double a){
        if(a <= 0 )
		{
		    throw new IllegalArgumentException();
		}
        return (a*a*sqrt(3))/4;
    }
    public double calculateRectangle(double a, double b){
        if(a <= 0 || b<=0)
		{
		    throw new IllegalArgumentException();
		}	
		return a*b;
    }
    
}
