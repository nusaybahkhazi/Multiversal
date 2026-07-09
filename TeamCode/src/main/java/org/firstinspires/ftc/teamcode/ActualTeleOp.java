import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.Robot;
public class ActualTeleOp extends OpMode {
    Robot robotmotors = new Robot();
    @Override
    public void init() {
        robotmotors.init(hardwareMap);
    }

    @Override
    public void loop() {
        robotmotors.setMotorSpeed(0.5);
    }
}
