package org.firstinspires.ftc.teamcode.OpMode.Teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Robot.Commands.Drive.DriveRCCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.Drive.DriveRCDPadCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

@SuppressWarnings("unused")
public class TeleOP extends CommandOpMode {

    DriveSubsystem driveSubsystem;

    GamepadEx gamepadOne;

    DriveRCCommand driveCommand;
    public static double driveDpadSpeed = 0.5;


    @Override
    public void initialize(){

        driveSubsystem = new DriveSubsystem(hardwareMap);

        gamepadOne = new GamepadEx(gamepad1);


        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whileHeld(new DriveRCDPadCommand(driveSubsystem, driveDpadSpeed, 0, 0));
        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whileHeld(new DriveRCDPadCommand(driveSubsystem, -driveDpadSpeed, 0, 0));
        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_UP).whileHeld(new DriveRCDPadCommand(driveSubsystem, 0,-driveDpadSpeed,0));
        gamepadOne.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whileHeld(new DriveRCDPadCommand(driveSubsystem, 0 , driveDpadSpeed, 0));

        driveCommand = new DriveRCCommand(driveSubsystem, gamepadOne::getLeftX, gamepadOne::getLeftY, gamepadOne::getRightX);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}