package az.content.blocks;

import az.content.AZFx;
import az.content.AZItems;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class AZProduction {
    public static Block
    crasideBrewer, superdenseKiln;

    public static void load() {

        //TODO
        crasideBrewer = new GenericCrafter("craside-brewer") {{
            requirements(Category.crafting, with(AZItems.fors, 60, AZItems.khylid, 35));
            outputItem = new ItemStack(AZItems.craside, 2);
            consumeItems(with(AZItems.khylid, 1, AZItems.volcanicSerrid, 1));
            craftTime = 110f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 3;
            craftEffect = AZFx.crasideBrewerSmoke;
            consumePower(1f);
            researchCostMultiplier = 0.2f;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"){{
                        layer = Layer.block;
                    }},
                    new DrawRegion(){{
                        layer = Layer.block + 0.1f;
                    }},
                    new DrawRegion("-top"){{
                        layer = Layer.block + 0.2f;
                    }}
            );
        }};

        superdenseKiln = new GenericCrafter("superdense-kiln") {{
            requirements(Category.crafting, with(AZItems.fors, 200, AZItems.khylid, 150, AZItems.craside, 100));
            outputItem = new ItemStack(AZItems.superdenseAlloy, 4);
            consumeItems(with(AZItems.fors, 2, AZItems.volcanicSerrid, 2, AZItems.ferbium, 1));
            craftTime = 160f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 4;
           // craftEffect = AZFx.crasideBrewerSmoke;
            consumePower(1f);
           // researchCostMultiplier = 0.2f;
            squareSprite = false;
        }};
    }
}
