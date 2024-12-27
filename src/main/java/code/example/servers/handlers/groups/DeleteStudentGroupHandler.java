package code.example.servers.handlers.groups;

import code.example.controllers.groups.StudentGroupController;
import code.example.exceptions.ServiceException;
import code.example.requests.groups.DeleteStudentGroup;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteStudentGroupHandler implements Handler {
    private ObjectMapper mapper;
    private StudentGroupController controller;

    public DeleteStudentGroupHandler(ObjectMapper mapper, StudentGroupController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }
    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        DeleteStudentGroup request = mapper.readValue(body, DeleteStudentGroup.class);
        ResponseEntity<Void> response = controller.deleteStudentGroup(request);
        return mapper.writeValueAsString(response);
    }
}
