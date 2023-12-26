package org.ministryofhealth;

import org.ministryofhealth.fuzzylogic.attendance.OverallAttendance;
import org.ministryofhealth.fuzzylogic.mark.OverallMark;

public class Main {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			int examPoints = (int) (Math.random() * 101);
			int failedAttendanceCount = (int) (Math.random() * 34);
			DecisionSystem system = new DecisionSystem(examPoints, failedAttendanceCount);
			Decision decision;
			try {
				decision = system.judgeForStipendium();
			} catch (RuntimeException e) {
				System.out.println("Не было принято решение для характеристик:");
				System.out.println("\tКоличество баллов: " + examPoints + " из 100;");
				System.out.println("\tОценка: " + new OverallMark(examPoints).getResultTerm() + ";");
				System.out.println("\tКоличество пропущенных занятий: " + failedAttendanceCount + " из 34;");
				System.out.println("\tПосещаемость: " + new OverallAttendance(failedAttendanceCount).getResultTerm() + ".");
				continue;
			}
			System.out.println(decision);
		}
	}
}