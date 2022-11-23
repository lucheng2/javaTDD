package com.tdd.chap04;

public class Ship {

    private final Location location;

    public Location getLocation() {
        return location;
    }

    public Ship(Location location) {
        this.location = location;
    }

    public boolean moveForward() {
        return location.forward();
    }

    public boolean moveBackword() {
        return location.backward();
    }
}
