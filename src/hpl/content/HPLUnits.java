package hpl.content;

import arc.graphics.Color;
import arc.util.Time;
import hpl.ai.ground.DistanceGroundAI;
import hpl.entities.ability.ShieldAbility;
import hpl.entities.bullets.AimBulletType;
import hpl.entities.bullets.ModEmpBulletType;
import hpl.entities.units.DroneUnitType;
import hpl.entities.units.ShieldUnitType;
import hpl.entities.units.StriCopterUnitType;
import hpl.gen.Dronec;
import hpl.gen.HPLEntityMapping;
import hpl.gen.StriCopterc;
import hpl.graphics.HPLPal;
import hpl.world.draw.Blade;
import hpl.world.draw.Rotor;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.annotations.Annotations;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

import static mindustry.Vars.tilesize;

public class HPLUnits {
    public static UnitType
            //aurelia core units
            gyurza, veresk, chaos,
    //angelshark unit tree
    angelshark, glaucus, aurora, dunkleosteus,
    //unmaker tree
    //vector tree
    //fire support
    source, quantum, diffraction, interference,
    //amphibia
    aqua, nameFloat, salamander,
    //off the tree
    shell, bastion, citadel,
    testHealUnit;
    public static @Annotations.EntityDef(value = {StriCopterc.class}) UnitType unmaker, eliminator, exterminator, blighter, dragonfly;
    public static @Annotations.EntityDef(value = {Dronec.class}) UnitType vector, zephyr, vortex, whirlwind;
    // global unit + legs + transform
    public static @Annotations.EntityDef({Unitc.class})
    UnitType craber;
    //supportDrone, torpedoNaval, bigKaboom
    public static void load() {
        HPLEntityMapping.init();
        //region aureliaCoreUnits
        gyurza = new UnitType("gyurza") {{
            constructor = UnitEntity::create;

            aiController = BuilderAI::new;
            isEnemy = false;

            lowAltitude = true;
            flying = true;

            speed = 3.3f;
            rotateSpeed = 17f;
            accel = 0.1f;
            drag = 0.05f;

            mineSpeed = 8f;
            mineTier = 1;
            buildSpeed = 0.4f;

            health = 300f;
            hitSize = 8f;
            itemCapacity = 50;

            engineSize = 3f;
            engineOffset = 9.5f;
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
                                hitSize = 3;

                                weapons.add(new Weapon(){{
                                    shootCone = 360f;
                                    mirror = false;
                                    reload = 1f;
                                    shootOnDeath = true;
                                    bullet = new ExplosionBulletType(75f, 20f){{
                                        shootEffect = Fx.massiveExplosion;
                                        buildingDamageMultiplier = 0.40f;
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
            health = 500;
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
                    shrinkX = 0;
                    shrinkY = 0;
                    hitSound = Sounds.explosion;
                    hitEffect = HPLFx.hitExplosion;
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
            health = 1600;
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
                            hitEffect = HPLFx.hitExplosion;
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
                            hitEffect = HPLFx.hitExplosion;
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
                            shrinkX = 0;
                            shrinkY = 0;
                            hitSound = Sounds.explosion;
                            hitEffect = HPLFx.hitExplosion;
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
            health = 4050;
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


        unmaker = new StriCopterUnitType("unmaker") {{
            flying = true;

            speed = 4f;
            rotateSpeed = 10f;
            accel = 0.1f;
            drag = 0.05f;

            health = 360f;
            hitSize = 9f;
            itemCapacity = 5;

            engineSize = 0f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;
            blade.add(
                    new Blade(name + "-blade"){{
                        y = 1f; x = 1.3f;
                        bladeMoveSpeed = 40f;
                        bladeBlurAlphaMultiplier = 0.5f;
                    }},

                    new Blade(name + "-blade"){{
                        y = -1f; x = 1.3f;
                        bladeMoveSpeed = -40f;
                        bladeBlurAlphaMultiplier = 0.5f;
                    }});

            weapons.add(
                    new Weapon("hpl-unmaker-teeth") {{
                        x = 2f;
                        y = 8f;
                        reload = 20;
                        layerOffset = -0.002f;
                        inaccuracy = 0.4f;

                        recoil = 3.5f;
                        shoot = new ShootSpread(3, 5f);
                        bullet = new BasicBulletType(5.5f, 15) {{
                            lifetime = 25f;
                            sprite = "hpl-dagbul";
                            statusDuration = 2f * Time.toSeconds;
                            status = HPLStatusEffects.weakness;
                            width = 10f;
                            height = 12f;
                            shrinkX = 0;
                            shrinkY = 0;
                            trailChance = 0.7f;
                            trailEffect = HPLFx.unmakerBulletTrail;
                            hitEffect = HPLFx.smallGreenExplosion;
                            despawnEffect = hitEffect;
                            frontColor = Color.valueOf("ffffff");
                            backColor = HPLPal.unmakerColor;
                        }};
                    }});
        }};

        eliminator = new StriCopterUnitType("eliminator") {{
            flying = true;

            speed = 1.95f;
            rotateSpeed = 7f;
            accel = 0.2f;
            drag = 0.05f;

            health = 970f;
            hitSize = 12f;
            itemCapacity = 10;
            range = 15 * tilesize;

            engineSize = 3f;
            engineOffset = 9.5f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;
            weapons.add(
                    new Weapon("eliminator-emp") {{
                        reload = 50;
                        layerOffset = -0.002f;
                        recoil = 3.5f;
                        bullet = new ModEmpBulletType() {{
                            lifetime = 45;
                            hitSize = 5;
                            speed = 4.5f;
                            damage = 40;
                            powerDamageScl = 0.2f;
                            powerSclDecrease = 0.1f;
                            statusDuration = 0.9f * Time.toSeconds;
                            status = HPLStatusEffects.weakness;
                            pierce = true;
                            pierceCap = 2;
                            radius = 5 * tilesize;
                            chainEffect = Fx.none;
                            timeDuration = 60f * 4f;
                            lightningLength = 15;

                            width = 17f;
                            height = 12f;
                            shrinkX = 0;
                            shrinkY = 0;

                            frontColor = HPLPal.unmakerColor;
                            backColor = Color.valueOf("ffffff");
                            sprite = "hpl-emp-wave";
                        }};
                    }});
            blade.add(
                    new Blade(name + "-blade-big"){{
                        y = 1.5f; x = 1.3f;
                        bladeMoveSpeed = 40f;
                        bladeBlurAlphaMultiplier = 0.5f;
                    }},

                    new Blade(name + "-blade"){{
                        y = -0.2f; x = 1.3f;
                        bladeMoveSpeed = -40f;
                        bladeBlurAlphaMultiplier = 0.5f;
                    }});

        }};
        dragonfly = new StriCopterUnitType("dragonfly") {{
            flying = true;

            speed = 4.5f;
            rotateSpeed = 10f;
            accel = 0.1f;
            drag = 0.05f;

            health = 150f;
            hitSize = 5f;
            itemCapacity = 5;

            engineSize = 0f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;
            blade.add(

                    new Blade(name + "-blade"){{
                        y = 0; x = 0f;
                        bladeMoveSpeed = -40f;
                        bladeBlurAlphaMultiplier = 0.9f;
                    }});
            weapons.add(
                    new Weapon("aaa") {{
                        y = 4f;
                        x = 0;
                        reload = 60;
                        layerOffset = -0.002f;
                        recoil = 3.5f;
                        mirror = false;
                        bullet = new BasicBulletType(5.5f, 15) {{
                            lifetime = 20f;
                            sprite = "hpl-dagbul";
                            statusDuration = 0.99f * Time.toSeconds;
                            status = HPLStatusEffects.decomposition;
                            width = 9f;
                            height = 11f;
                            shrinkX = 0;
                            shrinkY = 0;
                            trailEffect = HPLFx.unmakerBulletTrail;
                            hitEffect = HPLFx.smallGreenExplosion;
                            despawnEffect = hitEffect;
                            frontColor = Color.valueOf("ffffff");
                            backColor = HPLPal.unmakerColor;
                        }};
                    }});
        }};
        //endregion unmakerTree
        //region vectorTree
        vector = new DroneUnitType("vector") {{
            isEnemy = true;

            lowAltitude = true;
            flying = true;
            drag = 0.07f;
            speed = 2.3f;
            rotateSpeed = 16f;
            accel = 0.1f;
            itemCapacity = 20;
            health = 450f;
            hitSize = 7f;
            outlineColor = HPLPal.aureliaOutline;

            rotors.add(
                    new Rotor(name + "-rotor"){{
                        rotorLayer = -0.1f;
                        rotorSpeed = 30f;
                        x = 0f;
                        y = 0f;
                        rotorNotRadial = false;
                        rotorRadial = true;
                        bladeCount = 3;
                    }});
            weapons.add(new Weapon("hpl-vector-gun") {{
                reload = 10f;
                rotate = false;
                x = -4;
                y = -3;
                mirror = true;
                alternate = true;
                shootY = 1.7f;
                shootSound = Sounds.shootAlt;
                bullet = new BasicBulletType(6f, 13) {{
                    sprite = "hpl-grenade";
                    backColor = HPLPal.droneBulletBack;
                    frontColor = HPLPal.droneBullet;
                    width = 7f;
                    height = 10f;
                    shrinkX = 0;
                    shrinkY = 0;
                    hitSound = Sounds.explosion;
                    hitEffect = HPLFx.blueHitExplosion1;
                    despawnEffect = HPLFx.smallBlueExplosion;
                    lifetime = 25;
                }};
            }});
        }};
        zephyr = new DroneUnitType("zephyr") {{
            isEnemy = true;

            lowAltitude = true;
            flying = true;
            drag = 0.05f;
            speed = 2f;
            rotateSpeed = 14f;
            accel = 0.1f;
            itemCapacity = 30;
            health = 1090f;
            hitSize = 12f;

            outlineColor = HPLPal.aureliaOutline;

            rotors.add(
                    new Rotor(name + "-rotor") {{
                        rotorSpeed = 30f;
                        x = 0f;
                        y = 0f;
                        bladeCount = 3;
                        rotorNotRadial = false;
                        rotorRadial = true;
                        drawRotorTop = true;
                        drawGlow = true;
                    }});
            weapons.add(new Weapon("hpl-zephyr-gun") {{
                reload = 25f;
                shootY = 2f;
                rotate = false;
                x = -5;
                y = -4;
                mirror = true;
                alternate = true;
                shootSound = Sounds.shootAlt;
                bullet = new BasicBulletType(5.5f, 30) {{
                    sprite = "hpl-grenade";
                    backColor = HPLPal.droneBulletBack;
                    frontColor = HPLPal.droneBullet;
                    width = 9f;
                    height = 11f;
                    hitSound = Sounds.explosion;
                    hitEffect = HPLFx.blueHitExplosionNormal;
                    despawnEffect = HPLFx.blueExplosionNormal;
                    lifetime = 30;
                    shrinkX = 0;
                    shrinkY = 0;
                    splashDamage = 10f;
                    splashDamageRadius = 2f * Vars.tilesize;
                    fragBullets = 4;
                    fragBullet = new BasicBulletType(4f, 15) {{
                        sprite = "hpl-grenade";
                        backColor = HPLPal.droneBulletBack;
                        frontColor = HPLPal.droneBullet;
                        width = 5f;
                        height = 8f;
                        shrinkX = 0;
                        shrinkY = 0;
                        hitSound = Sounds.explosion;
                        hitEffect = HPLFx.blueHitExplosion1;
                        despawnEffect = HPLFx.smallBlueExplosion;
                        lifetime = 10;
                    }};
                }};
            }});
        }};
        //endregion vectorTree
        craber = new ShieldUnitType("craber"){{
            aiController = DistanceGroundAI::new;
            speed = 0.3f;
            health = 730;
            armor = 10f;
            hitSize = 16f;
            hovering = true;

            abilities.add(new ShieldAbility(4, 0.1f, 20f, 600f, 2.3f, 1.3f, 32.2f));
        }};
    }
}
