package hpl.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class HPLLiquids {
    public static Liquid
    mainl, pinkie;

    public static void load() {

        mainl = new Liquid("mainl", Color.valueOf("53ad99")) {{
            viscosity = 0.65f;
            temperature = 0.3f;
        }};
        pinkie = new Liquid("pinkie", Color.valueOf("a355be")) {{
            viscosity = 0.65f;
            temperature = 0.3f;
        }};
    }
}
