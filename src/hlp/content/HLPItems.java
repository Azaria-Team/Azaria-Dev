package hlp.content;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.type.Liquid;

public class HLPItems {
    public static Item
    //items
    fors, craside, khylid, ferbium;
    public static void load() {
        fors = new Item("fors", Color.valueOf("f3b2c1")) {{
        hardness = 1;
        cost = 0.75f;
        }};

        craside = new Item("craside", Color.valueOf("d9fa96")) {{
            hardness = 1; //test numbers
            cost = 0.6f;
        }};

        khylid = new Item("khylid", Color.valueOf("87d7bf")) {{
            cost = 30f;
        }};
        ferbium = new Item("ferbium", Color.valueOf("")) {{
            cost = 30f;
        }};
    }
}
