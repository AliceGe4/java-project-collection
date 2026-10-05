package com.alicegerman.bullseye;

import java.util.Random;
public class BullseyeGame {

	 private String secretNumber;

	    public BullseyeGame() {
	        startNewGame();
	    }

	    public void startNewGame() {
	        secretNumber = generateSecretNumber();
	    }

	    public String getSecretNumber() {
	        return secretNumber;
	    }

	    public String validateGuess(String guess) {

	        if (guess == null || guess.length() != 4) {
	            return "Invalid input: You must enter exactly 4 digits.";
	        }


	        if (guess.charAt(0) == '0') {
	            return "Invalid input: The first digit cannot be 0.";
	        }

	        for (int i = 0; i < guess.length(); i++) {
	            for (int j = i + 1; j < guess.length(); j++) {
	                if (guess.charAt(i) == guess.charAt(j)) {
	                    return "Invalid input: Digits must be different.";
	                }
	            }
	        }
	        for (int i = 0; i < guess.length(); i++) {
	            char c = guess.charAt(i);

	            if (c < '0' || c > '9') {
	                return "Invalid input: Only digits are allowed.";
	            }
	        }

	        return null; // means valid
	    }
	    
	    
	    
		public int countBulls(String guess) {
			// same digit, same position
			int count = 0;
			String temp = getSecretNumber();
			for (int i = 0; i < temp.length(); i++) {
				if (guess.charAt(i) == temp.charAt(i)) {
					count++;
				}
			}
			return count;
		}

	    public int countHits(String guess) {
	        // same digit, wrong position
	    	
	    	int count = 0;
	    	String temp = getSecretNumber();
	    	  for (int i = 0; i < guess.length(); i++) {
		         for (int j = 0; j < guess.length(); j++)   
		         {
		        	 if (guess.charAt(i) == temp.charAt(j) && i != j) {
		                    count++;             
		         }       
		            }
		        }
	    	  return count;
	    }

	    private String generateSecretNumber() {
	        // random valid 4-digit number
	    	Random rand = new Random();
	    	int FirstNum = rand.nextInt(9)+1;
	    	int SecondNum;
	    	int ThirdNum;
	    	int FourthNum;
	    	
	    		// generate second digit
	        	int tempNum = rand.nextInt(10);
	    		while ( FirstNum == tempNum)
	    		{
	    			tempNum = rand.nextInt(10);
	    		}
	    		SecondNum = tempNum;
	    		
	    		// generate third digit
	    		tempNum = rand.nextInt(10);
	    		while ( FirstNum == tempNum || SecondNum == tempNum )
	    		{
	    			tempNum = rand.nextInt(10);
	    		}
	    		ThirdNum = tempNum;	
	    		
	    		//generate fourth digit
	    		tempNum = rand.nextInt(10);
	    		while ( FirstNum == tempNum || SecondNum == tempNum || ThirdNum == tempNum )
	    		{
	    			tempNum = rand.nextInt(10);
	    		}
	    		FourthNum = tempNum;
	    		
	    	String desiredNum = "" + FirstNum + SecondNum + ThirdNum + FourthNum;
	    	return desiredNum;
	    	}
	    	
	    	
	    }
