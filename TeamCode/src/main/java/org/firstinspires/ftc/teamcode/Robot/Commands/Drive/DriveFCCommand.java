package org.firstinspires.ftc.teamcode.Robot.Commands.Drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DriveFCCommand extends CommandBase {


    private final DriveSubsystem drivesubsystem;

    private final Supplier <Double> strafeSpeed;
    private final Supplier <Double> turnSpeed;
    private final Supplier <Double> forwardSpeed;
    public DriveFCCommand(DriveSubsystem drivesubsystem,
                          Supplier <Double> strafeSpeed,
                          Supplier <Double> forwardSpeed,
                          Supplier <Double> turnSpeed){

        this.drivesubsystem = drivesubsystem;
        this.strafeSpeed = strafeSpeed;
        this.turnSpeed = turnSpeed;
        this.forwardSpeed = forwardSpeed;

        addRequirements(drivesubsystem);
    }

    @Override
    public void execute(){
        drivesubsystem.driveFC(strafeSpeed.get(), turnSpeed.get(), forwardSpeed.get());
    }

}