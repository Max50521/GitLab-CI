import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto.deriveDecoder
import io.circe.syntax._
import io.circe.yaml.syntax._
import shapeless.HList.ListCompat.::

import java.io._
import scala.::

object Main extends App {


var artifacts = Artifacts(List("- binaries-", ".config"), Some("- binaries/**/*.o"), Some("3 weeks and 2 days"), None, None, Some(true), Some(false))
val trigger = Trigger(Some("my-group/my-project"), Some("path/to/child-pipeline.gitlab-ci.yml"), None, None)
val service = Service("my-postgres:11.7", List("always", "if-not-present"))
val except = Except(List("- master", "- tags"), None,None, None)
val only = Only(List(" - master"), None,None , None)
val needs = Needs(Some(List("mac:build")), Some(false), Some("namespace/group/project-name"), Some("other/project"), Some(false))
val inherit = Inherit(Some(true),Some(false))
val image = Image("sbtscala/scala-sbt:$SCALA_SBT_IMAGE_VERSION", Some(""), None)
val hooks = Hooks(None, Some("- echo 'hello job1 pre_get_sources_script'"))
val environment = Environment("production", Some("https://prod.example.com"), None, None, None)
val cache = Cache(List(Cache_key(Some(List("Gemfile.lock")))), List("binaries/*.apk"),None,None,None,None,None)
val rules = Rules(Some("$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME =~ /^feature/ && $CI_MERGE_REQUEST_TARGET_BRANCH_NAME != $CI_DEFAULT_BRANCH"), Some(Rules_changes(Some("-Dockerfile"),None)), None, Some(false), None, None)
val release = Release(Some("myTagName"), None, "MyName", None, None, None)
val include = Include("/templates/.gitlab-ci-template.yml", Some("my-group/my-project"), None, Some("Auto-DevOps.gitlab-ci.yml"), None)
val workflow = Workflow("Pipeline for branch: $CI_COMMIT_BRANCH", List(Rules(Some("$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME =~ /^feature/ && $CI_MERGE_REQUEST_TARGET_BRANCH_NAME != $CI_DEFAULT_BRANCH"), Some(Rules_changes(Some("-Dockerfile"),None)), None, Some(false), None, None)))
val default = Default(Some(List("-echo 'i am starting text'")))
val services = Services("ruby:2.6", Some("db-postgres"), Some("/usr/local/bin/db-postgres"), None, "myImage", None, None, None, None)
val job_1 = Job("scalafmt_branches",None,None,Some(true),None,None,None,None,None,None,None,None,None,Some(image),None,None,None,None,Some(except),None,None,None,None, List("- sbt -mem 2048 scalafmtCheckAll"),None, "compile",None,None,None,None,None)
val job_2 = Job("scalafmt_master", None,None,Some(true),None,None,None,None,None,None,None,None,None,Some(image),None,None,None,Some(only),None,None,None,None,None, List("- sbt -mem 2048 scalafmtCheckAll"),None, "build",None,None,None,None,None)

val gitLabCI_1 = GitLabCI(None, List("- compile","- build"), None, List(job_1,job_2),List(Variables("JAVA_VERSION", None, "17.0.5_8", None, None),Variables("SBT_VERSION", None, "1.8.2", None, None),Variables("SCALA_VERSION", None, "2.13.10", None, None),Variables("SCALA_SBT_IMAGE_VERSION", None, "eclipse-temurin-${JAVA_VERSION}_${SBT_VERSION}_${SCALA_VERSION}", None, None)),None)


implicit val artifactsDecoder: Decoder[Artifacts] = deriveDecoder[Artifacts]
implicit val gitLabCIDecoder: Decoder[GitLabCI] = deriveDecoder[GitLabCI]
implicit val jodDecoder: Decoder[Job] = deriveDecoder[Job]
implicit val triggerDecoder: Decoder[Trigger] = deriveDecoder[Trigger]
implicit val serviceDecoder: Decoder[Service] = deriveDecoder[Service]
implicit val exceptDecoder: Decoder[Except] = deriveDecoder[Except]
implicit val onlyDecoder: Decoder[Only] = deriveDecoder[Only]
implicit val needsDecoder: Decoder[Needs] = deriveDecoder[Needs]
implicit val inheritDecoder: Decoder[Inherit] = deriveDecoder[Inherit]
implicit val imageDecoder: Decoder[Image] = deriveDecoder[Image]
implicit val hooksDecoder: Decoder[Hooks] = deriveDecoder[Hooks]
implicit val environmentDecoder: Decoder[Environment] = deriveDecoder[Environment]
implicit val variablesDecoder: Decoder[Variables] = deriveDecoder[Variables]
implicit val cache_keyDecoder: Decoder[Cache_key] = deriveDecoder[Cache_key]
implicit val cacheDecoder: Decoder[Cache] = deriveDecoder[Cache]
implicit val rules_changesDecoder: Decoder[Rules_changes] = deriveDecoder[Rules_changes]
implicit val rulesDecoder: Decoder[Rules] = deriveDecoder[Rules]
implicit val releaseDecoder: Decoder[Release] = deriveDecoder[Release]
implicit val includeDecoder: Decoder[Include] = deriveDecoder[Include]
implicit val workflowDecoder: Decoder[Workflow] = deriveDecoder[Workflow]
implicit val defaultDecoder: Decoder[Default] = deriveDecoder[Default]
implicit val servicesDecoder: Decoder[Services] = deriveDecoder[Services]

//----------------------------------------------------------------------------------------------------------------------
//enum тут перечислить все типы
/*
def addToGitLabCI(x: Job, y: GitLabCI): GitLabCI = {
  val updatedJobs = x :: y.jobs
  y.copy(jobs = updatedJobs)
}
val y = gitLabCI_1
val newJob = Job("publish", None,None,Some(true),None,None,None,None,None,None,None,None,None,Some(image),None,None,None,Some(only),None,None,None,None,None, List("- sbt -mem 2048 scalafmtCheckAll"),None, "build",None,None,None,None,None)

val gitLabCI_2 = addToGitLabCI(newJob, y)
*/

def addElementToGitLabCI[T](x: T, gitLabCI: GitLabCI): GitLabCI = {   // функция добавляет Job или Variable
  x match {
    case v: Variables =>
      val updatedVariables = v :: gitLabCI.variables
      gitLabCI.copy(variables = updatedVariables)

    case j: Job =>
      val updatedJobs = j :: gitLabCI.jobs
      gitLabCI.copy(jobs = updatedJobs)
  }
}
// функция добавляет Job для app или для bib
val LibJob =  Job("publish", None,None,Some(true),None,None,None,None,None,None,None,None,None,Some(image),None,None,None,Some(only),None,None,None,None,None, List("- sbt -mem 2048 scalafmtCheckAll"),None, "build",None,None,None,None,None)
val AppJob =  Job("test", None,None,Some(true),None,None,None,None,None,None,None,None,None,Some(image),None,None,None,Some(only),None,None,None,None,None, List("- sbt -mem 2048 scalafmtCheckAll"),None, "build",None,None,None,None,None)
  def ConfigСhoiceGitLabCI(x: String, gitLabCI: GitLabCI): GitLabCI = {
  x match {

    case "Lib" =>
      val updatedJobs = LibJob :: gitLabCI.jobs
      gitLabCI.copy(jobs = updatedJobs)

    case "App" =>
      val updatedJobs = AppJob :: gitLabCI.jobs
      gitLabCI.copy(jobs = updatedJobs)

  }
}
val gitLabCI_2 = ConfigСhoiceGitLabCI("Lib", gitLabCI_1)

