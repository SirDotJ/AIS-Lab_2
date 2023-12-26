package org.ministryofhealth.fuzzylogic.mark;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class OverallMark {
	private static final List<Class<?>> TESTED_MARKS = new ArrayList<>(Arrays.asList(
		MarkF.class, MarkD.class,
		MarkC.class, MarkB.class,
		MarkA.class, MarkS.class
	));
	private final Map<Mark, Double> judgementResults;
	public OverallMark(double examResult) throws IllegalArgumentException, IllegalStateException {
		if (examResult < 0 || examResult > 100)
			throw new IllegalArgumentException("Provided result is out of range!");

		this.judgementResults = new HashMap<>();
		for (Class<?> testedMark : TESTED_MARKS) {
			Mark mark;
			try {
				mark = (Mark) testedMark.getConstructors()[0].newInstance();
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
				System.out.println("ERROR: During judgement exception occurred: " + e);
				throw new IllegalStateException("Current TESTED_MARKS are not valid due to thrown exception: " + e);
			}
			double judgement = mark.judge(examResult);
			this.judgementResults.put(mark, judgement);
		}
	}
	public String getResultTerm() {
		double maxResult = Double.MIN_VALUE;
		Mark mostLikelyMark = null;

		for (Map.Entry<Mark, Double> entry : this.judgementResults.entrySet()) {
			Mark mark = entry.getKey();
			double judgement = entry.getValue();
			if (judgement > maxResult) {
				maxResult = judgement;
				mostLikelyMark = mark;
			}
		}

		if (mostLikelyMark == null)
			throw new IllegalStateException("Unexpected error: no most likely mark was found");

		return mostLikelyMark.meaning();
	}
}
