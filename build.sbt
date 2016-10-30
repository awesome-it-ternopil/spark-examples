
name := "spark-mllib-train"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "2.0.1"


val makeApp = taskKey[Unit]("RUN Spark App ...")

val PATH_TO_SPARK = "/Users/kisilnazar/Development/Tools/spark-2.0.0-bin-hadoop2.7/bin/spark-submit"
val RUNNABLE_APP = "wt.train.mllib.MLLIBExtractingFeatures"

makeApp := {
  print(s"Start make app")
  val packageFile =  (Keys.`package` in Compile).value
  println(s"[publicTask]" + packageFile)
  val runApp = Process(s"$PATH_TO_SPARK --class $RUNNABLE_APP --master local[4] $packageFile")
  runApp.lines.foreach(println)
}