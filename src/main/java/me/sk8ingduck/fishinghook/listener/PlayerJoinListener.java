package me.sk8ingduck.fishinghook.listener;

import me.sk8ingduck.fishinghook.FishingHook;
import me.sk8ingduck.fishinghook.config.FishingConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		FishingConfig config = FishingHook.getInstance().getFishingConfig();

		if (config.isGiveRodOnJoin()) {
			if (config.isPermissionEnabled()) {
				if (player.hasPermission("fishinghook.join")) {
					player.getInventory().setItem(config.getFishingRodSlot(), config.getFishingRod());
				}
			} else {
				player.getInventory().setItem(config.getFishingRodSlot(), config.getFishingRod());
			}
		}


	}
}
