package me.blendycat.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.blendycat.screen.Screen;
import me.blendycat.util.Sprite;

public class Main extends JavaPlugin{
	private HashMap<String,Screen> screens = new HashMap<String,Screen>();
	@Override
	public void onEnable(){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.runTaskTimer(this, new Runnable() {	
            @Override
            public void run() {
				update(1L);
            }
            
        }, 0L, 1L);
	}

	@Override
	public void onDisable(){
		
	}
	
	
	//Updates the sprites postion and determines whether it needs a velocity change
	public void update(long l) {
		for(Screen screen : screens.values()){
			screen.update(l);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("createscreen") && sender instanceof Player){
			if(args.length>0){
				Player player = (Player) sender;
				Location location = player.getLocation();
				Sprite sprite = new Sprite(new Location(
						location.getWorld(),
						location.getBlockX(),
						location.getBlockY(),
						location.getBlockZ()));
				sprite.setVX(Float.parseFloat(args[3]));
				sprite.setVY(Float.parseFloat(args[4]));
				Screen screen = new Screen(sprite.getBlockLocation(), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				screen.addSprite(sprite);
				screens.put(args[0], screen);
			}
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("deletescreen")){
			if(args.length==1){
				if(screens.containsKey(args[0])){
					screens.remove(args[0]);
				}
			}
			return true;
		}
		return false;
	}
	
}
