package edu.amrita.cb.cen.ds.sads.TermProject;

public class hashMap {
	
	static class KVPair {
		 Integer key;
		 Integer value; 
		 
		 KVPair next; 
		 
		 public KVPair(Integer k, Integer v, KVPair n) {
			 key = k;
			 value = v;
			 next = n;
		 }
		 
		  public boolean isKey(Integer k) {
			  return (k.equals(key)); 
		  }
		 
		 @Override
		 public int hashCode() {
			 return key.hashCode();
		 }	 
	 }
	 
	 KVPair[] map;
	 // biggest value for bitSize is 32...
	 public static final int bitSize = 2;
	 
	 // Content indexed Map....
	 
	 public hashMap() {
		 
		 int len = 1;
		 
		 // compute 2^bitSize
		 for(int i=0; i<bitSize; i++) 
			 len *= 2;
		 
		 map = new KVPair[len];
	 }
	 
	 // Indexing locatins with a hash value ....
	 private static int hashLocation(int hashCode) {
		 
		 int oHash = hashCode & 0x7FFFFFFF;
		 int size = 32/bitSize;
		 size = size + ( (32 % bitSize == 0) ? 0: 1);
		 int mask = 1;
		 for(int i=1;i<bitSize; i++) 
			 mask = (mask << 1) | 1; 
		 int []a = new int[size]; 
		 int loc = 0;
		 
		 for(int j=0; j<size; j++) {
			 a[j] = (oHash >> j*bitSize) & mask;
			 //System.out.println(j+" val " + Integer.toHexString(a[j]));
		 	 loc = loc ^ a[j]; 	
		 }
		 return loc;
	 }
	 
	 public void put(Integer k, Integer v ) {
		 int loc = hashLocation(k.hashCode());
		 KVPair kv = new KVPair(k,v, map[loc]);
		 map[loc]  = kv;
	 }
	 
	 public Integer get(Integer key) {
		 KVPair kv = map[ hashLocation(key.hashCode()) ];
		 
		 for(KVPair n = kv; n!=null; n = n.next) 
			 if(n.isKey(key)) return n.value;
		 
		 return null;
	 }
}
