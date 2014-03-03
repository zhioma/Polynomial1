/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.xml.soap.Node;

/**
 *
 * @author kare
 */
public class Polynomial1 {

    private Term head;

    public void runProgram() throws FileNotFoundException, Exception {
        head = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, please select an option from the menu");

        menu(input);
    }
//***********************END OF RUNPROGRAM*************************************

    public static void main(String[] args) throws FileNotFoundException,
            Exception {
        Polynomial1 myProgram = new Polynomial1();
        myProgram.runProgram();
    }
//***********************END OF MAIN*******************************************

    // Prompts the user to select an option from the menu and performs the 
    // operation that is selected
    public void menu(Scanner input) throws Exception {
        boolean done = false;
        while (!done) {
            System.out.println("1) Add Polynomial");
            System.out.println("2) Evaluate Polynomial");
            System.out.println("3) Save");
            System.out.println("4) Exit");

            String answer = input.nextLine();
            if (answer.equals("1")) {
                System.out.println("option1");
                messagePolynomial(input);
            } else if (answer.equals("2")) {
                System.out.println("option2");
                messagePolynomial(input);
            } else if (answer.equals("3")) {
                System.out.println("option3");
                //saveInformation();
            } else if (answer.equals("4")) {
                done = true;
            } else { // If the user enters an answer that is not on the
                // menu, it would ask the user to enter an answer again
                System.out.println("Please choose an option(1, 2, 3, 4");
            }
        }
    }
//***********************END OF MENU*******************************************

    public void addPolynomial(Scanner input) throws FileNotFoundException {
        messagePolynomial(input);
        //hacerdo de la otra clase?
    }
//***********************END OF ADDPOLYNOMIAL**********************************

    // Asks the user if the would like to perform the operation by using a new
    // polynomial or using one that already exist, then it prompts the user 
    // to enter a value for x and performs the operation of evaluating the 
    // polynomial at the x value
    public void evaluatePolynomial(Scanner input) throws FileNotFoundException {
        boolean isNumber = false;
        Double valueX = 0.0;
        messagePolynomial(input);
        while (!isNumber) {
            System.out.println("Please enter the value of X");
            String valueXString = input.nextLine();
            try {
                valueX = Double.parseDouble(valueXString);
                isNumber = true;
            } catch (Exception e) {
                System.out.println("The X value must only be numbers");
            }
        }
        // agarrar el polynomial y evaluarlo al valor de x
    }
//***********************END OF EVALUATEPOLYNOMIAL*****************************

    // Asks the user if they would like to create a new polynomial or use an 
    // existing one
    public void messagePolynomial(Scanner input) throws FileNotFoundException {
        boolean pick = false;
        System.out.println("Would you like to enter a new polynomial or use "
                + "an existing one?");
        while (!pick) {
            System.out.println("1) Create");
            System.out.println("2) Use existing one");

            String answer = input.nextLine();
            if (answer.equals("1")) {
                createPolynomial(input);
                pick = true;
            } else if (answer.equals("2")) {
                openExistingPolynomial(input);
                pick = true;
            } else {
                System.out.println("Please select an option( 1 or 2");
            }
        }
    }
//***********************END OF MESSAGEADDPOLYNOMIAL***************************

    // Aks the user to input a name of the file where the polynomial will be
    // saved, and then takes the input from the user and creates a linked list
    // using the information
    public void createPolynomial(Scanner input) throws FileNotFoundException {
        boolean check = false;
        while (!check) {
            System.out.println("Enter the name of the file where the "
                    + "polynomial will be saved");
            String name = input.nextLine();
            PrintWriter file = new PrintWriter(name + ".txt");
            check = true;
        }
        // preguntar al user a meter infomation and put it into alinked list
    }
//***********************END OF CREATEPOLYNOMIAL*******************************

    public int readCoefficient(Scanner input) {
        int coefficient = 0;

        System.out.println("Enter the coefficient");
        coefficient = input.nextInt();
        return coefficient;
    }
//***********************END OF READCOEFFICIENT********************************

    public int readExponent(Scanner input) {
        int exponent = 0;

        System.out.println("Enter the Exponent");
        exponent = input.nextInt();
        return exponent;
    }
//***********************END OF READEXPONENT***********************************

    public void insertNode(int coefficient, int exponent) {
        Term temp = new Term(coefficient, exponent, null);
        if (head == null) {
            head = temp;
        } else {
            Term a = null;
            Term b = head;

            if (temp.getExponent() > b.getExponent()) {
                temp.setNext((Node) head);
                head = temp;
            } else {
                while (b != null && b.getExponent() > temp.getExponent()) {
                    a = b;
                    b = (Term) b.getNext();
                }
                a.setNext((Node) temp);
                temp.setNext((Node) a);
            }
        }
    }

//***********************END OF INSERTNODE*************************************
    public void printPolynomial() {
        Term a = head;
        while (a != null) {
            if (a.getExponent() != 0) {
                System.out.println(a.getCoefficient() + "x^" + a.getExponent());
                a = (Term) a.getNext();
            } else {
                System.out.println(a.getCoefficient() + "x");
            }
        } 
        System.out.println(" ");
    }
//***********************END OF PRINTPOLYNOMIAL********************************

    // reads the filename from the user and searches for the file, if it is 
    // found it would take the contents of the file and would create a linked 
    // list. If it is not found it wold give a message and ask the user to 
    // enter the name of the file again
    public void openExistingPolynomial(Scanner input) {
        boolean exist = false;
        while (!exist) {
            System.out.println("Name of the file where the polynomial"
                    + " is located");

            String file = input.nextLine();
            File openFile = new File(file + ".txt");
            try {
                input = new Scanner(openFile);
                exist = true;
            } catch (IOException e) {
                System.out.println("Cannot find the File");
            }
        }
        // hacerlo que lea el polynomial que esta aguardado en un file 
        // se haga en un linked list
    }
//***********************END OF openExistingPolynomial*************************
}
