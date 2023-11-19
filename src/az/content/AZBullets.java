package az.content;

import arc.math.Interp;
import az.entities.bullets.AntiMissileBulletType;
import az.graphics.AZPal;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.ShrapnelBulletType;

public class AZBullets {
    public static BulletType
            noneBullet, forceBullet, hornBullet, antiMissileBullet, shrapnelBullet;

    public static void load() {

        noneBullet = new BasicBulletType(0f, 0f){{
            shrinkX = shrinkY = 0f;
            width = 0f;
            height = 0f;
            lifetime = 0;
            despawnEffect = hitEffect = Fx.none;
        }};
        forceBullet = new BasicBulletType(6f, 60f){{
           sprite = "az-dagger-missile";
           trailInterval = 0.5f;
           trailEffect = AZFx.forceBulletTrail;
           hitEffect = AZFx.forceBulletHit;
           despawnEffect = AZFx.forceBulletDespawn;
           trailRotation = true;
           shrinkX = shrinkY = 0f;
           width = 8f;
           height = 12f;
           lifetime = 35;
           collidesGround = true;
           collidesAir = true;
           hitSize = 3;
           homingPower = 0.3f;

           trailColor = AZPal.vogPinkBack;
           backColor = AZPal.vogPinkBack;
           frontColor = AZPal.forceBullet;

           trailLength = 18;
           trailWidth = 1.7f;

            splashDamage = 40f;
            splashDamageRadius = 25f;
        }};

        hornBullet = new BasicBulletType(5f, 40f){{
            hitEffect = AZFx.hornBulletHit;
            despawnEffect = AZFx.hornBulletDespawn;
            width = 52f;
            height = 5;
            shrinkY = -2f;
            shrinkX = 0.1f;
            hitSize = 9;
            knockback = 3.3f;
            ammoMultiplier = 0;

            shrinkInterp = Interp.reverse;
            lifetime = 26;
            collidesGround = true;
            collidesAir = true;
            impact = true;
            pierce = true;
            pierceCap = 2;

            backColor = AZPal.craside;
            frontColor = AZPal.craside2;

        }};

        antiMissileBullet = new AntiMissileBulletType(6f, 60f, 10 * Vars.tilesize){{
            sprite = "az-dagger-missile";
            shrinkX = shrinkY = 0f;
            speed = 6;
            damage = 60;
            width = 8f;
            height = 12f;
            lifetime = 35;
            collidesGround = true;
            collidesAir = true;
            hitSize = 3;
            homingPower = 0.3f;

            hitEffect = AZFx.hitExplosion;
            despawnEffect = AZFx.explosionSmall2;
            trailEffect = AZFx.vogTrail;
            trailRotation = true;
            trailInterval = 0.5f;

            splashDamage = 40f;
            splashDamageRadius = 25f;
        }};

        shrapnelBullet = new ShrapnelBulletType(){{
            damage = 1f;
            length = 110f;
        }};
    }
}
