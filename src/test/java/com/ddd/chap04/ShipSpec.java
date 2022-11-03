package com.ddd.chap04;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    private Ship ship;
    private Location location;

    @BeforeTest
    public void beforeTest() {
        location = new Location(new Point(1,2), Direction.NORTH);
        ship = new Ship(location);
    }

    public void whenInstantiatedThenPositionIsSet() {
        Assert.assertEquals(location, ship.getLocation());
    }

    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        Assert.assertEquals(expected, ship.getLocation());
    }

    public void whenMoveBackwardThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.moveBackword();
        Assert.assertEquals(expected, ship.getLocation());
    }

}
