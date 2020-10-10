# p175
select per.FirstName, per.LastName, addr.City, addr.State
from Person as per
    left join Address as addr on per.PersonId = addr.PersonId;

# ifNull 两个参数，假如第一个参数的查询结果为空，则返回第二个结果
# p176
select IFNULL((select distinct(Salary)
from Employee
order by Salary desc
limit 1, 1), null) as SecondHighestSalary;