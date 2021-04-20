package to_do.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
    	//TO-DO: Add 'try-catch' block to catch the IO error
    	try {
    	//TO-DO: Ask for card number, expiration date, CVV code then save them to suitable variables
        System.out.println("Enter card number: ");
        String number = READER.readLine();
        System.out.println("Enter expiration date: ");
        String date = READER.readLine();
        System.out.println("Enter CVV code: ");
        String cvv = READER.readLine();
    	//TO-DO: Create new CreditCard instance with given information
        CreditCard creditCard = new CreditCard(number, date, cvv);
        //TO-DO: Validate credit card number...
        
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    //TO-DO: Implement the pay() method
    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if 'cardIsPresent' => display a message 
    	to show that customer is paying with Credit Card with money amount
    	then reduce the card amount with that number
    	finally return true else return false */
        if(cardIsPresent()) {
        	System.out.println("Paying with Credit Card with: " + paymentAmount + " units");
        	return true;
        } else {
        	return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
