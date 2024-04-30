package az.content.blocks;

import arc.graphics.Color;
import az.content.AZFx;
import az.content.AZItems;
import az.graphics.AZPal;
import az.world.draw.MultiDrawFlame;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
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
            consumeItems(with(AZItems.fors, 2, AZItems.volcanicSerrid, 3, AZItems.ferbium, 1));
            craftTime = 160f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 4;
            // craftEffect = AZFx.crasideBrewerSmoke;
            consumePower(1f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new MultiDrawFlame(){{
                        flamePoints(
                                new FlamePoint(63.5f/128f,33.4f/128f),
                                new FlamePoint(63.5f/128f,93.5f/128f),
                                new FlamePoint(43.5f/128f,83.5f/128f),
                                new FlamePoint(43.5f/128f,43.5f/128f),
                                new FlamePoint(83.5f/128f,83.5f/128f),
                                new FlamePoint(83.5f/128f,43.5f/128f),
                                new FlamePoint(33.5f/128f,63.5f/128f),
                                new FlamePoint(93.5f/128f,63.5f/128f)

                        );
                        flameRadius = 1.3f;
                        flameRadiusIn = 0.5f;
                        flameRadiusScl = 3f;
                        flameRadiusMag = 0.5f;
                        flameRadiusInMag = 0.5f;
                        flameColor = AZPal.superdenseBullet;
                    }},
                    new DrawFlame(){{
                        flameColor = AZPal.superdenseBulletBack;
                        flameRadius = 3f;

                    }}
            );
            // researchCostMultiplier = 0.2f;
            squareSprite = false;
        }};
    }
}
