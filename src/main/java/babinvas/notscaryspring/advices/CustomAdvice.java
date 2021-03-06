package babinvas.notscaryspring.advices;

import babinvas.notscaryspring.annotations.CustomExceptionHandler;
import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice(annotations = CustomExceptionHandler.class)
public class CustomAdvice {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Response> handleException(BusinessException e) {
		String message = String.format("%s %s", LocalDateTime.now(),e.getMessage());
		Response response = new Response(message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
