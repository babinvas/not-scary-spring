package babinvas.notscaryspring.advices;

import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Response> handleException(BusinessException e) {
		Response response = new Response(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
