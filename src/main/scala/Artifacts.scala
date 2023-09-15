case class Artifacts( //представляет собой настройки сохранения артефактов (результатов выполнения) задачи.
                      //paths: List[String], // бязательное поле, содержащее список путей к файлам, которые будут сохранены как артефакты.
                      //exclude: Option[List[String]] = None,
                      //expire_in: Option[String] = None, //опциональное поле, содержащее время хранения артефактов.
                      //expose_as: Option[String] = None,
                      //name: Option[String] = None, // опциональное поле, содержащее имя артефакта.
                      //public: Option[Boolean] = None,
                      //untracked: Option[Boolean] = None, // опциональное поле, указывающее, нужно ли сохранять неотслеживаемые файлы (не добавленные в репозиторий).
                      //when: Option[String] = None// опциональное поле, указывающее, при каких условиях артефакты будут сохранены.
                      paths: List[String], // бязательное поле, содержащее список путей к файлам, которые будут сохранены как артефакты.
                      exclude: Option[String] = None,
                      expire_in: Option[String] = None, //опциональное поле, содержащее время хранения артефактов.
                      expose_as: Option[String] = None,
                      name: Option[String] = None, // опциональное поле, содержащее имя артефакта.
                      public: Option[Boolean] = None,
                      untracked: Option[Boolean] = None, // опциональное поле, указывающее, нужно ли сохранять неотслеживаемые файлы (не добавленные в репозиторий).
                      when: Option[String] = None
                    )