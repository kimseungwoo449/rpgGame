package rpgGame;

public class MonsterOrc extends Monster{

	
	public MonsterOrc( int maxHp, int offensivePower, int exp) {
		super("오크", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		String info = String.format("[%s]가 강타를 시전하였습니다.", this.getName());
		System.out.println(info);
		int attack = this.getOffensivePower()*2;
		return attack;
	}
}
