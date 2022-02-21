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

    }

    @Test
    public void infersBreachForPassiveCooling()
    {
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", CoolingType.PASSIVE_COOLING);

        assertTrue(BatteryManager.inferBreach(46, sampleBattery) == BreachType.TOO_HIGH);
        assertTrue(BatteryManager.isLowerBreach(46, sampleBattery) == false);
        assertTrue(BatteryManager.isUpperBreach(46, sampleBattery) == true);

    }

    @Test
    public void infersBreachForMidCooling()
    {
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", CoolingType.MED_ACTIVE_COOLING);

        assertTrue(BatteryManager.inferBreach(46, sampleBattery) == BreachType.TOO_HIGH);
        assertTrue(BatteryManager.isLowerBreach(46, sampleBattery) == false);
        assertTrue(BatteryManager.isUpperBreach(46, sampleBattery) == true);

    }
}
