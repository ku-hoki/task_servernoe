package code.example.servers.handlers.teachers;

import code.example.controllers.teachers.TeacherController;
import code.example.exceptions.ServiceException;
import code.example.requests.teachers.EditTeacherRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EditTeacherHandler implements Handler {
    private ObjectMapper mapper;
    private TeacherController controller;

    public EditTeacherHandler(ObjectMapper mapper, TeacherController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        EditTeacherRequest request = mapper.readValue(body, EditTeacherRequest.class);
        ResponseEntity<Void> response = controller.editTeacher(request);
        return mapper.writeValueAsString(response);
    }
}
