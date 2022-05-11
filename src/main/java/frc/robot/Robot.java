// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.StandardAuto;

public class Robot extends TimedRobot {
  private final RobotContainer robotContainer = new RobotContainer();

  private Command autonomousCommand;

  /** This function is called when the robot is enabled. */
  @Override
  public void robotInit() {
    setNetworkTablesFlushEnabled(true);
  }

  /** This function is called periodically. */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called when the autonomous is enabled. */
  @Override
  public void autonomousInit() {
    new StandardAuto(this.robotContainer.drivetrain).schedule();

    // SendableChooser<Command> autonomousCommandChooser = new SendableChooser<>();

    // autonomousCommandChooser.addOption("Standard", new StandardAuto(this.robotContainer.drivetrain));

    // autonomousCommand = autonomousCommandChooser.getSelected();
    // autonomousCommandChooser.close();

    // if(autonomousCommand != null){
    //   autonomousCommand.schedule();
    // }
  }

  /** This function is called periodically during autonomous control. */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    if(autonomousCommand != null){
      autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
