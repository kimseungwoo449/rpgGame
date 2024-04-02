package rpgGame;

public class MonsterWolf extends Monster{

	public MonsterWolf( int maxHp, int offensivePower, int exp) {
		super("늑대", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		String info = String.format("[%s]가 물어뜯기를 시전하였습니다.", this.getName());
		System.out.println(info);
		int attack = (int)(this.getOffensivePower()*1.5);
		return attack;
	}
}
