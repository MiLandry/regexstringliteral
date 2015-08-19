package testClasses;
import static org.junit.Assert.*;
import hamsterofdark.stringLiteral.StringUtil;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SwapTest {

	private String input;
	private String expected;
	
	
	public SwapTest(String input, String expected) {
		super();
		this.input = input;
		this.expected = expected;
	}
	
	//Input specimens MUST be well formed object expressions and literals
	@Parameters(name = "{index}: input :{0} output: {1}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
			{ "edEligibilityCargo.getActivityType().equals(\"PR\")", "\"PR\".equals(edEligibilityCargo.getActivityType())" }, 
			{ "foo.equals(\"bar\")", "\"bar\".equals(foo)",}, 
			{ 	"reasonCd.equalsIgnoreCase(\"FP\")", "\"FP\".equalsIgnoreCase(reasonCd)"}, 
			{"(String) foo.equals(\"bar\")", "\"bar\".equals((String) foo)",},
		});
	}



	@Test
	public void test() {
		assertEquals(expected, StringUtil.swapOperators(input));
	}

}
