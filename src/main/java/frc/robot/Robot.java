// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.thunder.LightningContainer;
import frc.thunder.LightningRobot;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends LightningRobot {
  private RobotContainer container;

  public Robot() {
    super(new RobotContainer());
  }

  @Override
  public void robotInit() {
    super.robotInit();
  }

  @Override
  public void autonomousInit() {
    super.autonomousInit();
  }

  @Override
  public void teleopInit() {
    super.teleopInit();
  }

  @Override
  public void disabledInit() {
    super.disabledInit();
  }

  @Override
  public void disabledPeriodic() {
    super.disabledPeriodic();
  }
}
