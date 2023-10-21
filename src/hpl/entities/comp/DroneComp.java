package hpl.entities.comp;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import hpl.entities.units.DroneUnitType;
import hpl.gen.Dronec;
import hpl.world.draw.Rotor;
import mindustry.annotations.Annotations;
import mindustry.content.Fx;
import mindustry.gen.Unit;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;

@Annotations.Component
public abstract class DroneComp implements Unitc, Dronec {
    public Rotor.RotorMount[] rotors;
    @Annotations.Import
    float x,y,rotation;
    @Annotations.Import
    boolean dead;
    @Annotations.Import
    UnitType type;
    public float rotSpeedScl = 1f;

    @Override
    public void afterRead(){
        setRotors(type);
    }

    @Override
    public void setType(UnitType type) {
        setRotors(type);
    }


    public void setRotors(UnitType type) {
        if (type instanceof DroneUnitType drone) {
            rotors = new Rotor.RotorMount[drone.rotors.size];
            for (int i = 0; i < rotors.length; i++) {
                Rotor rotorType = drone.rotors.get(i);
                rotors[i] = new Rotor.RotorMount(rotorType);
            }
        }
    }

    @Override
    public void update() {
        DroneUnitType type = (DroneUnitType) this.type;
        float rX = x + Angles.trnsx(rotation - 90, type.fallSmokeX, type.fallSmokeY);
        float rY = y + Angles.trnsy(rotation - 90, type.fallSmokeX, type.fallSmokeY);

        // Slows down rotor when dying
        if (dead || health() <= 0) {
            rotation += Time.delta * (type.spinningFallSpeed * vel().len()) * Mathf.signs[type.id % 2];
            if (Mathf.chanceDelta(type.fallSmokeChance)) {
                Fx.fallSmoke.at(rX, rY);
                Fx.burning.at(rX, rY);
            }
            rotSpeedScl = Mathf.lerpDelta(rotSpeedScl, 0f, type.rotorDeathSlowdown);
        } else {
            rotSpeedScl = Mathf.lerpDelta(rotSpeedScl, 1f, type.rotorDeathSlowdown);
        }

        for (Rotor.RotorMount rotor : rotors) {
            rotor.rotorRot += ((rotor.rotor.rotorSpeed * rotSpeedScl) + rotor.rotor.minimumRotorSpeed) * Time.delta;
        }
        type.fallSpeed = 0.006f;
    }
}

