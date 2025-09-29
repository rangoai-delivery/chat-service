package br.com.rangoai.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rangoai.model.Message;
import br.com.rangoai.repository.MessageRepository;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private Environment environment;

	@GetMapping("/status")
	public String status() {

		return "Ok. Port: " + this.environment.getProperty("server.port");

	}

	
	@PostMapping("/save")
	private void save(@RequestBody String body) {

		ObjectMapper mapper = new ObjectMapper();

		Message message = null;

		try {

			message = mapper.readValue(body, Message.class);

			message.setDate(new Date());

			this.messageRepository.save(message);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	
	@GetMapping("/get-messages-by-uuid")
	private List<Message> getMessagesByCustomerId(@RequestParam String uuid) {

		List<Message> messages = messageRepository.findByUuidAndDateAfter(uuid, LocalDateTime.now().minusHours(6));

		return messages;

	}

}
