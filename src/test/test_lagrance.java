package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import software.ConvertXtoY;
import software.ConvertYtoX;
import software.Line;

import org.junit.Test;
//import static org.junit.Assert.assertEquals;

public class test_lagrance {
	
		double sum;
		private ArrayList<Line> liste=new ArrayList<Line>();
		private ArrayList<Line> liste2=new ArrayList<Line>();
		private ArrayList<Line> liste3=new ArrayList<Line>();
	    @SuppressWarnings("deprecation")
		@Test
	    public void valueofarraylist() {
	        
	    	Line line1=new Line();
	        line1.setX(1);
	        line1.setY(9);
	        
	     assertEquals(1,0,line1.getX());  
	     assertEquals(9,0,line1.getY()); 
	        }
	     
		@SuppressWarnings("deprecation")
		@Test
	    public void test_xtoy(){
	    	 
			Line line2=new Line();
	        line2.setX(0);
	        line2.setY(3);
	        liste.add(line2);
	        
	        Line line3=new Line();
	        line3.setX(5);
	        line3.setY(28);
	        liste.add(line3);
	        
	        Line line4=new Line();
	        line4.setX(-1);
	        line4.setY(4);
	     
	        liste.add(line4);//x^2+3
	         
	        assertEquals("28.0", ConvertXtoY.xToY((float) 5.0,liste));        
	        assertEquals("84.0", ConvertXtoY.xToY((float) -9.0,liste));        
	   
	    	
	    	
	    }
		@SuppressWarnings("deprecation")
		@Test
	    public void test_ytox(){
	    	 
			Line line5=new Line();
	        line5.setX(1);
	        line5.setY(0);
	        liste2.add(line5);
	        
	        Line line6=new Line();
	        line6.setX(3);
	        line6.setY(14);
	        liste2.add(line6);
	        
	        Line line7=new Line();
	        line7.setX(6);
	        line7.setY(50);
	     
	        liste2.add(line7);
	        
	        Line line8=new Line();
	        line8.setX(7);
	        line8.setY(66);
	     
	        liste2.add(line8);
	        
	        assertEquals("3", ConvertYtoX.yToX((float) 36.0, liste2));	        
        }
		
		@SuppressWarnings("deprecation")
		@Test
	    public void test_XtoY2(){
	    	 
			Line line5=new Line();
	        line5.setX(0);
	        line5.setY(3);
	        liste3.add(line5);
	        
	        Line line6=new Line();
	        line6.setX(-2);
	        line6.setY(-7);
	        liste3.add(line6);
	        
	        Line line7=new Line();
	        line7.setX(2);
	        line7.setY(13);
	     
	        liste3.add(line7);
	        
	        Line line8=new Line();
	        line8.setX(-5);
	        line8.setY(-127);
	     
	        liste3.add(line8);
	        
	        assertEquals("-65.00001", ConvertXtoY.xToY((float) -4.0, liste3));	        
        }
}
	   
	
	
