import java.util.Scanner;

public class RSA {

	public static void main(String[] args) throws Exception {
		int n = 0; 
		int e = 0;
		int d = 0;
		int c = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter two distinct prime numbers:");
		int p = reader.nextInt();
		int q = reader.nextInt();
		n = p * q;	    
		e = PublicKey(p,q);
		d = PrivateKey(e,p,q);
		c = Encrypt(n,e);
		System.out.println( "Public Key{e,n}: {"+e+","+n+"}" );
		System.out.println( "Private Key{d,n}: {"+d+","+n+"}" );
		System.out.println("Cipher Text is: "+c);
		reader.close();
	}
	private static int GCD (int a, int b) throws Exception {
		int temp;
		while (b > 0)
		{
			temp = b;
			b = a % b;
			a = temp;
		}   
	    return a;
	}
	private static int PublicKey (int p, int q) throws Exception {
		int e = 2;
		int n = p * q;
		int r = (p - 1) * (q - 1);
		while (GCD(e, r) != 1)
		{
			e += 1;
		}     
		System.out.println("n = "+ n+"\ne = "+ e);
		return e;
	}

	private static int PrivateKey (int e, int p, int q) throws Exception {
		int d = 1;
		int r = (p - 1) * (q - 1);
		int temp = r;
		while (d > 0)
		{
			if (((temp + 1)%e) != 0)
			{
				temp += r;
			}
			else
			{
				d = (temp + 1)/e;
				break;
			}
		}
		return d;
	}
	private static int Encrypt (int n, int e) throws Exception {
		Scanner reader1 = new Scanner(System.in);
		System.out.println("Enter the message to be encrypted: ");
		int m = reader1.nextInt();
		reader1.close();
		return (int) (Math.pow(m, e)%n);
	}
}