package tn.esprit.spring.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import tn.esprit.spring.fileUpmessage.ResponseMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	  }
	}
	

