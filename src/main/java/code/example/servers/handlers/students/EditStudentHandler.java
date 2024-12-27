package code.example.servers.handlers.students;

import code.example.controllers.students.StudentController;
import code.example.exceptions.ServiceException;
import code.example.requests.students.EditStudentRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EditStudentHandler implements Handler {
    private ObjectMapper mapper;
    private StudentController controller;

    public EditStudentHandler(ObjectMapper mapper, StudentController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        EditStudentRequest request = mapper.readValue(body, EditStudentRequest.class);
        ResponseEntity<Void> response = controller.editStudent(request);
        return mapper.writeValueAsString(response);
    }
}
