
case class GitLabCI(
                     /*default: Option[Default] = None,
                     stages: List[String],
                     workflow: Option[Workflow] = None,
                     jobs: List[Job],
                     variables: Option[List[Variables]] = None,
                     include: Option[Include] = None*/

                     default: Option[Default] = None,
                     stages: List[String],
                     workflow: Option[Workflow] = None,
                     jobs: List[Job],
                     variables: List[Variables],
                     include: Option[Include] = None
                   )

