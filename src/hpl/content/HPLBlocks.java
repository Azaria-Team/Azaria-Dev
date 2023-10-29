package hpl.content;

import arc.Core;
import arc.graphics.Color;
import arc.util.Time;
import hpl.content.blocks.*;
import hpl.graphics.HPLPal;
import hpl.world.blocks.defense.NavalMine;
import hpl.world.blocks.defense.turret.BlockRepairTurret;
import hpl.world.blocks.defense.wall.IndestructibleWall;
import hpl.world.blocks.distribution.ModDuct;
import hpl.world.blocks.environment.ModOverlayFloor;
import hpl.world.blocks.environment.UndergroundOre;
import hpl.world.blocks.power.LightningPowerNode;
import hpl.world.blocks.production.OreRadar;
import hpl.world.blocks.power.ThermalEvaporator;
import hpl.world.blocks.production.HPLBurstDrill;
import hpl.world.draw.DrawCrasideSmelt;
import hpl.world.draw.DrawDrillPart;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Pump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class HPLBlocks {
    public static Block
            complexSurprise, coreLegion, caseI;
    public static void load() {

        HPLDistribution.load();
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
