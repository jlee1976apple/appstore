-- docker run -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d leejon_mysql

CREATE database sfg_dev;
CREATE database sfg_prod;

CREATE user 'sfg_dev_user'@'10.0.0.21' IDENTIFIED BY 'root';
CREATE user 'sfg_prod_user'@'10.0.0.21' IDENTIFIED BY 'root';

GRANT SELECT ON sfg_dev.* to 'sfg_dev_user'@'10.0.0.21';
GRANT INSERT ON sfg_dev.* to 'sfg_dev_user'@'10.0.0.21';
GRANT UPDATE ON sfg_dev.* to 'sfg_dev_user'@'10.0.0.21';
GRANT DELETE ON sfg_dev.* to 'sfg_dev_user'@'10.0.0.21';
GRANT SELECT ON sfg_prod.* to 'sfg_prod_user'@'10.0.0.21';
GRANT INSERT ON sfg_prod.* to 'sfg_prod_user'@'10.0.0.21';
GRANT UPDATE ON sfg_prod.* to 'sfg_prod_user'@'10.0.0.21';
GRANT DELETE ON sfg_prod.* to 'sfg_prod_user'@'10.0.0.21';