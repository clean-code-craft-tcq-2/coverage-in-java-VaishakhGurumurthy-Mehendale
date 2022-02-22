package TypewiseAlert;

import static TypewiseAlert.TypewiseAlertTest.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestInvoker {

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

    @Test
    public void testEmail()
    {
        isEmailSent(BreachType.TOO_LOW);
    }

    @Test
    public void testControllerAlert()
    {
        isControllerAlerted(BreachType.TOO_LOW);
    }


}
