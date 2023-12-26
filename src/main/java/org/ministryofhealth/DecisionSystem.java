package org.ministryofhealth;

import org.ministryofhealth.fuzzylogic.attendance.*;
import org.ministryofhealth.fuzzylogic.mark.*;

import java.util.*;

public class DecisionSystem {
	private static List<Mark> DEFINED_MARKS = new ArrayList<>(Arrays.asList(
		(new MarkF()), (new MarkD()),
		(new MarkC()), (new MarkB()),
		(new MarkA()), (new MarkS())
	));

	private static List<Attendance> DEFINED_ATTENDANCE = new ArrayList<>(Arrays.asList(
		(new AttendanceTerrible()), (new AttendanceBad()),
		(new AttendanceAverage()), (new AttendanceGood()),
		(new AttendanceExcellent()), (new AttendancePerfect())
	));

	private final OverallMark judgedMark;
	private final Map<Mark, Double> markJudgementsResult;
	private final OverallAttendance judgedAttendance;
	private final Map<Attendance, Double> attendanceJudgementResult;

	public DecisionSystem(double examPoints, double failedAttendanceCount) {
		this.judgedMark = new OverallMark(examPoints);
		this.judgedAttendance = new OverallAttendance((int) failedAttendanceCount);

		this.markJudgementsResult = new HashMap<>();
		for (Mark mark : DEFINED_MARKS)
			this.markJudgementsResult.put(mark, mark.judge(examPoints));

		this.attendanceJudgementResult = new HashMap<>();
		for (Attendance attendance : DEFINED_ATTENDANCE)
			this.attendanceJudgementResult.put(attendance, attendance.judge(failedAttendanceCount));
	}
}
