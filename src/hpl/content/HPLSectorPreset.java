package hpl.content;

import mindustry.type.SectorPreset;

import static hpl.content.HPLPlanets.auriona;

public class HPLSectorPreset {
    public static SectorPreset
            abandonedShoreline, caveEntrance, seaOutpost, theOutskirts;

    public static void load(){
        abandonedShoreline = new SectorPreset("abandoned-shoreline", auriona, 15){{
            alwaysUnlocked = true;
            difficulty = 1;
            captureWave = 10;
            startWaveTimeMultiplier = 3f;
        }};

        caveEntrance = new SectorPreset("cave-entrance", auriona, 220) {{
            difficulty = 2;
            captureWave = 15;
            startWaveTimeMultiplier = 2.75f;
        }};

        seaOutpost = new SectorPreset("sea-outpost", auriona, 200) {{
            difficulty = 3;
        }};

        theOutskirts = new SectorPreset("the-outskirts", auriona, 68) {{
            difficulty = 3;
            captureWave = 20;
        }};
    }
}
