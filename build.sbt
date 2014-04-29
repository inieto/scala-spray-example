name := "spray-example"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.2",
  "io.spray" % "spray-can" % "1.3.1",
  "io.spray" % "spray-client" % "1.3.1",
  "io.spray" % "spray-http" % "1.3.1",
  "io.spray" % "spray-httpx" % "1.3.1",
  "io.spray" % "spray-routing" % "1.3.1",
  "io.spray" %% "spray-json" % "1.2.6",
  "io.spray" % "spray-testkit" % "1.3.1" % "test",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.2" % "test"
)

