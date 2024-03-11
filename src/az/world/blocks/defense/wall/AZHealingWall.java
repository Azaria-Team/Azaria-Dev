package az.world.blocks.defense.wall;

import mindustry.type.Liquid;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.consumers.ConsumeLiquid;


public class AZHealingWall extends Wall {
    /** amount of health regeneration at a time*/
    public float healAmount = 1f;
    public AZHealingWall(String name) {
        super(name);
        update = true;
        hasLiquids = true;
    }

    @Override
    public ConsumeLiquid consumeLiquid(Liquid liquid, float amount) {
        if(newBuilding().health < newBuilding().maxHealth) {
            return super.consumeLiquid(liquid, amount);
        }
        return super.consumeLiquid(liquid, 0);
    }

    public class AZHealWallBuild extends WallBuild {

        @Override
        public void updateTile() {
            super.updateTile();

            if (health < maxHealth) {
                float liq = liquids.currentAmount();
                if (liq > 0) {
                    heal(healAmount * delta() * (liq / liquidCapacity));
                }
            }
        }
        //
    }
}
