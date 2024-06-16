package az.content.blocks;

import az.content.AZItems;
import az.world.blocks.distribution.ModDuct;
import mindustry.content.Blocks;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class AZDistribution {
    public static Block
            magneticConveyor, magneticJunction, magneticRouter, magneticBridgeConveyor,
            magneticSorter, magneticReverseSorter, magneticOverflorGate, magneticUnderflowGate,
            magneticUnloader;

    public static void load() {
        //sec1
        magneticConveyor = new ModDuct("magnetic-conveyor") {{
            requirements(Category.distribution, with(AZItems.fors, 1));
            researchCost = with(AZItems.fors, 5);

            health = 200;
            speed = 7.5f;

            junctionReplacement = AZDistribution.magneticJunction;
            bridgeReplacement = AZDistribution.magneticBridgeConveyor;
        }};

        magneticJunction = new Junction("magnetic-junction") {{
            requirements(Category.distribution, with(AZItems.fors, 2));
            researchCost = with(AZItems.fors, 10);

            health = 180;
            speed = 6f;

            capacity = 1;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};

        magneticRouter = new Router("magnetic-router") {{
            requirements(Category.distribution, with(AZItems.fors, 2));
            researchCost = with(AZItems.fors, 15);

            health = 180;
            speed = 16f;

            squareSprite = false;
        }};

        magneticBridgeConveyor = new ItemBridge("magnetic-bridge-conveyor"){{
            requirements(Category.distribution, with(AZItems.fors, 10));
            researchCost = with(AZItems.fors, 35);
            bridgeWidth = 8F;
            health = 170;
            range = 5;

            buildCostMultiplier = 2f;
            squareSprite = false;
        }};

        //sec2
        magneticSorter = new Sorter("magnetic-sorter"){{
            requirements(Category.distribution, with(AZItems.fors, 4));
        }};

        magneticReverseSorter = new Sorter("magnetic-reverse-sorter") {{
            requirements(Category.distribution, with(AZItems.fors, 4));
            invert = true;
        }};

        magneticOverflorGate = new OverflowGate("magnetic-overflow-gate"){{
            requirements(Category.distribution, with(AZItems.fors, 6));
            buildCostMultiplier = 3;
        }};
        magneticUnderflowGate = new OverflowGate("magnetic-underflow-gate") {{
            requirements(Category.distribution, with(AZItems.fors, 6));
            invert = true;
        }};

        magneticUnloader = new Unloader("magnetic-unloader") {{
            requirements(Category.distribution, with(AZItems.keremtite, 15, AZItems.fors, 5));
            health = 300;
            speed = 60.0f / 11.0f;

            group = BlockGroup.transportation;
            squareSprite = false;
        }};
    }
}
