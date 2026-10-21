package com.CodingShuttle.LinkedIn.ConnectionService.Exception;

import com.CodingShuttle.LinkedIn.ConnectionService.Controller.ConnectionsController;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice(assignableTypes = ConnectionsController.class)
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler({
            HandlerMethodValidationException.class,
            ConstraintViolationException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<ApiError> handleBadRequest(Exception exception) {
        String message = exception instanceof MethodArgumentTypeMismatchException
                ? "userId must be a valid number"
                : "userId must be greater than 0";
        return createErrorResponse(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnexpectedException(Exception exception) {
        log.error("Unexpected error while processing API request", exception);
        return createErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Unable to retrieve first-degree connections"
        );
    }

    private ResponseEntity<ApiError> createErrorResponse(HttpStatus status, String message) {
        ApiError error = new ApiError(status.value(), status.getReasonPhrase(), message);
        return ResponseEntity.status(status).body(error);
    }
}
