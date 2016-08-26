name := """turtle-graphics"""

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.92-R10"

libraryDependencies += "com.lihaoyi" %% "utest" % "0.4.3" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

