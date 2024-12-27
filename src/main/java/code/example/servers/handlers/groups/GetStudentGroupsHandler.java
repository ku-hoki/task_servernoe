package code.example.servers.handlers.groups;

import code.example.controllers.groups.StudentGroupController;
import code.example.exceptions.ServiceException;
import code.example.responses.ResponseEntity;
import code.example.responses.groups.GroupResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class GetStudentGroupsHandler implements Handler {
    private ObjectMapper mapper;
    private StudentGroupController controller;

    public GetStudentGroupsHandler(ObjectMapper mapper, StudentGroupController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        ResponseEntity<List<GroupResponse>> response = controller.getAllStudentsGroups();
        return mapper.writeValueAsString(response);
    }
}
