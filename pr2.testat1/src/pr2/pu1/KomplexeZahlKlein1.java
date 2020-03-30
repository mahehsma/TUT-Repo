package pr2.pu1;

public class KomplexeZahlKlein1 extends KomplexeZahl {
	
	/**
	 * 
	 * @param re	real part of complex number
	 * @param im	imaginary part of complex number
	 * @throws Exception if imaginary part is bigger then 10
	 */
	
	public KomplexeZahlKlein1(double re, double im) throws Exception {
		super(re, im);
		if (im > 10) {
			throw new Exception("Der imagin‰re Anteil ist zu groﬂ! Reeller Anteil ist " + re);
		}
	}
}
