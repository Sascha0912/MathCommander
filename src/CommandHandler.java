/**
 * 
 * @author Sascha Obst
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
	private List<Command> commands;
	
	public CommandHandler(){
		commands = new ArrayList<Command>();
	}
	
	public void addCommand(String key,IfCommandInput input){
		Command c = new Command(key,input);
		commands.add(c);
	}
	
	public Command findCommand(String key){
		for (Command command : commands) {
			if(command.getKey().equalsIgnoreCase(key)){
				return command;
			}
		}
		return null;
	}
	
	public List<Command> getCommands() {
		return commands;
	}
}
