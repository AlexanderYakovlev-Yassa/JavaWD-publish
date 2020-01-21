package by.jwdc.finances.service.factory;

import by.jwdc.finances.service.IServiceLogic;
import by.jwdc.finances.service.impl.ServiceLogic;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final IServiceLogic operationService = new ServiceLogic();

    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public IServiceLogic getServiceLogic() {
        return operationService;
    }
}
