package edu.amrita.cb.cen.ds.sads.TermProject;
import java.util.*;

public class strToken {
	int coeff[] = {};
    int pow[] = {};
	int degree;
	public strToken(String s,char x) 
	    { 	       
	        String str = s;
	        char c=x;
	        System.out.println("Polynomial entered: "+ s);
	        String[] arrOfStr = str.split("(?=\\+|\\-)|(?=<\\+|\\-)", 5);
	        
	        for(int i=0;i<arrOfStr.length;i++)
	        {
	        	if((arrOfStr[i].charAt(0)=='+')&&(arrOfStr[i].charAt(1)==c))
	        		arrOfStr[i] = arrOfStr[i].replace("+"+c,"+1"+c);
				if((arrOfStr[i].charAt(0)=='-')&&(arrOfStr[i].charAt(1)==c))
	        		arrOfStr[i] = arrOfStr[i].replace("-"+c,"-1"+c);
				if(arrOfStr[i].charAt(arrOfStr[i].length()-1)==c)
					arrOfStr[i] = arrOfStr[i].replace(c+"",c+"p1");
				if((arrOfStr[i].charAt(0)==c)&&(arrOfStr[i].charAt(1)=='p'))
	        		arrOfStr[i] = arrOfStr[i].replace(c+"p","1"+c+"p");
				String[] arrOfStr1 = arrOfStr[i].split(c+"p",2);
				if(arrOfStr1.length==2)
				{
					coeff = Arrays.copyOf(coeff, coeff.length+1);
					coeff[coeff.length - 1] = Integer.valueOf(arrOfStr1[0]);
					pow = Arrays.copyOf(pow, pow.length+1);
					pow[pow.length - 1] = Integer.valueOf(arrOfStr1[1]);
				}
				else
				{
					coeff = Arrays.copyOf(coeff, coeff.length+1);
					coeff[coeff.length - 1] = Integer.valueOf(arrOfStr1[0]);
					pow = Arrays.copyOf(pow, pow.length+1);
					pow[pow.length - 1] = 0;
				}

	        } 
	        System.out.println("Coefficients' array: "+Arrays.toString(coeff));
	        System.out.println("Powers' array: "+Arrays.toString(pow));
	        degree = getDegree(pow);
	    }
	 public int getDegree(int a[])
	 {
		 int arr[] = a;
		 int max_pow = arr[0];
		 for (int i = 1; i < arr.length; i++) 
             if (arr[i] > max_pow) 
            	 max_pow = arr[i]; 
        
         return max_pow;
	 }
	}
