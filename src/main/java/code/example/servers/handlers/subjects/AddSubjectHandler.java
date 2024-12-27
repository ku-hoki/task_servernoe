package code.example.servers.handlers.subjects;

import code.example.controllers.subjects.SubjectController;
import code.example.exceptions.ServiceException;
import code.example.requests.subjects.AddSubjectRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddSubjectHandler implements Handler {
    private ObjectMapper mapper;
    private SubjectController controller;

    public AddSubjectHandler(ObjectMapper mapper, SubjectController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        AddSubjectRequest request = mapper.readValue(body, AddSubjectRequest.class);
        ResponseEntity<Long> response = controller.addSubject(request);
        return mapper.writeValueAsString(response);
    }
}
