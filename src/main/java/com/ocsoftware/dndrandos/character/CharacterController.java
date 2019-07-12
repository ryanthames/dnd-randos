package com.ocsoftware.dndrandos.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
  private CharacterService characterService;

  @Autowired
  public CharacterController(CharacterService characterService) {
    this.characterService = characterService;
  }

  @GetMapping("/createRando")
  public DnDCharacter createRando() {
    return characterService.createRandoCharacter();
  }
}
