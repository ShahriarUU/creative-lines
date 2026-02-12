create sequence user_sequence start with 1 increment by 1;

create table app_user
(
    id                  bigint not null primary key,
    first_name          varchar(255),
    last_name           varchar(255),
    email               varchar(255) constraint uk_app_user_email unique,
    password            varchar(255) not null,
    role                varchar(255),
    status              varchar(255),
    subscription_type   varchar(255),
    profile_image       varchar(255),
    phone               varchar(255),
    created_at          timestamp(6) with time zone,
    created_by          bigint constraint fk_app_user_created_by references app_user,
    updated_at          timestamp(6) with time zone,
    updated_by          bigint constraint fk_app_user_updated_by references app_user
);

--rollback alter table app_user drop constraint fk_app_user_updated_by;
--rollback alter table app_user drop constraint fk_app_user_created_by;
--rollback alter table app_user drop constraint uk_app_user_email;
--rollback drop table app_user;
--rollback drop sequence user_sequence;
