package code.example.servers.handlers.students;

import code.example.controllers.students.StudentController;
import code.example.exceptions.ServiceException;
import code.example.requests.students.AddStudentRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddStudentHandler implements Handler {
    private ObjectMapper mapper;
    private StudentController controller;

    public AddStudentHandler(ObjectMapper mapper, StudentController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        AddStudentRequest request = mapper.readValue(body, AddStudentRequest.class);
        ResponseEntity<Long> response = controller.addStusent(request);
        return mapper.writeValueAsString(response);

    }
}
