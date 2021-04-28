package com.example.models;

public class VacRequirements {
    private Integer experience;
    private boolean highEducation;

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public boolean isHighEducation() {
        return highEducation;
    }

    public void setHighEducation(boolean highEducation) {
        this.highEducation = highEducation;
    }

    public VacRequirements(Integer experience, boolean highEducation) {
        this.experience = experience;
        this.highEducation = highEducation;
    }
}
