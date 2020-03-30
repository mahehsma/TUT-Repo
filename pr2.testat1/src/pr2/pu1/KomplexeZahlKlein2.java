package pr2.pu1;

public class KomplexeZahlKlein2 extends KomplexeZahl {
	
	/** 
	 * @param re				real part of complex number
	 * @param im				imaginary part of complex number
	 * @throws KZKException		if imaginary part is bigger then 10
	 */
	public KomplexeZahlKlein2(double re, double im) throws KZKException {
		super(re, im);
		if (im > 10) {
			throw new KZKException();
		}
	}

	public class KZKException extends Exception {

		@Override
		public String getMessage() {
			return "Der imagin‰re Anteil ist zu groﬂ! Reeller Anteil ist " + re;
		}
	}
}
