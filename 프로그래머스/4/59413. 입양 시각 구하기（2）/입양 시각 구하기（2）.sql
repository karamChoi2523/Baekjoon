-- 코드를 입력하세요
WITH RECURSIVE TIME AS(
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1
    FROM TIME
    WHERE HOUR<23
)

SELECT TIME.HOUR AS HOUR, IFNULL(COUNT(A.ANIMAL_ID), 0) AS COUNT
FROM TIME LEFT JOIN ANIMAL_OUTS A ON TIME.HOUR = HOUR(A.DATETIME)
GROUP BY TIME.HOUR
ORDER BY TIME.HOUR ASC