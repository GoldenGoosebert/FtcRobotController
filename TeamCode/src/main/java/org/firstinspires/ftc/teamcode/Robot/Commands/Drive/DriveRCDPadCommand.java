package org.firstinspires.ftc.teamcode.Robot.Commands.Drive;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Commands.Subsystems.DriveSubsystem;
import java.util.function.Supplier;

public class DriveRCDPadCommand extends CommandBase {

    DriveSubsystem driveSubsystem;

    private final Supplier <Double> strafeSpeed;
    private final Supplier <Double> turnSpeed;
    private final Supplier <Double> forwardSpeed;

    public DriveRCDPadCommand(DriveSubsystem driveSubsystem,
                              Supplier <Double> strafeSpeed,
                              Supplier <Double> turnSpeed,
                              Supplier <Double> forwardSpeed){

        this.driveSubsystem = driveSubsystem;

        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;

        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize(){
        driveSubsystem.driveRC(strafeSpeed.get(),forwardSpeed.get(),turnSpeed.get());
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}