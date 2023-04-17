package hlp.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class HLPLiquids {
    public static Liquid

    pinkie;

    public static void load() {
        pinkie = new Liquid("pinkie", Color.valueOf("a355be")) {{
            viscosity = 0.65f;
            temperature = 0.3f;
        }};
    }

}
