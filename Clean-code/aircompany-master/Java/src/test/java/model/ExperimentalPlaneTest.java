package model;

import com.company.model.ExperimentalPlane;
import com.company.model.classification.ClassificationLevel;
import com.company.model.classification.ExperimentalType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExperimentalPlaneTest {
    private static final ExperimentalPlane EXPECTED_EXPERIMENTAL_PLANE =
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET);
    private static final ExperimentalPlane EXPERIMENTAL_PLANE_WITH_SAME_ARGUMENTS =
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET);
    private static final ExperimentalPlane ANOTHER_EXPERIMENTAL_PLANE =
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET);

    @Test
    public void compareExperimentalPlaneTypeTest() {
        Assert.assertEquals(EXPECTED_EXPERIMENTAL_PLANE.getType(), ExperimentalType.HIGH_ALTITUDE);
    }

    @Test
    public void compareExperimentalPlaneClassificationLevelTest() {
        Assert.assertEquals(EXPECTED_EXPERIMENTAL_PLANE.getClassificationLevel(), ClassificationLevel.SECRET);
    }

    @Test
    public void compareIdenticalExperimentalPlanesTest() {
        Assert.assertEquals(EXPECTED_EXPERIMENTAL_PLANE, EXPERIMENTAL_PLANE_WITH_SAME_ARGUMENTS);
    }

    @Test
    public void compareNotIdenticalExperimentalPlanesTest() {
        Assert.assertNotEquals(EXPECTED_EXPERIMENTAL_PLANE, ANOTHER_EXPERIMENTAL_PLANE);
    }
}
