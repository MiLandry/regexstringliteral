import static org.junit.Assert.*;

import org.junit.Test;


public class StringUtilTest {
	
	
	static String[] testStringsJustExpressions = {
		
		"edEligibilityCargo.getActivityType().equals(\"PR\")",
		"foo.equals(\"bar\")",
		"reasonCd.equalsIgnoreCase(\"FP\")",
	};
	
	static String[] testStringsJustExpressionsResults = {
		
		"\"PR\".equals(edEligibilityCargo.getActivityType())",
		"\"bar\".equals(foo)",
		"\"FP\".equalsIgnoreCase(reasonCd)",
	};
	
	
	static String[] testStringsSingleExpressionsWithNoise = {
		"} else if (reasonCd.equalsIgnoreCase(\"FP\")) {",
		"reasonCd.equalsIgnoreCase(\"FP\")",
		"&& (!(dhsPaysTotalAmt.trim().equalsIgnoreCase(\"$ 0.00\")))",
		"if(apptStatus.equals(\"NT\"))",
	};
	
	static String[] testStringsExtracted = {
		"reasonCd.equalsIgnoreCase(\"FP\")",
		"reasonCd.equalsIgnoreCase(\"FP\")",
		"dhsPaysTotalAmt.trim().equalsIgnoreCase(\"$ 0.00\")",
		"apptStatus.equals(\"NT\")",
	};
	
	private static String[] testStringsSingleExpressionsFixed = {
	"} else if (\"FP\".equalsIgnoreCase(reasonCd)) {",
	"\"FP\".equalsIgnoreCase(reasonCd)",	
	"&& (!(\"$ 0.00\".equalsIgnoreCase(dhsPaysTotalAmt.trim())))",
	"if(\"NT\".equals(apptStatus))",
	};
	
	static String[] testStringsMultipleExpressionsWithNoise = {
		"        if (!serviceCodeDescList.equals(\"GROUP\") && !serviceCodeDescList.equals(\"INDV\")) {",
	};
	static String[] testStringsMultipleExpressionsWithNoiseFixed = {
		"        if (!\"GROUP\".equals(serviceCodeDescList) && !\"INDV\".equals(serviceCodeDescList)) {",
	};
	
    static String[][] testArrays = 
        {testStringsJustExpressions,
        testStringsSingleExpressionsWithNoise,
        testStringsMultipleExpressionsWithNoise,
        };


    static String[][] extractedAndSwapped = 
        {testStringsJustExpressionsResults,
        testStringsSingleExpressionsFixed ,
        testStringsMultipleExpressionsWithNoiseFixed,
        };



	private boolean debugSwap = false;

	private boolean debugExtract = false;   
    
    
    
    
	@Test
	public void testSwapOperators() {
        //test swapping
        if (debugSwap==true) System.out.println("testing swapper\n\n\n");
        
        
        
        for (int i = 0; i < testStringsJustExpressions.length; i++)
        {
            //do something with array[i]
        	if (debugSwap==true)System.out.println("Input: \n" + testStringsJustExpressions[i]);
        	if (debugSwap==true)System.out.println("Output: \n" + StringUtil.swapOperators(testStringsJustExpressions[i]));
            assertEquals(StringUtil.swapOperators(testStringsJustExpressions[i]), testStringsJustExpressionsResults[i]);
            if (debugSwap==true) System.out.println("*******************************");
        }
	}

	@Test
	public void testExtractEqualsMethod() {

        if (debugExtract ==true) System.out.println("testing extractor\n\n\n");
        
        
        for (int i = 0; i < testStringsSingleExpressionsWithNoise.length; i++)
        {
        	if (debugExtract ==true)System.out.println("Input: \n" + testStringsSingleExpressionsWithNoise[i]); 
        	if (debugExtract ==true)System.out.println("result: \n");
        	if (debugExtract ==true)StringUtil.extractEqualsMethod(testStringsSingleExpressionsWithNoise[i]);
            assertEquals(testStringsExtracted[i], StringUtil.extractEqualsMethod(testStringsSingleExpressionsWithNoise[i]));
            if (debugExtract ==true)System.out.println("****************\n\n");
        }
        
        for (int i = 0; i < testStringsMultipleExpressionsWithNoise.length; i++)
        {
        	if (debugExtract ==true)System.out.println("Input: \n" + testStringsMultipleExpressionsWithNoise[i]); 
        	if (debugExtract ==true)System.out.println("result: \n");
            StringUtil.extractEqualsMethod(testStringsMultipleExpressionsWithNoise[i]);
            if (debugExtract ==true)System.out.println("****************\n\n");
        }
	}

	@Test
	public void testFixCode() {
        System.out.println("testing code fixer\n\n");
        
        
        for (int i = 0; i < testArrays.length; i++)// loop over row
        {
            for (int j = 0; j <  testArrays[i].length; j++)
            {
                //do something with element a[i][j]
                String testString = testArrays[i][j];
                System.out.println("Input: \n" + testString); 
                System.out.println("Output: \n" + StringUtil.fixCode(testString));
                assertEquals(extractedAndSwapped[i][j], StringUtil.fixCode(testString));
                System.out.println("****************\n\n"); 
            }
        }
    }

}
