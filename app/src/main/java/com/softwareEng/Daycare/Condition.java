package com.softwareEng.Daycare;

public class Condition {
    int id;
    int severity;
    String medCondition;

    public Condition(int severity, String medCondition) {
        this.severity = severity;
        this.medCondition = medCondition;
    }
    public interface addCondition {
        public long addcondition(int severity,String medCondition);
    }
}
