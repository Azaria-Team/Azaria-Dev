package hlp.entities.bullet;

import hlp.graphics.HPLPal;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.graphics.Pal;
import mindustry.gen.*;
import mindustry.graphics.*;


public class VogBulletType extends BasicBulletType {

    public VogBulletType(float speed, float damage, String bulletSprite){
        super(speed, damage, bulletSprite);
        backColor = HPLPal.vogPinkBack;
        frontColor = HPLPal.vogPink;
        homingPower = 0.08f;
        shrinkY = 0.3f;
        width = 8f;
        height = 14f;
        hitSound = Sounds.explosion;
        trailChance = 0.2f;
        lifetime = 52f;
    }

    public VogBulletType(float speed, float damage){
        this(speed, damage, "vog");
    }

    public VogBulletType(){
        this(1f, 1f, "vog");
    }
}