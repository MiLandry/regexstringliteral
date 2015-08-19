package hamsterofdark.stringLiteral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;



public class StringUtil {
	/*
	 * the literal RE (as a non java string), you can monkey around with the java string all you want, but do not replace the 
	 * literal RE unless your tests pass
	 * 
	 * 
(\b(?!if\()[^\s\(!][^\s\|\&]*?(equals|equalsIgnoreCase)[.^\s]*?\(".*?"\))

or

(\(String\) )?(\b(?!if\()[^\s\(!][^\s]*?(equals|equalsIgnoreCase)[.^\s]*?\(".*?"\))
	 * 
	 * 
	 */
	final static Logger logger = Logger.getLogger(StringUtil.class);

	static String equalsRE = "(\\b(?!if\\()[^\\s\\(!][^\\s\\|\\&]*?(equals|equalsIgnoreCase)[.^\\s]*?\\(\".*?\"\\))";	
//	static String equalsRE ="(\\(String\\) )?(\\b(?!if\\()[^\\s\\(!][^\\s]*?(equals|equalsIgnoreCase)[.^\\s]*?\\(\".*?\"\\))";
	

	static String equalsIgnoreCaseRE = "([^\\s\\(!][^\\s]*?equalsIgnoreCase.*?\\(\".*?\"\\))";
	

	/**
	 * Returns a string representing the same expression but with the string literal 
	 * on the left side and the object expression on the right
	 * @param string A string representing a string comparison expression where 
	 * the string literal is in the right parens, and object on the left
	 * @return a string with the literal on the left.
	 */
	public static String swapOperators(String string) {	
//		if (!string.matches(equalsRE)) throw new IllegalArgumentException();
		
		String literalInsideDoubleQuotes = "", objectexpression = "";  
		
		// get the literal
		for( int i = 0; i<= string.length()-1; i++)
		{
			String  myChar = Character.toString(string.charAt(i));
			if ("\"".equals(myChar))
			{
				for (int j = 1; true; j++)
				{
					if ("\"".equals(Character.toString(string.charAt(i + j)))) break;
					literalInsideDoubleQuotes += string.charAt(i + j);
				}
				break;
				
			}
			
		}
		
		//get the object expression
		for( int i = 0; i<= string.length()-1; i++)
		{
			
			objectexpression += string.charAt(i);
			
			
			if ("\"".equals(Character.toString(string.charAt(i))))
			{
				int charsToRemove = 1;
				//remove all chars from end of string until we find dot 
				for (int j = i; true; j--)
				{
					if (".".equals(Character.toString(string.charAt(j))))
					{
						break;
					}
					charsToRemove++;
				}
			objectexpression =  objectexpression.substring(0, objectexpression.length() - charsToRemove);	
				break;
				
			}
		}
		
		//first, check for Ignore case,
		if (string.matches(equalsIgnoreCaseRE))
		{
		String result = String.format("\"%s\".equalsIgnoreCase(%s)", literalInsideDoubleQuotes, objectexpression);
			
			return result;			
		}
		
		//otherwise, assume equals		
		String result = String.format("\"%s\".equals(%s)", literalInsideDoubleQuotes, objectexpression);
			
			return result;
	}
	
	public static String extractEqualsMethod(String str)
	{
		
		Pattern pattern = Pattern.compile(equalsRE);
    	Matcher matcher = pattern.matcher(str);
    	String result = "fail";
    	while (matcher.find())
    	{
    		logger.debug("An expression has been found: \n" + matcher.group(1) + "\n");
    		result = matcher.group(1);
    	}
		
		return result;

		
	}
	
	public static String fixCode(String str)
	{
		
		Pattern pattern = Pattern.compile(equalsRE);
    	Matcher matcher = pattern.matcher(str);
    	int counter = 0;
    	while (matcher.find())
    	{
    		String targetExpression = matcher.group(1);
    		logger.debug("An expression has been found: \n" + matcher.group(1) + "\n");
    		
    		String fixedExpression = swapOperators(targetExpression);
    		fixedExpression = fixedExpression.replace("$", "\\$"); //escape $ characters
    		str = matcher.replaceFirst(fixedExpression);
    		matcher = pattern.matcher(str);
    		counter ++;
    	}
    	
    	logger.info("total literals swapped: " + counter);
    	
    	
    	
    	return str;
    	

		
	}

}
