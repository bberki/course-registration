# Course Registration System (JAVACS)

This project is a simple course registration simulation written in Java. It provides a Swing based user interface with separate panels for **Student** and **Admin** roles.

## Project Structure

- `Course.java` – represents a course (`code`, `name`, `credit`, `open` state)
- `User.java` – abstract base class for users
- `Student.java` – command line student implementation (still available)
- `Admin.java` – command line admin implementation (still available)
- `LessonCart.java` – manages a student's cart of courses
- `CourseManager.java` – helper class for listing, adding and removing courses
- `RoleSelectionFrame.java` – initial window to choose Student or Admin mode
- `StudentPanel.java` – Swing panel for managing the student cart
- `AdminPanel.java` – Swing panel for course management
- `Main.java` – entry point that launches the GUI
- `courses.txt` – list of courses loaded on startup

## Features

### Student

- View all available courses
- Add open courses to the cart (max total 30 credits)
- Remove courses from the cart
- Save the cart **once** (no further changes allowed)

### Admin

- Add new courses (code, name, credit, open/closed)
- Remove existing courses
- List all courses

## Important Rules

- The same course cannot be added more than once
- Closed courses cannot be selected
- Selections exceeding 30 credits are blocked
- No changes to the cart after it is saved
- Administrators cannot add a course that already exists
- Attempts to remove a non-existent course result in an error

## `courses.txt` Support

Courses are automatically loaded from `courses.txt` when the application starts. The file must contain lines in the following format:

```
CODE;Name;Credit;open
```

Example:

```
CSE101;Introduction to Programming;6;true
MAT102;Linear Algebra;5;true
FIZ103;Physics I;5;false
```

## Running the Program

1. Place all `.java` files in the same directory.
2. Compile them:

```bash
javac *.java
```

3. Run the application:

```bash
java Main
```

A GUI window will open with role selection followed by the corresponding panel.

## Authors

- **Buğra Berk İnci**
