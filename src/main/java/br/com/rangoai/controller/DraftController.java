package br.com.rangoai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rangoai.model.Draft;
import br.com.rangoai.repository.DraftRepository;

@RestController
@RequestMapping("/draft")
public class DraftController {

	@Autowired
	private DraftRepository draftRepository;

	@PostMapping("/save")
	private void save(@RequestBody String body) {

		ObjectMapper mapper = new ObjectMapper();

		Draft draft = null;

		try {

			draft = mapper.readValue(body, Draft.class);

			this.draftRepository.save(draft);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@GetMapping("/get-draft-by-uuid")
	private Draft getDraftByUuid(@RequestParam String uuid) {

		Draft draft = draftRepository.findByUuid(uuid);

		return draft;

	}

}
