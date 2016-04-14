package com.design.util;

import org.junit.Test;

public class TestTimeUtil {

	@Test
	public void test01() {
		System.out.println(TimeUtil.getDayBefore("2016-02-01").toLocalDate());
		System.out.println(TimeUtil.getDayBefore(null).toLocalDate());
	}
}
