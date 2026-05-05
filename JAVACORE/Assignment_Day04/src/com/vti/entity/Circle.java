package com.vti.entity;

public class Circle {
    private double radius;
    private String color;

    public Circle(){

    }
    public Circle(double radius){

    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return (float) (Math.PI * radius * radius);
    }
    @Override
    public String toString() {
        return "Circle[" + "radius= " + radius + ", color='" + color + '\'' + ']';
    }
}
