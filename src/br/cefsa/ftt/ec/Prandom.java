package br.cefsa.ftt.ec;

public class Prandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PRandomNumber rn = new PRandomNumber();
		
		for (int a = 0; a < 1000; a++) {
			System.out.println(a + " : " + rn.getMiddleSquareWeyl());		
		} //for
		
	} //main

} //Prandom

class PRandomNumber {
	
	private final int BITS = 64;
	
	private long x = 0, 
			     w = 0, 
			     s = 0xb5ad4eceda1ce2a9L; //Default Sead
	
	public void setNewSead(long s) {
		this.s = s;
	}
	
	public long getMiddleSquareWeyl() {
		
		//Reference:  https://en.wikipedia.org/wiki/Middle-square_method
		
		x *= x; 
		x += (w += s); 
		x = (x >> BITS) | (x << BITS); //Binary operation: shift and or
		
		return x;
		
	} //getMiddleSquareWeyl
	
} //PRandomNumber