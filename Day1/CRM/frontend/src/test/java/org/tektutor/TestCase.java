package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase {

	@Test
	public void testCase() {
		Frontend fe = new Frontend();

		String actualResponse = fe.getModuleName();
		String expectedResponse = "Frontend Module";

		assertEquals ( expectedResponse, actualResponse );
	}

}
