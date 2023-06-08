package hlp.content;

import arc.graphics.Color;
import hlp.graphics.HLPPal;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;

public class HLPBullets {
    public static BulletType
            none, forceBullet;

    public static void load() {
        forceBullet = new FlakBulletType(3f, 40f){{
           sprite = "circle-bullet";
           trailInterval = 0.5f;
           trailEffect = HLPFx.forceBulletTrail;
           hitEffect = HLPFx.forceBulletHit;
           despawnEffect = HLPFx.forceBulletDespawn;
           trailRotation = true;
           shrinkX = shrinkY = 0f;
           width = 11f;
           height = 11f;
           lifetime = 70;
           collidesGround = true;
           collidesAir = true;

           backColor = HLPPal.fors;
           frontColor = HLPPal.forsBack;
           trailColor = HLPPal.forceBulletBack;

           trailLength = 18;
           trailWidth = 3;

            splashDamage = 20f;
            splashDamageRadius = 30f;
        }};
    }
}
