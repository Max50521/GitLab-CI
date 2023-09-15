case class Needs(
                  job_name: Option[List[String]] = None,
                  artifacts: Option[Boolean] = None,
                  project: Option[String] = None,
                  pipeline: Option[String] = None,
                  optional: Option[Boolean] = None
                )
