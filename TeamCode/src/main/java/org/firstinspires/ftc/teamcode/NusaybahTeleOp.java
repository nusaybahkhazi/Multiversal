package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Nusaybah TeleOp")
public class NusaybahTeleOp extends OpMode {
    /**
     * This is called when the driver press INIT
     */
    @Override
    public void init() {

    }
        double squareInputWithSign(double input){
            double output = input * input;

            if (input <0){
                output *= -1;
            }
            return output;
//        }
//        public class RobotLocationPractice{
//            double angle;
//        }
//        public RobotLocationPractice(double angle){
//            this.angle = angle;
//        }
//        public double getHeading(){
//            double angle = this.angle;
//            while(angle >180){
//                angle -= 360;
//            }
//            while(angle <= -180){
//                angle += 360;
//            }
//            return angle;
        }
        /**
     * This is called while OpMode is playing
     */
    @Override
    public void loop() {
        double leftY = gamepad1.left_stick_y;
        boolean aButton = gamepad1.a;
        double DiffXJoysticks = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double SumTriggers = gamepad1.left_trigger + gamepad1.right_trigger;
        telemetry.addData("b button", gamepad1.b);
        telemetry.addData("difference x", DiffXJoysticks);
        telemetry.addData("sum of triggers", SumTriggers);
        if(leftY < 0.1 && leftY > -0.1){
            telemetry.addData("left stick", "dead zone");
        }
        if(gamepad1.a){
            telemetry.addData("A Button", "pressed");
        }
            telemetry.addData("A Button State", aButton);
        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Left Stick Normal", yAxis);
        yAxis = squareInputWithSign(yAxis);
        telemetry.addData("Left Stick Modified", yAxis);
    }

}
