package edu.wctc;

import java.util.*;

public class Room {

    private List<Wall> wallList = new ArrayList<>();


    public Room(double width, double length, double height) {

        //wallList.add(new Wall(width, height));
        //wallList.add(new Wall(width, height));
        //wallList.add(new Wall(length, height));
        //wallList.add(new Wall(length, height));

        Wall w1 = new Wall(width, height);
        Wall w2 = new Wall(width, height);
        Wall w3 = new Wall(length, height);
        Wall w4 = new Wall(length, height);

        this.wallList.add(w1);
        this.wallList.add(w2);
        this.wallList.add(w3);
        this.wallList.add(w4);
        
    }

    public double getArea() {
        double area = 0;
        for (Wall wall : wallList) {
            area =+ Wall.getArea();
        }

        return area;
    }

    public String toString() {

        return String.valueOf(getArea());
    }
}
