package hlp.content;

import hlp.world.blocks.environment.ModOverlayFloor;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OverlayFloor;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;

import static mindustry.type.ItemStack.with;

public class HLPBlocks{
    public static Block
    //environment

    fir, firWall, forenite, foreniteWall, forsite, forsiteWall, infernoCrystal, infernoCrystalWall,

    seaSerrid, seaSerridWall, serridDust, serridDustWall, spaceRock, spaceRockWall, uberraschung, uberraschungWall,
    //liquids and each other...
    mainLiquid, pinkieFloor,

    //prop
    ancientSus, serridBoulder,

    //ores
    fors,

    //drills
    forsDrill,
    //distribution

    //core
    coreLegion;

    public static void load() {
        //region environment
        fir = new Floor("fir") {{
            variants = 4;
        }};

        firWall = new StaticWall("fir-wall") {{
            variants = 3;
        }};

        forenite = new Floor("forenite") {{
            variants = 4;
        }};

        foreniteWall = new StaticWall("forenite-wall") {{
            variants = 3;
        }};

        forsite = new Floor("forsite") {{
            variants = 3;
        }};

        forsiteWall = new StaticWall("forsite-wall") {{
            variants = 3;
        }};

        infernoCrystal = new Floor("inferno-crystal") {{
            variants = 4;
        }};

        infernoCrystalWall = new StaticWall("inferno-crystal-wall") {{
            variants = 3;
        }};

        seaSerrid = new Floor("sea-serrid") {{
            variants = 3;
        }};

        seaSerridWall = new StaticWall("sea-serrid-wall") {{
            variants = 3;
        }};

        serridDust = new Floor("serrid-dust") {{
            variants = 4;
        }};

        serridDustWall = new StaticWall("serrid-dust-wall") {{
            variants = 3;
        }};

        spaceRock = new Floor("space-rock") {{
            variants = 4;
        }};

        spaceRockWall = new StaticWall("space-rock-wall") {{
            variants = 3;
        }};

        uberraschung = new Floor("uberraschung") {{
            variants = 4;
        }};

        uberraschungWall = new StaticWall("uberraschung-wall") {{
            variants = 3;
        }};
        //LIQUIDS/ZHYZHA
        mainLiquid = new Floor("main-liquid") {{
            variants = 4;
            isLiquid = true;
        }};

        pinkieFloor = new Floor("pinkie-floor"){{
           variants = 4;
           isLiquid = true;
        }};

        //region prop
        ancientSus = new Prop("ancient-sus"){{
            breakable = false;
        }};

        serridBoulder = new Prop("serrid-boulder"){{
            variants = 2;
            serridDust.asFloor().decoration = this;
        }};
        //endregion prop

        //ores
        fors = new ModOverlayFloor("fors-ore"){{
            attributes.set(HLPAttribute.forsattr, 1f);
            variants = 2;
        }};
        //endregion environment
        //region drills
        forsDrill = new AttributeCrafter("fors-block"){{
            attribute = HLPAttribute.forsattr;
            displayEfficiencyScale = 1f / 4f;
            minEfficiency = 4f - 0.0001f;
            outputItem = new ItemStack(HLPItems.fors, 2);
            craftTime = 90;
            displayEfficiency = false;
        }};
        //endregion drills
        //region distribution
        //endregion distribution
        //regionproduction
        //endregion production
        //region core
        coreLegion = new CoreBlock("core-legion"){{
            requirements(Category.effect, with(Items.graphite, 1400, Items.silicon, 1200));

            isFirstTier = true;
            unitType = HLPUnits.gyurza;
            health = 2000;
            itemCapacity = 2600;
            size = 3;
            thrusterLength = 34/4f;
            armor = 2f;
            alwaysUnlocked = true;
            incinerateNonBuildable = true;
            buildCostMultiplier = 0.7f;


            unitCapModifier = 12;
            researchCostMultiplier = 0.07f;
        }};
        //endregion core
    }
}
