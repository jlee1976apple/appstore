-- docker run -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d leejon_mysql

CREATE DATABASE appstore_dev;
CREATE DATABASE appstore_test;
CREATE DATABASE appstore_prod;

CREATE USER 'appstore_dev_user' IDENTIFIED BY 'appstore$1';
CREATE USER 'appstore_test_user' IDENTIFIED BY 'appstore$1';
CREATE USER 'appstore_prod_user' IDENTIFIED BY 'appstore$1';

GRANT SELECT ON appstore_dev.* TO 'appstore_dev_user';
GRANT INSERT ON appstore_dev.* TO 'appstore_dev_user';
GRANT UPDATE ON appstore_dev.* TO 'appstore_dev_user';
GRANT DELETE ON appstore_dev.* TO 'appstore_dev_user';

GRANT SELECT ON appstore_test.* TO 'appstore_test_user';
GRANT INSERT ON appstore_test.* TO 'appstore_test_user';
GRANT UPDATE ON appstore_test.* TO 'appstore_test_user';
GRANT DELETE ON appstore_test.* TO 'appstore_test_user';

GRANT SELECT ON appstore_prod.* TO 'appstore_prod_user';
GRANT INSERT ON appstore_prod.* TO 'appstore_prod_user';
GRANT UPDATE ON appstore_prod.* TO 'appstore_prod_user';
GRANT DELETE ON appstore_prod.* TO 'appstore_prod_user';