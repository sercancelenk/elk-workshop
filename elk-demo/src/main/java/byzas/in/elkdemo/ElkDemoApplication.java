package byzas.in.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
public class ElkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElkDemoApplication.class, args);
	}

	@RestController
	@RequestMapping("/log")
	public static class IndexController{

		private static Logger logger = LoggerFactory.getLogger(IndexController.class);

		@GetMapping("/write/bulk")
		public String writeLogBulk(){
			Random rnd = new Random(500);

			for(int i = 0; i<rnd.nextInt(1000); i++){
				logger.info("[{}] Writing Log " + i, i%2==0?"logtype":"fetchtype");
			}

			return "OK";
		}

	}
}

