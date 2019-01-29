package org.abondar.industrial.parkinglot;

import org.abondar.industrial.parkinglot.util.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length>0 && args[0].contains(".txt")){
           runInFileMode(args[0]);
        } else if (args.length==0) {
            runInInteractiveMode();
        }
    }

    private static void runInFileMode(String fileName) throws Exception{
        System.out.println("Running in file mode");
        var lines = InputUtil.parseFile(new FileInputStream(fileName));
        lines.forEach(InputUtil::executeCommand);
    }

    private static void runInInteractiveMode(){
          System.out.println("Running in interactive mode");
          var scanner = new Scanner(System.in);
          while (true){
              var command = scanner.nextLine();
              String[] cmdData = command.split(" ");
              InputUtil.executeCommand(cmdData);
          }

    }
}
