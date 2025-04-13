// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Collect;
import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Consumer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tank;
import frc.thunder.LightningContainer;

import java.util.stream.Collector;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer extends LightningContainer {
  private Tank tank;
  private Consumer consumer;
  private Shooter shooter;

  private XboxController driver;

  @Override
  protected void initializeSubsystems() {
    tank = new Tank();
    consumer = new Consumer();
    shooter = new Shooter();

    driver = new XboxController(0);
  }

  @Override
  protected void initializeNamedCommands() {}

  @Override
  protected void configureButtonBindings() {
    new Trigger(driver::getAButton).whileTrue(new Shoot(shooter, () -> 0.8));
  }

  @Override
  protected void configureDefaultCommands() {
    tank.setDefaultCommand(
      new Drive(tank, 
        () -> (-driver.getLeftY()), 
        () -> (driver.getRightY()))
      );

    consumer.setDefaultCommand(
      new Collect(consumer, 
        () -> (driver.getRightTriggerAxis() - driver.getLeftTriggerAxis())));
  }

  @Override
  protected Command getAutonomousCommand() {
    return null; // I ain't doing allat
  }

}
