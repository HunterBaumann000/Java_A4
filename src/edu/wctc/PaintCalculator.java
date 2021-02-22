package edu.wctc;

import java.util.List;

public class PaintCalculator {
    private List<Room> roomList;

    public void addRoom(double length, double width, double height) {
        roomList.add(new Room(length, width, height));
    }

    public String toString() {
        if(roomList.isEmpty()){
            return "There are Currently 0 rooms";
        } else{
            return String.valueOf(roomList);
        }
    }

}
