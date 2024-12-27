package code.example.servers.handlers;
import code.example.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Handler {
    String apply(String body) throws JsonProcessingException, ServiceException;
}
