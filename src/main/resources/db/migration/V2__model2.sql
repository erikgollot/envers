create table department2 (id bigint not null auto_increment, name VARCHAR(50), enterprise_id bigint, primary key (id)) engine=InnoDB;
create table enterprise2 (id bigint not null auto_increment, name VARCHAR(50), siret VARCHAR(32), primary key (id)) engine=InnoDB;
alter table department2 add constraint entreprise2_dep_fk foreign key (enterprise_id) references enterprise2 (id);

CREATE TABLE `department2_aud` (
          `id` bigint NOT NULL,
          `rev` int NOT NULL,
          `revtype` tinyint DEFAULT NULL,
          `name` varchar(50) DEFAULT NULL,
          `enterprise_id` bigint DEFAULT NULL,
          PRIMARY KEY (`id`,`rev`),
          KEY `dep2_rev` (`rev`),
          CONSTRAINT `dep2_rev` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
CREATE TABLE `enterprise2_aud` (
          `id` bigint NOT NULL,
          `rev` int NOT NULL,
          `revtype` tinyint DEFAULT NULL,
          `name` varchar(50) DEFAULT NULL,
          `siret` varchar(32) DEFAULT NULL,
          PRIMARY KEY (`id`,`rev`),
          KEY `ent2_rev` (`rev`),
          CONSTRAINT `ent2_rev` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;