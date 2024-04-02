package rpgGame;

public class MonsterSlime extends Monster{


	public MonsterSlime( int maxHp, int offensivePower, int exp) {
		super("슬라임", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		int heal = this.getOffensivePower()*3;
		String info = String.format("[%s]가 자가회복을 사용하였습니다. 체력 %d가 회복합니다.", this.getName(),heal);
		System.out.println(info);
		this.setCurHp(heal);
		return 0;
	}
}
