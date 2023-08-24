package com.LucaSteam.controller.error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Global exception handler to customize error responses.
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
     * Handles GameNotFoundException and sends a NOT_FOUND response.
     *
     * @param response The HttpServletResponse.
     * @throws IOException If an I/O error occurs.
     */
    @ExceptionHandler(GameNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    
    /**
     * Handles ConstraintViolationException and sends a BAD_REQUEST response.
     *
     * @param response The HttpServletResponse.
     * @throws IOException If an I/O error occurs.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        System.out.println("------ ConstraintViolationException() ");
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * Handles validation errors and constructs a custom error response.
     *
     * @param ex      The MethodArgumentNotValidException.
     * @param headers The HttpHeaders.
     * @param status  The HttpStatus.
     * @param request The WebRequest.
     * @return A ResponseEntity containing the custom error response.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        CustomErrorJson customError = new CustomErrorJson();
        customError.setTimestamp(new Date());
        customError.setStatus(status.value());
        customError.setError(status.name());

        List<String> messages = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            messages.add(error.getField() + ": " + error.getDefaultMessage());
        }
        customError.setMessage(messages);

        String uri = request.getDescription(false);
        uri = uri.substring(uri.indexOf("=") + 1);
        customError.setPath(uri);

        return new ResponseEntity<>(customError, headers, status);
    }

    /**
     * Handles HttpRequestMethodNotSupportedException and constructs a custom error response.
     *
     * @param ex      The HttpRequestMethodNotSupportedException.
     * @param headers The HttpHeaders.
     * @param status  The HttpStatus.
     * @param request The WebRequest.
     * @return A ResponseEntity containing the custom error response.
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("------ handleHttpRequestMethodNotSupported()");
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        Map<String, Object> body = new LinkedHashMap<>();
        // Paso fecha formateada a String
        body.put("timestamp", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        body.put("status", status.value());
        body.put("error", ex.getLocalizedMessage());
        body.put("message", builder.toString());
        body.put("autor", "Antonio");

        return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

    }
}
