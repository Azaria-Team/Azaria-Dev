package az.content;

import arc.func.Prov;
import arc.graphics.Color;
import arc.math.Interp;
import arc.math.geom.Rect;
import arc.struct.ObjectIntMap;
import arc.struct.ObjectMap;

import arc.util.Time;
import az.entities.ability.ModShieldArcAbility;
import az.entities.bullets.AimBulletType;
import az.entities.bullets.ModEmpBulletType;
import az.entities.entity.DroneUnitEntity;
import az.entities.entity.StriCopterUnitEntityLegacy;
import az.entities.units.DroneUnitType;
import az.entities.units.StriCopterUnitType;
import az.graphics.AZPal;
import az.pattern.AZBurstShoot;
import az.world.draw.Blade;
import az.world.draw.Rotor;

import azaria.gen.StriCopterUnit;
import azaria.gen.StriCopterc;
import azaria.gen.TankUnit;
import ent.anno.Annotations;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.BlockFlag;

import static mindustry.Vars.tilesize;
public class AZUnits {
    public static UnitType
            //aurelia core units
            gyurza, veresk, chaos,
    //angelshark unit tree
    angelshark, glaucus, aurora, piranha, megalodon,
    //vector tree
    vector, zephyr, vortex, altura, cataclysm;

    //fire support
    //...

    //off the tree
    public static @Annotations.EntityDef({Unitc.class, StriCopterc.class})
    //unmaker tree
    UnitType unmaker, eliminator, exterminator, blighter, plague, dragonfly;

    public static @Annotations.EntityDef({Unitc.class, Tankc.class})
    //support
    UnitType sentinel, custodian, bulwark, bulat, colossus;
    private static final ObjectMap.Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new ObjectMap.Entry[]{
            prov(DroneUnitEntity.class, DroneUnitEntity::new)
    };

    private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

