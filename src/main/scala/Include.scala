case class Include( // Класс Include представляет собой файл, который будет включен в текущий YAML-файл.
                    local: String, //обязательное поле, содержащее путь к локальному файлу.
                    project: Option[String] = None,
                    remote: Option[String] = None,
                    template: Option[String] = None,
                    file_path: Option[String] = None//поле, содержащее путь к файлу в репозитории.
                  )