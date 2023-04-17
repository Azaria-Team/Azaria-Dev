package hlp.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;

public class HLPBlocks{
    public static Block
    //environment
        //sw-biome
    fir, firWall, forenite, foreniteWall, seggz, seggzWall, spaceRock, spaceRockWall,
        //aa
    uberraschung, uberraschungWall, serridDust, serridDustWall, fellatio, fellatioWall,
        //liquids and each other...
    blassenFloor;

    public static void load() {
        fir = new Floor("fir") {{
           variants = 4;
        }};

        firWall = new StaticWall("fir-wall") {{

        }};

        forenite = new Floor("forenite") {{
            variants = 4;
        }};

        foreniteWall = new StaticWall("forenite-wall") {{

        }};
        seggz = new Floor("seggz") {{
            variants = 3;
        }};

        seggzWall = new StaticWall("seggz-wall") {{

        }};

        spaceRock = new Floor("space-rock") {{
            variants = 4;
        }};

        spaceRockWall = new StaticWall("space-rock-wall") {{

        }};

        uberraschung = new Floor("uberraschung") {{
            variants = 4;
        }};

        uberraschungWall = new StaticWall("uberraschung-wall") {{

        }};

        serridDust = new Floor("serrid-dust") {{
            variants = 4;
        }};

        serridDustWall = new StaticWall("serrid-dust-wall") {{

        }};

        fellatio = new Floor("fellatio") {{
            variants = 4;
        }};

        fellatioWall = new StaticWall("fellatio-wall") {{

        }};
        //LIQUIDS/ZHYZHA
        blassenFloor = new Floor("blassen-floor") {{
            variants = 4;
        }};
    }
}
