name := "slick-joda-mapper"
organization := "com.github.tototoshi"
version := "2.4.0"
licenses += ("BSD Simplified", url("http://opensource.org/licenses/BSD-2-Clause"))

crossScalaVersions ++= Seq("2.11.8", "2.12.1")
scalaVersion := "2.12.1"

scalacOptions ++= Seq("-deprecation", "-language:_")

libraryDependencies ++= Seq(
  "joda-time"          %  "joda-time"       % "2.9.7"  % Provided,
  "org.joda"           %  "joda-convert"    % "1.8.1"  % Provided,
  //
  "com.h2database"     %  "h2"              % "[1.4,)" % Test,
  "org.scalatest"      %% "scalatest"       % "3.0.1"  % Test,
  "ch.qos.logback"     %  "logback-classic" % "1.2.1"  % Test
)

libraryDependencies ++= scalaVersion {
  case sv if sv.startsWith("2.12") => Seq(
    "com.typesafe.slick" %% "slick" % "3.2.0" % Provided
  )

  case sv if sv.startsWith("2.11") => Seq(
    "com.typesafe.slick" %% "slick" % "3.1.1" % Provided
  )
}.value

initialCommands += """
                     |import com.github.tototoshi.slick.JodaSupport._
                     |import org.joda.time._
                     |import java.sql._
                     |""".stripMargin

bintrayOrganization := Some("micronautics")
bintrayRepository := "slick"
