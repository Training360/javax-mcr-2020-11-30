create table salary (amount bigint);
DELIMITER $$
CREATE PROCEDURE GetSalarySum()
BEGIN
    SELECT
        SUM(amount)
    FROM
        salary;
END$$
DELIMITER ;