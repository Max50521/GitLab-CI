case class Job( // представляет собой задачу пайплайна
                name: String, // обязательное поле, содержащее название задачи
                before_script: Option[List[String]] = None, // опциональное поле, содержащее список команд, которые будут выполнены перед выполнением каждой задачи в пайплайне.
                after_script: Option[List[String]]  = None, // опциональное поле, содержащее список команд, которые будут выполнены после выполнения каждой задачи в пайплайне.
                allow_failure: Option[Boolean]  = None, //опциональное поле, указывающее, может ли задача завершиться неудачно без остановки пайплайна.
                artifacts: Option[Artifacts] = None, //опциональное поле, содержащее настройки сохранения артефактов (результатов выполнения) задачи
                cache: Option[Cache] = None, // опциональное поле, содержащее настройки кэширования результатов выполнения задачи.
                coverage: Option[List[String]] = None,
                dast_configuration: Option[List[String]] = None,
                dependencies: Option[List[String]] = None,
                environment: Option[Environment] = None, // опциональное поле, содержащее настройки окружения, в котором будет выполняться задача.
                extends_1: Option[List[String]] = None,
                hooks: Option[Hooks] = None,
                id_tokSens: Option[List[String]] = None,
                image: Option[Image] = None, // опциональное поле, содержащее название Docker-образа, который будет использоваться для запуска задачи
                inherit: Option[Inherit] = None,
                interruptible: Option[Boolean] = None,
                needs: Option[Needs] = None,
                only: Option[Only] = None, //опциональное поле, содержащее условия, при которых задача будет выполнена.
                except: Option[Except] = None, // опциональное поле, содержащее условия, при которых задача не будет выполнена.
                parallel: Option[Int] = None,
                release: Option[Release] = None,
                retry: Option[Int] = None,
                rules: Option[Rules] = None,
                script: List[String], // обязательное поле, содержащее список команд, которые будут выполнены в рамках задачи
                service: Option[List[Service]] = None, //опциональное поле, содержащее список сервисов, которые будут запущены вместе с задачей.
                stage: String, // обязательное поле, содержащее название стадии, на которой будет выполнена задача.
                tags: Option[List[String]] = None,
                timeout: Option[String] = None,
                trigger: Option[Trigger] = None,
                variables: Option[Variables] = None, // опциональное поле, содержащее переменные, которые могут использоваться внутри задачи.
                when: Option[String] = None //опциональное поле, указывающее, при каких условиях задача будет выполнена.
              )
