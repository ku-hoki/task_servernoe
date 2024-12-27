package code.example.servers.handlers.subjects;

import code.example.controllers.subjects.SubjectController;
import code.example.exceptions.ServiceException;
import code.example.requests.subjects.GetSubjectByIdRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.subjects.SubjectResponse;
import code.example.servers.handlers.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetSubjectByIdHandler implements Handler {
    private ObjectMapper mapper;
    private SubjectController controller;

    public GetSubjectByIdHandler(ObjectMapper mapper, SubjectController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Override
    public String apply(String body) throws JsonProcessingException, ServiceException {
        GetSubjectByIdRequest request = mapper.readValue(body, GetSubjectByIdRequest.class);
        ResponseEntity<SubjectResponse> response = controller.getSubjectById(request);
        return mapper.writeValueAsString(response);
    }
}
