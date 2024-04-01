package aut.isp.lab4;


import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise4.AquariumController;
import aut.isp.lab4.exercise4.Lights;
import org.junit.Assert;
import org.junit.Test;

public class AquariumControllerTest {
    @Test
    public void testLights() {
        FishFeeder feeder = new FishFeeder("A32", "Pro");
        Lights lights = new Lights(false);
        AquariumController aquariumController = new AquariumController(feeder, "YT", "A10", lights);

        aquariumController.setLightOnTime(6.0f);
        aquariumController.setLightOffTime(14.0f);

        aquariumController.setCurrentTime(5.0f);
        Assert.assertFalse("Lights should be off before light on time", lights.isOn());

        aquariumController.setCurrentTime(7.0f);
        Assert.assertTrue("Lights should be on after light on time", lights.isOn());

        aquariumController.setCurrentTime(15.0f);
        Assert.assertFalse("Lights should be off after light off time", lights.isOn());
    }

    @Test
    public void testToString() {
        FishFeeder feeder = new FishFeeder("A66", "Pro");
        Lights lights = new Lights(false);

        AquariumController controller = new AquariumController(feeder, "A20", "PRO LED", lights);
        String expected = "AquariumController{feeder=FishFeeder: manufacturer=A66, model=Pro, meals=0, manufacturer='A20', model='PRO LED', currentTime=0.0, feedingTime=0.0, lightOnTime=0.0, lightOffTime=0.0, Lights state: Off}";
        Assert.assertEquals(expected, controller.toString());
    }

}
