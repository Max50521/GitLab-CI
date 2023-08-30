import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto.deriveDecoder
import io.circe.syntax._
import io.circe.yaml.syntax._
import java.io._

object Main extends App {


val artifacts = Artifacts(List("- binaries-",".config"),Some("- binaries/**/*.o"),Some("3 weeks and 2 days"), None,None,Some(true), Some(false))
val trigger = Trigger(Some("my-group/my-project"), Some("path/to/child-pipeline.gitlab-ci.yml"), None, None)
val service = Service("my-postgres:11.7", List("always", "if-not-present"))
val except = Except(List(" - branches"), Some(true),None, Some(List("-Dockerfile","- docker", "/scripts")))
val only = Only(List(" - main"), Some(false),Some(List(Variables("$RELEASE", None, "staging", None, None))) , Some(List("-Dockerfile")))
val needs = Needs(Some(List("mac:build")), Some(false), Some("namespace/group/project-name"), Some("other/project"), Some(false))
val inherit = Inherit(Some(true),Some(false))
val image = Image("myImage", Some(""), None)
val hooks = Hooks(None, Some("- echo 'hello job1 pre_get_sources_script'"))
val environment = Environment("production", Some("https://prod.example.com"), None, None, None)
val cache = Cache(List(Cache_key(Some(List("Gemfile.lock")))), List("binaries/*.apk"),None,None,None,None,None)
val rules = Rules(Some("$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME =~ /^feature/ && $CI_MERGE_REQUEST_TARGET_BRANCH_NAME != $CI_DEFAULT_BRANCH"), Some(Rules_changes(Some("-Dockerfile"),None)), None, Some(false), None, None)
val release = Release(Some("myTagName"), None, "MyName", None, None, None)
val include = Include("/templates/.gitlab-ci-template.yml", Some("my-group/my-project"), None, Some("Auto-DevOps.gitlab-ci.yml"), None)
val workflow = Workflow("Pipeline for branch: $CI_COMMIT_BRANCH", List(Rules(Some("$CI_MERGE_REQUEST_SOURCE_BRANCH_NAME =~ /^feature/ && $CI_MERGE_REQUEST_TARGET_BRANCH_NAME != $CI_DEFAULT_BRANCH"), Some(Rules_changes(Some("-Dockerfile"),None)), None, Some(false), None, None)))
val default = Default(Some(List("-echo 'i am starting text'")))
val services = Services("ruby:2.6", Some("db-postgres"), Some("/usr/local/bin/db-postgres"), None, "myImage", None, None, None, None)
val job = Job("Job1", Some(List("-echo 'Hi!'")),None,Some(true),Some(artifacts),Some(cache),None,Some(List("Example Co")),None,Some(environment),None,Some(hooks),Some(List("password")),Some(image),Some(inherit),Some(false),Some(needs),Some(only),Some(except),Some(4),None,Some(1),Some(rules), List("echo - 'Hello World'"),Some(List(service)), "build",None,Some("60 minutes"),Some(trigger),Some(Variables("VAR1", None, "22332", None, None)),None)
val gitLabCI = GitLabCI(Some(default), List("-build","-test", "deploy"), Some(workflow), List(job),Some(Variables("VAR2", None, "421", None, None)),Some(include))




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



// создаем JSON объект
val json = gitLabCI.asJson
val yaml = json.asYaml
// записываем его в файл



val pw = new PrintWriter(new File("gitLabCI.json"))
pw.write(json.spaces2)
pw.close()


val pw2 = new PrintWriter(new File("gitLabCI.yaml"))
pw2.write(yaml.spaces4)
pw2.close()

//println(gitLabCI.asJson);
//println(yaml.spaces2)

}
//----------------------------------------------------------------------------------------------------------------------
/*
implicit val artifactsEncoder: Encoder[Artifacts] = artifacts => Json.o bj(
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



