package com.ocsoftware.dndrandos;

import com.ocsoftware.dndrandos.character.CharacterService;
import com.ocsoftware.dndrandos.character.DnDCharacter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterServiceTest {
  @Autowired
  private CharacterService service;

  @Test
  public void testAbilityModifierForScore3IsNegative4() {
    assertEquals(-4, service.calculateModifier(3));
  }

  @Test
  public void testAbilityModifierForScore4IsNegative3() {
    assertEquals(-3, service.calculateModifier(4));
  }

  @Test
  public void testAbilityModifierForScore5IsNegative3() {
    assertEquals(-3, service.calculateModifier(5));
  }

  @Test
  public void testAbilityModifierForScore6IsNegative2() {
    assertEquals(-2, service.calculateModifier(6));
  }

  @Test
  public void testAbilityModifierForScore7IsNegative2() {
    assertEquals(-2, service.calculateModifier(7));
  }

  @Test
  public void testAbilityModifierForScore8IsNegative1() {
    assertEquals(-1, service.calculateModifier(8));
  }

  @Test
  public void testAbilityModifierForScore9IsNegative1() {
    assertEquals(-1, service.calculateModifier(9));
  }

  @Test
  public void testAbilityModifierForScore10Is0() {
    assertEquals(0, service.calculateModifier(10));
  }

  @Test
  public void testAbilityModifierForScore11Is0() {
    assertEquals(0, service.calculateModifier(11));
  }

  @Test
  public void testAbilityModifierForScore12Is1() {
    assertEquals(1, service.calculateModifier(12));
  }

  @Test
  public void testAbilityModifierForScore13Is1() {
    assertEquals(1, service.calculateModifier(13));
  }

  @Test
  public void testAbilityModifierForScore14Is2() {
    assertEquals(2, service.calculateModifier(14));
  }

  @Test
  public void testAbilityModifierForScore15Is2() {
    assertEquals(2, service.calculateModifier(15));
  }

  @Test
  public void testAbilityModifierForScore16Is3() {
    assertEquals(3, service.calculateModifier(16));
  }

  @Test
  public void testAbilityModifierForScore17Is3() {
    assertEquals(3, service.calculateModifier(17));
  }

  @Test
  public void testAbilityModifierForScore18Is4() {
    assertEquals(4, service.calculateModifier(18));
  }

  @Test
  public void testRandomAbilityIsWithinRange() {
    int score = service.generateAbility();
    assertTrue(score > 2 && score < 19);
  }

  @Test
  public void testRandomCharacterIsValid() {
    for (int i = 0; i < 1000; i++) {
      DnDCharacter character = service.createRandoCharacter();
      assertTrue(character.getStrength() > 2 && character.getStrength() < 19);
      assertTrue(character.getDexterity() > 2 && character.getDexterity() < 19);
      assertTrue(character.getConstitution() > 2 && character.getConstitution() < 19);
      assertTrue(character.getIntelligence() > 2 && character.getIntelligence() < 19);
      assertTrue(character.getWisdom() > 2 && character.getWisdom() < 19);
      assertTrue(character.getCharisma() > 2 && character.getCharisma() < 19);
      assertEquals(character.getHitpoints(),
          10 + service.calculateModifier(character.getConstitution()));
    }
  }

  @Test
  public void testEachAbilityIsOnlyCalculatedOnce() {
    DnDCharacter character = service.createRandoCharacter();
    assertEquals(character.getStrength(), character.getStrength());
  }
}
