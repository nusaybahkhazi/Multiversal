public class robotConfig {
    private String name;
    private String frontLeftDriveName;
    private String frontRightDriveName;
    private String backLeftDriveName;
    private String backRightDriveName;
    private String servoName;
    private String limelightName;
    private String intakeMotorName;

    // A default no-argument constructor is strictly required by Jackson
    public robotConfig() {}

    public String getName() {
        return name;
    }

    public String getFrontLeftDriveName() {
        return frontLeftDriveName;
    }

    public String getFrontRightDriveName() {
        return frontRightDriveName;
    }

    public String getBackLeftDriveName() {
        return backLeftDriveName;
    }

    public String getBackRightDriveName() {
        return BackRightDriveName;
    }
}
