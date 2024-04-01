package rpgGame;

abstract public class Stage {
	private String stageName;
	
	public Stage(String name) {
		this.stageName = name;
	}
	
	public String getStageName() {
		return this.stageName;
	}
	
	abstract public void printMenu();
}
