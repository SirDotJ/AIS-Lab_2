package org.ministryofhealth.fuzzylogic.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendancePerfect extends Attendance {
	// Выведено при помощи экспертной оценки терма "Идеальная" в файле "Экспертный анализ термов посещаемости.xlsx"
	private static final List<Double[]> attendancePerfectNormalizedCoefficients = new ArrayList<>(Arrays.asList(
		new Double[] {0d, 1d},
		new Double[] {1d, 0.9829d},
		new Double[] {3d, 0.9658d},
		new Double[] {5d, 0.9125d},
		new Double[] {7d, 0.7954d},
		new Double[] {9d, 0.7245d},
		new Double[] {11d, 0.6048d},
		new Double[] {13d, 0.5784d},
		new Double[] {15d, 0.4863d},
		new Double[] {17d, 0.4369d},
		new Double[] {19d, 0.3156d},
		new Double[] {21d, 0.2958d},
		new Double[] {23d, 0.2589d},
		new Double[] {25d, 0.1245d},
		new Double[] {27d, 0.0785d},
		new Double[] {29d, 0.0369d},
		new Double[] {31d, 0.025d},
		new Double[] {33d, 0.001d},
		new Double[] {34d, 0.0005d}
	));

	public AttendancePerfect() {
		super(attendancePerfectNormalizedCoefficients);
	}

	@Override
	public String meaning() {
		return "Идеальная - Не пропускает занятия";
	}
}
