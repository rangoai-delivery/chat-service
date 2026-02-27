package br.com.rangoai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rangoai.model.Draft;

public interface DraftRepository extends JpaRepository<Draft, Long> {
	
	Draft findByUuid(String uuid);

}
