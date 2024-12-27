package code.example.servers.handlers.groups;

import code.example.controllers.groups.StudentGroupController;
import code.example.exceptions.ServiceException;
import code.example.requests.groups.AddGroupStudents;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddStudentGroupHandler implements Handler {

    private ObjectMapper mapper;
    private StudentGroupController controller;

    public AddStudentGroupHandler(ObjectMapper mapper, StudentGroupController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        AddGroupStudents request = mapper.readValue(body, AddGroupStudents.class);
        ResponseEntity<Long> response = controller.addStudentGroup(request);
        return mapper.writeValueAsString(response);
    }
}
