package com.capgeticketevents.errorcontrol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		

		logger.info("------ handleMethodArgumentNotValid()");
		
		
		CustomErrorModel customError = new CustomErrorModel();

		//Paso fecha pero la formatea a String con formato DD/MM/YY
		
		customError.setTrace("texto personalizado trace");
		customError.setStatus(400);
		customError.setError("Bad Request, los datos introducidos son erroneos o faltan datos");
		
		List<String> messages = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			messages.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMessage(messages);

		
		//Para recoger el path y simular de forma completa los datos originales
		// request.getDescription(false) ---> uri=/students
		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=")+1);
		customError.setPath(uri);

		return new ResponseEntity<>(customError, headers, status);
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> springHandleNotFound(MethodArgumentNotValidException ex){

		CustomErrorModel customError = new CustomErrorModel();
		//Paso fecha pero la formatea a String con formato DD/MM/YY
		
		customError.setTrace("texto personalizado trace");
		customError.setStatus(400);
		customError.setError("Bad Request, los datos introducidos son erroneos o faltan datos");
		
		List<String> messages = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			messages.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMessage(messages);

	

		return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST );
	}
}
