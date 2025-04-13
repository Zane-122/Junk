// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Constants.RobotMap;
import frc.thunder.LightningContainer;
import frc.thunder.shuffleboard.LightningShuffleboard;

public class Shooter extends SubsystemBase {
  public Victor motor;

  boolean coast = true;

  double kp;

  double currentMotorPower;
  double targetMotorPower;
  double setMotorPower;
  double motorPower;

  /** Creates a new Shooter. */
  public Shooter() {
    motor = new Victor(RobotMap.SHOOTER);
  }

  @Override
  public void periodic() {
    kp = LightningShuffleboard.getDouble("Shooter", "kP", 0.03);

    LightningShuffleboard.setDouble("Shooter", "motor power", motorPower);

    if (coast) {
      targetMotorPower = -0.2;
    } else {
      targetMotorPower = setMotorPower;
    }
  
    if (motorPower < 1 && motorPower > -1) {
      motorPower += (targetMotorPower-motorPower) * kp;
    }

    motor.set(motorPower);

  }

  public void setPower(double power) {
    coast = false;
    setMotorPower = power;

  }

  public void setCoast(boolean coast) {
    this.coast = coast;
  }
}
