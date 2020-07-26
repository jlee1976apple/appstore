-- docker run -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d leejon_mysql

CREATE sfg_dev;
CREATE sfg_prod;

CREATE user 'sfg_dev_user'@'localhost' IDENTIFIED BY 'root';
CREATE user 'sfg_prod_user'@'localhost' IDENTIFIED BY 'root';

GRANT SELECT ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT INSERT ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT UPDATE ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT DELETE ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT SELECT ON sfg_prod.* to 'sfg_prod_user'@'localhost';
GRANT INSERT ON sfg_prod.* to 'sfg_prod_user'@'localhost';
GRANT UPDATE ON sfg_prod.* to 'sfg_prod_user'@'localhost';
GRANT DELETE ON sfg_prod.* to 'sfg_prod_user'@'localhost';