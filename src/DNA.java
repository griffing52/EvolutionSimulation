public class DNA {
    public float speed;
    public Vector[] genes;
    public int lifespan;

    private static float maxSpeed = 0.15f; 
    private static float minSpeed = 0.06f; 

    public DNA(int _lifespan) {
        lifespan = _lifespan;
        speed = (float) (Math.random()*(maxSpeed-minSpeed))+minSpeed;
        genes = new Vector[_lifespan];
        for (int i = 0; i < _lifespan; i++) {
            genes[i] = Vector.random();
            genes[i].mult(speed);
        }
    }
    public DNA setSpeed(float _speed) {
        speed = _speed;
        return this;
    }
    public DNA setGenes(Vector[] _genes) {
        genes = _genes;
        return this;
    }
    public DNA crossover(DNA mate) {
        DNA newDNA = new DNA(lifespan);
        Vector[] _genes = newDNA.genes.clone(); 

        double seed = Math.random();
        int split = (int)  (seed * genes.length);
         
        float _speed = (seed < 1/3) ? speed : (seed < 2/3) ? mate.speed : newDNA.speed; 

        for (int i = 0; i < genes.length; i++) {
            if (!mutation())
                _genes[i] = (i > split) ? genes[i] : mate.genes[i];
        }
        return newDNA.setGenes(_genes).setSpeed(_speed);
    }

    public boolean mutation() {
        return Math.random() < 0.005;
    }
}
