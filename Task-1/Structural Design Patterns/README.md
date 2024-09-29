# Structural Design Patterns

## Overview

Structural design patterns deal with object composition, focusing on how classes and objects can be combined to form larger structures while keeping the system efficient and manageable. These patterns simplify relationships between objects.

### Patterns Implemented

1. **Adapter Pattern**:

   - Allows incompatible interfaces to work together by converting one interface into another.
   - Use Case: Integrating an external system or library that doesn’t match your current system’s interface.

2. **Facade Pattern**:

   - Provides a simplified interface to a complex subsystem, making it easier for clients to interact with.
   - Use Case: Interfacing with a multimedia system where only key functions are needed from a complex set of operations.

### How to Test

1. Clone the repository or download the Adapter and Facade pattern implementations.
2. Ensure that the code is properly organized into separate classes and files.
3. Compile and run the `AdapterPatternDemo` or `FacadePatternDemo` class to validate the implementations.
4. Verify the outputs to ensure the Adapter is correctly converting between interfaces or that the Facade provides a simplified access to a complex subsystem.

### Example

Run the following in your terminal or IDE:

```bash
javac AdapterPatternDemo.java
java AdapterPatternDemo

javac FacadePatternDemo.java
java FacadePatternDemo

