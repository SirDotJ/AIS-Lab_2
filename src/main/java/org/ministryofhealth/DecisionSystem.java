package org.ministryofhealth;

import org.ministryofhealth.fuzzylogic.attendance.*;
import org.ministryofhealth.fuzzylogic.mark.*;

import java.util.*;

public class DecisionSystem {
	private final double examPoints;
	private final int failedAttendanceCount;

	public DecisionSystem(double examPoints, int failedAttendanceCount) {
		this.examPoints = examPoints;
		this.failedAttendanceCount = failedAttendanceCount;
	}

	public int judgeForStipendium() {
		// Shorthands for Marks
		Mark MF = new MarkF(); // F
		Mark MD = new MarkD(); // D
		Mark MC = new MarkC(); // C
		Mark MB = new MarkB(); // B
		Mark MA = new MarkA(); // A
		Mark MS = new MarkS(); // S

		// Shorthands for Attendances
		Attendance AT = new AttendanceTerrible(); // Ужасная
		Attendance AB = new AttendanceBad(); // Плохая
		Attendance AA = new AttendanceAverage(); // Средняя
		Attendance AG = new AttendanceGood(); // Хорошая
		Attendance AE = new AttendanceExcellent(); // Отличная
		Attendance AP = new AttendancePerfect(); // Идеальная

		// С оценкой A и посещаемостью П или оценкой B и посещаемостью почти И/О/Х = 1000
		if ((MA
			.moreProminentThan(Arrays.asList(MS, MF, MD, MC, MB), this.examPoints)
				&& AB
					.moreProminentThan(Arrays.asList(AT, AA, AG, AE, AP), this.failedAttendanceCount))
			|| (MB
				.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& (AP.unification(AE).unification(AG).broad()
					.moreProminentThan(Arrays.asList(AT, AB, AA), this.failedAttendanceCount))))
					return 1000;

		// С оценкой B и посещаемостью И = 1500
		if (MB
			.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& AP
					.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount))
			return 1500;

		// С оценкой F/D/C при любой посещаемости или оценкой B и посещаемостью П/У или оценкой A и посещаемостью У = 0
		if (MF.unification(MD).unification(MC)
			.moreProminentThan(Arrays.asList(MS, MA, MB), this.examPoints)
			|| MB
				.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& (AT.unification(AB)
					.moreProminentThan(Arrays.asList(AA, AG, AE, AP), this.failedAttendanceCount))
			|| MA
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AT
				.moreProminentThan(Arrays.asList(AB, AA, AG, AE, AP), this.failedAttendanceCount))
			return 0;

		// С оценкой A и посещаемостью Х/С или оценкой S и посещаемостью ПОЧТИ У = 2500
		if (MA
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AG.unification(AA)
					.moreProminentThan(Arrays.asList(AT, AB, AE, AP), this.failedAttendanceCount)
			|| MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AT.broad()
					.moreProminentThan(Arrays.asList(AB, AA, AG, AE, AP), this.failedAttendanceCount))
			return 2500;

		// С оценкой S и посещаемостью У = 2000
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AT
					.moreProminentThan(Arrays.asList(AB, AA, AG, AE, AP), this.failedAttendanceCount))
			return 2000;

		// С оценкой A и посещаемостью почти И или оценкой S и посещаемостью почти П = 2750
		if (MA
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AP.broad()
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount)
			|| MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
					&& AB.broad()
						.moreProminentThan(Arrays.asList(AT, AA, AG, AE, AP), this.failedAttendanceCount))
			return 2750;

		// С оценкой B и посещаемостью C = 500
		if (MB
			.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& AA
					.moreProminentThan(Arrays.asList(AT, AB, AG, AE, AP), this.failedAttendanceCount))
			return 500;

		// С оценкой A и посещаемостью О = 2600
		if (MA
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AE
					.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AP), this.failedAttendanceCount))
			return 2600;

		// С оценкой S и посещаемостью ПОЧТИ И = 5500
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AP.broad()
					.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount))
			return 5500;

		// С оценкой S и посещаемостью И = 6000
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AP
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount))
			return 6000;

		// С оценкой S и посещаемостью О = 5400
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AE
					.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AP), this.failedAttendanceCount))
			return 5400;

		// С оценкой S и посещаемостью Х = 5000
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AG
					.moreProminentThan(Arrays.asList(AT, AB, AA, AE, AP), this.failedAttendanceCount))
			return 5000;

		// С оценкой S и посещаемостью С = 4400
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AA
					.moreProminentThan(Arrays.asList(AT, AB, AG, AE, AP), this.failedAttendanceCount))
			return 4400;

		throw new RuntimeException("No clear decision was made");
	}
}
