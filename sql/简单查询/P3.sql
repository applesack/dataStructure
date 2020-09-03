# 查询各科成绩最高和最低分
select 课程号, max(成绩) as 最高分, min(成绩) as 最低分
from score
group by 课程号;

# 查询每门课程被选修的人数
select 课程号, count(distinct 学号) as 选修人数
from score
group by 课程号;

# 查询男女生人数
select 性别, count(学号) as 人数
from student
group by 性别;