DROP TABLE `book`


create table book (
id bigint PRIMARY KEY AUTO_INCREMENT,
author varchar(255),
coverurl varchar(255),
genre varchar(255),
isbn integer not null,
pages integer not null,
rating integer not null,
status varchar(255),
title varchar(255),
primary key (id)
);
