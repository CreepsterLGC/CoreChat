package me.creepsterlgc.corechat.customized;

import java.util.HashMap;

public class Channels {

	private static HashMap<String, Channel> channels = new HashMap<String, Channel>();
	public static void add(String name, Channel channel) { if(!channels.containsKey(name)) channels.put(name, channel); }
	public static void remove(String name) { if(channels.containsKey(name)) channels.remove(name); }
	public static Channel get(String name) { return channels.containsKey(name) ? channels.get(name) : null; }
	public static HashMap<String, Channel> all() { return channels; }
	
}
