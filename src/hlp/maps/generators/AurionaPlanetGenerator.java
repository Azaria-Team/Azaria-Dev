package hlp.maps.generators;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.struct.ObjectMap;
import arc.util.Tmp;
import arc.util.noise.Noise;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import hlp.content.HLPBlocks;
import mindustry.content.Blocks;
import mindustry.graphics.g3d.PlanetGrid;
import mindustry.maps.generators.BaseGenerator;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.TileGen;

public class AurionaPlanetGenerator extends PlanetGenerator {
    Block[][] arr =
            {
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.crabStone, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.seaSerrid, HLPBlocks.seaSerrid, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.forsite, HLPBlocks.seaSerrid, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.crabStone, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor}
            };

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, 8, 0.7f, 1f, position.x, position.y, position.z);
    }
    
    @Override
    public float getHeight(Vec3 position){
        return 0;
    }
    @Override
    
    public Color getColor(Vec3 position) {
        Block block = getBlock(position);

        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }

    @Override
    public void genTile(Vec3 position, TileGen tile){
        tile.floor = getBlock(position);
        tile.block = tile.floor.asFloor().wall;

        if(Ridged.noise3d(seed + 1, position.x, position.y, position.z, 2, 22) > 0.31){
            tile.block = Blocks.air;
        }
    }

    Block getBlock(Vec3 position){
        float height = rawHeight(position);
        Tmp.v31.set(position);
        position = Tmp.v33.set(position).scl(2f);
        float temp = Simplex.noise3d(seed, 8, 0.6, 1f/2f, position.x, position.y + 99f, position.z);
        height *= 1.2f;
        height = Mathf.clamp(height);

        //float tar = (float)noise.octaveNoise3D(4, 0.55f, 1f/2f, position.x, position.y + 999f, position.z) * 0.3f + Tmp.v31.dst(0, 0, 1f) * 0.2f;

        return arr[Mathf.clamp((int)(temp * arr.length), 0, arr[0].length - 1)][Mathf.clamp((int)(height * arr[0].length), 0, arr[0].length - 1)];
    }

    @Override
    protected float noise(float x, float y, double octaves, double falloff, double scl, double mag){
        Vec3 v = sector.rect.project(x, y).scl(5f);
        return Simplex.noise3d(seed, octaves, falloff, 1f / scl, v.x, v.y, v.z) * (float)mag;
    }
}
