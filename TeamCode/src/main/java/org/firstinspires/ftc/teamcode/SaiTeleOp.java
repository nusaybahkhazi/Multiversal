package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

<<<<<<< HEAD
=======

>>>>>>> 745964e59963032f4f0488a91064fe6d9b76ed6c
@TeleOp(name = "Sai TeleOp")
public class SaiTeleOp extends OpMode {
    /**
     * This is called when the driver press INIT
     */
    @Override
    public void init() {

    }
<<<<<<< HEAD
    /**
     * This is called while OpMode is playing
     */
    @Override
    public void loop() {

    }
=======

    double squareInputWithSign(double input) {
        double output = input * input

        if (input < 0) {
            output *= -1
        }
        return output;
    }

    public class RobotLocationPractice {
        double angle;
    }

    // constructor method
    public RobotLocationPractice(double angle) {
        this.angle = angle
    }

    public double getHeading() {
        double angle = this.angle // copy the angle of imu
        while (angle > 180) {
            angle -= 360; // subtract until in target range
        }
        while (angle <= -180) {
            angle += 360; // add until in target range
        }
        return angle; // return normalized value
    }

    
    @Override
    public void loop() {
        double difference = gamepad1.left_joy_stick_x - gamepad1.right_joy_stick_x;
        telemetry.addData("differences", difference);
        telemetry.addData("b", gamepad1.b);
        double sum_of_triggers = gamepad1.right_trigger + gamepad1.gamepad1.left_trigger
        telemetry.addData("sum of triggers", sum_of_triggers); 
        boolean isPressed = gamepad1.a
        if (gamepad1.a) {
            telemetry.addData("A Button State", "Pressed");
        } else {
            telemetry.addData("A Button State", "Not Pressed");
        }
        double leftY = gamepad1.left_joy_stick_y;
        if (leftY < 0.1 && leftY > -0.1) {
            telemetry.addData("Left Stick Status: ", "In Dead Zone");
        } 
        else {
            telemetry.addData("Left Stick Status: ", "Not In Dead Zone");
        }
        // --------
        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Left Stick Normal", yAxis);
        yAxis = squareInputWithSign(yAxis)
        telemetry.addData("Left Stick Modified", yAxis);

        
>>>>>>> 745964e59963032f4f0488a91064fe6d9b76ed6c
}
