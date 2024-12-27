package code.example.servers.handlers.teachers;

import code.example.controllers.teachers.TeacherController;
import code.example.exceptions.ServiceException;
import code.example.requests.teachers.GetTeacherByIdRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.teachers.TeacherResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class GetTeachersHandler implements Handler {
    private ObjectMapper mapper;
    private TeacherController controller;

    public GetTeachersHandler(ObjectMapper mapper, TeacherController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        ResponseEntity<List<TeacherResponse>> response = controller.getTeachers();
        return mapper.writeValueAsString(response);
    }
}
