package org.ministryofhealth.fuzzylogic;

import org.ministryofhealth.factory.PointListFactory;
import org.ministryofhealth.function.type.LineCompositeFormula;

import java.util.List;

public abstract class Term {
	protected LineCompositeFormula formula;
	protected Term(List<Double[]> points) {
		this.formula = new LineCompositeFormula(PointListFactory.makeList(points));
	}

	public double judge(double point) {
		return formula.get(point);
	}
	public abstract String meaning();

	public double unification(Term other, double point) {
		return Math.max(this.judge(point), other.judge(point));
	}
	public double interference(Term other, double point) {
		return Math.min(this.judge(point), other.judge(point));
	}
	public double difference(Term other, double point) {
		return Math.max(this.judge(point) - other.judge(point), 0);
	}
	public double negation(double point) {
		return 1 - this.judge(point);
	}
	public double sum(Term other, double point) {
		return Math.min(1, this.judge(point) + other.judge(point));
	}
	public double multiplication(Term other, double point) {
		return this.judge(point) * other.judge(point);
	}
	public double power(double power, double point) {
		return Math.pow(this.judge(point), power);
	}
	public double narrow(double point) {
		return this.power(2, point);
	}
	public double broad(double point) {
		return this.power(0.5, point);
	}
}
