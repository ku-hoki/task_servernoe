package code.example.servers.handlers.subjects;

import code.example.controllers.subjects.SubjectController;
import code.example.exceptions.ServiceException;
import code.example.requests.subjects.EditSubjectRequest;
import code.example.responses.ResponseEntity;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EditSubjectHandler implements Handler {
    private ObjectMapper mapper;
    private SubjectController controller;

    public EditSubjectHandler(ObjectMapper mapper, SubjectController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        EditSubjectRequest request = mapper.readValue(body, EditSubjectRequest.class);
        ResponseEntity<Void> response = controller.editSubject(request);
        return mapper.writeValueAsString(response);
    }
}
