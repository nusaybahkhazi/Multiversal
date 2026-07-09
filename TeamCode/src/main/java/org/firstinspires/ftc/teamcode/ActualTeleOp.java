package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Robot.RobotMotors;

public class ActualTeleOp extends OpMode {
    public RobotMotors robotMotors;
    @Override
    public void init() {
        robotMotors = new RobotMotors(hardwareMap);
    }

    @Override
    public void loop() {

    }
}
