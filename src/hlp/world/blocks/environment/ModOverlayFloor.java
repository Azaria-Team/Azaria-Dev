package hlp.world.blocks.environment;

import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

public class ModOverlayFloor extends Floor{
    public int variants = 2;

        public ModOverlayFloor(String name){
            super(name);
            useColor = false;
        }

        @Override
        public void drawBase(Tile tile){
            Draw.rect(variantRegions[Mathf.randomSeed(tile.pos(), 0, Math.max(0, variantRegions.length - variants))], tile.worldx(), tile.worldy());
        }
}
