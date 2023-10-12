package hpl.world.blocks.environment;

import arc.graphics.g2d.Draw;
import mindustry.Vars;
import mindustry.graphics.Layer;
import mindustry.type.Item;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.OreBlock;

public class UndergroundOre extends OreBlock {
    public boolean shouldDrawBase = false;

    public UndergroundOre(String name, Item ore) {
        super(name);
        this.itemDrop = ore;
        this.variants = 3;
        //hide an ore from the minimap
        useColor = false;
        playerUnmineable = true;
        variants = 1;
    }
    public UndergroundOre(Item ore){
        this("ore-" + ore.name, ore);

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
    public String getDisplayName(Tile tile){
        return null;
    }
}
