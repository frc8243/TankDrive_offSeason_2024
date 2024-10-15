// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
  private final CANdle candle;
  /** Creates a new LEDSubsytem. */
  public LEDSubsystem() {
    candle = new CANdle(0); 
    CANdleConfiguration ConfigAll = new CANdleConfiguration();
    ConfigAll.stripType = LEDStripType.RGB;
  }
  public void setRed() {
    candle.setLEDs(255,0,0);
  }
  public void setBlue(){
    candle.setLEDs(0,0,255);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
