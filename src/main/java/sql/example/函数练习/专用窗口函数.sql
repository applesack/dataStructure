select 学号 ,avg(成绩),
       row_number () over( order by avg(成绩) desc)
from score
group by 学号  ;