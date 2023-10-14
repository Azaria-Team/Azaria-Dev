package hpl.content;

import arc.graphics.Color;
import arc.util.Time;
import hpl.HPL;
import hpl.graphics.HPLPal;
import hpl.world.blocks.defense.NavalMine;
import hpl.world.blocks.defense.turret.BlockRepairTurret;
import hpl.world.blocks.defense.wall.IndestructibleWall;
import hpl.world.blocks.distribution.ModDuct;
import hpl.world.blocks.environment.ModOverlayFloor;
import hpl.world.blocks.environment.UndergroundOre;
import hpl.world.blocks.power.LightningPowerNode;
import hpl.world.blocks.power.OreRadar;
import hpl.world.blocks.power.ThermalEvaporator;
import hpl.world.blocks.production.HPLBurstDrill;
import hpl.world.draw.DrawCrasideSmelt;
import hpl.world.draw.DrawDrillPart;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.ArmoredConduit;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Pump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class HPLBlocks {
    public static Block
    //environment
    //forest biome
    forsite, forsiteWall, fir, firWall, forenite, foreniteWall, theFlower,
    kust, bigKust, swampShine, swampShineBoulder,
    //sea biome
    serridDust, serridDustWall, crabStone, crabStoneWall, serridicRock, serridicRockWall,
    //crystal biome
    crystalIce, crystalIceWall, lamprosMineral, lamprosMineralWall, lamprosCrystals,
    //other
    darkSerrid, darkSerridWall, huitaRock, huitaRockWall,
    //liquids
    oxylite, deepOxylite, serridOxylite, darkSerridOxylite,

    //prop
    ancientSus, crabStoneBoulder, serridBoulder, serridicBoulder, huitaBoulder,
    foreniteBoulder, firBoulder, darkSerridBoulder, forsiteBoulder, forsBoulder,
    lamprosBoulder, crystalIceBoulder,
    //ores
    forsOre, ferbiumOre, forsRock, khylidOre,

    //power
    plasmaNode, plasmaNodeLarge,
    plasmaDistributor, plasmaDistributorLarge, thermalEvaporator, oxyliteTurbine,

    //drills
    waveDrill, forsDrill, pumpDrill, oreDetector,

    //distribution
    impulseConveyor, impulseJunction, impulseRouter, impulseSorter, impulseGate, impulseBridge,

    //liquid
    impulsePump, liquidPipe, liquidPipeJunction, pipeBridgeConduit, liquidPipeRouter, liquidCanister,

    //production
    crasideBrewer,

    //defense
    repairTurret,
    forsWall, forsWallLarge, compositeWall, compositeWallLarge,
    forceTurret, hornTurret,

    //complex
    complexSurprise, complexChameleon,

    //storage
    coreLegion, caseI,

    //units
    angelsharkFabricator, vectorFabricator, sourceFabricator, unmakerFabricator, aquaFabricator,
    //sanbox
    indestructibleWall, indestructibleWallLarge, testBlock;

    public static void load() {
        //region environment

        //region forest biome
        forsite = new Floor("forsite-plates") {{
            variants = 4;
        }};
        forsiteWall = new StaticWall("forsite-wall") {{
            variants = 3;
            forsite.asFloor().wall = this;
        }};
        forsiteBoulder = new Prop("forsite-boulder") {{
            variants = 2;
            forsite.asFloor().decoration = this;
        }};
        forsBoulder = new Prop("fors-boulder") {{
            variants = 2;
            //probably there were no parent floor & you will place this block with your kutty paws uwu
        }};
        forenite = new Floor("forenite") {{
            variants = 4;
        }};
        foreniteWall = new StaticWall("forenite-wall") {{
            variants = 3;
            forenite.asFloor().wall = this;
        }};
        foreniteBoulder = new Prop("forenite-boulder") {{
            variants = 3;
            forenite.asFloor().decoration = this;
        }};
        fir = new Floor("fir") {{
            variants = 4;
        }};
        firWall = new StaticWall("fir-wall") {{
            variants = 3;
            fir.asFloor().wall = this;
            mapColor = Color.valueOf("3f4f45");
        }};
        firBoulder = new Prop("fir-boulder") {{
            variants = 3;
            fir.asFloor().decoration = this;
        }};
        kust = new TreeBlock("kust") {{
            variants = 2;
        }};
        bigKust = new TallBlock("big-kust") {{
            variants = 3;
        }};
        swampShine = new TallBlock("swamp-shine") {{
            variants = 3;
            emitLight = true;
            lightColor = HPLPal.forestLight;
            lightRadius = 7 * Vars.tilesize;
        }};
        swampShineBoulder = new Prop("swamp-shine-boulder") {{
            variants = 3;
            emitLight = true;
            lightColor = HPLPal.forestLight;
            lightRadius = 3 * Vars.tilesize;
        }};
        //endregion forest biome

        //region sea biome
        serridDust = new Floor("serrid-dust") {{
            variants = 4;
        }};
        serridDustWall = new StaticWall("serrid-dust-wall") {{
            variants = 3;
            serridDust.asFloor().wall = this;
        }};
        serridBoulder = new Prop("serrid-boulder") {{
            variants = 3;
            serridDust.asFloor().decoration = this;
        }};
        crabStone = new Floor("crab-stone") {{
            variants = 4;
        }};
        crabStoneWall = new StaticWall("crab-stone-wall") {{
            variants = 3;
            crabStone.asFloor().wall = this;
        }};
        crabStoneBoulder = new Prop("crab-stone-boulder") {{
            variants = 3;
            crabStone.asFloor().decoration = this;
        }};
        serridicRock = new Floor("serridic-rock") {{
            variants = 4;
        }};
        serridicRockWall = new StaticWall("serridic-stone-wall") {{
            variants = 3;
            serridicRock.asFloor().wall = this;
        }};
        serridicBoulder = new Prop("serridic-boulder") {{
            variants = 3;
            serridicRock.asFloor().decoration = this;
        }};
        oxylite = new Floor("oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
            attributes.set(HPLAttribute.mainlheatattr, 0.25f);
            mapColor = Color.valueOf("50a9a8");
        }};
        deepOxylite = new Floor("deep-oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
            drownTime = 140f;
        }};
        serridOxylite = new Floor("serrid-oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
        }};
        darkSerridOxylite = new Floor("dark-serrid-oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
        }};
        //endregion sea biome

        //region crystal biome
        crystalIce = new Floor("crystal-ice") {{
            variants = 4;
        }};
        crystalIceWall = new StaticWall("crystal-ice-wall") {{
            variants = 2;
            crystalIce.asFloor().wall = this;
        }};
        crystalIceBoulder = new Prop("crystal-ice-boulder") {{
            variants = 3;
            crystalIce.asFloor().decoration = this;
        }};
        lamprosMineral = new Floor("lampros-mineral") {{
            variants = 4;
        }};
        lamprosCrystals = new Floor("lampros-crystals") {{
            variants = 4;
        }};
        lamprosMineralWall = new StaticWall("lampros-mineral-wall") {{
            variants = 3;
            lamprosMineral.asFloor().wall = this;
        }};
        lamprosBoulder = new Prop("lampros-boulder") {{
            variants = 3;
            lamprosMineral.asFloor().decoration = this;
        }};
        //endregion crystal biome

        //region other
        darkSerrid = new Floor("dark-serrid") {{
            variants = 4;
        }} ;
        darkSerridWall = new StaticWall("dark-serrid-wall") {{
            variants = 3;
            darkSerrid.asFloor().wall = this;
        }};
        darkSerridBoulder = new Prop("dark-serrid-boulder") {{
            variants = 3;
            darkSerrid.asFloor().decoration = this;
        }};
        huitaRock = new Floor("huita-rock") {{
            itemDrop = HPLItems.volcanicSerrid;
            variants = 4;
        }};
        huitaRockWall = new StaticWall("huita-rock-wall") {{
            variants = 3;
            huitaRock.asFloor().wall = this;
        }};
        huitaBoulder = new Prop("huita-boulder") {{
            variants = 2;
            huitaRock.asFloor().decoration = this;
        }};
        //endregion other
        //region prop
        ancientSus = new Prop("ancient-sus") {{
            breakable = false;
            size = 1;
            solid = true;

        }};
        //endregion prop

        //ores
        forsOre = new OreBlock(HPLItems.fors){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        ferbiumOre = new UndergroundOre(HPLItems.ferbium){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        forsRock = new ModOverlayFloor("fors-rock") {{
            parent = blendGroup = forsite;
            variants = 2;
            attributes.set(HPLAttribute.forsattr, 1f);
        }};
        khylidOre = new ModOverlayFloor(("khylid-ore")) {{
            parent = blendGroup = oxylite;
            variants = 2;
            cacheLayer = CacheLayer.water;
            attributes.set(HPLAttribute.khylidattr, 1f);
        }};
        //endregion environment
        //region power
        plasmaNode = new LightningPowerNode("plasma-node", 0) {{
            requirements(Category.power, with(HPLItems.fors, 3  ));
            researchCost = with(HPLItems.fors, 25);

            consumePowerBuffered(1000f);
            lightningRange = 17 * 8f;
            thresholdPerTile = 0.1f / 8f;
        }};

        plasmaNodeLarge = new LightningPowerNode("plasma-node-large", 0) {{
            //todo crafting
            requirements(Category.power, with(HPLItems.khylid, 20));
            consumePowerBuffered(5000f);
            size = 2;
            lightningRange = 28 * 8f;
            thresholdPerTile = 0.1f / 8f;
        }};

        plasmaDistributor = new LightningPowerNode("plasma-distributor", 12) {{
            requirements(Category.power, with(HPLItems.fors, 10));
            researchCost = with(HPLItems.fors, 40);
            size = 2;
            consumePowerBuffered(300f);
            lightningRange = 5 * 8f;
            laserRange = 7;
            thresholdPerTile = 0.1f / 8f;
        }};

        plasmaDistributorLarge = new LightningPowerNode("plasma-distributor-large", 24) {{
            //todo crafting
            requirements(Category.power, with(HPLItems.khylid, 20));
            consumePowerBuffered(5000f);
            size = 3;
            lightningRange = 15 * 8f;
            laserRange = 16;
            thresholdPerTile = 0.1f / 8f;
        }};

        thermalEvaporator = new ThermalEvaporator("thermal-evaporator") {{
            requirements(Category.power, with(HPLItems.fors, 40));
            researchCost = with(HPLItems.fors, 65);

            powerProduction = 0.5f / 3;
            displayEfficiency = true;
            size = 2;
            floating = true;
            placeableLiquid = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            attribute = HPLAttribute.mainlheatattr;
            generateEffect = HPLFx.smokeEvaporatorBig;
            effectChance = 0.2f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = HPLPal.lightningNodeColor;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
        }};

        oxyliteTurbine = new ConsumeGenerator("oxylite-turbine"){{
            requirements(Category.power, with(HPLItems.fors, 100, HPLItems.khylid, 90, HPLItems.craside, 50));
            powerProduction = 4f;
            itemDuration = 100f;
            consumeLiquid(HPLLiquids.oxyliteLiq, 5f / 60f);
            hasLiquids = true;
            size = 3;
            squareSprite = false;
            generateEffect = HPLFx.smokeEvaporatorSmall;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;

            consumeItems(with(HPLItems.khylid, 2f));

            drawer = new DrawMulti(

                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(HPLLiquids.oxyliteLiq){{
                        padLeft = 2; padRight = 2; padTop = 2; padBottom = 2;
                    }},
                    new DrawDefault(),
                    new DrawBlurSpin("-rotor", 10f)
            );
        }};
        //endregion power
        //region production
        //TODO
        crasideBrewer = new GenericCrafter("craside-brewer") {{
            requirements(Category.crafting, with(HPLItems.fors, 60, HPLItems.khylid, 40));
            outputItem = new ItemStack(HPLItems.craside, 1);
            consumeItems(with(HPLItems.fors, 1, HPLItems.volcanicSerrid, 1));
            craftTime = 65f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 3;
            craftEffect = HPLFx.crasideBrewerSmoke;
            consumePower(1f);
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"){{
                        layer = Layer.block;
                    }},
                    new DrawRegion(){{
                        layer = Layer.block + 0.1f;
                    }},
                    new DrawRegion("-top"){{
                        layer = Layer.block + 0.2f;
                    }}
            );
        }};
        //endregion production
        //region drills
        //Soon
        forsDrill = new AttributeCrafter("fors-block") {{
            requirements(Category.production, with(HPLItems.fors, 20));
            researchCost = with(HPLItems.fors, 5);
            attribute = HPLAttribute.forsattr;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HPLItems.fors, 4);
            craftTime = 240f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            displayEfficiency = false;
            size = 2;
            craftEffect = HPLFx.forsDrillEffect;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = HPLPal.fors;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
        }};
        pumpDrill = new AttributeCrafter("pump-drill") {{
            requirements(Category.production, with(HPLItems.fors, 40));
            researchCost = with(HPLItems.fors, 7);
            attribute = HPLAttribute.khylidattr;
            group = BlockGroup.liquids;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HPLItems.khylid, 4);
            craftTime = 160;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            consumePower(0.5f);
            displayEfficiency = false;
            size = 2;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.8f;
                        color = HPLPal.khylid;
                        glowIntensity = 0.1f;
                        glowScale = 9f;
                    }}
            );
            squareSprite = false;
        }};
        waveDrill = new HPLBurstDrill("wave-drill"){{
            requirements(Category.production, with(HPLItems.fors, 20));
            drillTime = 60f * 12f;
            size = 3;
            hasPower = true;
            tier = 2;
            //drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            shake = 3f;
            itemCapacity = 20;
            researchCost = with(HPLItems.fors, 5);

            fogRadius = 4;

            consumePower(2f / 60f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawDrillPart(11f / 4f){{
                        shadowOffset = 1f;
                        baseOffset = 4f / 4f;
                        layer = Layer.blockOver;
                        angleOffset = 135;
                        drawPlan = false;

                    }},
                    new DrawRegion("-top"){{
                        layer = Layer.blockOver + 0.1f;
                    }}
            );
        }};

        oreDetector = new OreRadar("ore-detector") {{
            requirements(Category.production, with(HPLItems.fors, 1));
            size = 3;
            consumePower(1.2f);
        }};
        //endregion drills
        //region distribution
        impulseConveyor = new ModDuct("impulse-conveyor") {{
            requirements(Category.distribution, with(HPLItems.fors, 1));
            health = 130;
            speed = 5f;
            researchCost = with(HPLItems.fors, 5);
            junctionReplacement = HPLBlocks.impulseJunction;
            bridgeReplacement = HPLBlocks.impulseBridge;
        }};
        impulseJunction = new Junction("impulse-junction") {{
            requirements(Category.distribution, with(HPLItems.fors, 2));
            researchCost = with(HPLItems.fors, 10);
            speed = 6;
            capacity = 1;
            health = 140;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};
        impulseRouter = new Router("impulse-router") {{
            requirements(Category.distribution, with(HPLItems.fors, 3));
            researchCost = with(HPLItems.fors, 15);
            speed = 16;
            buildCostMultiplier = 4f;
            squareSprite = false;
        }};
        impulseSorter = new Sorter("impulse-sorter"){{
            requirements(Category.distribution, with(HPLItems.fors, 4));
            buildCostMultiplier = 3f;
        }};
        impulseGate = new OverflowGate("impulse-gate"){{
            requirements(Category.distribution, with(HPLItems.fors, 6));
            buildCostMultiplier = 3f;
        }};
        impulseBridge = new DuctBridge("impulse-bridge"){{
            requirements(Category.distribution, with(HPLItems.fors, 10));
            researchCost = with(HPLItems.fors, 20);
            health = 90;
            speed = 4f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
            squareSprite = false;
        }};
        //endregion distribution
        //region liquid
        impulsePump = new Pump("impulse-pump"){{
            requirements(Category.liquid, with(HPLItems.fors, 90, HPLItems.craside, 70, HPLItems.ferbium, 30));

            squareSprite = false;
            pumpAmount = 10f / 60f;
            liquidCapacity = 140f;
            size = 2;
        }};

        liquidPipe = new ArmoredConduit("liquid-pipe"){{
            requirements(Category.liquid, with(HPLItems.fors, 1, HPLItems.ferbium, 1));
            botColor = HPLPal.aureliaOutline;
            leaks = true;
            liquidCapacity = 25f;
            liquidPressure = 1.1f;
            health = 300;
            researchCostMultiplier = 3;
            underBullets = true;
        }};
        liquidPipeJunction = new LiquidJunction("liquid-pipe-junction"){{
            requirements(Category.liquid, with(HPLItems.fors, 5, HPLItems.ferbium, 10));
            buildCostMultiplier = 3f;
            health = 320;
            ((Conduit)liquidPipe).junctionReplacement = this;
            researchCostMultiplier = 1;
            solid = false;
            underBullets = true;
        }};

        pipeBridgeConduit = new DirectionLiquidBridge("pipe-bridge-conduit"){{
            requirements(Category.liquid, with(HPLItems.fors, 10, HPLItems.ferbium, 13));
            range = 5;
            hasPower = false;
            researchCostMultiplier = 1;
            underBullets = true;

            ((Conduit)liquidPipe).rotBridgeReplacement = this;
        }};

        liquidPipeRouter = new LiquidRouter("liquid-pipe-router"){{
            requirements(Category.liquid, with(HPLItems.fors, 10, HPLItems.ferbium, 5));
            liquidCapacity = 35f;
            liquidPadding = 4f/4f;
            researchCostMultiplier = 3;
            underBullets = true;
            solid = false;
        }};

        liquidCanister = new LiquidRouter("liquid-canister") {{
            requirements(Category.liquid, with(HPLItems.ferbium, 10));
            liquidCapacity = 3545f;
            size = 2;
            liquidPadding = 4f/4f;
            researchCostMultiplier = 2;
            underBullets = true;
        }};
        //endregion liquid
        //region production

        //endregion production
        //region defense

        forsWall = new Wall("fors-wall") {{
            requirements(Category.defense, with(HPLItems.fors, 6));
            researchCost = with(HPLItems.fors, 100);
            health = 160 * 4;
            armor = 3f;
            buildCostMultiplier = 8f;
        }};

        forsWallLarge = new Wall("fors-wall-large") {{
            requirements (Category.defense, with(HPLItems.fors, 24));
            researchCost = with(HPLItems.fors, 450);
            health = 160 * 16;
            size = 2;
            armor = 3f;
            buildCostMultiplier = 8f;
        }};

        compositeWall = new Wall("composite-wall") {{
            requirements (Category.defense, with(HPLItems.craside, 4, HPLItems.khylid, 2));
            health = 800;
            buildCostMultiplier = 2f;
        }};

        compositeWallLarge = new Wall("composite-wall-large"){{
            requirements (Category.defense, with(HPLItems.craside, 20, HPLItems.khylid, 4));
            size = 2;
            buildCostMultiplier = 2f;

        }};

        forceTurret = new ItemTurret("force"){{
            requirements(Category.turret, with(HPLItems.fors, 70, HPLItems.khylid, 25));
            researchCost = with(HPLItems.fors, 150, HPLItems.khylid, 70);
            health = 700;
            shootEffect = HPLFx.shootForce;
            smokeEffect = HPLFx.shootSmokeForce;
            reload = 70f;
            inaccuracy = 2f;
            shake = 2f;
            shootY = -2;
            outlineColor = HPLPal.aureliaOutline;
            size = 2;
            recoil = 2f;
            range = 24 * Vars.tilesize;
            shootCone = 10f;
            rotateSpeed = 4f;

            shootSound = Sounds.cannon;
            squareSprite = false;
            itemCapacity = 20;

            ammo(HPLItems.fors, HPLBullets.forceBullet);

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
            requirements(Category.turret, with(HPLItems.fors, 70, HPLItems.khylid, 25));
            researchCost = with(HPLItems.fors, 150, HPLItems.khylid, 70);
            health = 900;
            //shootEffect = HPLFx.shootForce;
            //smokeEffect = HPLFx.shootSmokeForce;
            shootEffect = Fx.none;
            smokeEffect = Fx.none;
            reload = 100f;
            inaccuracy = 0f;
            shake = 4f;
            shootY = -2;
            outlineColor = HPLPal.aureliaOutline;
            size = 2;
            recoil = 4f;
            range = 16 * Vars.tilesize;
            shootCone = 35f;
            rotateSpeed = 3.4f;

            shootSound = Sounds.cannon;
            squareSprite = false;

            shoot = new ShootSpread(7, 6);

            shootType = HPLBullets.hornBullet;
            consumePower(1.5f);

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

        repairTurret = new BlockRepairTurret("repair-turret"){{
            requirements(Category.units, with(HPLItems.fors, 120, HPLItems.khylid, 80, HPLItems.craside, 30));
            repairSpeed = 0.45f;
            repairRadius = 180f;
            outlineColor = HPLPal.aureliaOutline;
            beamWidth = 1f;
            powerUse = 1f;
            size= 2;
        }};
        //endregion defense
        //region traps
        complexSurprise = new NavalMine("complex-surprise") {{
            size = 2;
            floating = true;
            outlineColor = HPLPal.aureliaOutline;
            requirements(Category.effect, with(HPLItems.ognium, 50));
            hasShadow = false;
            health = 150;
            damage = 150;
            tileDamage = 50;
        }};
        //endregion traps
        //region storage
        coreLegion = new CoreBlock("core-legion") {{
            requirements(Category.effect, with(HPLItems.fors, 1200, HPLItems.khylid, 800));

            isFirstTier = true;
            unitType = HPLUnits.gyurza;
            health = 2500;
            itemCapacity = 2500;
            size = 3;
            armor = 2f;
            alwaysUnlocked = true;
            squareSprite = false;

            unitCapModifier = 12;
        }};

        caseI = new StorageBlock("case") {{
            requirements(Category.effect, with(HPLItems.fors, 100));
            size = 2;
            itemCapacity = 100;
            scaledHealth = 80;
            squareSprite = false;
        }};
        //endregion storage

        //region units
        angelsharkFabricator = new UnitFactory("angelshark-fabricator"){{
            requirements(Category.units, with(HPLItems.fors, 200, HPLItems.khylid, 140, HPLItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(HPLUnits.angelshark, 15f * Time.toSeconds, with(HPLItems.fors, 40, HPLItems.khylid, 30, HPLItems.craside, 10)));
            researchCost = with(HPLItems.fors, 180, HPLItems.khylid, 100, HPLItems.craside, 40);
            regionSuffix = "-hpl";
            fogRadius = 3;
            consumePower(2f);
        }};

        vectorFabricator = new UnitFactory("vector-fabricator"){{
            requirements(Category.units, with(HPLItems.fors, 200, HPLItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(HPLUnits.vector, 10f * Time.toSeconds, with(HPLItems.fors, 50, HPLItems.craside, 30)));
            researchCost = with(HPLItems.fors, 220, HPLItems.craside, 80);
            regionSuffix = "-hpl";
            fogRadius = 3;
            consumePower(2f);
        }};
        unmakerFabricator = new UnitFactory("unmaker-fabricator") {{
            requirements(Category.units, with(HPLItems.fors, 200, HPLItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(HPLUnits.unmaker, 10f * Time.toSeconds, with(HPLItems.fors, 50, HPLItems.craside, 30)));
            researchCost = with(HPLItems.fors, 220, HPLItems.craside, 80);
            regionSuffix = "-hpl";
            fogRadius = 3;
            consumePower(2f);
        }};

        //endregion
        //region sandbox

        indestructibleWall = new IndestructibleWall("indestructible-wall") {{
            size = 1;
            placeableLiquid = true;
        }};
        indestructibleWallLarge = new IndestructibleWall("indestructible-wall-large") {{
            size = 2;
            placeableLiquid = true;
        }};
        //endregion sandbox

        testBlock = new GenericCrafter("test-block") {{
            requirements(Category.crafting, with(HPLItems.fors, 50, HPLItems.khylid, 20));
            outputItem = new ItemStack(HPLItems.craside, 1);
            consumeItems(with(HPLItems.fors, 2, HPLItems.volcanicSerrid, 1));
            craftTime = 40f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 3;
            craftEffect = Fx.none;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion(){{
                        layer = Layer.block;
                    }},
                    new DrawCrasideSmelt()
            );
        }};
    }
}
