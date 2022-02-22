package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

import static TypewiseAlert.Alerter.sendToController;
import static TypewiseAlert.Alerter.sendToEmail;

public class BatteryManager {

    static Map<CoolingType, Integer> lowerLimitMapper = new HashMap<>();
    static Map<CoolingType, Integer> upperLimitMapper = new HashMap<>();

    static{
        lowerLimitMapper.put(CoolingType.PASSIVE_COOLING, 0);
        lowerLimitMapper.put(CoolingType.HI_ACTIVE_COOLING, 0);
        lowerLimitMapper.put(CoolingType.MED_ACTIVE_COOLING, 0);

        upperLimitMapper.put(CoolingType.PASSIVE_COOLING, 35);
        upperLimitMapper.put(CoolingType.HI_ACTIVE_COOLING, 45);
        upperLimitMapper.put(CoolingType.MED_ACTIVE_COOLING, 40);
    }

    public static SampleBattery initBattery(String brand, CoolingType coolingType){
        return new SampleBattery(brand, coolingType, lowerLimitMapper.get(coolingType), upperLimitMapper.get(coolingType));
    }

    public static BreachType inferBreach(int tempValue, SampleBattery samBat){

        boolean lowerBreachState = isLowerBreach(tempValue, samBat);
        boolean upperBreachState = isUpperBreach(tempValue, samBat);

        if(lowerBreachState)
            return BreachType.TOO_LOW;
        else if(upperBreachState)
            return BreachType.TOO_HIGH;

        return BreachType.NORMAL;

    }

    static boolean isLowerBreach(int tempValue, SampleBattery samBat){

        boolean isBreached = tempValue < samBat.getLowerLimit();
            if(isBreached){
                sendToController(BreachType.TOO_LOW);
                sendToEmail(BreachType.TOO_LOW);
            }
        return isBreached;
    }

    static boolean isUpperBreach(int tempValue, SampleBattery samBat){
        boolean isBreached = tempValue > samBat.getUpperLimit();
        if (isBreached){
            sendToController(BreachType.TOO_HIGH);
            sendToEmail(BreachType.TOO_HIGH);
        }
        return isBreached;
    }

}
