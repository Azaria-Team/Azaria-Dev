package hpl.entities.comp;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import hpl.entities.units.StriCopterUnitType;
import hpl.gen.StriCopterc;
import hpl.world.draw.Blade;
import mindustry.annotations.Annotations;
import mindustry.content.Fx;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;

import static hpl.world.draw.Blade.BladeMount;

@Annotations.Component
public abstract class StriCopterComp implements Unitc, StriCopterc {
    @Annotations.Import
    float x,y,rotation;
    @Annotations.Import
    boolean dead;
    @Annotations.Import
    UnitType type;
    public BladeMount[] blades;
    public float bladeMoveSpeedScl = 1f;

    @Override
    public void afterRead(){
        setBlades(type);
    }

    @Override
    public void setType(UnitType type) {
        setBlades(type);
    }

    public void setBlades(UnitType type){
        if (type instanceof StriCopterUnitType stricopter) {
            blades = new BladeMount[stricopter.blade.size];
            for (int i = 0; i < blades.length; i++) {
                Blade bladeType = stricopter.blade.get(i);
                blades[i] = new BladeMount(bladeType);
            }
        }
    }

    public long drawSeed = 0;
    private float driftAngle;
    private boolean hasDriftAngle = false;
    public float driftAngle() {
        return driftAngle;
    }

    @Override
    public void update() {
        drawSeed++;
        StriCopterUnitType type = (StriCopterUnitType) this.type;
        float rX = x + Angles.trnsx(rotation - 90, type.fallSmokeX, type.fallSmokeY);
        float rY = y + Angles.trnsy(rotation - 90, type.fallSmokeX, type.fallSmokeY);

        // When dying
        if (dead || health() <= 0) {
            if (Mathf.chanceDelta(type.fallSmokeChance)) {
                Fx.fallSmoke.at(rX, rY);
                Fx.burning.at(rX, rY);
            }

            bladeMoveSpeedScl = Mathf.lerpDelta(bladeMoveSpeedScl, 0f, type.bladeDeathMoveSlowdown);
        } else {
            hasDriftAngle = false; // Reset the drift angle flag
            bladeMoveSpeedScl = Mathf.lerpDelta(bladeMoveSpeedScl, 1f, type.bladeDeathMoveSlowdown);
        }

        for (BladeMount blade : blades) {
            blade.bladeRotation += ((blade.blade.bladeMoveSpeed * bladeMoveSpeedScl) + blade.blade.minimumBladeMoveSpeed) * Time.delta;
        }
        type.fallSpeed = 0.01f;
    }
}