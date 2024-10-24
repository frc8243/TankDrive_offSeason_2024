// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
  private final CANdle candle;

  //private RollerClawIO rollerClawIO;
  private DigitalInput ledSwitch = new DigitalInput(0);
  private static boolean notePresent = false;

  /** Creates a new LEDSubsytem. */
  public LEDSubsystem() {
    candle = new CANdle(10); 
    CANdleConfiguration ConfigAll = new CANdleConfiguration();
    //ConfigAll.stripType = LEDStripType.RGB;
    candle.configAllSettings(ConfigAll);
  }
  public void setRed() {
    candle.setLEDs(255,0,0);
  }
  public void setBlue(){
    candle.setLEDs(64,224,208); 
  }

  public void setPurple(){
    candle.setLEDs(148, 0, 211);
  }

  public void setGreen(){
    candle.setLEDs(0,255,0);
  }

  public void turnOff (){
    candle.setLEDs(0, 0, 0);
  }
  @Override
  public void periodic() {
    //SmartDashboard.putNumber("Switch Speed", rollerClawIO.getRollerClawSpeed());
    SmartDashboard.putBoolean("Switch on", notePresent);
    if (ledSwitch.get()){
      notePresent = true;
    } else {
      notePresent = false;
    }
    // This method will be called once per scheduler run
  }
}
