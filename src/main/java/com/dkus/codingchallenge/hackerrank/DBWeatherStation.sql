-- https://www.hackerrank.com/challenges/weather-observation-station-19/problem
SELECT round(sqrt(pow(t.b - t.a, 2) + pow(t.d - t.c, 2)), 4)
FROM (
    SELECT
        MAX(LAT_N) b,
        MIN(LAT_N) a,
        MAX(LONG_W) d,
        MIN(LONG_W) c
    FROM STATION
) t