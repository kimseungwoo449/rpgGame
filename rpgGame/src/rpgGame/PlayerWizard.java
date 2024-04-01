package rpgGame;

public class PlayerWizard extends Player {

	public PlayerWizard() {
		super("마법사", 700, 50, 0);
	}

	@Override
	public int skill(Unit target) {
		System.out.println("[파이어 볼] 발동!");
		int myOffensivePower = super.getOffensivePower();
		int attack = myOffensivePower + (int) (myOffensivePower * 1.5);
		String info = String.format("[%s]가 [%s]에게 %d의 대미지를 입혔습니다!", super.getName(), target.getName(), attack);
		System.out.println(info);
		return attack;
	}

}
