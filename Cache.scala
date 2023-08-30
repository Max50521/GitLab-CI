case class Cache(  // редставляет собой настройки кэширования результатов выполнения задачи.
                   key:  List[Cache_key], // обязательное поле, содержащее уникальный ключ для кэша.
                   paths: List[String], // обязательное поле, содержащее список путей к файлам и директориям, которые будут кэшироваться.
                   untracked: Option[Boolean] = None,
                   unprotect: Option[Boolean] = None,
                   when: Option[String] = None,
                   policy: Option[String] = None, // опциональное поле, содержащее политику кэширования.
                   fallback_keys: Option[List[String]] = None
                )