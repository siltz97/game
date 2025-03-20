package my.fbk.npc.inventory;


import lombok.Getter;

public enum ItemList {
    HEALTH_POTION("Restores health", 50, " healthpotion "),
    MANA_FLASK("Restores mana", 60, " healthpotion "),
    IRON_SWORD("A basic but reliable sword", 200, " healthpotion "),
    WOODEN_SHIELD("A simple wooden shield", 150, " healthpotion "),
    FIRE_SCROLL("A magic scroll that casts fire", 300, " healthpotion "),
    LEATHER_BOOTS("Light boots for better movement", 100, " healthpotion "),
    SILVER_RING("A ring with minor magical properties", 250, " healthpotion "),
    MAGIC_WAND("A small wand for casting spells", 400, " healthpotion "),
    TORCH("Lights up dark places", 20, " healthpotion "),
    BUCKET_OF_INVISIBILITY("it's just a bucket. What did you expect?", 1, " healthpotion "),
    DOVAKIN_VOICE("FUS RO DAH!!!", 9999, " healthpotion ");

    private final String description;
    private final int price;
    @Getter
    private String name;

    public void setName(String name){
        this.name = name;
    }


    ItemList(String description, int price, String name) {
        this.description = description;
        this.price = price;
        this.name = name;

    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }


}
