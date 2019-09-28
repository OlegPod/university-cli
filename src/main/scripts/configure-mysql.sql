## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Database
CREATE DATABASE university;

#Create database service account
CREATE USER 'university_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'university_user'@'%' IDENTIFIED BY 'pass';
#Database grants
GRANT SELECT ON university.* to 'university_user'@'localhost';
GRANT INSERT ON university.* to 'university_user'@'localhost';
GRANT DELETE ON university.* to 'university_user'@'localhost';
GRANT UPDATE ON university.* to 'university_user'@'localhost';
GRANT SELECT ON university.* to 'university_user'@'%';
GRANT INSERT ON university.* to 'university_user'@'%';
GRANT DELETE ON university.* to 'university_user'@'%';
GRANT UPDATE ON university.* to 'university_user'@'%';