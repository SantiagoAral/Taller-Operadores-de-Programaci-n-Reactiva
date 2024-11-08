# Taller sobre Operadores de Programación Reactiva

Nombre:Santiago Andres Araque

Operadores Utilizados: Map, Filter, FlapMap, Merge y Zip

Ejecucion: mvn compile
           mvn exec:java/mvn exec:java -Dexec.mainClass="com.example.ReactiveExamples"


Resultado Codigo: 
```
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.example:reactive-operators >-------------------
[INFO] Building reactive-operators 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.0.0:java (default-cli) @ reactive-operators ---
Map Result: Alice passed: true
Map Result: Bob passed: true
Map Result: Charlie passed: false
Map Result: Diana passed: true
Map Result: Eve passed: true
Filter Result: Student{name='Alice', subject='Math', grade=85.5}
Filter Result: Student{name='Eve', subject='Math', grade=91.0}
FlatMap Result: Alice got a grade of 85.5 in Math
FlatMap Result: Bob got a grade of 92.0 in Science
FlatMap Result: Charlie got a grade of 76.5 in Math
FlatMap Result: Diana got a grade of 88.0 in History
FlatMap Result: Eve got a grade of 91.0 in Math
Merge Result: Alice
Merge Result: Bob
Merge Result: Charlie
Merge Result: Diana
Merge Result: Eve
Merge Result: Math
Merge Result: Science
Merge Result: Math
Merge Result: History
Merge Result: Math
Zip Result: Alice - Grade: 85.5
Zip Result: Bob - Grade: 92.0
Zip Result: Charlie - Grade: 76.5
Zip Result: Diana - Grade: 88.0
Zip Result: Eve - Grade: 91.0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
------------------------
[INFO] Total time:  0.983 s
[INFO] Finished at: 2024-11-08T16:27:56-05:00
[INFO] ------------------------------------------------------------------------
