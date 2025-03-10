package me.CAPS123987.Item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.text.DecimalFormat;


import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.CAPS123987.BetterReactor.BetterReactor;
import me.CAPS123987.IIIDmultiblock.ReactorCore;
import net.md_5.bungee.api.ChatColor;
public class Items {
	
	
	public static FileConfiguration cfg = BetterReactor.instance.getConfig();
	public static int uranMax = cfg.getInt("uranMax");
	public static DecimalFormat df = new DecimalFormat("0.00");
	
	public static final ItemGroup betterReactor = new ItemGroup(new NamespacedKey(BetterReactor.getInstance(),
	        "Better_Reactor"),
	        new CustomItemStack(Material.OBSIDIAN, GetText.tr("&dBetter Reactor"))
	    );
	
	public static final SlimefunItemStack REACTOR_CORE = new SlimefunItemStack("REACTOR_CORE",
			Material.MAGENTA_GLAZED_TERRACOTTA,
	        ChatColor.RESET+ GetText.tr("Reactor Core"),
	        "",
	        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
	        LoreBuilder.powerBuffer(uranMax*ReactorCore.powerPer*2),
	        LoreBuilder.powerPerSecond(uranMax*ReactorCore.powerPer*2),
	        "&8\u21E8 &e\u26A1 &7"+"Lasts "+ReactorCore.burnTime+"t",
	        "&8\u21E8 &e\u26A1 &7"+"In total: "+df.format(uranMax*ReactorCore.powerPer*ReactorCore.burnTime/1000000f) +"M J",
	        "&7Core of Reactor, &bshows Reactor Core Hologram"
	    );
	public static final SlimefunItemStack HEATED_COOLANT = new SlimefunItemStack("HEATED_COOLANT",
			"de4073be40cb3deb310a0be959b4cac68e825372728fafb6c2973e4e7c33",
	        ChatColor.RESET+GetText.tr("Heated Coolant"),
	        ""
	    );
	
	
	public static final SlimefunItemStack SUPER_FREEZER = new SlimefunItemStack("SUPER_FREEZER",
			Material.QUARTZ_BLOCK,
	        ChatColor.RESET+GetText.tr("Super Freezer"),
	        "",
	        GetText.tr("&7(&cWarning!&7 more inputs needed for good flow of items)"),
	        GetText.tr("&7Water instantly to coolant"),
	        LoreBuilder.powerPerSecond(50)
	    );
	
	public static final SlimefunItemStack LEAD_BLOCK = new SlimefunItemStack("LEAD_BLOCK",
			Material.IRON_BLOCK,
	        ChatColor.RESET+GetText.tr("Lead Block"),
	        "",
	        GetText.tr("&fWhite &7in &bReactor Core Hologram")
	    );
	
	public static final SlimefunItemStack LEAD_GLASS = new SlimefunItemStack("LEAD_GLASS",
			Material.GRAY_STAINED_GLASS,
			ChatColor.RESET+GetText.tr("Lead Glass"),
	        "",
	        GetText.tr("&7Gray in &bReactor Core Hologram")
	    );
	
	public static final SlimefunItemStack BORIUM_ROD = new SlimefunItemStack("BORIUM_ROD",
			Material.ANCIENT_DEBRIS,
			ChatColor.RESET+GetText.tr("Borium Rod"),
	        "",
	        GetText.tr("&6Orange &7in &bReactor Core Hologram")
	    );
	
