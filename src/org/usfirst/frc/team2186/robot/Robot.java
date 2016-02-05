
package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Drive d = Drive.getInstance();
	Joystick j = new Joystick(0);
	Joystick driver = new Joystick(1);
	Compressor c;
	MotionPath autonomous;
    public void robotInit() {
    	c = new Compressor();
    	c.start();
    	
    	//autonomous = new MotionPath("motion.txt");
    	
    	SmartDashboard.putNumber("DriveType", 0);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//autonomous.interpret();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	d.teleop(j);
    	if(driver.getRawButton(3)) {
    		SmartDashboard.putNumber("DriveType", 1);
    	} else {
    		SmartDashboard.putNumber("DriveType", 0);
    	}
    	
    	if(driver.getRawButton(1)) {
    		d.shift(1);
    	} else {
    		d.shift(0);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
