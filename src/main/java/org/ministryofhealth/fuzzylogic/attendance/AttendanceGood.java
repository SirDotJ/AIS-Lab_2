package org.ministryofhealth.fuzzylogic.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceGood extends Attendance {
	// Выведено при помощи экспертной оценки терма "Хорошая" в файле "Экспертный анализ термов посещаемости.xlsx"
	private static final List<Double[]> attendanceGoodNormalizedCoefficients = new ArrayList<>(Arrays.asList(
		new Double[] {0d, 0.009d},
		new Double[] {1d, 0.015d},
		new Double[] {3d, 0.269d},
		new Double[] {5d, 0.3987d},
		new Double[] {7d, 0.4785d},
		new Double[] {9d, 0.6398d},
		new Double[] {11d, 0.6985d},
		new Double[] {13d, 0.8695d},
		new Double[] {15d, 0.9468d},
		new Double[] {17d, 1d},
		new Double[] {19d, 0.9158d},
		new Double[] {21d, 0.7856d},
		new Double[] {23d, 0.7365d},
		new Double[] {25d, 0.5746d},
		new Double[] {27d, 0.4486d},
		new Double[] {29d, 0.3789d},
		new Double[] {31d, 0.2584d},
		new Double[] {33d, 0.1365d},
		new Double[] {34d, 0.1134d}
	));

	public AttendanceGood() {
		super(attendanceGoodNormalizedCoefficients);
	}

	@Override
	public String meaning() {
		return "Хорошая - Иногда пропускает занятия";
	}
}
