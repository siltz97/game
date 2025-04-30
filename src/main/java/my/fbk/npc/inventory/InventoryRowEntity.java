package my.fbk.npc.inventory;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class InventoryRowEntity implements Serializable {
    Integer id;
    String character;
    String item;
}
