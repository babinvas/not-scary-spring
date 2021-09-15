package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Example4Controller {

	@GetMapping(value = "/testDefaultControllerAdvice", produces = APPLICATION_JSON_VALUE)
	public Response testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
			throws BusinessException {
		if (exception) {
			throw new BusinessException("BusinessException in testDefaultControllerAdvice");
		}

		return new Response("OK");
	}
}
