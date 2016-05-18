import java.math.BigInteger;
import java.util.Scanner;


public class PNG {
	private BigInteger p, y;
	public PNG(){
		p.equals(0);
		y.equals(0);
	}
	
	public void generate(BigInteger num){
		int it = 10; 
		int k = 2;
		BigInteger a = BigInteger(1);
		long ab = num.longValue();
		MillerRabin mr = new MillerRabin();
		
		 boolean prime = mr.isPrime(num.longValue(), k);
	        while(prime != true){
        	num.add(1);
        	prime = mr.isPrime( num.longValue(), k);
        }
	        if (prime)
	         p = num;
	    num = num.multiply(10000);
	    prime = mr.isPrime(num, k);
	    while(prime != true){
       	num++;
       	prime = mr.isPrime(num, k);
       }
	        if (prime)
	         y = num;
	}
	
	public BigInteger getP(){
		return p;
	}
	
	public BigInteger getY(){
		return y;
	}
	
	//public static void main(String args[]){
		 /*Scanner scan = new Scanner(System.in);
	        MillerRabin mr = new MillerRabin();
	        /** Accept number **/
	     /*   System.out.println("Enter number\n");
	        long num = scan.nextLong();
	        /** Accept number of iterations **/
	      /*  System.out.println("\nEnter number of iterations");
	        int k = scan.nextInt();
	        /** check if prime **/
	     /*   boolean prime = mr.isPrime(num, k);
	        while(prime != true){
            	num++;
            	prime = mr.isPrime(num, k);
            }
	        if (prime)
	            System.out.println("\n"+ num );*/
	            
	//}
}
