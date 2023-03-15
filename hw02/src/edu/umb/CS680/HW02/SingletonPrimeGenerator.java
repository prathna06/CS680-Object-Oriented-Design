package edu.umb.CS680.HW02;
import java.util.Iterator;
import java.util.LinkedList;


public class SingletonPrimeGenerator {
	protected static long from, to;
	protected  LinkedList<Long> primes = new LinkedList<Long>();
	private static SingletonPrimeGenerator singleInstance = null;
	public static synchronized SingletonPrimeGenerator getInstance(long _from,long _to){
		if(singleInstance == null){
			singleInstance = new SingletonPrimeGenerator();
		}
		if(_from >= 1 && _to > _from){
			from = _from;
			to = _to;
		}else{
			throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
		}
		return singleInstance;
	}
	
	
	public LinkedList<Long> getPrimes(){ return primes; };
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}
	
	protected boolean isPrime(long n){
		// 1 or lower numbers are not prime. 
		if(n <= 1){ return false; }
		// Even numbers are not prime, except for 2.  
		if( n > 2 && isEven(n) ){ return false; }
		long i;
		// Find a number "i" that can divide "n" 
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
        // If such a number "i" is found, n is not prime. Otherwise, n is prime. 
        if (i == 1){ return true; }
        else{ return false; }
	}

	public void generatePrimes(){
		for (long n = from; n <= to; n++) {
			if( isPrime(n) ){ primes.add(n); }
        }
	}

	
	public static void main(String[] args) {
		SingletonPrimeGenerator gen = new SingletonPrimeGenerator();
		gen.generatePrimes();
		LinkedList<Long> primes = gen.getPrimes();
		Iterator<Long> it = primes.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("\n" + gen.getPrimes().size() + " primes are found.");								
	}
}

