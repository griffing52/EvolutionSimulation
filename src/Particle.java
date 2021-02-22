import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class Particle {
    // private static int width = 1, height = 1;
    public Vector pos = new Vector(200, 10);
    public Vector acc = new Vector(0, 0);
    public Vector vel = new Vector(0, 0);

    public DNA dna;
    public int r, g, b;

    public boolean dead = false;
    public boolean finished = false;
    public int timeToFinish = 0;

    public float cost = 0;

    public Particle(int lifespan) {
        dna = new DNA(lifespan);
        r = (int) (Math.random()*255);
        g = (int) (Math.random()*255);
        b = (int) (Math.random()*255);
    }

    public void averageColor(int Ar, int Ag, int Ab, int Br, int Bg, int Bb) {
        r = (int) Math.floor((Ar + Br) * 0.5);
        g = (int) Math.floor((Ag + Bg) * 0.5);
        b = (int) Math.floor((Ab + Bb) * 0.5);
    }

    public void adoptColor(Particle a, Particle _b) {
        Particle dominant = (Math.random() < 0.5) ? a : _b;
        r = dominant.r;
        g = dominant.g;
        b = dominant.b;
    }

    public void update() {
        vel.add(acc);
        pos.add(vel);
        acc.mult(0);
    }

    public void edges(Target target, int age) {
        if (pos.x > Display.WIDTH || pos.x < 0 || pos.y > Display.HEIGHT || pos.y < 0) {
            dead = true;
            stop();
        }
        if (pos.x >= target.x && pos.x <= target.x + target.length && pos.y >= target.y && pos.y <= target.y + target.height) {
            finished = true;
            timeToFinish = age;
            stop();
        }
    }

    public void stop() {
        acc.mult(0);
        vel.mult(0);
    }

    public void applyForce(Vector force) {
        acc.add(force);
    }

    public float getCost(Vector target) {
        float modifier = (finished) ? 2 : (dead) ? 0.5f : 1;
        float cost = (float) (1 / Math.pow(Math.sqrt(Math.pow(pos.x-target.x, 2) + Math.pow(pos.y - target.y, 2)), modifier));
        // System.out.println(cost);
        return cost + (float) (0.5 * timeToFinish); //TODO fix
    }
    
    public void show(Graphics2D _g) {
        // g.fillOval((int) pos.x, (int) pos.y, Particle.width, Particle.height);
        Color c = new Color(r, g, b);
        // System.out.println(c.toString());
        _g.setColor(c);
        _g.setStroke(new BasicStroke(5));
        _g.drawLine((int) pos.x, (int) pos.y, (int) pos.x, (int) pos.y);
    }
}
