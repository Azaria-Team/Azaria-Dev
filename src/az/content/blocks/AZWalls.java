package az.content.blocks;

import az.content.AZItems;
import az.content.AZLiquids;

import az.world.blocks.defense.wall.AZHealingWall;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static arc.input.KeyCode.f;
import static mindustry.type.ItemStack.with;

public class AZWalls {

    public static Block
            forsWall, forsWallLarge,
            compositeWall, compositeWallLarge;

    public static void load() {

        //sec1
        forsWall = new Wall("fors-wall") {{
            requirements(Category.defense, with(AZItems.fors, 6));
            researchCost = with(AZItems.fors, 100);

            health = 420;
            armor = 3f;

            buildCostMultiplier = 6f;
        }};

        forsWallLarge = new Wall("fors-wall-large") {{
            requirements (Category.defense, with(AZItems.fors, 24));
            researchCost = with(AZItems.fors, 400);

            health = forsWall.health * 4;
            size = 2;
            armor = 3f;

            buildCostMultiplier = 6f;
        }};

        //later
        compositeWall = new AZHealingWall("composite-wall") {{
            requirements (Category.defense, with(AZItems.craside, 4, AZItems.khylid, 2));
            health = 800;
            buildCostMultiplier = 6f;

            hasLiquids = true;
            liquidCapacity = 25f;
            consumeLiquid(AZLiquids.oxyliteLiq, 0.05f);
            healAmount = 0.175f;
        }};

        compositeWallLarge = new AZHealingWall("composite-wall-large"){{
            requirements (Category.defense, with(AZItems.craside, 20, AZItems.khylid, 4));
            health = 800 * 4;
            size = 2;
            buildCostMultiplier = 6f;

            hasLiquids = true;
            liquidCapacity = 50f;
            consumeLiquid(AZLiquids.oxyliteLiq, 0.175f);
            healAmount = 0.7f;
        }};
    }
}
