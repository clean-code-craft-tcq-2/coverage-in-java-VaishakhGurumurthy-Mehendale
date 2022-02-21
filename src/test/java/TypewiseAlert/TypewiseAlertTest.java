package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachForHighCooling()
    {
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", CoolingType.HI_ACTIVE_COOLING);

        assertTrue(BatteryManager.inferBreach(46, sampleBattery) == BreachType.TOO_HIGH);
        assertTrue(BatteryManager.isLowerBreach(46, sampleBattery) == false);
        assertTrue(BatteryManager.isUpperBreach(46, sampleBattery) == true);

        assertTrue(BatteryManager.inferBreach(-1, sampleBattery) == BreachType.TOO_LOW);
        assertTrue(BatteryManager.isLowerBreach(-1, sampleBattery) == true);
        assertTrue(BatteryManager.isUpperBreach(-1, sampleBattery) == false);

    }

    @Test
    public void infersBreachForPassiveCooling()
    {
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", CoolingType.PASSIVE_COOLING);

        assertTrue(BatteryManager.inferBreach(41, sampleBattery) == BreachType.TOO_HIGH);
        assertTrue(BatteryManager.isLowerBreach(41, sampleBattery) == false);
        assertTrue(BatteryManager.isUpperBreach(41, sampleBattery) == true);

        assertTrue(BatteryManager.inferBreach(-1, sampleBattery) == BreachType.TOO_LOW);
        assertTrue(BatteryManager.isLowerBreach(-1, sampleBattery) == true);
        assertTrue(BatteryManager.isUpperBreach(-1, sampleBattery) == false);

    }

    @Test
    public void infersBreachForMidCooling()
    {
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", CoolingType.MED_ACTIVE_COOLING);

        assertTrue(BatteryManager.inferBreach(36, sampleBattery) == BreachType.TOO_HIGH);
        assertTrue(BatteryManager.isLowerBreach(36, sampleBattery) == false);
        assertTrue(BatteryManager.isUpperBreach(36, sampleBattery) == true);

        assertTrue(BatteryManager.inferBreach(-1, sampleBattery) == BreachType.TOO_LOW);
        assertTrue(BatteryManager.isLowerBreach(-1, sampleBattery) == true);
        assertTrue(BatteryManager.isUpperBreach(-1, sampleBattery) == false);

    }
}
