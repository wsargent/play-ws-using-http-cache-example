name := """play-ws-using-http-cache-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.5"

libraryDependencies += ehcache
libraryDependencies += guice
libraryDependencies += ws

// Use caffeine with jcache implementation and "play-ws-cache" in the application.conf file...
libraryDependencies += "com.github.ben-manes.caffeine" % "jcache" % "2.5.0"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0-M3" % Test
