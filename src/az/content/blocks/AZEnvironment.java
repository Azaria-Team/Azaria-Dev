package az.content.blocks;

import arc.graphics.Color;
import az.content.AZAttribute;
import az.content.AZItems;
import az.content.AZLiquids;
import az.world.blocks.environment.ModOverlayFloor;
import az.world.blocks.environment.UndergroundOre;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;

public class AZEnvironment {
    public static Block
            //sea-biome
    oxylite, deepOxylite,
    serridDust, serridDustWall, serridicBoulder,
    crabStone, crabStoneWall, crabStoneBoulder,
    serridicRock, serridicRockWall, serridBoulder, serridOxylite,
            corals,

    //forest-biome
    fir, firWall, firBoulder,
    forenite, foreniteWall, foreniteBoulder,
    darkSerrid, darkSerridWall, darkSerridBoulder, darkSerridOxylite,
    forsite, forsiteWall, forsiteBoulder, forsBoulder,
    bigKust,

    //crystal-biome
    lamprosMineral, lamprosMineralWall, lamprosBoulder, lamprosCrystals,
    crystalIce, crystalIceWall, crystalIceBoulder,
    spectralite, spectraliteWall, spectraliteBoulder, spectraliaWall,
    nerephyte, nerephyteWall, nerephyteBoulder,
    spectralia,

    //volcanic-biome
    huitaRock, huitaRockWall, huitaBoulder,
    volcanicSerrid, volcanicSerridWall, volcanicSerridBoulder,

    //other

    //prop
    ancientSus,

    //ores
    forsOre, ferbiumOre, forsRock, khylidOre;

    public static void load() {
        //region Auriona
        //region sea-biome
        //oxylite
        oxylite = new Floor("oxylite") {{
            variants = 4;
            liquidDrop = AZLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            attributes.set(AZAttribute.mainlheatattr, 0.25f);
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
            mapColor = Color.valueOf("50a9a8");
        }};
        deepOxylite = new Floor("deep-oxylite") {{
            variants = 4;
            liquidDrop = AZLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
            drownTime = 140f;
        }};
        serridOxylite = new Floor("serrid-oxylite") {{
            variants = 4;
            liquidDrop = AZLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
        }};
        //serridDust
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
        //crabStone
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
        //serridic rock
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
        //decorations
        corals = new TallBlock("coral") {{
            variants = 3;
            cacheLayer = CacheLayer.water;
        }};
        //endregion sea-biome

        //region forest-biome
        //fir
        fir = new Floor("fir") {{
            mapColor = Color.valueOf("222625");
            variants = 4;
        }};
        firWall = new StaticWall("fir-wall") {{
            variants = 3;
            fir.asFloor().wall = this;
            mapColor = Color.valueOf("54685e");
        }};
        firBoulder = new Prop("fir-boulder") {{
            variants = 3;
            fir.asFloor().decoration = this;
        }};
        //forenite
        forenite = new Floor("forenite") {{
            mapColor = Color.valueOf("313a3b");
            variants = 4;
        }};
        foreniteWall = new StaticWall("forenite-wall") {{
            variants = 3;
            forenite.asFloor().wall = this;
            mapColor = Color.valueOf("869985");
        }};
        foreniteBoulder = new Prop("forenite-boulder") {{
            variants = 3;
            forenite.asFloor().decoration = this;
        }};
        //forsite
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
        }};
        //darkSerrid
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
        darkSerridOxylite = new Floor("dark-serrid-oxylite") {{
            variants = 4;
            liquidDrop = AZLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
        }};
        //plants
        bigKust = new TallBlock("big-kust") {{
            variants = 3;
        }};
        //endregion forest-biome

        //region crystal-biome
        //lamprosMineral
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
        //crystalIce
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
        //spectralite
        spectralite = new Floor("spectralite") {{
            variants = 4;

        }};
        spectraliaWall = new StaticWall("spectralite-wall") {{
            variants = 2;
        }};
        spectraliteBoulder = new Prop("spectralite-boulder") {{
            variants = 3;
            spectralite.asFloor().decoration = this;
        }};
        //spectralia
        spectraliaWall = new StaticWall("spectralia-wall") {{
            variants = 2;
            spectralite.asFloor().wall = this;
        }};
        //nerephyte
        nerephyte = new Floor("nerephyte") {{
            variants = 5;
        }};
        nerephyteWall = new StaticWall("nerephyte-wall") {{
            variants = 3;
            nerephyte.asFloor().decoration = this;
        }};
        nerephyteBoulder  = new Prop("nerephyte-boulder") {{
            variants = 3;
            nerephyte.asFloor().decoration = this;
        }};
        //endregion crystal-biome

        //region volcanic-biome
        //huitaRock
        huitaRock = new Floor("huita-rock") {{
            attributes.set(AZAttribute.serridAttr, 0.25f);
            itemDrop = AZItems.volcanicSerrid;
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
        //volcanicSerrid
        volcanicSerrid = new Floor("volcanic-serrid") {{
            variants = 4;
        }};
        volcanicSerridWall = new StaticWall("volcanic-serrid-wall") {{
            variants = 3;
            volcanicSerrid.asFloor().decoration = this;
        }};
        volcanicSerridBoulder = new Prop("volcanic-serrid-boulder") {{
            variants = 3;
            volcanicSerrid.asFloor().decoration = this;
        }};
        //spectralia
        spectralia = new Floor("spectralia") {{
            variants = 4;
            isLiquid = true;
            liquidDrop = AZLiquids.spectralia;
            cacheLayer = CacheLayer.water;
            attributes.set(AZAttribute.mainlheatattr, 0.25f);
        }};
        //endregion volcanic-biome

        //region not-in-biome

        //endregion not-in-biome

        //region decorations
        ancientSus = new Prop("ancient-sus") {{
            breakable = false;
            size = 1;
            solid = true;

        }};
        //endregion decorations

        //region ores
        forsOre = new OreBlock(AZItems.fors){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        ferbiumOre = new UndergroundOre("ore-ferbium"){{
            itemDrop = AZItems.ferbium;
            generateIcons = false;
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
            variants = 2;
        }};
        forsRock = new ModOverlayFloor("fors-rock") {{
            parent = blendGroup = forsite;
            variants = 2;
            attributes.set(AZAttribute.forsattr, 1f);
        }};
        khylidOre = new ModOverlayFloor(("khylid-ore")) {{
            parent = blendGroup = oxylite;
            variants = 2;
            cacheLayer = CacheLayer.water;
            attributes.set(AZAttribute.khylidattr, 1f);
        }};
        //endregion ores
        //endregion Auriona

    }
}
