package com.example.models;

public class Vacancy {
    private Integer vacId;
    private Integer userId;
    private String vacName;
    private String description;
    private VacRequirements requirements;

    public Vacancy(Integer vacId, Integer userId,String vacName, String description, VacRequirements requirements) {
        this.vacId = vacId;
        this.userId = userId;
        this.vacName = vacName;
        this.description = description;
        this.requirements = requirements;
    }

    public String getVacName() {
        return vacName;
    }

    public void setVacName(String vacName) {
        this.vacName = vacName;
    }

    public Vacancy(Integer userId, String vacName, String description, VacRequirements requirements) {
        this.userId = userId;
        this.vacName = vacName;
        this.description = description;
        this.requirements = requirements;
    }

    public Integer getVacId() {
        return vacId;
    }

    public void setVacId(Integer vacId) {
        this.vacId = vacId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VacRequirements getRequirements() {
        return requirements;
    }

    public void setRequirements(VacRequirements requirements) {
        this.requirements = requirements;
    }
}
