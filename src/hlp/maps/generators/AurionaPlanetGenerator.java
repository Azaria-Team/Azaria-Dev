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
    //alternate, less direct generation (wip)
    float scl = 5f;
    float waterOffset = 0.07f;
    Block[][] arr =
            {
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.seaSerrid, HLPBlocks.seaSerrid, HLPBlocks.seaSerrid, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.crabStone, HLPBlocks.forsite, HLPBlocks.seaSerrid, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.seaSerrid, HLPBlocks.mainlFloor, HLPBlocks.serridDust, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.seaSerrid, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor},
                    {HLPBlocks.mainlDeepFloor, HLPBlocks.crabStone, HLPBlocks.crabStone, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor},
                    {HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlDeepFloor, HLPBlocks.mainlFloor, HLPBlocks.mainlFloor}
            };

    float water = 2f / arr[0].length;

    ObjectMap<Block, Block> tars = ObjectMap.of(
            HLPBlocks.fir, HLPBlocks.forsite,
            HLPBlocks.forenite, HLPBlocks.forsite
    );

    float rawHeight(Vec3 position){
        position = Tmp.v33.set(position).scl(scl);
        return (Mathf.pow(Simplex.noise3d(seed, 7, 0.5f, 1f/3f, position.x, position.y, position.z), 2.3f) + waterOffset) / (1f + waterOffset);
    }

    @Override
    public float getHeight(Vec3 position){
        float height = rawHeight(position);
        return Math.max(height, water);
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
        position = Tmp.v33.set(position).scl(scl);
        float rad = scl;
        float temp = Mathf.clamp(Math.abs(position.y * 2f) / (rad));
        float tnoise = Simplex.noise3d(seed, 7, 0.56, 1f/3f, position.x, position.y + 999f, position.z);
        temp = Mathf.lerp(temp, tnoise, 0.5f);
        height *= 1.2f;
        height = Mathf.clamp(height);

        float tar = Simplex.noise3d(seed, 4, 0.55f, 1f/2f, position.x, position.y + 999f, position.z) * 0.3f + Tmp.v31.dst(0, 0, 1f) * 0.2f;

        Block res = arr[Mathf.clamp((int)(temp * arr.length), 0, arr[0].length - 1)][Mathf.clamp((int)(height * arr[0].length), 0, arr[0].length - 1)];
        if(tar > 0.5f){
            return tars.get(res, res);
        }else{
            return res;
        }
    }

    @Override
    protected float noise(float x, float y, double octaves, double falloff, double scl, double mag){
        Vec3 v = sector.rect.project(x, y).scl(5f);
        return Simplex.noise3d(seed, octaves, falloff, 1f / scl, v.x, v.y, v.z) * (float)mag;
    }
}
