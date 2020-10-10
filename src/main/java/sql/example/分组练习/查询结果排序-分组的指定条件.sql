# 查询学生的总成绩并进行排名
select `学号`, sum(`成绩`) as `总成绩`
from score
group by `学号`
order by sum(`成绩`) desc;

# 查询平均成绩大于60分的学生和平均成绩
select `学号`, avg(`成绩`) as `平均成绩`
from score
group by `学号`
having `平均成绩` >= 60;
