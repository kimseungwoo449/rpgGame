package rpgGame;

import java.util.Scanner;

public class GameManager {
	public static Scanner sc = new Scanner(System.in);
	public static boolean isRun;
	private StageTitle stageTitle = StageTitle.getInstance();
	private StageLobby stageLobby = StageLobby.getInstance();
	private Player player;
	
	
	public GameManager() {
		isRun = false;
	}
	
	public static String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	public static int inputNumber(String message) {
		int number = -1;
		try {
			System.out.print(message + " : ");
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자로 입력해 주세요.");
		}
		return number;
	}
	
	public void run() {
		stageTitle.printMenu();
		player = stageTitle.getPlayer();
		
	}
	
}
