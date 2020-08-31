# 查询课程编号为"0002"的总成绩

select sum(成绩) from score
where 课程号 = '0001';


# 查询选了课程的学生人数
select count(distinct 学号) from score;