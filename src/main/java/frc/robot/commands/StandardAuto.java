package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.commands.TurnByAngle;
import frc.robot.subsystems.drivetrain.commands.TurnToAngle;

public class StandardAuto extends SequentialCommandGroup {
    public StandardAuto(Drivetrain drivetrain){
        addCommands(
            // Initialize by turning to start heading
            // Turn robot to 0 degrees
            new TurnToAngle(drivetrain, 0.0),

            // First iteration: 0 to 90 degrees
            // Drive robot forward at a safe speed for for 2 seconds
            new ParallelRaceGroup(
                new RunCommand(() -> {
                    drivetrain.drive(Constants.Drivetrain.kSafeForwardThrottle, 0);
                }, drivetrain),
                new WaitCommand(2.0)
            ),
            // Turn robot by 90 degrees
            new TurnByAngle(drivetrain, 90.0),

            // Second iteration: 90 to 180 degrees
            // Drive robot forward at a safe speed for for 2 seconds
            new ParallelRaceGroup(
                new RunCommand(() -> {
                    drivetrain.drive(Constants.Drivetrain.kSafeForwardThrottle, 0);
                }, drivetrain),
                new WaitCommand(2.0)
            ),
            // Turn robot by 90 degrees
            new TurnByAngle(drivetrain, 90.0),

            // Third iteration: 180 to 270 degrees
            // Drive robot forward at a safe speed for for 2 seconds
            new ParallelRaceGroup(
                new RunCommand(() -> {
                    drivetrain.drive(Constants.Drivetrain.kSafeForwardThrottle, 0);
                }, drivetrain),
                new WaitCommand(2.0)
            ),
            // Turn robot by 90 degrees
            new TurnByAngle(drivetrain, 90.0)
        );

        addRequirements(drivetrain);
        
        addCommands(
            new IntakeBall(intake,nPower,true);
            new WaitCommand(2.0);
            new OuttakeBall(intake,nPower,true);
            )
        addRequirements(intake);
        
        addCommands(
            new HighballGoal(turret,shootAngle);
            new LowballGoal(turret,shootAngle);
            new WaitCommand(2.0);
            )
        addRequirements(turret);
    }
}
