package my.fbk.npc.Mapper;

import my.fbk.npc.inventory.ItemList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<ItemList> {


    @Override
    public ItemList mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemList item = new ItemList(
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getInt("durability"),
                rs.getString("specialEffect")
        );
        switch (item.getName()) {
            case "bucket":
                ItemList.Bucket bucket = ItemList.bucket();
                return bucket;
            case "silverring":
                ItemList.SilverRing silverRing = ItemList.silverRing();
                return silverRing;
            case "ironsword":
                ItemList.IronSword ironSword = ItemList.ironSword();
                return ironSword;
            case "manaflask":
                ItemList.ManaFlask manaFlask = ItemList.manaFlask();
                return manaFlask;
            case "firescroll":
                ItemList.FireScroll fireScroll = ItemList.fireScroll();
                return fireScroll;
            case "healthpotion":
                ItemList.HealthPotion healthPotion = ItemList.healthPotion();
                return healthPotion;
            default:
                throw new IllegalStateException("Invalid item name");
        }

    }

}
