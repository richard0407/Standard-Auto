package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret.Turret;

public class LowballGoal extends Commandbase{
  private Turret turret;
  private double shootAngle;
  private boolean ballShot;
  private double lowGoalbig;
  private double lowGoalSmall;
  private double shotFinished;
  
  public LowballGoal(Turret turret, double shootAngle) {
    this.turret = turret;
    this.shootAngle = shootAngle;
    this.ballShot = false;
    this.lowGoalBig = 45.0;
    this.lowGoalSmall = 0.0;
    this.shotFinished = 1.0; 
    addRequirements(turret);
  }
  @Override
  public void execute(){
    if(shootAngle < lowGoalBig && shootAngle > lowGoalSmall){
      this.turret.shootPower(double Container.kLowBallToGoalSpeed);
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
