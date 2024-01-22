create table user_role(
id int not null primary key,
role_id bigint,
user_id bigint not null,
foreign key (role_id) references role(role_id),
foreign key (user_id) references sign_up(user_id)
)