package hlp.world.draw;

import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import hlp.content.HLPFx;
import mindustry.entities.Effect;
import mindustry.gen.Building;
import mindustry.world.draw.DrawBlock;

public class EffectDraw extends DrawBlock {
    public float x, y;
    public Effect effect = HLPFx.smokeEvaporatorSmall;
    public float effectChanceDelta = 0.06f;

    /** Any number <=0 disables layer changes. */
    public float layer = 0;

    public EffectDraw(){
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        if(Mathf.chanceDelta(effectChanceDelta))
        effect.at(x, y);
        Draw.z(z);
    }
}

