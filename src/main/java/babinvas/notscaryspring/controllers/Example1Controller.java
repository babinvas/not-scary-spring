package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Example1Controller {

	@GetMapping(value = "/testExceptionHandler", produces = APPLICATION_JSON_VALUE)
	Response testExceptionHandler(@RequestParam(required = false, defaultValue ="false") boolean exception)
			throws BusinessException {
		if(exception) {
			throw new BusinessException("BusinessException in testExceptionHandler");
		}

		return new Response("OK");
	}

	@ExceptionHandler(BusinessException.class)
	public Response handleException(BusinessException e) {
		return new Response(e.getMessage());
	}
}
