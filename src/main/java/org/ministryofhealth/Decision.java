package org.ministryofhealth;

import org.ministryofhealth.fuzzylogic.attendance.OverallAttendance;
import org.ministryofhealth.fuzzylogic.mark.OverallMark;

public class Decision {
    private final double examPoints;
    private final double failedAttendanceCount;
    private final int stipendium;
    private final String explanation;
    public Decision(double examPoints, double failedAttendanceCount, int stipendium, String explanation) {
        this.examPoints = examPoints;
        this.failedAttendanceCount = failedAttendanceCount;
        this.stipendium = stipendium;
        this.explanation = explanation;
    }
    public int getExamPoints() {
        return (int) examPoints;
    }
    public int getFailedAttendanceCount() {
        return (int) failedAttendanceCount;
    }
    public int getStipendium() {
        return stipendium;
    }
    public String getExplanation() {
        return "Стипендия была выдано по следующему критерию: " + explanation;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Решение:\n");
        builder.append("\tКоличество баллов: ").append(this.examPoints).append(" из 100;\n");
        builder.append("\tОценка: ").append(new OverallMark(this.examPoints).getResultTerm()).append(";\n");
        builder.append("\tКол-во пропущенных занятий: ").append(this.failedAttendanceCount).append(" из 34;\n");
        builder.append("\tПосещаемость: ").append(new OverallAttendance((int) this.failedAttendanceCount).getResultTerm()).append(";\n");
        builder.append("\tСтипендия: ").append(this.stipendium).append(";\n");
        builder.append("\tОснования решения: ").append(this.explanation).append(".\n");
        return builder.toString();
    }
}
