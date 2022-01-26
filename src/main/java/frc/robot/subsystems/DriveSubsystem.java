// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.SPI;
public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_TalonSRX m_FrontLeft = new WPI_TalonSRX(DriveConstants.kFrontLeftMotorPort);
  private final WPI_TalonSRX m_FrontRight = new WPI_TalonSRX(DriveConstants.kFrontRightMotorPort);
  private final WPI_TalonSRX m_RearLeft = new WPI_TalonSRX(DriveConstants.kRearLeftMotorPort);
  private final WPI_TalonSRX m_rearRight = new WPI_TalonSRX(DriveConstants.kRearRightMotorPort);
  private final AHRS navx = new AHRS(SPI.Port.kMXP);
  private final DifferentialDrive diffDrive = new DifferentialDrive(m_FrontLeft, m_FrontRight);
  public DriveSubsystem() {
    m_RearLeft.follow(m_FrontLeft);
    m_rearRight.follow(m_FrontRight);
  }
  public void drive(double fwd, double rot){
    diffDrive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public double getAngle(){
    return navx.getAngle();
  }
}
