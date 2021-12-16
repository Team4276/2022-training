package frc.systems;

import frc.utilities.Xbox;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
    private final double MAX_POWER = 1.0;

    private TalonSRX myArmController;
    private Encoder myArmEncoder;

    private double manualPower = 0;
    private double commandedPower = 0;

    public Arm(int armCANPort1, int arm_encoderPortA, int arm_encoderPortB) {
        myArmController = new TalonSRX(armCANPort1);
        myArmEncoder = new Encoder(arm_encoderPortA, arm_encoderPortB);
        myArmEncoder.reset();
    }

    private void computeManualPower() {
        if (Math.abs(Robot.xboxJoystick.getRawAxis(Xbox.LAxisY)) > 0.2) {
            manualPower = Robot.xboxJoystick.getRawAxis(Xbox.LAxisY);
        } else {
            manualPower = 0;
        }
    }

    private void limitCommandedPower() {
        // Limit the range of commanded power
        if (commandedPower > MAX_POWER) {
            commandedPower = MAX_POWER;
        } else if (commandedPower < -MAX_POWER) {
            commandedPower = -MAX_POWER;
        }
    }

    public void armPeriodic() {
        computeManualPower();
        commandedPower = manualPower;
        limitCommandedPower();
        myArmController.set(ControlMode.PercentOutput, commandedPower);

        SmartDashboard.putNumber("XboxL_Y", Robot.xboxJoystick.getRawAxis(Xbox.LAxisY));
        SmartDashboard.putNumber("Arm Output %", commandedPower);
        SmartDashboard.putNumber("Arm_EncoderAngle", myArmEncoder.getDistance());
    }
}
