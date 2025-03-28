SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO AS FI JOIN FISH_NAME_INFO AS FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE LENGTH = (SELECT MAX(LENGTH)
                FROM FISH_INFO
                WHERE FISH_TYPE = FI.FISH_TYPE)