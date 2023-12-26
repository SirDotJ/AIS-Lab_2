package org.ministryofhealth.fuzzylogic.attendance;

import org.ministryofhealth.fuzzylogic.Term;

import java.util.List;

public abstract class Attendance extends Term {
	protected Attendance(List<Double[]> points) {
		super(points);
	}
}
