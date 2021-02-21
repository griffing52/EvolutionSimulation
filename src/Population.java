import java.awt.Graphics2D;
import java.util.ArrayList;

public class Population {
    public Particle[] particles;

    public int age = 0;
	public int generation = 1;

    private int lifespan;
    private int size;
    private Target target;

    private ArrayList<DNA> matingPool;

    public Population(int _size, int _lifespan, Target _target) {
        lifespan = _lifespan;
        size = _size;
        target = _target;
        particles = new Particle[size];
        for (int i = 0; i < size; i++) {
            particles[i] = new Particle(lifespan);
            particles[i].applyForce(Vector.random());
        }
        matingPool = new ArrayList<DNA>();
    }
    
    public void run(Graphics2D g) {
        if (age >= lifespan)
            reset();
        for (Particle particle: particles) {
            particle.applyForce(particle.dna.genes[age]);
            particle.update();
            particle.edges(target);
            particle.show(g);
        }
        age++;
    }

    private void fillPool() {
        for (Particle particle: particles) {
            for (int i = 0; i < particle.getCost(target.CENTER)*10; i++) {
                matingPool.add(particle.dna);
            }
        }
    }
    
    private void breed() {
        Particle[] _particles = particles.clone();
        for (int i = 0; i < size; i++) {
            DNA pA = matingPool.get((int) (Math.random() * matingPool.size())); // parent a
            DNA pB = matingPool.get((int) (Math.random() * matingPool.size())); // parent b
            DNA cDNA = pA.crossover(pB); // child DNA
            Particle child = new Particle(lifespan);
            child.dna.setSpeed(cDNA.speed).setGenes(cDNA.genes);
            _particles[i] = child;
        }
        particles = _particles;
        matingPool.clear();
    }

    private void reset() {
        age = 0;
        generation++;
        System.out.println(generation);
        fillPool();
        breed();
        // for (Particle particle: particles) {
        //     particle.stop();
        //     particle.pos.set(200, 10);
        // }
    }
}
