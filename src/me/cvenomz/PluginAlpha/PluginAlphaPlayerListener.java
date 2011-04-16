package me.cvenomz.PluginAlpha;

import com.nijiko.permissions.PermissionHandler;
import org.bukkit.event.player.*;

public class PluginAlphaPlayerListener extends org.bukkit.event.player.PlayerListener{

	private final PluginAlpha plugin;
	private final PermissionHandler permissions;
	
	public PluginAlphaPlayerListener(PluginAlpha instance, PermissionHandler perm)
	{
		plugin = instance;
		permissions = perm;
	}
	
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		if (plugin.activeList.contains(e.getPlayer()))
			e.getPlayer().sendMessage("" + e.getItem().getType().getId());
		//else
			//e.getPlayer().sendMessage("You dont gots da privs");
	}
	
	
}
