-- https://www.hackerrank.com/challenges/binary-search-tree-1
SELECT * FROM (
    SELECT N, 'Root' FROM BST WHERE P IS NULL
    UNION
    SELECT a.N, 'Leaf'
    FROM BST a
    LEFT JOIN BST b
    ON a.N = b.P
    WHERE b.P IS NULL
    UNION
    SELECT DISTINCT(a.P), 'Inner'
    FROM BST a
    INNER JOIN BST b
    ON a.P = b.N
    WHERE b.P IS NOT NULL
) t1
ORDER BY N