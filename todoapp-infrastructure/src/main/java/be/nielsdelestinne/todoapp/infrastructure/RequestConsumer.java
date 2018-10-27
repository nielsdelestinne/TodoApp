package be.nielsdelestinne.todoapp.infrastructure;

import be.nielsdelestinne.todoapp.application.Request;
import be.nielsdelestinne.todoapp.application.Response;
import be.nielsdelestinne.todoapp.application.UseCase;

public class RequestConsumer {

    protected <TReq extends Request, RType, TRes extends Response<RType>> RType doConsume(UseCase<TReq, TRes> useCase, TReq request) {
        return useCase.process(request).getValue();
    }

}
