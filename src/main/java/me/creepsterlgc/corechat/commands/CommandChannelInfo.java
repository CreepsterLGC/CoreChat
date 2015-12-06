package main.java.me.creepsterlgc.corechat.commands;

import main.java.me.creepsterlgc.core.utils.PermissionsUtils;
import main.java.me.creepsterlgc.core.utils.TextUtils;
import main.java.me.creepsterlgc.corechat.customized.Channel;
import main.java.me.creepsterlgc.corechat.customized.Channels;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;


public class CommandChannelInfo {

	public CommandChannelInfo(CommandSource sender, String[] args) {
		
		if(args.length < 2 || args.length > 2) { sender.sendMessage(Texts.of(TextColors.YELLOW, "Usage: ", TextColors.GRAY, "/channel info <channel>")); return; }
	
		String channel = args[1].toLowerCase();
		Channel c = Channels.get(channel);
		
		if(c == null) {
			sender.sendMessage(Texts.of(TextColors.RED, "Channel not found!"));
			return;
		}
		
		if(!PermissionsUtils.has(sender, "core.channel.info." + channel)) {
			sender.sendMessage(Texts.of(TextColors.RED, "You do not have permissions to view this channel!"));
			return;
		}
		
		sender.sendMessage(Texts.of(TextColors.WHITE, "Channel: ", TextColors.GRAY, TextUtils.color(c.getName())));
		sender.sendMessage(Texts.of(TextColors.WHITE, "ID: ", TextColors.GRAY, c.getID()));
		sender.sendMessage(Texts.of(TextColors.WHITE, "Prefix: ", TextColors.GRAY, TextUtils.color(c.getPrefix())));
		sender.sendMessage(Texts.of(TextColors.WHITE, "Suffix: ", TextColors.GRAY, TextUtils.color(c.getSuffix())));
		sender.sendMessage(Texts.of(TextColors.WHITE, "Format: ", TextColors.GRAY, c.getFormat()));
		sender.sendMessage(Texts.of(TextColors.WHITE, "Range: ", TextColors.GRAY, c.getRange()));
		
	}

}
