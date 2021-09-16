package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.annotations.CustomExceptionHandler;
import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CustomExceptionHandler
public class Example5Controller {

	@GetMapping(value = "/testCustomControllerAdvice", produces = APPLICATION_JSON_VALUE)
	public Response testCustomControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
			throws BusinessException {
		if (exception) {
			throw new BusinessException("BusinessException in testCustomControllerAdvice");
		}

		return new Response("OK");
	}
}
