package org.ministryofhealth.fuzzylogic.attendance;


import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class OverallAttendance {
	private static final List<Class<?>> TESTED_ATTENDANCES = new ArrayList<>(Arrays.asList(
		AttendanceTerrible.class, AttendanceBad.class,
		AttendanceAverage.class, AttendanceGood.class,
		AttendanceExcellent.class, AttendancePerfect.class
	));
	private final Map<Attendance, Double> judgementResults;
	public OverallAttendance(int failedAttendanceCount) throws IllegalArgumentException, IllegalStateException {
		if (failedAttendanceCount < 0 || failedAttendanceCount > 34)
			throw new IllegalArgumentException("Provided count is out of range!");

		this.judgementResults = new HashMap<>();
		for (Class<?> testedAttendance : TESTED_ATTENDANCES) {
			Attendance attendance;
			try {
				attendance = (Attendance) testedAttendance.getConstructors()[0].newInstance();
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
				System.out.println("ERROR: During judgement exception occurred: " + e);
				throw new IllegalStateException("Current TESTED_ATTENDANCES are not valid due to thrown exception: " + e);
			}
			double judgement = attendance.judge(failedAttendanceCount);
			this.judgementResults.put(attendance, judgement);
		}
	}
	public String getResultTerm() {
		double maxResult = Double.MIN_VALUE;
		Attendance mostLikelyAttendance = null;

		for (Map.Entry<Attendance, Double> entry : this.judgementResults.entrySet()) {
			Attendance attendance = entry.getKey();
			double judgement = entry.getValue();
			if (judgement > maxResult) {
				maxResult = judgement;
				mostLikelyAttendance = attendance;
			}
		}

		if (mostLikelyAttendance == null)
			throw new IllegalStateException("Unexpected error: no most likely attendance was found");

		return mostLikelyAttendance.meaning();
	}
}
