
//Import  packages and files requiered for the class
package frc.systems;

import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch extends DigitalInput {// Class declaration: "public class 'Name of the class' {}"

    // create instance variables that will be used throughout the code

    // create instance variables that will be used throughout the code (See Unit 1
    // on APCS videos in slack)

    public LimitSwitch(int channel) {
        super(channel);
    }

    public boolean isArmTouching() {
        return get();

    }// end method

}// end class