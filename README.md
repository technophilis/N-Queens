### Project Overview
This repo provides a backtracking implementation of the popular N-Queens with an added constraint: no 3 queens should form a straight line at any angle. The implementation relies on a basic chess framework that provides appropriate abstrations for solving chess problems. The framework could be easily extended to include other algorithms for the N-Queens problem or other chess problems.

### Build Without Tests
```
./gradlew clean build -x test
```

### Run Unit Tests
```
./gradlew clean test
```

### Run N-Queens Interactive Backtracking Solver
```
./gradlew run --console=plain
```
Follow the instructions displayed in the console.

### Code Base

#### N-Queens backtracking solver
The `nqueens` package contains the implementation of the N-Queens problem with the constraints described in the project overview.

#### Chess Problem Framework
The project uses the MVC design pattern so it contains 3 main packages:
- `model`: basic abstraction of a chess board
- `view`: basic abstraction of a chess board user interface plus a text-based implementation
- `controller`: a runner that takes input from the user and displays output in the view
