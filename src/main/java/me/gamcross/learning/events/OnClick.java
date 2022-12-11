package me.gamcross.learning.events;

import me.gamcross.learning.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftInventory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnClick implements Listener {
    private Main main; // Main class
    public OnClick(Main main) {
        this.main = main;
    }

    // This is a method that is called when a player clicks
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer(); // Get the player who clicked
        Action action = event.getAction(); // Get the action of the click

        // Check if player right-clicked
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // Check if player is holding a COMPASS
            if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS) {
                // Create a new inventory Menu
                Inventory inv = Bukkit.createInventory(null, 27, "Menu");

                //test if main.getConfig().getString("menu.item1.material") is a valid material
                Material material = Material.getMaterial(main.getConfig().getString("menu.item1.material"));
                if (material == null) {
                    material = Material.STONE;
                }
                else {
                    material = Material.getMaterial(main.getConfig().getString("menu.item1.material"));
                }
                // Create a new ItemStack with a name and material is defined in config.yml
                ItemStack item = new ItemStack(material, 1);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("§6Game 1");
                item.setItemMeta(meta);
                inv.setItem(10, item);

                //test if main.getConfig().getString("menu.item2.material") is a valid material
                material = Material.getMaterial(main.getConfig().getString("menu.item2.material"));
                if (material == null) {
                    material = Material.STONE;
                }
                else {
                    material = Material.getMaterial(main.getConfig().getString("menu.item2.material"));
                }
                item = new ItemStack(material, 1);
                meta = item.getItemMeta();
                meta.setDisplayName("§6Game 2");
                item.setItemMeta(meta);
                inv.setItem(12, item);

                //test if main.getConfig().getString("menu.item3.material") is a valid material
                material = Material.getMaterial(main.getConfig().getString("menu.item3.material"));
                if (material == null) {
                    material = Material.STONE;
                }
                else {
                    material = Material.getMaterial(main.getConfig().getString("menu.item3.material"));
                }
                item = new ItemStack(material, 1);
                meta = item.getItemMeta();
                meta.setDisplayName("§6Game 3");
                item.setItemMeta(meta);
                inv.setItem(14, item);

                //test if main.getConfig().getString("menu.item4.material") is a valid material
                material = Material.getMaterial(main.getConfig().getString("menu.item4.material"));
                if (material == null) {
                    material = Material.STONE;
                }
                else {
                    material = Material.getMaterial(main.getConfig().getString("menu.item4.material"));
                }
                item = new ItemStack(material, 1);
                meta = item.getItemMeta();
                meta.setDisplayName("§6Game 4");
                item.setItemMeta(meta);
                inv.setItem(16, item);

                // Open the inventory menu for the player
                player.openInventory(inv);
            }
        }

        // Check if player left-clicked
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
        }
    }

    // This is called when a player clicks in an inventory
    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        // Check if the inventory is the one we created
        if (event.getView().getTitle().equals("Menu")) {
            // Cancel the event so the player doesn't take the item
            event.setCancelled(true);
            // Get the player who clicked
            Player player = (Player) event.getWhoClicked();
            // Get the item that was clicked
            ItemStack item = event.getCurrentItem();
            // Close the inventory
            player.closeInventory();
            // Check if the item is null
            if (item == null) {
                return;
            }

            player.sendMessage("You clicked a " + item.getType().name());
        }
    }
}

