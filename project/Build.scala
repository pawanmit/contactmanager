import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "contactmanager"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    javaJpa,
    "mysql" % "mysql-connector-java" % "5.1.18",
    "org.hibernate" % "hibernate-entitymanager" % "4.2.1.Final"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    //ebeanEnabled := false      
  )

}
