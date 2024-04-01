package rpgGame;

public class PlayerWizard extends Player{

	public PlayerWizard(String name, int maxHp, int offensivePower, int exp) {
		super(name, maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		System.out.println("[파이어 볼] 발동!");
		String info = String.format("[%s]가 [%s]에게 %d의 대미지를 입혔습니다!", super.getName(), target.getName(), (int)super.getOffensivePower()*1.5);
		System.out.println(info);
		return (int) (super.getOffensivePower()*1.5);
	}

}