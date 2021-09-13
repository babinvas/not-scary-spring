package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Example2Controller {

	@GetMapping(value = "/testResponseStatusExceptionResolver", produces = APPLICATION_JSON_VALUE)
	public Response testResponseStatusExceptionResolver(@RequestParam(required = false, defaultValue = "false") boolean exception)
			throws ServiceException {
		if (exception) {
			throw new ServiceException("ServiceException in testResponseStatusExceptionResolver");
		}

		return new Response("OK");
	}
}
