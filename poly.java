package edu.amrita.cb.cen.ds.sads.TermProject;

import java.util.Scanner;
public class poly {
	static int Spow1[];
	static int Scoef1[];
	static int Spow2[];
	static int Scoef2[];
	static int degree1;
	static int degree2;
	static int maxVal;
	static char var;
public static void poly() 
{
	Scanner myObj = new Scanner(System.in);
	
	System.out.print("Enter the variable(eg.x/y/z) \n");
	var = myObj.nextLine().charAt(0);
	operations obj = new operations();
	String poly1;
	System.out.print("Enter first polynomial: \n");
	poly1 = myObj.nextLine();
	
	String poly2;
	System.out.print("Enter Second polynomial: \n");
	poly2 = myObj.nextLine();

	//TOKENISE: 1st Polynomial
	strToken tokenize1 = new strToken(poly1,var);
	degree1 = tokenize1.degree;
	System.out.println("Degree of 1st polynomial: "+degree1+"\n");
	
	//TOKENISE: 2nd Polynomial
	strToken tokenize2 = new strToken(poly2,var);
	degree2 = tokenize2.degree;
	System.out.println("Degree of 2nd polynomial: "+degree2+"\n");
	
	//Find maximum degree b/w 2.
	if(degree1>degree2)
		maxVal = degree1;
	else
		maxVal = degree2;
	
	//SPARSING: 1st Polynomial
	makeSparse Sparse1 = new makeSparse(maxVal,tokenize1.coeff,tokenize1.pow);
	//Sparse1(maxVal,tokenize1.coeff,tokenize1.pow);
	Spow1 = Sparse1.sparse_pow;
	Scoef1 = Sparse1.sparse_coef;
	
	//SPARSING: 2nd Polynomial
	makeSparse Sparse2 = new makeSparse(maxVal,tokenize2.coeff,tokenize2.pow);
	Spow2 = Sparse2.sparse_pow;
	Scoef2 = Sparse2.sparse_coef;
	
	
	//HASHSING: 1st Polynomial
	hashMap map1 = new hashMap();
	int len1 = Sparse1.sparse_pow.length;
	for(int i =0;i<len1;i++)
		map1.put(Sparse1.sparse_pow[i],Sparse1.sparse_coef[i]);
	
	for(int i =0;i<len1;i++)
	{
		System.out.print(Sparse1.sparse_pow[i]+" -----> ");
		System.out.println(map1.get(Sparse1.sparse_pow[i]));
	}
		
	
	MinHeap heap1 = new MinHeap(maxVal+2);
	
	for(int i =0;i<len1;i++)
		heap1.insert(Sparse1.sparse_pow[i]); 
	heap1.print(Scoef1);
	
	//HASHSING: 2nd Polynomial
	
	hashMap map2 = new hashMap();
	int len2 = Sparse2.sparse_pow.length;
	for(int i =0;i<len2;i++)
		map2.put(Sparse2.sparse_pow[i],Sparse2.sparse_coef[i]);
	
	for(int i =0;i<len2;i++)
	{
		System.out.print(Sparse2.sparse_pow[i]+" -----> ");
		System.out.println(map2.get(Sparse2.sparse_pow[i]));
	}
	MinHeap heap2 = new MinHeap(maxVal+2);
	
	for(int i =0;i<len2;i++)
		heap2.insert(Sparse2.sparse_pow[i]); 
	heap2.print(Scoef2);
	
}
}




/*
xp3+5xp2+2x+1
5xp4+2xp3+5xp2+6

multiplication
6yp3+7yp2+2y-1
2yp5-yp4-6yp3+5yp2-4

4zp5+2zp4+2zp2+z-2
2zp4-zp2+6z+10
square
*/