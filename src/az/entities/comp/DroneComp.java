package az.entities.comp;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import az.content.AZUnits;
import az.entities.units.DroneUnitType;
import az.world.draw.Rotor;
import az.world.draw.Rotor.RotorMount;
import ent.anno.Annotations;
import mindustry.content.Fx;
import mindustry.entities.EntityCollisions;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;

@Annotations.EntityComponent
abstract class DroneComp implements Unitc {
    public RotorMount[] rotors;
    public float rotSpeedScl = 1f;
    @Annotations.Import
    UnitType type;
    @Annotations.Import boolean dead;
    @Annotations.Import float health, rotation;
    @Annotations.Import int id;
    @Annotations.Import
    float x,y;
    /** @author GlennFolker#6881 */
    @Override
    public void add(){
        DroneUnitType type = (DroneUnitType)this.type;

        rotors = new RotorMount[type.rotors.size];
        for(int i = 0; i < rotors.length; i++){
            Rotor rotor = type.rotors.get(i);
            rotors[i] = new RotorMount(rotor);
        }
    }

    @Override
    public void update() {
        DroneUnitType type = (DroneUnitType) this.type;
        float rX = x + Angles.trnsx(rotation - 90, type.fallSmokeX, type.fallSmokeY);
        float rY = y + Angles.trnsy(rotation - 90, type.fallSmokeX, type.fallSmokeY);

        // Slows down rotor when dying
        if (dead || health() <= 0) {
            rotation += Time.delta * (type.spinningFallSpeed * vel().len()) * Mathf.signs[id % 2];
            if (Mathf.chanceDelta(type.fallSmokeChance)) {
                Fx.fallSmoke.at(rX, rY);
                Fx.burning.at(rX, rY);
            }
            rotSpeedScl = Mathf.lerpDelta(rotSpeedScl, 0f, type.rotorDeathSlowdown);
        } else {
            rotSpeedScl = Mathf.lerpDelta(rotSpeedScl, 1f, type.rotorDeathSlowdown);
        }

        for (RotorMount rotor : rotors) {
            rotor.rotorRot += ((rotor.rotor.rotorSpeed * rotSpeedScl) + rotor.rotor.minimumRotorSpeed) * Time.delta;
        }
        type.fallSpeed = 0.006f;
    }
}

