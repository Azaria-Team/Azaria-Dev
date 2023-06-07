package hlp.world.blocks.power;

import arc.math.Mathf;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ThermalGenerator;

import java.awt.*;

public class EffectThermalPowerGenerator extends ThermalGenerator {
    public Seq<EffectBuild> effects = new Seq<>();

    public EffectThermalPowerGenerator(String name) {
        super(name);
    }

    public class EffectBuild extends ThermalGeneratorBuild {
        public float x, y = 0;
        public Effect effect = Fx.none;
        public Color color;
        public float effectChance = 0.04f;
        public float sum;

        public void effects() {

            if(wasVisible) {
                    if (Mathf.chanceDelta(effectChance)) {
                        effect.at(x, y);
                }
            }
        }
    }
}
