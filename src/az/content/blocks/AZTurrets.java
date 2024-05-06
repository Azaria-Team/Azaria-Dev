package az.content.blocks;

import az.content.AZBullets;
import az.content.AZFx;
import az.content.AZItems;
import az.content.AZLiquids;
import az.graphics.AZPal;
import az.world.blocks.defense.turret.AirDefenceTurret;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootBarrel;
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
            complexShell, complexAvalon;

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

            shootSound = Sounds.shockBlast;
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
                            moves.add(new PartMove(PartProgress.recoil, 0f, 6f, 0f));
                        }},

                        new RegionPart("-blade-l"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveY = -2;
                            moves.add(new PartMove(PartProgress.recoil, 0f, 6f, 0f));
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
                    AZItems.superdenseAlloy, AZBullets.razeBullet
            );

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                        -5, -1f, 0,
                        -9, -4f, 0,
                        5, -1f, 0,
                        9, -4f, 0
                };
                shots = 1;
                shotDelay = 1f;
            }};

            health = 1560;
            size = 3;
            reload = 13f;
            range = 37f * Vars.tilesize;
            recoil = 2;
            inaccuracy = 2f;
            rotateSpeed = 3f;
            shootCone = 2f;
            //ammoPerShot = 1;
            shootSound = Sounds.shootBig;
            ammoUseEffect = Fx.casing2;
            targetAir = true;
            targetGround = false;

            drawer = new DrawTurret(){{
                for(int i = 0; i < 2; i++){
                    int f = i;
                    parts.add(new RegionPart("-barrel1-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -1.5f;
                    }});
                }
                for(int j = 0; j < 2; j++){
                    int f = j;
                    parts.add(new RegionPart("-barrel2-" + (j == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -1.5f;
                    }});
                }
            }};
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

        complexAvalon = new PowerTurret("complex-avalon") {{
            size = 3;
            requirements(Category.turret, with(AZItems.superdenseAlloy, 300));
        }};

        //endregion h-tur
    }
}
