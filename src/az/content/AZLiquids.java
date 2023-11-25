package az.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class AZLiquids {
    public static Liquid
            oxyliteLiq, spectralia;

    public static void load() {

        oxyliteLiq = new Liquid("oxylite-liq", Color.valueOf("53ad99")) {{
            viscosity = 0.65f;
            heatCapacity = 0.3f;
        }};

        spectralia = new Liquid("spectralia", Color.valueOf("f4c0f4")) {{
            viscosity = 0.65f;
            heatCapacity = 0.3f;
        }};
    }
}
