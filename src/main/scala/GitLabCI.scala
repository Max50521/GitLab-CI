case class GitLabCI(
                     default: Option[Default] = None,
                     stages: List[String],
                     workflow: Option[Workflow] = None,
                     jobs: List[Job],
                     variables: Option[Variables] = None,
                     include: Option[Include] = None
                   )

//опциональное поле, содержащее переменные, которые могут использоваться в задачах пайплайна.
// опциональное поле, содержащее список файлов, которые будут включены в текущий YAML-файл.