package hpl.content;

import mindustry.type.SectorPreset;

import static hpl.content.HPLPlanets.auriona;

public class HPLSectorPreset {
    public static SectorPreset
            abandonedShoreline, caveEntrance;

    //testshitcomment
    public static void load(){
        abandonedShoreline = new SectorPreset("abandoned-shoreline", auriona, 15){{
            alwaysUnlocked = true;
            difficulty = 1;
            captureWave = 10;
            startWaveTimeMultiplier = 3f;
        }};

        caveEntrance = new SectorPreset("cave-entrance", auriona, 22) {{
            alwaysUnlocked = false;
            difficulty = 2;
            captureWave = 15;
            startWaveTimeMultiplier = 2.75f;
        }};
    }
}
