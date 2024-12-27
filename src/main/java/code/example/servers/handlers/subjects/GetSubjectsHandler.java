package code.example.servers.handlers.subjects;

import code.example.controllers.subjects.SubjectController;
import code.example.responses.ResponseEntity;
import code.example.responses.subjects.SubjectResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class GetSubjectsHandler implements Handler {
    private ObjectMapper mapper;
    private SubjectController controller;

    public GetSubjectsHandler(ObjectMapper mapper, SubjectController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException {
        ResponseEntity<List<SubjectResponse>> response = controller.getSubjects();
        return mapper.writeValueAsString(response);
    }
}
