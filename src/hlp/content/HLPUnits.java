package hlp.content;

import arc.graphics.Color;
import hlp.graphics.HPLPal;
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
            //aurelia core units
            gyurza; /*veresk, vortex;*/

    public static void load() {
        //core
        gyurza = new UnitType("gyurza") {{
            constructor = UnitEntity::create;

            aiController = BuilderAI::new;
            isEnemy = false;

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
            engineSize = 1.8f;
            engineOffset = 5.7f;
            hitSize = 8f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;

            weapons.add(
            new Weapon(){{
                x = y = 0f;
                mirror = false;
                reload = 20f;

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
