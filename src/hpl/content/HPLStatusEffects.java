package hpl.content;

import arc.graphics.Color;
import hpl.HPL;
import hpl.graphics.HPLPal;
import mindustry.type.StatusEffect;

public class HPLStatusEffects {
    public static StatusEffect weakness, decomposition;

    public static void load() {
        weakness = new StatusEffect ("weakness") {{
            color = HPLPal.unmakerColor;
            damage = 0.25f;
            healthMultiplier = 0.8f;
            speedMultiplier =  0.5f;
        }};

        decomposition = new StatusEffect ("decomposition") {{
            damage = 1.1f;
            healthMultiplier = 0.7f;
            buildSpeedMultiplier = 0.8f;
        }};
    }
}
