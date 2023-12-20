package org.ministryofhealth.marks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JudgementResult {
    private final Map<Class<Mark>, Double> verdicts;
    public JudgementResult(double points) {
        this.verdicts = new HashMap<>();
        verdicts.put(MarkF, MarkF.judge(points));
        verdicts.put(MarkD, MarkD.judge(points));
        verdicts.put(MarkC.resultStr(), MarkC.judge(points));
        verdicts.put(MarkB.resultStr(), MarkB.judge(points));
        verdicts.put(MarkA.resultStr(), MarkA.judge(points));
        verdicts.put(MarkS.resultStr(), MarkS.judge(points));
    }
    public String getMostLikelyVerdict() {
        return Collections.max(this.verdicts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public boolean isGoodStudent() { // S or A
        return  this.getMostLikelyVerdict().equals(MarkS.resultStr()) ||
                this.getMostLikelyVerdict().equals(MarkA.resultStr());
    }
    public boolean isBadStudent() { // F or D
        return  this.getMostLikelyVerdict().equals(MarkF.resultStr()) ||
                this.getMostLikelyVerdict().equals(MarkD.resultStr());
    }
    public boolean isFineStudent() { // C or B
        return  this.getMostLikelyVerdict().equals(MarkC.resultStr()) ||
                this.getMostLikelyVerdict().equals(MarkB.resultStr());
    }
    public double deservedBonus() {
        Collections.max(this.verdicts.entrySet(), Map.Entry.comparingByValue()).
    }
}
