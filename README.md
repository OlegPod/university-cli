# CLI Application for University, which Consists of Departments and Lectors
Java project with the console interface for university, which consists of departments and lectors

## Stack of technologies that are used in this application:
* Maven
* Hibernate
* Spring Data JPA
* MySQL database
* Spring Shell

## The Application implements such commands:

```
Who is head of department {department_name}
```

Answer: Head of {department_name} department is {head_of_department_name}

```
Show {department_name} statistic.
```

Answer: assistans - {assistams_count}
associate professors - {associate_professors_count}
professors - {professors_count}

```
Show the average salary for department {department_name}.
```

Answer: The average salary of {department_name} is {average_salary}

```
Show count of employee for {department_name}.
```

Answer: {employee_count}

```
Global search by {template}.   
```

Example Global search by van
Answer Ivan Petrenko, Petro Ivanov

Department names are injected in Bootstrap.java for {department_name}

Advertising, Biology, Psychology, Chemistry, Accounting

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Installing

To run this application, we need to setup MySQL database.

Use to run MySQL docker image, optional if you're not using a local MySQL database

```
docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql
```
**Connect to mysql and run as root user**

* Create Database
```
CREATE DATABASE university;
```

* Create database service account
```
CREATE USER 'university_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'university_user'@'%' IDENTIFIED BY 'pass';
```
* Database grants
```
GRANT SELECT ON university.* to 'university_user'@'localhost';
GRANT INSERT ON university.* to 'university_user'@'localhost';
GRANT DELETE ON university.* to 'university_user'@'localhost';
GRANT UPDATE ON university.* to 'university_user'@'localhost';
GRANT SELECT ON university.* to 'university_user'@'%';
GRANT INSERT ON university.* to 'university_user'@'%';
GRANT DELETE ON university.* to 'university_user'@'%';
GRANT UPDATE ON university.* to 'university_user'@'%';
```
* Initiating tables in **university** database

```
create table department (id bigint not null auto_increment, name varchar(255), head_id bigint, primary key (id)) engine=InnoDB;
create table department_lector (department_id bigint not null, lector_id bigint not null, primary key (department_id, lector_id)) engine=InnoDB;
create table lector (id bigint not null auto_increment, degree varchar(255), first_and_last_name varchar(255), salary double precision, primary key (id)) engine=InnoDB;
alter table department add constraint FKdb1vl8mut04igtg6992oob1ce foreign key (head_id) references lector (id);
alter table department_lector add constraint FKi5jwkssy8kawtqunhx7q3ui87 foreign key (lector_id) references lector (id);
alter table department_lector add constraint FK57g67o2p8vdphk23xbk7o5gy foreign key (department_id) references department (id);
```

After all that have been done, the application is ready to run
