package babinvas.notscaryspring.advices;

import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Response> handleException(BusinessException e) {
		Response response = new Response(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
	                                                              HttpHeaders headers,
	                                                              HttpStatus status,
	                                                              WebRequest request) {
		Response response = new Response("Не правильный JSON", ex.getMessage());
		return new ResponseEntity<>(response, status);
	}
}
