package az.content.blocks;

import az.content.AZItems;
import az.content.AZUnits;
import az.graphics.AZPal;
import az.world.blocks.defense.NavalMine;
import az.world.blocks.defense.turret.BlockRepairTurret;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;

import static mindustry.type.ItemStack.with;

public class AZCoreRelatedBlocks {
    public static Block
            navalMine, coreLegion, caseI, repairTurret;
    public static void load() {
        //region traps
        coreLegion = new CoreBlock("core-legion") {{
            requirements(Category.effect, with(AZItems.fors, 1200, AZItems.khylid, 800));

            isFirstTier = true;
            unitType = AZUnits.gyurza;
            health = 2500;
            itemCapacity = 2500;
            size = 3;
            armor = 2f;
            alwaysUnlocked = true;
            squareSprite = false;

            unitCapModifier = 12;
        }};

        caseI = new StorageBlock("case") {{
            requirements(Category.effect, with(AZItems.fors, 100));
            size = 2;
            itemCapacity = 100;
            scaledHealth = 80;
            squareSprite = false;
            researchCostMultiplier = 0.7f;
        }};
        navalMine = new NavalMine("naval-mine") {{
            size = 2;
            placeableLiquid = true;
            underBullets = true;
            outlineColor = AZPal.aureliaOutline;
            requirements(Category.effect, with(AZItems.ognium, 50, AZItems.ferbium, 35));
            hasShadow = false;
            health = 1850;
            damage = 790;
            tileDamage = 1850;
        }};

        repairTurret = new BlockRepairTurret("repair-turret"){{
            requirements(Category.effect, with(AZItems.fors, 120, AZItems.khylid, 30, AZItems.craside, 80));
            repairSpeed = 0.75f;
            repairRadius = 180f;
            outlineColor = AZPal.aureliaOutline;
            beamWidth = 1f;
            powerUse = 1f;
            size= 2;
            researchCostMultiplier = 0.5f;
        }};
    }
}
