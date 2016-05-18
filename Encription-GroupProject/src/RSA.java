import java.util.*;
import java.math.*;
public class RSA {
	BigInteger p, y, e, eg, n, emes, d, k, x;
	BigInteger one, q, E, D,P,Q;
	private BigInteger message;

	public RSA(){

	}

	public  RSA(BigInteger mes, BigInteger str){
		message = mes;
		PNG x = new PNG();
		x.generate(str);
		p = x.getP();
		y = x.getY();
		n = p.multiply(y);
		eg = (p.subtract(BigInteger.ONE)).multiply(y.subtract(BigInteger.ONE));
		generateE();
		//generateD();
	}

	public void generateKeys(BigInteger str){
		PNG x = new PNG();
		x.generate(str);
		p = x.getP();
		y = x.getY();
		n = p.multiply(y);
		eg = (p.subtract(BigInteger.ONE)).multiply(y.subtract(BigInteger.ONE));
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
		BigInteger i =  BigInteger.valueOf(6);
		boolean bob = true;
		while(bob){
		if(((p.gcd(i)).equals(BigInteger.ONE))&&((y.gcd(i)).equals(BigInteger.ONE))){ bob = false;}
		i.add(BigInteger.ONE);
		}
		e = i;

	}

	public void generateD(){
		BigInteger i = BigInteger.valueOf(5);
		boolean phil = true;
		while(phil)
		{
		D=new BigInteger(String.valueOf(i));
		if(((D.multiply(i)).mod(p.multiply(y))).equals(BigInteger.ONE))
		{phil = false;
			break;}
		i.add(BigInteger.ONE);
		}
	}

	public void setKey(long a, long b){
		p =  BigInteger.valueOf(a);
		y = BigInteger.valueOf(b);
		n = p.multiply(y);
		eg = p.subtract(BigInteger.ONE).multiply(y.subtract(BigInteger.ONE));
		generateE();
		generateD();
	}

	public void setMessage(long mes){
		message = BigInteger.valueOf(mes);
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
		emes=((message.modPow(e,n)));

		return emes;

	}

	public BigInteger decode(){
		message =(emes.modPow(emes,n));

		return message;
	}

	public static void main(String args[]){
		RSA enc = new RSA();
		enc.setKey(3, 13);
		enc.setMessage(12);
		//enc.generateE();
		enc.getE();
		enc.getD();
		System.out.println(enc.encode());
		System.out.println(enc.decode());
		//RSA b = new RSA(1351246, 500);
		//enc.getE();
		//enc.getD();
		//System.out.println(b.encode());
		//System.out.println(b.decode());

	}
}
