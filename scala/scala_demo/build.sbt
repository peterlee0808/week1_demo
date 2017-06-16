import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import ScalateKeys._
/*import sbtdocker.DockerKeys._*/

val ScalatraVersion = "2.5.1"

ScalatraPlugin.scalatraSettings

scalateSettings

organization := "com.example"

name := "scala_demo"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.2"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
  "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)

scalateTemplateConfig in Compile := {
  val base = (sourceDirectory in Compile).value
  Seq(
    TemplateConfig(
      base / "webapp" / "WEB-INF" / "templates",
      Seq.empty,  /* default imports should be added here */
      Seq(
        Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
      ),  /* add extra bindings here */
      Some("templates")
    )
  )
}

enablePlugins(JettyPlugin)
enablePlugins(DockerPlugin)


imageNames in docker := Seq(
  ImageName("dockyard.cloud.capitalone.com/week1demo/scala")
)
assemblyJarName in assembly := "scalaServlet.jar"
dockerfile in docker := {
  val artifact: File = assembly.value
  new sbtdocker.mutable.Dockerfile {
    from("instructure/scala-sbt:latest")

    val port = 8080
    expose(port)

    val workdir = "/app"
    workDir(workdir)

    add(artifact, workdir + "/scalaServlet.jar")
    entryPoint("java", "-cp", "/app/scalaServlet.jar",
      "com.app.MyScalatraServlet")
  }
}