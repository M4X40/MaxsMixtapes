package com.m4x4.mixtapes.item;

import com.m4x4.mixtapes.Base.ArmorMaterials;
import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.tabs.MMDiscTab;
import com.m4x4.mixtapes.tabs.MMItemTab;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MMItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, maxs_mixtapes.MODID);

    // Items
    public static final RegistryObject<Item> Blockman = ITEMS.register("blockman", () -> new MMBlockmanUsage(new Item.Properties().tab(MMItemTab.instance)));
    public static final RegistryObject<Item> BlankTape = ITEMS.register("blanktape", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.RARE), "A time machine on the shoulders of memories"));

    //// Cassettes
    //public static final RegistryObject<Item> TestCassette = ITEMS.register("testcassette", () -> new MMCassetteItem(8, MMSongs.TEST_SOUND, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3060, "Test Cassette for MM"));

    // Update 1
    public static final RegistryObject<Item> hcas = ITEMS.register("hcas", () -> new MMCassetteItem(8, MMSongs.HCAS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5140, "And I am in sound mind"));
    public static final RegistryObject<Item> doll_house = ITEMS.register("doll_house", () -> new MMCassetteItem(8, MMSongs.DOLL_HOUSE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3460, "\"It's okay... I see you.\""));
    public static final RegistryObject<Item> botp = ITEMS.register("botp", () -> new MMCassetteItem(8, MMSongs.BOTP, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4820, "\"Flawed but fixable...\""));
    public static final RegistryObject<Item> is_it_me = ITEMS.register("is_it_me", () -> new MMCassetteItem(8, MMSongs.IS_IT_ME, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4340, "\"Oh yeah?! Try and stop me!\""));
    public static final RegistryObject<Item> matb = ITEMS.register("matb", () -> new MMCassetteItem(8, MMSongs.MATB, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3920, "\"I noticed and I notice it again\""));
    public static final RegistryObject<Item> wit = ITEMS.register("wit", () -> new MMCassetteItem(8, MMSongs.WIT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3160, "\"Power in the unconscious\""));
    public static final RegistryObject<Item> histe = ITEMS.register("histe", () -> new MMCassetteItem(8, MMSongs.HISTE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6020, "\"You loved me and thats all i ever cared about\""));
    public static final RegistryObject<Item> my_ordinary_life = ITEMS.register("my_ordinary_life", () -> new MMCassetteItem(8, MMSongs.MY_ORDINARY_LIFE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4620, "\"So high up, I'm near divine\""));
    public static final RegistryObject<Item> five_long_nights = ITEMS.register("five_long_nights", () -> new MMCassetteItem(8, MMSongs.FIVE_LONG_NIGHTS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3760, "\"The friends are forever\""));
    public static final RegistryObject<Item> parasite = ITEMS.register("parasite", () -> new MMCassetteItem(8, MMSongs.PARASITE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5820, "\"Don't you wanna be free?\""));
    public static final RegistryObject<Item> eisop = ITEMS.register("eisop", () -> new MMCassetteItem(8, MMSongs.EISOP, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1400, "\"This time, death cannot save you.\""));
    public static final RegistryObject<Item> always_come_back = ITEMS.register("always_come_back", () -> new MMCassetteItem(8, MMSongs.ALWAYS_COME_BACK, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3180, "\"Until then don't you dare say that we are the same\""));
    public static final RegistryObject<Item> leave_me_behind = ITEMS.register("leave_me_behind", () -> new MMCassetteItem(8, MMSongs.LEAVE_ME_BEHIND, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4040, "\"Before I close the book, I always skip to the end.\""));
    public static final RegistryObject<Item> sandcastle_kingdoms = ITEMS.register("sandcastle_kingdoms", () -> new MMCassetteItem(8, MMSongs.SANDCASTLE_KINGDOMS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3680, "\"Maybe one day, you'll find a golden key.\""));
    public static final RegistryObject<Item> big_poppa = ITEMS.register("big_poppa", () -> new MMCassetteItem(8, MMSongs.BIG_POPPA, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5060, "R.I.P The GOAT of Hip-Hop"));
    public static final RegistryObject<Item> dotd = ITEMS.register("dotd", () -> new MMCassetteItem(8, MMSongs.DOTD, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4700, "This is just the beginning."));
    public static final RegistryObject<Item> guiding_light = ITEMS.register("guiding_light", () -> new MMCassetteItem(8, MMSongs.GUIDING_LIGHT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1220, "\"You were almost there!\""));
    public static final RegistryObject<Item> here_i_come = ITEMS.register("here_i_come", () -> new MMCassetteItem(8, MMSongs.HERE_I_COME, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2960, "Ready or not..."));
    public static final RegistryObject<Item> bbt = ITEMS.register("bbt", () -> new MMCassetteItem(8, MMSongs.BBT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4840, "\"REALLY? WHAT TIPPED YOU OFF GENIUS?\""));
    public static final RegistryObject<Item> tomcat_disposables = ITEMS.register("tomcat_disposables", () -> new MMCassetteItem(8, MMSongs.TOMCAT_DISPOSABLES, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 7140, "\"Nature i guess..\""));
    public static final RegistryObject<Item> wbtta = ITEMS.register("wbtta", () -> new MMCassetteItem(8, MMSongs.WBTTA, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5120, "\"Baby could you play along with me?\""));
    public static final RegistryObject<Item> okultra = ITEMS.register("okultra", () -> new MMCassetteItem(8, MMSongs.OKULTRA, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5900, "\"For what? For what?\""));
    public static final RegistryObject<Item> love_me_normally = ITEMS.register("love_me_normally", () -> new MMCassetteItem(8, MMSongs.LOVE_ME_NORMALLY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6900, "\"I suggest that we keep this informal\""));
    public static final RegistryObject<Item> puppeteer = ITEMS.register("puppeteer", () -> new MMCassetteItem(8, MMSongs.PUPPETEER, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3440, "\"Now dont be a fool go break all the rules!\""));
    public static final RegistryObject<Item> bmp = ITEMS.register("bmp", () -> new MMCassetteItem(8, MMSongs.BMP, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3040, "\"OHOHO THAT IS SO FIRE DUDE\""));
    public static final RegistryObject<Item> toacw = ITEMS.register("toacw", () -> new MMCassetteItem(8, MMSongs.TOACW, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5300, "\"This was the moment in which Calamity reigned supreme.\""));
    public static final RegistryObject<Item> return_to_slime = ITEMS.register("return_to_slime", () -> new MMCassetteItem(8, MMSongs.RETURN_TO_SLIME, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5880, "\"Its purity is sullied by freshly absorbed muck and grime.\""));
    public static final RegistryObject<Item> sotu = ITEMS.register("sotu", () -> new MMCassetteItem(8, MMSongs.SOTU, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 9180, "\"Dont get cocky!\""));
    public static final RegistryObject<Item> universal_collapse = ITEMS.register("universal_collapse", () -> new MMCassetteItem(8, MMSongs.UNIVERSAL_COLLAPSE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5840, "\"It's not over yet, kid.\""));
    public static final RegistryObject<Item> jungle_dragon = ITEMS.register("jungle_dragon", () -> new MMCassetteItem(8, MMSongs.JUNGLE_DRAGON, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 10100, "\"The air is getting warmer around you.\""));
    public static final RegistryObject<Item> ghosts_n_stuff = ITEMS.register("ghosts_n_stuff", () -> new MMCassetteItem(8, MMSongs.GHOSTS_N_STUFF, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3760, "We are Professional Griefers"));
    public static final RegistryObject<Item> bad_end_theater = ITEMS.register("bad_end_theater", () -> new MMCassetteItem(8, MMSongs.BAD_END_THEATER, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1980, "\"I've missed you my darling\""));
    public static final RegistryObject<Item> anarchy_rainbow = ITEMS.register("anarchy_rainbow", () -> new MMCassetteItem(8, MMSongs.ANARCHY_RAINBOW, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 7380, "\"You lip-sync, we drip ink\""));
    public static final RegistryObject<Item> amongus = ITEMS.register("amongus", () -> new MMCassetteItem(8, MMSongs.AMONGUS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3460, "amogus."));
    public static final RegistryObject<Item> furrymon = ITEMS.register("furrymon", () -> new MMCassetteItem(8, MMSongs.FURRYMON, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4240, "\"zwei's gonna be so pissed at me\""));
    public static final RegistryObject<Item> gymbattle = ITEMS.register("gymbattle", () -> new MMCassetteItem(8, MMSongs.GYMBATTLE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 7980, "Half of this games budget went into this song."));
    public static final RegistryObject<Item> island = ITEMS.register("island", () -> new MMCassetteItem(8, MMSongs.ISLAND, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2180, "\"Mathematical!\""));
    public static final RegistryObject<Item> love_like_you = ITEMS.register("love_like_you", () -> new MMCassetteItem(8, MMSongs.LOVE_LIKE_YOU, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2880, "\"Let's only think about love!\""));
    public static final RegistryObject<Item> wild_side = ITEMS.register("wild_side", () -> new MMCassetteItem(8, MMSongs.WILD_SIDE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3180, "\"I'll be fine. It's always been like this\""));
    public static final RegistryObject<Item> box15 = ITEMS.register("box15", () -> new MMCassetteItem(8, MMSongs.BOX15, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4900, "\"Upupu~\""));
    public static final RegistryObject<Item> still_alive = ITEMS.register("still_alive", () -> new MMCassetteItem(8, MMSongs.STILL_ALIVE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3560, "The cake is a lie"));
    public static final RegistryObject<Item> want_you_gone = ITEMS.register("want_you_gone", () -> new MMCassetteItem(8, MMSongs.WANT_YOU_GONE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2780, "\"I AM NOT A MORON\""));
    public static final RegistryObject<Item> betty = ITEMS.register("betty", () -> new MMCassetteItem(8, MMSongs.BETTY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2940, "\"Gravy, my mom loves you\""));
    public static final RegistryObject<Item> ottt = ITEMS.register("ottt", () -> new MMCassetteItem(8, MMSongs.OTTT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2640, "\"Because meme cassette quota\""));
    public static final RegistryObject<Item> cest_la_vie = ITEMS.register("cest_la_vie", () -> new MMCassetteItem(8, MMSongs.CEST_LA_VIE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3220, "That's life; such is life"));
    public static final RegistryObject<Item> good_morning = ITEMS.register("good_morning", () -> new MMCassetteItem(8, MMSongs.GOOD_MORNING, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3920, "\"You may be talented, but you're not Kanye West \""));
    public static final RegistryObject<Item> stronger = ITEMS.register("stronger", () -> new MMCassetteItem(8, MMSongs.STRONGER, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6260, "\"As a man I am flawed, but my music is perfect\""));
    public static final RegistryObject<Item> american_boy = ITEMS.register("american_boy", () -> new MMCassetteItem(8, MMSongs.AMERICAN_BOY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4800, "\"Hey! Don't mess with his funky flow!\""));
    public static final RegistryObject<Item> ywbo = ITEMS.register("ywbo", () -> new MMCassetteItem(8, MMSongs.YWBO, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4360, "\"I will never be far away from my special little starfire\""));
    public static final RegistryObject<Item> sunset_rose_cocktail = ITEMS.register("sunset_rose_cocktail", () -> new MMCassetteItem(8, MMSongs.SUNSET_ROSE_COCKTAIL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2320, "\"As wild waters, fast and free, it's your true name: Mississippi\""));
    public static final RegistryObject<Item> olive_branch = ITEMS.register("olive_branch", () -> new MMCassetteItem(8, MMSongs.OLIVE_BRANCH, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6320, "\"I don't want a sandwich!\""));
    public static final RegistryObject<Item> rasputin = ITEMS.register("rasputin", () -> new MMCassetteItem(8, MMSongs.RASPUTIN, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5360, "\"Chad vas... Bad\""));
    public static final RegistryObject<Item> god_of_war = ITEMS.register("god_of_war", () -> new MMCassetteItem(8, MMSongs.GOD_OF_WAR, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4960, "\"Death can have me when it earns me.\""));
    public static final RegistryObject<Item> thunder_roll = ITEMS.register("thunder_roll", () -> new MMCassetteItem(8, MMSongs.THUNDER_ROLL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3640, "\"Street warrior, sushi chef, and the coolest lizard in the Peace Syndicate.\""));
    public static final RegistryObject<Item> virtual_insanity = ITEMS.register("virtual_insanity", () -> new MMCassetteItem(8, MMSongs.VIRTUAL_INSANITY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4520, "\"Dancing, Walking, Rearranging Furniture.\""));
    public static final RegistryObject<Item> dreamland = ITEMS.register("dreamland", () -> new MMCassetteItem(8, MMSongs.DREAMLAND, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4880, "\"Does everybody live in a dreamland?\""));
    public static final RegistryObject<Item> like_that = ITEMS.register("like_that", () -> new MMCassetteItem(8, MMSongs.LIKE_THAT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3560, "\"All told i got too bold, heart of gold\""));
    public static final RegistryObject<Item> final_duet = ITEMS.register("final_duet", () -> new MMCassetteItem(8, MMSongs.FINAL_DUET, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2660, "\"Why don't you enjoy a nice picnic with me? That always seems to cheer you up.\""));
    public static final RegistryObject<Item> home_for_flowers = ITEMS.register("home_for_flowers", () -> new MMCassetteItem(8, MMSongs.HOME_FOR_FLOWERS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1880, "\"My thoughts will follow you into your dreams\""));
    public static final RegistryObject<Item> my_time = ITEMS.register("my_time", () -> new MMCassetteItem(8, MMSongs.MY_TIME, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6300, "Oyasumi"));
    public static final RegistryObject<Item> undertale = ITEMS.register("undertale", () -> new MMCassetteItem(8, MMSongs.UNDERTALE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 7640, "\"Despite everything, it's still you\""));
    public static final RegistryObject<Item> death_by_glamor = ITEMS.register("death_by_glamor", () -> new MMCassetteItem(8, MMSongs.DEATH_BY_GLAMOR, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2700, "\"THAT'S SHOW BUSINESS, BABY!\""));
    public static final RegistryObject<Item> fohad = ITEMS.register("fohad", () -> new MMCassetteItem(8, MMSongs.FOHAD, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3240, "\"Quiet people piss me off...\""));
    public static final RegistryObject<Item> ycach = ITEMS.register("ycach", () -> new MMCassetteItem(8, MMSongs.YCACH, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2020, "\"I am Toriel, caretaker of the Ruins...\""));
    public static final RegistryObject<Item> scarlet_forest = ITEMS.register("scarlet_forest", () -> new MMCassetteItem(8, MMSongs.SCARLET_FOREST, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2580, "\"...2 minutes in jail and you've already started eating moss.\""));
    public static final RegistryObject<Item> cybers_world = ITEMS.register("cybers_world", () -> new MMCassetteItem(8, MMSongs.CYBERS_WORLD, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3340, "\"Potassium.\""));
    public static final RegistryObject<Item> safeandsound = ITEMS.register("safeandsound", () -> new MMCassetteItem(8, MMSongs.SAFEANDSOUND, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3880, "\"if my childhood had end credits\""));
    public static final RegistryObject<Item> letter_to_my_brother = ITEMS.register("letter_to_my_brother", () -> new MMCassetteItem(8, MMSongs.LETTER_TO_MY_BROTHER, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4340, "Welcome home, Rome."));
    public static final RegistryObject<Item> after_dark = ITEMS.register("after_dark", () -> new MMCassetteItem(8, MMSongs.AFTER_DARK, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5160, "Rome's a simp"));
    public static final RegistryObject<Item> monster = ITEMS.register("monster", () -> new MMCassetteItem(8, MMSongs.MONSTER, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5140, "So edgy you could hurt yourself, be gentle Rome."));
    public static final RegistryObject<Item> fmttm = ITEMS.register("fmttm", () -> new MMCassetteItem(8, MMSongs.FMTTM, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5320, "\"Shoot, that was my last quarter.\""));
    public static final RegistryObject<Item> gtaw = ITEMS.register("gtaw", () -> new MMCassetteItem(8, MMSongs.GTAW, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6620, "Remember me."));
    public static final RegistryObject<Item> rejuv = ITEMS.register("rejuv", () -> new MMCassetteItem(8, MMSongs.REJUV, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2160, "\"This is gonna make you feel better.\""));
    public static final RegistryObject<Item> wmtao = ITEMS.register("wmtao", () -> new MMCassetteItem(8, MMSongs.WMTAO, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2460, "\"Yeeeaah, let's move it, people!\""));
    public static final RegistryObject<Item> bow = ITEMS.register("bow", () -> new MMCassetteItem(8, MMSongs.BOW, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3600, "\"Let the Kitsune guide you.\""));
    public static final RegistryObject<Item> ghost = ITEMS.register("ghost", () -> new MMCassetteItem(8, MMSongs.GHOST, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3180, "\"I don't believe in animals, milk comes from the trees.\""));
    public static final RegistryObject<Item> if_we_fall = ITEMS.register("if_we_fall", () -> new MMCassetteItem(8, MMSongs.IF_WE_FALL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4840, "\"Blame it on the humans.\""));
    public static final RegistryObject<Item> kick_back = ITEMS.register("kick_back", () -> new MMCassetteItem(8, MMSongs.KICK_BACK, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3920, "\"If dreams do come true, I wanna hug a girl before I die\""));
    public static final RegistryObject<Item> riav = ITEMS.register("riav", () -> new MMCassetteItem(8, MMSongs.RIAV, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3740, "Gimme the music, this beat is too sick, I wanna drink til I get stupid!"));
    public static final RegistryObject<Item> lightsabers = ITEMS.register("lightsabers", () -> new MMCassetteItem(8, MMSongs.LIGHTSABERS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5660, "\"My flow non-binary, that mean it never miss\""));
    public static final RegistryObject<Item> pizza_time = ITEMS.register("pizza_time", () -> new MMCassetteItem(8, MMSongs.PIZZA_TIME, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4600, "Very..  A    N  I  C  E!!!"));
    public static final RegistryObject<Item> idwbf = ITEMS.register("idwbf", () -> new MMCassetteItem(8, MMSongs.IDWBF, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2860, "\"You're never livin' in prison theres always somethin to do!\""));
    public static final RegistryObject<Item> the_last_goodbye = ITEMS.register("the_last_goodbye", () -> new MMCassetteItem(8, MMSongs.THE_LAST_GOODBYE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3980, "\"We're going down in a blaze of glory!\""));
    public static final RegistryObject<Item> cosmic = ITEMS.register("cosmic", () -> new MMCassetteItem(8, MMSongs.COSMIC, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 9040, "None too far as we chase through the stars beyond forever, I'll follow you"));
    public static final RegistryObject<Item> mattel = ITEMS.register("mattel", () -> new MMCassetteItem(8, MMSongs.MATTEL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6620, "Advertisement, moral scrawl, a semblance of choice when there's no choice at all!"));
    public static final RegistryObject<Item> g = ITEMS.register("g", () -> new MMCassetteItem(8, MMSongs.G, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4400, "Ahh fuck, give me a delete button..... Delete!"));
    public static final RegistryObject<Item> nightmare = ITEMS.register("nightmare", () -> new MMCassetteItem(8, MMSongs.NIGHTMARE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 7440, "R.I.P - The Rev, world's best drummer."));
    public static final RegistryObject<Item> two_time_zones = ITEMS.register("two_time_zones", () -> new MMCassetteItem(8, MMSongs.TWO_TIME_ZONES, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3240, "\"Because the clock idea was too good to pass up.\""));
    public static final RegistryObject<Item> pigstep = ITEMS.register("pigstep", () -> new MMCassetteItem(8, MMSongs.PIGSTEP, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2920, "\"Interior Crocodile Aligator\""));
    public static final RegistryObject<Item> alpha = ITEMS.register("alpha", () -> new MMCassetteItem(8, MMSongs.ALPHA, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 12080, "Minecraft grew up with you."));
    public static final RegistryObject<Item> vital = ITEMS.register("vital", () -> new MMCassetteItem(8, MMSongs.VITAL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4340, "\"Cause some mayhem out there~\""));

    // Update 2
    public static final RegistryObject<Item> drunk = ITEMS.register("drunk", () -> new MMCassetteItem(8, MMSongs.DRUNK, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4520, "\"Where's my keys?\""));
    public static final RegistryObject<Item> djmm = ITEMS.register("djmm", () -> new MMCassetteItem(8, MMSongs.DJMM, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4240, "Max has held the Security Breach DJMM World Record since 10/29/22"));
    public static final RegistryObject<Item> roxanne = ITEMS.register("roxanne", () -> new MMCassetteItem(8, MMSongs.ROXANNE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3240, "She kinda bad tho"));
    public static final RegistryObject<Item> here_i_come_2 = ITEMS.register("here_i_come_2", () -> new MMCassetteItem(8, MMSongs.HERE_I_COME_2, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2860, "You can't run, nor can you hide..."));
    public static final RegistryObject<Item> fbc = ITEMS.register("fbc", () -> new MMCassetteItem(8, MMSongs.FBC, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3420, "\"bro stop spamming lightning magic\""));
    public static final RegistryObject<Item> archetype = ITEMS.register("archetype", () -> new MMCassetteItem(8, MMSongs.ARCHETYPE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4860, "\"I like these calm moments before the storm\""));
    public static final RegistryObject<Item> btd5 = ITEMS.register("btd5", () -> new MMCassetteItem(8, MMSongs.BTD5, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2340, "\"Got any Super Monkeys yet?\""));
    public static final RegistryObject<Item> barbie_girl = ITEMS.register("barbie_girl", () -> new MMCassetteItem(8, MMSongs.BARBIE_GIRL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4040, "\"Anxiety, Panic Attacks, and OCD not included\""));
    public static final RegistryObject<Item> cali_girls = ITEMS.register("cali_girls", () -> new MMCassetteItem(8, MMSongs.CALI_GIRLS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4680, "\"Greetings, loved ones. Let's take a journey.\" (zen SHUT UP)"));
    public static final RegistryObject<Item> eh = ITEMS.register("eh", () -> new MMCassetteItem(8, MMSongs.EH, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3080, "\"...tear until it's done.\""));
    public static final RegistryObject<Item> tottfiy = ITEMS.register("tottfiy", () -> new MMCassetteItem(8, MMSongs.TOTTFIY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 8260, "\"Rip and...\""));
    public static final RegistryObject<Item> sg = ITEMS.register("sg", () -> new MMCassetteItem(8, MMSongs.SG, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4700, "\"Now just keep sucking on it until we're all the way to the nut\" - Smallant 2022"));
    public static final RegistryObject<Item> oot = ITEMS.register("oot", () -> new MMCassetteItem(8, MMSongs.OOT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3380, "\"A thing that does not change with time is a memory of younger days...\""));
    public static final RegistryObject<Item> war = ITEMS.register("war", () -> new MMCassetteItem(8, MMSongs.WAR, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4700, "\"In the game of love, the more desperate you are, the more you lose.\""));
    public static final RegistryObject<Item> box16 = ITEMS.register("box16", () -> new MMCassetteItem(8, MMSongs.BOX16, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6640, "\"Mukuro Ikusaba, the 16th Student, lying hidden somewhere in this school...\""));
    public static final RegistryObject<Item> gravity = ITEMS.register("gravity", () -> new MMCassetteItem(8, MMSongs.GRAVITY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6220, "\"Irredeemable!\""));
    public static final RegistryObject<Item> addict = ITEMS.register("addict", () -> new MMCassetteItem(8, MMSongs.ADDICT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6320, "\"Maybe things won't be so terrible inside this hotel...\""));
    public static final RegistryObject<Item> cotton_candy = ITEMS.register("cotton_candy", () -> new MMCassetteItem(8, MMSongs.COTTON_CANDY, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3420, "\"i have like a rainbow, in my vagina right now\""));
    public static final RegistryObject<Item> lat = ITEMS.register("lat", () -> new MMCassetteItem(8, MMSongs.LAT, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3320, "\"Eaugh! Ever heard of mouthwash?! FUCK FAAAACCCEEEE!\""));
    public static final RegistryObject<Item> simoon = ITEMS.register("simoon", () -> new MMCassetteItem(8, MMSongs.SIMOON, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6780, "\"CHEESE AND RICE MOONY.\""));
    public static final RegistryObject<Item> gr = ITEMS.register("gr", () -> new MMCassetteItem(8, MMSongs.GR, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3200, "\"I CAN'T GO ONNNN!!! I WON'T ACHIEVE ANYTHINGGGGG!!\""));
    public static final RegistryObject<Item> anemoia = ITEMS.register("anemoia", () -> new MMCassetteItem(8, MMSongs.ANEMOIA, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2680, "\"HAAH!! Are you kidding?! I HATE THIS STUPID JOB!!!\""));
    public static final RegistryObject<Item> toxic_coffee = ITEMS.register("toxic_coffee", () -> new MMCassetteItem(8, MMSongs.TOXIC_COFFEE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4000, "\"Max after making the mod bootloop:\""));
    public static final RegistryObject<Item> a_safe_world = ITEMS.register("a_safe_world", () -> new MMCassetteItem(8, MMSongs.A_SAFE_WORLD, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3360, "I love deltarune..."));
    public static final RegistryObject<Item> sac = ITEMS.register("sac", () -> new MMCassetteItem(8, MMSongs.SAC, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3360, "I love Capital Cities..."));
    public static final RegistryObject<Item> bm = ITEMS.register("bm", () -> new MMCassetteItem(8, MMSongs.BM, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5840, "\"You think of the yakuza as a way to die. To me... being yakuza... It's a way to live.\""));
    public static final RegistryObject<Item> ijam = ITEMS.register("ijam", () -> new MMCassetteItem(8, MMSongs.IJAM, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5080, "feelsstrongman"));
    public static final RegistryObject<Item> wigglecore = ITEMS.register("wigglecore", () -> new MMCassetteItem(8, MMSongs.WIGGLECORE, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3280, "\"I dodged\""));
    public static final RegistryObject<Item> street_fighter = ITEMS.register("street_fighter", () -> new MMCassetteItem(8, MMSongs.STREET_FIGHTER, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4180, "\"Hey everyone! Dan here from The Diamond Minecart\""));
    public static final RegistryObject<Item> sb = ITEMS.register("sb", () -> new MMCassetteItem(8, MMSongs.SB, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3660, "\"And that's just a theory\""));
    public static final RegistryObject<Item> pigstep_jazz = ITEMS.register("pigstep_jazz", () -> new MMCassetteItem(8, MMSongs.PIGSTEP_JAZZ, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 7560, "The Piglins got classy."));
    public static final RegistryObject<Item> mov = ITEMS.register("mov", () -> new MMCassetteItem(8, MMSongs.MOV, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5680, "\"The song you used to know.\""));

    // Update 3
    public static final RegistryObject<Item> sss = ITEMS.register("sss", () -> new MMCassetteItem(8, MMSongs.SSS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4620, "[TBD]"));
    public static final RegistryObject<Item> fnaf = ITEMS.register("fnaf", () -> new MMCassetteItem(8, MMSongs.FNAF, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3560, "[TBD]"));
    public static final RegistryObject<Item> fmn = ITEMS.register("fmn", () -> new MMCassetteItem(8, MMSongs.FMN, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5000, "[TBD]"));
    public static final RegistryObject<Item> jufab = ITEMS.register("jufab", () -> new MMCassetteItem(8, MMSongs.JUFAB, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4600, "[TBD]"));
    public static final RegistryObject<Item> golfswamp = ITEMS.register("golfswamp", () -> new MMCassetteItem(8, MMSongs.GOLFSWAMP, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 3380, "[TBD]"));
    public static final RegistryObject<Item> ych = ITEMS.register("ych", () -> new MMCassetteItem(8, MMSongs.YCH, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 5780, "[TBD]"));
    public static final RegistryObject<Item> rfyl = ITEMS.register("rfyl", () -> new MMCassetteItem(8, MMSongs.RFYL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1460, "[TBD]"));
    public static final RegistryObject<Item> gps = ITEMS.register("gps", () -> new MMCassetteItem(8, MMSongs.GPS, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4100, "[TBD]"));
    public static final RegistryObject<Item> rod = ITEMS.register("rod", () -> new MMCassetteItem(8, MMSongs.ROD, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4960, "[TBD]"));
    public static final RegistryObject<Item> ig = ITEMS.register("ig", () -> new MMCassetteItem(8, MMSongs.IG, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 6600, "[TBD]"));
    public static final RegistryObject<Item> fl = ITEMS.register("fl", () -> new MMCassetteItem(8, MMSongs.FL, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1840, "[TBD]"));
    public static final RegistryObject<Item> esc = ITEMS.register("esc", () -> new MMCassetteItem(8, MMSongs.ESC, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 4160, "[TBD]"));
    public static final RegistryObject<Item> pm = ITEMS.register("pm", () -> new MMCassetteItem(8, MMSongs.PM, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 1740, "[TBD]"));
    public static final RegistryObject<Item> potm = ITEMS.register("potm", () -> new MMCassetteItem(8, MMSongs.POTM, new Item.Properties().tab(MMDiscTab.instance).stacksTo(1).rarity(Rarity.RARE), 2700, "[TBD]"));

    //// Items
    public static final RegistryObject<Item> bull_pill = ITEMS.register("bull_pill", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(64).rarity(Rarity.RARE).food(FoodItems.bull_pill), "[TBD]"));
    public static final RegistryObject<Item> agent_rainbow = ITEMS.register("agent_rainbow", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(16).rarity(Rarity.EPIC).food(FoodItems.agent_rainbow), "Easy access into the collective unconsious"));
    public static final RegistryObject<Item> airpod = ITEMS.register("airpod", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.EPIC), "\"fucking AIRPOD man he's so airpod and for what reason\""));
    public static final RegistryObject<Item> remnant = ITEMS.register("remnant", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(16).rarity(Rarity.COMMON), "\"Get ready for unstoppable fu-u-u-u-u-un, fun, fun.\""));
    public static final RegistryObject<Item> knob = ITEMS.register("knob", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(64).rarity(Rarity.COMMON), "Just 999 more!"));
    public static final RegistryObject<Item> joycon = ITEMS.register("joycon", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "JoyConBoyz For Life, Fly high Etika"));
    public static final RegistryObject<Item> drawing_tablet = ITEMS.register("drawing_tablet", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "My wrist hurts..."));
    public static final RegistryObject<Item> violin = ITEMS.register("violin", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "\"Steady your heartbeat.... Don't be afraid\""));
    public static final RegistryObject<Item> annoying_dog = ITEMS.register("annoying_dog", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "( The dog absorbs the cassette. )"));
    public static final RegistryObject<Item> gold_play_button = ITEMS.register("gold_play_button", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "[TBD]"));
    public static final RegistryObject<Item> normal_pills = ITEMS.register("normal_pills", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "\"You've become immune to my toxic fumes, my dose dependent presence.\""));
    public static final RegistryObject<Item> turron = ITEMS.register("turron", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON).food(FoodItems.turron), "\"Turr\u00F3n? Turr\u00F3n! Turr\u00F3n!\""));
    public static final RegistryObject<Item> coffin_varnish = ITEMS.register("coffin_varnish", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON).food(FoodItems.coffin_varnish), "\"It beats radiator fluid\""));
    public static final RegistryObject<Item> stolas_grimoire = ITEMS.register("stolas_grimoire", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(1).rarity(Rarity.COMMON), "\"Jelly Sandwiches\""));
    public static final RegistryObject<Item> auric_bar = ITEMS.register("auric_bar", () -> new MMItem(new Item.Properties().tab(MMItemTab.instance).stacksTo(64).rarity(Rarity.COMMON), "Boundless power emanates from the metal"));
    public static final RegistryObject<Item> handsome_devil = ITEMS.register("handsome_devil", () -> new MMItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), "He is him. (Okami named this not Max)"));
    public static final RegistryObject<MMArmorItem> yeezys = ITEMS.register("yeezys", () -> new MMArmorItem(YeezyInfo.yeezys, EquipmentSlot.FEET, new Item.Properties().tab(MMItemTab.instance), "\"Shoe of the year\" - Kanye"));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class YeezyInfo {
        public static final ArmorMaterial yeezys = new ArmorMaterials("yeezys", 25, new int[] {2,2,2,2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, null);
    }

    public static class FoodItems {
        public static final FoodProperties bull_pill = new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).alwaysEat().build();
        public static final FoodProperties agent_rainbow = new FoodProperties.Builder().nutrition(-4).saturationMod(-0.5f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 3), 1.0f).build(); // Make drink
        public static final FoodProperties turron = new FoodProperties.Builder().nutrition(6).saturationMod(0.8f).build();
        public static final FoodProperties coffin_varnish = new FoodProperties.Builder().nutrition(-2).saturationMod(0.3f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 3), 1.0f).build(); // Make drink
    }

}