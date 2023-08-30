case class Image(
                  name: String,
                  entrypoint: Option[String] = None,
                  pull_policy: Option[String] = None
                )