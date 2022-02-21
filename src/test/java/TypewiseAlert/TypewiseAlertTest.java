package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{

    public void inferBreachFor(CoolingType coolingType){
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", coolingType);

        assertTrue(BatteryManager.inferBreach(BatteryManager.upperLimitMapper.get(coolingType)+1, sampleBattery) == BreachType.TOO_HIGH);
        assertTrue(BatteryManager.isLowerBreach(BatteryManager.upperLimitMapper.get(coolingType)+1, sampleBattery) == false);
        assertTrue(BatteryManager.isUpperBreach(BatteryManager.upperLimitMapper.get(coolingType)+1, sampleBattery) == true);

        assertTrue(BatteryManager.inferBreach(BatteryManager.lowerLimitMapper.get(coolingType)-1, sampleBattery) == BreachType.TOO_LOW);
        assertTrue(BatteryManager.isLowerBreach(BatteryManager.lowerLimitMapper.get(coolingType)-1, sampleBattery) == true);
        assertTrue(BatteryManager.isUpperBreach(BatteryManager.lowerLimitMapper.get(coolingType)-1, sampleBattery) == false);
    }

    @Test
    public void infersBreachForHighCooling()
    {
        inferBreachFor(CoolingType.HI_ACTIVE_COOLING);

    }

    @Test
    public void infersBreachForPassiveCooling()
    {
        inferBreachFor(CoolingType.PASSIVE_COOLING);
    }

    @Test
    public void infersBreachForMidCooling()
    {
        inferBreachFor(CoolingType.MED_ACTIVE_COOLING);
    }
}
