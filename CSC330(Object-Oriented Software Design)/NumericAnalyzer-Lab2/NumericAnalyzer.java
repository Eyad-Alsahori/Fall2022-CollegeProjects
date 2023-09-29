package edu.cuny.csi.csc330.lab2;

import java.lang.Math;
import java.util.Arrays;

public class NumericAnalyzer {	
	private int [] num;
	private final String PRING_FORMAT = "%-20s %-,20d\n";
	public NumericAnalyzer(int[] num) {
		this.num = num;
	}
	
	public static boolean isNumeric(String args) {
		//check if the arguments are numerical values
	    if (args == null) {
	        return false;
	    }
	    try {
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public void sortedNumbers() {
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++)
		{
			System.out.print(num[i] + " ");
		}
		System.out.println("");
	}
	
	
	public int count() {
		 return num.length;
	}
	
	//Under here we will calculate min,max,range,sum,mean,median,variance,standard deviation
	public int MinValue(int[] numArray) {
           return numArray[0];
       }
       

	  public int MaxValue(int[] numArray) {
	        return numArray[numArray.length - 1];
	    }

	  
	  public int RangeValue(int[] numArray) {
          int max, min;
          max = MaxValue(numArray);
          min = MinValue(numArray);
          return max - min;
      }

	 public int SumValue(int[] numArray) {
        int sum = 0;
        for (int number : numArray) {
            sum += number;
        }
        return sum;
    }

	  public int MeanValue(int[] numArray) {
	        int sum = 0, mean;
	        sum = SumValue(numArray);
	        mean = sum / numArray.length;
	        return mean;
	    }

	  public int MedianValue(int[] numArray) {
	        int median;
	        if (numArray.length % 2 == 0) {
	            median = (numArray[numArray.length / 2] + numArray[numArray.length / 2 - 1]) / 2;
	        } else {
	            median = numArray[numArray.length / 2];
	        }
	        return median;
	    }

	
	  public int VarianceValue(int[] numArray) {
		  int variance = 0;
	        int mean = MeanValue(numArray);
	        for (int number : numArray) {
	            variance += Math.pow(number - mean, 2);
	        }
	        variance = variance / numArray.length;
	        return variance;
	    }

	
	  public int DeviationValue(int[] numArray) {
		  int variance = (int) VarianceValue(numArray);
		  int stdDev = (int) Math.sqrt(variance);
	        return stdDev;

	    }

	
		//displaying the output
	public void display() {
		System.out.println("");
			System.out.printf(PRING_FORMAT, "Count:", count());
		System.out.printf(PRING_FORMAT, "Min: ", MinValue(num) );
		System.out.printf(PRING_FORMAT, "Max:", MaxValue(num));
		System.out.printf(PRING_FORMAT, "Range:", RangeValue(num));
		System.out.printf(PRING_FORMAT, "Sum:", SumValue(num));
		System.out.printf(PRING_FORMAT, "Mean:", MeanValue(num));
		System.out.printf(PRING_FORMAT, "Median:", MedianValue(num));
		System.out.printf("%-20s %-,20d\n", "Variance:", VarianceValue(num));
		System.out.printf("%-20s %-,20d\n", "Standard Deviation:", DeviationValue(num));

	}


	public static void main(String[] args) {
		if(args.length == 0 ) {
			System.err.println("system err- there needs to be a positive integer - exiting early."  ); 
		System.exit(1); 
		}
		
	
		// create an int array 
		int [] numbers = new int[args.length]; 
		
		for(int i = 0 ; i < args.length ; ++i ) {
		
		  // The exrta credit
		  if(!NumericAnalyzer.isNumeric(args[i])) {
			System.err.println("non-numeric parameters- invalid data - exiting early" + args[i]);
			System.exit(2); // will exit code for the  unvalid data 
		  }
		  numbers[i] = Integer.parseInt(args[i]); 
		}

		
		NumericAnalyzer analyzer = new NumericAnalyzer(numbers);
		analyzer.sortedNumbers(); 
		analyzer.display(); 
		System.exit(0);
	}
}


