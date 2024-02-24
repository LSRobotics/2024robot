// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.LEDConstants;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.IndexerSubsystem;

/** An example command that uses an example subsystem. */
public class ShooterRampUpCommand extends Command {
  private final ShooterSubsystem m_shooter;
  private final IndexerSubsystem m_index;
  private double speed = 0;
  private final LEDSubsystem m_leds;

  public ShooterRampUpCommand(ShooterSubsystem shooter, IndexerSubsystem index, LEDSubsystem leds, double speed) {
    m_shooter = shooter;
    m_index = index;
    m_leds = leds;
    this.speed = speed;
    addRequirements(shooter, leds);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.runShooter(this.speed);
    m_leds.runLeds(LEDConstants.colorSkyBlue);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.runShooter(0);
    m_leds.runLeds(LEDConstants.colorLimeGreen);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !m_index.notePresent();
  }
}
