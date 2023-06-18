package hpl.content;

import hpl.graphics.HPLPal;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;

public class HPLBullets {
    public static BulletType
            none, forceBullet;

    public static void load() {
        forceBullet = new BasicBulletType(3f, 65f){{
           sprite = "hpl-dagger-missile";
           trailInterval = 0.5f;
           trailEffect = HPLFx.forceBulletTrail;
           hitEffect = HPLFx.forceBulletHit;
           despawnEffect = HPLFx.forceBulletDespawn;
           trailRotation = true;
           shrinkX = shrinkY = 0f;
           width = 8f;
           height = 12f;
           hitSize = 5;
           lifetime = 70;
           collidesGround = true;
           collidesAir = true;

           backColor = HPLPal.fors;
           frontColor = HPLPal.forsBack;
           trailColor = HPLPal.forceBulletBack;

           trailLength = 18;
           trailWidth = 3;

            splashDamage = 15f;
            splashDamageRadius = 20f;
        }};
    }
}
