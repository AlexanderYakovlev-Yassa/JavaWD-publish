package by.jwdc.finances.controller;

import by.jwdc.finances.controller.Command.Command;
import by.jwdc.finances.controller.Command.CommandName;
import by.jwdc.finances.controller.Command.impl.AddFinanceOperation;
import by.jwdc.finances.controller.Command.impl.AddOperationType;
import by.jwdc.finances.controller.Command.impl.IncorrectRequest;
import by.jwdc.finances.controller.Command.impl.ShowAllFinanceOperations;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider(){
        repository.put(CommandName.INCORRECT_REQUEST, new IncorrectRequest());
        repository.put(CommandName.ADD_FINANCE_OPERATION, new AddFinanceOperation());
        repository.put(CommandName.ADD_OPERATION_TYPE, new AddOperationType());
        repository.put(CommandName.SHOW_ALL_FINANCE_OPERATIONS, new ShowAllFinanceOperations());
    }

    public Command getCommand(String commandName){

        Command command;

        try {
            command = repository.get(CommandName.valueOf(commandName.toUpperCase()));
        } catch (IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.INCORRECT_REQUEST);
        }

        return command;
    }
}
