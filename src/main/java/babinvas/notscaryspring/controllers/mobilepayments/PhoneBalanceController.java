package babinvas.notscaryspring.controllers.mobilepayments;

import babinvas.notscaryspring.dto.mobilepayments.PhoneBalanceDto;
import babinvas.notscaryspring.services.mobilepayments.PhoneBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
@RequiredArgsConstructor
public class PhoneBalanceController {
	private final PhoneBalanceService phoneBalanceService;

	@GetMapping("/find-phonenumber-ById/{id}")
	public ResponseEntity<?> findPhoneNumberById(@PathVariable Integer id) {
		PhoneBalanceDto balanceDto = phoneBalanceService.findDtoById(id);

		if (balanceDto.getId() == null) {
			return ResponseEntity.ok().body(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(balanceDto);
	}

	@GetMapping("/find-phonenumber-ByName/{name}")
	public ResponseEntity<?> findPhoneNumberByName(@PathVariable String name) {
		List<PhoneBalanceDto> balanceDtos = phoneBalanceService.findDtoByNameCustomer(name);
		return balanceDtos != null && !balanceDtos.isEmpty()
				? ResponseEntity.ok(balanceDtos)
				: ResponseEntity.ok().body(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findall")
	public ResponseEntity<?> findAll() {
		List<PhoneBalanceDto> balanceDtos = phoneBalanceService.findAllDto();

		return balanceDtos != null && !balanceDtos.isEmpty()
				? ResponseEntity.ok(balanceDtos)
				: ResponseEntity.ok().body(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/entry")
	public ResponseEntity<?> entryNumber(@RequestBody PhoneBalanceDto dto) {
		phoneBalanceService.save(dto);
		return ResponseEntity.ok().body(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete-phoneById/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		phoneBalanceService.deleteById(id);
		return ResponseEntity.ok().body(HttpStatus.OK);
	}
}
