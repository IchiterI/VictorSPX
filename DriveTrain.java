// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  VictorSP leftFront;
  VictorSP rightFront;
  VictorSP leftBack;
  VictorSP rightBack;
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;
  DifferentialDrive drive;



  /** Creates a new DriveTrain. */ 
  public DriveTrain() {
    leftFront = new VictorSP(Constants.LEFT_FRONT);
    leftFront.setInverted(false);
    rightFront = new VictorSP(Constants.RIGHT_FRONT);
    rightFront.setInverted(true);
    leftBack = new VictorSP(Constants.LEFT_BACK);
    leftBack.setInverted(false);
    rightBack = new VictorSP(Constants.RIGHT_BACK);
    rightBack.setInverted(true);

    leftMotors = new MotorControllerGroup(leftFront, leftBack);
    rightMotors = new MotorControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(leftMotors, rightMotors);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoySticks(XboxController controller, double speed)
  {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
    {
      drive.stopMotor();
    }
}
