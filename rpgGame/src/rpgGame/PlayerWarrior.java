package rpgGame;

public class PlayerWarrior extends Player {
	private boolean isSkilled;

	public PlayerWarrior() {
		super("전사", 1000, 65, 0);
		this.isSkilled = false;
	}

	@Override
	public int skill(Unit target) {
		if(isSkilled) {
			System.err.println("공격이 이미 강화된 상태입니다.");
			return 1;
		}
		System.out.println("다음 턴의 공격력이 3배가 됩니다.");
		this.isSkilled = true;
		return 0;
	}

	public boolean isSkilled() {
		return this.isSkilled;
	}

	public void setIsSkilled() {
		this.isSkilled = this.isSkilled == false ? true : false;
	}

}
