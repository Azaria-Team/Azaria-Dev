package hpl.entities.entity;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import hpl.entities.units.DroneUnitType;
import hpl.world.draw.Blade;
import hpl.world.draw.Rotor;
import mindustry.content.Fx;
import mindustry.gen.UnitEntity;

public class DroneUnitEntity extends UnitEntity {
    public Rotor.RotorMount[] rotors;
    public float rotSpeedScl = 1f;

    @Override
    public void add(){
        DroneUnitType type = (DroneUnitType)this.type;

        rotors = new Rotor.RotorMount[type.rotors.size];
        for (int i = 0; i < rotors.length; i++) {
            Rotor rotorType = type.rotors.get(i);
            rotors[i] = new Rotor.RotorMount(rotorType);
        }
    }

    @Override
    public void update() {
        super.update();
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

        for (Rotor.RotorMount rotor : rotors) {
            rotor.rotorRot += ((rotor.rotor.rotorSpeed * rotSpeedScl) + rotor.rotor.minimumRotorSpeed) * Time.delta;
        }
        type.fallSpeed = 0.006f;
    }
}

