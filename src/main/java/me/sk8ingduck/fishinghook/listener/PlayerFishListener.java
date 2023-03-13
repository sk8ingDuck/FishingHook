package me.sk8ingduck.fishinghook.listener;

import me.sk8ingduck.fishinghook.FishingHook;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class PlayerFishListener implements Listener {

	@EventHandler
	public void onPlayerFish(PlayerFishEvent event) {
		Player player = event.getPlayer();

		if (FishingHook.getInstance().getFishingConfig().isPermissionEnabled() && !player.hasPermission("fishinghook.use")) {
			return;
		}

		Location playerLoc = player.getLocation();
		Location hookLoc = event.getHook().getLocation();

		Material blockBelow = hookLoc.subtract(0, 0.1, 0).getBlock().getType();
		if ((event.getState() == PlayerFishEvent.State.FAILED_ATTEMPT
				&& blockBelow != Material.AIR
				&& blockBelow != Material.WATER
				&& blockBelow != Material.LAVA)
				|| event.getState() == PlayerFishEvent.State.IN_GROUND) {
			Vector boost = player.getVelocity();
			boost.setY(0.3);
			player.setVelocity(boost);
			Bukkit.getScheduler().scheduleSyncDelayedTask(FishingHook.getInstance(), () -> {
				double gravity = -0.08;
				double dist = hookLoc.distance(playerLoc);
				double v_x = (1.0 + 0.07 * dist) * (hookLoc.getX() - playerLoc.getX()) / dist;
				double v_y = (1.0 + 0.03 * dist) * (hookLoc.getY() - playerLoc.getY()) / dist - 0.5 * gravity * dist;
				double v_z = (1.0 + 0.07 * dist) * (hookLoc.getZ() - playerLoc.getZ()) / dist;

				Vector v = player.getVelocity();
				v.setX(v_x);
				v.setY(v_y);
				v.setZ(v_z);
				v.multiply(FishingHook.getInstance().getFishingConfig().getFishingRodStrength());
				player.setVelocity(v);
			}, 1L);

		}
	}


}
