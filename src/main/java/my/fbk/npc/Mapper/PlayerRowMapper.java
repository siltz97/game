package my.fbk.npc.Mapper;

import my.fbk.npc.my_player.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(
            ResultSet rs,
            int rowNum
    ) throws SQLException{
        Player player = new Player(1,1,1,1,1,1);
        player.setMoney(rs.getInt("money"));
        player.setHealth(rs.getInt("health"));
        player.setMana(rs.getInt("mana"));
        player.setDamage(rs.getInt("damage"));
        player.setExperience(rs.getInt("experience"));
        player.setLevel(rs.getInt("level"));
        return player;
    }

}
