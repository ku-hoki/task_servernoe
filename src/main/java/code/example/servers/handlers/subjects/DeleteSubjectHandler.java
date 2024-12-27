package code.example.servers.handlers.subjects;

import code.example.controllers.subjects.SubjectController;
import code.example.requests.subjects.DeleteSubjectRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteSubjectHandler implements Handler {

    private ObjectMapper mapper;
    private SubjectController controller;

    public DeleteSubjectHandler(ObjectMapper mapper, SubjectController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException {
        DeleteSubjectRequest request = mapper.readValue(body, DeleteSubjectRequest.class);
        ResponseEntity<Void> response = controller.deleteSubject(request);
        return mapper.writeValueAsString(response);
    }
}
