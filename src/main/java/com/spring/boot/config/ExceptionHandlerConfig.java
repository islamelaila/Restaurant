package com.spring.boot.config;
import com.spring.boot.helper.MessageResponse;
import com.spring.boot.service.impl.BundelMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @Autowired
    private BundelMessageService bundelMessageService;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> ExceptionHandler (MethodArgumentNotValidException e ){

        List<MessageResponse> messageResponses = new ArrayList<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        fieldErrors.stream().forEach(fieldError -> {
            String message = fieldError.getDefaultMessage();
            messageResponses.add(new MessageResponse(message));

        });

        return ResponseEntity.badRequest().body(messageResponses);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> ExceptionHandler (Exception exception){
        String message = exception.getMessage();
        return ResponseEntity.badRequest().body(new MessageResponse(message));
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageResponse> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(
                bundelMessageService.getMessage(exception.getMessage())
        );
    }


}
