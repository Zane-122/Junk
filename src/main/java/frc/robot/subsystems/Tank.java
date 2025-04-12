// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Tank extends SubsystemBase {
  public Victor leftMotor1;
  public Victor rightMotor1;
  public Victor leftMotor2;
  public Victor rightMotor2;

/** Creates a new Tank. */
  public Tank() {
    this.leftMotor1 = new Victor(RobotMap.LEFT_1);
    this.leftMotor2 = new Victor(RobotMap.LEFT_2);
    this.rightMotor1 = new Victor(RobotMap.RIGHT_1);
    this.rightMotor2 = new Victor(RobotMap.RIGHT_2);
  }

  @Override
  public void periodic() {

  }

  public void setPower(Double left, Double right) {
    leftMotor1.set(left);
    leftMotor2.set(left);

    rightMotor1.set(right);
    rightMotor2.set(right);
  }

  public void stop() {
    leftMotor1.stopMotor();
    leftMotor2.stopMotor();

    rightMotor1.stopMotor();
    rightMotor2.stopMotor();
  }

}
