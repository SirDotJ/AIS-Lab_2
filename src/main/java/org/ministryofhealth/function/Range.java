package org.ministryofhealth.function;

public class Range {
	private final double start;
	private final double end;

	public Range(double start, double end) {
		this.start = start;
		this.end = end;
	}

	public boolean check(double value) {
		return value >= this.start && value <= this.end;
	}
}
