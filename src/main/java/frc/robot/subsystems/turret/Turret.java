package frc.robot.subsystems.intake;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants; 

public class Turret extends SubsystemBase {
    private final static int kPort = 0;
    private final static double kP = 0;
    private final static double kI = 0;
    private final static double kD = 0;
    private final static double kFF = 0;
  
    private CANSparkMax Turret = new CANSparkMax(Turret.kport, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax Turret = new CANSparkMax(Turret.kport, CANSparkMaxLowLevel.MotorType.kBrushless);
    public RelativeEncoder TurretEncoder = Turret.getEncoder();
    private SparkMaxPIDController controller;


    public Turret(){
        this.angleMotor = new CANSparkMax(Turret.kPort, CANSparkMax.TurretType.kBrushless);
        this.speedMotor = new CANSparkMax(Turret.kPort, CANSparkMax.TurretType.kBrushless);
        
        this.angleEncoder = this.turret.getEncoder();

        this.speedController = this.turret.getPIDController();
        this.speedController.setP(Turret.kP); 
        this.speedController.setI(Turret.kI); 
        this.speedController.setD(Turret.kD); 
        this.speedController.setFF(Turret.kFF);

    }
    
    public void setAngle(double Container.kBallToGoalAngle){
      if(indexerPostion > 0){
        this.angleMotor.set(angleEncoder.getposition(double Container.kBallToGoalAngle))
      }else{
        indexerEncoder.getposition();
      }
    }
      
    public void shootPower(double shootball){
      this.speedMotor.set(double shootball);
    }
}
