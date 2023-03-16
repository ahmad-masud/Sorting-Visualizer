# Sorting-Visualizer
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
![BubbleSort](https://user-images.githubusercontent.com/96448477/225763993-f77f766b-5bb5-42d2-9a47-e6b813f77c02.gif)

# Selection Sort
![SelectionSort](https://user-images.githubusercontent.com/96448477/225764076-949c91e6-56ea-4332-bf1c-5cdaed82ca0d.gif)

# Insertion Sort
![InsertionSort](https://user-images.githubusercontent.com/96448477/225764105-3e81a4d2-1ede-4616-9e61-04b21659e68f.gif)

# Merge Sort
![MergeSort](https://user-images.githubusercontent.com/96448477/225764160-08a44a1b-53ce-4ce2-b07e-028b223639b4.gif)

# Quick Sort
![QuickSort](https://user-images.githubusercontent.com/96448477/225764172-ea097623-c109-41ae-a372-1495b9a58c1c.gif)

# Build Output Description
When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "SortingVisualizer.jar" 

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
