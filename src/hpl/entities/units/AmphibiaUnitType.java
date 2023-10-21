package hpl.entities.units;

import arc.Core;
import arc.func.Boolf;
import arc.func.Func;
import arc.graphics.g2d.TextureRegion;
import hpl.graphics.AbilityTextures;
import mindustry.gen.Unit;
import mindustry.gen.WaterMovec;
import mindustry.type.UnitType;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.ShallowLiquid;

/*
 * From AvantTeam/ProjectUnity
 */
public class AmphibiaUnitType extends UnitType {

    public TextureRegion[] abilityRegions = new TextureRegion[AbilityTextures.values().length];

    public Func<Unit, UnitType> toTrans;
    public Boolf<Unit> transPred = unit -> {
        Floor floor = unit.floorOn();
        return floor.isLiquid && !(floor instanceof ShallowLiquid) ^ unit instanceof WaterMovec;
    };
    public float transformTime;
    public AmphibiaUnitType(String name){
        super(name);
    }

    @Override
    public void load() {
        super.load();
        //abilities
        for (AbilityTextures type : AbilityTextures.values()) {
            abilityRegions[type.ordinal()] = Core.atlas.find(name + "-" + type.name());
        }
    }
}
