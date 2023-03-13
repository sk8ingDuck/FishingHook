package me.sk8ingduck.fishinghook.listener;

import me.sk8ingduck.fishinghook.FishingHook;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!FishingHook.getInstance().getFishingConfig().canMoveRodInInventory()
				&& event.getSlot() == FishingHook.getInstance().getFishingConfig().getFishingRodSlot()
				&& !event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
			event.setCancelled(true);
		}
	}
}
