package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="myRobot")
public class myRobot extends LinearOpMode{

    private DcMotor left;
    private DcMotor right;
    private DcMotor arm;

    @Override
    public void runOpMode() throws InterruptedException {

        arm = hardwareMap.get(DcMotor.class, "arm");

        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()){
            left.setPower(gamepad1.right_stick_y);
            right.setPower(gamepad1.left_stick_y);

            if (gamepad1.a) {
                arm.setPower(1);
            }
            else if (gamepad1.b) {
                arm.setPower(-1);
            }
            else {
                arm.setPower(0);
            }
        }
    }
}
