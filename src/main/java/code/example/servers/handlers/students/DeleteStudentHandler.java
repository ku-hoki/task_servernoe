package code.example.servers.handlers.students;

import code.example.controllers.students.StudentController;
import code.example.exceptions.ServiceException;
import code.example.requests.students.DeleteStudentRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteStudentHandler implements Handler {
    private ObjectMapper mapper;
    private StudentController controller;

    public DeleteStudentHandler(ObjectMapper mapper, StudentController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        DeleteStudentRequest request = mapper.readValue(body, DeleteStudentRequest.class);
        ResponseEntity<Void> response = controller.deleteStudent(request);
        return mapper.writeValueAsString(response);
    }
}
