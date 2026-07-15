package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Robot.RobotMotors;

public class LimelightTest extends OpMode {
    RobotMotors motors = new RobotMotors(hardwareMap);
    @Override
    public void init() {
        motors.limelight.pipelineSwitch(9);
    }
    @Override
    public void start(){
        motors.limelight.start();
    }
    @Override
    public void loop() {

    }
}
