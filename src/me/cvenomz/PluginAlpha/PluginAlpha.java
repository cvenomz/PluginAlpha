package me.cvenomz.PluginAlpha;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.*;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.player.*;

public class PluginAlpha extends JavaPlugin{
	
	public static PermissionHandler permissions;
	private PluginAlphaPlayerListener playerListener = new PluginAlphaPlayerListener(this, permissions);
	private static final Logger log = Logger.getLogger("Minecraft");
	public ArrayList<Player> activeList;

	/*public PluginAlpha(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader)
	{
		//initialize(getServer().getPluginManager(), getServer(), new File("plugin.yml"), new File("PluginAlpha"), new File("PluginAlpha.jar"), );
	}
	
	public PluginAlpha()
	{
		//super();
	}*/
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		log.info("PluginAlpha Initializing...");
		setupPermissions();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
		activeList = new ArrayList<Player>();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("pa")){
			//toggleTD((Player) sender);
			sender.sendMessage("K Thx");
			if (activeList.contains(sender)){
				activeList.remove(sender); sender.sendMessage("deactivated");}
			else{
				activeList.add((Player)sender); sender.sendMessage("activated");}
			return true;
		}
		return false;
	}
	
	private void setupPermissions() {
	      Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");

	      if (this.permissions == null) {
	          if (test != null) {
	              this.permissions = ((Permissions)test).getHandler();
	          } else {
	              log.info("Permission system not detected, defaulting to OP");
	          }
	      }
	  }

}
