package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain.Drivetrain;

public class TurnByAngle extends CommandBase {
    private Drivetrain drivetrain;

    private double desiredHeading;

    public TurnByAngle(Drivetrain drivetrain, double angle){
        this.drivetrain = drivetrain;

        this.desiredHeading = drivetrain.getHeading() + angle;

        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        double error = this.desiredHeading - this.drivetrain.getHeading();
        this.drivetrain.drive(0, Math.signum(error) * Constants.Drivetrain.kIterativeTurningAdjustment);
    }

    @Override
    public boolean isFinished(){
        double error = this.desiredHeading - this.drivetrain.getHeading();

        return Math.abs(error) < Constants.Drivetrain.kAcceptableTurningError;
    }

    @Override
    public void end(boolean interrupted){
        this.drivetrain.drive(0, 0);
    }
}
