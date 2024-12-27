package code.example.servers.handlers.students;

import code.example.controllers.students.StudentController;
import code.example.exceptions.ServiceException;
import code.example.requests.students.GetStudentsByGroupRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.students.StudentResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class GetStudentByGroupHandler implements Handler {
    private ObjectMapper mapper;
    private StudentController controller;

    public GetStudentByGroupHandler(ObjectMapper mapper, StudentController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        GetStudentsByGroupRequest request = mapper.readValue(body, GetStudentsByGroupRequest.class);
        ResponseEntity<List<StudentResponse>> response = controller.getStudentByGroupId(request);
        return mapper.writeValueAsString(response);
    }
}
