# EvolutionSimulation

## Project Overview
**EvolutionSimulation** is a Java-based simulation that visualizes a population of particles evolving towards a target. This simulation demonstrates genetic algorithms, where each generation of particles adapts based on "fitness" — the proximity to a defined target. The project displays **genetic evolution**, **mutation**, and **natural selection** principles.

## Features
- **Population Management:** Each particle in the simulation has its own DNA, and populations evolve over time.
- **Mutation and Natural Selection:** Based on their fitness, particles adapt across generations.
- **Target Interaction:** Users can change the target location with a mouse click.
- **Visual Output:** The simulation displays particles moving toward the target, resetting each generation to visualize evolution.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/griffing52/EvolutionSimulation.git
2.  Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3.  Ensure you have Java Development Kit (JDK) 11 or higher installed.

Usage
-----

1.  Run the `Display` class. This initializes a GUI window to display the simulation.
2.  Use your mouse to click on the window and relocate the target position. Particles will attempt to reach this new target in subsequent generations.

Class Structure
---------------

### Display.java

-   **Purpose:** Handles GUI display, initializes the simulation, and manages target location.
-   **Key Attributes:**
    -   `fps` - Frames per second for rendering.
    -   `lifespan` - Lifespan of each particle.
    -   `popSize` - Number of particles in each population.
    -   `WIDTH` and `HEIGHT` - Simulation window dimensions.
-   **Key Methods:**
    -   `paint(Graphics g)` - Renders each frame of the simulation.
    -   `main(String[] args)` - Main method to run the simulation.

### Population.java

-   **Purpose:** Manages a population of particles and their evolution.
-   **Key Attributes:**
    -   `particles` - Array of particles in the current population.
    -   `age` - Current age of the population within a generation.
    -   `generation` - Tracks the generation count.
-   **Key Methods:**
    -   `run(Graphics2D g)` - Executes each simulation step.
    -   `fillPool()` - Creates a mating pool based on particle fitness.
    -   `breed()` - Generates the next generation of particles using genetic crossover.
    -   `reset()` - Resets the simulation for a new generation.

Controls
--------

-   **Mouse Click:** Relocate the target.

Customization
-------------

To modify parameters:

-   Adjust `fps`, `lifespan`, or `popSize` in `Display.java` to control simulation speed, particle lifespan, and population size.

1.  Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
2.  Ensure you have Java Development Kit (JDK) 11 or higher installed.

Usage
-----

1.  Run the `Display` class. This initializes a GUI window to display the simulation.
2.  Use your mouse to click on the window and relocate the target position. Particles will attempt to reach this new target in subsequent generations.

Class Structure
---------------

### Display.java

-   **Purpose:** Handles GUI display, initializes the simulation, and manages target location.
-   **Key Attributes:**
    -   `fps` - Frames per second for rendering.
    -   `lifespan` - Lifespan of each particle.
    -   `popSize` - Number of particles in each population.
    -   `WIDTH` and `HEIGHT` - Simulation window dimensions.
-   **Key Methods:**
    -   `paint(Graphics g)` - Renders each frame of the simulation.
    -   `main(String[] args)` - Main method to run the simulation.

### Population.java

-   **Purpose:** Manages a population of particles and their evolution.
-   **Key Attributes:**
    -   `particles` - Array of particles in the current population.
    -   `age` - Current age of the population within a generation.
    -   `generation` - Tracks the generation count.
-   **Key Methods:**
    -   `run(Graphics2D g)` - Executes each simulation step.
    -   `fillPool()` - Creates a mating pool based on particle fitness.
    -   `breed()` - Generates the next generation of particles using genetic crossover.
    -   `reset()` - Resets the simulation for a new generation.

Controls
--------

-   **Mouse Click:** Relocate the target.

Customization
-------------
-   Adjust `fps`, `lifespan`, or `popSize` in `Display.java` to control simulation speed, particle lifespan, and population size.

To modify parameters:Example Code Snippet
--------------------

java`// Initialize display and start simulation
JFrame frame = new JFrame("Evolution Simulation");
Display display = new Display();
frame.add(display);
frame.setSize(Display.WIDTH, Display.HEIGHT);
frame.setVisible(true);`

License
-------

Distributed under the MIT License. See `LICENSE` for more information.
