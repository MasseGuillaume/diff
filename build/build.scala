import cbt._
import java.net._
import java.io.File
import scala.collection.immutable.Seq

class Build(context: cbt.Context) extends cbt.PublishBuild(context){
  override def defaultScalaVersion = "2.11.8"

  override def defaultVersion = "1.0"
  override def artifactId = "diff"
  override def groupId = "ai.x"

  override def runClass: String = "ai.x.diff.Test"

  override def dependencies = super.dependencies :+
    MavenResolver(
      context.cbtHasChanged,context.paths.mavenCache,MavenResolver.central
    ).resolve(
      "com.chuusai" %% "shapeless" % "2.2.0",
      "org.cvogt" %% "scala-extensions" % "0.4.1"
    )
  override def scalacOptions = Seq( "-language:experimental.macros" )

  override def url = new URL("http://github.com/xdotai/diff")
  override def licenses = Seq( License("Two-clause BSD-style license", new URL("http://github.com/xdotai/diff/blob/master/LICENSE.txt")) )
  override def developers = Seq( Developer("cvogt", "Jan Christopher Vogt", "-5", new URL("https://github.com/cvogt/")) )
  override def scmUrl = "git@github.com:xdotai/diff.git"
  override def scmConnection = "scm:git:git@github.com:xdotai/diff.git"
  override def description ="diff tool for Scala data structures (nested case classes etc)"
  override def pomExtra =
    <inceptionYear>2016</inceptionYear>
    <organization>
        <name>x.ai</name>
        <url>http://x.ai</url>
    </organization>
}
