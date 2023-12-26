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

	public Decision judgeForStipendium() {
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

		int stipendium;
		String explanation;

		// С оценкой S и посещаемостью И = 6000
		stipendium = 6000;
		explanation = "Получил оценку S и посещаемость Идеальная";
		if (MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AP
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой S и посещаемостью ПОЧТИ И = 5500
		stipendium = 5500;
		explanation = "Получил оценку S и посещаемость почти Идеальная";
		if (MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AP.broad()
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой S и посещаемостью О = 5400
		stipendium = 5400;
		explanation = "Получил оценку S и посещаемость Отличная";
		if (MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AE
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой S и посещаемостью Х = 5000
		stipendium = 5000;
		explanation = "Получил оценку S и посещаемость Хорошая";
		if (MS
			.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AG
					.moreProminentThan(Arrays.asList(AT, AB, AA, AE, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой S и посещаемостью С = 4400
		stipendium = 4400;
		explanation = "Получил оценку S и посещаемость Средняя";
		if (MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AA
				.moreProminentThan(Arrays.asList(AT, AB, AG, AE, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой A и посещаемостью почти И или оценкой S и посещаемостью почти П = 2750
		stipendium = 2750;
		explanation = "Получил оценку A и посещаемость почти Идеальная, либо оценка S и посещаемость почти Плохая";
		if (MA
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AP.broad()
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount)
				|| MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AB.broad()
				.moreProminentThan(Arrays.asList(AT, AA, AG, AE, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой A и посещаемостью О = 2600
		stipendium = 2600;
		explanation = "Получил оценку A и посещаемость Отличная";
		if (MA
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AE
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой A и посещаемостью Х/С или оценкой S и посещаемостью ПОЧТИ У = 2500
		stipendium = 2500;
		explanation = "Получил оценку A и посещаемость Хорошая/Средняя, либо оценка S и посещаемость почти Ужасная";
		if (MA
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MS), this.examPoints)
				&& AG.unification(AA)
				.moreProminentThan(Arrays.asList(AT, AB, AE, AP), this.failedAttendanceCount)
				|| MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AT.broad()
				.moreProminentThan(Arrays.asList(AB, AA, AG, AE, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой S и посещаемостью У = 2000
		stipendium = 2000;
		explanation = "Получил оценку S и посещаемость Ужасная";
		if (MS
				.moreProminentThan(Arrays.asList(MF, MD, MC, MB, MA), this.examPoints)
				&& AT
				.moreProminentThan(Arrays.asList(AB, AA, AG, AE, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой B и посещаемостью И = 1500
		stipendium = 1500;
		explanation = "Получил оценку B и посещаемость Идеальная";
		if (MB
				.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& AP
				.moreProminentThan(Arrays.asList(AT, AB, AA, AG, AE), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой A и посещаемостью П или оценкой B и посещаемостью почти И/О/Х = 1000
		stipendium = 1000;
		explanation = "Получил оценку A и посещаемость Плохая, либо оценка B и посещаемость почти Идеальная/Отличная/Хорошая";
		if ((MA
			.moreProminentThan(Arrays.asList(MS, MF, MD, MC, MB), this.examPoints)
				&& AB
					.moreProminentThan(Arrays.asList(AT, AA, AG, AE, AP), this.failedAttendanceCount))
			|| (MB
				.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& (AP.unification(AE).unification(AG).broad()
					.moreProminentThan(Arrays.asList(AT, AB, AA), this.failedAttendanceCount))))
					return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой B и посещаемостью C = 500
		stipendium = 500;
		explanation = "Получил оценку B и посещаемость Средняя";
		if (MB
			.moreProminentThan(Arrays.asList(MF, MD, MC, MA, MS), this.examPoints)
				&& AA
					.moreProminentThan(Arrays.asList(AT, AB, AG, AE, AP), this.failedAttendanceCount))
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		// С оценкой F/D/C при любой посещаемости или оценкой B и посещаемостью П/У или оценкой A и посещаемостью У = 0
		stipendium = 0;
		explanation = "Получил оценку F/D/C, либо оценка B и посещаемость Плохая/Ужасная, либо оценка A и посещаемость Ужасная";
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
			return new Decision(this.examPoints, this.failedAttendanceCount, stipendium, explanation);

		throw new RuntimeException("No clear decision was made");
	}
}
