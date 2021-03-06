/*
 *@(#)Fibonacci.java 2018.01.10
 *
 * Copyright 2018 NHN Corp. All rights Reserved.
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.naver.dynamicprogramming.fibonacci;

/**
 *
 *
 * @author kim.minjoo
 */
public class Fibonacci {
	public static int calculate(int n) {
		int[] memo = new int[n];
		for (int i = 0; i < n; i++) {
			memo[i] = -1;
		}
		return calculate(n, memo);
	}

	private static int calculate(int n, int[] memo) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be greater than 0");
		}

		if (n <= 1) {
			return n;
		}

		int prev = memo[n - 1];
		if (prev == -1) {
			prev = calculate(n - 1, memo);
			memo[n - 1] = prev;
		}

		int beforePrev = memo[n - 2];
		if (beforePrev == -1) {
			beforePrev = calculate(n - 1, memo);
			memo[n - 2] = beforePrev;
		}

		return prev + beforePrev;
	}
}