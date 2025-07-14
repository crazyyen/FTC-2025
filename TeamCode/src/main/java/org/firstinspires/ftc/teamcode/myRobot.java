package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="myRobot")
public class myRobot extends LinearOpMode{

    private DcMotor left;
    private DcMotor right;
    private DcMotor arm;
    private TouchSensor touchSensor;

    @Override
    public void runOpMode() throws InterruptedException {

        arm = hardwareMap.get(DcMotor.class, "arm");
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        touchSensor = hardwareMap.get(TouchSensor.class, "touch sensor");

        left.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()){
            left.setPower(gamepad1.right_stick_y);
            right.setPower(gamepad1.left_stick_y);

            if (touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "Pressed");
            } else {
                telemetry.addData("Touch Sensor", "Not Pressed");
            }

            if (gamepad1.a) {
                arm.setPower(1);
            } else if (gamepad1.b) {
                arm.setPower(-1);
            } else {
                arm.setPower(0);
            }

            telemetry.update();
        }
    }
}