  // создаем JSON объект
val json = gitLabCI_2.asJson
val yaml = json.asYaml
// записываем его в файл
val newJob = Job("publish", None, None, Some(true), None, None, None, None, None, None, None, None, None, Some(image), None, None, None, Some(only), None, None, None, None, None, List("- sbt -mem 2048 scalafmtCheckAll"), None, "build", None, None, None, None, None)
val newVar = Variables("JAVA_VERSION", None, "10.3.4", None, None)
//val gitLabCI_2 = addElementToGitLabCI(newJob, y)
//val gitLabCI_2 = addElementToGitLabCI(newVar, gitLabCI_1)

//Запись в файл Json
val pw = new PrintWriter(new File("gitLabCI.json"))
pw.write(json.spaces2)
pw.close()

//Запись в файл YAML
val pw2 = new PrintWriter(new File("gitLabCI.yaml"))
pw2.write(yaml.spaces4)
pw2.close()

println(gitLabCI_2.asJson);
//println(yaml.spaces2)

}
//----------------------------------------------------------------------------------------------------------------------
/*
implicit val artifactsEncoder: Encoder[Artifacts] = artifacts => Json.obj(
    "path" -> artifacts.paths.asJson,
    "exclude" -> artifacts.exclude.asJson,
    "expire_in" -> artifacts.expire_in.asJson,
    "expose_as" -> artifacts.expose_as.asJson,
    "name" -> artifacts.name.asJson,
    "public" -> artifacts.public.asJson,
    "untracked" -> artifacts.untracked.asJson,
    "when" -> artifacts.when.asJson,
)
*/
/*
val a = Artifacts("//dddfdf")
val a2 = Cache("sdfsdf")
val a3 = Cache_key("key")
val a4 = Default("sdfsdf")
val a5 = Environment("sdfsdfs")
val a6 = Except("sdfsd")
val a7 = GitLabCI("addfd")
val a8 = Hooks("sd")
val a9 = Image("sd")
val a10 = Include("sdfsdf")
val a11 = Inherit("as")
val a12 = Job("ssdasdasd")
val a13 = Needs("asdasd")
val a14 = Only("sdfsdf")
val a15 = Release("ddddd")
val a16 = Rules("adsdfc")
val a17 = Rules_changes("dsdfsdf")
val a18 = Service("sdfsdfsd")
val a19 = Services("asdasd")
val a20 = Trigger("adasdsad")
val a21 = Variables("asdasdasd", "asdasdas")
val a22 = Workflow("asads")

val Json = GitLabCI.asJson.noSpaces
println(Json)
*/



