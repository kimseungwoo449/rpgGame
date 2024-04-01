package rpgGame;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	private Random ran = new Random();
	private String path;
	private String monsterName[];
	
	private static UnitManager instance = new UnitManager();
	
	private UnitManager() {
		monsterName = new String[] { "UnitOrc", "UnitSlime", "UnitWolf" };
	}

	public ArrayList<Unit> createMonsters() {
		ArrayList<Unit> monsters = new ArrayList<Unit>();
		Class<?> params[] = new Class<?>[] { int.class, int.class, int.class };
		int rNum = ran.nextInt(5);
		for (int i = 0; i < rNum; i++) {
			int rIndex = ran.nextInt(3);
			path = "rpgGame." + monsterName[rIndex];

			try {
				Class<?> clazz = Class.forName(path);
				int hp = ran.nextInt(100) + 120;
				int power = ran.nextInt(10) + 15;
				int exp = ran.nextInt(15) + 10;
				Object obj = clazz.getDeclaredConstructor(params).newInstance(hp, power, exp);
				Unit temp = (Unit)obj;
				monsters.add(temp);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return monsters;
	}
	
	public static UnitManager getInstance() {
		return instance;
	}
	
}