	public static final SlimefunItemStack BORIUM = new SlimefunItemStack("BORIUM",
			Material.GUNPOWDER,
			ChatColor.RESET+GetText.tr("Borium"),
	        ""
	    );
	public static final SlimefunItemStack REACTOR_INPUT = new SlimefunItemStack("REACTOR_INPUT",
			Material.LIGHT_BLUE_WOOL,
	        ChatColor.RESET+GetText.tr("Reactor Input"),
	        "",
	        GetText.tr("&9Blue &7in &bReactor Core Hologram")
	    );
	public static final SlimefunItemStack REACTOR_OUTPUT = new SlimefunItemStack("REACTOR_OUTPUT",
			Material.RED_WOOL,
			ChatColor.RESET+GetText.tr("Reactor Output"),
	        "",
	        GetText.tr("&cRed &7in &bReactor Core Hologram")
	    );
	//https://minecraft-heads.com/custom-heads/miscellaneous/50973-fancy-cube
	public static final SlimefunItemStack REACTOR_HATCH = new SlimefunItemStack("REACTOR_HATCH",
			"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWU4MzI4NDE2MDdkZjc2ZWM1NjE5MGVhODdjMzE2MDUwYTI3N2E1YTU4ZjFkM2JjODJhMGU5NGVkYjk1MzUzIn19fQ==",
			ChatColor.RESET+GetText.tr("Reactor Hatch"),
	        "",
	        GetText.tr("&aGreen &7in &bReactor Core Hologram")
	    );
	
	
	public static final ItemStack[] recipe_LEAD_GLASS= {
			Items.LEAD_BLOCK,Items.LEAD_BLOCK,Items.LEAD_BLOCK,
			Items.LEAD_BLOCK,new ItemStack(Material.GLASS),Items.LEAD_BLOCK,
			Items.LEAD_BLOCK,Items.LEAD_BLOCK,Items.LEAD_BLOCK
	};
	public static final ItemStack[] recipe_SUPER_FREEZER= {
			SlimefunItems.FREEZER_2,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.CARGO_MOTOR,
			SlimefunItems.REACTOR_COOLANT_CELL,new ItemStack(Material.ICE),SlimefunItems.REACTOR_COOLANT_CELL,
			SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.FREEZER_2
	};
	
	public static final ItemStack[] recipe_BORIUM_ROD= {
			Items.BORIUM,Items.BORIUM,Items.BORIUM,
			Items.BORIUM,new ItemStack(Material.IRON_BLOCK),Items.BORIUM,
			Items.BORIUM,Items.BORIUM,Items.BORIUM
	};
	
	public static final ItemStack[] recipe_LEAD_BLOCK= {
			SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_INGOT,
			SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_INGOT,
			SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_INGOT
	};
	public static final ItemStack[] recipe_REACTOR_HATCH= {
			SlimefunItems.LEAD_INGOT,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.LEAD_INGOT,
			SlimefunItems.LEAD_INGOT,SlimefunItems.NUCLEAR_REACTOR,SlimefunItems.LEAD_INGOT,
			SlimefunItems.LEAD_INGOT,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.LEAD_INGOT
	};
	public static final ItemStack[] recipe_REACTOR_CORE= {
			Items.LEAD_BLOCK,SlimefunItems.GPS_CONTROL_PANEL,Items.LEAD_BLOCK,
			new ItemStack(Material.CHEST),SlimefunItems.REACTOR_ACCESS_PORT,new ItemStack(Material.CHEST),
			Items.LEAD_BLOCK,SlimefunItems.ELECTRO_MAGNET,Items.LEAD_BLOCK
	};
	public static final ItemStack[] recipe_REACTOR_INPUT= {
			Items.LEAD_BLOCK,Items.LEAD_BLOCK,Items.LEAD_BLOCK,
			new ItemStack(Material.CHEST),SlimefunItems.CARGO_INPUT_NODE,new ItemStack(Material.CHEST),
			Items.LEAD_BLOCK,SlimefunItems.ELECTRO_MAGNET,Items.LEAD_BLOCK
	};
	public static final ItemStack[] recipe_REACTOR_OUTPUT= {
			Items.LEAD_BLOCK,Items.LEAD_BLOCK,Items.LEAD_BLOCK,
			new ItemStack(Material.CHEST),SlimefunItems.CARGO_OUTPUT_NODE_2,new ItemStack(Material.CHEST),
			Items.LEAD_BLOCK,SlimefunItems.ELECTRO_MAGNET,Items.LEAD_BLOCK
	};
	
	public static final ItemStack[] recipe_TEST_ITEM= {
			null,null,null,
			null,new ItemStack(Material.PINK_WOOL),null,
			null,null,null
	};
}
