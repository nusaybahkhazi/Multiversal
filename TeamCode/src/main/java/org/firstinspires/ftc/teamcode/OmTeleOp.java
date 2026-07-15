package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Robot.RobotMotors;
import org.firstinspires.ftc.teamcode.Util.MotorUtil;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;
@TeleOp
public class OmTeleOp extends OpMode {
    RobotMotors robotMotors = null;

    @Override
    public void init(){
        robotMotors = new RobotMotors(hardwareMap);
    }

    @Override
    public void loop(){
        robotMotors.
    }
}
