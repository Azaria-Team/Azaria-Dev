package hlp.world.blocks.environment;

import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import mindustry.content.Blocks;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

import static mindustry.Vars.tilesize;

public class ModOverlayFloor extends Floor{
    public Block parent = Blocks.air;

        public ModOverlayFloor(String name){
            super(name);
            useColor = false;
        }

    @Override
    public void drawBase(Tile tile){
        parent.drawBase(tile);

            Mathf.rand.setSeed(tile.pos());
            Draw.rect(variantRegions[Mathf.randomSeed(tile.pos(), 0, Math.max(0, variantRegions.length - 1))], tile.worldx() - tilesize, tile.worldy() - tilesize);
        }
}
