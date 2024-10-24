// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends CommandBase {
  private final MotorSubsystem motorSubsystem;
  private final double speed;
  /** Creates a new MotorCommand. */
  public MotorCommand(MotorSubsystem subsystem, double speed) {
    motorSubsystem = subsystem;
    this.speed = speed;
    addRequirements(motorSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorSubsystem.spin(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; // runs until interrupted
  }
}
