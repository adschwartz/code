-- https://www.hackerrank.com/challenges/projects
SELECT t1.sd sd, min(t2.ed) ed
FROM (
        SELECT a.Start_Date sd
        FROM projects a
        LEFT JOIN projects b
        ON a.Start_Date = b.End_Date
        WHERE b.End_Date IS NULL
    ) t1,
    (
        SELECT a.End_date ed
        FROM projects a
        LEFT JOIN projects b
        ON a.End_Date = b.Start_Date
        WHERE b.Start_Date IS NULL
    ) t2
WHERE sd < ed
GROUP BY sd
ORDER BY DATEDIFF(min(t2.ed),t1.sd), sd