/**
 * 
 * @author Sascha Obst
 * @version 1.0
 * 
 */


public class Command {
	private String key;
	private IfCommandInput input;
	
	public Command(String key, IfCommandInput input) {
		this.key = key;
		this.input = input;
	}

	public String getKey() {
		return key;
	}

	public IfCommandInput getInput() {
		return input;
	}
	
	public void ausfuehren(String eingabe){
		input.ausfuehren(eingabe);
	}

}
