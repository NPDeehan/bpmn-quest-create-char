package org.camunda.bpmn.quest.CharacterCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;

public class MaterializeMonsterDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		List<CharacterModel> monsters = generateMonsterPool();
		
		Random rn = new Random();
		int randomNumber = rn.nextInt(2) + 1;
		
		CharacterModel thisMonster = monsters.get(randomNumber);
		
		ObjectValue monsterDataValue = Variables.objectValue(thisMonster)
				  .serializationDataFormat(Variables.SerializationDataFormats.JSON)
				  .create();
		
		execution.setVariable("thisMonster", monsterDataValue);
		
		// Just for Testing
		CharacterModel player = new CharacterModel("jakob", "Jakob the Hero", 50, 50, 50, 50, 50, 10, 150);
		execution.setVariable("playerCharacter", player);
		

	}
	
	private List<CharacterModel> generateMonsterPool () {
		
		List<CharacterModel> monsters = new ArrayList<CharacterModel>();

		monsters.add(new CharacterModel(
				"alfredo",
				"Alfredo",
				30, // Strength
				30, // Perception
				30, // Endurance
				30, // Charisma
				30, // Intelligence
				30, // Agility
				30 // Luck
				));
	
		monsters.add(new CharacterModel(
				"booneeda",
				"Boo Needa",
				40, // Strength
				30, // Perception
				30, // Endurance
				30, // Charisma
				30, // Intelligence
				70, // Agility
				40 // Luck
				));

		monsters.add(new CharacterModel(
				"lordwebsfear",
				"Lord Web's Fear",
				100, // Strength
				30, // Perception
				30, // Endurance
				30, // Charisma
				30, // Intelligence
				10, // Agility
				20 // Luck
				));
		
		return monsters;		
	}

}
