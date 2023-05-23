package hlp.utils;

import arc.math.geom.Vec2;
import mindustry.type.Item;

public class Utils {

    public interface Targeting {
        default Vec2 targetPos(){
            return null;
        }
    }
}
