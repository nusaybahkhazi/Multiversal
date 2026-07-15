package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.RobotMotors;

@TeleOp
public class ActualTeleOp extends OpMode {
    RobotMotors motors;
    double forward, strafe, rotate;
    @Override
    public void init() {
        motors = new RobotMotors(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        motors.drive(forward, strafe, rotate);
    }
}
