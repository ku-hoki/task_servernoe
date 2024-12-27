package code.example.servers.handlers.groups;

import code.example.controllers.groups.StudentGroupController;
import code.example.exceptions.ServiceException;
import code.example.requests.groups.EditGroupStudents;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EditStudentGroupHandler implements Handler {

    private ObjectMapper mapper;
    private StudentGroupController controller;

    public EditStudentGroupHandler(ObjectMapper mapper, StudentGroupController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        EditGroupStudents request = mapper.readValue(body, EditGroupStudents.class);
        ResponseEntity<Void> response = controller.editStudentGroup(request);
        return mapper.writeValueAsString(response);
    }
}
