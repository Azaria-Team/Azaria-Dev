package hlp.content;

import arc.graphics.Color;
import hlp.entities.bullets.AimBulletType;
import hlp.graphics.HLPPal;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.pattern.ShootSpread;
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
    angelshark, glaucus;
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
            health = 290f;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            hitSize = 8f;
            alwaysUnlocked = true;
            outlineColor = HLPPal.aureliaOutline;

            weapons.add(
                    new Weapon(){{
                        x = y = 0f;
                        mirror = false;
                        reload = 30f;
                        soundPitchMin = 1f;
                        shootSound = Sounds.flame;
                        bullet = new FlakBulletType(){{
                            width = 8;
                            height = 8;
                            shrinkY = 0;
                            shrinkX = 0;
                            maxRange = 10f;
                            ignoreRotation = true;
                            backColor = Pal.bulletYellowBack;
                            frontColor = Pal.bulletYellow;
                            hitSound = Sounds.plasmaboom;
                            shootCone = 180f;
                            ejectEffect = Fx.none;
                            shootEffect = Fx.none;
                            hitShake = 1f;
                            collidesAir = true;
                            collidesGround = true;
                            lifetime = 80f;
                            hitEffect = Fx.massiveExplosion;
                            keepVelocity = false;
                            speed = 0f;
                            damage = 15;
                            splashDamage = 20f;
                            splashDamageRadius = 100f;
                        }};
                    }});
        }};
        //endregion aureliaCoreUnits
        //region angelsharkTree
        angelshark = new UnitType("angelshark") {{
            speed = 0.9f;
            drag = 0.12f;
            hitSize = 12f;
            health = 300;
            accel = 0.2f;
            faceTarget = false;
            rotateSpeed = 4f;
            trailLength = 20;
            waveTrailX = 5.5f;
            trailScl = 1.3f;
            range = 25 * Vars.tilesize;
            constructor = UnitWaterMove::create;
            outlineColor = HLPPal.aureliaOutline;

            weapons.add(new Weapon("hlp-vog-launcher") {{
                reload = 30f;
                shootY = 2f;
                rotate = true;
                x = 0;
                y = -6;
                mirror = false;
                bullet = new MissileBulletType(5f, 23, "hlp-vog") {{
                    backColor = HLPPal.vogPinkBack;
                    frontColor = HLPPal.vogPink;
                    homingPower = 0.02f;
                    width = 13f;
                    height = 15f;
                    hitSound = Sounds.explosion;
                    hitEffect = HLPFx.explosionSmall;
                    despawnEffect = HLPFx.explosionSmall2;
                    trailEffect = HLPFx.vogTrail;
                    trailRotation = true;
                    trailInterval = 0.5f;
                    lifetime = 60f;
                }};
            }});
        }};
        glaucus = new UnitType("glaucus") {{
            speed = 0.72f;
            drag = 0.15f;
            hitSize = 15f;
            health = 780;
            accel = 0.3f;
            drag = 0.04f;

            faceTarget = false;
            rotateSpeed = 3f;
            trailLength = 20;
            waveTrailX = 6f;
            waveTrailY = -4f;
            trailScl = 1.9f;
            range = 30 * Vars.tilesize;
            constructor = UnitWaterMove::create;
            outlineColor = HLPPal.aureliaOutline;

            weapons.add(
                    new Weapon("hlp-plasma-pointer") {{
                        reload = 60f;
                        shootY = 2f;
                        rotate = false;
                        x = 5;
                        y = 1;
                        mirror = true;
                        alternate = false;
                        layerOffset = -0.0001f;
                        baseRotation = -65f;
                        shootCone = 360f;
                        shoot = new ShootSpread(1, 10f);
                        bullet = new AimBulletType(3f, 26) {{
                            backColor = HLPPal.vogPinkBack;
                            frontColor = HLPPal.vogPink;
							sprite = "hlp-dagger-missile";
                            maxRange = 190;
                            homingPower = 0.06f;
                            homingRange = 0;
                            drag = 0.01f;
                            width = 13f;
                            height = 15f;
                            hitSound = Sounds.explosion;
                            hitEffect = HLPFx.explosionSmall;
                            despawnEffect = HLPFx.explosionSmall2;
                            trailEffect = HLPFx.paimMissileTrail;
                            trailRotation = true;
                            trailInterval = 0.5f;
                            lifetime = 180f;
                        }};
                    }},
                    new Weapon("hlp-plasma-pointer") {{
                        reload = 60f;
                        shootY = 2f;
                        rotate = false;
                        x = 5;
                        y = -2;
                        mirror = true;
                        alternate = false;
                        layerOffset = -0.0001f;
                        baseRotation = -115f;
                        shootCone = 360f;
                        shoot = new ShootSpread(1, 10f);
                        bullet = new AimBulletType(3f, 26) {{
                            backColor = HLPPal.vogPinkBack;
                            frontColor = HLPPal.vogPink;
							sprite = "hlp-dagger-missile";
                            homingPower = 0.06f;
                            homingRange = 0;
                            drag = 0.01f;
                            width = 13f;
                            height = 15f;
                            hitSound = Sounds.explosion;
                            hitEffect = HLPFx.explosionSmall;
                            despawnEffect = HLPFx.explosionSmall2;
                            trailEffect = HLPFx.paimMissileTrail;
                            trailRotation = true;
                            trailInterval = 0.5f;
                            lifetime = 180f;
                        }};
                    }});
        }};
        //endregion angelsharkTree
    }
}
