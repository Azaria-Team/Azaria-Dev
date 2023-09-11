package hpl.content;

import arc.func.Prov;
import arc.graphics.Color;
import hpl.entities.bullets.AimBulletType;
import hpl.entities.entity.DroneUnitEntity;
import hpl.entities.entity.StriCopterUnitEntity;
import hpl.entities.units.DroneUnitType;
import hpl.entities.units.StriCopterUnitType;
import hpl.graphics.HPLPal;
import hpl.world.draw.Blade;
import hpl.world.draw.Rotor;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;
import arc.struct.*;
import arc.struct.ObjectMap.Entry;

public class HPLUnits {
    public static UnitType
    //aurelia core units
    gyurza, veresk, vortex,
    //angelshark unit tree
    angelshark, glaucus, aurora,
    //unmaker tree
    unmaker, eliminator,
    //vector tree
    vector, zephyr;
    //off the tree
    //supportDrone, torpedoNaval, bigKaboom
    // Steal from Progressed Material which stole from Unlimited-Armament-Works which stole from  Endless Rusting which stole from Progressed Materials in the past which stole from BetaMindy
    private static final Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new Entry[]{
            prov(DroneUnitEntity.class, DroneUnitEntity::new),
            prov(StriCopterUnitEntity.class, StriCopterUnitEntity::new)
    };

    private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

    /**
     * Internal function to flatmap {@code Class -> Prov} into an {@link Entry}.
     * @author GlennFolker
     */
    private static <T extends Entityc> Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov) {
        Entry<Class<T>, Prov<T>> entry = new Entry<>();
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

            lowAltitude = true;
            flying = true;

            speed = 3.3f;
            rotateSpeed = 17f;
            accel = 0.1f;
            drag = 0.05f;

            mineSpeed = 8f;
            mineTier = 2;
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
                                hitSize = 4;

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


        unmaker = new StriCopterUnitType("unmaker") {{
            flying = true;

            speed = 4f;
            rotateSpeed = 10f;
            accel = 0.1f;
            drag = 0.05f;

            health = 460f;
            hitSize = 9f;
            itemCapacity = 5;

            engineSize = 0f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;
            blade.add(
                    new Blade(name + "-blade"){{
                        /*x = 5, y = 3;*/ y = 1f; x = -1.3f;
                        bladeMoveSpeed = 10f;
                        bladeCount = 1;
                        bladeBlurAlphaMultiplier = 0.7f;
                    }},
                    new Blade(name + "-blade1"){{
                        /* x = -5, y - 3*/ y = 1f; x = 1.3f;
                        bladeMoveSpeed = -10f;
                        bladeCount = 1;
                        bladeBlurAlphaMultiplier = 0.7f;
                    }});
            weapons.add(
                    new Weapon("hpl-unmaker-teeth") {{
                        x = 1f;
                        y = 4.4f;
                        reload = 20;
                        layerOffset = -0.002f;
                        recoil = 3.5f;
                        shoot = new ShootSpread(3, 5f);
                        bullet = new BasicBulletType(5.5f, 15) {{
                            lifetime = 25f;
                            sprite = "hpl-dagbul";
                            status = HPLStatusEffects.weakness;
                            width = 13f;
                            height = 15f;
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

            health = 1100f;
            hitSize = 12f;
            itemCapacity = 10;

            engineSize = 3f;
            engineOffset = 9.5f;
            alwaysUnlocked = true;
            outlineColor = HPLPal.aureliaOutline;
            weapons.add(
                    new Weapon("eliminator-emp") {{
                        reload = 45;
                        layerOffset = -0.002f;
                        recoil = 3.5f;
                        bullet = new EmpBulletType() {{
                            lifetime = 30f;
                            speed = 4f;
                            damage = 30f;
                            pierce = true;

                            status = HPLStatusEffects.weakness;

                            width = 17f;
                            height = 12f;

                            frontColor = HPLPal.unmakerColor;
                            backColor = Color.valueOf("ffffff");
                            sprite = "hpl-emp-wave";
                        }};
                    }});
        }};
        //endregion unmakerTree
        //region vectorTree
        vector = new DroneUnitType("vector") {{
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
            weapons.add(new Weapon("") {{
                reload = 10f;
                shootY = 2f;
                rotate = true;
                x = -4;
                y = -3;
                mirror = true;
                alternate = true;
                shootSound = Sounds.shootAlt;
                bullet = new BasicBulletType(6f, 10) {{
                    backColor = HPLPal.droneBulletBack;
                    frontColor = HPLPal.droneBullet;
                    width = 9f;
                    height = 12f;
                    hitSound = Sounds.explosion;
                    hitEffect = HPLFx.explosionSmall1;
                    despawnEffect = HPLFx.explosionSmall3;
                    lifetime = 30;
                }};
            }});
        }};
        zephyr = new DroneUnitType("zephyr") {{
           isEnemy = true;

           lowAltitude = true;
           flying = true;
           drag = 0.05f;
           speed = 2.2f;
           rotateSpeed = 8f;
           accel = 0.3f;
           itemCapacity = 30;
           health = 1100f;
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
        }};
        //endregion vectorTree
    }
}
