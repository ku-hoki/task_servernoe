package code.example.responses;

public class ResponseEntity<T> {
    private  T body;
    private int statusCode;
    private String message;

    public ResponseEntity(T body, int statusCode, String message) {
        this.body = body;
        this.statusCode = statusCode;
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public static <T> ResponseEntity<T> success(T body) {
        return new ResponseEntity<>(body, 200, "Запрос успешно выполнен");
    }

    public static <T> ResponseEntity<T> created(T body) {
        return new ResponseEntity<>(body, 201, "Запрос выполнен и привел к созданию нового ресурса");
    }

    public static <T> ResponseEntity<T> error(int statusCode, String message) {
        return new ResponseEntity<>(null, statusCode, message);
    }
}
