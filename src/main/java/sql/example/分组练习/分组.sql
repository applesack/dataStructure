# 查询每课成绩最高和最低的分
select `课程号`, max(`成绩`), min(`成绩`)
from score
group by `课程号`;

# 查询每门课被选修的学生数
select `课程号`, count(`学号`)
from score
group by `课程号`;

# 查询男女生人数
select `性别`, count(`学号`)
from student
group by `性别`;