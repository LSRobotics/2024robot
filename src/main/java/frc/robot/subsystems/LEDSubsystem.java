// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDSubsystem extends SubsystemBase {
  private Spark ledDriverOne;

  public LEDSubsystem() {
    ledDriverOne = new Spark(Constants.LEDConstants.LEDDriverOneID);
  }

  public void runLeds(double color) {
    ledDriverOne.set(color);
  }
}