package frc.systems;

import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch extends DigitalInput {

    public LimitSwitch(int channel) {
        super(channel);//reads data from the roboRIO
    }//end method

    public boolean isArmTouching() {
        return get();//.get() Get the value from a digital input channel. 

    }// end method

}
