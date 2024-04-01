package rpgGame;

abstract public class Player extends Unit {
	private int lv;

	public Player(String name, int maxHp, int offensivePower, int exp) {
		super(name, maxHp, offensivePower, exp);
		this.lv = 1;
	}

	public void reciveExp(int exp) {
		String info = String.format("[%s]가 %d의 경험치를 얻었습니다!.", super.getName(), exp);
		System.out.println(info);
		super.setExp(exp);
	}

	public void checkLevelUp() {
		if (super.getExp() >= 100) {
			System.out.println("레벨 업!");
			this.lv += 1;
			super.levelUp();
		}
	}
}
