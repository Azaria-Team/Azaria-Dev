package hlp.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Vec2;
import arc.struct.Seq;
import hlp.graphics.HLPPal;
import mindustry.entities.Effect;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;

public class HLPFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static final Effect

    explosionSmall = new Effect(30, e -> {
        color(HLPPal.vogPink);
        e.scaled(7, i -> {
            stroke(3f * i.fout());
            Lines.circle(e.x, e.y, 3f + i.fin() * 10f);
        });

        color(HLPPal.vogPink);

        randLenVectors(e.id, 7, 2f + 19f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
        });

        color(HLPPal.vogPink, HLPPal.vogPinkBack, Color.pink, e.fin());
        stroke(1.5f * e.fout());

        randLenVectors(e.id + 1, 8, 1f + 23f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
        });
    }),

    explosionSmall2 = new Effect(20, e -> {
        color(HLPPal.vogPink);
        e.scaled(8, i -> {
            stroke(2f * i.fout());
            Lines.circle(e.x, e.y, 2f + i.fin() * 5f);
        });

        color(HLPPal.vogPink, HLPPal.vogPinkBack, Color.pink, e.fin());
        stroke(1.01f * e.fout());

        randLenVectors(e.id + 1, 4, 1f + 16 * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 2f);
        });
    }),

    vogTrail = new Effect(15, e -> {
        color(HLPPal.vogPink, HLPPal.vogPinkBack, e.fin());
        stroke(0.3f + e.fout() * 0.7f);
        rand.setSeed(e.id);

        for(int i = 0; i < 1; i++){
            float rot = e.rotation + rand.range(10f) + 180f;
            v.trns(rot, rand.random(e.fin() * 18f));
            lineAngle(e.x + v.x, e.y + v.y, rot, e.fout() * rand.random(1f, 4f) + 1f);
        }
    }),

    paimMissileTrail = new Effect(20f, 50f, e -> {
        color(HLPPal.vogPink, HLPPal.vogPinkBack, Color.pink,  e.fin() * e.fin());

        randLenVectors(e.id, 4, 1f + e.finpow() * 15, e.rotation + 180, 7f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.30f + e.fout() * 1.1f);
        });
    });

    public static void lightning(float x1, float y1, float x2, float y2, Color c, int iterations, float rndScale, Effect e) {
        Seq<Vec2> lines = new Seq<>();
        boolean swap = Math.abs(y1 - y2) < Math.abs(x1 - x2);
        if(swap) {
            lines.add(new Vec2(y1, x1));
            lines.add(new Vec2(y2, x2));
        } else {
            lines.add(new Vec2(x1, y1));
            lines.add(new Vec2(x2, y2));
        }
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < lines.size - 1; j += 2) {
                Vec2 v1 = lines.get(j), v2 = lines.get(j + 1);
                Vec2 v = new Vec2((v1.x + v2.x) / 2, ((v1.y + v2.y) / 2));
                float ang = (v2.angle(v1) + 90f) * Mathf.degRad;
                float sin = Mathf.sin(ang), cos = Mathf.cos(ang);
                float rnd = Mathf.random(rndScale);
                v.x += rnd * sin;
                v.y += rnd * cos;
                lines.insert(j + 1, v);
            }
        }
        if(swap) {
            for(int i = 0; i < lines.size; i++) {
                Vec2 v = lines.get(i);
                float px = v.x;
                v.x = v.y;
                v.y = px;
            }
        }
        e.at(x1, y1, 0f, c, lines);
    }
}
