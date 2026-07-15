package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Robot.RobotMotors;
import org.firstinspires.ftc.teamcode.Util.DriveUtil;
import org.firstinspires.ftc.teamcode.Util.MotorUtil;
import org.firstinspires.ftc.teamcode.Util.StopWatch;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * A simple time-based autonomous for Om's mecanum robot.
 *
 * <p>Because {@link RobotMotors} runs the drive motors in RUN_WITHOUT_ENCODER,
 * this routine drives for fixed amounts of time rather than to encoder targets.
 * Tune the DURATION and POWER constants on the real robot.
 */
@Autonomous(name = "Om Auto", group = "Om")
public class OmAuto extends LinearOpMode {

    // Drive powers (0..1). Kept modest so moves stay controllable.
    private static final double DRIVE_POWER  = 0.5;
    private static final double STRAFE_POWER = 0.5;
    private static final double TURN_POWER   = 0.4;

    // How long each move runs, in seconds. Tune these for your field.
    private static final double FORWARD_TIME = 1.5;
    private static final double STRAFE_TIME  = 1.0;
    private static final double TURN_TIME    = 0.7;

    private RobotMotors robotMotors = null;
    private final MotorUtil motorUtil = new MotorUtil();
    private final StopWatch timer = new StopWatch();

    @Override
    public void runOpMode() {
        robotMotors = new RobotMotors(hardwareMap);

        telemetry.addLine("Om Auto ready. Press play.");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        // --- Autonomous sequence ---
        driveForTime(DRIVE_POWER, 0.0, 0.0, FORWARD_TIME, "Forward");
        driveForTime(0.0, STRAFE_POWER, 0.0, STRAFE_TIME, "Strafe right");
        driveForTime(0.0, 0.0, TURN_POWER, TURN_TIME, "Turn clockwise");

        stopDrive();
        telemetry.addLine("Auto complete.");
        telemetry.update();
    }

    /**
     * Drives with the given mecanum inputs for a fixed number of seconds, then
     * stops. Respects op-mode interruption so pressing STOP ends the move early.
     *
     * @param drive   forward/back power (+ forward)
     * @param strafe  left/right power (+ right)
     * @param turn    rotation power (+ clockwise)
     * @param seconds how long to run the move
     * @param label   telemetry label for this step
     */
    private void driveForTime(double drive, double strafe, double turn,
                              double seconds, String label) {
        double[] powers = DriveUtil.mecanum(drive, strafe, turn);
        timer.reset();

        while (opModeIsActive() && !timer.hasElapsed(seconds)) {
            motorUtil.setPowers(
                    robotMotors.frontLeftDrive, robotMotors.frontRightDrive,
                    robotMotors.backLeftDrive, robotMotors.backRightDrive,
                    powers);

            telemetry.addData("Step", label);
            telemetry.addData("Elapsed", "%.2f / %.2f s", timer.seconds(), seconds);
            telemetry.update();
        }

        stopDrive();
    }

    /** Cuts power to all four drive motors. */
    private void stopDrive() {
        motorUtil.stop(
                robotMotors.frontLeftDrive, robotMotors.frontRightDrive,
                robotMotors.backLeftDrive, robotMotors.backRightDrive);
    }
}
