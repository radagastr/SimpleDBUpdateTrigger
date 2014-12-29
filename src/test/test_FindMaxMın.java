package test;

import static org.junit.Assert.*;
import maxmin.FindMaxAndMin;

import org.junit.Test;

import software.ConvertXtoY;
import software.Line;

public class test_FindMaxMýn {

	@Test
	public void test_max() {
		 
		String[] f1valuesx=new String[5];
		f1valuesx[0]="12";
		f1valuesx[1]="10";
		f1valuesx[2]="-100";
		f1valuesx[3]="9";
		f1valuesx[4]="25";
		
		  assertEquals("25.0", FindMaxAndMin.max(f1valuesx));    
		        
	}
	@Test
	public void test_min() {
		 
		String[] f1valuesx=new String[5];
		f1valuesx[0]="12";
		f1valuesx[1]="10";
		f1valuesx[2]="-100";
		f1valuesx[3]="9";
		f1valuesx[4]="25";
		
		  assertEquals("-100.0", FindMaxAndMin.min(f1valuesx));    
		        
	}

}
