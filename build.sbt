name := """scala-rules"""

version := "0.1.0.2"

scalaVersion := "2.11.2"

resolvers += "SpringSource Milestone Repository" at "http://repo.springsource.org/milestone"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "com.google.guava" % "guava" % "18.0",
  "org.springframework.scala" % "spring-scala_2.10" % "1.0.0.RC1",
  "commons-lang" % "commons-lang" % "2.6",
  "org.codehaus.groovy" % "groovy" % "2.4.0",
  "org.scalatest" % "scalatest_2.11" % "3.0.0-SNAP4" % "test"
)