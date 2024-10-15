// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveWithJoystickCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MotorCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.LEDSubsystem;


public class RobotContainer {
  private final MotorSubsystem m_MotorSubsystem = new MotorSubsystem(12);
  private final LEDSubsystem ledSubsystem = new LEDSubsystem();
  private final XboxController xboxcontroller = new XboxController(0);
  private final DrivetrainSubsystem drivetrainsubsystem = new DrivetrainSubsystem();
  // FIXXXXX THIS!!!! CODE LINES 9 + 10 




 
 

  public final static CommandXboxController controller = new CommandXboxController(0);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureButtonBindings();
    SmartDashboard.putData("LEDS",ledSubsystem);
    drivetrainsubsystem.setDefaultCommand(new DriveWithJoystickCommand(drivetrainsubsystem));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureButtonBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    controller.a().onTrue(new InstantCommand(()->m_MotorSubsystem.stop()));
    controller.x().onTrue(new InstantCommand(()->ledSubsystem.setBlue()));
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    
    controller.b().onTrue(new InstantCommand(()->m_MotorSubsystem.spin(.5)));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(new ExampleSubsystem());
  }
}
