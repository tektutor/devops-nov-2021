package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase {

	@Test
	public void testCase() {
		Backend fe = new Backend();

		String actualResponse = fe.getModuleName();
		String expectedResponse = "Backend Module";

		assertEquals ( expectedResponse, actualResponse );
	}

}
