package az.content.blocks;

import az.content.AZItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static mindustry.type.ItemStack.with;

public class AZWalls {

    public static Block
            forsWall, forsWallLarge, compositeWall, compositeWallLarge;

    public static void load() {
        forsWall = new Wall("fors-wall") {{
            requirements(Category.defense, with(AZItems.fors, 6));
            researchCost = with(AZItems.fors, 100);
            health = 160 * 4;
            armor = 3f;
            buildCostMultiplier = 6f;
        }};

        forsWallLarge = new Wall("fors-wall-large") {{
            requirements (Category.defense, with(AZItems.fors, 24));
            researchCost = with(AZItems.fors, 450);
            health = 160 * 16;
            size = 2;
            armor = 3f;
            buildCostMultiplier = 6f;
        }};

        compositeWall = new Wall("composite-wall") {{
            requirements (Category.defense, with(AZItems.craside, 4, AZItems.khylid, 2));
            health = 800;
            buildCostMultiplier = 6f;
        }};

        compositeWallLarge = new Wall("composite-wall-large"){{
            requirements (Category.defense, with(AZItems.craside, 20, AZItems.khylid, 4));
            size = 2;
            buildCostMultiplier = 6f;
            health = 800 * 4;
        }};
    }
}
