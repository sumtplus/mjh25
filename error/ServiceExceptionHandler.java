package com.qsvc.finapi.exception;

import com.google.gson.JsonSyntaxException;
import com.qsvc.finapi.eds.exception.EdsException;
import com.qsvc.finapi.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ServiceExceptionHandler {

	private String getErrorMsg(List<String> parameterNames) {
		return new StringBuilder(ServiceError.INVALID_REQUEST_PARAM.getDescription())
    			.append("(")
    			.append(String.join(", ", parameterNames))
    			.append(")")
    			.toString();
	}
	
    @ExceptionHandler(EdsException.class)
    public ResponseEntity<?> handleServiceException(EdsException se) {
    	log.error("[error]status = {}, message = {}", se.getStatus(), se.getMessage());
    	return new ResponseEntity<>(ApiUtil.error(se.getMessage(), se.getStatus()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleServiceException(ServiceException se) {
    	log.error("[error]status = {}, message = {}", se.getStatus(), se.getMessage());
    	return new ResponseEntity<>(ApiUtil.error(se.getMessage(), se.getStatus()), se.getStatus());
    }
    
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException e) {
//    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
//    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
//    }
    
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<?> handleAuthenticationException(AuthenticationException e) {
//    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
//    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
//    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<?> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.UNSUPPORTED_MEDIA_TYPE), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<?> handleMethodNotAllowedException(MethodNotAllowedException e) {
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.METHOD_NOT_ALLOWED), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<?> handleException(Exception e) {
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleRequestParameterException(MissingServletRequestParameterException e) {
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(
    			this.getErrorMsg(Arrays.asList(e.getParameterName())), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> handleNumberFormatException(NumberFormatException e){
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(JsonSyntaxException.class)
    public ResponseEntity<?> handleJsonSyntaxException(JsonSyntaxException e){
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JSONException.class)
    public ResponseEntity<?> handleJSONException(JSONException e){
        log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
        return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<?> handleClassCastException(ClassCastException e){
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), e.getMessage(), e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<?> handleUnknownHostException(UnknownHostException e){
    	log.error("[error] Exception = {}, message = {}, cause = {}", e.getClass(), "호스트를 찾을 수 없습니다.", e.getCause());
    	return new ResponseEntity<>(ApiUtil.error(e, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
