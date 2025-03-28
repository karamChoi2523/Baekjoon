-- 코드를 입력하세요
SELECT MCDP_CD AS '진료과 코드', COUNT(PT_NO) AS '5월예약건수'
FROM APPOINTMENT
WHERE YEAR(APNT_YMD)=2022 AND MONTH(APNT_YMD)=05
GROUP BY MCDP_CD
ORDER BY 2 ASC, 1 ASC;