package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccessLog {
    private final LocalDateTime dateTime;
    private final String operation;
    private final DoorStatus doorStatus;

    AccessLog(LocalDateTime dateTime, String operation, DoorStatus doorStatus) {
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
    }

    @Override
    public String toString() {
        return "AccessLog{" +
                "dateTime=" + dateTime +
                ", operation='" + operation + '\'' +
                ", doorStatus=" + doorStatus +
                '}';
    }
}