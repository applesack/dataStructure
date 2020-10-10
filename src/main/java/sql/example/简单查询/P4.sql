# 查询平均成绩大于60分的学生学号和平均成绩
select 学号, avg(成绩) as 平均成绩
from score
group by 学号
having 平均成绩 > 60;

# 查询至少选修2门课程的学生学号
select 学号, count(课程号) as 选修课程数目
from score
group by 学号
having 选修课程数目 > 2;

# 查询同名同姓学生名单并统计同名人数
select 姓名, count(学号) as 同名人数
from student
group by 姓名
having 同名人数 > 1;

