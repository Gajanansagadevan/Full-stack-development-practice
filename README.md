# Full-stack Development Practice

This repository contains practice projects and exercises for full-stack web development, focusing on Java for backend work and HTML for frontend prototypes.

## Contents

- Backend: Java-based projects (may use frameworks like Spring Boot, Jakarta EE, or plain Java). Look for directories such as `src/`, `backend/`, or individual project folders.
- Frontend: Static HTML prototypes and examples. Look for `html/`, `public/`, or standalone `.html` files.

## Tech Stack

- Primary: Java
- Frontend: HTML (static pages)

Other tools that may be used across projects: Maven or Gradle for Java build management, a modern browser for testing HTML, and optional Node.js tooling for frontend workflows.

## Getting Started

These instructions are generic because this repository contains multiple practice projects. Check each project folder for specific build/run instructions.

Prerequisites

- Java JDK 11+ (or the version required by the specific project)
- Maven or Gradle (if the Java projects use one of these build tools)
- A web browser to open HTML files

Run a Java project (Maven)

1. Open a terminal in the project folder that contains a `pom.xml` file.
2. Build: `mvn clean package`
3. Run: `mvn spring-boot:run` (if it's a Spring Boot project) or `java -jar target/your-app.jar`.

Run a Java project (Gradle)

1. Open a terminal in the project folder that contains a `build.gradle` file.
2. Build: `./gradlew build`
3. Run: `./gradlew bootRun` (if applicable) or `java -jar build/libs/your-app.jar`.

Open HTML files

- Open the `.html` file in your browser directly, or serve the folder with a simple static server:
  - Python 3: `python -m http.server 8000` and open `http://localhost:8000`
  - Node (http-server): `npx http-server .`

## Project Structure (example)

- /project-name-backend/  - Java backend project
- /project-name-frontend/ - HTML/CSS/JS frontend files
- /README.md              - This file

Check each top-level folder for its own README or documentation.

## Contributing

Contributions and practice exercises are welcome. If you add a new project, please:

1. Create a folder with a descriptive name.
2. Add a short README inside that folder with specific build/run steps and any prerequisites.
3. Open a pull request describing the new content.

## License

If you want this repository to be under a specific license, add a `LICENSE` file. Otherwise, the repository currently has no explicit license and the default repository settings apply.

## Contact

Created by Gajanan Sagadevan. For questions or suggestions, open an issue or send a pull request.
