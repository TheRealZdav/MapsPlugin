package com.oresomecraft.BattleMaps.maps;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.*;

import com.oresomecraft.BattleMaps.*;
import com.oresomecraft.OresomeBattles.api.*;

public class Mutiny extends BattleMap implements IBattleMap, Listener {

    public Mutiny() {
        super.initiate(this, name, fullName, creators, modes);
        disableDrops(new Material[]{Material.IRON_AXE, Material.DIAMOND_BOOTS, Material.GOLD_LEGGINGS, Material.IRON_CHESTPLATE, Material.LEATHER_HELMET});
    }

    String name = "mutiny";
    String fullName = "Mutiny";
    String creators = "DynaDavidson and JacquiRose";
    Gamemode[] modes = {Gamemode.TDM};

    public void readyTDMSpawns() {
        redSpawns.add(new Location(w, 3, 72, -38));
        redSpawns.add(new Location(w, 1, 77, -19));
        redSpawns.add(new Location(w, 1, 70, -60));
        blueSpawns.add(new Location(w, -38, 72, -38));
        blueSpawns.add(new Location(w, -36, 70, -18));
        blueSpawns.add(new Location(w, -36, 77, -56));
    }

    public void readyFFASpawns() {
        FFASpawns.add(new Location(w, 3, 72, -38));
        FFASpawns.add(new Location(w, 1, 77, -19));
        FFASpawns.add(new Location(w, 1, 70, -60));
        FFASpawns.add(new Location(w, -38, 72, -38));
        FFASpawns.add(new Location(w, -36, 70, -18));
        FFASpawns.add(new Location(w, -36, 77, -56));
    }

    public void applyInventory(final BattlePlayer p) {
        Inventory i = p.getInventory();

        ItemStack HEALTH = new ItemStack(Material.GOLDEN_APPLE, 2);
        ItemStack STEAK = new ItemStack(Material.COOKED_BEEF, 1);
        ItemStack BOW = new ItemStack(Material.BOW, 1);
        ItemStack ARROWS = new ItemStack(Material.ARROW, 64);
        ItemStack LOGS = new ItemStack(Material.LOG, 12);
        //You need more resources
        ItemStack AXE = new ItemStack(Material.IRON_AXE, 1);
        //So people will stop making wood swords
        ItemStack IRON_HELMET = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack IRON_CHESTPLATE = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack IRON_PANTS = new ItemStack(Material.GOLD_LEGGINGS, 1);
        ItemStack IRON_BOOTS = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemStack STONE_SWORD = new ItemStack(Material.STONE_SWORD, 1);

        p.getInventory().setBoots(IRON_BOOTS);
        p.getInventory().setLeggings(IRON_PANTS);
        p.getInventory().setChestplate(IRON_CHESTPLATE);
        p.getInventory().setHelmet(IRON_HELMET);

        i.setItem(0, STONE_SWORD);
        i.setItem(1, BOW);
        i.setItem(0, AXE);
        i.setItem(2, STEAK);
        i.setItem(3, HEALTH);
        i.setItem(4, LOGS);
        i.setItem(10, ARROWS);


    }

    // Region. (Top corner block and bottom corner block.
    // Top left corner.
    public int x1 = -50;
    public int y1 = 50;
    public int z1 = -76;

    //Bottom right corner.
    public int x2 = 13;
    public int y2 = 119;
    public int z2 = -4;

    // Getting the region
    public boolean contains(Location loc, int x1, int x2, int y1,
                            int y2, int z1, int z2) {
        int bottomCornerX = x1 < x2 ? x1 : x2;
        int bottomCornerZ = z1 < z2 ? z1 : z2;
        int topCornerX = x1 > x2 ? x1 : x2;
        int topCornerZ = z1 > z2 ? z1 : z2;
        int bottomCornerY = y1 < y2 ? y1 : y2;
        int topCornerY = y1 > y2 ? y1 : y2;
        if (loc.getX() >= bottomCornerX && loc.getX() <= topCornerX) {
            if (loc.getZ() >= bottomCornerZ && loc.getZ() <= topCornerZ) {
                if (loc.getY() >= bottomCornerY && loc.getY() <= topCornerY) {
                    return true;
                }
            }
        }
        return false;

    }
}
