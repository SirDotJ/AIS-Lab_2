package org.ministryofhealth.fuzzylogic.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceTerrible extends Attendance {
	// Выведено при помощи экспертной оценки терма "Ужасная" в файле "Экспертный анализ термов посещаемости.xlsx"
	private static final List<Double[]> attendanceTerribleNormalizedCoefficients = new ArrayList<>(Arrays.asList(
		new Double[] {0d, 0.01d},
		new Double[] {1d, 0.03d},
		new Double[] {3d, 0.06d},
		new Double[] {5d, 0.09d},
		new Double[] {7d, 0.145d},
		new Double[] {9d, 0.184d},
		new Double[] {11d, 0.254d},
		new Double[] {13d, 0.348d},
		new Double[] {15d, 0.374d},
		new Double[] {17d, 0.485d},
		new Double[] {19d, 0.523d},
		new Double[] {21d, 0.62d},
		new Double[] {23d, 0.68d},
		new Double[] {25d, 0.723d},
		new Double[] {27d, 0.795d},
		new Double[] {29d, 0.863d},
		new Double[] {31d, 0.964d},
		new Double[] {33d, 1d},
		new Double[] {34d, 1d}
	));

	public AttendanceTerrible() {
		super(attendanceTerribleNormalizedCoefficients);
	}

	@Override
	public String meaning() {
		return "Ужасная - Пропускает практически все занятия";
	}
}
