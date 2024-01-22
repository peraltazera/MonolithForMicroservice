package memelandia.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MemelandiaUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaUsuariosApplication.class, args);
	}

}
