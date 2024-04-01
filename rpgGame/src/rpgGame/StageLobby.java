package rpgGame;

public class StageLobby extends Stage{
	private final int BATTLE = 1;
	private final int EXIT =2;
	
	private static StageLobby instance = new StageLobby();
	
	private StageLobby() {
		super("LOBBY");
	}
	
	public static StageLobby getInstance() {
		return instance;
	}
	
	@Override
	public void printMenu() {
		System.out.println("======["+super.getStageName()+"]=====");
		System.out.println("[1] 전투 [2] 종료");
		runMenu();
	}
	
	private void runMenu() {
		int choice = GameManager.inputNumber("Menu");
		if(choice==BATTLE) {
			
		}
		else if(choice==EXIT)
			GameManager.isRun = false;
	}
}