    /**
     * Internal function to flatmap {@code Class -> Prov} into an {@link ObjectMap.Entry}.
     * @author GlennFolker
     */
    private static <T extends Entityc> ObjectMap.Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov) {
        ObjectMap.Entry<Class<T>, Prov<T>> entry = new ObjectMap.Entry<>();
        entry.key = type;
        entry.value = prov;
        return entry;
    }

    /**
     * Setups all entity IDs and maps them into {@link EntityMapping}.
     * <p>
     * Put this inside load()
     * </p>
     * @author GlennFolker
     */
    private static void setupID() {
        for (
                int i = 0,
                j = 0,
                len = EntityMapping.idMap.length;
                i < len;
                i++
        ) {
            if (EntityMapping.idMap[i] == null) {
                idMap.put(types[j].key, i);
                EntityMapping.idMap[i] = types[j].value;
                if (++j >= types.length) break;
            }
        }
    }

    /**
     * Retrieves the class ID for a certain entity type.
     * @author GlennFolker
     */
    public static <T extends Entityc> int classID(Class<T> type) {
        return idMap.get(type, -1);
    }

    public static void load() {
        setupID();

        //region aureliaCoreUnits
        gyurza = new UnitType("gyurza") {{
            constructor = UnitEntity::create;

            aiController = BuilderAI::new;
            isEnemy = false;
            range = 230;

            lowAltitude = true;
            flying = true;

            speed = 3.3f;
            rotateSpeed = 13f;
            accel = 0.1f;
            drag = 0.05f;

            mineSpeed = 8f;
            mineTier = 1;
            buildSpeed = 0.6f;

            health = 500f;
            hitSize = 8f;
            itemCapacity = 50;

            engineSize = 3f;
            engineOffset = 9.5f;
            alwaysUnlocked = true;
            outlineColor = AZPal.aureliaOutline;

            weapons.add(
                    new Weapon(){{
                        x = y = 0f;
                        mirror = false;
                        reload = 90f;
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
                                speed = 4.2f;
                                maxRange = 16f;
                                trailWidth = 1;

                                lifetime = 55;
                                outlineColor = AZPal.aureliaOutline;
                                health = 25;
                                lowAltitude = true;
                                hittable = false;
                                targetable = false;
                                hitSize = 2f;

                                weapons.add(new Weapon(){{
                                    shootCone = 360f;
                                    mirror = false;
                                    reload = 1f;
                                    shootOnDeath = true;
                                    bullet = new ExplosionBulletType(90f, 3f * tilesize){{
                                        shootEffect = Fx.explosion;
                                        buildingDamageMultiplier = 0.5f;
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
            outlineColor = AZPal.aureliaOutline;

            weapons.add(new Weapon("az-vog-launcher") {{
                reload = 90f;
                shootY = 2f;
                rotate = true;
                x = 0;
                y = -6;
                mirror = false;
                shootSound = Sounds.shootAlt;
                bullet = new MissileBulletType(5f, 20, "az-vog") {{
                    backColor = AZPal.vogPinkBack;
                    frontColor = AZPal.forceBullet;
                    width = 13f;
                    height = 15f;
                    shrinkX = 0;
                    shrinkY = 0;
                    hitSound = Sounds.explosion;
                    hitEffect = AZFx.hitExplosion;
                    despawnEffect = AZFx.explosionSmall2;
                    trailEffect = AZFx.vogTrail;
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
                outlineColor = AZPal.aureliaOutline;

                parts.add(
                        new RegionPart("-shaft") {{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = true;
                            moveX = 0f;
                            moveY = -3f;
                            moveRot = 0f;
                            //x = 0;
                            //y = -2f;
                        }});

                weapons.add(
                        new Weapon("az-plasma-pointer") {{
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
                                backColor = AZPal.vogPinkBack;
                                frontColor = AZPal.vogPink;
                                sprite = "az-dagger-missile";
                                maxRange = 240;
                                homingPower = 0.07f;
                                homingRange = 0;
                                shrinkY = 0f;
                                shrinkX = 0f;
                                drag = 0.01f;
                                width = 9f;
                                height = 15f;
                                hitSound = Sounds.explosion;
                                hitEffect = AZFx.hitExplosion;
                                despawnEffect = AZFx.explosionSmall2;
                                trailEffect = AZFx.aimMissileTrail;
                                trailRotation = true;
                                trailInterval = 0.5f;
                                lifetime = 200f;

                                splashDamage = 85;
                                splashDamageRadius = 20;
                            }};
                        }},
                        new Weapon("az-plasma-pointer") {
                            {
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
                                bullet = new AimBulletType(3f, 25) {
                                    {
                                        backColor = AZPal.vogPinkBack;
                                        frontColor = AZPal.vogPink;
                                        sprite = "az-dagger-missile";
                                        maxRange = 240;
                                        homingPower = 0.07f;
                                        homingRange = 0;
                                        shrinkY = 0f;
                                        shrinkX = 0f;
                                        drag = 0.01f;
                                        width = 9f;
                                        height = 15f;
                                        hitSound = Sounds.explosion;
                                        hitEffect = AZFx.hitExplosion;
                                        despawnEffect = AZFx.explosionSmall2;
                                        trailEffect = AZFx.aimMissileTrail;
                                        trailRotation = true;
                                        trailInterval = 0.5f;
                                        lifetime = 200f;

                                        splashDamage = 85;
                                        splashDamageRadius = 20;
                                    }
                                };
                            }}
                );

                weapons.add(
                        new Weapon("az-vog-automatic-launcher") {{
                                reload = 40f;
                                shootY = 3f;
                                inaccuracy = 4;
                                rotate = true;
                                x = 0;
                                y = -2.5f;
                                mirror = false;
                                shootSound = Sounds.shootAlt;

                                shoot = new AZBurstShoot(2, 4, 6.0f);
                                bullet = new MissileBulletType(6f, 10, "az-vog") {{
                                    backColor = AZPal.vogPinkBack;
                                    frontColor = AZPal.vogPink;
                                    width = 13f;
                                    height = 15f;
                                    shrinkX = 0;
                                    shrinkY = 0;
                                    hitSound = Sounds.explosion;
                                    hitEffect = AZFx.hitExplosion;
                                    despawnEffect = AZFx.explosionSmall2;
                                    trailEffect = AZFx.vogTrail;
                                    trailRotation = true;
                                    trailInterval = 0.5f;
                                    lifetime = 40f;
                                }};
                        }}
                );
        }};

        aurora = new UnitType("aurora") {{
            speed = 0.67f;
            drag = 0.9f;
            hitSize = 17f;
            armor = 14;
            health = 4050;
            accel = 0.35f;
            faceTarget = false;
            rotateSpeed = 4f;
            trailLength = 30;
            waveTrailX = 6f;
            trailScl = 1.5f;
            range = 30 * Vars.tilesize;
            constructor = UnitWaterMove::create;
            outlineColor = AZPal.aureliaOutline;

            weapons.add(
                    new Weapon("az-laser-launcher") {{
                        reload = 6f * Time.toSeconds;

                        x = 1.5f;
                        shootX = -6.7f;
                        shootY = -8f;
                        mirror = false;
                        rotate = true;
                        rotateSpeed = 1f;
                        layerOffset = 0.01f;
                        showStatSprite = false;
                        shootSound = Sounds.missileLaunch;
                        targetAir = false;
                        //shootStatus = StatusEffects.unmoving;
//                        shoot.firstShotDelay = 90f;
                        parts.add(
                                new RegionPart("-missile") {{
                                    y = 0.5f;
                                    progress = PartProgress.reload.curve(Interp.pow2In);
                                    under = true;
                                    x = -8f;
                                    moves.add(new PartMove(PartProgress.reload,8f, 0f, 0f));
                                }},
                                new RegionPart("-lens") {{
                                    under = true;
                                }},
                                new RegionPart("-lid") {{
                                    under = true;
                                    mirror = true;
                                    moves.add(new PartMove(PartProgress.warmup, 4f, 0f, 0f));
                                }}

                        );
                        bullet = new BasicBulletType() {{
                            shootEffect = Fx.none;
                            smokeEffect = AZFx.shootSmokeAuroraMissile;
                            lifetime = 0f;
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;

                            spawnUnit = new MissileUnitType("aurora-missile") {{
                                speed = 5f;
                                //maxRange = 6f;
                                lifetime = 60f * 1.35f;
                                rotateSpeed = 0.7f;
                                outlineColor = AZPal.aureliaOutline;
                                engineColor = AZPal.vogPink;
                                engineLayer = Layer.effect;
                                engineOffset = 9f;
                                trailLength = 12;
                                health = 500;
                                lowAltitude = true;
                                loopSound = Sounds.missileTrail;
                                loopSoundVolume = 0.6f;
                                deathSound = Sounds.largeExplosion;
                                hitEffect = Fx.none;
                                despawnEffect = Fx.none;
                                collidesAir = false;
                                targetAir = false;

                                weapons.add(new Weapon(){{
                                    shootCone = 360f;
                                    mirror = false;
                                    reload = 1f;
                                    deathExplosionEffect = AZFx.massiveExplosionAurora2;
                                    shootOnDeath = true;
                                    shake = 5f;
                                    bullet = new ExplosionBulletType(1450, 4f * tilesize){{
                                        hitColor = AZPal.forceBullet;
                                        hitEffect = Fx.none;
                                        despawnEffect = Fx.none;
                                        shootEffect = new MultiEffect(AZFx.massiveExplosionAurora, AZFx.scatheExplosionAurora, AZFx.scatheLightAurora);
                                        collidesAir = false;
                                    }};
                                }});
                            }};
                        }};
                    }}
            );
        }};
        //endregion angelsharkTree
        //region unmakerTree
        unmaker = new StriCopterUnitType("unmaker") {{
            flying = true;

            speed = 3f;
            rotateSpeed = 10f;
            accel = 0.1f;
            drag = 0.05f;
            strafePenalty = 0.4f;

            health = 360f;
            hitSize = 9f;
            itemCapacity = 5;

            engineSize = 0f;
            alwaysUnlocked = true;
            outlineColor = AZPal.aureliaOutline;

            for(int i = -1; i < 2; i+=2) {
                int diffPos = i;
                blade.add(
                new Blade(name + "-blade") {{
                            y = 1f * diffPos;
                            x = 1.3f;
                            bladeMoveSpeed = 40 * diffPos;
                            bladeBlurAlphaMultiplier = 0.5f;
                        }});
            }

            weapons.add(
                    new Weapon("az-unmaker-teeth") {{
                        x = 2f;
                        y = 8f;
                        reload = 20;
                        layerOffset = -0.002f;
                        inaccuracy = 0.4f;

                        recoil = 3.5f;
                        shoot = new ShootSpread(3, 5f);
                        bullet = new BasicBulletType(5.5f, 15) {{
                            lifetime = 25f;
                            sprite = "az-dagbul";
                            statusDuration = 100.0f;
                            status = AZStatusEffects.weakness;

                            width = 12f;
                            height = 15f;
                            shrinkX = 0;
                            shrinkY = 0;
                            trailChance = 0.7f;
                            trailEffect = AZFx.unmakerBulletTrail;
                            hitEffect = AZFx.smallGreenExplosion;
                            despawnEffect = hitEffect;
                            frontColor = Color.valueOf("ffffff");
                            backColor = AZPal.unmakerColor;
                        }};
                    }});
        }};

        eliminator = new StriCopterUnitType("eliminator") {{
            flying = true;

            speed = 2.5f;
            rotateSpeed = 7f;
            accel = 0.2f;
            drag = 0.05f;
            strafePenalty = 0.3f;

            health = 970f;
            hitSize = 12f;
            itemCapacity = 10;
            range = 15 * tilesize;

            engineSize = 0f;
            alwaysUnlocked = true;
            outlineColor = AZPal.aureliaOutline;
            weapons.add(
                    new Weapon("eliminator-gun") {{
                        reload = 15;
                        layerOffset = -0.002f;
                        recoil = 3.5f;
                        inaccuracy = 3.0f;

                        bullet = new BasicBulletType(4.f, 15) {{
                            lifetime = 35.0f;
                            drag = 0.0012f;
                            shootEffect = Fx.shootLiquid;

                            frontColor = Color.white;
                            backColor = AZPal.unmakerColor;

                            height *= 2.5f;
                            width = height / 2;

                            trailEffect = AZFx.cursedFireTrailSmall;
                            trailRotation = true;
                            trailInterval = 0.5f;

                            hitEffect = AZFx.cursedFireHit;
                            status = AZStatusEffects.decomposition;
                            statusDuration = 140f;

                            splashDamage = 20;
                            splashDamageRadius = 35.0f;

                            range = 125.0f;
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
            outlineColor = AZPal.aureliaOutline;
            blade.add(

                    new Blade(name + "-blade"){{
                        y = 0; x = 0f;
                        bladeMoveSpeed = -40f;
                        bladeBlurAlphaMultiplier = 0.9f;
                    }});
            weapons.add(new Weapon(""){{
                shootSound = Sounds.flame;
                shootY = 2f;
                mirror = false;
                x = 0;
                reload = 11f;
                recoil = 1f;
                ejectEffect = Fx.none;
                bullet = new BulletType(4.2f, 37f){{
                    ammoMultiplier = 3f;
                    hitSize = 7f;
                    lifetime = 13f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    statusDuration = 60f * 4;
                    shootEffect = AZFx.opjozdyhFlame;
                    hitEffect = AZFx.opjozdyshHit;
                    despawnEffect = Fx.none;
                    status = StatusEffects.burning;
                    keepVelocity = false;
                    hittable = false;
                }};
            }});
        }};
        //endregion unmakerTree

        //region vectorTree
        vector = new DroneUnitType("vector") {{
            targetFlags = new BlockFlag[] {BlockFlag.turret, BlockFlag.drill, null};

            hovering = true;
            useEngineElevation = false;
            flying = false;
            drag = 0.07f;
            speed = 1.4f;
            rotateSpeed = 16f;
            accel = 0.1f;
            itemCapacity = 20;
            health = 450f;
            hitSize = 7f;
            outlineColor = AZPal.aureliaOutline;

            researchCostMultiplier = 0f;
            shadowElevation = 0.1f;
            hover = true;
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
            weapons.add(new Weapon("az-vector-gun")
            {{
                reload = 27.5f; //10
                rotate = false;
                x = -4;
                y = -3;
                mirror = true;
                alternate = true;
                shootY = 1.7f;
                shootSound = Sounds.shootAlt;

                shoot = new AZBurstShoot(2, 5, 4.0f);
                inaccuracy = 5.65f;
                bullet = new BasicBulletType(6f, 10) {{
                    sprite = "az-grenade";
                    backColor = AZPal.droneBulletBack;
                    frontColor = AZPal.droneBullet;
                    width = 7f;
                    height = 10f;
                    shrinkX = 0;
                    shrinkY = 0;
                    hitSound = Sounds.explosion;
                    hitEffect = AZFx.blueHitExplosion1;
                    despawnEffect = AZFx.smallBlueExplosion;
                    lifetime = 25;
                    velocityRnd =  0.2f;
                }};
            }});
        }};
        zephyr = new DroneUnitType("zephyr") {{

            lowAltitude = true;
            flying = true;
            drag = 0.05f;
            speed = 1.5f;
            rotateSpeed = 8f;
            accel = 0.1f;
            itemCapacity = 30;
            health = 1090f;
            hitSize = 12f;

            outlineColor = AZPal.aureliaOutline;

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
            weapons.add(new Weapon("az-zephyr-gun") {{
                reload = 25f;
                shootY = 2f;
                rotate = false;
                x = -5;
                y = -4;
                mirror = true;
                alternate = true;
                shootSound = Sounds.shootAlt;

                inaccuracy = 5.5f;
                bullet = new ArtilleryBulletType(5.5f, 10) {{
                    velocityRnd = 0.25f;
                    sprite = "az-grenade";
                    backColor = AZPal.droneBulletBack;
                    frontColor = AZPal.droneBullet;
                    width = 9f;
                    height = 11f;
                    hitSound = Sounds.explosion;
                    hitEffect = AZFx.blueHitExplosionNormal;
                    despawnEffect = AZFx.blueExplosionNormal;
                    lifetime = 30;
                    shrinkX = 0;
                    shrinkY = 0;
                    splashDamage = 10f;
                    splashDamageRadius = 2f * Vars.tilesize;
                    fragBullets = 4;
                    fragBullet = new BasicBulletType(4f, 35) {{
                        sprite = "az-grenade";
                        backColor = AZPal.droneBulletBack;
                        frontColor = AZPal.droneBullet;
                        width = 5f;
                        height = 8f;
                        shrinkX = 0;
                        shrinkY = 0;
                        hitSound = Sounds.explosion;
                        hitEffect = AZFx.blueHitExplosion1;
                        despawnEffect = AZFx.smallBlueExplosion;
                        lifetime = 25; //10
                    }};
                }};
            }});
        }};

        vortex = new DroneUnitType("vortex") {{
            outlineColor = AZPal.aureliaOutline;
            flying = true;

            speed = 1.0f;
            rotateSpeed = 3.0f;
            drag = 0.03f;
            accel = 0.07f;
            hitSize = 20.0f;
            engineSize = 0;

            health = 4200.0f;
            armor = 9.0f;
            range = 22 * tilesize;
            crashDamageMultiplier = 50;

            targetPriority = 3.0f;
//            isEnemy = true;

            itemCapacity = 45;


            weapons.add(
                    new Weapon("az-vortex-emp") {{
                        rotate = true;
                        rotateSpeed /= 2.0f;
                        x = 13;
                        y = -7;

                        reload = 45.0f;
                        inaccuracy = 22.5f;
                        shake = 0.4f;

                        bullet = new ModEmpBulletType() {{
                            damage = 20.0f;
                        }};
                    }});
            }
/*            weapons.add(new Weapon("") {{
            }});*/
        };
        //endregion vectorTree

        //region sentinelTree
        sentinel = new TankUnitType("sentinel"){
            {
                hitSize = 12f;
                treadPullOffset = 3;
                speed = 0.75f;
                rotateSpeed = 3.5f;
                health = 850;
                armor = 6f;
                itemCapacity = 0;
                treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
                researchCostMultiplier = 0f;
                constructor = TankUnit::create;
                abilities.add(new ModShieldArcAbility(){{
                    radius = hitSize + 32f;
                    angle = 100;
                    regen = 3f;
                    cooldown = 60f * 10f;
                    max = 700;
                    width = 10f;
                    drawWidth = 5f;
                    whenShooting = true;
                }});
                weapons.add(new Weapon("az-flare-shield") {{
                    reload = Integer.MAX_VALUE;
                    shootSound = Sounds.none;
                    recoil = 0f;
                    rotateSpeed = 2f;
                    rotate = true;
                    x = y = 0;
                    mirror = false;

                    bullet = new BasicBulletType() {{
                        display = false;
                        lifetime = 150f;
                        speed = 1f;
                        damage = 0f;
                        sprite = "none.png";
                        shootEffect = hitEffect = despawnEffect = Fx.none;
                    }};
                }});
            }};
        //endregion sentinelTree

        //region source
        //endregion source

        //region UNUSED
        //endregion UNUSED

        //region treeOff
        //endregion treeOff
    }
}
