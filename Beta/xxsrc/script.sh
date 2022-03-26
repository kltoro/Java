find . -name "*.class" -type f -delete 
echo deleted all class files
javac Main.java
echo recompiled
cd /home/kltoro/Java/Projects/Projektmunka/quickdel/
java Quickdel /home/kltoro/Java/Projects/Projektmunka/Tesztmappa
echo deleted all .html files


