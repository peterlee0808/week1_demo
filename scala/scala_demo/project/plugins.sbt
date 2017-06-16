resolvers ++= Seq( "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "JBoss" at "https://repository.jboss.org",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")
addSbtPlugin("com.waioeka.sbt" %% "cucumber-plugin" % "0.1.1")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.4.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.4")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.4")
addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.0")
addSbtPlugin("org.scalatra.scalate" % "sbt-scalate-precompiler" % "1.8.0.1")

addSbtPlugin("org.scalatra.sbt" % "scalatra-sbt" % "0.5.1")
