package babinvas.notscaryspring.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateService implements CommandLineRunner {
	// Имплементируем интерфейс CommandLineRunner (командная строка запуска)

	// Переопределяем метод который позволит
	// нам выполнять методы нашего приложения при запуске
	@Override
	public void run(String ... args) throws Exception {
		System.out.println("Run BabinVas run!");
	}
}
