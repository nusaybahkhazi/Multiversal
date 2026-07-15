package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Robot.RobotMotors;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;

public class OmTeleOp {
    private DcMotor motor;

    public void init(HardwareMap haMap){
        motor = haMap.get(DcMotor.class, "front_left_drive");
        motor.setMode();
    }
}
