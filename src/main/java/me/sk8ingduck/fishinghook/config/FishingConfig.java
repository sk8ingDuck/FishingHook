package me.sk8ingduck.fishinghook.config;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class FishingConfig extends Config {

    private final boolean permissionEnabled;
    private final boolean giveRodOnJoin;
    private final boolean canDropRod;
    private final boolean canMoveRodInInventory;
    private final int fishingRodStrength;
    private final int fishingRodSlot;
    private final ItemStack fishingRod;
    public FishingConfig(String name, File path) {
        super(name, path);

        this.permissionEnabled = (Boolean) getPathOrSet("permissionEnabled", false);
        this.giveRodOnJoin = (Boolean) getPathOrSet("giveRodOnJoin", true);
        this.canDropRod = (Boolean) getPathOrSet("canDropFishingrod", true);
        this.canMoveRodInInventory = (Boolean) getPathOrSet("canMoveRodInInventory", true);
        this.fishingRodStrength = (int) getPathOrSet("fishingRodStrenth", 1);
        this.fishingRodSlot = (int) getPathOrSet("fishingRodSlot", 8);

        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemMeta rodMeta = rod.getItemMeta();
        rodMeta.setUnbreakable(true);
        rod.setItemMeta(rodMeta);

        this.fishingRod = (ItemStack) getPathOrSet("fishingRodItem", rod);

    }

    public boolean isPermissionEnabled() {
        return permissionEnabled;
    }

    public boolean isGiveRodOnJoin() {
        return giveRodOnJoin;
    }
    public boolean canDropRod() {
        return canDropRod;
    }
    public boolean canMoveRodInInventory() {
        return canMoveRodInInventory;
    }
    public int getFishingRodStrength() {
        return fishingRodStrength;
    }
    public int getFishingRodSlot() {
        return fishingRodSlot;
    }
    public ItemStack getFishingRod() {
        return fishingRod;
    }
}
