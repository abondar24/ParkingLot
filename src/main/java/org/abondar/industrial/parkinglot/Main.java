package org.abondar.industrial.parkinglot;

import org.abondar.industrial.parkinglot.processing.command.CommandSwitcher;
import org.abondar.industrial.parkinglot.util.FileParserUtil;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        CommandSwitcher switcher = new CommandSwitcher();

        if (args.length > 0 && args[0].contains(".txt")) {
            runInFileMode(args[0], switcher);
        } else if (args.length == 0) {
            runInInteractiveMode(switcher);
        }
    }

    private static void runInFileMode(String fileName, CommandSwitcher switcher) throws Exception {
        System.out.println("Running in file mode");
        var lines = FileParserUtil.parseFile(new FileInputStream(fileName));
        lines.forEach(switcher::executeCommand);
    }

    private static void runInInteractiveMode(CommandSwitcher switcher) {
        System.out.println("Running in interactive mode");
        var scanner = new Scanner(System.in);
        while (true) {
            var command = scanner.nextLine();
            String[] cmdData = command.split(" ");
            switcher.executeCommand(cmdData);
        }

    }

}

