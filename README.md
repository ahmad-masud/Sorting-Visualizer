# Sorting-Algorithm-Visualizer
A Java Frame Application to visualize sorting algorithms.

This application implements java swing to draw out a visual of the process of loop sorting. There are interactive buttons to visualize different sorting algorithms and a slider to change the delay in between swaps. The height of each bar corresponds to its value and its x position corresponds to it's index in the array.

# Implemented Algorithms
- Insertion Sort
- Selection Sort
- Bubble Sort

# Insertion Sort
![InsertionSort](https://user-images.githubusercontent.com/96448477/209458879-c9d59038-6dc2-4cf1-b380-e59b9161fb7e.gif)

# Selection Sort
![SelectionSort](https://user-images.githubusercontent.com/96448477/209458885-ec15216c-4184-4a28-aac7-0670d7d679ce.gif)

# Bubble Sort
![BubbleSort](https://user-images.githubusercontent.com/96448477/209458891-b9441f5c-fb28-434f-a625-469d5e7d307b.gif)

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
