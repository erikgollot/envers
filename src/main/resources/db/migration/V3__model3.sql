create table department3 (id bigint not null auto_increment, name VARCHAR(50), enterprise_id bigint, primary key (id)) engine=InnoDB;
create table enterprise3 (id bigint not null auto_increment, name VARCHAR(50), siret VARCHAR(32), primary key (id)) engine=InnoDB;
alter table department3 add constraint entreprise3_dep_fk foreign key (enterprise_id) references enterprise3 (id);

CREATE TABLE `department3_aud` (
          `id` bigint NOT NULL,
          `rev` int NOT NULL,
          `revtype` tinyint DEFAULT NULL,
          `name` varchar(50) DEFAULT NULL,
          `enterprise_id` bigint DEFAULT NULL,
          PRIMARY KEY (`id`,`rev`),
          KEY `dep3_rev` (`rev`),
          CONSTRAINT `dep3_rev` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
CREATE TABLE `enterprise3_aud` (
          `id` bigint NOT NULL,
          `rev` int NOT NULL,
          `revtype` tinyint DEFAULT NULL,
          `name` varchar(50) DEFAULT NULL,
          `siret` varchar(32) DEFAULT NULL,
          PRIMARY KEY (`id`,`rev`),
          KEY `ent3_rev` (`rev`),
          CONSTRAINT `ent3_rev` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;