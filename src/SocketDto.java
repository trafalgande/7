import java.io.Serializable;

public class SocketDto implements Serializable {
    private String command;
    private Character object;

    public void setCommand(String command) {
        this.command = command;
    }

    public void setObject(Character object) {
        this.object = object;
    }

    public String getCommand() {
        return command;
    }

    public Character getObject() {
        return object;
    }

    public SocketDto() {
    }

    public SocketDto(String command, Character object) {
        this.command = command;
        this.object = object;
    }

}
