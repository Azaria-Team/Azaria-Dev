package az.world.blocks.environment;

import arc.graphics.g2d.Draw;
import mindustry.Vars;
import mindustry.graphics.Layer;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.OverlayFloor;

public class UndergroundOre extends OverlayFloor {
    public boolean shouldDrawBase = false;

    public UndergroundOre(String name) {
        super(name);
        //hide an ore from the minimap
        useColor = false;
        playerUnmineable = true;
        variants = 1;
    }
    @Override
    public void drawBase(Tile tile) {
        if (shouldDrawBase || Vars.state.isEditor()) {
            float l = Draw.z();
            Draw.z(Layer.light);

            super.drawBase(tile);

            Draw.z(l);
        }
    }

    @Override
    public String getDisplayName(Tile tile) {
        return null;
    }
}
