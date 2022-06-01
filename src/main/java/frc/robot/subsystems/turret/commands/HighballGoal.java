package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret.Turret;

public class HighballGoal extends Commandbase{
  private Turret turret;
  private double shootAngle;
  private double shootSpeed;
  private boolean ballShot;
  private double highGoal;
  
  public HighballGoal(Turret turret, double shootAngle, double shootSpeed) {
    this.turret = turret;
    this.shootAngle = shootAngle;
    this.shootSpeed = shootSpeed;
    this.ballShot = ballShot;
    this.highGoal = highGoal;
    addRequirements(turret);
  }
  @Override
  public void execute(){
    if(shootAngle == highGoal){
      this.turret.shootPower(double Container.kHighBallToGoalSpeed);
    }else{
      boolean ballShot = false;
    } 
  }
  @Override 
  public boolean isFinished(){
    if(shootSpeed != 0.0){
      boolean ballShot = true;
    }
    return ballShot;
  }
  @Override
  public void end(boolean interrupted){
    this.turret.shootPower(0.0);
  }
}
