package hlp.world.draw;

import arc.*;
import arc.graphics.g2d.*;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.gen.*;
import mindustry.world.draw.DrawBlock;

public class EffectDraw extends DrawBlock {
    public String suffix = "";
    public float x, y;
    public Effect effect = Fx.burning;

    /** Any number <=0 disables layer changes. */
    public float layer = 0;

    public EffectDraw(String suffix){
        this.suffix = suffix;
    }

    public EffectDraw(){
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        effect.at(x, y);
        Draw.z(z);
    }
}

