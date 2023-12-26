package org.ministryofhealth.fuzzylogic.mark;

import org.ministryofhealth.fuzzylogic.Term;

import java.util.List;

public abstract class Mark extends Term {
	protected Mark(List<Double[]> points) {
		super(points);
	}
}
