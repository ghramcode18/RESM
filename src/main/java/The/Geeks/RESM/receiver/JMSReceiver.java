package The.Geeks.RESM.receiver;

import org.springframework.stereotype.Component;

import The.Geeks.RESM.dto.EstatesDto;

@Component

public class JMSReceiver {
    
    public void receiveMessage(EstatesDto estatesDto)
	{
		System.out.println("Received <" + estatesDto + ">");
	}
}
