case class Trigger(
                    path: Option[String] = None,
                    include: Option[String] = None,
                    project: Option[String] = None,
                    strategy: Option[String] = None
                  )