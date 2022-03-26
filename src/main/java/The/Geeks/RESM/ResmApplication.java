package The.Geeks.RESM;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import The.Geeks.RESM.config.RabbitMQConfiguration;
import The.Geeks.RESM.dto.EstatesDto;

@SpringBootApplication
public class ResmApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(ResmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EstatesDto estatesDto = new EstatesDto();
		estatesDto.setId(1);
		estatesDto.setBuyerName("ghram");
		estatesDto.setPropertyName("home3");
		estatesDto.setSellingPrice(1000);
		estatesDto.setPrice(900);

		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
				"message_routing_key", estatesDto);
		System.out.println("Message sent successfully...");

	}

}
