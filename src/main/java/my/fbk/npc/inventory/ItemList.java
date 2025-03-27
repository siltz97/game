package my.fbk.npc.inventory;


import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.myPlayer.Player;

@SuppressWarnings("NonFinalFieldInEnum")
@Getter
public enum ItemList {
    HEALTH_POTION("Restores +100 health", 50, 1,""),
    MANA_FLASK("Restores +100 mana", 60,1, ""),
    IRON_SWORD("A basic but reliable sword. +40 DMG", 200,1, ""),
    WOODEN_SHIELD("A simple wooden one handed shield. +50 ARMOR", 150,1, ""),
    FIRE_SCROLL("A magic scroll that casts fire 300 DMG", 300,1, ""),
    LEATHER_BOOTS("Light boots for better movement +5 ARMOR", 100,1, ""),
    SILVER_RING("A ring with minor magical properties +30 MAX MANA ", 250,1, ""),
    MAGIC_WAND("A small wand for casting spells +20 MAGIC DMG", 400,1, ""),
    TORCH("Lights up dark places +5 DMG", 20,1, ""),
    BUCKET("it's just a bucket. What did you expect?", 1,1, ""),
    DOVAKIN_VOICE("FUS RO DAH!!! 1000 DMG", 9999,9999, "");

    private final String description;
    private final int price;
    @Setter
    private String name;
    @Setter
    private int durability;

    ItemList(String description, int price,int durability, String name ) {
        this.description = description;
        this.price = price;
        this.durability = durability;
        this.name = name;

    }



}
