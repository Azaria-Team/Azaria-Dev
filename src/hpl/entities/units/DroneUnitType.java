package hpl.entities.units;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.math.Mathf;
import arc.struct.Seq;
import hpl.entities.entity.DroneUnitEntity;
import hpl.entities.entity.StriCopterUnitEntity;
import hpl.world.draw.Rotor;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.graphics.MultiPacker;
import mindustry.type.UnitType;

public class DroneUnitType extends UnitType {
    // Copters.
    public final Seq<Rotor> rotors = new Seq<>();

    public float spinningFallSpeed = 0;
    public float rotorDeathSlowdown = 0.01f;
    public float fallSmokeX = 0f, fallSmokeY = -5f, fallSmokeChance = 0.1f;

    public DroneUnitType(String name) {
        super(name);
        engineSize = 0;
        constructor = DroneUnitEntity::new;
    }
    @Override
    public void drawSoftShadow(Unit unit, float alpha) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        Draw.z(z - 3f);
        super.drawSoftShadow(unit, alpha);
    }

    // Drawing Rotors
    public void drawRotor(Unit unit) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        applyColor(unit);
        if (unit instanceof DroneUnitEntity copter) {
            for (Rotor.RotorMount mount : copter.rotors) {
                Rotor rotor = mount.rotor;
                float rx = unit.x + Angles.trnsx(unit.rotation - 90, rotor.x, rotor.y);
                float ry = unit.y + Angles.trnsy(unit.rotation - 90, rotor.x, rotor.y);
                float rotorScl = Draw.scl * rotor.rotorSizeScl;
                float rotorTopScl = Draw.scl * rotor.rotorTopSizeScl;

                for (int i = 0; i < rotor.bladeCount; i++) {
                    float angle = (i * 360f / rotor.bladeCount + mount.rotorRot) % 360;
                    float blurAngle = (i * 360f / rotor.bladeCount + (mount.rotorRot * rotor.rotorBlurSpeedMultiplier)) % 360;

                    // region Normal Rotor
                    Draw.z(z + rotor.rotorLayer);
                    Draw.alpha(rotor.bladeShadeRegion.found() ? 1 - (copter.rotSpeedScl / 0.8f) : 1);
                    Draw.rect(
                            rotor.bladeOutlineRegion, rx, ry,
                            rotor.bladeOutlineRegion.width * rotorScl,
                            rotor.bladeOutlineRegion.height * rotorScl,
                            angle
                    );
                    Draw.mixcol(Color.white, unit.hitTime);
                    Draw.rect(rotor.bladeRegion, rx, ry,
                            rotor.bladeRegion.width * rotorScl,
                            rotor.bladeRegion.height * rotorScl,
                            angle
                    );
                    // endregion Normal Rotor

                    // Double Rotor
                    if (rotor.doubleRotor) {
                        Draw.rect(
                                rotor.bladeOutlineRegion, rx, ry,
                                rotor.bladeOutlineRegion.width * rotorScl * -Mathf.sign(false),
                                rotor.bladeOutlineRegion.height * rotorScl,
                                -angle
                        );
                        Draw.mixcol(Color.white, unit.hitTime);
                        Draw.rect(rotor.bladeRegion, rx, ry,
                                rotor.bladeRegion.width * rotorScl * -Mathf.sign(false),
                                rotor.bladeRegion.height * rotorScl,
                                -angle
                        );
                    }
                    Draw.reset();

                    // Blur Rotor
                    if (rotor.bladeShadeRegion.found()) {
                        Draw.z(z + rotor.rotorLayer);
                        Draw.alpha(copter.rotSpeedScl * rotor.rotorBlurAlphaMultiplier * (copter.dead() ? copter.rotSpeedScl * 0.5f : 1));
                        Draw.rect(
                                rotor.bladeShadeRegion, rx, ry,
                                rotor.bladeShadeRegion.width * rotorScl,
                                rotor.bladeShadeRegion.height * rotorScl,
                                -blurAngle
                        );

                        // Double Rotor Blur
                        if (rotor.doubleRotor) {
                            Draw.rect(
                                    rotor.bladeShadeRegion, rx, ry,
                                    rotor.bladeShadeRegion.width * rotorScl * -Mathf.sign(false),
                                    rotor.bladeShadeRegion.height * rotorScl,
                                    blurAngle
                            );
                        }
                        Draw.reset();
                    }

                    Draw.reset();

                    // Rotor Top
                    if (rotor.drawRotorTop) {
                        Draw.z(z + rotor.rotorLayer + 0.001f);
                        Draw.rect(
                                rotor.topRegion, rx, ry,
                                rotor.topRegion.width * rotorTopScl,
                                rotor.topRegion.height * rotorTopScl,
                                unit.rotation - 90);
                        Draw.mixcol(Color.white, unit.hitTime);
                        Draw.rect(
                                rotor.topRegion, rx, ry,
                                rotor.topRegion.width * rotorTopScl,
                                rotor.topRegion.height * rotorTopScl,
                                unit.rotation - 90
                        );
                    }
                    Draw.reset();
                }
            }
        }
    }

    @Override
    public void draw(Unit unit) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        super.draw(unit);
        Draw.z(z);
        drawRotor(unit);
    }

    @Override
    public void load() {
        super.load();
        rotors.each(Rotor::load);
    }
}