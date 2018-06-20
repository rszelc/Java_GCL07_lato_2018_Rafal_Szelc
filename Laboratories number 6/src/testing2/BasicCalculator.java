/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Rafał
 */
public class BasicCalculator {
    public double calculateSum(double a, double b){
        return a+b;
    }
    public double calculateDifference(double a, double b){
        return a-b;
    }
    public double calculateMultiplication(double a, double b){
        return a*b;
    }
    public double calculateDivision(double a, double b){
        if (b == 0) {
		        throw new IllegalArgumentException("Zero in denomination!");
		    }
        else{
		return a/b;
        }
    }
    public double calculatePow(double a, double b){
        return pow(a,b);
    }
    public double calculateSqrt(double a){
        if (a < 0) {
	        throw new IllegalArgumentException("Parameter lower than zero");
	    }
		return sqrt(a);
    }
    
}
