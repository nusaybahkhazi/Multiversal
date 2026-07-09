package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Sai TeleOp")
public class SaiTeleOp extends OpMode {
    /**
     * This is called when the driver press INIT
     */
    @Override
    public void init() {

    }
    /**
     * This is called while OpMode is playing
     */
    @Override
    public void loop() {
        telemetry.addData("b", gamepad1.b);
    }

}
