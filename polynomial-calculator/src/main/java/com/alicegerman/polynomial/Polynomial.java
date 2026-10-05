package com.alicegerman.polynomial;

import java.util.ArrayList;

public class Polynomial {

	private ArrayList<Term> terms;

	private class Term {
		double number;
		int power;

		Term(double number, int power) {
			this.number = number;
			this.power = power;
		}
	}

	public Polynomial(double[] numbers, int[] powers) throws Exception {
		if (numbers.length != powers.length)
			throw new Exception("Arrays must be same length");

		terms = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			Term newTerm = new Term(numbers[i], powers[i]);

			int j = 0;

			while (j < terms.size() && terms.get(j).power > newTerm.power) {
				j++;
			}
			terms.add(j, newTerm);
		}

	}

	public Polynomial() {
		terms = new ArrayList<>();
	}

	public Polynomial plus(Polynomial other) {
		Polynomial result = new Polynomial();

		int i = 0;
		int j = 0;

		while (i < this.terms.size() && j < other.terms.size()) {
			Term t1 = this.terms.get(i);
			Term t2 = other.terms.get(j);

			if (t1.power == t2.power) {
				double sum = t1.number + t2.number;
				if (sum != 0) {
					Term resTerm = new Term(sum, t1.power);
					result.terms.add(resTerm);
				}
				i++;
				j++;
			} else if (t1.power > t2.power) {

				Term resTerm = new Term(t1.number, t1.power);
				i++;
				result.terms.add(resTerm);
			} else {

				Term resTerm = new Term(t2.number, t2.power);
				j++;
				result.terms.add(resTerm);
			}
		}

		while (i < this.terms.size()) {
			// copy remaining terms from this
			Term t1 = this.terms.get(i);
			Term resTerm = new Term(t1.number, t1.power);
			i++;
			result.terms.add(resTerm);
		}

		while (j < other.terms.size()) {
			// copy remaining terms from other
			Term t2 = other.terms.get(j);
			Term resTerm = new Term(t2.number, t2.power);
			j++;
			result.terms.add(resTerm);
		}

		return result;
	}

	
	public Polynomial minus(Polynomial other) {

	    Polynomial result = new Polynomial();

	    int i = 0;
	    int j = 0;

	    while (i < terms.size() && j < other.terms.size()) {

	        Term t1 = terms.get(i);
	        Term t2 = other.terms.get(j);

	        if (t1.power == t2.power) {

	            double diff = t1.number - t2.number;

	            if (diff != 0) {
	                result.terms.add(new Term(diff, t1.power));
	            }

	            i++;
	            j++;

	        } else if (t1.power > t2.power) {

	            result.terms.add(new Term(t1.number, t1.power));
	            i++;

	        } else {

	            result.terms.add(new Term(-t2.number, t2.power));
	            j++;
	        }
	    }

	    while (i < terms.size()) {
	        Term t1 = terms.get(i);
	        result.terms.add(new Term(t1.number, t1.power));
	        i++;
	    }

	    while (j < other.terms.size()) {
	        Term t2 = other.terms.get(j);
	        result.terms.add(new Term(-t2.number, t2.power));
	        j++;
	    }

	    return result;
	}
	
	
	public Polynomial derivative() {

	    Polynomial result = new Polynomial();

	    for (int i = 0; i < terms.size(); i++){
	    	Term t1 = terms.get(i);
	    	if (t1.power != 0) {
	    		result.terms.add(new Term(t1.power * t1.number, t1.power -1));
	    	}

	    }
	    return result;
	}
	
	@Override
	public String toString() {

	    String result = "";

	    for (int i = 0; i < terms.size(); i++) {

	        Term t = terms.get(i);
	        double numb = t.number;
	        int pow = t.power;

	        // handle sign
	        if (numb >= 0 && i > 0)
	            result += "+";

	        // handle coefficient
	        if (pow == 0)
	            result += numb;
	        else {
	            if (numb == -1)
	                result += "-";
	            else if (numb != 1)
	                result += numb;

	            result += "x";

	            if (pow != 1)
	                result += "^" + pow;
	        }
	    }

	    return result;
	}
	
	@Override
	public boolean equals(Object obj) {

	    if (obj == null)
	        return false;

	    if (!(obj instanceof Polynomial))
	        return false;

	    Polynomial other = (Polynomial) obj;

	    if (this.terms.size() != other.terms.size())
	        return false;

	    for (int i = 0; i < terms.size(); i++) {

	        Term t1 = this.terms.get(i);
	        Term t2 = other.terms.get(i);

	        if (t1.power != t2.power || t1.number != t2.number)
	            return false;
	    }

	    return true;
	}

}
