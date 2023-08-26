package hpl.content;

import hpl.entities.bullets.AimBulletType;
import hpl.entities.units.StriCopterUnitType;
import hpl.graphics.HPLPal;
import hpl.world.draw.Blade;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.gen.UnitWaterMove;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

public class HPLUnits {
    public static UnitType
    //aurelia core units
    gyurza, veresk, vortex,
    //angelshark unit tree
    angelshark, glaucus, aurora,
    //unmaker tree
    unmaker,
    //vector tree
    vector, zephyr;
    //off the tree
    //supportDrone, torpedoNaval, bigKaboom
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
            buildSpeed = 0.4f;
            drag = 0.05f;
            speed = 3.3f;
            rotateSpeed = 17f;
            accel = 0.1f;
            itemCapacity = 50;
            health = 300f;
            engineSize = 3f;
            engineOffset = 9.5f;
            hitSize = 8f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;

            weapons.add(
                    new Weapon(){{
                        x = y = 0f;
                        mirror = false;
                        reload = 80f;
                        soundPitchMin = 1f;
                        shootSound = Sounds.missileSmall;
                        bullet = new BulletType(){{
                            shake = 2f;
                            speed = 0f;
                            keepVelocity = false;
                            inaccuracy = 2f;

                            spawnUnit = new MissileUnitType("gyurza-missile"){{
                                engineSize = 1.75f;
                                engineLayer = Layer.effect;
                                speed = 3.4f;
                                maxRange = 16f;
                                trailWidth = 1;

                                lifetime = 60;
                                outlineColor = HPLPal.aureliaOutline;
                                health = 25;
                                lowAltitude = true;

                                weapons.add(new Weapon(){{
                                    shootCone = 360f;
                                    mirror = false;
                                    reload = 1f;
                                    shootOnDeath = true;
                                    bullet = new ExplosionBulletType(75f, 15f){{
                                        shootEffect = Fx.massiveExplosion;
                                        buildingDamageMultiplier = 0.25f;
                                    }};
                                }});
                            }};
                        }};
                    }});
            parts.add(

                    new RegionPart("-blade") {{
                        moveRot = -10;
                        moves.add(new PartMove(PartProgress.reload, 0f, 1.5f, -5f));
                        progress = PartProgress.warmup;
                        mirror = true;
                    }});
        }};
        //endregion aureliaCoreUnits
        //region angelsharkTree
        angelshark = new UnitType("angelshark") {{
            targetAir = true;
            speed = 0.9f;
            drag = 0.12f;
            hitSize = 12f;
	    armor = 2;
            health = 620;
            accel = 0.2f;
            faceTarget = false;
            rotateSpeed = 4f;
            trailLength = 20;
            waveTrailX = 5.5f;
            trailScl = 1.3f;
            range = 25 * Vars.tilesize;
            constructor = UnitWaterMove::create;
            outlineColor = HPLPal.aureliaOutline;

            weapons.add(new Weapon("hpl-vog-launcher") {{
                reload = 90f;
                shootY = 2f;
                rotate = true;
                x = 0;
                y = -6;
                mirror = false;
                shootSound = Sounds.shootAlt;
                bullet = new MissileBulletType(5f, 20, "hpl-vog") {{
                    backColor = HPLPal.vogPinkBack;
                    frontColor = HPLPal.forceBullet;
                    width = 13f;
                    height = 15f;
                    hitSound = Sounds.explosion;
                    hitEffect = HPLFx.explosionSmall;
                    despawnEffect = HPLFx.explosionSmall2;
                    trailEffect = HPLFx.vogTrail;
                    trailRotation = true;
                    trailInterval = 0.5f;
                    lifetime = 35;

                    splashDamage = 65f;
                    splashDamageRadius = 30f;
                }};
            }});
        }};
        glaucus = new UnitType("glaucus") {{
            speed = 0.72f;
            hitSize = 15f;
            health = 1700;
	    armor = 8;
            accel = 0.3f;
            drag = 0.04f;

            faceTarget = true;
            targetAir = true;
            rotateSpeed = 3f;
            trailLength = 20;
            waveTrailX = 6f;
            waveTrailY = -4f;
            trailScl = 1.9f;
            range = 30 * Vars.tilesize;
            constructor = UnitWaterMove::create;
            outlineColor = HPLPal.aureliaOutline;

            weapons.add(
                    new Weapon("hpl-plasma-pointer") {{
                        reload = 60f;
                        shootY = 2f;
                        rotate = false;
                        x = 6;
                        y = 1.3f;
                        mirror = true;
                        alternate = false;
                        layerOffset = -0.0001f;
                        baseRotation = -65f;
                        shootCone = 360f;
						shootSound = Sounds.missileSmall;
                        shoot = new ShootSpread(1, 10f);
                        bullet = new AimBulletType(3f, 25) {{
                            backColor = HPLPal.vogPinkBack;
                            frontColor = HPLPal.vogPink;
							sprite = "hpl-dagger-missile";
                            maxRange = 240;
                            homingPower = 0.07f;
                            homingRange = 0;
                            shrinkY = 0f;
                            shrinkX = 0f;
                            drag = 0.01f;
                            width = 9f;
                            height = 15f;
                            hitSound = Sounds.explosion;
                            hitEffect = HPLFx.explosionSmall;
                            despawnEffect = HPLFx.explosionSmall2;
                            trailEffect = HPLFx.aimMissileTrail;
                            trailRotation = true;
                            trailInterval = 0.5f;
                            lifetime = 200f;

                            splashDamage = 85;
                            splashDamageRadius = 20;
                        }};
                    }},
                    new Weapon("hpl-plasma-pointer") {{
                        reload = 60f;
                        shootY = 2f;
                        rotate = false;
                        x = 6;
                        y = -2.3f;
                        mirror = true;
                        alternate = false;
                        layerOffset = -0.0001f;
                        baseRotation = -115f;
                        shootCone = 360f;
						shootSound = Sounds.missileSmall;
                        shoot = new ShootSpread(1, 10f);
                        bullet = new AimBulletType(3f, 25) {{
                            backColor = HPLPal.vogPinkBack;
                            frontColor = HPLPal.vogPink;
							sprite = "hpl-dagger-missile";
                            maxRange = 240;
                            homingPower = 0.07f;
                            homingRange = 0;
                            shrinkY = 0f;
                            shrinkX = 0f;
                            drag = 0.01f;
                            width = 9f;
                            height = 15f;
                            hitSound = Sounds.explosion;
                            hitEffect = HPLFx.explosionSmall;
                            despawnEffect = HPLFx.explosionSmall2;
                            trailEffect = HPLFx.aimMissileTrail;
                            trailRotation = true;
                            trailInterval = 0.5f;
                            lifetime = 200f;

                            splashDamage = 85;
                            splashDamageRadius = 20;
                        }};
                    }},
                    new Weapon("hpl-vog-automatic-launcher") {{
                        reload = 40f;
                        shootY = 3f;
                        inaccuracy = 4;
                        rotate = true;
                        x = 0;
                        y = -2.5f;
                        mirror = false;
                        shootSound = Sounds.shootAlt;
                        shoot.shots = 4;
                        shoot.shotDelay = 6f;
                        bullet = new MissileBulletType (6f, 10, "hpl-vog") {{
                            backColor = HPLPal.vogPinkBack;
                            frontColor = HPLPal.forceBullet;
                            width = 13f;
                            height = 15f;
                            hitSound = Sounds.explosion;
                            hitEffect = HPLFx.explosionSmall;
                            despawnEffect = HPLFx.explosionSmall2;
                            trailEffect = HPLFx.vogTrail;
                            trailRotation = true;
                            trailInterval = 0.5f;
                            lifetime = 40f;
                        }};
                        parts.add(
                        new RegionPart("-shaft"){
                            {
                                progress = PartProgress.recoil;
                                mirror = false;
                                under = true;
                                top = true;
                                moveX = 0f;
                                moveY = -3f;
                                moveRot = 0f;
                                //x = 0;
                                //y = -2f;
                            }});
                    }});
        }};

        aurora = new UnitType("aurora") {{
            speed = 0.7f;
            drag = 0.9f;
            hitSize = 17f;
	    armor = 14;
            health = 4300;
            accel = 0.35f;
            faceTarget = false;
            rotateSpeed = 3f;
            trailLength = 30;
            waveTrailX = 6f;
            trailScl = 1.5f;
            range = 30 * Vars.tilesize;
            constructor = UnitWaterMove::create;
            outlineColor = HPLPal.aureliaOutline;

            weapons.add (
                    new Weapon("kpa") {{

                        new RegionPart("shaft") {{

                        }};
                    }});
        }};
        //endregion angelsharkTree
        //region unmakerTree

        //endregion unmakerTree
        unmaker = new UnitType("unmaker") {{
            isEnemy = true;
            flying = true;
            drag = 0.08f;
            speed = 5.2f;
            rotateSpeed = 4f;
            accel = 0.4f;
            itemCapacity = 5;
            health = 350f;
            hitSize = 8.5f;
            outlineColor = HPLPal.aureliaOutline;
            weapons.add(
                    new Weapon("unmaker-teeth") {{
                        x = 10f /4;
                        y = 33f / 4;
                        reload = 20;
                        layerOffset = -0.002f;
                        alternate = false;
                        recoil = 3.5f;
                        shoot = new ShootSpread(3, 15f);
                        bullet = new BasicBulletType(3.5f, 15) {{
                            lifetime = 30f;
                            sprite = "dagger-bullet";
                            frontColor = HPLPal.unmakerColor;
                            backColor = HPLPal.unmakerDark;
                        }};
                    }});
        }};
        //region vectorTree
        vector = new UnitType("vector") {{
            isEnemy = true;

            lowAltitude = true;
            flying = true;
            drag = 0.05f;
            speed = 2.2f;
            rotateSpeed = 9f;
            accel = 0.4f;
            itemCapacity = 20;
            health = 480f;
            hitSize = 7f;
            outlineColor = HPLPal.aureliaOutline;
        }};
        zephyr = new UnitType("zephyr") {{
            isEnemy = true;
            flying = true;
            drag = 0.05f;
            speed = 2.6f;
            rotateSpeed = 14f;
            accel = 0.4f;
            itemCapacity = 25;
            health = 1370;
            hitSize = 7f;
            outlineColor = HPLPal.aureliaOutline;
        }};
        //endregion vectorTree
    }
}
