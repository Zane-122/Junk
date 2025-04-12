// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.DoubleSummaryStatistics;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;
import frc.thunder.shuffleboard.LightningShuffleboard;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Drive extends Command {
  private Tank tank;

  private DoubleSupplier leftPower;
  private DoubleSupplier rightPower;

  private double speedMult;

  /** Creates a new Drive. */
  public Drive(Tank tank, DoubleSupplier rightPower, DoubleSupplier leftPower) {
    this.rightPower = rightPower;
    this.leftPower = leftPower;
    this.tank = tank;

    addRequirements(tank);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speedMult = LightningShuffleboard.getDouble("Drive", "Multiplier", 0.8);

    tank.setPower(leftPower.getAsDouble() * speedMult, rightPower.getAsDouble() * speedMult);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tank.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
