package com.ocsoftware.dndrandos.character;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class CharacterService {
  private static final int DIE_SIZE = 6;
  private static final int STARTING_HP = 10;

  public DnDCharacter createRandoCharacter() {
    DnDCharacter dndCharacter = new DnDCharacter();

    dndCharacter.setCharisma(generateAbility());
    dndCharacter.setConstitution(generateAbility());
    dndCharacter.setDexterity(generateAbility());
    dndCharacter.setIntelligence(generateAbility());
    dndCharacter.setStrength(generateAbility());
    dndCharacter.setWisdom(generateAbility());

    int hpModifier = STARTING_HP + calculateModifier(dndCharacter.getConstitution());
    dndCharacter.setHitpoints(hpModifier);

    return dndCharacter;
  }

  private int rollDice() {
    return new Random().nextInt(DIE_SIZE) + 1;
  }

  public int generateAbility() {
    List<Integer> rolls = new ArrayList<>();

    IntStream.range(0, 4).forEach(i -> rolls.add(rollDice()));
    Collections.sort(rolls, Collections.reverseOrder());
    rolls.remove(rolls.size() - 1);

    return rolls.stream().mapToInt(Integer::intValue).sum();
  }

  public int calculateModifier(int input) {
    return Math.floorDiv(input - STARTING_HP, 2);
  }

}
