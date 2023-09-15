case class Release(
                    tag_name: Option[String] = None,
                    tag_message: Option[String] = None,
                    name: String,
                    description: Option[String] = None,
                    ref: Option[String] = None,
                    released_at: Option[String] = None,
                  )