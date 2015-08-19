package testClasses;
import static org.junit.Assert.*;
import hamsterofdark.stringLiteral.StringUtil;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ExtractTest {

	private String input;
	private String expected;
	
	
	public ExtractTest(String input, String expected) {
		super();
		this.input = input;
		this.expected = expected;
	}
	

	@Parameters(name = "{index}: input :{0} Expected: {1}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
			//1
			{ "edEligibilityCargo.getActivityType().equals(\"PR\")", "edEligibilityCargo.getActivityType().equals(\"PR\")" }, 
			//2
			{ "foo.equals(\"bar\")", "foo.equals(\"bar\")",}, 
			//3
			{ 	"reasonCd.equalsIgnoreCase(\"FP\")", "reasonCd.equalsIgnoreCase(\"FP\")"}, 			
			//4
			{" else if (reasonCd.equalsIgnoreCase(\"FP\"))", "reasonCd.equalsIgnoreCase(\"FP\")"},
			{"&& (!(dhsPaysTotalAmt.trim().equalsIgnoreCase(\"$ 0.00\")))", "dhsPaysTotalAmt.trim().equalsIgnoreCase(\"$ 0.00\")"},
			//5
			{"if(apptStatus.equals(\"NT\"))", "apptStatus.equals(\"NT\")"}, 
			//6
			{"if (!serviceCodeDescList.equals(\"GROUP\") && !serviceCodeDescList.equals(\"INDV\")) {",
			"serviceCodeDescList.equals(\"INDV\")"}, 
			//7
			{"((String) foo).equals(\"bar\")", "((String) foo).equals(\"bar\")",},
		});
	}



	@Test
	public void test() {
		assertEquals(expected, StringUtil.extractEqualsMethod(input));
	}

}
