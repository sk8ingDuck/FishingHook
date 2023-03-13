package me.sk8ingduck.fishinghook;

import me.sk8ingduck.fishinghook.config.FishingConfig;
import me.sk8ingduck.fishinghook.listener.InventoryClickListener;
import me.sk8ingduck.fishinghook.listener.PlayerDropItemListener;
import me.sk8ingduck.fishinghook.listener.PlayerFishListener;
import me.sk8ingduck.fishinghook.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FishingHook extends JavaPlugin {

	private static FishingHook instance;

	private FishingConfig fishingConfig;

	@Override
	public void onEnable() {
		instance = this;

		fishingConfig = new FishingConfig("config.yml", getDataFolder());

		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static FishingHook getInstance() {
		return instance;
	}

	public FishingConfig getFishingConfig() {
		return fishingConfig;
	}
}
