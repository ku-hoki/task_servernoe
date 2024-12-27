package code.example.servers.handlers.students;

import code.example.controllers.students.StudentController;
import code.example.exceptions.ServiceException;
import code.example.requests.students.GetStudentByIdRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.students.StudentResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetStudentByIdHandler implements Handler {

    private ObjectMapper mapper;
    private StudentController controller;

    public GetStudentByIdHandler(ObjectMapper mapper, StudentController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        GetStudentByIdRequest request = mapper.readValue(body, GetStudentByIdRequest.class);
        ResponseEntity<StudentResponse> response = controller.getStudentById(request);
        return mapper.writeValueAsString(response);
    }
}
