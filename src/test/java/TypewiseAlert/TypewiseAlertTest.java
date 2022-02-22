package TypewiseAlert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest
{

    public static void inferBreachFor(CoolingType coolingType){
        SampleBattery sampleBattery = BatteryManager.initBattery("sample", coolingType);

        testUpperLimitBreach(coolingType, sampleBattery);
        testLowerLimitBreach(coolingType, sampleBattery);
        testNoBreachState(coolingType, sampleBattery);


    }

    public static void isEmailSent(BreachType breachType){
        assertTrue( Alerter.sendToEmail(breachType));
    }

    public static void isControllerAlerted(BreachType breachType){
        assertTrue( Alerter.sendToController(breachType) );
    }

    public static void testUpperLimitBreach(CoolingType coolingType, SampleBattery sampleBattery){

        for(int tempValue = BatteryManager.upperLimitMapper.get(coolingType)+1; tempValue < BatteryManager.upperLimitMapper.get(coolingType)  + 10; tempValue++){
            assertTrue(BatteryManager.inferBreach(tempValue, sampleBattery) == BreachType.TOO_HIGH);
            assertFalse(BatteryManager.isLowerBreach(tempValue, sampleBattery) );
            assertTrue(BatteryManager.isUpperBreach(tempValue, sampleBattery) );
       }


    }

    public static void testLowerLimitBreach(CoolingType coolingType, SampleBattery sampleBattery){

        for(int tempValue = BatteryManager.lowerLimitMapper.get(coolingType)-1; tempValue > BatteryManager.lowerLimitMapper.get(coolingType) - 10; tempValue--){

            assertTrue(BatteryManager.inferBreach(tempValue, sampleBattery) == BreachType.TOO_LOW);
            assertTrue(BatteryManager.isLowerBreach(tempValue, sampleBattery));
            assertFalse(BatteryManager.isUpperBreach(tempValue, sampleBattery));

        }


    }

    public static void testNoBreachState(CoolingType coolingType, SampleBattery sampleBattery){

        for( int tempValue = BatteryManager.lowerLimitMapper.get(coolingType); tempValue <= BatteryManager.upperLimitMapper.get(coolingType); tempValue++  ){
            assertTrue(BatteryManager.inferBreach(tempValue, sampleBattery) == BreachType.NORMAL);
            assertFalse(BatteryManager.isLowerBreach(tempValue, sampleBattery));
            assertFalse(BatteryManager.isUpperBreach(tempValue, sampleBattery));
        }

    }



}
