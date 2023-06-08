package hlp.content;

import arc.graphics.Color;
import hlp.graphics.HLPPal;
import hlp.world.blocks.defense.wall.IndestructibleWall;
import hlp.world.blocks.environment.ModOverlayFloor;
import hlp.world.blocks.power.LightningPowerNode;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class HLPBlocks{
    public static Block
    //environment
    seaSerrid, seaSerridWall, crabStone, crabStoneCratters, crabStoneWall, mainlFloor, mainlDeepFloor, serridMainl, mainlSerrid, huitaRock, huitaRockWall, mainlThermalFloor,
    fir, firWall, forenite, foreniteWall, forsite, forsiteWall,
    spaceRock, spaceRockWall,
    //liquids
    pinkieFloor,

    //prop
    ancientSus, crabStoneBoulder, forsiteBoulder, forsBoulder,

    //ores
    forsOre, khylidOre,

    //power
    plasmaNode, plasmaNodeLarge,
            plasmaDistributor, plasmaDistributorLarge, thermalEvaporator,

    //drills
    forsDrill, pumpDrill,

    //distribution
    impulseConveyor, impulseJunction, impulseRouter,

    //defense
    forsWall,
    forceTurret,

    //storage
    coreLegion, caseI,

    //sanbox
    indestructibleWall, indestructibleWallLarge;

    public static void load() {
        //region environment
        //region biomes
        //region seaBiome
        seaSerrid = new Floor("sea-serrid") {{
            variants = 4;
        }};
        seaSerridWall = new StaticWall("sea-serrid-wall") {{
            variants = 3;
        }};
        crabStone = new Floor("crab-stone") {{
            variants = 4;
        }};
        crabStoneCratters = new Floor("crab-stone-cratters") {{
            variants = 4;
        }};
        crabStoneWall = new StaticWall("crab-stone-wall") {{
            variants = 3;
        }};
        crabStoneBoulder = new Prop("crab-stone-boulder") {{
            variants = 3;
            crabStone.asFloor().decoration = this;
        }};
        mainlFloor = new Floor("mainl-floor") {{
            variants = 4;
            isLiquid = true;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;

        }};
        mainlDeepFloor = new Floor("mainl-deep-floor") {{
            variants = 4;
            isLiquid = true;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            drownTime = 50f;
            albedo = 0.5f;
        }};
        serridMainl = new Floor("serrid-mainl") {{
            variants = 4;
            isLiquid = true;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            drownTime = 50f;
            albedo = 0.5f;
        }};
        mainlSerrid = new Floor("mainl-serrid") {{
            variants = 4;
            isLiquid = true;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            drownTime = 50f;
            albedo = 0.5f;
        }};
        mainlThermalFloor = new Floor("mainl-thermal") {{
            variants = 4;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.5f;
            attributes.set(HLPAttribute.mainlheatattr, 0.25f);
        }};
        //endregion seaBiome
        //region forestBiome
        forenite = new Floor("forenite") {{
            variants = 4;
        }};
        foreniteWall = new StaticWall("forenite-wall") {{
            variants = 3;
        }};
        huitaRock = new Floor("huita-rock") {{
           variants = 4;
        }};
        huitaRockWall = new StaticWall("huita-rock-wall") {{
            variants = 3;
        }};
        fir = new Floor("fir") {{
            variants = 4;
        }};
        firWall = new StaticWall("fir-wall") {{
            variants = 3;
        }};
        forsite = new Floor("forsite") {{
            variants = 3;
        }};
        forsiteWall = new StaticWall("forsite-wall") {{
            variants = 3;
        }};
        forsiteBoulder = new Prop("forsite-boulder") {{
            variants = 2;
            forsite.asFloor().decoration = this;
        }};
        forsBoulder = new Prop("fors-boulder") {{
            variants = 2;
            forsite.asFloor().decoration = this;
        }};
        spaceRock = new Floor("space-rock") {{
            variants = 4;
        }};
        spaceRockWall = new StaticWall("space-rock-wall") {{
            variants = 3;
        }};
        //endregion forestBiome
        //region otherBiomes
        pinkieFloor = new Floor("pinkie-floor") {{
            variants = 4;
            isLiquid = true;
            cacheLayer = CacheLayer.water;

        }};

        //region prop
        ancientSus = new Prop("ancient-sus") {{
            breakable = false;
            size = 1;
            solid = true;
        }};
        //endregion prop

        //ores
        forsOre = new ModOverlayFloor("fors-ore") {{
            parent = blendGroup = forsite;
            variants = 2;
            attributes.set(HLPAttribute.forsattr, 1f);
        }};
        khylidOre = new ModOverlayFloor(("khylid-ore")) {{
            parent = blendGroup = mainlFloor;
            variants = 2;
            cacheLayer = CacheLayer.water;
            attributes.set(HLPAttribute.khylidattr, 1f);
        }};
        //endregion environment
        //region power
        plasmaNode = new LightningPowerNode("plasma-node", 0) {{
            requirements(Category.power, with(HLPItems.fors, 1, HLPItems.khylid, 2));

            consumePowerBuffered(600f);
            lightningRange = 7 * 8f;
            thresholdPerTile = 25f / 8;
        }};

        plasmaNodeLarge = new LightningPowerNode("plasma-node-large", 0) {{
            //todo crafting
            requirements(Category.power, with(HLPItems.khylid, 1000));
            consumePowerBuffered(14000f);
            size = 2;
            lightningRange = 17 * 8f;
            thresholdPerTile = 60f / 8;
        }};

        plasmaDistributor = new LightningPowerNode("plasma-distributor", 12) {{
            requirements(Category.power, with(HLPItems.fors, 20, HLPItems.khylid, 30));
            size = 2;
            consumePowerBuffered(1000f);
            lightningRange = 5 * 8f;
            laserRange = 10;
            thresholdPerTile = 10f / 8;
        }};

        plasmaDistributorLarge = new LightningPowerNode("plasma-distributor-large", 24) {{
            //todo crafting
            requirements(Category.power, with(HLPItems.khylid, 1000));
            consumePowerBuffered(10000f);
            size = 3;
            lightningRange = 15 * 8f;
            laserRange = 17;
            thresholdPerTile = 40f / 8;
        }};

        thermalEvaporator = new ThermalGenerator("thermal-evaporator") {{
            requirements(Category.power, with(HLPItems.fors, 40));
            powerProduction = 2f;
            displayEfficiency = true;
            size = 2;
            floating = true;
            placeableLiquid = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            attribute = HLPAttribute.mainlheatattr;
            generateEffect = HLPFx.smokeEvaporatorBig;
            effectChance = 0.4f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = HLPPal.lightningNodeColor;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
        }};
        //endregion power
        //region drills
        forsDrill = new AttributeCrafter("fors-block") {{
            requirements(Category.production, with(HLPItems.fors, 20));
            attribute = HLPAttribute.forsattr;
            group = BlockGroup.liquids;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HLPItems.fors, 4);
            craftTime = 240f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            displayEfficiency = false;
            size = 2;
            craftEffect = HLPFx.forsDrillEffect;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = HLPPal.fors;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
        }};
        pumpDrill = new AttributeCrafter("pump-drill") {{
            requirements(Category.production, with(HLPItems.fors, 40));
            attribute = HLPAttribute.khylidattr;
            group = BlockGroup.liquids;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HLPItems.khylid, 2);
            craftTime = 70;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            consumePower(0.5f);
            displayEfficiency = false;
            size = 2;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.8f;
                        color = HLPPal.khylid;
                        glowIntensity = 0.1f;
                        glowScale = 9f;
                    }}
            );
            squareSprite = false;
        }};
        //endregion drills
        //region distribution
        impulseConveyor = new Duct("impulse-conveyor") {{
            requirements(Category.distribution, with(HLPItems.fors, 1));
            health = 130;
            speed = 5f;
            researchCost = with(HLPItems.fors, 5);

        }};
        impulseJunction = new Junction("impulse-junction") {{
            requirements(Category.distribution, with(HLPItems.fors, 2));
            speed = 6;
            capacity = 1;
            health = 140;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};
        impulseRouter = new Router("impulse-router") {{
            requirements(Category.distribution, with(HLPItems.fors, 3));
            speed = 16;
            buildCostMultiplier = 4f;
            squareSprite = false;
        }};
        //endregion distribution
        //region production
        //endregion production
        //region defense
        forsWall = new Wall("fors-wall") {{
            requirements(Category.defense, with(HLPItems.fors, 6));
            health = 120 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
        }};

        forceTurret = new ItemTurret("force"){{
            requirements(Category.turret, with(HLPItems.fors, 120, HLPItems.khylid, 50));
            health = 600;
            shootEffect = HLPFx.shootForce;
            smokeEffect = HLPFx.shootSmokeForce;
            reload = 70f;
            inaccuracy = 2f;
            shake = 2f;
            shootY = -2;
            outlineColor = HLPPal.aureliaOutline;
            size = 2;
            recoil = 2f;
            range = 19 * Vars.tilesize;
            shootCone = 10f;
            rotateSpeed = 2.4f;

            shootSound = Sounds.shootAlt;
            squareSprite = false;
            itemCapacity = 20;

            ammo(HLPItems.fors, HLPBullets.forceBullet);

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
        //endregion defense
        //region storage
        coreLegion = new CoreBlock("core-legion") {{
            requirements(Category.effect, with(HLPItems.fors, 1200, HLPItems.khylid, 800));

            isFirstTier = true;
            unitType = HLPUnits.gyurza;
            health = 2000;
            itemCapacity = 2500;
            size = 3;
            armor = 2f;
            alwaysUnlocked = true;
            squareSprite = false;

            unitCapModifier = 12;
        }};

        caseI = new StorageBlock("case") {{
            requirements(Category.effect, with(HLPItems.fors, 100));
            size = 2;
            itemCapacity = 100;
            scaledHealth = 80;
            squareSprite = false;
        }};
        //endregion storage
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
    }
}
