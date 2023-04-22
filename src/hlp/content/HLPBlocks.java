package hlp.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OverlayFloor;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.meta.Attribute;

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
    fors;

    public static void load() {
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

        //prop
        ancientSus = new Prop("ancient-sus"){{
            breakable = false;
        }};

        serridBoulder = new Prop("serrid-boulder"){{
            variants = 2;
            serridDust.asFloor().decoration = this;
        }};

        //ores
        fors = new OverlayFloor("fors"){{
            attributes.set(HLPAttribute.fors, 1f);
        }};
    }
}
