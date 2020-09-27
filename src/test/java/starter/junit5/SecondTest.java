/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package starter.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("fast")
class SecondTest {

	@Test
	@DisplayName("My 2nd JUnit 5 test! 😎")
	void mySecondTest(TestInfo testInfo) {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
		assertEquals("My 2nd JUnit 5 test! 😎", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
	}

}
