package code.example.servers.handlers.groups;

import code.example.controllers.groups.StudentGroupController;
import code.example.exceptions.ServiceException;
import code.example.requests.groups.GetStudentGroupById;
import code.example.responses.ResponseEntity;
import code.example.responses.groups.GroupResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetStudentGroupByIdHandler implements Handler {
    private ObjectMapper mapper;
    private StudentGroupController controller;

    public GetStudentGroupByIdHandler(ObjectMapper mapper, StudentGroupController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        GetStudentGroupById request = mapper.readValue(body, GetStudentGroupById.class);
        ResponseEntity<GroupResponse> response = controller.getStudentGroupById(request);
        return mapper.writeValueAsString(response);
    }

}
