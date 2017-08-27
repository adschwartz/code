-- Write a query to identify the type of node in a binary search tree:

SELECT ID, 'Root'
    FROM TREE
    WHERE P_ID IS NULL
UNION
    SELECT DISTINCT(P_ID), 'Inner'
    FROM TREE
    WHERE P_ID IS NOT NULL
UNION
    SELECT a.ID, 'Leaf'
    FROM TREE a
    LEFT JOIN TREE b
    ON a.ID=b.P_ID
    WHERE b.P_ID IS NULL


CREATE TABLE `TREE` (
  `ID` int(11) NOT NULL,
  `P_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `TREE` (`ID`, `P_ID`) VALUES
(1, 2),
(3, 2),
(5, 6),
(7, 6),
(2, 4),
(6, 4),
(4, 15),
(8, 9),
(10, 9),
(12, 13),
(14, 13),
(9, 11),
(13, 11),
(11, 15),
(15, NULL);
