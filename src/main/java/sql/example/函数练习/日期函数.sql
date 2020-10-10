# 查找1990年出生的学生名单
# 学生表中出生日期列的类型是datetime
select `姓名`, `出生日期`
from student
where year(`出生日期`) = 1990;

# 查询各学生的年龄(精确到月份)
select `学号`, timestampdiff(month , `出生日期`, now())/12
from student;

# 查询本月过生日的学生
select *
from student
where month(`出生日期`) = month(now());

