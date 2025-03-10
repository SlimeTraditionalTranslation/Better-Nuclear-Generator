package me.CAPS123987.BetterReactor;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import io.github.bakedlibs.dough.updater.GitHubBuildsUpdaterTR;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
import me.CAPS123987.Cargo.ReactorInput;
import me.CAPS123987.Cargo.ReactorOutput;
import me.CAPS123987.IIIDmultiblock.ReactorCore;
import me.CAPS123987.Item.Grafit;
import me.CAPS123987.Item.Items;
import me.CAPS123987.Utils.Methodes;
import me.CAPS123987.machines.SuperFreezer;
import org.mini2Dx.gettext.GetText;
import org.mini2Dx.gettext.PoFile;

public class BetterReactor extends JavaPlugin implements SlimefunAddon {
	public static BetterReactor instance;
	private static final Map<Vector, SlimefunItemStack> reactor = new LinkedHashMap<>();
	
    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build_STCT - ")) {
        	
        	GitHubBuildsUpdaterTR
        	updater = new GitHubBuildsUpdaterTR(this, this.getFile(), "SlimeTraditionalTranslation/Better-Nuclear-Generator/master");
        	updater.start();
        	
        }

        GetText.setLocale(Locale.TRADITIONAL_CHINESE);
        InputStream inputStream = getClass().getResourceAsStream("/translations/zh_tw.po");
        if (inputStream == null) {
            getLogger().severe("錯誤！無法找到翻譯檔案，請回報給翻譯者。");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else {
            getLogger().info("載入繁體翻譯檔案...");
            try {
                PoFile poFile = new PoFile(Locale.TRADITIONAL_CHINESE, inputStream);
                GetText.add(poFile);
            } catch (ParseCancellationException | IOException e) {
                getLogger().severe("錯誤！讀取翻譯時發生錯誤，請回報給翻譯者：" + e.getMessage());
                getServer().getPluginManager().disablePlugin(this);
                return;
            }
        }
        
        instance = this;
        new SlimefunItem(Items.betterReactor, Items.LEAD_GLASS, RecipeType.ENHANCED_CRAFTING_TABLE , Items.recipe_LEAD_GLASS,new SlimefunItemStack(Items.LEAD_GLASS, 8)).register(this);
        new SlimefunItem(Items.betterReactor, Items.LEAD_BLOCK, RecipeType.ENHANCED_CRAFTING_TABLE , Items.recipe_LEAD_BLOCK).register(this);
        new SlimefunItem(Items.betterReactor, Items.BORIUM_ROD, RecipeType.ENHANCED_CRAFTING_TABLE , Items.recipe_BORIUM_ROD).register(this);
        new SlimefunItem(Items.betterReactor, Items.REACTOR_HATCH ,RecipeType.ENHANCED_CRAFTING_TABLE , Items.recipe_REACTOR_HATCH).register(this);
        new SlimefunItem(Items.betterReactor, Items.HEATED_COOLANT ,RecipeType.NULL, new ItemStack[0]).register(this);
        new Grafit().register(this);
        new ReactorInput().register(this);
        new ReactorOutput().register(this);
        
        //bottom
        Methodes.areaList(-2, -1, 0, 2, -1, 4, Items.LEAD_BLOCK, reactor);
        //top
        Methodes.areaList(-2, 5, 0, 2, 5, 4, Items.LEAD_BLOCK, reactor);
        //sides
        Methodes.areaList(-1, 0, 4, 1, 4, 4, Items.LEAD_GLASS, reactor);
        Methodes.areaList(-2, 0, 1, -2, 4, 3, Items.LEAD_GLASS, reactor);
        Methodes.areaList(2, 0, 1, 2, 4, 3, Items.LEAD_GLASS, reactor);
        Methodes.areaList(-1, 1, 0,1, 4, 0, Items.LEAD_GLASS, reactor);
        //pillar
        Methodes.areaList(-2, 0, 0, -2, 4, 0, Items.LEAD_BLOCK, reactor);
        Methodes.areaList(2, 0, 0, 2, 4, 0, Items.LEAD_BLOCK, reactor);
        Methodes.areaList(-2, 0, 4, -2, 4, 4, Items.LEAD_BLOCK, reactor);
        Methodes.areaList(2, 0, 4, 2, 4, 4, Items.LEAD_BLOCK, reactor);
        //rods
        Methodes.areaList(-1, 0, 1, -1, 3, 1, Items.BORIUM_ROD, reactor);
        Methodes.areaList(1, 0, 1, 1, 3, 1, Items.BORIUM_ROD, reactor);
        Methodes.areaList(1, 0, 3, 1, 3, 3, Items.BORIUM_ROD, reactor);
        Methodes.areaList(-1, 0, 3, -1, 3, 3, Items.BORIUM_ROD, reactor);
        Methodes.areaList(0, 0, 2, 0, 3, 2, Items.BORIUM_ROD, reactor);
        //hatches
        reactor.put(new Vector(-1,4,1), Items.REACTOR_HATCH);
        reactor.put(new Vector(1,4,1), Items.REACTOR_HATCH);
        reactor.put(new Vector(0,4,2), Items.REACTOR_HATCH);
        reactor.put(new Vector(-1,4,3), Items.REACTOR_HATCH);
        reactor.put(new Vector(1,4,3), Items.REACTOR_HATCH);
        //output
        reactor.put(new Vector(-1,0,0), Items.REACTOR_INPUT);
        reactor.put(new Vector(1,0,0), Items.REACTOR_OUTPUT);
        
        new ReactorCore(reactor).register(this);
        new SuperFreezer().register(this);

        
        
        
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

	public static BetterReactor getInstance() {
        return instance;
    }

}
