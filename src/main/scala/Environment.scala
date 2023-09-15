case class Environment( // Класс Environment представляет собой настройки окружения, в котором будет выполняться задача.
                        name: String, //обязательное поле, содержащее название окружения.
                        url: Option[String] = None, // опциональное поле, содержащее URL для доступа к окружению.
                        on_stop: Option[String] = None, //опциональное поле, содержащее список команд, которые будут выполнены при остановке окружения.
                        auto_stop_in: Option[String] = None,
                        deployment_tier: Option[String] = None
                      )
