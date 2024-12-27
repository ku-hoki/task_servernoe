package code.example.servers.handlers.teachers;

import code.example.controllers.teachers.TeacherController;
import code.example.exceptions.ServiceException;
import code.example.requests.teachers.DeleteTeacherRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteTeacherHandler implements Handler {

    private ObjectMapper mapper;
    private TeacherController controller;

    public DeleteTeacherHandler(ObjectMapper mapper, TeacherController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        DeleteTeacherRequest request = mapper.readValue(body, DeleteTeacherRequest.class);
        ResponseEntity<Void> response = controller.deleteTeacher(request);
        return mapper.writeValueAsString(response);
    }
}
