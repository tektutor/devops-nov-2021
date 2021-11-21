package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase {

	@Test
	public void testCase() {
		Main fe = new Main();

		String actualResponse = fe.getModuleName();
		String expectedResponse = "Main Module";

		assertEquals ( expectedResponse, actualResponse );
	}

}
