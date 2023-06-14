package hlp.content;

import hlp.graphics.HLPPal;
import hlp.world.blocks.defense.wall.IndestructibleWall;
import hlp.world.blocks.environment.ModOverlayFloor;
import hlp.world.blocks.power.LightningPowerNode;
import mindustry.Vars;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.DuctBridge;
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

import static mindustry.type.ItemStack.with;

public class HLPBlocks{
    public static Block
    //environment
            //forest biome
            forsite, forsiteWall, fir, firWall, forenite, foreniteWall,
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
    forsOre, khylidOre,

    //power
    plasmaNode, plasmaNodeLarge,
            plasmaDistributor, plasmaDistributorLarge, thermalEvaporator,

    //drills
    forsDrill, pumpDrill,

    //distribution
    impulseConveyor, impulseJunction, impulseRouter, impulseBridgeConveyor,

    //defense
    forsWall, forsWallLarge,
    forceTurret,

    //storage
    coreLegion, caseI,

    //sanbox
    indestructibleWall, indestructibleWallLarge;

    public static void load() {
        //region environment
        //region biomes
        //region forest biome
        forsite = new Floor("forsite") {{
            variants = 4;
        }};
        forsiteWall = new StaticWall("forsite-wall") {{
            variants = 3;
            forsite.asFloor().wall = this;

        }};
        forenite = new Floor("forenite") {{
            variants = 4;
        }};
        foreniteWall = new StaticWall("forenite-wall") {{
            variants = 3;
            forenite.asFloor().wall = this;
        }};
        fir = new Floor("fir") {{
            variants = 4;
        }};
        firWall = new StaticWall("fir-wall") {{
            variants = 3;
            fir.asFloor().wall = this;
        }};
        forsiteBoulder = new Prop("forsite-boulder") {{
            variants = 2;
            forsite.asFloor().decoration = this;
        }};
        forsBoulder = new Prop("fors-boulder") {{
            variants = 2;
            //probably there were no parent floor and you will place this block with your kutty paws uwu
        }};
        foreniteBoulder = new Prop("forenite-boulder") {{
            variants = 3;
            forenite.asFloor().decoration = this;
        }};
        firBoulder = new Prop("fir-boulder") {{
            variants = 3;
            fir.asFloor().decoration = this;
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
        crabStone = new Floor("crab-stone") {{
            variants = 4;
        }};
        crabStoneWall = new StaticWall("crab-stone-wall") {{
            variants = 3;
            crabStone.asFloor().wall = this;
        }};
        serridicRock = new Floor("serridic-stone") {{
            variants = 4;
        }};
        serridicRockWall = new StaticWall("serridic-stone-wall") {{
            variants = 3;
            serridicRock.asFloor().wall = this;
        }};
        crabStoneBoulder = new Prop("crab-stone-boulder") {{
            variants = 3;
            crabStone.asFloor().decoration = this;
        }};
        serridBoulder = new Prop("serrid-boulder") {{
            variants = 3;
            serridDust.asFloor().decoration = this;
        }};
        serridicBoulder = new Prop("serridic-boulder") {{
            variants = 3;
            serridicRock.asFloor().decoration = this;
        }};
        oxylite = new Floor("oxylite") {{
            variants = 4;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
            attributes.set(HLPAttribute.mainlheatattr, 0.25f);
        }};
        deepOxylite = new Floor("deep-oxylite") {{
            variants = 4;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
        }};
        serridOxylite = new Floor("serrid-oxylite") {{
            variants = 4;
            liquidDrop = HLPLiquids.mainl;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.9f;
        }};
        darkSerridOxylite = new Floor("dark-serrid-oxylite") {{
            variants = 4;
            liquidDrop = HLPLiquids.mainl;
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
            variants = 3;
            crystalIce.asFloor().wall = this;
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
        crystalIceBoulder = new Prop("crystal-ice-boulders") {{
            variants = 3;
            crystalIce.asFloor().decoration = this;
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
        darkSerridBoulder = new StaticWall("dark-serrid-boulder") {{
            variants = 3;
            darkSerrid.asFloor().decoration = this;
        }};
        huitaRock = new Floor("huita-rock") {{
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
        forsOre = new ModOverlayFloor("fors-ore") {{
            parent = blendGroup = forsite;
            variants = 2;
            attributes.set(HLPAttribute.forsattr, 1f);
        }};
        khylidOre = new ModOverlayFloor(("khylid-ore")) {{
            parent = blendGroup = oxylite;
            variants = 2;
            cacheLayer = CacheLayer.water;
            attributes.set(HLPAttribute.khylidattr, 1f);
        }};
        //endregion environment
        //region power
        plasmaNode = new LightningPowerNode("plasma-node", 0) {{
            requirements(Category.power, with(HLPItems.fors, 15));

            consumePowerBuffered(600f);
            lightningRange = 8 * 8f;
            thresholdPerTile = 25f / 8;
        }};

        plasmaNodeLarge = new LightningPowerNode("plasma-node-large", 0) {{
            //todo crafting
            requirements(Category.power, with(HLPItems.khylid, 1000));
            consumePowerBuffered(14000f);
            size = 2;
            lightningRange = 15 * 8f;
            thresholdPerTile = 60f / 8;
        }};

        plasmaDistributor = new LightningPowerNode("plasma-distributor", 12) {{
            requirements(Category.power, with(HLPItems.fors, 30));
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
        impulseBridgeConveyor = new DuctBridge("impulse-bridge-conveyor"){{
            requirements(Category.distribution, with(HLPItems.fors, 10));
            health = 90;
            speed = 4f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
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

        forsWallLarge = new Wall("fors-wall-large") {{
            requirements (Category.defense, with(HLPItems.fors, 24));
            health = 120 * 16;
            size = 2;
            armor = 3f;
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
            range = 24 * Vars.tilesize;
            shootCone = 10f;
            rotateSpeed = 2.4f;

            shootSound = Sounds.cannon;
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
