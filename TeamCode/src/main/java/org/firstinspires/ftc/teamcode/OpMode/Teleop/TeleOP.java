package org.firstinspires.ftc.teamcode.OpMode.Teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Robot.Commands.Drive.DriveFCCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.Drive.DriveRCDPadCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

@SuppressWarnings("unused")
public class TeleOP extends CommandOpMode {

    DriveSubsystem driveSubsystem;
    double turnPower = 0;

    GamepadEx gamepadOne;

    DriveFCCommand driveCommand;
    public static double driveDpadSpeed = 0.5;


    @Override
    public void initialize(){

        driveSubsystem = new DriveSubsystem(hardwareMap);

        gamepadOne = new GamepadEx(gamepad1);

        IMU imu;

        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot orientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.RIGHT, RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD);
        imu.initialize(new IMU.Parameters(orientation));
        imu.resetYaw();

        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whileHeld(new DriveRCDPadCommand(driveSubsystem, () -> driveDpadSpeed, () -> 0d, () -> -turnPower));
        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whileHeld(new DriveRCDPadCommand(driveSubsystem, () -> -driveDpadSpeed, () -> 0d, () -> -turnPower));
        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_UP).whileHeld(new DriveRCDPadCommand(driveSubsystem, () -> 0d, () -> -driveDpadSpeed, () -> -turnPower));
        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whileHeld(new DriveRCDPadCommand(driveSubsystem, () -> 0d, () -> -driveDpadSpeed, () -> - turnPower));

        driveSubsystem.setDefaultCommand(driveCommand);
        driveCommand = new DriveFCCommand(driveSubsystem,gamepadOne::getLeftX,gamepadOne::getLeftY, () -> -turnPower);

        gamepadOne.getGamepadButton(GamepadKeys.Button.A).whenPressed(new InstantCommand( () -> {
            DriveSubsystem.autoAngles = 0;
            imu.initialize(new IMU.Parameters(orientation));
            imu.resetYaw();
        }));
    }
}