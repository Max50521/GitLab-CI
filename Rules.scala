case class Rules(
                  if_r: Option[String] = None,
                  changes: Option[Rules_changes] = None,
                  exist: Option[List[String]] = None,
                  allow_failure: Option[Boolean] = None,
                  needs: Option[Needs] = None,
                  variables: Option[Variables] = None
                )