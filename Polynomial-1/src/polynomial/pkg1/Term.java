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
    public double coefficient;
    public int exponent;
    public Node next;
    
    public Term(){
        coefficient = 0;
        exponent = 0;
        next = null;
    }
    public Term(double coefficient, int exponent, Node next){
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next =  next;
    }
    
}
