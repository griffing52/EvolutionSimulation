import java.awt.Graphics2D;
import java.util.ArrayList;

public class Population {
    public Particle[] particles;

    public int age = 0;
	public int generation = 1;

    private int lifespan;
    private int size;
    private Target target;

    private ArrayList<Particle> matingPool;

    public Population(int _size, int _lifespan, Target _target) {
        lifespan = _lifespan;
        size = _size;
        target = _target;
        particles = new Particle[size];
        for (int i = 0; i < size; i++) {
            particles[i] = new Particle(lifespan);
            particles[i].applyForce(Vector.random());
        }
        matingPool = new ArrayList<Particle>();
    }
    
    public void run(Graphics2D g) {
        if (age >= lifespan)
            reset();
        for (Particle particle: particles) {
            if (!particle.finished && !particle.dead) {
                particle.applyForce(particle.dna.genes[age]);
            }
            particle.update();
            particle.edges(target, age);
            particle.show(g);
        }
        age++;
    }

    private void fillPool() {
        int finishers = 0;
        int deads = 0;
        for (Particle particle: particles) {
            for (int i = 0; i < particle.getCost(target.CENTER)*10; i++) {
                matingPool.add(particle);
            }
            if (particle.finished) finishers++;
            if (particle.dead) deads++;
        }
        System.out.println(finishers + " finished and " + deads + " died this generation");
    }
    
    private void breed() {
        Particle[] _particles = particles.clone();
        for (int i = 0; i < size; i++) {
            Particle a = matingPool.get((int) (Math.random() * matingPool.size())); // parent a
            Particle b = matingPool.get((int) (Math.random() * matingPool.size())); // parent b
            DNA cDNA = a.dna.crossover(b.dna); // child DNA
            Particle child = new Particle(lifespan);
            // child.averageColor(a.r, a.g, a.b, b.r, b.g, b.b);
            child.adoptColor(a, b);
            child.dna.setSpeed(cDNA.speed).setGenes(cDNA.genes);
            _particles[i] = child;
        }
        particles = _particles;
        matingPool.clear();
    }

    private void reset() {
        age = 0;
        generation++;
        System.out.println("Generation: " + generation);
        fillPool();
        breed();
        // for (Particle particle: particles) {
        //     particle.stop();
        //     particle.pos.set(200, 10);
        // }
    }
}
