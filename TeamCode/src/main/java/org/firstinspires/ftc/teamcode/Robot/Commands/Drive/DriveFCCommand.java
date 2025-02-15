package org.firstinspires.ftc.teamcode.Robot.Commands.Drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;

@SuppressWarnings("unused")
public class DriveFCCommand extends CommandBase {


    DriveSubsystem drivesubsystem;
    double strafeSpeed;
    double turnSpeed;
    double forwardSpeed;
    double angle;

    public DriveFCCommand(DriveSubsystem drivesubsystem, double strafeSpeed, double forwardSpeed, double turnSpeed, double angle){

        this.drivesubsystem = drivesubsystem;
        this.strafeSpeed = strafeSpeed;
        this.turnSpeed = turnSpeed;
        this.forwardSpeed = forwardSpeed;
        this.angle = angle;

        addRequirements(drivesubsystem);
    }

    @Override
    public void execute(){
        drivesubsystem.driveFC(strafeSpeed,forwardSpeed,turnSpeed, angle);
    }

}