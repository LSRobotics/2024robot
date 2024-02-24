// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class ClearIntakeCommand extends Command {
  private final IntakeSubsystem m_intake;
  private final IndexerSubsystem m_indexer;
  private double speed = 0;

 
  public ClearIntakeCommand(IntakeSubsystem intake, IndexerSubsystem indexer, double speed) {
    m_intake = intake;
    m_indexer = indexer;
    this.speed = speed;
    addRequirements(intake, indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.runIntake(-speed);
    m_indexer.runIndexer(-speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.runIntake(0);
    m_indexer.runIndexer(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
