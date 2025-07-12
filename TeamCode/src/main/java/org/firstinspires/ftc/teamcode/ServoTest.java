package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Servo test", group = "testing")
public class ServoTest extends LinearOpMode {

    private Servo servo0;

    @Override
    public void runOpMode() throws InterruptedException {
        servo0 = hardwareMap.get(Servo.class, "servo0");
        waitForStart();
        while (opModeIsActive()){
            if(gamepad1.a){
                moveServoNeutral();
            } else if (gamepad1.b) {
                servo0.setPosition(0);
            } else if (gamepad1.x){
                servo0.setPosition(1);
            }
        }
    }

    public void moveServoNeutral() {
        servo0.setPosition(0.5);
    }
}
