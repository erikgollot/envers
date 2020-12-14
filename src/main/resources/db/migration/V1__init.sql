create table department (id bigint not null auto_increment, name VARCHAR(50), enterprise_id bigint, primary key (id)) engine=InnoDB;
create table enterprise (id bigint not null auto_increment, name VARCHAR(50), siret VARCHAR(32), primary key (id)) engine=InnoDB;
alter table department add constraint entreprise_dep_fk foreign key (enterprise_id) references enterprise (id);


CREATE TABLE `revinfo` (
       `rev` int NOT NULL AUTO_INCREMENT,
       `revtstmp` bigint DEFAULT NULL,
       PRIMARY KEY (`rev`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `department_aud` (
      `id` bigint NOT NULL,
      `rev` int NOT NULL,
      `revtype` tinyint DEFAULT NULL,
      `name` varchar(50) DEFAULT NULL,
      `enterprise_id` bigint DEFAULT NULL,
      PRIMARY KEY (`id`,`rev`),
      KEY `FKdrxjxvx2qlyxtsq8teb2fgqy8` (`rev`),
      CONSTRAINT `FKdrxjxvx2qlyxtsq8teb2fgqy8` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `enterprise_aud` (
      `id` bigint NOT NULL,
      `rev` int NOT NULL,
      `revtype` tinyint DEFAULT NULL,
      `name` varchar(50) DEFAULT NULL,
      `siret` varchar(32) DEFAULT NULL,
      PRIMARY KEY (`id`,`rev`),
      KEY `FKg26lnr90b1w2m8gr2aj9wfkd9` (`rev`),
      CONSTRAINT `FKg26lnr90b1w2m8gr2aj9wfkd9` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
