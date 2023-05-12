package hlp.content;

import arc.graphics.Color;
import hlp.entities.bullet.VogBulletType;
import hlp.graphics.HPLPal;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.gen.UnitWaterMove;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;


import static mindustry.Vars.tilesize;

public class HLPUnits {
    public static UnitType
            //aurelia core units
            gyurza,  /*veresk, vortex;*/
            //angelshark unit tree
            angelshark, glcucus;
    public static void load() {
        //region aureliaCoreUnits
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
        //endregion aureliaCoreUnits
        //region angelsharkTree
        angelshark = new UnitType("angelshark") {{
            speed = 0.72f;
            drag = 0.12f;
            hitSize = 12f;
            health = 230;
            accel = 0.2f;
            drag = 0.05f;
            rotateSpeed = 2.9f;
            faceTarget = true; //do not forget to put false here

            range = 25 * Vars.tilesize;
            constructor = UnitWaterMove::create;

            weapons.add(new Weapon("vog-launcher") {{
                reload = 45f;
                shootY = 2f;
                rotate = true;
                bullet = new VogBulletType(5f, 20) {{
                    lifetime = 60f;
                }};
            }});
        }};
        //endregion angelsharkTree
    }
}
