package org.abondar.industrial.parkinglot.processing.command;

import java.util.ArrayList;
import java.util.List;

public class Switch {

    private final List<Command> history = new ArrayList<>();

    public void storeAndExecute(Command cmd){
        this.history.add(cmd);
        cmd.execute();
    }
}
