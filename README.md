# Java and JavaFX Project Collection

A selection of desktop games, interactive canvas applications and console utilities developed by Alice German.

The collection demonstrates object-oriented programming, Java collections, event-driven interfaces, FXML, canvas rendering, timed animation and thread synchronization.

## Highlights

- **BullsEye:** separates number generation and scoring from its JavaFX controller; validates guesses and maintains a history.
- **Target Click Game:** uses timed target creation and removal, coordinate-based hit detection and score calculation.
- **Bank Account Model:** uses an abstract account class, inheritance, polymorphism and custom exceptions.
- **Resource Pool Demo:** coordinates ten workers with three reusable resources using synchronized methods, wait and notifyAll.

## Projects

| Project | Interface | Features |
| --- | --- | --- |
| [bullseye-game](bullseye-game/) | JavaFX | Four-digit guessing game with validation, bulls-and-hits scoring and guess history. |
| [target-click-game](target-click-game/) | JavaFX | Timed target-click game using Timeline and PauseTransition, hit detection and score calculation. |
| [shape-drawing-board](shape-drawing-board/) | JavaFX | Canvas drawing tool with selectable lines and rectangles, dimensions and a clear button. |
| [canvas-message-board](canvas-message-board/) | JavaFX | Interactive canvas with text-input dialogs and replacement of nearby messages. |
| [animated-shapes](animated-shapes/) | JavaFX | Click-to-create circles or squares that grow and change color over time. |
| [bank-account-model](bank-account-model/) | Console Java | Account hierarchy with deposits, withdrawals, monthly fees, interest and custom balance exceptions. |
| [polynomial-calculator](polynomial-calculator/) | Console Java | Console calculator for polynomial addition, subtraction, derivatives and equality. |
| [resource-pool-demo](resource-pool-demo/) | Console Java | Synchronized resource pool shared by ten worker threads, using wait, notifyAll and join. |

## Requirements

- JDK 17 (a full JDK, not only a JRE).
- Apache Maven 3.9 or newer, available as `mvn` in your terminal.
- Internet access for the first build so Maven can fetch dependencies.
- A desktop display for the JavaFX applications.

JavaFX dependencies are declared in Maven; a separate JavaFX SDK or machine-specific Eclipse settings are not needed.

## Build

Run from the directory containing the top-level `pom.xml`:

```sh
mvn clean verify
```

Each project builds independently. The parent POM supplies common Java and dependency settings.

## Run

Run one project at a time from the repository root:

```sh
mvn -f bullseye-game/pom.xml javafx:run
mvn -f target-click-game/pom.xml javafx:run
mvn -f shape-drawing-board/pom.xml javafx:run
mvn -f canvas-message-board/pom.xml javafx:run
mvn -f animated-shapes/pom.xml javafx:run
mvn -f bank-account-model/pom.xml compile exec:java
mvn -f polynomial-calculator/pom.xml compile exec:java
mvn -f resource-pool-demo/pom.xml compile exec:java
```

## Controls

| Application | How to use it |
| --- | --- |
| BullsEye | Enter four different digits, with a nonzero first digit, then click Guess. Bulls match position; hits match a digit in another position. The victory dialog lets you restart or exit. |
| Target Click Game | Click Start, then click the small squares before they disappear. Final score is twice the hits minus missed clicks. |
| Shape Drawing Board | Select Line or Rectangle, enter positive numeric dimensions, then click the canvas. Clear removes drawings. |
| Canvas Message Board | Click the canvas and enter text in the dialog. Clicking near an existing message removes it before prompting for a replacement. |
| Animated Shapes | Select Circle or Square and click the canvas to start a growing shape with changing colors. |
| Bank Account Model | Run the console demo to see deposits, withdrawals, monthly account management and equality examples. |
| Polynomial Calculator | Enter the number of terms, then each coefficient and integer exponent, for two polynomials. Use unique nonnegative exponents. |
| Resource Pool Demo | Run the console demo to see resource IDs and total use counts. Thread scheduling can change the output order. |

## Scope

These are focused demonstration applications. The banking model uses sample account data and double-based amounts; it is not a financial system. The drawing and polynomial tools expect valid numeric input. Polynomial terms should have unique exponents. The resource pool assumes every borrowed resource is returned exactly once; cancellation and interruption handling are areas for further improvement.

## Organization

Each folder contains standard Maven `src/main/java` and, where applicable, `src/main/resources` directories. Java classes use separate `com.alicegerman` packages. FXML controller references and resource paths match the renamed classes.

## References

- [OpenJFX setup and Maven guide](https://openjfx.io/openjfx-docs/)
- [Apache Maven](https://maven.apache.org/)

## Validation of this export

All eight projects compiled using Java 17; the three console demos ran successfully; all five FXML views loaded successfully in a headless JavaFX check. An end-to-end Maven build could not complete in the preparation environment because Maven Central hostname resolution was unavailable. Dependency resolution through Maven and full interactive gameplay still need checking on a desktop computer.
