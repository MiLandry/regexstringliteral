
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] testStringsSwap = {"edEligibilityCargo.getActivityType().equals(\"PR\")",
		                        "foo.equals(\"bar\")",
		                        "reasonCd.equalsIgnoreCase(\"FP\")",
		};
		
		String[] testStringsExtract = {"} else if (reasonCd.equalsIgnoreCase(\"FP\")) {",
				"reasonCd.equalsIgnoreCase(\"FP\"",
				//"        if (!serviceCodeDescList.equals(\"GROUP\") && ansoethisnaoethi",
				"        if (!serviceCodeDescList.equals(\"GROUP\") && !serviceCodeDescList.equals(\"INDV\")) {",
		};
		
		
		//test swapping
	//	System.out.println("testing extractor");
		
//	    for (int i = 0; i < testStrings.length; i++){
//	        //do something with array[i]
//	    	System.out.println(testStrings[i]);
//			System.out.println(StringUtil.swapOperators(testStrings[i]));
//			System.out.println("*******************************");
//	
//
//	              }

		
		//test extractor
		System.out.println("testing extractor");
		for (int i = 0; i < testStringsExtract.length; i++)
		{
			System.out.println(" extracting equals expression out of \n" + testStringsExtract[i]); 
			System.out.println("result:");
			System.out.println(StringUtil.extractEqualsMethod((testStringsExtract[i])));
			System.out.println("****************");
		}

		

	}

}
