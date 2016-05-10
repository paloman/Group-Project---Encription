
public class RSA {
	private long p, y, e, eg, n, emes, d, k;
	private int message;
	
	public RSA(){
		
	}
	
	public  RSA(int mes, long str){
		message = mes;
		PNG x = new PNG();
		x.generate(str);
		p = x.getP();
		y = x.getY();
		n = p*y;
		eg = (p-1)*(y-1);
		k = 1%eg;
	}
	
	public void generateKeys(long str){
		PNG x = new PNG();
		x.generate(str);
		p = x.getP();
		y = x.getY();
		n = p*y;
		eg = (p-1)*(y-1);
		k = 1%eg;
	}
	
	public void generateE(){
		MillerRabin test = new MillerRabin();
		int x = (int) Math.sqrt(k);
		for(int i =3; i <x ; i++){
			for(int a =i; a<x;a++){
				if(i*a==k&&test.isPrime(i, 1)&&test.isPrime(a, 1)){
					e = i;
					d = a;
				}
			}
		}
	}
	
	public void setKey(long a, long b){
		p = a;
		y = b;
		n = p*y;
		eg = (p-1)*(y-1);
		k = 1%eg;
	}
	
	public void setMessage(int mes){
		message = mes;
	}
	
	public void getE(){
		System.out.println(e);
		System.out.println(n);
	}
	public void getP(){
		System.out.println(p);
	}
	public void getY(){
		System.out.println(y);
	}
	public void getD(){
		System.out.println(d);
	}
	
	public long encode(){
		emes = (long) (Math.pow(message, e)%(n));
		
		return emes;
		
	}
	
	public long decode(){
		message = (int) (Math.pow(emes, d)%(n));
		
		return message;
	}
	
	public static void main(String args[]){
		RSA enc = new RSA();
		enc.setKey(3, 13);
		enc.setMessage(15);
		enc.generateE();
		enc.getE();
		enc.getY();
		enc.getP();
		enc.getD();
	}
}
