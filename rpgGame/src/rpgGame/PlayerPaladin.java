package rpgGame;

public class PlayerPaladin extends Player {

	public PlayerPaladin() {
		super("성기사", 800, 60, 0);
	}
	
	@Override
	public int skill(Unit target) {
		int myOffensivePower = super.getOffensivePower();
		int heal = myOffensivePower*3;
		String info = String.format("체력을 %d 회복 했습니다.", heal);
		System.out.println(info);
		super.setCurHp(heal);
		return 0;
	}
	
}
