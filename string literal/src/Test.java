
public class Test {
	static String[] testStringsJustExpressions = {

		"edEligibilityCargo.getActivityType().equals(\"PR\")",
		"foo.equals(\"bar\")",
		"reasonCd.equalsIgnoreCase(\"FP\")",
};
	
	
	static String[] testStringsSingleExpressionsWithNoise = {"} else if (reasonCd.equalsIgnoreCase(\"FP\")) {",
			"reasonCd.equalsIgnoreCase(\"FP\")",
			"&& (!(dhsPaysTotalAmt.trim().equalsIgnoreCase(\"$ 0.00\")))",
	};
	
	static String[] testStringsMultipleExpressionsWithNoise = {
		"        if (!serviceCodeDescList.equals(\"GROUP\") && !serviceCodeDescList.equals(\"INDV\")) {",
};
	
	
	
	
	
	static String[][] testArrays = 
		{testStringsJustExpressions,
		testStringsSingleExpressionsWithNoise,
		testStringsMultipleExpressionsWithNoise,
		};



	static void testSwapper() {

		
			
		//test swapping
		System.out.println("testing swapper\n\n\n");
		
		
		
	    for (int i = 0; i < testStringsJustExpressions.length; i++)
	    {
	        //do something with array[i]
	    	System.out.println("Input: \n" + testStringsJustExpressions[i]);
			System.out.println("Output: \n" + StringUtil.swapOperators(testStringsJustExpressions[i]));
			System.out.println("*******************************");
	    }
    
		
	}

	static void testExtractor() {
		// TODO Auto-generated method stub
		//test extractor
		System.out.println("testing extractor\n\n\n");
		
		for (int i = 0; i < testStringsJustExpressions.length; i++)
		{
			System.out.println("Input: \n" + testStringsJustExpressions[i]); 
			System.out.println("result: \n");
			StringUtil.extractEqualsMethod(testStringsJustExpressions[i]);
			System.out.println("****************\n\n");
		}
		
		for (int i = 0; i < testStringsSingleExpressionsWithNoise.length; i++)
		{
			System.out.println("Input: \n" + testStringsSingleExpressionsWithNoise[i]); 
			System.out.println("result: \n");
			StringUtil.extractEqualsMethod(testStringsSingleExpressionsWithNoise[i]);
			System.out.println("****************\n\n");
		}
		
		for (int i = 0; i < testStringsMultipleExpressionsWithNoise.length; i++)
		{
			System.out.println("Input: \n" + testStringsMultipleExpressionsWithNoise[i]); 
			System.out.println("result: \n");
			StringUtil.extractEqualsMethod(testStringsMultipleExpressionsWithNoise[i]);
			System.out.println("****************\n\n");
		}
		
		
	}
	static void testCodeFixer() {
		System.out.println("testing code fixer\n\n");
		
		
		for (int i = 0; i < testArrays.length; i++)// loop over row
		{
			for (int j = 0; j <  testArrays[i].length; j++)
			{
				//do something with element a[i][j]
				String testString = testArrays[i][j];
				System.out.println("Input: \n" + testString); 
				System.out.println("Output: \n" + StringUtil.fixCode(testString));
				System.out.println("****************\n\n");	
			}
		}

//
//		for (int i = 0; i < testStringsJustExpressions.length; i++)
//		{
//			System.out.println("Input: \n" + testStringsJustExpressions[i]); 
//			System.out.println("result: \n");
//			System.out.println("Output: \n" + StringUtil.fixCode(testStringsJustExpressions[i]));
//			System.out.println("****************\n\n");
//		}
//		
//		for (int i = 0; i < testStringsSingleExpressionsWithNoise.length; i++)
//		{
//			System.out.println("Input: \n" + testStringsSingleExpressionsWithNoise[i]); 
//			System.out.println("result: \n");
//			System.out.println("Output: \n" + StringUtil.fixCode(testStringsSingleExpressionsWithNoise[i]));
//			System.out.println("****************\n\n");
//		}
//		
//		for (int i = 0; i < testStringsMultipleExpressionsWithNoise.length; i++)
//		{
//			System.out.println("Input: \n" + testStringsMultipleExpressionsWithNoise[i]); 
//			System.out.println("result: \n");
//			System.out.println("Output: \n" + StringUtil.fixCode(testStringsMultipleExpressionsWithNoise[i]));
//			System.out.println("****************\n\n");
//		}
		
		
		// TODO Auto-generated method stub
		
	}
}
