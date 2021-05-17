### Project Overview
This repo provides a backtracking implementation of the popular N-Queens with an added contrains: no 3 queens should form a straight line at any angle. The implementation relies on a basic chess framework that provides appropriate abstration for solving chess problems. The framework could be easily extended to include other algorithms for the N-Queens problem or other chess problems.

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
The project uses the MVC design pattern so the it contains 3 main packages:
- `model`: basic abstraction of a chess board
- `view`: basic abstraction of a chess board user interface plus a text-based implementation
- `controlle`r: a runner that takes input from the user and displays output in the view
The project also contains a 4th package (`nqueens`) with an implementation of a special case of the N-Queens problem as described in the overview.
