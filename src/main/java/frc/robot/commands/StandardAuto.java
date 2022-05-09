package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class StandardAuto extends SequentialCommandGroup {
    // put subsystem definitions here

    public StandardAuto(/*  put subsystems arguments here  */){

        addCommands(/*  put your procedure of commands here  */);

        addRequirements(/*  put subsystems here  */);

    }

    /*  runs once the command has finished/been interrupted  */
    @Override
    public void end(boolean interrupted){
        
    }
}
