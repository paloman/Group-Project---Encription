import java.util.*;
import java.math.*;
public class RSA {
	BigInteger p, y, e, eg, n, emes, d, k;
	BigInteger one, p, q, E, D, n,P,Q;
	private BigInteger message;
	
	public RSA(){
		
	}
	
	public  RSA(BigInteger mes, BigInteger str){
		message = mes;
		PNG x = new PNG();
		x.generate(str);
		p = x.getP();
		y = x.getY();
		n = p*y;
		eg = (p-1)*(y-1);
		generateE();
		//generateD();
	}
	
	public void generateKeys(long str){
		PNG x = new PNG();
		x.generate(str);
		p = x.getP();
		y = x.getY();
		n = p*y;
		eg = (p-1)*(y-1);
		generateE();
		//generateD();
	}
	
	public static long greatestCommon(long eg2, long b)
    {
        while (eg2 != 0 && b != 0)
        {
            if (eg2 >= b)
            {
                eg2 = eg2 - b;
            }
            else
                b = b - eg2;
        }
        if (eg2 == 0) return b;
        else return eg2;
    }
	
	public void generateE(){
		int i = 6;
		boolean bob = true;
		while(bob){
		i++;
		if(1== greatestCommon(eg,i)) bob = false;
		
		}
		e = i;
		d = i;
	}
	
	public void generateD(){
		D=new BigInteger(String.valueOf(i));
	if(((D.multiply(E)).mod(P.multiply(Q))).equals(BigInteger.ONE))
		break;
		}
	}
	
	public void setKey(long a, long b){
		p = a;
		y = b;
		n = p*y;
		eg = (p-1)*(y-1);
		generateE();
	}
	
	public void setMessage(int mes){
		message = mes;
	}
	
	public void getE(){
		System.out.println(e);
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
	
	public BigInteger encode(){
		emes =  (Math.pow(message, e)%(n));
		
		return emes;
		
	}
	
	public BigInteger decode(){
		message = (Math.pow(emes, d)%(n));
		
		return message;
	}
	
	public static void main(String args[]){
		RSA enc = new RSA();
		enc.setKey(3, 13);
		enc.setMessage(32);
		enc.generateE();
		//enc.getE();
		//enc.getD();
		System.out.println(enc.encode());
		System.out.println(enc.decode());
		//RSA b = new RSA(1351246, 500);
		//enc.getE();
		//enc.getD();
		//System.out.println(b.encode());
		//System.out.println(b.decode());
		
	}
}
