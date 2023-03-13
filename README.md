# Sorting-Algorithm-Visualizer
A Java Frame Application to visualize sorting algorithms.

This application implements java swing to draw out a visual of the process of loop sorting. There are interactive buttons to visualize different sorting algorithms and a slider to change the delay in between swaps. The height of each bar corresponds to its value and its x position corresponds to it's index in the array.

# Stack
- Java
- Netbeans

# Implemented Algorithms
- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort

# Bubble Sort
![BubbleSort]

# Selection Sort
![SelectionSort](https://user-images.githubusercontent.com/96448477/209897874-3c63209a-e17c-4dab-a050-a4c5797f610a.gif)

# Insertion Sort
![InsertionSort](https://user-images.githubusercontent.com/96448477/209897862-169cc23a-3352-4f0b-b5c5-205c23ab4a36.gif)

# Build Output Description
When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "SortingAlgorithmVisualizer.jar" 

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.

Notes:

* If two JAR files on the project classpath have the same name, only the first
JAR file is copied to the lib folder.
* Only JAR files are copied to the lib folder.
If the classpath contains other types of files or folders, these files (folders)
are not copied.
* If a library on the projects classpath also has a Class-Path element
specified in the manifest,the content of the Class-Path element has to be on
the projects runtime path.
* To set a main class in a standard Java project, right-click the project node
in the Projects window and choose Properties. Then click Run and enter the
class name in the Main Class field. Alternatively, you can manually type the
class name in the manifest Main-Class element.
