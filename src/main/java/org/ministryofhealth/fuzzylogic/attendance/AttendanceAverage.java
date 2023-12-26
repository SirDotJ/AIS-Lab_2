package org.ministryofhealth.fuzzylogic.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceAverage extends Attendance {
	// Выведено при помощи экспертной оценки терма "Средняя" в файле "Экспертный анализ термов посещаемости.xlsx"
	private static final List<Double[]> attendanceAverageNormalizedCoefficients = new ArrayList<>(Arrays.asList(
		new Double[] {0d, 0.021d},
		new Double[] {1d, 0.054d},
		new Double[] {3d, 0.1548d},
		new Double[] {5d, 0.2859d},
		new Double[] {7d, 0.3587d},
		new Double[] {9d, 0.4368d},
		new Double[] {11d, 0.5186d},
		new Double[] {13d, 0.5596d},
		new Double[] {15d, 0.5986d},
		new Double[] {17d, 0.7025d},
		new Double[] {19d, 0.7589d},
		new Double[] {21d, 0.8265d},
		new Double[] {23d, 0.9785d},
		new Double[] {25d, 1d},
		new Double[] {27d, 0.9368d},
		new Double[] {29d, 0.7895d},
		new Double[] {31d, 0.6548d},
		new Double[] {33d, 0.5364d},
		new Double[] {34d, 0.5112d}
	));

	public AttendanceAverage() {
		super(attendanceAverageNormalizedCoefficients);
	}

	@Override
	public String meaning() {
		return "Средняя - Заметно часто нет на занятиях";
	}
}
