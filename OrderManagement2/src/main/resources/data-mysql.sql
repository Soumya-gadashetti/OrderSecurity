create database om;
use om;
insert into orders values(1,"1997-08-18",800.00);
insert into orders values(2,"1998-09-18",400.00);
insert into orders values(3,"1997-01-18",300.00);
insert into orders values(4,"1997-02-18",200.00);
insert into orders values(5,"1997-03-18",100.00);

insert into orderitem values(1,800.00,8,1,1);
insert into orderitem values(2,400.00,4,1,2);
insert into orderitem values(1,800.00,8,2,3);
insert into orderitem values(1,800.00,8,3,4);


