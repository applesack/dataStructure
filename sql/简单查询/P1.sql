# 查找姓猴的学生

SELECT * FROM student
WHERE `姓名` LIKE "猴%";

# 查询姓名中最后一个字是“猴”的学生名单

SELECT * FROM student
WHERE `姓名` LIKE "%猴";

# 查询姓名中带“猴”的学生名单

SELECT * FROM student
WHERE `姓名` LIKE "%猴%";


