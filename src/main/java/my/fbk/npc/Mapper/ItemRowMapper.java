package my.fbk.npc.Mapper;

import my.fbk.npc.inventory.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {


    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item(
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getInt("durability"),
                rs.getString("specialEffect")
        );
        switch (item.getName()) {
            case "bucket":
                Item.Bucket bucket = Item.bucket();
                return bucket;
            case "silverring":
                Item.SilverRing silverRing = Item.silverRing();
                return silverRing;
            case "ironsword":
                Item.IronSword ironSword = Item.ironSword();
                return ironSword;
            case "manaflask":
                Item.ManaFlask manaFlask = Item.manaFlask();
                return manaFlask;
            case "firescroll":
                Item.FireScroll fireScroll = Item.fireScroll();
                return fireScroll;
            case "healthpotion":
                Item.HealthPotion healthPotion = Item.healthPotion();
                return healthPotion;
            default:
                throw new IllegalStateException("Invalid item name");
        }

    }

}
