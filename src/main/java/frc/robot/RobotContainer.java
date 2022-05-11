package frc.robot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.util.XboxController;

public class RobotContainer {
    private final XboxController driverController = new XboxController(0);
    private final XboxController manipulatorController = new XboxController(1);

    public final Drivetrain drivetrain = new Drivetrain();

    public RobotContainer(){
        drivetrain.setDefaultCommand(new RunCommand(() -> {
            drivetrain.drive(
                driverController.getAxisValue(XboxController.Axis.LEFT_Y),
                driverController.getAxisValue(XboxController.Axis.RIGHT_X)
            );
        }, drivetrain));
    }
}
