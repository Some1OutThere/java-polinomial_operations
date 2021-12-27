package edu.amrita.cb.cen.ds.sads.TermProject;

//import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class operations {
	static char var;
	operations(){
		var = poly.var;
	}
	public static int[] Addition(){
		int Coeff1[] = poly.Scoef1;
		int Coeff2[] = poly.Scoef2;
		System.out.println("Sparse Coefficient array1: "+Arrays.toString(Coeff1));
		System.out.println("Sparse Coefficient array2: "+Arrays.toString(Coeff2));
		int[] ans;
		ans = new int[Coeff1.length];
		for(int i=0; i<Coeff1.length;i++)
		{
			ans[i] = Coeff1[i]+Coeff2[i];
		}
		System.out.println("Answer: "+Arrays.toString(ans));
		return ans;
	}
	public static int[] Subtraction(){

		int Coeff1[] = poly.Scoef1;
		int Coeff2[] = poly.Scoef2;
		System.out.println("Sparse Coefficient array1: "+Arrays.toString(Coeff1));
		System.out.println("Sparse Coefficient array2: "+Arrays.toString(Coeff2));
		int[] ans;
		ans = new int[Coeff1.length];
		for(int i=0; i<Coeff1.length;i++)
		{
			ans[i] = Coeff1[i]-Coeff2[i];
		}
		System.out.println("Answer: "+Arrays.toString(ans));
		return ans;
	}
	public static int[] Multiply(){
		int Coeff1[] = poly.Scoef1;
		int Coeff2[] = poly.Scoef2;
		int degree = poly.degree1+poly.degree2;
		int maxDegree = poly.maxVal;
		int ans[][] = new int[maxDegree+1][degree+2];
		int mul_ans[] = new int[degree+2];
		int l;
		int i=0;
		for(int j=0;j<mul_ans.length;j++)
			{
				l=j;
				for(int k=0;k<=maxDegree;k++)
				{	
					ans[i][l] = Coeff1[i]*Coeff2[k];
					l++;
				}
				System.out.println("Sparse Array#"+i+": "+Arrays.toString(ans[i]));
				i++;
				if(i==maxDegree+1)
					break;
			}			
		for(i = 0;i<=maxDegree;i++)
			for(int j=0;j<mul_ans.length;j++)
				mul_ans[j] = mul_ans[j]+ans[i][j];
		System.out.println("Answer: "+Arrays.toString(mul_ans));
		return mul_ans;
	}
	
	public static int[] Squaring(){
		Scanner s1 = new Scanner(System.in);
		
		System.out.print("Enter the variable(eg.x/y/z) \n");
		var = s1.nextLine().charAt(0);
		String poly;
		System.out.print("Enter the polynomial: \n");
		poly = s1.nextLine();
		strToken tokenize = new strToken(poly,var);
		int deg = tokenize.degree;
		makeSparse Sparse = new makeSparse(deg,tokenize.coeff,tokenize.pow);
		int Spow[] = Sparse.sparse_pow;
		int Scoef[] = Sparse.sparse_coef;
				
		hashMap map = new hashMap();
		int len = Sparse.sparse_pow.length;
		for(int i =0;i<len;i++)
			map.put(Sparse.sparse_pow[i],Sparse.sparse_coef[i]);
		
		for(int i =0;i<len;i++)
		{
			System.out.print(Sparse.sparse_pow[i]+" -----> ");
			System.out.println(map.get(Sparse.sparse_pow[i]));
		}
		MinHeap heap = new MinHeap(deg+2);
		
		for(int i =0;i<len;i++)
			heap.insert(Sparse.sparse_pow[i]); 
		heap.print(Scoef);
		
		int degree = 2*deg;
		int ans[][] = new int[deg+1][degree+2];
		int mul_ans[] = new int[degree+2];
		int l;
		int i=0;
		for(int j=0;j<mul_ans.length;j++)
			{
				l=j;
				for(int k=0;k<=deg;k++)
				{	
					ans[i][l] = Scoef[i]*Scoef[k];
					l++;
				}
				System.out.println("Sparse array#"+i+": "+Arrays.toString(ans[i]));
				i++;
				if(i==deg+1)
					break;
			}			
		for(i = 0;i<=deg;i++)
			for(int j=0;j<mul_ans.length;j++)
				mul_ans[j] = mul_ans[j]+ans[i][j];
		//System.out.println("Answer: "+Arrays.toString(mul_ans));
		return mul_ans;
	}
	
	public static void dispAnswer(int [] ans) {
		String[] supercript = {"","","\u00B2","\u00B3","\u2074","\u2075","\u2076","\u2077","\u2078","\u00B9"};
		//String[] supercript = {"","","^2","^3","^4","^5","^6","^7","^8","^9","^10"};
		int[] inv_Ans = ans;
		int len = inv_Ans.length;
		int[] Ans = new int[len];
		int i1=0;
		for(int i=len-1;i>=0;i--)
		{
			Ans[i1]=inv_Ans[i];
			i1++;
		}
		int j = len;
		String output = "";
		for(int i=0;i<len;i++) {
			j--;
			if(Ans[i]!=0)
			{
				if(Ans[i]<0 || i==0||(i==1 && Ans[0]==0))
				{
					if(j==1)
						output = output+String.valueOf(Ans[i])+var;
					else if(j==0)
						output = output+String.valueOf(Ans[i]);
					else
						output = output+String.valueOf(Ans[i])+var+supercript[j];
					}
				else
				{
					if(j==1)
						output = output+'+'+String.valueOf(Ans[i])+var;
					else if(j==0)
						output = output+'+'+String.valueOf(Ans[i]);
					else
						output = output+'+'+String.valueOf(Ans[i])+var+supercript[j];
				}
		}
		}
		//byte[] bytes = output.getBytes(StandardCharsets.ISO_8859_1);
		//String utf8EncodedString = new String(bytes, StandardCharsets.UTF_16);
		System.out.println("Answer: "+output);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int opt;
		System.out.println("\t\tEnter the polynomial operation to perform");
		System.out.println("1-ADDITION  2-SUBTRACTION  3-MULTIPLICATION  4-SQUARE");
		opt = s.nextInt();
		switch(opt) {
		case 1:
			System.out.println("ADDITION");
			poly.poly();
			int[] add_ans = Addition();
			dispAnswer(add_ans);
			break;
		case 2:
			System.out.println("SUBTRACTION");
			poly.poly();
			int[] sub_ans =Subtraction();
			dispAnswer(sub_ans);
			break;
		case 3:
			System.out.println("MULTIPLICATION");
			poly.poly();
			int[] mul_ans =Multiply();
			dispAnswer(mul_ans);
			break;
		case 4:
			System.out.println("SQUARE");
			int[] sqr_ans = Squaring();
			dispAnswer(sqr_ans);
			break;
			default:
				System.out.println("!!Enter the correct option!!");			
		}
	}
}
