package az.content.blocks;

import arc.util.Time;
import az.content.AZItems;
import az.content.AZUnits;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class AZUnitRelatedBlocks {
    public static Block
    angelsharkFabricator, vectorFabricator, unmakerFabricator;

    public static void load() {
        angelsharkFabricator = new UnitFactory("angelshark-fabricator"){{
            requirements(Category.units, with(AZItems.fors, 200, AZItems.khylid, 140, AZItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(AZUnits.angelshark, 15f * Time.toSeconds, with(AZItems.fors, 40, AZItems.khylid, 30, AZItems.craside, 10)));
            researchCost = with(AZItems.fors, 180, AZItems.khylid, 100, AZItems.craside, 40);
            regionSuffix = "-az";
            fogRadius = 3;
            consumePower(2f);
        }};

        vectorFabricator = new UnitFactory("vector-fabricator"){{
            requirements(Category.units, with(AZItems.fors, 200, AZItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(AZUnits.vector, 10f * Time.toSeconds, with(AZItems.fors, 50, AZItems.craside, 30)));
            researchCost = with(AZItems.fors, 220, AZItems.craside, 80);
            regionSuffix = "-az";
            fogRadius = 3;
            researchCostMultiplier = 0.2f;
            consumePower(2f);
        }};
        unmakerFabricator = new UnitFactory("unmaker-fabricator") {{
            requirements(Category.units, with(AZItems.fors, 200, AZItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(AZUnits.unmaker, 10f * Time.toSeconds, with(AZItems.fors, 50, AZItems.craside, 30)));
            researchCost = with(AZItems.fors, 220, AZItems.craside, 80);
            regionSuffix = "-az";
            fogRadius = 3;
            consumePower(2f);
        }};
    }
}
