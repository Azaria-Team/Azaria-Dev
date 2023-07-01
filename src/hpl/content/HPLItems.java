package hpl.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class HPLItems {
    public static Item
    //items
    fors, craside, khylid, ferbium;
    public static final Seq<Item> aurionaItems = new Seq<>();
    public static void load() {
        fors = new Item("fors", Color.valueOf("f3b2c1")) {{
        cost = 0.75f;
        }};
        khylid = new Item("khylid", Color.valueOf("87d7bf")) {{
            cost = 0.3f;
        }};
        craside = new Item("craside", Color.valueOf("d9fa96")) {{
            cost = 0.6f;
        }};
        ferbium = new Item("ferbium", Color.valueOf("87d7bf")) {{
            cost = 30f;
        }};

        aurionaItems.addAll(
                fors, craside, khylid, ferbium
        );
    }
}
