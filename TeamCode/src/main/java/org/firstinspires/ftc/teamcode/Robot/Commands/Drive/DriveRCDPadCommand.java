package org.firstinspires.ftc.teamcode.Robot.Commands.Drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;

public class DriveRCDPadCommand extends CommandBase {

    DriveSubsystem driveSubsystem;
    double strafeSpeed;
    double turnSpeed;
    double forwardSpeed;

    public DriveRCDPadCommand(DriveSubsystem driveSubsystem, double strafeSpeed, double turnSpeed, double forwardSpeed){
        this.driveSubsystem = driveSubsystem;

        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;

        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize(){
        driveSubsystem.driveRC(strafeSpeed,forwardSpeed,turnSpeed);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}