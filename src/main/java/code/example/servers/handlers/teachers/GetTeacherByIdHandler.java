package code.example.servers.handlers.teachers;

import code.example.controllers.teachers.TeacherController;
import code.example.exceptions.ServiceException;
import code.example.requests.teachers.GetTeacherByIdRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.teachers.TeacherResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetTeacherByIdHandler implements Handler {
    private ObjectMapper mapper;
    private TeacherController controller;

    public GetTeacherByIdHandler(ObjectMapper mapper, TeacherController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        GetTeacherByIdRequest request = mapper.readValue(body, GetTeacherByIdRequest.class);
        ResponseEntity<TeacherResponse> response = controller.getTeacherById(request);
        return mapper.writeValueAsString(response);
    }
}
