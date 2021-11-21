package model;

import com.company.model.MilitaryPlane;
import com.company.model.classification.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilitaryPlaneTest {
    private static final MilitaryPlane EXPECTED_MILITARY_PLANE =
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000,MilitaryType.BOMBER);
    private static final MilitaryPlane THE_SAME_MILITARY_PLANE =
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000,MilitaryType.BOMBER);
    private static final MilitaryPlane ANOTHER_MILITARY_PLANE =
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER);

    @Test
    public void compareMilitaryPlaneTypeTest() {
        Assert.assertEquals(EXPECTED_MILITARY_PLANE.getType(), MilitaryType.BOMBER);
    }

    @Test
    public void compareIdenticalMilitaryPlanesTest() {
        Assert.assertEquals(EXPECTED_MILITARY_PLANE, THE_SAME_MILITARY_PLANE);
    }

    @Test
    public void compareNotIdenticalMilitaryPlanesTest() {
        Assert.assertNotEquals(EXPECTED_MILITARY_PLANE, ANOTHER_MILITARY_PLANE);
    }
}
