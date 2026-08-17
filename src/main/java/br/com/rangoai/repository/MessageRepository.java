package br.com.rangoai.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rangoai.model.Message;
import br.com.rangoai.model.MessageType;

public interface MessageRepository extends JpaRepository<Message, Long> {
	
	List<Message> findByUuidAndDateAfter(String uuid, LocalDateTime dateTime);
	
	/*List<Message> findByUuid(String uuid);
	
	List<Message> findByUuidContainingAndType(String uuid, MessageType type);*/

}
