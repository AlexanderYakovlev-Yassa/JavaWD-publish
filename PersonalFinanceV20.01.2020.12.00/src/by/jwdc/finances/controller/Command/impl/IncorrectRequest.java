package by.jwdc.finances.controller.Command.impl;

import by.jwdc.finances.controller.Command.Command;

public class IncorrectRequest implements Command {

    @Override
    public String action(String request) {


        return "Wrong command";
    }
}
