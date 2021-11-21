package model;

import com.company.model.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PassengerPlaneTest {
    private static final PassengerPlane EXPECTED_PASSENGER_PLANE =
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164);
    private static final PassengerPlane THE_SAME_PASSENGER_PLANE =
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164);
    private static final PassengerPlane ANOTHER_PASSENGER_PLANE =
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192);
    private static final int EXPECTED_PASSENGER_PLANE_PASSENGER_CAPACITY = 164;

    @Test
    public void comparePassengerPlanePassengerCapacityTest() {
        Assert.assertEquals(
                EXPECTED_PASSENGER_PLANE.getPassengersCapacity(),
                EXPECTED_PASSENGER_PLANE_PASSENGER_CAPACITY
        );
    }

    @Test
    public void compareIdenticalPassengerPlanesTest() {
        Assert.assertEquals(EXPECTED_PASSENGER_PLANE, THE_SAME_PASSENGER_PLANE);
    }

    @Test
    public void compareNotIdenticalPassengerPlanesTest() {
        Assert.assertNotEquals(EXPECTED_PASSENGER_PLANE, ANOTHER_PASSENGER_PLANE);
    }
}
