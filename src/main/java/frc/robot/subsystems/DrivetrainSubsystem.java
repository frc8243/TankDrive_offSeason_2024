// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  CANSparkMax leftFrontMotor = new CANSparkMax(4,MotorType.kBrushed);
  CANSparkMax leftBackMotor = new CANSparkMax(5,MotorType.kBrushed);
  CANSparkMax rightFrontMotor = new CANSparkMax(2,MotorType.kBrushed);
  CANSparkMax rightBackMotor = new CANSparkMax(3,MotorType.kBrushed);

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup (leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup (rightFrontMotor, rightBackMotor);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  public DrivetrainSubsystem() {
    leftFrontMotor.restoreFactoryDefaults();
    leftBackMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(false);
  }

  public void arcadeDrive(double fwd, double rot){
    differentialDrive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
