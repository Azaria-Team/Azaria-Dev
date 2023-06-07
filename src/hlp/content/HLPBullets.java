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
        forceBullet = new FlakBulletType(3f, 60f){{
           sprite = "circle-bullet";
           trailInterval = 0.4f;
           trailEffect = HLPFx.forceBulletTrail;
           hitEffect = HLPFx.forceBulletHit;
           despawnEffect = HLPFx.forceBulletDespawn;
           trailRotation = true;
           shrinkX = shrinkY = 0f;
           width = 17f;
           height = 17f;
           lifetime = 120;

           backColor = HLPPal.vogPinkBack;
           frontColor = HLPPal.vogPink;
           trailColor = HLPPal.fors;
           trailLength = 5;
           trailWidth = 4;
           pierce = true;
           pierceCap = 2;

            fragBullet = intervalBullet = new FlakBulletType(4f, 5){{
                width = 2f;
                height = 5f;
                pierce = true;
                lifetime = 35f;
                pierceCap = 2;
                pierceBuilding = true;
                backColor = HLPPal.vogPinkBack;
                frontColor = HLPPal.vogPink;
                hitEffect = HLPFx.explosionSmall;
                despawnEffect = HLPFx.explosionSmall2;
                homingPower = 0.2f;
                lifetime = 30;
                shrinkX = shrinkY = 0f;
                despawnSound = Sounds.titanExplosion;
            }};

            bulletInterval = 40f;
            intervalRandomSpread = -180f;
            intervalBullets = 3;
            intervalAngle = -180f;
            intervalSpread = 300f;

            fragBullets = 5;
            fragVelocityMin = 0.1f;
            fragVelocityMax = 1.3f;
            fragLifeMin = 0.4f;
        }};
    }
}
