package me.sk8ingduck.fishinghook.listener;

import me.sk8ingduck.fishinghook.FishingHook;
import me.sk8ingduck.fishinghook.config.FishingConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		FishingConfig config = FishingHook.getInstance().getFishingConfig();
		if (!config.canDropRod() && event.getItemDrop().getItemStack().equals(config.getFishingRod())) {
			event.setCancelled(true);
		}
	}

}
