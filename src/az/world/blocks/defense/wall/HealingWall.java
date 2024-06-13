package az.world.blocks.defense.wall;

import mindustry.world.blocks.defense.Wall;

public class HealingWall extends Wall {
    public float healAmount = 1f;
    public HealingWall(String name) {
        super(name);
        update = true;
        hasLiquids = true;
    }

    public class AZHealWallBuild extends WallBuild {

        @Override
        public void updateTile() {
            super.updateTile();
            heal(healAmount * delta());
        }
    }
}
