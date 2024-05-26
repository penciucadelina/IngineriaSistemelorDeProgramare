package isp.lab11.exercise1;

public class LandCommand {
    private AtcCommand command;

    public LandCommand(String command) {
        this.command = AtcCommand.LAND_CMD;
    }

    public AtcCommand getCommand() {
        return command;
    }

}


