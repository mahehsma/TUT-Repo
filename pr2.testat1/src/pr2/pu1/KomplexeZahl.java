package pr2.pu1;

public class KomplexeZahl {
	/** @param re 	real part of complex number
	 *  @param im 	imaginary part of complex number
	 */
	protected double re; 
	private double im; 

	public KomplexeZahl(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public static void main(String[] args) {
		var x = new KomplexeZahl(2.5, 4.5);
		System.out.println("x = " + x);
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	@Override
	public String toString() {
		return String.format("%.1f + %.1f*i", re, im);
	}
	
	// method for adding two complex numbers
	public KomplexeZahl add(KomplexeZahl k) {
		return new KomplexeZahl(k.re + re, k.im + im);
	}
	// method for multiplying two complex numbers
	public KomplexeZahl prod(KomplexeZahl k) {
		return new KomplexeZahl(k.re * re - k.im * im, k.re * im + k.im * re);
	}
	
	// static method for adding two complex numbers
	public static KomplexeZahl add(KomplexeZahl k1, KomplexeZahl k2) {
		return new KomplexeZahl(k1.re + k2.re, k1.im + k2.im);
	}
	
	// static method for multiplying two complex numbers
	public static KomplexeZahl prod(KomplexeZahl k1, KomplexeZahl k2) {
		return new KomplexeZahl(k1.re * k2.re - k1.im * k2.im, k1.re * k2.im + k1.im * k2.re);
	}
}
