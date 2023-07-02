package hpl.content;

import hpl.entities.bullets.AimBulletType;
import hpl.entities.units.StriCopterUnitType;
import hpl.graphics.HPLPal;
import hpl.world.draw.Blade;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.bullet.MissileBulletType;
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
    gyurza,  /*veresk, vortex;*/
    //angelshark unit tree
    angelshark, glaucus,
    unmaker;
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
            engineSize = 4f;
            engineOffset = 11f;
            hitSize = 8f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;

            weapons.add(
                    new Weapon(){{
                        x = y = 0f;
                        mirror = false;
                        reload = 70f;
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
                                speed = 3f;
                                maxRange = 15f;
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
                                    bullet = new ExplosionBulletType(30f, 10f){{
                                        shootEffect = Fx.massiveExplosion;
                                        buildingDamageMultiplier = 0.25f;
                                    }};
                                }});
                            }};
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
            outlineColor = HPLPal.aureliaOutline;

            weapons.add(new Weapon("hpl-vog-launcher") {{
                reload = 30f;
                shootY = 2f;
                rotate = true;
                x = 0;
                y = -6;
                mirror = false;
                shootSound = Sounds.shootAlt;
                bullet = new MissileBulletType(5f, 23, "hpl-vog") {{
                    backColor = HPLPal.vogPinkBack;
                    frontColor = HPLPal.vogPink;
                    homingPower = 0.02f;
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
            }});
        }};
        glaucus = new UnitType("glaucus") {{
            speed = 0.72f;
            drag = 0.15f;
            hitSize = 15f;
            health = 780;
            accel = 0.3f;
            drag = 0.04f;

            faceTarget = true;
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
                        x = 5;
                        y = 1;
                        mirror = true;
                        alternate = false;
                        layerOffset = -0.0001f;
                        baseRotation = -65f;
                        shootCone = 360f;
						shootSound = Sounds.missileSmall;
                        shoot = new ShootSpread(1, 10f);
                        bullet = new AimBulletType(3f, 26) {{
                            backColor = HPLPal.vogPinkBack;
                            frontColor = HPLPal.vogPink;
							sprite = "hpl-dagger-missile";
                            maxRange = 190;
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
                        }};
                    }},
                    new Weapon("hpl-plasma-pointer") {{
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
						shootSound = Sounds.missileSmall;
                        shoot = new ShootSpread(1, 10f);
                        bullet = new AimBulletType(3f, 26) {{
                            backColor = HPLPal.vogPinkBack;
                            frontColor = HPLPal.vogPink;
							sprite = "hpl-dagger-missile";
                            homingPower = 0.06f;
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
                        }};
                    }});
        }};
        //endregion angelsharkTree
    }
}
