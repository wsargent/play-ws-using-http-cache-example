name := """play-ws-using-http-cache-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += ws

// Use caffeine with jcache implementation and "play-ws-cache" in the application.conf file...
libraryDependencies += "com.github.ben-manes.caffeine" % "jcache" % "2.4.0"

// Specify this manually until it gets merged...
// https://mvnrepository.com/artifact/com.typesafe.play/play-ahc-ws-standalone_2.12
// https://app.updateimpact.com/treeof/com.typesafe.play/play-ahc-ws-standalone_2.12/1.0.0-M7
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws-standalone" % "1.0.0-M7"


libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0-M3" % Test
