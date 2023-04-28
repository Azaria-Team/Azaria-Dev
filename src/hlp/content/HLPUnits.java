package hlp.content;

import arc.graphics.Color;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import static mindustry.Vars.tilesize;

public class HLPUnits {
    public static UnitType
            gyurza;

    public static void load() {
        //core
        gyurza = new UnitType("gyurza") {{
            aiController = BuilderAI::new;
            isEnemy = false;

            targetPriority = -1;
            lowAltitude = true;
            flying = true;
            mineSpeed = 8f;
            mineTier = 2;
            buildSpeed = 0.9f;
            drag = 0.05f;
            speed = 3.3f;
            rotateSpeed = 17f;
            accel = 0.1f;
            itemCapacity = 50;
            health = 230f;
            engineOffset = 6f;
            hitSize = 9f;
            faceTarget = false;

            constructor = UnitEntity::create;

            weapons.add(
            new Weapon(){{
                x = y = 0f;
                mirror = false;
                reload = 30f;
                minShootVelocity = 0.01f;

                soundPitchMin = 1f;
                shootSound = Sounds.flame;

                bullet = new FlakBulletType(){{
                    width = 8;
                    height = 8;

                    maxRange = 10f;
                    ignoreRotation = true;

                    backColor = Pal.heal;
                    frontColor = Color.white;
                    mixColorTo = Color.white;

                    hitSound = Sounds.plasmaboom;

                    shootCone = 180f;
                    ejectEffect = Fx.none;
                    hitShake = 1f;

                    collidesAir = false;

                    lifetime = 300f;

                    hitEffect = Fx.massiveExplosion;
                    keepVelocity = false;

                    speed = 0f;
                    damage = 60;

                    splashDamage = 40f;
                    splashDamageRadius = 100f;
                }};
            }});
        }};
    }
}
