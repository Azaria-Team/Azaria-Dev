package hlp.content;

import hlp.world.blocks.environment.ModOverlayFloor;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.gen.Sounds;
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
import mindustry.world.meta.BlockGroup;

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
    forsOre1, forsOre2,

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
        forsOre1 = new ModOverlayFloor("fors-ore1"){{
            attributes.set(HLPAttribute.forsattr, 1f);
        }};
        forsOre2 = new ModOverlayFloor("fors-ore2"){{
            attributes.set(HLPAttribute.forsattr, 1f);
        }};
        //endregion environment
        //region drills
        forsDrill = new AttributeCrafter("fors-block"){{
            requirements(Category.production, with(HLPItems.fors, 20));
            attribute = HLPAttribute.forsattr;
            group = BlockGroup.liquids;
            minEfficiency = 9f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 9f;
            outputItem = new ItemStack(HLPItems.fors, 2);
            craftTime = 90;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            consumePower(0.5f);
            displayEfficiency = false;
            size = 3;
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
            unitType = UnitTypes.alpha;
            health = 2000;
            itemCapacity = 2600;
            size = 3;
            armor = 2f;
            alwaysUnlocked = true;

            unitCapModifier = 12;
        }};
        //endregion core
    }
}
