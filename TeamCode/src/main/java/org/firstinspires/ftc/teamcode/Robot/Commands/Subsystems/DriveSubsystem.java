package org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    public static double angles;
    public static double autoAngles = 0;
    MecanumDrive mecanumDrive;

    public DriveSubsystem(HardwareMap hardwareMap){
        super();

        MotorEx lfMotor = new MotorEx(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        MotorEx rfMotor = new MotorEx(hardwareMap, "rf", Motor.GoBILDA.RPM_435);
        MotorEx lrMotor = new MotorEx(hardwareMap, "lr", Motor.GoBILDA.RPM_435);
        MotorEx rrMotor = new MotorEx(hardwareMap, "rr", Motor.GoBILDA.RPM_435);

        lfMotor.setInverted(true);
        lrMotor.setInverted(true);

        lfMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rfMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        lrMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rrMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        this.mecanumDrive = new MecanumDrive(lfMotor,rfMotor,lrMotor,rrMotor);
    }

    public void driveFC(double strafeSpeed, double forwardSpeed, double turnSpeed){
        mecanumDrive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed,angles - autoAngles, true);
    }

    public void driveRC(double strafeSpeed, double forwardSpeed, double turnSpeed){
        mecanumDrive.driveRobotCentric(strafeSpeed,forwardSpeed,turnSpeed,true);
    }
}
