
case class Variables( //Класс Variable представляет собой переменную, которая может использоваться внутри задачи.
                      key: String, //обязательное поле, содержащее название переменной
                      description: Option[String] = None,
                      value: String, // обязательное поле, содержащее значение переменной.
                      options: Option[List[String]] = None,
                      expand: Option[Boolean] = None

)

/*val variables: Map[String, Map[String, String]] = Map(
  "DEPLOY_ENVIRONMENT" -> Map(
    "value" -> "staging",
    "description" -> "The deployment target. Change this variable to 'canary' or 'production' if needed."
  )*/

