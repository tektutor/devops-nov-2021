package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase {

	@Test
	public void testCase() {
		BusinessLayer fe = new BusinessLayer();

		String actualResponse = fe.getModuleName();
		String expectedResponse = "BusinessLayer Module";

		assertEquals ( expectedResponse, actualResponse );
	}

}
