package rpgGame;

public class StageTitle extends Stage {
	private boolean isRun;

	private static StageTitle instance = new StageTitle();

	private StageTitle() {
		super("TITLE");
		this.isRun = true;
	}

	public static StageTitle getInstance() {
		return instance;
	}

	@Override
	public void printMenu() {
		while (this.isRun) {
			System.out.println("========[" + super.getStageName() + "]=======");
			System.out.println("==== Console RPG ====");
			System.out.println("\t[시작]");
			System.out.println("\t[종료]");
			System.out.println("[시작]을 입력해 주세요...");
			System.out.println("=====================");
			runMenu();
		}
	}

	private void runMenu() {
		String input = GameManager.inputString("Input");
		if (input.equals("시작")) {
			GameManager.isRun = true;
			this.isRun = false;
		} else if (input.equals("종료")) {
			GameManager.isRun = false;
			this.isRun = false;
		}
	}

	private void printPlayer() {
		System.out.println("[1] 전사");
		System.out.println("[2] 마법사");
		System.out.println("[3] 성기사");
	}

	private String choicePlayer() {
		String name = null;
		while (true) {
			int choice = GameManager.inputNumber("영웅 선택");

			if (choice < 1 || choice > 3)
				continue;

			if (choice == 1)
				name = "PlayerWarrior";
			else if (choice == 2)
				name = "PlayerWizard";
			else if (choice == 3)
				name = "PlayerPaladin";
			break;
		}
		return name;
	}

	private Object setPlayer(String name) {
		Object obj = null;
		try {
			Class<?> temp = Class.forName("rpgGame." + name);
			obj = temp.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Player getPlayer() {
		if (GameManager.isRun) {
			printPlayer();
			String name = choicePlayer();
			Object obj = setPlayer(name);

			if (obj instanceof PlayerWarrior) {
				PlayerWarrior player = (PlayerWarrior) obj;
				return player;
			} else if (obj instanceof PlayerWizard) {
				PlayerWizard player = (PlayerWizard) obj;
				return player;
			} else if (obj instanceof PlayerPaladin) {
				PlayerPaladin player = (PlayerPaladin) obj;
				return player;
			}
		}
		return null;
	}
}
