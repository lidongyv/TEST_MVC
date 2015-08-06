drop table if exists USER_INFOR_TAB, category_book_t,INFORMATION_TAB;

create table USER_INFOR_TAB(
	id int primary key auto_increment,
	login_id varchar(8) ,
	login_pwd varchar(6),
	user_name varchar(18),
	user_sex varchar(10),
	user_location varchar(20),
	user_phone varchar(12),
	user_email varchar(25),
	user_right varchar(1)
) ENGINE=InnoDB;

insert into USER_INFOR_TAB values('1','Kevin','123456','xiaodong','male','Qingdao','13708983877','xcdxdd@gmail.com','1');


create table category_book_t(catid varchar(30) not null primary key,
					  		 name varchar(80),
					  		 descn varchar(255)) ENGINE=InnoDB;
					  		 
insert into category_book_t values('Computer','Dell','From Dell Computer Co.Ltd');


create table INFORMATION_TAB(
	productid varchar(10),
	categoryid varchar(30),
	name varchar(80),
	publisher varchar(50),
	price float,
	description varchar(255)
) ENGINE=InnoDB;

insert into INFORMATION_TAB values('isbn-001','Computer','Java','Youdian','51.90','A Good Book.');

