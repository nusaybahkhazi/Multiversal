package org.firstinspires.ftc.teamcode.Robot;

//import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.IMU;

public class RobotMotors {
    public DcMotorEx frontLeftDrive = null;
    public DcMotorEx frontRightDrive = null;
    public DcMotorEx backLeftDrive = null;
    public DcMotorEx backRightDrive = null;
    public DcMotorEx intakeMotor = null;
    public DcMotorEx flywheelMotor = null;
    public Servo servo = null;
    public Limelight3A limelight;
    public IMU imu;
    public RobotConfigReader reader = new RobotConfigReader();

    public RobotMotors(HardwareMap hardwareMap) {
        reader.initConfig();
        frontLeftDrive = hardwareMap.get(DcMotorEx.class, reader.frontLeftDriveName);
        frontRightDrive = hardwareMap.get(DcMotorEx.class, reader.frontRightDriveName);
        backLeftDrive = hardwareMap.get(DcMotorEx.class, reader.backLeftDriveName);
        backRightDrive = hardwareMap.get(DcMotorEx.class, reader.backRightDriveName);
        servo = hardwareMap.get(Servo.class, reader.servoName);
        limelight = hardwareMap.get(Limelight3A.class, reader.limelightName);
        intakeMotor = hardwareMap.get(DcMotorEx.class, reader.intakeMotorName);
        imu = hardwareMap.get(IMU.class, reader.imuName);
        flywheelMotor = hardwareMap.get(DcMotorEx.class, reader.flywheelMotorName);

        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        servo.setDirection(Servo.Direction.FORWARD);

        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
        public void drive(double forward, double strafe, double rotate) {
            double frontLeftPower = forward + strafe + rotate;
            double backLeftPower = forward - strafe + rotate;
            double frontRightPower = forward - strafe - rotate;
            double backRightPower = forward + strafe - rotate;

            double maxPower = 1.0;
            double maxSpeed = 0.7;

            maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
            maxPower = Math.max(maxPower, Math.abs(backLeftPower));
            maxPower = Math.max(maxPower, Math.abs(frontRightPower));
            maxPower = Math.max(maxPower, Math.abs(backRightPower));

            frontLeftDrive.setPower(maxSpeed * (frontLeftPower / maxPower));
            backLeftDrive.setPower(maxSpeed * (backLeftPower / maxPower));
            frontRightDrive.setPower(maxSpeed * (frontRightPower / maxPower));
            backRightDrive.setPower(maxSpeed * (backRightPower / maxPower));
        }
        public void setServoPosition(double angle) {
            servo.setPosition(angle);
        }

        public void intake(){

        }

        public void launch(){

        }

    }


