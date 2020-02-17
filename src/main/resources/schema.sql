create schema if not exists blog;

create table if not exists blog.posts
(
    id            number        auto_increment,
    title         varchar2(255)  not null,
    content       text          not null,
    creation_time timestamp     default systimestamp,
    primary key (id)
);

create table if not exists blog.comments
(
    id            number        auto_increment,
    title         varchar2(255)  not null,
    content       text          not null,
    approved      boolean       default false,
    creation_time timestamp     default systimestamp,
    post_id       number        not null references blog.posts,
    primary key (id)
);