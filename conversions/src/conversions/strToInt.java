package conversions;

import java.math.BigDecimal;
import java.util.Scanner;

public class strToInt {

	public static void main(String[] args) 
	{
		//Ask for string as input
		String target = stringRequest();
		System.out.println("The String you want to convert is: " + target);
		
		//Parse given string to Big Decimal Array
		BigDecimal[] subtractTargetArray = parseStrToBigDecimal(target);
		
		//Take given BigDec array and subtract first value from second value
		BigDecimal finalVal = SubFromTwoLengthArray(subtractTargetArray);
		
		//Print resulting value
		System.out.println("The Subtracted value of the string is: $" + finalVal );

	}
	
	//Request input from user in console to allow different inputs.  
	public static String stringRequest()
	{
		System.out.println("Please enter 2 values in the format (number; number) ");
		System.out.println("    or click enter for original (345.67; 1,325.12) string as input");
		
		String target = "";
		Scanner input = new Scanner(System.in);
		target = input.nextLine();
		input.close();
		
		if(target.equals(""))
		{
			target = "(345.67; 1,325.12)";
			return target;
		}
		else
		{
			return target;
		}		
	}
	
	//Must ignore ( ; , ) within string.
	//Takes a String and converts values into Big decimal array of size 2.  
	//This can also accommodate for negative values given.
	public static BigDecimal[] parseStrToBigDecimal(String target)
	{
		String delims = " ";
		String[] tokens = target.
				replaceAll("\\(" , "").
				replaceAll("\\)" , "").
				replaceAll("\\;" , "").
				replaceAll("\\," , "").
				split(delims);
		
		BigDecimal[] result = new BigDecimal[tokens.length];
		for(int i = 0; i < tokens.length; i++)
		{
			result[i] = new BigDecimal(tokens[i]);
		}
		System.out.println("The First Value: $" + result[0]);
		System.out.println("The Second Value: $" + result[1]);
		return result;
	}
	
	//Subtracts position zero from position one
	public static BigDecimal SubFromTwoLengthArray(BigDecimal[] a)
	{
		if(a.length != 2)
		{
			System.out.println("Too many values in Array");
			return (BigDecimal) null;
		}
		else
		{
			return a[1].subtract(a[0]);
		}
	}

}
