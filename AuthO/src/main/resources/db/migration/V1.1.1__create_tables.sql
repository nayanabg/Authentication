create table sign_up(
user_id bigint not null,
first_name varchar(30),
last_name varchar(30),
password varchar(200),
phone_no varchar(15),
city varchar(25),
primary key(user_id)
);

create table login(
login_id bigint not null primary key,
user_name varchar(50),
password varchar(200)
)
