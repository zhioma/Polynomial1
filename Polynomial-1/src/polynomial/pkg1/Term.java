/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial.pkg1;

import javax.xml.soap.Node;

/**
 *
 * @author kare
 */
public class Term {

    public int coefficient;
    public int exponent;
    public Node next;

    public Term() {
        coefficient = 0;
        exponent = 0;
        next = null;
    }

    public Term(int coefficient, int exponent, Node next) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int newCoefficient) {
        coefficient = newCoefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int newExponent) {
        exponent = newExponent;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}
