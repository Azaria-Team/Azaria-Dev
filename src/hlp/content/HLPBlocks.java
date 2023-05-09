package hlp.content;

import hlp.world.blocks.environment.ModOverlayFloor;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class HLPBlocks{
    public static Block
    //environment
    seaSerrid, seaSerridWall, crabStone, crabStoneWall, mainlFloor, mainlDeepFloor, whiteChips, whiteChipsWall,
    fir, firWall, forenite, foreniteWall, forsite, forsiteWall,
    spaceRock, spaceRockWall, terra, terraWall,
    //liquids
    pinkieFloor,

    //prop
    ancientSus, crabStoneBoulder, forsiteBoulder, forsBoulder,

    //ores
    forsOre, khylidOre,

    //drills
    forsDrill,
    //distribution
    //defense
    forsWall,
    coreLegion;

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
        crabStoneWall = new StaticWall("crab-stone-wall") {{
            variants = 3;
        }};
        crabStoneBoulder = new Prop("crab-stone-boulder"){{
            variants = 2;
            crabStone.asFloor().decoration = this;
        }};
        mainlFloor = new Floor("mainl-floor") {{
            variants = 4;
            isLiquid = true;
        }};
        mainlDeepFloor = new Floor("mainl-deep-floor") {{
            variants = 4;
            isLiquid = true;
        }};
        //endregion seaBiome
        //region forestBiome
        forenite = new Floor("forenite") {{
            variants = 4;
        }};
        foreniteWall = new StaticWall("forenite-wall") {{
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
        }};
        forsBoulder = new Prop("fors-boulder") {{
            variants = 2;
        }};
        spaceRock = new Floor("space-rock") {{
            variants = 4;
        }};
        spaceRockWall = new StaticWall("space-rock-wall") {{
            variants = 3;
        }};
        //endregion forestBiome
        //region otherBiomes
        whiteChips = new Floor("white-chips") {{
            variants = 4;
        }};
        whiteChipsWall = new StaticWall("white-chips-wall") {{
            variants = 3;
        }};
        terra = new Floor("terra") {{
            variants = 4;
        }};
        terraWall = new StaticWall("terra-wall") {{
            variants = 3;
        }};
        pinkieFloor = new Floor("pinkie-floor"){{
           variants = 4;
           isLiquid = true;
        }};

        //region prop
        ancientSus = new Prop("ancient-sus"){{
            breakable = false;
            size = 1;
            variants = 1;
            solid = true;
        }};
        //endregion prop

        //ores
        forsOre = new ModOverlayFloor("fors-ore"){{
            parent = blendGroup = forsite;
            variants = 2;
            attributes.set(HLPAttribute.forsattr, 1f);
        }};
        khylidOre = new ModOverlayFloor(("khylid-ore")) {{
           parent = blendGroup = mainlFloor;
           variants = 2;
           attributes.set(HLPAttribute.khylidattr, 1f);
        }};
        //endregion environment
        //region drills
        forsDrill = new AttributeCrafter("fors-block"){{
            requirements(Category.production, with(HLPItems.fors, 20));
            attribute = HLPAttribute.forsattr;
            group = BlockGroup.liquids;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HLPItems.fors, 2);
            craftTime = 90;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            consumePower(0.5f);
            displayEfficiency = false;
            size = 2;
        }};
        //endregion drills
        //region distribution
        //endregion distribution
        //region production
        //endregion production
        //region defense
        forsWall = new Wall("fors-wall"){{
            requirements(Category.defense, with(HLPItems.fors, 6));
            health = 120 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
        }};
        //endregion defense
        //region core
        coreLegion = new CoreBlock("core-legion"){{
            requirements(Category.effect, with(Items.graphite, 1400, Items.silicon, 1200));

            isFirstTier = true;
            unitType = HLPUnits.gyurza;
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
