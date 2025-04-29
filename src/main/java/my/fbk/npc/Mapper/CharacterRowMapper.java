package my.fbk.npc.Mapper;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.Guard;
import my.fbk.npc.all_npc.Merchant;
import my.fbk.npc.all_npc.Peasant;
import my.fbk.npc.all_npc.Thief;
import my.fbk.npc.enemy.Goblin;
import my.fbk.npc.enemy.Kobold;
import my.fbk.npc.enemy.Skeleton;
import my.fbk.npc.enemy.Zombie;
import my.fbk.npc.my_player.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterRowMapper implements RowMapper<AbstractCharacter> {

    @Override
    public AbstractCharacter mapRow(
            ResultSet rs,
            int rowNum
    ) throws SQLException{
        AbstractCharacter character;
        String name = rs.getString("name");
        switch(name){
            case "Goblin" -> {character = new Goblin(1,1,1,1,1);}
            case "Skeleton" -> {character = new Skeleton(1,1,1,1,1);}
            case "Kobold" -> {character = new Kobold(1,1,1,1,1);}
            case "Zombie" -> {character = new Zombie(1,1,1,1,1);}

            case "Merchant" -> {character = new Merchant(1,1,1,1,1, 1);}
            case "Guard" -> {character = new Guard(1,1,1,1,1,1);}
            case "Peasant" -> {character = new Peasant(1,1,1,1,1,1);}
            case "Thief" -> {character = new Thief(1,1,1,1,1,1);}
            case "Player" -> {character = new Player(1,1,1,1,1, 1);}
            default -> throw new IllegalArgumentException("Invalid character name");
        }
        return character;

    }

}
