case class Default(
                    after_script: Option[List[String]] = None,
                    artifacts: Option[Artifacts] = None,
                    before_script: Option[List[String]] = None,
                    cache: Option[Cache] = None,
                    hooks: Option[Hooks] = None,
                    image: Option[Image] = None,
                    retry: Option[Int] = None,
                    services: Option[Services] = None,
                    tags: Option[List[String]] = None,
                    timeout: Option[String] = None
                  )