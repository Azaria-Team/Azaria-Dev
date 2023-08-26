package hpl.maps.generators;


import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import arc.util.noise.Noise;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import hpl.content.HPLBlocks;
import mindustry.content.Blocks;
import mindustry.graphics.g3d.PlanetGrid;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.TileGen;
import hpl.content.HPLLoadouts;

public class AurionaPlanetGenerator extends PlanetGenerator {
    float scl = 7f;
    float waterOffset = 0.07f;

    {
    defaultLoadout = HPLLoadouts.basicLegion;
    }

    Block[][] arr =
            {
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.serridDust, HPLBlocks.serridicRock, HPLBlocks.serridicRock, HPLBlocks.crabStone, HPLBlocks.forsite},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.serridDust, HPLBlocks.serridicRock, HPLBlocks.huitaRock, HPLBlocks.crabStone, HPLBlocks.crabStone},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.huitaRock, HPLBlocks.crabStone, HPLBlocks.forsite, HPLBlocks.forsite},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.forenite, HPLBlocks.fir, HPLBlocks.forenite, HPLBlocks.forenite},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.forenite, HPLBlocks.forsite, HPLBlocks.forsite, HPLBlocks.fir},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.forenite, HPLBlocks.fir, HPLBlocks.fir, HPLBlocks.fir},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.forsite, HPLBlocks.forenite, HPLBlocks.forenite, HPLBlocks.forenite},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.darkSerridOxylite, HPLBlocks.darkSerrid, HPLBlocks.lamprosMineral, HPLBlocks.lamprosMineral, HPLBlocks.crystalIce, HPLBlocks.crystalIce},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.darkSerridOxylite, HPLBlocks.darkSerrid, HPLBlocks.lamprosMineral, HPLBlocks.forsite, HPLBlocks.lamprosMineral, HPLBlocks.crystalIce},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.darkSerridOxylite, HPLBlocks.darkSerrid, HPLBlocks.forsite, HPLBlocks.crystalIce, HPLBlocks.crystalIce, HPLBlocks.crystalIce},
            };
    /*
    Block[][] arr =
            {
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.serridicRock, HPLBlocks.serridDust, HPLBlocks.crabStone, HPLBlocks.crabStone, HPLBlocks.crabStone},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.forenite, HPLBlocks.serridicRock, HPLBlocks.serridDust, HPLBlocks.crabStone, HPLBlocks.forenite},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridOxylite, HPLBlocks.huitaRock, HPLBlocks.forenite, HPLBlocks.fir, HPLBlocks.serridicRock, HPLBlocks.crabStone, HPLBlocks.forenite},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.serridOxylite, HPLBlocks.forenite, HPLBlocks.forenite, HPLBlocks.forenite, HPLBlocks.serridDust, HPLBlocks.crabStone, HPLBlocks.fir},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.serridDust, HPLBlocks.fir, HPLBlocks.fir, HPLBlocks.forsite, HPLBlocks.serridDust, HPLBlocks.serridDust},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.serridOxylite, HPLBlocks.fir, HPLBlocks.fir, HPLBlocks.fir, HPLBlocks.serridicRock, HPLBlocks.serridicRock, HPLBlocks.serridicRock},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.serridDust, HPLBlocks.darkSerrid, HPLBlocks.darkSerrid, HPLBlocks.fir, HPLBlocks.huitaRock, HPLBlocks.huitaRock},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.serridOxylite, HPLBlocks.serridDust, HPLBlocks.forsite, HPLBlocks.fir, HPLBlocks.huitaRock, HPLBlocks.fir},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.darkSerrid, HPLBlocks.forsite, HPLBlocks.forsite, HPLBlocks.forenite, HPLBlocks.forenite, HPLBlocks.forenite},
                    {HPLBlocks.deepOxylite, HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.darkSerrid, HPLBlocks.darkSerrid, HPLBlocks.forsite, HPLBlocks.forenite, HPLBlocks.fir},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.serridDust, HPLBlocks.forsite, HPLBlocks.crystalIce, HPLBlocks.darkSerrid, HPLBlocks.darkSerrid, HPLBlocks.darkSerrid},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.lamprosMineral, HPLBlocks.lamprosMineral, HPLBlocks.lamprosMineral, HPLBlocks.darkSerrid, HPLBlocks.darkSerrid, HPLBlocks.crystalIce},
                    {HPLBlocks.deepOxylite, HPLBlocks.oxylite, HPLBlocks.oxylite, HPLBlocks.lamprosMineral, HPLBlocks.crystalIce, HPLBlocks.crystalIce, HPLBlocks.crystalIce, HPLBlocks.crystalIce, HPLBlocks.crystalIce}
            };


     */
    float water = 5f / arr[0].length;

    float rawHeight(Vec3 position){
        position = Tmp.v33.set(position).scl(scl);
        return (Mathf.pow(Simplex.noise3d(seed, 7, 0.5f, 1f/3f, position.x, position.y, position.z), 2.3f) + waterOffset) / (1f + waterOffset);
    }

    @Override
    public void generateSector(Sector sector){

        //these always have bases
        if(sector.id == 154 || sector.id == 0){
            sector.generateEnemyBase = true;
            return;
        }

        PlanetGrid.Ptile tile = sector.tile;

        boolean any = false;
        float poles = Math.abs(tile.v.y);
        float noise = Noise.snoise3(tile.v.x, tile.v.y, tile.v.z, 0.001f, 0.58f);

        if(noise + poles/7.1 > 0.12 && poles > 0.23){
            any = true;
        }

        if(noise < 0.16){
            for(PlanetGrid.Ptile other : tile.tiles){
                var osec = sector.planet.getSector(other);

                //no sectors near start sector!
                if(
                        osec.id == sector.planet.startSector || //near starting sector
                                osec.generateEnemyBase && poles < 0.85 || //near other base
                                (sector.preset != null && noise < 0.11) //near preset
                ){
                    return;
                }
            }
        }

        sector.generateEnemyBase = any;
    }
    
    @Override
    public float getHeight(Vec3 position){
        float height = rawHeight(position);
        return Math.max(height, water);
    }
    @Override
    
    public Color getColor(Vec3 position) {
        Block block = getBlock(position);

        if(block == HPLBlocks.crystalIce) return Color.valueOf("f6e9ff");
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

        //float tar = (float)noise.octaveNoise3D(4, 0.55f, 1f/2f, position.x, position.y + 999f, position.z) * 0.3f + Tmp.v31.dst(0, 0, 1f) * 0.2f;

        return arr[Mathf.clamp((int)(temp * arr.length), 0, arr[0].length - 1)][Mathf.clamp((int)(height * arr[0].length), 0, arr[0].length - 1)];
    }

    @Override
    protected float noise(float x, float y, double octaves, double falloff, double scl, double mag){
        Vec3 v = sector.rect.project(x, y).scl(5f);
        return Simplex.noise3d(seed, octaves, falloff, 1f / scl, v.x, v.y, v.z) * (float)mag;
    }
}
