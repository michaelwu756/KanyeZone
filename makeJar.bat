javac *.java ui\*.java engine\*.java members\*.java
jar -cfm KanyeZone.jar MANIFEST.MF *.class ui\*.class engine\*.class members\*.class Audio\* Images\*
java -jar KanyeZone.jar