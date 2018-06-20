/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rafał
 */
public class FieldCalculatorTest {
    
    private FieldCalculator fieldCalculator;
	
    @Before
    public void createObject()
    {
		fieldCalculator= new FieldCalculator();
    }
 
    @After
    public void cleanUp()
    {
    } 
 
    @BeforeClass
    public static void setUpClass()
    {
    	 System.out.println("Start test");
    }
 
    @AfterClass
    public static void cleanUpClass()
    {
    	System.out.println("End of test");
    }
    
  
 
    @Test
    public void testSquare1()
    {
    	assertEquals(16.0,fieldCalculator.calculateSquare(4),0);
    }
    @Test
    public void testSquare2()
    {
    	assertNotEquals(15.0,fieldCalculator.calculateSquare(4));
    }
    @Test
    public void testSquare3()
    {
    	assertTrue(16.0==fieldCalculator.calculateSquare(4));
    }
    @Test
    public void testCircle1()
    {
    	assertEquals(Math.PI*2*2,fieldCalculator.calculateCircle(2),0);
    }
    @Test
    public void testCircle2()
    {
    	assertFalse(Math.PI*2*2*2==fieldCalculator.calculateCircle(2));
    }
    @Test
    public void testCircle3()
    {
    	assertNotEquals(Math.PI*2*2*2,fieldCalculator.calculateCircle(2));
    }

    @Test
    public void testTriangle1()
    {
    	assertEquals(6.92,fieldCalculator.calculateTriangle(4),0.1);
    }
    @Test
    public void testTriangle2()
    {
    	assertNotEquals(3.0,fieldCalculator.calculateTriangle(4));
    }
    @Test
    public void testTriangle3()
    {
    	assertTrue(6.0!=fieldCalculator.calculateTriangle(4));
    }

    @Test
    public void testRectangle1()
    {
    	assertEquals(8.0,fieldCalculator.calculateRectangle(2,4),0);
    }
    @Test
    public void testRectangle2()
    {
    	assertNotEquals(7.0,fieldCalculator.calculateRectangle(2,4));
    }
    @Test
    public void testRectangle3()
    {
    	assertFalse(8.0!=fieldCalculator.calculateRectangle(2,4));
    }
    
}
