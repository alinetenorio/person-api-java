package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;

@RestController // controller will be acessed trough RestAPI
@RequestMapping("/api/v1/people")
public class PersonController {

  private PersonRepository personRepository;

  public PersonController(PersonRepository personRepository){
    this.personRepository = personRepository;
  }
  
  @PostMapping
  public MessageResponseDTO createPerson(@RequestBody Person person) {
    Person savedPerson = personRepository.save(person);
    return MessageResponseDTO
            .builder()
            .message("Person created with ID: " + savedPerson.getId())
            .build();
  }
}
