package org.ministryofhealth;

import org.ministryofhealth.fuzzylogic.attendance.OverallAttendance;
import org.ministryofhealth.fuzzylogic.mark.OverallMark;

public class Main {
	public static void main(String[] args) {

		if (args.length <= 0) {
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 35; j++) {
					int examPoints = i;
					int failedAttendanceCount = j;
					DecisionSystem system = new DecisionSystem(examPoints, failedAttendanceCount);
					System.out.println("Количество баллов: " + examPoints + " из 100");
					System.out.println("Оценка: " + (new OverallMark(examPoints)).getResultTerm());
					System.out.println("Пропущенных занятий: " + failedAttendanceCount + " из 34");
					System.out.println("Посещаемость: " + (new OverallAttendance(failedAttendanceCount).getResultTerm()));
					System.out.println("Стипендия: " + system.judgeForStipendium());
					// TODO: добавить причину выдачи стипендии
				}
			}
		} else {
			int examPoints = Integer.parseInt(args[0]);
			int failedAttendanceCount = Integer.parseInt(args[1]);
			DecisionSystem system = new DecisionSystem(examPoints, failedAttendanceCount);
			System.out.println("Количество баллов: " + examPoints + " из 100");
			System.out.println("Оценка: " + (new OverallMark(examPoints)).getResultTerm());
			System.out.println("Пропущенных занятий: " + failedAttendanceCount + " из 34");
			System.out.println("Посещаемость: " + (new OverallAttendance(failedAttendanceCount).getResultTerm()));
			System.out.println("Стипендия: " + system.judgeForStipendium());
			// TODO: добавить причину выдачи стипендии
		}
	}
}