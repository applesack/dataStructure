# 查询所有学生的学号、姓名、选课数、总成绩
select student.`学号`, student.`姓名`, count(s.课程号), sum(s.成绩)
from student
    left join score s on student.学号 = s.学号
group by `学号`;

# 查询平均成绩大于85的所有学生的学号、姓名和平均成绩
select stu.学号, stu.姓名, avg(sco.成绩)
from student as stu
    left join score as sco on stu.学号 = sco.学号
group by stu.学号;

# 查询学生的选课情况：学号，姓名，课程号，课程名称
select stu.学号, stu.姓名, cour.课程号, cour.课程名称
from student as stu
    inner join score as sco on sco.学号 = stu.学号
    inner join course as cour on cour.课程号 = sco.课程号;

