package me.creepsterlgc.corechat.commands;

import java.util.Map.Entry;

import me.creepsterlgc.core.utils.PermissionsUtils;
import me.creepsterlgc.core.utils.TextUtils;
import me.creepsterlgc.corechat.customized.Channel;
import me.creepsterlgc.corechat.customized.Channels;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.CommandSource;


public class CommandChannelList {

	public CommandChannelList(CommandSource sender, String[] args) {
		
		if(!PermissionsUtils.has(sender, "core.channel.list")) { sender.sendMessage(Texts.builder("You do not have permissions!").color(TextColors.RED).build()); return; }
		
		if(args.length != 1) { sender.sendMessage(Texts.of(TextColors.YELLOW, "Usage: ", TextColors.GRAY, "/channel list")); return; }

		sender.sendMessage(Texts.of(TextColors.GRAY, "Found ", TextColors.YELLOW, Channels.all().size(), TextColors.GRAY, " channels:"));
		for(Entry<String, Channel> e : Channels.all().entrySet()) {
			sender.sendMessage(Texts.of(TextColors.GRAY, "- ", TextColors.WHITE, TextUtils.color(e.getValue().getName()), TextColors.GRAY, " (", e.getKey(), ")"));
		}
		
	}

}
