package by.jwdc.finances.controller;

import by.jwdc.finances.controller.Command.Command;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    private final String DELIMITER = " ";
    private final String EMPTY_STRING = "";

    public String executeRequest(String request){

        String commandString;
        String parameters;
        Command command;

        String response = "response was not allow";

        int firstDelimiterIndex = request.indexOf(DELIMITER);

        if (firstDelimiterIndex > -1) {
            commandString = request.substring(0, firstDelimiterIndex);
            parameters = request.substring(request.indexOf(DELIMITER) + 1);
        } else {
            commandString = request;
            parameters = EMPTY_STRING;
        }

        command = provider.getCommand(commandString);
        response = command.action(parameters);

        return response;
    }
}
