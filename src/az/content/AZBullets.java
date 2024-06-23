package az.content;

import arc.math.Interp;
import az.entities.bullets.AntiMissileBulletType;
import az.graphics.AZPal;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.gen.Sounds;
import mindustry.type.StatusEffect;

public class AZBullets {
    public static BulletType
            noneBullet, forceBullet, forceFerbiumBullet, hornBullet, antiMissileBullet, shrapnelBullet, razeBullet;

    public static void load() {

        noneBullet = new BasicBulletType(0f, 0f){{
            shrinkX = shrinkY = 0f;
            width = 0f;
            height = 0f;
            despawnEffect = hitEffect = shootEffect = smokeEffect =  Fx.none;
            lifetime = 0f;
            speed = 0f;
            damage = 0f;
            sprite = "az-none";
            collidesAir = true;
            collidesGround = true;
            range = 17 * 8f;
            maxRange = 17 * 8f;
            despawnSound = hitSound = Sounds.none;
        }};
        forceBullet = new BasicBulletType(6f, 35f){{
            splashDamage = 30f;
            splashDamageRadius = 25f;
            sprite = "az-dagger-missile";
            trailInterval = 0.5f;
            trailEffect = AZFx.forceBulletTrail;
            hitEffect = AZFx.forceBulletHit;
            despawnEffect = AZFx.forceBulletDespawn;
            trailRotation = true;
            shrinkX = shrinkY = 0f;
            width = 8f;
            height = 12f;
            lifetime = 34;
            collidesGround = true;
            collidesAir = true;
            hitSize = 3;
            homingPower = 0.3f;

            trailColor = AZPal.vogPinkBack;
            backColor = AZPal.vogPinkBack;
            frontColor = AZPal.vogPink;

            trailLength = 18;
            trailWidth = 1.7f;
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
            lifetime = 28;
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
            splashDamageRadius = 40f;
            fragBullets = 5;
            ammoMultiplier = 3f;
            fragBullet = new BasicBulletType(2f, 10) {{
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

        hornBullet = new BasicBulletType(5f, 35f){{
            hitEffect = AZFx.hornBulletHit;
            despawnEffect = AZFx.hornBulletDespawn;
            width = 52f;
            height = 5;
            shrinkY = -2f;
            shrinkX = 0.1f;
            hitSize = 9;
            knockback = 3.5f;
            ammoMultiplier = 0;

            shrinkInterp = Interp.reverse;
            lifetime = 26;
            collidesGround = true;
            collidesAir = true;
            impact = true;
            pierce = true;
            pierceCap = 2;
            trailLength = 10;
            trailWidth = 3;

            status = new StatusEffect("") {{
                    disarm = true;
                    speedMultiplier = 0.0f;
                    statusDuration = 55f;
                }};
            backColor = AZPal.craside;
            frontColor = AZPal.craside2;
        }};


        razeBullet = new BasicBulletType(7f, 40f){{
            sprite = "az-grenade";
            trailInterval = 0.5f;
            hitEffect = AZFx.superdanseBulletHit;
            despawnEffect = AZFx.superdanseBulletDespawn;
            trailRotation = false;
            shrinkX = shrinkY = 0f;
            width = 10f;
            height = 14f;
            lifetime = 38;
            collidesGround = false;
            collidesAir = true;
            hitSize = 5;
            //homingPower = 0.3f;

            backColor = AZPal.superdenseBulletBack;
            frontColor = AZPal.superdenseBullet;

            trailColor = AZPal.superdenseAlloy;
            trailEffect = Fx.none;
            trailLength = 10;
            trailWidth = 2f;
            ammoMultiplier = 3f;

            splashDamage = 50f;
            splashDamageRadius = 5.5f * 8f;
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
