package rpgGame;

abstract public class Unit {
	private int maxHp;
	private int curtHp;
	private int offensivePower;
	private String name;
	private boolean isDead;
	private int exp;
	
	public Unit(String name, int maxHp, int offensivePower,int exp) {
		this.name = name;
		this.maxHp = maxHp;
		this.curtHp = this.maxHp;
		this.offensivePower = offensivePower;
		this.isDead = false;
		this.exp = exp;
	}

	public Unit attack(Unit target) {
		String info = String.format("[%s]에게 %d의 대미지를 입혔습니다!",target.getName(), this.offensivePower);
		System.out.println(info);
		
		return this;
	}
	
	public int takeDamage(Unit target) {
		String info = String.format("[%s]에게 %d의 대미지를 받았습니다!!!", target.getName(),target.getOffensivePower());
		System.err.println(info);
		
		this.curtHp-=target.getOffensivePower();
		
		if(this.curtHp<=0) {
			System.err.println("["+this.name+"]"+"가 죽었습니다...");
			this.isDead = true;
			return this.exp;
		}
		return 0;
	}
	
	abstract public int skill();
	
	public String getName() {
		return this.name;
	}
	
	public int getOffensivePower() {
		return this.offensivePower;
	}
}
