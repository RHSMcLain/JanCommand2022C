// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;


import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;
  

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  boolean isRunning = false;
  long startTime = 0;
  double degreesToTurn = 0.0;
  double startAngle = 0.0;
  public TurnCommand(DriveSubsystem subsystem, double angle) {
    //constructor: runs when you declare it
    m_subsystem = subsystem;
    degreesToTurn = angle;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //sometimes that's connected to when you run it
    //set the start time
    // startTime = //get time millis
    startAngle = m_subsystem.getAngle();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //This pattern makes sure your initialization work happends
    // with the first running of execute()
    if (!isRunning){
      startTime = System.currentTimeMillis();
      isRunning = true;

    }
    m_subsystem.drive(0.5,0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    ///example: if getTimeMillis() - startTime > 2000 then return true else return false
    // if (System.currentTimeMillis() - startTime > 2000){
    //   return true;
    // }
    // else{
    //   return false;
    // }
    return m_subsystem.getAngle() >= startAngle + degreesToTurn;

  }
}
