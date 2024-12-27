package code.example.servers.handlers.teachers;

import code.example.controllers.teachers.TeacherController;
import code.example.exceptions.ServiceException;
import code.example.requests.teachers.AddTeacherRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddTeacherHandler implements Handler {
    private ObjectMapper mapper;
    private TeacherController controller;

    public AddTeacherHandler(ObjectMapper mapper, TeacherController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        AddTeacherRequest request = mapper.readValue(body, AddTeacherRequest.class);
        ResponseEntity<Long> response = controller.addTeacher(request);
        return mapper.writeValueAsString(response);
    }
}
