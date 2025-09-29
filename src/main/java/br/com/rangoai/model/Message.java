package br.com.rangoai.model;

import java.util.Date;
import java.util.Objects;

import br.com.rangoai.util.SQLTextLength;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String messageBefore;

	private String messageAfter;

	@Column(length = SQLTextLength.mediumText)
	private String products;
	
	@Enumerated(EnumType.STRING)
	private MessageType type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String uuid;

	public Message() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageBefore() {
		return messageBefore;
	}

	public void setMessageBefore(String messageBefore) {
		this.messageBefore = messageBefore;
	}

	public String getMessageAfter() {
		return messageAfter;
	}

	public void setMessageAfter(String messageAfter) {
		this.messageAfter = messageAfter;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id);
	}
}
