package isp.lab11.exercise1;

public class TakeoffCommand {
    int alt;
    private AtcCommand command;

    public TakeoffCommand(int alt) {
        this.command = AtcCommand.TAKEOFF_CMD;
        this.alt = alt;
    }

    public AtcCommand getCommand() {
        return command;
    }

    public int getAlt() {
        return alt;
    }

}