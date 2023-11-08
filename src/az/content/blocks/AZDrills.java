package az.content.blocks;

import az.content.AZAttribute;
import az.content.AZFx;
import az.content.AZItems;
import az.graphics.AZPal;
import az.world.blocks.production.HPLBurstDrill;
import az.world.blocks.production.OreRadar;
import az.world.draw.DrawDrillPart;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class AZDrills {
    public static Block
            forsDrill, pumpDrill,
            waveDrill, oreDetector;
    public static void load() {
        //sec1
        forsDrill = new AttributeCrafter("fors-block") {{
            requirements(Category.production, with(AZItems.fors, 20));
            researchCost = with(Category.production, AZItems.fors, 25);

            attribute = AZAttribute.forsattr;
            outputItem = new ItemStack(AZItems.fors, 4);
            ambientSound = Sounds.hum;

            health = 280;
            size = 2;
            craftTime = 240f;

            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            ambientSoundVolume = 0.06f;
            craftEffect = AZFx.forsDrillEffect;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = AZPal.fors;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
            squareSprite = false;
            displayEfficiency = false;
        }};

        pumpDrill = new AttributeCrafter("pump-drill") {{
            researchCost = with(Category.production, AZItems.fors, 35);
            researchCost = with(AZItems.fors, 50);

            attribute = AZAttribute.khylidattr;
            group = BlockGroup.liquids;
            outputItem = new ItemStack(AZItems.khylid, 4);
            ambientSound = Sounds.hum;

            health = 280;
            size = 2;
            craftTime = 160;

            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            ambientSoundVolume = 0.06f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.8f;
                        color = AZPal.khylid;
                        glowIntensity = 0.1f;
                        glowScale = 9f;
                    }}
            );
            squareSprite = false;
            displayEfficiency = false;
        }};

        //later
        waveDrill = new HPLBurstDrill("wave-drill"){{
            requirements(Category.production, with(AZItems.fors, 35, AZItems.craside, 15));
            drillTime = 60f * 5f;
            size = 3;
            hasPower = true;
            tier = 3;
            //drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            shake = 3f;
            itemCapacity = 20;
            researchCost = with(AZItems.fors, 50);

            fogRadius = 4;
            consumePower(15f / 60f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawDrillPart(11f / 4f){{
                        shadowOffset = 1f;
                        baseOffset = 1.0f; //you're fucking genius to write 4.0f/4.0f;
                        layer = Layer.blockOver;
                        angleOffset = 135;
                        drawPlan = false;

                    }},
                    new DrawRegion("-top"){{
                        layer = Layer.blockOver + 0.1f;
                    }}
            );
        }};

        oreDetector = new OreRadar("ore-detector") {{
            requirements(Category.production, with(AZItems.fors, 20, AZItems.khylid, 20, AZItems.craside, 35));
            size = 3;
            consumePower(30f/60f);
        }};
    }
}
