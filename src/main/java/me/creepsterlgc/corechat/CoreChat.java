package main.java.me.creepsterlgc.corechat;

import java.io.File;
import java.util.logging.Logger;

import main.java.me.creepsterlgc.core.files.FileCommands;
import main.java.me.creepsterlgc.corechat.commands.CommandChannel;
import main.java.me.creepsterlgc.corechat.commands.CommandNick;
import main.java.me.creepsterlgc.corechat.commands.CommandRealname;
import main.java.me.creepsterlgc.corechat.events.EventPlayerChat;
import main.java.me.creepsterlgc.corechat.files.FileChat;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "CoreChat", name = "Chat Module for Core", dependencies = "required-after:Core")

public class CoreChat {

	@Inject
	private Game game;
	
	@Inject
	Logger logger;
	
	public static CoreChat corechat;
	
	public static CoreChat getInstance() { return corechat; }
	public Game getGame() { return game; }
	
    @Listener
    public void onEnable(GameStartingServerEvent event) {
    	
    	File folder = new File("config/core/modules");
    	if(!folder.exists()) folder.mkdir();
    	
    	FileChat.setup();
    	
    	game.getEventManager().registerListeners(this, this);
    	game.getEventManager().registerListeners(this, new EventPlayerChat());
    	
    	if(FileCommands.CHANNEL()) game.getCommandDispatcher().register(this, new CommandChannel(), "channel", "ch", "c");
    	if(FileCommands.NICK()) game.getCommandDispatcher().register(this, new CommandNick(), "nick");
    	if(FileCommands.REALNAME()) game.getCommandDispatcher().register(this, new CommandRealname(), "realname");
    	
    }
	
}
