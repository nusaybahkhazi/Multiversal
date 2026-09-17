package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.Robot.AprilTag;
import org.firstinspires.ftc.teamcode.Robot.RobotMotors;
import org.firstinspires.ftc.teamcode.Robot.IMUtest;

@TeleOp
public class ActualTeleOp extends OpMode {
    AprilTag aprilTag = new AprilTag();
    RobotMotors motors;
    double forward, strafe, rotate;
    IMUtest bench = new IMUtest();
    @Override
    public void init() {
        motors = new RobotMotors(hardwareMap);
        bench.init(hardwareMap);
        aprilTag.init(hardwareMap);
        aprilTag.start();
        //motors.setServoPosition(0.5);
    }

    @Override
    public void loop() {
        // Driver Controls
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
        // IMU Display thingy
        double heading = bench.getHeading(AngleUnit.RADIANS);
        if (heading < .5 && heading > -.5) {
            motors.setServoPosition(.75);
        }
        else {
            motors.setServoPosition(.25);
        }
        //limelight
        aprilTag.loop();
        telemetry.addData("Target X", aprilTag.getTx());
        telemetry.addData("Target Y", aprilTag.getTy());
        telemetry.addData("Target A", aprilTag.getTa());


    }
}
