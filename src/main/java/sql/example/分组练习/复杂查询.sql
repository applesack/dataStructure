# 查询所有课程成绩小于60分学生的学号、姓名
select `学号`, `姓名`
from student
where `学号` in (select `学号`
               from score
               where `成绩` < 60);

# 查询没有学全所有课的学生的学号、姓名
select `学号`, `姓名`
from student
where `学号` in
      (select `学号` from score
       group by `学号`
       having count(`课程号`) < (select count(`课程号`) from course));

# 查询只选修了两门课程的全部学生的学号和姓名
select `学号`, `姓名`
from student
where `学号` in
      (select `学号`
      from course
      group by `学号`
      having count(`课程号`) = 2);