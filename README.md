# CoffeeMaker System

## Overview

The CoffeeMaker system is a Java-based application that simulates the functionality of a coffee machine. It is designed as a modular system with several submodules, including `BeanTray`, `ServeTray`, and `Display`. Each submodule performs specific tasks and includes an availability check method that throws a custom exception in case of errors. The system allows users to make coffee, refill the bean tray, place a cup on the serve tray, and check the status of the coffee maker.

# Usage
## Using .jar file

1. **Build maven project**: `mvn clean package`
2. **Run the project**:
   Run the JAR file with: `java -jar target/*.jar`
3. **Interact with the Menu**:
    - **Option 1**: Make a coffee.
    - **Option 2**: Fill the bean tray.
    - **Option 3**: Place a cup on the serve tray.
    - **Option 4**: Shut down the coffee machine.

## Docker
The CoffeeMaker system can be containerized using Docker. This allows for easy deployment and consistent environments across different systems.

To build and run the Docker image locally, follow these steps:

1. **Build maven project**: `mvn clean package`

2. **Build the Docker Image**: `docker build -t coffeemaker .`

3. **Run the Docker Container**: `docker run -it coffeemaker`

This will start the CoffeeMaker application inside the Docker container so that you can interact with it.
## Example Workflow

1. **Start the Coffee Maker**: Start the application.
2. **Place a Cup**: Select option 3 to place a cup on the serve tray.
3. **Make Coffee**: Select option 1 to make a coffee. If the bean tray is empty, you will be prompted to refill it.
4. **Refill Bean Tray**: Select option 2 to refill the bean tray.
5. **Check Status**: The system will display the current status of the bean tray and serve tray after each action.
6. **Shut Down**: Select option 4 to shut down the coffee maker.



## GitHub Actions Workflow
The project includes a GitHub Actions workflow to automate the build, test, and Docker image push process. 
The workflow is triggered when a new tag is pushed to the repository.

You can find the built artifacts under this [link](ghcr.io/aradidaniel/coffeemaker).


