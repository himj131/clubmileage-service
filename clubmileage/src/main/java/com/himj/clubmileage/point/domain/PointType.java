package com.himj.clubmileage.point.domain;

public enum PointType {
    NORMAL(1),
    FIRST_REVIEW(1);

    private int point;
    PointType(int point) {
        this.point = point;
    }

    public int getPoint(){
        return this.point;
    }
}
