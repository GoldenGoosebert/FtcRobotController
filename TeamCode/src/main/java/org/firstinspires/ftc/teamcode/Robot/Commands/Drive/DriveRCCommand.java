package org.firstinspires.ftc.teamcode.Robot.Commands.Drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

@SuppressWarnings("unused")
public class DriveRCCommand extends CommandBase {

    DoubleSupplier strafeSpeed;
    DoubleSupplier turnSpeed;
    DoubleSupplier forwardSpeed;

    DriveSubsystem drivesubsystem;

    public DriveRCCommand(DriveSubsystem drivesubsystem, DoubleSupplier strafeSpeed, DoubleSupplier forwardSpeed, DoubleSupplier turnSpeed){

        this.drivesubsystem = drivesubsystem;

        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;

        addRequirements(drivesubsystem);
    }

    @Override
    public void execute(){
        drivesubsystem.driveRC(-strafeSpeed.getAsDouble(),-turnSpeed.getAsDouble(),-forwardSpeed.getAsDouble());
    }
}