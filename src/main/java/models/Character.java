package models;

import java.util.Random;

public class Character {

	private int healthPoints;
	private int strongPoints;
	
	public Character(int healthPoints, int strongPoints) {
		this.healthPoints = healthPoints;
		this.strongPoints = strongPoints;
	}

	public int attack(Character ch) {
		Random r = new Random();
		int damage = (int)(strongPoints + r.nextInt(6));
		int result = ch.getHealthPoints() - damage;
		if(ch.getHealthPoints() <= 0) {
			result = 0;
			ch.setHealthPoints(result);
		} else {
			ch.setHealthPoints(result);
		}
		return result;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getStrongPoints() {
		return strongPoints;
	}

	public void setStrongPoints(int strongPoints) {
		this.strongPoints = strongPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + healthPoints;
		result = prime * result + strongPoints;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (healthPoints != other.healthPoints)
			return false;
		if (strongPoints != other.strongPoints)
			return false;
		return true;
	}
	
	
}
