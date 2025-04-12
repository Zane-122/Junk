// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Constants.RobotMap;

public class Shooter extends SubsystemBase {
  public Victor motor;
  /** Creates a new Shooter. */
  public Shooter() {
    motor = new Victor(RobotMap.SHOOTER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
