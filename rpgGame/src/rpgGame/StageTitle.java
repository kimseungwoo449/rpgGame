package rpgGame;

public class StageTitle extends Stage{
	private String stageName;
	private boolean isRun;
	
	private static StageTitle instance = new StageTitle();
	
	private StageTitle() {
		this.stageName = "TITLE";
		this.isRun = true;
	}
	
	public static StageTitle getInstance() {
		return instance;
	}
	
	@Override
	public void printMenu() {
		while(this.isRun) {
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
		if(input.equals("시작")) {
			GameManager.isRun = true;
			this.isRun = false;
		}
		else if(input.equals("종료")) {
			GameManager.isRun = false;
			this.isRun = false;
		}
	}
}
