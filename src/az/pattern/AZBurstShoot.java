package az.pattern;

import mindustry.entities.pattern.ShootPattern;
import java.util.Random;

public class AZBurstShoot extends ShootPattern {
    protected int burstRange = 1;
    int a;
    protected int burstOffset = 1;

    /** burst fire random interval setter. only unsigned values! */
    public void burstFireInterval(int from, int to) {
        burstRange = 1 + to - from;
        burstOffset = from;

        //(from - to) -> (range, offset)
    }

    public AZBurstShoot(int from, int to, float shotDelay) {
        burstFireInterval(from, to);
        this.shotDelay = shotDelay;
    }

    @Override
    public void shoot(int totalShots, ShootPattern.BulletHandler handler) {
        Random randNum = new Random();

        for (int i = 1; i <= randNum.nextInt(burstRange) + burstOffset; i++) {
            //TODO fix the delay
            handler.shoot(0, 0, 0, firstShotDelay + shotDelay * i);
        }
    }
}
