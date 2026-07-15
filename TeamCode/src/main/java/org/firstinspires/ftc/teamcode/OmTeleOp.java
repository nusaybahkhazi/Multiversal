package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Robot.OmRobotMotors;
import org.firstinspires.ftc.teamcode.Util.DriveUtil;
import org.firstinspires.ftc.teamcode.Util.MathUtil;
import org.firstinspires.ftc.teamcode.Util.MotorUtil;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Om TeleOp", group = "Om")
public class OmTeleOp extends OpMode {

    // Ignore tiny resting-stick values so the robot doesn't creep.
    private static final double DEADBAND = 0.05;

    // Power multipliers: normal driving vs. precision "slow mode".
    private static final double NORMAL_SPEED = 1.0;
    private static final double SLOW_SPEED = 0.4;

    private OmRobotMotors robotMotors = null;
    private final MotorUtil motorUtil = new MotorUtil();

    @Override
    public void init() {
        robotMotors = new OmRobotMotors(hardwareMap);
        telemetry.addLine("Initialized. Press play to start.");
        telemetry.update();
    }

    @Override
    public void loop() {
        // --- Read driver inputs (gamepad1) ---
        // Stick Y is negated because pushing forward reports negative on the SDK.
        double drive  = MathUtil.applyDeadband(-gamepad1.left_stick_y, DEADBAND);
        double strafe = MathUtil.applyDeadband(gamepad1.left_stick_x, DEADBAND);
        double turn   = MathUtil.applyDeadband(gamepad1.right_stick_x, DEADBAND);

        // Squaring gives finer control near center while keeping full power at the edges.
        drive  = MathUtil.squareInput(drive);
        strafe = MathUtil.squareInput(strafe);
        turn   = MathUtil.squareInput(turn);

        // Hold right bumper (or the right trigger) for precision slow mode.
        boolean slowMode = gamepad1.right_bumper || gamepad1.right_trigger > 0.5;
        double speedFactor = slowMode ? SLOW_SPEED : NORMAL_SPEED;

        // --- Compute wheel powers ---
        double[] powers = DriveUtil.mecanum(drive, strafe, turn);
        DriveUtil.scale(powers, speedFactor);

        // --- Send to hardware (powers are clamped inside setPowers) ---
        motorUtil.setPowers(
                robotMotors.frontLeftDrive, robotMotors.frontRightDrive,
                robotMotors.backLeftDrive, robotMotors.backRightDrive,
                powers);

        // --- Telemetry ---
        telemetry.addData("Mode", slowMode ? "SLOW" : "NORMAL");
        telemetry.addData("Drive/Strafe/Turn", "%.2f / %.2f / %.2f", drive, strafe, turn);
        telemetry.addData("FL / FR", "%.2f / %.2f", powers[0], powers[1]);
        telemetry.addData("BL / BR", "%.2f / %.2f", powers[2], powers[3]);
        telemetry.update();
    }

    @Override
    public void stop() {
        // Safety: make sure the drivetrain is stopped when the op mode ends.
        if (robotMotors != null) {
            motorUtil.stop(
                    robotMotors.frontLeftDrive, robotMotors.frontRightDrive,
                    robotMotors.backLeftDrive, robotMotors.backRightDrive);
        }
    }
}
