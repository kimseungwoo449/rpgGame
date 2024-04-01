package rpgGame;

abstract public class Unit {
	private int maxHp;
	private int curHp;
	private int offensivePower;
	private String name;
	private boolean isDead;
	private int exp;

	public Unit(String name, int maxHp, int offensivePower, int exp) {
		this.name = name;
		this.maxHp = maxHp;
		this.curHp = this.maxHp;
		this.offensivePower = offensivePower;
		this.isDead = false;
		this.exp = exp;
	}

	public Unit attack(Unit target) {
		String info = String.format("[%s]가 [%s]에게 %d의 대미지를 입혔습니다!", this.name, target.getName(), this.offensivePower);
		System.out.println(info);

		return this;
	}

	public int takeDamage(Unit target) {
		String info = String.format("[%s]가 [%s]에게 %d의 대미지를 받았습니다!!!", this.name, target.getName(),
				target.getOffensivePower());
		System.err.println(info);

		this.curHp -= target.getOffensivePower();

		if (this.curHp <= 0) {
			System.err.println("[" + this.name + "]" + "가 죽었습니다...");
			this.isDead = true;
			return this.exp;
		}
		return 0;
	}

	abstract public int skill(Unit target);

	public String getName() {
		return this.name;
	}

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp += exp;
	}

	public int getOffensivePower() {
		return this.offensivePower;
	}

	public void setCurHp(int heal) {
		if (curHp + heal > maxHp) {
			this.curHp = this.maxHp;
			return;
		}

		curHp += heal;
	}

	public void levelUp() {
		this.exp -= 100;
		this.maxHp += this.maxHp / 3;
		this.curHp = this.maxHp;
		this.offensivePower += this.offensivePower / 3;
	}
}
