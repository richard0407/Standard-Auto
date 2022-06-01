package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret.Turret;

public class HighballGoal extends Commandbase{
  private Turret turret;
  private double shootAngle;
  private double shootSpeed;
  
  public HighballGoal(Turret turret, double shootAngle, double shootSpeed) {
    this.turret = turret;
    this.shootAngle = shootAngle;
    this.shootSpeed = shootAngle;
    addRequirements(turret);
  }
  @Override
  public void execute(){
    if(shootAngle == highgoal){
      this.speedMotor.set(double Container.kHighBallToGoalSpeed);
    } 
  }
  
}
