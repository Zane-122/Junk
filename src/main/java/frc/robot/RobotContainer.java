// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Collect;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Consumer;
import frc.robot.subsystems.Tank;
import frc.thunder.LightningContainer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer extends LightningContainer{
  private Tank tank;
  private Consumer consumer;

  private final CommandXboxController driver =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    
  }

  @Override
  protected void initializeSubsystems() {
    tank = new Tank();
    consumer = new Consumer();
  }

  @Override
  protected void initializeNamedCommands() {}

  @Override
  protected void configureButtonBindings() {

  }

  @Override
  protected void configureDefaultCommands() {
    new Drive(tank, 
      () -> (driver.getLeftTriggerAxis()), 
      () -> (driver.getRightTriggerAxis()));

    new Collect(consumer, () -> (driver.getRightTriggerAxis() - driver.getLeftTriggerAxis()));
  }

  @Override
  protected Command getAutonomousCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAutonomousCommand'");
  }

}
