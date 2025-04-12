// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Consumer extends SubsystemBase {
  private Victor motor;

  /** Creates a new Consumer. */
  public Consumer() {

    motor = new Victor(RobotMap.CONSUMER);
  }

  @Override
  public void periodic() {}

  public void setPower(double speed) {
    motor.set(speed);
  }

  public void stop() {
    motor.stopMotor();
  }
}
