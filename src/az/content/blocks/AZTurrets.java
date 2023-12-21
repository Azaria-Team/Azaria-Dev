package az.content.blocks;

import arc.math.geom.Vec2;
import az.content.AZBullets;
import az.content.AZFx;
import az.content.AZItems;
import az.content.AZLiquids;
import az.entities.ShootMultiBarrel;
import az.graphics.AZPal;
import az.world.blocks.defense.turret.AirDefenceTurret;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.with;

public class AZTurrets {
    
    public static Block
            forceTurret, hornTurret, razeTurret,
            complexShell, complexRage, complexAvalon;

    public static void load() {
        forceTurret = new ItemTurret("force"){{
            requirements(Category.turret, with(AZItems.fors, 70, AZItems.khylid, 25));
            researchCost = with(AZItems.fors, 150, AZItems.khylid, 70);
            health = 700;
            shootEffect = AZFx.shootForce;
            smokeEffect = AZFx.shootSmokeForce;
            reload = 70f;
            inaccuracy = 2f;
            shake = 2f;
            shootY = -2;
            outlineColor = AZPal.aureliaOutline;
            size = 2;
            recoil = 2f;
            range = 24 * Vars.tilesize;
            shootCone = 10f;
            rotateSpeed = 4f;

            shootSound = Sounds.cannon;
            squareSprite = false;
            itemCapacity = 20;
            coolantMultiplier = 2f;
            coolant = consume(new ConsumeLiquid(AZLiquids.oxyliteLiq, 10f / 60f));

            ammo(
                    AZItems.fors, AZBullets.forceBullet,
                    AZItems.ferbium, AZBullets.forceFerbiumBullet
            );


            drawer = new DrawTurret("fortified-"){{
                parts.add(
                        new RegionPart("-edge-r"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveRot = -8f;
                        }},
                        new RegionPart("-edge-l"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveRot = 8f;
                        }},
                        new RegionPart("-barrel"){{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveX = 0f;
                            moveY = -1f;
                            moveRot = 0f;
                            x = 0;
                            y = 0;
                        }});
            }};
        }};

        hornTurret = new PowerTurret("horn"){{
            requirements(Category.turret, with(AZItems.fors, 70, AZItems.craside, 25));
            researchCost = with(AZItems.fors, 150, AZItems.khylid, 70);
            health = 900;
            //shootEffect = HPLFx.shootForce;
            //smokeEffect = HPLFx.shootSmokeForce;
            shootEffect = Fx.none;
            smokeEffect = Fx.none;
            reload = 100f;
            inaccuracy = 0f;
            shake = 4f;
            shootY = -2;
            outlineColor = AZPal.aureliaOutline;
            size = 2;
            recoil = 4f;
            range = 16 * Vars.tilesize;
            shootCone = 35f;
            rotateSpeed = 3.4f;

            shootSound = Sounds.cannon;
            squareSprite = false;

            shoot = new ShootSpread(7, 6);

            shootType = AZBullets.hornBullet;
            consumePower(1.5f);
            coolantMultiplier = 2f;
            coolant = consume(new ConsumeLiquid(AZLiquids.oxyliteLiq, 12f / 60f));

            drawer = new DrawTurret("fortified-"){{
                parts.add(
                        new RegionPart("-blade-r"){{
                            progress = PartProgress.warmup;

                            mirror = false;
                            under = false;
                            moveY = -2;
                            moves.add(new PartMove(PartProgress.reload, 0f, 6f, 0f));
                        }},

                        new RegionPart("-blade-l"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveY = -2;
                            moves.add(new PartMove(PartProgress.reload, 0f, 6f, 0f));
                        }},

                        new RegionPart("-piston"){{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveX = 0f;
                            moveY = -3f;
                            moveRot = 0f;
                            x = 0;
                            y = 0;
                        }});
            }};
        }};

        razeTurret = new ItemTurret("raze"){{
            requirements(Category.turret, with(AZItems.fors, 140, AZItems.craside, 80, AZItems.superdenseAlloy, 70));
            ammo(
                    AZItems.superdenseAlloy, AZBullets.forceBullet
            );
            shoot.shots = 2;
            shoot= new ShootMultiBarrel(){{
                shots=2;
                shotDelay = 18f;//burstSpacing = 18f;
                blockSize = 3;
                barrelPoints(
                        new Vec2(30f / 96f, 4f / 96f),
                        new Vec2(66f / 96f, 4f / 96f)
                );
                ejectPoints(
                        new Vec2(33f / 96f, 40f / 96f),
                        new Vec2(63f / 96f, 40f / 96f)
                );
            }};
            health = 1960;
            size = 3;
            reload = 80f;
            range = 237f;
            recoil = 3f;
            inaccuracy = 4f;
            rotateSpeed = 4f;
            shootCone = 2f;
            ammoPerShot = 2;
            shootSound = Sounds.shootBig;
            ammoUseEffect = Fx.casing2;
            targetAir = false;
        }};


        //region h-tur
        complexShell = new AirDefenceTurret("complex-shell") {{
            size = 3;
            requirements(Category.turret, with(AZItems.superdenseAlloy, 300));
            health = 700;
            shootEffect = AZFx.shootForce;
            smokeEffect = AZFx.shootSmokeForce;
            reload = 70f;
            inaccuracy = 2f;
            shake = 2f;
            shootY = -2;
            outlineColor = AZPal.aureliaOutline;
            recoil = 2f;
            range = 24 * Vars.tilesize;
            shootCone = 10f;
            rotateSpeed = 3f;

            shootSound = Sounds.cannon; 
            squareSprite = false;
            itemCapacity = 20;
            coolantMultiplier = 2f;
            consumePower(1f);
            ammo(AZItems.superdenseAlloy, AZBullets.antiMissileBullet);
        }};


        complexRage = new PowerTurret("complex-rage") {{
            size = 3;
            requirements(Category.turret, with(AZItems.superdenseAlloy, 300));
        }};

        complexAvalon = new PowerTurret("complex-avalon") {{
            size = 3;
            requirements(Category.turret, with(AZItems.superdenseAlloy, 300));
        }};

        //endregion h-tur
    }
}
