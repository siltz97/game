package my.fbk.npc.inventory;


public enum ItemList {
    HEALTH_POTION("Restores health", 50),
    MANA_FLASK("Restores mana", 60),
    IRON_SWORD("A basic but reliable sword", 200),
    WOODEN_SHIELD("A simple wooden shield", 150),
    FIRE_SCROLL("A magic scroll that casts fire", 300),
    LEATHER_BOOTS("Light boots for better movement", 100),
    SILVER_RING("A ring with minor magical properties", 250),
    MAGIC_WAND("A small wand for casting spells", 400),
    TORCH("Lights up dark places", 20),
    BUCKET_OF_INVISIBILITY("it's just a bucket. What did you expect?", 1),
    DOVAKIN_VOICE("FUS RO DAH!!!", 9999);

    private final String description;
    private final int price;
    private String name;


    ItemList(String description, int price) {
        this.description = description;
        this.price = price;

    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }


}
