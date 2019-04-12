package com.bodymassindex;

public class BMI {
    private float height;
    private float weight;
    private float bmi;
    private float meter;

    public BMI(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public float Calculate() {
        meter = (height / 100);
        bmi = weight / (meter * meter);
        return bmi;


    }
}
