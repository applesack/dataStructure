# 平均成绩大于60分学生的学号和品均成绩
select `学号`, avg(`成绩`)
from score
group by `学号`
having avg(`成绩`) > 60;

# 查询至少选修两门课程的学生学号
select 学号, count(`课程号`)
from score
group by `学号`
having count(`课程号`) >= 2;

# 查询同名同姓学生名单并统计同名人数
select `姓名`, count(学号)
from student
group by `姓名`
having count(`学号`) > 1;