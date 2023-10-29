package hpl.content;

import hpl.content.blocks.*;
import hpl.graphics.HPLPal;
import hpl.world.blocks.defense.NavalMine;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;

import static mindustry.type.ItemStack.with;

public class HPLDistribution {
    public static Block
            complexSurprise, coreLegion, caseI;
    public static void load() {

        hpl.content.blocks.HPLDistribution.load();
        HPLDrills.load();
        HPLEnvironment.load();
        HPLLiquidBlocks.load();
        HPLPower.load();
        HPLProduction.load();
        HPLSandbox.load();
        HPLTurrets.load();
        HPLUnitRelatedBlocks.load();
        HPLWalls.load();

        //region traps
        coreLegion = new CoreBlock("core-legion") {{
            requirements(Category.effect, with(HPLItems.fors, 1200, HPLItems.khylid, 800));

            isFirstTier = true;
            unitType = HPLUnits.gyurza;
            health = 2500;
            itemCapacity = 2500;
            size = 3;
            armor = 2f;
            alwaysUnlocked = true;
            squareSprite = false;

            unitCapModifier = 12;
        }};

        caseI = new StorageBlock("case") {{
            requirements(Category.effect, with(HPLItems.fors, 100));
            size = 2;
            itemCapacity = 100;
            scaledHealth = 80;
            squareSprite = false;
        }};
        complexSurprise = new NavalMine("complex-surprise") {{
            size = 2;
            floating = true;
            outlineColor = HPLPal.aureliaOutline;
            requirements(Category.effect, with(HPLItems.ognium, 50, HPLItems.ferbium, 35));
            hasShadow = false;
            health = 1850;
            damage = 150;
            tileDamage = 450;
        }};
    }
}
