package my.fbk.npc.inventory;


import lombok.Getter;
import lombok.Setter;
@SuppressWarnings("NonFinalFieldInEnum")
@Getter
public enum ItemList {
    HEALTH_POTION("Restores health", 50, 1,""),
    MANA_FLASK("Restores mana", 60,1, ""),
    IRON_SWORD("A basic but reliable sword", 200,1, ""),
    WOODEN_SHIELD("A simple wooden shield", 150,1, ""),
    FIRE_SCROLL("A magic scroll that casts fire", 300,1, ""),
    LEATHER_BOOTS("Light boots for better movement", 100,1, ""),
    SILVER_RING("A ring with minor magical properties", 250,1, ""),
    MAGIC_WAND("A small wand for casting spells", 400,1, ""),
    TORCH("Lights up dark places", 20,1, ""),
    BUCKET_OF_INVISIBILITY("it's just a bucket. What did you expect?", 1,1, ""),
    DOVAKIN_VOICE("FUS RO DAH!!!", 9999,1, "");

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
