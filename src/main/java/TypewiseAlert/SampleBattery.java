package TypewiseAlert;

public class SampleBattery implements BatteryConfigs{

    CoolingType coolingType;
    String brand;
    int lowerLimit;
    int upperLimit;

    SampleBattery(String brand, CoolingType coolingType, int lowerLimit, int upperLimit){
        setBrand(brand);
        setCoolingType(coolingType);
        setLowerLimit(lowerLimit);
        setUpperLimit(upperLimit);
    }

    public void setCoolingType(CoolingType cType) {
        this.coolingType = cType;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public CoolingType getCoolingType() {
        return coolingType;
    }
}
