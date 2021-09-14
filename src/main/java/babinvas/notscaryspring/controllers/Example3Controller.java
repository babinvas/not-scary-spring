package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.Response;
import babinvas.notscaryspring.exceptions.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Example3Controller {

	@GetMapping(value = "/testCustomExceptionResolver", produces = APPLICATION_JSON_VALUE)
	public Response testCustomExceptionResolver(@RequestParam(required = false, defaultValue = "false") boolean exception)
	throws CustomException {
		if (exception) {
			throw new CustomException("CustomException in testCustomExceptionResolver");
		}

		return new Response("OK");
	}
}
