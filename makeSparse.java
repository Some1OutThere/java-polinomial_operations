package edu.amrita.cb.cen.ds.sads.TermProject;

public class makeSparse {
	 int sparse_pow[];
	 int sparse_coef[];
	public makeSparse(int max_val,int co[],int po[])
	 {
	int m = max_val;
	 int coef[] = co;
	 int powr[] = po;
	 sparse_coef = new int[m+1];
	 sparse_pow = new int[m+1];
	 
	 for(int i=0;i<sparse_pow.length;i++)
		 sparse_pow[i] = i;
	 
	 for(int j=0;j<powr.length;j++)
		 sparse_coef[powr[j]] = coef[j];

}
}
