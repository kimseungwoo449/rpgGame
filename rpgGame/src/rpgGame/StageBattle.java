package rpgGame;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	private Random ran = new Random();

	private final int ATTACK = 1;
	private final int SKILL = 2;

	private Player player;

	private ArrayList<Unit> monsters;

	public StageBattle(Player player, ArrayList<Unit> monsters) {
		super("BATTLE");
		this.player = player;
		this.monsters = monsters;
	}

	@Override
	public void printMenu() {
		System.out.println("========[" + super.getStageName() + "]=======");
		while (checkNext()) {
			System.out.println("========[PLAYER]=======");
			System.out.println(player);
			System.out.println("========[MONSTER]=======");
			for (Unit monster : monsters)
				System.out.println(monster);
			System.out.println("[1] 어택 [2] 스킬");
			runMenu();
		}
		result();
		GameManager.battle = false;
	}

	private boolean checkNext() {
		int numberOfMonster = this.monsters.size();
		int count = 0;
		for (Unit monster : monsters) {
			if (monster.isDead())
				count++;
		}

		if (count != numberOfMonster && !player.isDead()) {
			return true;
		}
		return false;
	}

	private void runMenu() {
		int choice = GameManager.inputNumber("Menu");
		if (choice == ATTACK)
			attack();
		else if (choice == SKILL)
			skill();
	}

	private void attack() {
		Unit monster = null;
		while (true) {
			int rMonster = ran.nextInt(monsters.size());
			monster = monsters.get(rMonster);

			if (!monster.isDead())
				break;
		}
		int attack = player.getOffensivePower();
		
		if (player instanceof PlayerWarrior && ((PlayerWarrior) player).isSkilled()) {
			attack*=3;
			((PlayerWarrior) player).setIsSkilled();
		}

		monster.takeDamage(player, attack);
		takeDamage();
	}

	private void takeDamage() {
		for (Unit monster : monsters) {
			if (!monster.isDead() && !player.isDead()) {
				int attack = monster.getOffensivePower();
				player.takeDamage(monster, attack);
			}
		}
	}

	private void skill() {
		Unit monster = null;
		while (true) {
			int rMonster = ran.nextInt(monsters.size());
			monster = monsters.get(rMonster);

			if (!monster.isDead())
				break;
		}
		if (player instanceof PlayerWizard) {
			int attack = player.skill(monster);
			monster.takeDamage(player, attack);
			takeDamage();
		} else if (player instanceof PlayerPaladin || player instanceof PlayerWarrior) {
			player.skill(monster);
			takeDamage();
		}

	}

	private void result() {
		if (player.isDead()) {
			System.err.println("GAME OVER...");
			GameManager.isRun = false;
			return;
		}

		for (Unit monster : monsters) {
			int exp = monster.getExp();
			player.setExp(exp);
			player.checkLevelUp();
		}
	}

}
