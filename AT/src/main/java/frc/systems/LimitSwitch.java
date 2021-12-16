
//Import  packages and files requiered for the class
package frc.systems;
import frc.robot.Robot;
import edu.wpi.first.hal.simulation.DIODataJNI;


public class LimitSwitch extends DIODataJNI {//Class declaration: "public class 'Name of the class' {}"
    

    //create instance variables that will be used throughout the code 

    //create instance variables that will be used throughout the code (See Unit 1 on APCS videos in slack)
    
    boolean LSwitchStatus; //stores a True/False value on whether or not the limit switch is activated

    //constructor: determine the characteristics of the limit switch
    public LimitSwitch(int limitSwitchPort, boolean LSwitch){
        LSwitchStatus = LSwitch;
        
    }//end constructor
        

    public boolean isArmTouching()
    {   
        return Robot.myLimitSwitch.LSwitchStatus;
    
    }//end method


}//end class