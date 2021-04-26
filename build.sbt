name := "ExpenseManagement"

version := "0.1"

scalaVersion := "2.13.5"

val AkkaVersion = "2.6.6"
val AkkaHttpVersion = "10.2.0"
val circeVersion = "0.14.0-M1"

libraryDependencies ++= Seq(
 "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,

  //Circe
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic"  % circeVersion,
  "io.circe" %% "circe-parser"  % circeVersion,

  "de.heikoseeberger" %% "akka-http-circe"% "1.31.0",

//Sqlite
 "org.xerial" % "sqlite-jdbc" % "3.28.0",
 "io.getquill" %% "quill-jdbc" % "3.7.0"



  //"org.scalatest" %% "scalatest" % "3.0.5" % Test
  )
