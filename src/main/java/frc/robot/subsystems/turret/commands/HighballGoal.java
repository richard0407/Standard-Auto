package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret.Turret;

public class HighballGoal extends Commandbase{
  private Turret turret;
  private double shootAngle;
  private boolean ballShot;
  private double highGoalbig;
  private double highGoalSmall;
  private double shotFinished;
  
  public HighballGoal(Turret turret, double shootAngle) {
    this.turret = turret;
    this.shootAngle = shootAngle;
    this.ballShot = false;
    this.highGoalBig = 90.0;
    this.highGoalSmall = 45.0;
    this.shotFinished = 1.0; 
    addRequirements(turret);
  }
  @Override
  public void execute(){
    if(shootAngle < highGoalBig && shootAngle > highGoalSmall){
      this.turret.shootPower(double Container.kHighBallToGoalSpeed);
    }else{
      boolean ballShot = true;
    } 
  }
  @Override 
  public boolean isFinished(){
    if(shootFinished != 0.0){
      boolean ballShot = false;
    }
    return ballShot;
  }
  @Override
  public void end(boolean interrupted){
    this.turret.shootPower(0.0);
  }
}
