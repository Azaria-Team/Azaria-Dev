package hpl.world.draw;

import arc.*;
import arc.graphics.g2d.*;
import mindustry.io.*;

/**
 * Defines a rotor type.
 * @author younggam
 * @author GlennFolker
 */
public class Rotor{
    public final String name;

    public TextureRegion bladeRegion, bladeOutlineRegion, rotorShadeRegion, topRegion;


    /** Rotor offsets from the unit */
    public float x = 0f, y = 0f;
    /** Rotor Size Scaling */
    public float rotorSizeScl = 1, rotorTopSizeScl = 1;
    /** Rotor base rotation speed */
    public float rotorSpeed = 12;
    /** Minimum Rotation Speed for rotor, the rotor speed wont go below this value, even when dying */
    public float minimumRotorSpeed = 0f;
    /** On what rotorLayer is the Rotor drawn at */
    public float rotorLayer = 0.5f;
    /** How fast does the blur region rotates, multiplied by default rotatespeed */
    public float rotorBlurSpeedMultiplier = 0.25f;
    /** Multiplier for rotor blurs alpha */
    public float rotorBlurAlphaMultiplier = 0.9f;
    /** Whenever to draw the rotor top sprite */
    public boolean drawRotorTop = false;
    /** Duplicates the initial rotor and spins it on the opposite dirrection */
    public boolean doubleRotor = false;
    /** How many blades generated on the unit */
    public int bladeCount = 4;

    public Rotor(String name){
        this.name = name;
    }

    public void load(){
        bladeRegion = Core.atlas.find(name + "-blade");
        bladeOutlineRegion = Core.atlas.find(name + "-blade-outline");
        rotorShadeRegion = Core.atlas.find(name + "-blade-shade");
        topRegion = Core.atlas.find(name + "-top");
    }

    /** Rotor entities that are mounted in units or other stuff. */
    public static class RotorMount{
        public final Rotor rotor;
        public float rotorRot;
        public float rotorShadeRot;

        public RotorMount(Rotor rotor){
            this.rotor = rotor;
        }
    }
}
