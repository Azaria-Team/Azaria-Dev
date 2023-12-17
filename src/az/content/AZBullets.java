package az.content;

import arc.math.Interp;
import az.entities.bullets.AntiMissileBulletType;
import az.graphics.AZPal;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.gen.Sounds;

public class AZBullets {
    public static BulletType
            noneBullet, forceBullet, forceFerbiumBullet, hornBullet, antiMissileBullet, shrapnelBullet;

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

        forceFerbiumBullet = new BasicBulletType(7f, 45f){{
            sprite = "az-dagger-missile";
            trailInterval = 0.4f;
            trailEffect = AZFx.forceFerbiumBulletTrail;
            hitEffect = AZFx.forceFerbiumBulletHit;
            despawnEffect = AZFx.forceFerbiumBulletDespawn;
            trailRotation = true;
            shrinkX = shrinkY = 0f;
            width = 8f;
            height = 14f;
            lifetime = 29;
            collidesGround = true;
            collidesAir = true;
            hitSize = 3;
            homingPower = 0.3f;

            trailColor = AZPal.ferbiumBulletBack;
            backColor = AZPal.ferbiumBulletBack;
            frontColor = AZPal.ferbiumBullet;

            trailLength = 20;
            trailWidth = 1.7f;

            splashDamage = 45f;
            splashDamageRadius = 35f;
            fragBullets = 5;
            fragBullet = new BasicBulletType(2f, 8) {{
               // sprite = "bullet";
                backColor = AZPal.ferbiumBulletBack;
                frontColor = AZPal.ferbiumBullet;
                width = 3f;
                height = 8f;
                shrinkX = 0;
                shrinkY = 0;
                hitSound = Sounds.explosion;
                hitEffect = Fx.none;
                despawnEffect = Fx.none;
                lifetime = 5;
            }};
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
