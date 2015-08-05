import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {

	public static String swapOperators(String string) {
		// TODO Auto-generated method stub
		
		
//		String test = "foo.equals(\"bar\")";
//		String test2 = "edEligibilityCargo.getActivityType().equals(\"PR\")";
//		
//		string = test2;
		
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
		
		String result = String.format("\"%s\".equals(%s)", literalInsideDoubleQuotes, objectexpression);
			

			
			
			return result;
	}
	
	public static String extractEqualsMethod(String str)
	{
		/*
		 * the literal RE (as a non java string)
		 * 
		 * ([^\s\(!]*?equals.*\(".*?")
		 * 
		 */
		
//		String equalsRE = "(if ?\\(.*?equals.*\\(\".*?\")";
		String equalsRE = "([^\\s\\(!]*?equals.*\\(\".*?\")";
		
		Pattern pattern = Pattern.compile(equalsRE);
    	Matcher matcher = pattern.matcher(str);
    	String result = "fail";
    	while (matcher.find())
    	{
    		System.out.println("FOUND: " + matcher.group(1));
    		result = matcher.group(1);
    	}
		
		return result;

		
	}
	

}
