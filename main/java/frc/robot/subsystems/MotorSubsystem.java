// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class MotorSubsystem extends SubsystemBase {
  private final CANSparkMax motor;

  public MotorSubsystem(int motorPort) {
    motor = new CANSparkMax(motorPort, MotorType.kBrushless);
  }

 
  public void spin (double speed) {
    motor.set(speed);
    // This method will be called once per scheduler run
  }

public void stop() {
  motor.set(0);
}
}
