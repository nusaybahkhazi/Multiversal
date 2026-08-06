package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Robot.RobotMotors;
import org.firstinspires.ftc.teamcode.Robot.IMUtest;

@TeleOp
public class ActualTeleOp extends OpMode {
    RobotMotors motors;
    double forward, strafe, rotate;
    IMUtest bench = new IMUtest();
    @Override
    public void init() {
        motors = new RobotMotors(hardwareMap);
        bench.init(hardwareMap);
        //motors.setServoPosition(0.5);
    }

    @Override
    public void loop() {
        telemetry.addData("Heading", bench.getHeading(AngleUnit.DEGREES));
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        motors.drive(forward, strafe, rotate);
       /* if (gamepad1.a) {
            motors.setServoPosition(0.84);
        }
        else {
            motors.setServoPosition(0.23);
        }*/
        double heading = bench.getHeading(AngleUnit.RADIANS);
        if (heading < .5 && heading > -.5) {
            motors.setServoPosition(.75);
        }
        else {
            motors.setServoPosition(.25);
        }
    }
}
